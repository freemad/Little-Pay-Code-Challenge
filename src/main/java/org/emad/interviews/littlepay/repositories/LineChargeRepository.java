package org.emad.interviews.littlepay.repositories;

import org.emad.interviews.littlepay.entities.Line;
import org.emad.interviews.littlepay.entities.LineCharge;

import java.util.HashMap;

public class LineChargeRepository {

    public static HashMap<Line, LineCharge> LINE_CHARGES = new HashMap<>();
    static {
        Line line1 = new Line(StopRepository.STOPS.get("Stop1"), StopRepository.STOPS.get("Stop2"));
        Line line2 = new Line(StopRepository.STOPS.get("Stop2"), StopRepository.STOPS.get("Stop3"));
        Line line3 = new Line(StopRepository.STOPS.get("Stop1"), StopRepository.STOPS.get("Stop3"));
        LINE_CHARGES.put(line1, new LineCharge(1, line1, 3.25f));
        LINE_CHARGES.put(line2, new LineCharge(2, line2, 5.5f));
        LINE_CHARGES.put(line3, new LineCharge(3, line3, 7.3f));
    }
}
