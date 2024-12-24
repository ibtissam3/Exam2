package com.example.commandes.service;

import com.example.commandes.dto.CommandeDTO;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class CommandesService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public CommandesService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public Commande creerCommande(CommandeDTO commandeDTO) {
        Commande commande = new Commande();
        commande.setUtilisateurId(commandeDTO.getUtilisateurId());
        commande.setProduits(commandeDTO.getProduits());
        commande.setTotal(commandeDTO.getTotal());

        // Simulation de sauvegarde dans la base de données
        System.out.println("Commande sauvegardée : " + commande);

        // Envoyer un message Kafka
        kafkaTemplate.send("commandes", "Nouvelle commande créée : " + commande);

        return commande;
    }
}