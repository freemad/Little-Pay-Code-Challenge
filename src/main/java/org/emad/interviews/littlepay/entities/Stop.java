package org.emad.interviews.littlepay.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Stop {

    private int id;
    private String stopId;
    private Float maxCharge;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stop stop = (Stop) o;
        return id == stop.id && stopId.equals(stop.stopId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, stopId);
    }
}
