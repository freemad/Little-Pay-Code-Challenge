package org.emad.interviews.littlepay.entities;

import lombok.Data;

import java.util.HashSet;

@Data
public class Line {

    private HashSet<Stop> ends;

    public Line(Stop endA, Stop endZ) {
        ends = new HashSet<>();
        ends.add(endA);
        ends.add(endZ);
    }

    public boolean isStopIn(Stop stop) {
        return ends.contains(stop);
    }
}
