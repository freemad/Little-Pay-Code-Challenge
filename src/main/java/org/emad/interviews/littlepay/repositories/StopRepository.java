package org.emad.interviews.littlepay.repositories;

import org.emad.interviews.littlepay.entities.Stop;

import java.util.HashMap;

public class StopRepository {

    public static HashMap<String, Stop> STOPS = new HashMap();
    static {
        STOPS.put("Stop1", new Stop(1, "Stop1",  0.0f));
        STOPS.put("Stop2", new Stop(2, "Stop2",  0.0f));
        STOPS.put("Stop3", new Stop(3, "Stop3",  0.0f));
    }
}
