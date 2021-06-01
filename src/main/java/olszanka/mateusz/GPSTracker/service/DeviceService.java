package olszanka.mateusz.GPSTracker.service;

import com.google.common.collect.Lists;
import olszanka.mateusz.GPSTracker.dao.DeviceRepository;
import olszanka.mateusz.GPSTracker.domain.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DeviceService {
    private DeviceRepository deviceRepository;

    @Autowired
    public DeviceService(DeviceRepository deviceRepository){
        this.deviceRepository = deviceRepository;
    }

    public boolean existsById(Long id){
        return deviceRepository.existsById(id);
    }

    public Device getOne(Long id){
        if(deviceRepository.existsById(id)){
            return deviceRepository.findById(id).get();
        }else{
            throw new EntityNotFoundException(Long.toString(id));
        }
    }

    public List<Device> findAll() {
        return Lists.newArrayList(deviceRepository.findAll());
    }

    public Device create(Device device){
        return deviceRepository.save(device);
    }

    public void delete(Long id) {
        if(deviceRepository.existsById(id)){
            deviceRepository.deleteById(id);
        }else{
            throw new EntityNotFoundException(Long.toString(id));
        }
    }

    public void deleteAll() {
        deviceRepository.deleteAll();
    }

}
