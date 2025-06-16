package uz.pdp.service;

import uz.pdp.model.Category;
import uz.pdp.model.FileUtil;
import uz.pdp.model.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ProductService {
    CategoryService categoryService = new CategoryService();

    private static final String fileName = "categories.json";
    private List<Product> producties;
    
    public ProductService() {
        producties = new ArrayList<>();
        try {
            producties = FileUtil.readFromXml(fileName, Product.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addProduct(Product product, UUID CategoryId) {
        boolean tek = categoryService.tekId(CategoryId);
        if (tek == true) {
            producties.add(product);
            try {
                FileUtil.writeToXml(fileName, producties);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println(" Bunday category mavjud emas");
        }
    }
}
