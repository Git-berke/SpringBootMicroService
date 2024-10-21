package tr.edu.ogu.ceng.notification.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tr.edu.ogu.ceng.notification.entity.NotificationTypes;
import tr.edu.ogu.ceng.notification.service.NotificationsTypesService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/notification-types")
public class NotificationTypesController {

    private NotificationsTypesService notificationTypesService;

    @GetMapping
    public List<NotificationTypes> getAllNotificationTypes() {
        return notificationTypesService.getAllNotificationTypes();
    }

    @GetMapping("/{id}")
    public NotificationTypes getNotificationTypeById(@PathVariable Long id) {
        return notificationTypesService.getNotificationTypeById(id);
    }

    @PostMapping
    public NotificationTypes createNotificationType(@RequestBody NotificationTypes notificationType) {
        return notificationTypesService.createNotificationType(notificationType);
    }

    @PutMapping("/{id}")
    public NotificationTypes updateNotificationType(@PathVariable Long id, @RequestBody NotificationTypes notificationTypeDetails) {
        return notificationTypesService.updateNotificationType(id, notificationTypeDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteNotificationType(@PathVariable Long id) {
        notificationTypesService.deleteNotificationType(id);
    }
}
