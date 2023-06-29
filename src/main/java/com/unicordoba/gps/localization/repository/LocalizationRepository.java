package com.unicordoba.gps.localization.repository;

// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unicordoba.gps.localization.model.Localization;

public interface LocalizationRepository extends JpaRepository<Localization, Long>{
    // List<Localization> findAllOrderByDateDesc();
}
