package cn.pet.lin.domain.order;

import cn.pet.lin.domain.pet.Pet;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lwt on 2016/3/4.
 * 购物车类
 */
public class Cart {
    Map<String, CartItem> cartItems = new HashMap<String, CartItem>();
    private int totalPrice;

    public void add(Pet pet, int num) {
        CartItem item = cartItems.get(pet.getCode());
        if (item == null) {
            item = new CartItem();
            item.setPet(pet);
            item.setQuantity(num);
            cartItems.put(pet.getCode(), item);
        } else {
            item.setQuantity(item.getQuantity() + num);
        }
    }

    public void changeNum(String code, int quantity) {
        CartItem item = cartItems.get(code);
        item.setQuantity(quantity);

    }

    public void remove(String code) {
        cartItems.remove(code);
    }

    public int getTotalPrice() {
        this.totalPrice = 0;
        for (Map.Entry<String, CartItem> entry : cartItems.entrySet()) {
            this.totalPrice += entry.getValue().getPet().getPrice() * entry.getValue().getQuantity();
        }
        return totalPrice;
    }


    public Map<String, CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Map<String, CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

}
