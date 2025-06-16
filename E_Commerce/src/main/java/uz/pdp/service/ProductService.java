package uz.pdp.service;

import lombok.SneakyThrows;
import uz.pdp.model.Category;
import uz.pdp.model.FileUtil;
import uz.pdp.model.Product;

import java.util.*;

public class ProductService {
    CategoryService categoryService = new CategoryService();

    private static final String fileName = "product.json";
    private List<Product> products;
    private Map<UUID,Product> productMap;

    @SneakyThrows
    public ProductService() {
        products = FileUtil.read(fileName, Product.class);
        productMap = new HashMap<>();

        for (Product p : products) {
            productMap.put(p.getId(),p);
        }
    }

    @SneakyThrows
    public void saveProducts(){
        FileUtil.write(fileName, products);
    }

    public  Product getProductById(UUID id){
        if (productMap.containsKey(id)){
            return productMap.get(id);
        }
        return  null;
    }

    public void addProduct(Product product, UUID categoryId) {
        Category category = categoryService.getCategoryById(categoryId);
        if (category != null && category.getChildCategories() == null) {
            product.setCategoryId(categoryId);
            products.add(product);
            productMap.put(product.getId(), product);
            saveProducts();
        }else {
            System.out.println(" Bunday category mavjud emas");
        }
    }

    public List<Product> getAllProducts(){
        return  products;
    }
    public String deletedProduct(UUID id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                products.remove(product);
                saveProducts();
                productMap.remove(product.getId());
                return "mahsulot o'chirildi";
            }
        }
        return "bu mahsulot topilmadi";
    }
}
