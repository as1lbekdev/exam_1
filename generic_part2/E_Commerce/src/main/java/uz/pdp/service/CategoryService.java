package uz.pdp.service;

import uz.pdp.model.Category;
import uz.pdp.model.FileUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CategoryService {
    private static final String fileName = "categories.xml";
    private List<Category> categories;

    public CategoryService() {
        categories = new ArrayList<>();
        categories.add(new Category("Category",UUID.randomUUID()));
        try {
            categories = FileUtil.readFromXml(fileName, Category.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String addCategory(Category category, String toCategoryName) {
        Category toCategory = getByName(toCategoryName);
        if (toCategory != null) {
            category.setParentId(toCategory.getId());
            try {
                FileUtil.writeToXml(fileName, categories);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "Not found category";
    }

    public Category getByName(String name) {
        for (Category category : categories) {
            if (category.getName().equals(name)) {
                return category;
            }
        }
        return null;
    }

    public boolean tekId(UUID id){
        for (Category category : categories) {
            if(category.getId().equals(id)){
                return true;
            }
        }
        return false;
    }

    public List<Category> getChildCategoryById(UUID id) {
        List<Category> childCategory = new ArrayList<>();
        for (Category category : categories) {
            if (category.getParentId().equals(id)) {
                childCategory.add(category);
            }
        }
        return childCategory;
    }

    public void deleted(List<Category> deletedCategory) {
        for (Category c : deletedCategory) {
            for (Category category : categories) {
                if (category.getId().equals(c.getId())) {
                    List<Category> childCategory = getChildCategoryById(category.getId());
                    deleted(childCategory);
                    categories.remove(category);
                    break;
                }
            }
        }

    }
}
