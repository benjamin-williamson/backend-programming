package com.example.demo.services;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;
import com.example.demo.entities.Customer;
import com.example.demo.entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private final CustomerRepository customerRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        // 1. Retrieve the purchase info from DTO
        Cart cart = purchase.getCart();

        // 2. Generate Tracking Number
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        // 3. Populate cart with cartItems
        Set<CartItem> cartItems = purchase.getCartItems();
        if (cartItems != null) {
            cartItems.forEach(item -> cart.add(item));
        }

        // 4. Set Status to ORDERED
        cart.setStatus(StatusType.ordered);

        // 5. Populate customer with cart
        Customer customer = purchase.getCustomer();
        customer.add(cart);

        // 6. Save to database
        // We save the customer, and CascadeType.ALL saves the cart/items automatically
        customerRepository.save(customer);

        // 7. Return response
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        // Generate a random UUID (e.g. "52442725-855a-423a-833c-313316c11267")
        return UUID.randomUUID().toString();
    }
}