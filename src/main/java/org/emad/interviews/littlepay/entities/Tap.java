package org.emad.interviews.littlepay.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.emad.interviews.littlepay.enums.TapType;

import javax.smartcardio.Card;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Tap implements Comparable<Tap> {

    private Long id;
    private LocalDateTime dateTime;
    private TapType tapType;
    private Stop stop;
    private Company company;
    private Bus bus;
    private Card card;

    @Override
    public int compareTo(Tap o) {
        return dateTime.compareTo(o.getDateTime());
    }
}
