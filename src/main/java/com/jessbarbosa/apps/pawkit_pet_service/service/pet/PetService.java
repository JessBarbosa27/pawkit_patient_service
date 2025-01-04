package com.jessbarbosa.apps.pawkit_pet_service.service.pet;

import com.jessbarbosa.apps.pawkit_pet_service.model.Appointment;
import com.jessbarbosa.apps.pawkit_pet_service.model.Pet;

import java.util.List;

public interface PetService {

    public Pet getPet(Long id);

    public Pet updatePet(Long id, Pet petDetails);

    public Appointment bookAppointment(Long petId, Appointment appointment);

    public List<Appointment> getAppointments(Long petId);
}
