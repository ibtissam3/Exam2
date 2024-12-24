package com.example.commandes.model;

import com.example.commandes.model.OrderItem;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerId; // ID du client
    private String status;     // Statut de la commande (e.g., PENDING, COMPLETED)

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderItem> items;

    // Getters et Setters
}
