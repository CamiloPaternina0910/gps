package com.unicordoba.gps.device.service;

import java.util.List;

import com.unicordoba.gps.device.model.Device;
import com.unicordoba.gps.user.model.User;

public interface DeviceService {
    
    List<Device> findAll();

    List<Device> findByUser(User user);

    Device findById(Long id);

    void save(Device device);

    void delete(Device device);
    
}
