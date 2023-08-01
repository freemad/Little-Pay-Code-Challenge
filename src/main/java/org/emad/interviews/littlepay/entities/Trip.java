package org.emad.interviews.littlepay.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.emad.interviews.littlepay.enums.TripStatus;

import java.time.ZoneOffset;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Trip {

    private long id;
    private Tap tapOn;
    private Tap tapOff;
    private float chargeAmount;
    private TripStatus status;

    public long getDuration() {
        return (tapOff != null)
                ? (tapOff.getDateTime().toEpochSecond(ZoneOffset.UTC) - tapOn.getDateTime().toEpochSecond(ZoneOffset.UTC))
                : 0;
    }
}
