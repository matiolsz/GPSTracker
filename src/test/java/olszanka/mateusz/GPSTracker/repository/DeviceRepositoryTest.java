package olszanka.mateusz.GPSTracker.repository;

import olszanka.mateusz.GPSTracker.dao.DeviceRepository;
import olszanka.mateusz.GPSTracker.domain.Device;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class DeviceRepositoryTest {

    @Autowired
    private DeviceRepository deviceRepository;

    @Test
    void testCreateDevice() {
        Device device = deviceRepository.save(new Device("nazwa"));
        assertNotNull(device);
        assertTrue(device.getId() > 0);
    }
}