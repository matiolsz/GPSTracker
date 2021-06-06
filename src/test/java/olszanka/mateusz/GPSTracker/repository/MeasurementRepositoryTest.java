package olszanka.mateusz.GPSTracker.repository;

import olszanka.mateusz.GPSTracker.dao.MeasurementRepository;
import olszanka.mateusz.GPSTracker.domain.Measurement;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class MeasurementRepositoryTest {

    @Autowired
    private MeasurementRepository measurementRepository;

    @Test
    void testCreateMeasurement() {
        Measurement measurement = measurementRepository.save(new Measurement(12312,12312));
        assertNotNull(measurement);
        assertTrue(measurement.getId() > 0);
    }
}