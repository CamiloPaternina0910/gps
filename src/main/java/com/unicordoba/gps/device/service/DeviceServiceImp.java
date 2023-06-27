package com.unicordoba.gps.device.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicordoba.gps.device.model.Device;
import com.unicordoba.gps.device.repository.DeviceRepository;
import com.unicordoba.gps.user.model.User;

@Service
public class DeviceServiceImp implements DeviceService{

    @Autowired
    private DeviceRepository deviceRepository;

    @Override
    public List<Device> findAll() {
        return deviceRepository.findAll();
    }

    @Override
    public List<Device> findByUser(User user) {
        return deviceRepository.findAllByUser(user);
    }

    @Override
    public Device findById(Long id) {
        return deviceRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Device device) {
        deviceRepository.save(device);
    }

    @Override
    public void delete(Device device) {
        deviceRepository.delete(device);
    }
    
}
