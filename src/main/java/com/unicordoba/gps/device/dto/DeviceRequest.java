package com.unicordoba.gps.device.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeviceRequest {
    
    @NotEmpty(message = "Name's device is required")
    private String deviceName;

    @NotNull(message = "Type's device is required")
    private Long type;

}
