package com.jessbarbosa.apps.pawkit_pet_service.repository;

import com.jessbarbosa.apps.pawkit_pet_service.model.Veterinarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeterinarianRepository extends JpaRepository<Veterinarian, Long> {}
