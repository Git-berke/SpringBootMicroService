package tr.edu.ogu.ceng.notification.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tr.edu.ogu.ceng.notification.entity.NotificationSettings;
import tr.edu.ogu.ceng.notification.service.NotificationsSettingsService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/notification-settings")
public class NotificationSettingsController {

    private NotificationsSettingsService notificationSettingsService;

    @GetMapping
    public List<NotificationSettings> getAllNotificationSettings() {
        return notificationSettingsService.getAllNotificationSettings();
    }

    @GetMapping("/{id}")
    public NotificationSettings getNotificationSettingById(@PathVariable Long id) {
        return notificationSettingsService.getNotificationSettingById(id);
    }

    @PostMapping
    public NotificationSettings createNotificationSetting(@RequestBody NotificationSettings notificationSetting) {
        return notificationSettingsService.createNotificationSetting(notificationSetting);
    }

    @PutMapping("/{id}")
    public NotificationSettings updateNotificationSetting(@PathVariable Long id, @RequestBody NotificationSettings notificationSettingDetails) {
        return notificationSettingsService.updateNotificationSetting(id, notificationSettingDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteNotificationSetting(@PathVariable Long id) {
        notificationSettingsService.deleteNotificationSetting(id);
    }
}
