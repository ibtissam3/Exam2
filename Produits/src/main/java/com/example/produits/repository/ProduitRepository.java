package com.example.produits.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.produits.model.Produit;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {
}
