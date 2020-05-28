package cl.tbd.back.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cl.tbd.back.model.Emergency;
import cl.tbd.back.service.EmergencyService;

@CrossOrigin
@RestController
public class EmergencyController {
    
    private final EmergencyService emergencyService;

    @Autowired
    public EmergencyController(@Valid @NonNull EmergencyService emergencyService) {
        this.emergencyService = emergencyService;
    }

    @PostMapping("/api/v1/emergencies")
    public void insertEmergency(@RequestBody Emergency emergency) {
        emergencyService.insertEmergency(emergency);
    }

    @GetMapping("/api/v1/emergencies")
    public List<Emergency> selectAllEmergency() {
        return emergencyService.selectAllEmergencies();
    }

    @GetMapping("/api/v1/emergencies/{id}")
    public Emergency selectEmergencyById(@PathVariable("id") UUID id) {
        return emergencyService.selectEmergencyById(id).orElse(null);
    }

    @PutMapping("/api/v1/emergencies/name/{id}")
    public void updateEmergencyNameById(@PathVariable("id") UUID id, @Valid @NonNull Emergency emergency) {
        emergencyService.updateEmergencyNameById(id, emergency);
    }

    @PutMapping("/api/v1/emergencies/description/{id}")
    public void updateEmergencyDescriptionById(@PathVariable("id") UUID id, @Valid @NonNull Emergency emergency) {
        emergencyService.updateEmergencyDescriptionById(id, emergency);
    }

    @PutMapping("/api/v1/emergencies/finish/{id}")
    public void updateEmergencyFinish_dateById(@PathVariable("id") UUID id, @Valid @NonNull Emergency emergency) {
        emergencyService.updateEmergencyFinish_dateById(id, emergency);
    }

    @DeleteMapping("/api/v1/emergencies/{id}")
    public void deleteEmergencyById(@PathVariable("id") UUID id) {
        emergencyService.deleteEmergencyById(id);
    }
}