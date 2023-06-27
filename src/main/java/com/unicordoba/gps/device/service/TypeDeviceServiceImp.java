package com.unicordoba.gps.device.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicordoba.gps.device.model.TypeDevice;
import com.unicordoba.gps.device.repository.TypeDeviceRepository;

@Service
public class TypeDeviceServiceImp implements TypeDeviceService{

    @Autowired
    private TypeDeviceRepository typeDeviceRepository;

    @Override
    public List<TypeDevice> findAll() {
        return typeDeviceRepository.findAll();
    }

    public TypeDevice findById(Long id){
        return typeDeviceRepository.findById(id).orElse(null);
    }
    
}
