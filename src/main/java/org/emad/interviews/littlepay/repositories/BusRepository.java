package org.emad.interviews.littlepay.repositories;

import org.emad.interviews.littlepay.entities.Bus;

import java.util.HashMap;

public class BusRepository {

    public static HashMap<String, Bus> BUSES = new HashMap<>();
    static {
        BUSES.put("Bus36", new Bus(1, "Bus36"));
        BUSES.put("Bus37", new Bus(2, "Bus37"));
        BUSES.put("Bus38", new Bus(3, "Bus38"));
        BUSES.put("Bus39", new Bus(4, "Bus39"));
    }
}
