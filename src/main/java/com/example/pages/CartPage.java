package com.example.pages;

import com.example.Cart;

public class CartPage {
    private Cart cart;

    public CartPage(Cart cart) {
        this.cart = cart;
    }

    public String viewCart() {
        return cart.displayCartContents();
    }

    public double getCartTotal() {
        return cart.calculateTotal();
    }
}
