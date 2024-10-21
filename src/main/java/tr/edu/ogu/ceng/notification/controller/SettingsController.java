package tr.edu.ogu.ceng.notification.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tr.edu.ogu.ceng.notification.entity.Settings;
import tr.edu.ogu.ceng.notification.service.SettingsService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/settings")
public class SettingsController {

    private final SettingsService settingsService;

    @GetMapping
    public List<Settings> getAllSettings() {
        return settingsService.getAllSettings();
    }

    // Get a setting by id
    @GetMapping("/{id}")
    public Settings getSettingById(@PathVariable Long id) {
        return settingsService.getSettingById(id);
    }

    // Create a new setting
    @PostMapping
    public Settings createSetting(@RequestBody Settings setting) {
        return settingsService.createSetting(setting);
    }

    // Update an existing setting
    @PutMapping("/{id}")
    public Settings updateSetting(@PathVariable Long id, @RequestBody Settings settingDetails) {
        return settingsService.updateSetting(id, settingDetails);
    }

    // Delete a setting
    @DeleteMapping("/{id}")
    public void deleteSetting(@PathVariable Long id) {
        settingsService.deleteSetting(id);
    }

}
