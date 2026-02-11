package edu.icet.ecom_backend.service;

import edu.icet.ecom_backend.model.Cart;
import edu.icet.ecom_backend.model.CartItem;
import edu.icet.ecom_backend.model.Product;
import edu.icet.ecom_backend.model.User;
import edu.icet.ecom_backend.repository.CartRepository;
import edu.icet.ecom_backend.repository.ProductRepository;
import edu.icet.ecom_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;


    public Cart addToCart(String username, Long productId, Integer quantity) {


        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));


        Cart cart = cartRepository.findByUser(user).orElse(
                Cart.builder()
                        .user(user)
                        .items(new ArrayList<>())
                        .total(0.0)
                        .build()
        );


        Optional<CartItem> existingItem = cart.getItems().stream()
                .filter(item -> item.getProduct().getId().equals(productId))
                .findFirst();

        if (existingItem.isPresent()) {

            CartItem item = existingItem.get();
            item.setQuantity(item.getQuantity() + quantity);
        } else {

            CartItem newItem = CartItem.builder()
                    .product(product)
                    .cart(cart)
                    .quantity(quantity)
                    .build();
            cart.getItems().add(newItem);
        }


        calculateTotal(cart);
        return cartRepository.save(cart);
    }


    public Cart getCart(String username) {
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new RuntimeException("User not found"));


        return cartRepository.findByUser(user).orElse(
                Cart.builder().user(user).items(new ArrayList<>()).total(0.0).build()
        );
    }


    private void calculateTotal(Cart cart) {
        double total = cart.getItems().stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();
        cart.setTotal(total);
    }
}
