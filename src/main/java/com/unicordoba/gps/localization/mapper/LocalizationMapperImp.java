package com.unicordoba.gps.localization.mapper;

import org.springframework.stereotype.Component;

import com.unicordoba.gps.localization.dto.LocalizationRequest;
import com.unicordoba.gps.localization.model.Localization;

@Component
public class LocalizationMapperImp implements LocalizationMapper{

    @Override
    public Localization toEntity(LocalizationRequest request) {
       if(request == null) return null;

        Localization localization = new Localization();
        localization.setLat(request.getLat());
        localization.setLgh(request.getLgh());

        return localization;
    }

    @Override
    public LocalizationRequest toDto(Localization localization) {
        if(localization == null) return null;
        
        LocalizationRequest res = new LocalizationRequest();
        res.setDeviceId(localization.getDevice().getDeviceId());
        res.setLat(localization.getLat());
        res.setLgh(localization.getLgh());

        return res;
    }
    
}
