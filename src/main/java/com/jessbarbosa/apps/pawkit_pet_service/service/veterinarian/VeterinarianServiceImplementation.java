package com.jessbarbosa.apps.pawkit_pet_service.service.veterinarian;

import com.jessbarbosa.apps.pawkit_pet_service.exception.ResourceNotFoundException;
import com.jessbarbosa.apps.pawkit_pet_service.model.Appointment;
import com.jessbarbosa.apps.pawkit_pet_service.model.Veterinarian;
import com.jessbarbosa.apps.pawkit_pet_service.repository.VeterinarianRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeterinarianServiceImplementation {
    private final VeterinarianRepository veterinarianRepository;

    public VeterinarianServiceImplementation(VeterinarianRepository veterinarianRepository) {
        this.veterinarianRepository = veterinarianRepository;
    }

    public List<Appointment> getAppointments(Long vetId) {
        Veterinarian vet = veterinarianRepository.findById(vetId)
                .orElseThrow(() -> new ResourceNotFoundException("Veterinarian not found"));
        return vet.getAppointments();
    }

    public void addNotes(Long vetId, String notes) {
        Veterinarian vet = veterinarianRepository.findById(vetId)
                .orElseThrow(() -> new ResourceNotFoundException("Veterinarian not found"));
        // Logic to save notes (e.g., in a separate table or log system)
    }
}
