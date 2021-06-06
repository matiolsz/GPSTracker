package olszanka.mateusz.GPSTracker.controller;

import olszanka.mateusz.GPSTracker.domain.Device;
import olszanka.mateusz.GPSTracker.domain.Measurement;
import olszanka.mateusz.GPSTracker.service.DeviceService;
import olszanka.mateusz.GPSTracker.service.MeasurementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/measurement")
public class MeasurementController {
    private MeasurementService measurementService;

    Logger logger = LoggerFactory.getLogger(MeasurementController.class);

    @Autowired
    public MeasurementController(MeasurementService measurementService){
        this.measurementService = measurementService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public Measurement create(@RequestBody Measurement measurement){
        return measurementService.create(measurement);
    }

    @GetMapping
    public List<Measurement> getAll(){
        return measurementService.findAll();
    }

    @GetMapping("/{id}")
    public Measurement getOne(Long id){
        return measurementService.getOne(id);
    }

    @DeleteMapping
    void deleteAll(){
        measurementService.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void delete(Long id){
        measurementService.delete(id);
    }

    @PutMapping("/{id}")
    public Measurement put(@RequestBody Measurement measurement){
        return measurementService.create(measurement);
    }

    @ResponseStatus(value= HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public String measurementNotFound(EntityNotFoundException ex) {
        logger.warn("Nie ma takiego rekordu");
        return ex.getMessage();
    }
    @ExceptionHandler(NoSuchElementException.class)
    public String measurementNotFound(NoSuchElementException ex) {
        logger.warn("Nie ma urządzenia z id, które podajesz");
        return ex.getMessage();
    }
}
