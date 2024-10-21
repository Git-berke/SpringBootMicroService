package tr.edu.ogu.ceng.notification.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import tr.edu.ogu.ceng.notification.entity.NotificationSettings;
import tr.edu.ogu.ceng.notification.repository.NotificationsSettingsRepo;

import java.util.List;
import java.util.Optional;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class NotificationsSettingsService {

    private NotificationsSettingsRepo notificationSettingsRepository;

    public List<NotificationSettings> getAllNotificationSettings() {
        return notificationSettingsRepository.findAll();
    }

    public NotificationSettings getNotificationSettingById(Long id) {
        Optional<NotificationSettings> notificationSetting = notificationSettingsRepository.findById(id);
        return notificationSetting.orElseThrow(() -> new RuntimeException("Notification setting not found with id: " + id));
    }

    public NotificationSettings createNotificationSetting(NotificationSettings notificationSetting) {
        return notificationSettingsRepository.save(notificationSetting);
    }

    public NotificationSettings updateNotificationSetting(Long id, NotificationSettings notificationSettingDetails) {

        NotificationSettings notificationSetting = getNotificationSettingById(id);
        notificationSetting.setEnabled(notificationSettingDetails.getEnabled());

        return notificationSettingsRepository.save(notificationSetting);
    }

    public void deleteNotificationSetting(Long id) {
        NotificationSettings notificationSetting = getNotificationSettingById(id);
        notificationSettingsRepository.delete(notificationSetting);
    }
}
