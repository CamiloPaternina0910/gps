package com.unicordoba.gps.device.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unicordoba.gps.device.model.Device;
import com.unicordoba.gps.user.model.User;


public interface DeviceRepository extends JpaRepository<Device, Long>{
    
    List<Device> findAllByUser(User user);

}
