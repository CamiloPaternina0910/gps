package com.unicordoba.gps.device.service;

import java.util.List;

import com.unicordoba.gps.device.model.TypeDevice;

public interface TypeDeviceService {
    
    List<TypeDevice> findAll();
    TypeDevice findById(Long id);
}
