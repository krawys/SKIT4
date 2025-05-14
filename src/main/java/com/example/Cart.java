package com.example;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Item> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void addItem(String name, double price) {
        items.add(new Item(name, price));
    }

    public String displayCartContents() {
        StringBuilder contents = new StringBuilder("Cart contents:\n");
        for (Item item : items) {
            contents.append(item.getName()).append(" - $").append(item.getPrice()).append("\n");
        }
        return contents.toString();
    }

    public double calculateTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public List<Item> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty(); // assuming 'items' is your list of cart items
    }

}
