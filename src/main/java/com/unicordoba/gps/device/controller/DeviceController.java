package com.unicordoba.gps.device.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicordoba.gps.device.dto.DeviceRequest;
import com.unicordoba.gps.device.mapper.DeviceMapper;
import com.unicordoba.gps.device.model.Device;
import com.unicordoba.gps.device.service.DeviceService;
import com.unicordoba.gps.device.service.TypeDeviceService;
import com.unicordoba.gps.user.service.UserService;
import com.unicordoba.gps.utils.Response;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("api/v1/device")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private DeviceMapper deviceMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private TypeDeviceService typeDeviceService;

    @PostMapping("/new")
    public ResponseEntity<Response> newDevice(@AuthenticationPrincipal User user,
            @Valid @RequestBody DeviceRequest request) {
        Device device = deviceMapper.toEntity(request);
        device.setUser(userService.findByUsername(user.getUsername()));
        device.setType(typeDeviceService.findById(request.getType()));

        deviceService.save(device);
        return new ResponseEntity<Response>(
                new Response(false, "Device saved", "200-OK"),
                HttpStatus.OK);
    }

    @GetMapping(value = "/my")
    public ResponseEntity<Response> findDevices(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(new Response(
                false,
                mapperList(userService.findByUsername(user.getUsername()).getDevices()),
                "200-OK"));
    }

    private List<DeviceRequest> mapperList(List<Device> devices) {
        return devices
                .stream()
                .map(device -> deviceMapper.toDto(device))
                .toList();
    }
}
