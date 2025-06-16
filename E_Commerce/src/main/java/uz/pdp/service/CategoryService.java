package uz.pdp.service;

import lombok.SneakyThrows;
import uz.pdp.model.Category;
import uz.pdp.model.FileUtil;

import java.io.IOException;
import java.util.*;

public class CategoryService {
    private static final String fileName = "categories.json";
    private static final String fileXml = "categories.xml";
    private List<Category> categories;
    private List<Category> heads;

    public CategoryService() {
        categories = new ArrayList<>();
        try {
            categories = FileUtil.read(fileName, Category.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        heads = buildTree();
    }

    public List<Category> buildTree() {
        Map<UUID, Category> map = new HashMap<>();
        List<Category> roots = new ArrayList<>();

        for (Category category : categories) {
            map.put(category.getId(), category);
        }

        for (Category category : categories) {
            if (category.getParentId() == null) {
                roots.add(category);
            } else {
                Category parent = map.get(category.getParentId());
                parent.getChildCategories().add(category);
            }
        }
        return roots;
    }

    @SneakyThrows
    public void saveCategories() {
        FileUtil.write(fileName, categories); // JSON uchun
        FileUtil.writeToXmlForCategory(fileXml, heads);
    }

    public String addCategory(Category category, UUID id) {
        Category toCategory = getCategoryById(id);
        if (toCategory != null) {
            category.setParentId(toCategory.getId());
            if (toCategory.getChildCategories() == null) {
                toCategory.setChildCategories(new ArrayList<>());
            }
            toCategory.getChildCategories().add(category);
            categories.add(category);
            saveCategories();
        }
        return "Not found category";
    }

    public String addCategory(Category category) {
        categories.add(category);
        heads.add(category);
        saveCategories();
        return "UnSuccessful";
    }

    private Category getByName(String name) {
        for (Category category : categories) {
            if (category.getName().equals(name)) {
                return category;
            }
        }
        return null;
    }

    public List<Category> getChildCategoryById(UUID id) {
        List<Category> childCategory = new ArrayList<>();
        for (Category category : categories) {
            if (category.getParentId() != null && category.getParentId().equals(id)) {
                childCategory.add(category);
            }
        }
        return childCategory;
    }

    private Category getParentByCategory(Category category) {
        return getCategoryById(category.getParentId());
    }

    public String deleted(UUID id) {
        Category currCategory = getCategoryById(id);
        if (currCategory != null) {
            Category parent = getParentByCategory(currCategory);
            if (parent != null) {
                parent.getChildCategories().remove(currCategory);
            }
            deletedChild(id);
            saveCategories();
        }
        return "UnSuccessful";
    }

    private void deletedChild(UUID id) {
        for (Category category : categories) {
            if (category.getParentId() != null && category.getParentId().equals(id)) {
                deletedChild(category.getId());
            }
        }
        categories.remove(getCategoryById(id));
    }

    public Category getCategoryById(UUID id) {
        for (Category category : categories) {
            if (category.getId().equals(id)) {
                return category;
            }
        }
        return null;
    }

    public List<Category> getALLCategories() {
        return categories;
    }
}