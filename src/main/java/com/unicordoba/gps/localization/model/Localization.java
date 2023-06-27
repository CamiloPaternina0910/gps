package com.unicordoba.gps.localization.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.unicordoba.gps.device.model.Device;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "localizations")
@Getter
@Setter
public class Localization implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long localizationId;

    @NotEmpty(message = "Lat is required")
    private String lat;

    @NotEmpty(message = "Lgh is required")
    private String lgh; 

    private LocalDateTime dateTime = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    private Device device;
}
