package olszanka.mateusz.GPSTracker.dao;

import olszanka.mateusz.GPSTracker.domain.Measurement;
import org.springframework.data.repository.CrudRepository;

public interface MeasurementRepository extends CrudRepository<Measurement,Long> {
}
