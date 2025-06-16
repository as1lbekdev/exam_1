package uz.pdp.service;

import lombok.SneakyThrows;
import uz.pdp.model.Cart;
import uz.pdp.model.FileUtil;

import java.util.*;

public class CartService {
    private final String fileName = "carts.json";
    private List<Cart> cartList;
    private Map<UUID, Cart> cartMap;
    private ProductService productService = new ProductService();

    @SneakyThrows
    public CartService() {
        cartList = FileUtil.read(fileName, Cart.class);
        cartMap = new HashMap<>();
        for (Cart cart : cartList) {
            cartMap.put(cart.getUserId(), cart);
        }
    }

    @SneakyThrows
    private void saveCarts() {
        FileUtil.write(fileName, cartList);
    }

    public Cart getCartByUserId(UUID userId) {
        if (cartMap.containsKey(userId)) {
            return cartMap.get(userId);
        }
        return null;
    }

    public List<Cart> getAllCarts() {
        return cartList;
    }

    public Cart createCart(UUID id){
        if(!cartMap.containsKey(id)){
            Cart newCart=new Cart();
            newCart.setUserId(id);
            cartMap.put(id,newCart);
            saveCarts();
            return newCart;
        }
        else{
            return null;
        }
    }

    public String addProductToCart(UUID productId, UUID userId, int quantity) {
        if (productService.getProductById(productId) != null) {
            Cart cart = cartMap.get(userId);
            if (cart == null) {
                cart = createCart(userId);
            }
            Integer count = cart.getProducts().get(productId);
            if (count != null) {
                cart.getProducts().put(productId, count + quantity);
                cartMap.put(cart.getId(), cart);
                saveCarts();
                return "Successful";
            }
            cart.getProducts().put(productId, quantity);
            cartMap.put(cart.getId(), cart);
            saveCarts();
            return "Successful";
        }
        return "not found product";
    }
}
