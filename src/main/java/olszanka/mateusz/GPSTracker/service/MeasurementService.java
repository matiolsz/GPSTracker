package olszanka.mateusz.GPSTracker.service;

import com.google.common.collect.Lists;
import olszanka.mateusz.GPSTracker.dao.DeviceRepository;
import olszanka.mateusz.GPSTracker.dao.MeasurementRepository;
import olszanka.mateusz.GPSTracker.domain.Device;
import olszanka.mateusz.GPSTracker.domain.Measurement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MeasurementService {
    private MeasurementRepository measurementRepository;
    private DeviceRepository deviceRepository;

    @Autowired
    public MeasurementService(MeasurementRepository measurementRepository, DeviceRepository deviceRepository){
        this.measurementRepository = measurementRepository;
        this.deviceRepository = deviceRepository;
    }

    public boolean existsById(Long id){
        return measurementRepository.existsById(id);
    }

    public Measurement getOne(Long id){
        if(measurementRepository.existsById(id)){
            return measurementRepository.findById(id).get();
        }else{
            throw new EntityNotFoundException(Long.toString(id));
        }
    }

    public List<Measurement> findAll() {
        return Lists.newArrayList(measurementRepository.findAll());
    }

    public Measurement create(Measurement measurement) {
        if(deviceRepository.existsById(measurement.getDeviceId())) {
            Device device = deviceRepository.findById(measurement.getDeviceId()).get();
            measurementRepository.save(measurement);
            device.addMeasurementToList(measurement);
            deviceRepository.save(device);
        }else{
            throw new NoSuchElementException("Próbujesz przyporządkować pomiar do urządzenia którego nie ma(sprawdz idDevice)");
        }
        return measurementRepository.save(measurement);
    }

    public void delete(Long id) {
        if(measurementRepository.existsById(id)){
            measurementRepository.deleteById(id);
        }else{
            throw new EntityNotFoundException(Long.toString(id));
        }
    }

    public void deleteAll() {
        measurementRepository.deleteAll();
    }

}
