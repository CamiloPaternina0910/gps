package com.unicordoba.gps.localization.service;

import java.util.List;

import com.unicordoba.gps.localization.model.Localization;

public interface LocalizationService {
    
    List<Localization> findAll();

    Localization findById(Long id);

    void save(Localization localization);

    void delete(Localization localization);
    
}
