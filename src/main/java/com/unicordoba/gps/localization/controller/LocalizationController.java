package com.unicordoba.gps.localization.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unicordoba.gps.device.service.DeviceService;
import com.unicordoba.gps.localization.dto.LocalizationRequest;
import com.unicordoba.gps.localization.mapper.LocalizationMapper;
import com.unicordoba.gps.localization.model.Localization;
import com.unicordoba.gps.localization.service.LocalizationService;
import com.unicordoba.gps.utils.Response;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/localization")
public class LocalizationController {

    @Autowired
    private LocalizationService localizationService;

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private LocalizationMapper localizationMapper;

    @PostMapping("/new")
    public ResponseEntity<Response> createLocalization(@Valid @ModelAttribute LocalizationRequest request) {
        Localization localization = localizationMapper.toEntity(request);
        localization.setDevice(deviceService.findById(request.getDeviceId()));
        localizationService.save(localization);

        return new ResponseEntity<Response>(
                new Response(false, "Localization saved", "200-OK"),
                HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<Response> getLastLocalization(@RequestParam Long deviceId) {
        List<Localization> localizations = deviceService.findById(deviceId).getLocalizations();
        return new ResponseEntity<Response>(
                new Response(false, mapperList(localizations), "200"),
                HttpStatus.OK);
    }

    private List<LocalizationRequest> mapperList(List<Localization> localizations) {
        return localizations
                .stream()
                .map(localization -> localizationMapper.toDto(localization))
                .toList();
    }
}
