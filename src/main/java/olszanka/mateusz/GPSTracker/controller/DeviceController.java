package olszanka.mateusz.GPSTracker.controller;

import olszanka.mateusz.GPSTracker.domain.Device;
import olszanka.mateusz.GPSTracker.service.DeviceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/device")
public class DeviceController {
    private DeviceService deviceService;

    Logger logger = LoggerFactory.getLogger(DeviceController.class);

    @Autowired
    private DeviceController(DeviceService deviceService){
        this.deviceService = deviceService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public Device create(@RequestBody Device device){
        logger.info("Dodano nowy pomiar");
        return deviceService.create(device);
    }

    @GetMapping
    public List<Device> getAll(){
        logger.info("Wyświetlam wszystkie pomiary");
        return deviceService.findAll();
    }

    @GetMapping("/{id}")
    public Device getOne(Long id){
        return deviceService.getOne(id);
    }

    @DeleteMapping
    void deleteAll(){
        deviceService.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void delete(Long id){
        deviceService.delete(id);
    }

    @PutMapping("/{id}")
    public Device put(@RequestBody Device sensor){
        return deviceService.create(sensor);
    }

    @ResponseStatus(value= HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public String sensorNotFound() {
        return "Nie ma takiego rekordu";
    }
}
