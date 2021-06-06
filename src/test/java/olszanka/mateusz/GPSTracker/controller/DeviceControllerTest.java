package olszanka.mateusz.GPSTracker.controller;

import olszanka.mateusz.GPSTracker.domain.Device;
import olszanka.mateusz.GPSTracker.service.DeviceService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class DeviceControllerTest {

    @Test
    @DisplayName("Should find a device with given id")
    void testingMethodNamedGetOne() {
        DeviceService deviceService = Mockito.mock(DeviceService.class);
        DeviceController deviceController = new DeviceController(deviceService);
        Device device = new Device(1L,"gps",new ArrayList<>());
        when(deviceService.getOne(1L)).thenReturn(device);
        assertEquals(1L,deviceController.getOne(1L).getId());
    }

    @Test
    @DisplayName("Should not find a device with given id")
    void testingMethodNamedGetOne2() {
        DeviceService deviceService = Mockito.mock(DeviceService.class);
        DeviceController deviceController = new DeviceController(deviceService);
        Device device = new Device(1L,"gps",new ArrayList<>());
        when(deviceService.getOne(1L)).thenReturn(device);
        assertFalse(2L == deviceController.getOne(1L).getId());
    }


    @Test
    @DisplayName("Calling getAll devices and checking if two added devices will be retured (should be true)")
    void getAll() {
        DeviceService deviceService = Mockito.mock(DeviceService.class);
        DeviceController deviceController = new DeviceController(deviceService);
        Device device = new Device(1L, "gps", new ArrayList<>());
        Device device2 = new Device(2L, "gps2", new ArrayList<>());
        List<Device> list = new ArrayList<>();
        list.add(device);
        list.add(device2);
        when(deviceService.findAll()).thenReturn(list);
        assertTrue(list.toString().equals(deviceController.getAll().toString()));
    }


    @Test
    void delete() {

    }

    @Test
    void put() {

    }


}