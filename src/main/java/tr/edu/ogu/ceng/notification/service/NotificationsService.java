package tr.edu.ogu.ceng.notification.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import tr.edu.ogu.ceng.notification.entity.Notifications;
import tr.edu.ogu.ceng.notification.repository.NotificationsRepo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class NotificationsService {

    private NotificationsRepo notificationsRepository;

    public List<Notifications> getAllNotifications() {
        return notificationsRepository.findAll();
    }

    public Notifications getNotificationById(Long id) {
        Optional<Notifications> notification = notificationsRepository.findById(id);
        return notification.orElseThrow(() -> new RuntimeException("Notification not found with id: " + id));
    }

    public Notifications createNotification(Notifications notification) {
        notification.setCreatedAt(LocalDateTime.now());
        return notificationsRepository.save(notification);
    }

    public Notifications updateNotification(Long id, Notifications notificationDetails) {

        Notifications notification = getNotificationById(id);

        notification.setCreatedAt(notificationDetails.getCreatedAt());
        notification.setMessage(notificationDetails.getMessage());
        notification.setStatus(notificationDetails.getStatus());
        notification.setSentAt(notificationDetails.getSentAt());

        return notificationsRepository.save(notification);
    }

    public void deleteNotification(Long id) {
        Notifications notification = getNotificationById(id);
        notificationsRepository.delete(notification);
    }
}
