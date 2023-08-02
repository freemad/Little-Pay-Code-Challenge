package org.emad.interviews.littlepay.interfaces;

import org.emad.interviews.littlepay.exceptions.BusinessException;

public interface ITripsWriter {

    void writeTrips(String tripsCsvFileAndPath) throws BusinessException;
}
