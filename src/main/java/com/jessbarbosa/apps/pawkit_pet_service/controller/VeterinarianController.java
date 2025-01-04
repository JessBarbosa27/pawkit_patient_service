package com.jessbarbosa.apps.pawkit_pet_service.controller;

import com.jessbarbosa.apps.pawkit_pet_service.model.Appointment;
import com.jessbarbosa.apps.pawkit_pet_service.service.veterinarian.VeterinarianService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vet")
@RequiredArgsConstructor
public class VeterinarianController {
    private final VeterinarianService veterinarianService;

    @GetMapping("/{id}/appointments")
    public ResponseEntity<List<Appointment>> getVetAppointments(@PathVariable Long id) {
        return ResponseEntity.ok(veterinarianService.getAppointments(id));
    }

    @PostMapping("/{id}/notes")
    public ResponseEntity<Void> addNotes(@PathVariable Long id, @RequestBody String notes) {
        veterinarianService.addNotes(id, notes);
        return ResponseEntity.ok().build();
    }
}
