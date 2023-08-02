package org.emad.interviews.services;

import org.emad.interviews.littlepay.entities.LineCharge;
import org.emad.interviews.littlepay.interfaces.IStopsUpdater;
import org.emad.interviews.littlepay.repositories.LineChargeRepository;
import org.emad.interviews.littlepay.repositories.StopRepository;

import java.util.Optional;

public class StopService
        implements IStopsUpdater {
    @Override
    public void updateStops() {
        StopRepository.STOPS.values().forEach(stop -> {
            Optional<Float> maxCharge = LineChargeRepository.LINE_CHARGES.values().stream()
                    .filter(lineCharge -> lineCharge.getLine().isStopIn(stop))
                    .map(LineCharge::getChargeAmount)
                    .max(Float::compareTo);
            stop.setMaxCharge(maxCharge.orElse(0.0f));
        });
    }
}
