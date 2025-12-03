package com.example.demo.services;

import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;
import com.example.demo.entities.Customer;
import jakarta.validation.constraints.NotNull; // Import required
import java.util.Set;

public class Purchase {

    @NotNull
    private Customer customer;

    @NotNull
    private Cart cart;

    @NotNull
    private Set<CartItem> cartItems;

    // Manual Getters/Setters (Keep these!)
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
    public Cart getCart() { return cart; }
    public void setCart(Cart cart) { this.cart = cart; }
    public Set<CartItem> getCartItems() { return cartItems; }
    public void setCartItems(Set<CartItem> cartItems) { this.cartItems = cartItems; }
}