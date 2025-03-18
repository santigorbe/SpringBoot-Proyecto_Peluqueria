package org.example.peluqueria.kafka.order;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        Customer customer,
        List<Product> products
) {
}
