package olszanka.mateusz.GPSTracker.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int latitiude;
    private int longitiude;

    public Device(){

    }

    public Device(int latitiude, int longitiude) {
        this.latitiude = latitiude;
        this.longitiude = longitiude;
    }
}
