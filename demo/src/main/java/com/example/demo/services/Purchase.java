package com.example.demo.services;

import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;
import com.example.demo.entities.Customer;
import lombok.Data;
import java.util.Set;
import jakarta.validation.constraints.NotNull;

@Data
public class Purchase {
    @NotNull
    private Customer customer;
    @NotNull
    private Cart cart;
    @NotNull
    private Set<CartItem> cartItems;
}