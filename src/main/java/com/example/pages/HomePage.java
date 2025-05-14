package com.example.pages;

import com.example.Cart;

public class HomePage {
    private Cart cart;

    public HomePage(Cart cart) {
        this.cart = cart;
    }

    public void addItemToCart(String itemName, double price) {
        cart.addItem(itemName, price);
    }

    public Cart getCart() {
        return cart;
    }
}
