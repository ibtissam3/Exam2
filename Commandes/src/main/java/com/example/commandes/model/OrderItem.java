package com.example.commandes.model;

import jakarta.persistence.*;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productId; // ID du produit
    private int quantity;     // Quantité commandée
    private double price;     // Prix unitaire

    @ManyToOne
    @JoinColumn(name = "order_id")
    private com.example.orderservice.entity.Order order;

    // Getters et Setters
}
