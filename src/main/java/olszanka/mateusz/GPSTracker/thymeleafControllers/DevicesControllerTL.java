package olszanka.mateusz.GPSTracker.thymeleafControllers;

import olszanka.mateusz.GPSTracker.domain.Device;
import olszanka.mateusz.GPSTracker.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/devicesTL")
public class DevicesControllerTL {

    DeviceService deviceService;

    @Autowired
    private DevicesControllerTL(DeviceService deviceService){
        this.deviceService = deviceService;
    }

    @GetMapping
    public String showMeasurements(Model model){
        List<Device> measurementList = deviceService.findAll();
        model.addAttribute("measurementList", measurementList);
        return "device-measurements";
    }
}
