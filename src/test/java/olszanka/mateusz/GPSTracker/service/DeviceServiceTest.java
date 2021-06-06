package olszanka.mateusz.GPSTracker.service;

import olszanka.mateusz.GPSTracker.dao.DeviceRepository;
import olszanka.mateusz.GPSTracker.domain.Device;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.MockitoAnnotations.initMocks;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class DeviceServiceTest {

    @MockBean
    private DeviceRepository deviceRepository;

    @InjectMocks
    private DeviceService deviceService;

    @Test
    void testIfExistsById(){
        Device device = new Device();
        device.setId(1L);
        Mockito.when(deviceRepository.findById(1L)).thenReturn(device));
        assertTrue(deviceService.existsById(1L));
    }

    @Test
    void getOne() {
        Device device = new Device(1L,"jakis",null);

    }
}