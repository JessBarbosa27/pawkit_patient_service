package com.jessbarbosa.apps.pawkit_pet_service.service.pet;

import com.jessbarbosa.apps.pawkit_pet_service.exception.ResourceNotFoundException;
import com.jessbarbosa.apps.pawkit_pet_service.model.Appointment;
import com.jessbarbosa.apps.pawkit_pet_service.model.Pet;
import com.jessbarbosa.apps.pawkit_pet_service.repository.AppointmentRepository;
import com.jessbarbosa.apps.pawkit_pet_service.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImplementation {
    private final PetRepository petRepository;
    private final AppointmentRepository appointmentRepository;

    public PetServiceImplementation(PetRepository petRepository, AppointmentRepository appointmentRepository) {
        this.petRepository = petRepository;
        this.appointmentRepository = appointmentRepository;
    }

    public Pet getPet(Long id) {
        return petRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pet not found"));
    }

    public Pet updatePet(Long id, Pet petDetails) {
        Pet pet = getPet(id);
        pet.setName(petDetails.getName());
        pet.setBreed(petDetails.getBreed());
        pet.setDateOfBirth(petDetails.getDateOfBirth());
        return petRepository.save(pet);
    }

    public Appointment bookAppointment(Long petId, Appointment appointment) {
        Pet pet = getPet(petId);
        appointment.setPet(pet);
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAppointments(Long petId) {
        Pet pet = getPet(petId);
        return pet.getAppointments();
    }
}
