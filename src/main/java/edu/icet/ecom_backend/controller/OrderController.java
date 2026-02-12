package edu.icet.ecom_backend.controller;

import edu.icet.ecom_backend.model.Order;
import edu.icet.ecom_backend.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;


    @PostMapping("/place")
    public ResponseEntity<String> placeOrder(Principal principal) {
        orderService.placeOrder(principal.getName());
        return ResponseEntity.ok("Order placed successfully!");
    }


    @GetMapping
    public ResponseEntity<List<Order>> getUserOrders(Principal principal) {
        return ResponseEntity.ok(orderService.getUserOrders(principal.getName()));
    }
}
