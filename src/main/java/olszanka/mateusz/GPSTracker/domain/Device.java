package olszanka.mateusz.GPSTracker.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany
    private List<Measurement> measurements;

    public Device(){
        this.measurements = new ArrayList<>();
    }

    public Device(Long id, String name, List<Measurement> measurements) {
        this.id = id;
        this.name = name;
        this.measurements = measurements;
    }

    public Device(String name){
        this.name = name;
    }

    public Device(List<Measurement> measurements){
        this.measurements = measurements;
    }

    public void addMeasurementToList(Measurement measurement){
        measurements.add(measurement);
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
