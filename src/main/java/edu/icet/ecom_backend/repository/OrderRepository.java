package edu.icet.ecom_backend.repository;

import edu.icet.ecom_backend.model.Order;
import edu.icet.ecom_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);
}