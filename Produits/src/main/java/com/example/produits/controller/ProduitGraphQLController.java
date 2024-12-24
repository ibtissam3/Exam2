package com.example.produits.controller;

import com.example.produits.model.Produit;
import com.example.produits.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProduitGraphQLController {

    @Autowired
    private ProduitService produitService;

    // Requête pour obtenir tous les produits
    @QueryMapping
    public List<Produit> getProduits() {
        return produitService.getAllProduits();
    }

    // Requête pour obtenir un produit par ID
    @QueryMapping
    public Produit getProduit(@Argument Long id) {
        return produitService.getProduitById(id).orElseThrow(() -> new RuntimeException("Produit non trouvé"));
    }

    // Mutation pour créer un produit
    @MutationMapping
    public Produit createProduit(@Argument String nom, @Argument Double prix, @Argument Integer stock) {
        Produit produit = new Produit();
        produit.setNom(nom);
        produit.setPrix(prix);
        produit.setStock(stock);
        return produitService.createProduit(produit);
    }

    // Mutation pour mettre à jour un produit
    @MutationMapping
    public Produit updateProduit(@Argument Long id, @Argument String nom, @Argument Double prix, @Argument Integer stock) {
        Produit produitDetails = new Produit();
        produitDetails.setNom(nom);
        produitDetails.setPrix(prix);
        produitDetails.setStock(stock);
        return produitService.updateProduit(id, produitDetails);
    }

    // Mutation pour supprimer un produit
    @MutationMapping
    public String deleteProduit(@Argument Long id) {
        produitService.deleteProduit(id);
        return "Produit supprimé avec succès";
    }
}
