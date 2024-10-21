package tr.edu.ogu.ceng.notification.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import tr.edu.ogu.ceng.notification.entity.Settings;
import tr.edu.ogu.ceng.notification.repository.SettingsRepo;

import java.util.List;
import java.util.Optional;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class SettingsService {

    private final SettingsRepo settingsRepository;

    public List<Settings> getAllSettings() {
        return settingsRepository.findAll();
    }

    public Settings getSettingById(Long id) {
        Optional<Settings> setting = settingsRepository.findById(id);
        return setting.orElseThrow(() -> new RuntimeException("Setting not found with id: " + id));
    }

    public Settings createSetting(Settings setting) {
        return settingsRepository.save(setting);
    }

    public Settings updateSetting(Long id, Settings settingDetails) {
        Settings setting = getSettingById(id);

        setting.setSettingKey(settingDetails.getSettingKey());
        setting.setValue(settingDetails.getValue());

        return settingsRepository.save(setting);
    }

    public void deleteSetting(Long id) {
        Settings setting = getSettingById(id);
        settingsRepository.delete(setting);
    }
}
