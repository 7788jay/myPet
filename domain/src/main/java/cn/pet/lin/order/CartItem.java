package cn.pet.lin.order;

import cn.pet.lin.pet.Pet;

/**
 * Created by lwt on 2016/3/4.
 * 购物车项
 */
public class CartItem {
    private Pet pet = new Pet();
    private int quantity;

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
