package tr.edu.ogu.ceng.notification.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tr.edu.ogu.ceng.notification.entity.Notifications;
import tr.edu.ogu.ceng.notification.service.NotificationsService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/notification")
public class NotificationController {

    private NotificationsService notificationService;

    @GetMapping
    public List<Notifications> getAllNotifications() {
        return notificationService.getAllNotifications();
    }

    @GetMapping("/{id}")
    public Notifications getNotificationById(@PathVariable Long id) {
        return notificationService.getNotificationById(id);
    }

    @PostMapping
    public Notifications createNotification(@RequestBody Notifications notification) {
        return notificationService.createNotification(notification);
    }

    @PutMapping("/{id}")
    public Notifications updateNotification(@PathVariable Long id, @RequestBody Notifications notificationDetails) {
        return notificationService.updateNotification(id, notificationDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteNotification(@PathVariable Long id) {
        notificationService.deleteNotification(id);
    }
}
