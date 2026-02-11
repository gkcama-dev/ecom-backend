package edu.icet.ecom_backend.controller;

import edu.icet.ecom_backend.dto.CartRequest;
import edu.icet.ecom_backend.model.Cart;
import edu.icet.ecom_backend.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;


    @PostMapping("/add")
    public ResponseEntity<Cart> addToCart(@RequestBody CartRequest request, Principal principal) {

        return ResponseEntity.ok(
                cartService.addToCart(principal.getName(), request.getProductId(), request.getQuantity())
        );
    }


    @GetMapping
    public ResponseEntity<Cart> getCart(Principal principal) {
        return ResponseEntity.ok(cartService.getCart(principal.getName()));
    }
}
