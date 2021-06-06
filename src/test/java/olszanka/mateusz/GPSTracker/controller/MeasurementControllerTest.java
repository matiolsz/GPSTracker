package olszanka.mateusz.GPSTracker.controller;

import olszanka.mateusz.GPSTracker.domain.Measurement;
import olszanka.mateusz.GPSTracker.service.MeasurementService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class MeasurementControllerTest {

    @Test
    @DisplayName("Should find a measurement with given id")
    void testingMethodNamedGetOne() {
        MeasurementService measurementService = Mockito.mock(MeasurementService.class);
        MeasurementController measurementController = new MeasurementController(measurementService);
        Measurement measurement = new Measurement(1L,312312, 124124 ,null);
        when(measurementService.getOne(1L)).thenReturn(measurement);
        assertEquals(1L,measurementController.getOne(1L).getId());
    }

    @Test
    @DisplayName("Should not find a measurement with given id")
    void testingMethodNamedGetOne2() {
        MeasurementService measurementService = Mockito.mock(MeasurementService.class);
        MeasurementController measurementController = new MeasurementController(measurementService);
        Measurement measurement = new Measurement(1L,312312, 124124 ,null);
        when(measurementService.getOne(1L)).thenReturn(measurement);
        assertFalse(2L == measurementController.getOne(1L).getId());
    }


    @Test
    @DisplayName("Calling getAll measurements and checking if two added measurements will be retured (should be true)")
    void getAll() {
        MeasurementService measurementService = Mockito.mock(MeasurementService.class);
        MeasurementController measurementController = new MeasurementController(measurementService);
        Measurement measurement = new Measurement(1L,312312, 124124 ,null);
        Measurement measurement1 = new Measurement(2L, 3123412, 1424124 , null);
        List<Measurement> list = new ArrayList<>();
        list.add(measurement);
        list.add(measurement1);
        when(measurementService.findAll()).thenReturn(list);
        assertTrue(list.toString().equals(measurementController.getAll().toString()));
    }

}