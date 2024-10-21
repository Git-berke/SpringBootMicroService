package tr.edu.ogu.ceng.notification.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import tr.edu.ogu.ceng.notification.entity.NotificationTypes;
import tr.edu.ogu.ceng.notification.repository.NotificationsTypesRepo;

import java.util.List;
import java.util.Optional;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class NotificationsTypesService {

    private NotificationsTypesRepo notificationTypesRepository;

    public List<NotificationTypes> getAllNotificationTypes() {
        return notificationTypesRepository.findAll();
    }

    public NotificationTypes getNotificationTypeById(Long id) {
        Optional<NotificationTypes> notificationType = notificationTypesRepository.findById(id);
        return notificationType.orElseThrow(() -> new RuntimeException("Notification type not found with id: " + id));
    }

    public NotificationTypes createNotificationType(NotificationTypes notificationType) {
        return notificationTypesRepository.save(notificationType);
    }

    public NotificationTypes updateNotificationType(Long id, NotificationTypes notificationTypeDetails) {
        NotificationTypes notificationType = getNotificationTypeById(id); // Get the existing notification type
        notificationType.setTypeName(notificationTypeDetails.getTypeName());
        return notificationTypesRepository.save(notificationType);
    }

    public void deleteNotificationType(Long id) {
        NotificationTypes notificationType = getNotificationTypeById(id); // Ensure notification type exists
        notificationTypesRepository.delete(notificationType);
    }
}
