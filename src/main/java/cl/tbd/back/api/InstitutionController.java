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

import cl.tbd.back.model.Institution;
import cl.tbd.back.service.InstitutionService;

@CrossOrigin
@RestController
public class InstitutionController {
    
    private final InstitutionService institutionService;

    @Autowired
    public InstitutionController(@Valid @NonNull InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    @PostMapping("/api/v1/institutions")
    public void insertInstitution(@RequestBody Institution institution) {
        institutionService.insertInstitution(institution);
    }

    @GetMapping("/api/v1/institutions")
    public List<Institution> selectAllInstitution() {
        return institutionService.selectAllInstitutions();
    }

    @GetMapping("/api/v1/institutions/{id}")
    public Institution selectInstitutionById(@PathVariable("id") UUID id) {
        return institutionService.selectInstitutionById(id).orElse(null);
    }

    @PutMapping("/api/v1/institutions/name/{id}")
    public void updateInstitutionNameById(@PathVariable("id") UUID id, @Valid @NonNull Institution institution) {
        institutionService.updateInstitutionNameById(id, institution);
    }

    @DeleteMapping("/api/v1/institutions/{id}")
    public void deleteInstitutionById(@PathVariable("id") UUID id) {
        institutionService.deleteInstitution(id);
    }

}