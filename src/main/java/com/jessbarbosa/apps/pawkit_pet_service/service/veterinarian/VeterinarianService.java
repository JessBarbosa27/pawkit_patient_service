package com.jessbarbosa.apps.pawkit_pet_service.service.veterinarian;

import com.jessbarbosa.apps.pawkit_pet_service.model.Appointment;

import java.util.List;

public interface VeterinarianService {

    public List<Appointment> getAppointments(Long vetId);

    public void addNotes(Long vetId, String notes);
}
