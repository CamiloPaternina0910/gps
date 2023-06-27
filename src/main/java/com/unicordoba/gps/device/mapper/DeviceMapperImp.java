package com.unicordoba.gps.device.mapper;

import org.springframework.stereotype.Component;

import com.unicordoba.gps.device.dto.DeviceRequest;
import com.unicordoba.gps.device.model.Device;

@Component
public class DeviceMapperImp implements DeviceMapper{

    @Override
    public Device toEntity(DeviceRequest request) {
        if(request == null) return null;

        Device device = new Device();
        device.setDeviceName(request.getDeviceName());
        
        return device;
    }

    @Override
    public DeviceRequest toDto(Device device) {
        if(device == null) return null;

        DeviceRequest res = new DeviceRequest();
        res.setDeviceName(device.getDeviceName());
        res.setType(device.getType().getTypeDeviceId());

        return res;
    }
    
}
