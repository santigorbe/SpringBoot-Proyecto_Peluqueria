package org.example.peluqueria.product;

import com.alibou.ecommerce.category.Category;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Product {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    private double availableQuantity;
    private BigDecimal price; //Cuando se trabaja con precios, lo mejor es usar BigDecimal pq tiene mas metodos utiles
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
