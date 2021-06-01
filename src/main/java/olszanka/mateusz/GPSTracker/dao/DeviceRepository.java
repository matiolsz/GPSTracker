package olszanka.mateusz.GPSTracker.dao;

import olszanka.mateusz.GPSTracker.domain.Device;
import org.springframework.data.repository.CrudRepository;

public interface DeviceRepository extends CrudRepository<Device, Long> {
}
