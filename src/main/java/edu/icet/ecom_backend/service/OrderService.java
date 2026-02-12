package edu.icet.ecom_backend.service;

import edu.icet.ecom_backend.model.Cart;
import edu.icet.ecom_backend.model.Order;
import edu.icet.ecom_backend.model.OrderItem;
import edu.icet.ecom_backend.model.User;
import edu.icet.ecom_backend.repository.CartRepository;
import edu.icet.ecom_backend.repository.OrderRepository;
import edu.icet.ecom_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final UserRepository userRepository;


    public void placeOrder(String username) {


        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Cart cart = cartRepository.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        if (cart.getItems().isEmpty()) {
            throw new RuntimeException("Cart is empty! Cannot place order.");
        }


        Order order = Order.builder()
                .user(user)
                .orderDate(LocalDateTime.now())
                .status("PENDING")
                .total(cart.getTotal())
                .build();


        List<OrderItem> orderItems = cart.getItems().stream()
                .map(cartItem -> OrderItem.builder()
                        .product(cartItem.getProduct())
                        .quantity(cartItem.getQuantity())
                        .price(cartItem.getProduct().getPrice())
                        .order(order)
                        .build()
                ).toList();

        order.setItems(orderItems);


        orderRepository.save(order);


        cart.getItems().clear();
        cart.setTotal(0.0);
        cartRepository.save(cart);
    }


    public List<Order> getUserOrders(String username) {
        User user = userRepository.findByEmail(username).orElseThrow();
        return orderRepository.findByUser(user);
    }
}
