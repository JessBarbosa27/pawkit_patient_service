package com.jessbarbosa.apps.pawkit_pet_service.controller;

import com.jessbarbosa.apps.pawkit_pet_service.model.Appointment;
import com.jessbarbosa.apps.pawkit_pet_service.model.Pet;
import com.jessbarbosa.apps.pawkit_pet_service.service.pet.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pet")
@RequiredArgsConstructor
public class PetController {
    private final PetService petService;

    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPet(@PathVariable Long id) {
        return ResponseEntity.ok(petService.getPet(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pet> updatePet(@PathVariable Long id, @RequestBody Pet pet) {
        return ResponseEntity.ok(petService.updatePet(id, pet));
    }

    @PostMapping("/{id}/appointments")
    public ResponseEntity<Appointment> bookAppointment(@PathVariable Long id, @RequestBody Appointment appointment) {
        return ResponseEntity.ok(petService.bookAppointment(id, appointment));
    }

    @GetMapping("/{id}/appointments")
    public ResponseEntity<List<Appointment>> getAppointments(@PathVariable Long id) {
        return ResponseEntity.ok(petService.getAppointments(id));
    }
}
