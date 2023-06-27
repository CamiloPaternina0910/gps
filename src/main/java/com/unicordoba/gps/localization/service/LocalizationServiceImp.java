package com.unicordoba.gps.localization.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicordoba.gps.localization.model.Localization;
import com.unicordoba.gps.localization.repository.LocalizationRepository;

@Service
public class LocalizationServiceImp implements LocalizationService{

    @Autowired
    private LocalizationRepository localizationRepository;

    @Override
    public List<Localization> findAll() {
        return localizationRepository.findAllOrderByDateDesc();
    }

    @Override
    public Localization findById(Long id) {
        return localizationRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Localization localization) {
        localizationRepository.save(localization);
    }

    @Override
    public void delete(Localization localization) {
        localizationRepository.delete(localization);
    }

}
