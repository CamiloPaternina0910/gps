package com.unicordoba.gps.device.mapper;

import com.unicordoba.gps.device.dto.DeviceRequest;
import com.unicordoba.gps.device.model.Device;

public interface DeviceMapper {

    Device toEntity(DeviceRequest request);
    
    DeviceRequest toDto(Device device);

}
