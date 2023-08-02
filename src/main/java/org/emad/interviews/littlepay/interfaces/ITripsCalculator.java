package org.emad.interviews.littlepay.interfaces;

import org.emad.interviews.littlepay.entities.Tap;
import org.emad.interviews.littlepay.exceptions.BusinessException;

import java.util.List;

public interface ITripsCalculator {

    void calculateTrips(List<Tap> taps) throws BusinessException;
}
