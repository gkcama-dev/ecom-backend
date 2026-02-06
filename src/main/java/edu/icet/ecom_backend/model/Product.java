package edu.icet.ecom_backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Product name is required")
    private String name;
    @Size(min = 10, message = "Description must be at least 10 characters")
    private String description;
    @NotNull(message = "Price is required")
    @Min(value = 0, message = "Price must be positive")
    private Double price;
    @Min(value = 0, message = "Stock cannot be negative")
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}