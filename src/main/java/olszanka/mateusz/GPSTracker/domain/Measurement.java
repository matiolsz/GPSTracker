package olszanka.mateusz.GPSTracker.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int latitiude;
    private int longitiude;
    private Long deviceId;

    public Measurement(){

    }
    public Measurement(int latitiude, int longitiude){
        this.latitiude = latitiude;
        this.longitiude = longitiude;
    }
    public Measurement(int latitiude, int longitiude, Long deviceId){
        this.latitiude = latitiude;
        this.longitiude = longitiude;
        this.deviceId = deviceId;
    }
    public Long getDeviceId(){
        return this.deviceId;
    }
    public Long getId(){
        return this.id;
    }
}
