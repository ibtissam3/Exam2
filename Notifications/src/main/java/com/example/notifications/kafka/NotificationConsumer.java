package com.example.notifications.kafka;


import com.example.notifications.model.Notification;
import com.example.notifications.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    @Autowired
    private NotificationRepository notificationRepository;

    @KafkaListener(topics = "orders-topic", groupId = "notification-group")
    public void consume(String message) {
        System.out.println("Message reçu depuis Kafka: " + message);

        // Parse the message (e.g., JSON string to object)
        String[] parts = message.split(","); // Exemple de parsing simplifié
        Long userId = Long.parseLong(parts[0]);
        Long orderId = Long.parseLong(parts[1]);

        // Créer une notification
        Notification notification = new Notification();
        notification.setUserId(userId);
        notification.setOrderId(orderId);
        notification.setMessage("Une nouvelle commande a été créée : " + orderId);

        // Sauvegarder dans la base de données
        notificationRepository.save(notification);

        System.out.println("Notification sauvegardée avec succès !");
    }
}
