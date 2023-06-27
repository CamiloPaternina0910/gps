package com.unicordoba.gps.device.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unicordoba.gps.device.model.TypeDevice;

public interface TypeDeviceRepository extends JpaRepository<TypeDevice, Long>{
    
}
