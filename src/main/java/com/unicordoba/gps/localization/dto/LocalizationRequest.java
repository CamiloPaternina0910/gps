package com.unicordoba.gps.localization.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalizationRequest {
    
    @NotEmpty(message = "Lat is required")
    private String lat;

    @NotEmpty(message = "Lgh is required")
    private String lgh; 

    @NotNull(message = "deviceId is required")
    private Long deviceId;

}
