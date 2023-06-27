package com.unicordoba.gps.localization.mapper;

import com.unicordoba.gps.localization.dto.LocalizationRequest;
import com.unicordoba.gps.localization.model.Localization;

public interface LocalizationMapper {
    
    Localization toEntity(LocalizationRequest request);

    LocalizationRequest toDto(Localization localization);
    
}
