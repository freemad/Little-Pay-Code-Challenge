package org.emad.interviews.services;

import lombok.Data;
import org.emad.interviews.littlepay.entities.Card;
import org.emad.interviews.littlepay.entities.Line;
import org.emad.interviews.littlepay.entities.Tap;
import org.emad.interviews.littlepay.entities.Trip;
import org.emad.interviews.littlepay.enums.ErrorCode;
import org.emad.interviews.littlepay.enums.TripStatus;
import org.emad.interviews.littlepay.exceptions.BusinessException;
import org.emad.interviews.littlepay.interfaces.ITripsCalculator;
import org.emad.interviews.littlepay.interfaces.ITripsWriter;
import org.emad.interviews.littlepay.repositories.LineChargeRepository;
import org.emad.interviews.littlepay.utils.CsvUtil;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
public class TripService
        implements ITripsCalculator, ITripsWriter {

    HashMap<Card, Tap> cardTapMap;
    List<Trip> trips;

    public TripService() {
        cardTapMap = new HashMap<>();
        trips = new ArrayList<>();

    }

    @Override
    public void calculateTrips(@NotNull List<Tap> taps) throws BusinessException {
        for (Tap tap :
                taps) {
            Trip trip = null;
            switch (tap.getTapType()) {
                case ON:
                    trip = handleTapOn(tap);
                    break;
                case OFF:
                    trip = handleTapOff(tap);
                    break;
            }
            if (trip != null) {
                trips.add(trip);
            }
        }
        // The rest of tapOns have no relevant tapOff, make UNCOMPLETED Trip of them
        for (Tap tapOn :
                cardTapMap.values()) {
            Trip trip = makeUncompletedTripByTap(tapOn);
            trips.add(trip);
        }
        cardTapMap.clear();
    }

    @NotNull
    private Trip handleTapOff(Tap tap) throws BusinessException {
        Trip trip;
        if (cardTapMap.containsKey(tap.getCard())) {
            Tap tapOn = popTapOnByCard(tap.getCard());
            // the card was tapped before
            if (!tap.getStop().equals(tapOn.getStop())) {
                trip = makeCompletedTripByTaps(tapOn, tap);
            } else {
                trip = makeCanceledTripByTaps(tapOn, tap);
            }
        } else {
            // A Tap-Off without relevant Tap-On occurred, It's a Potential Threat or a BUSINESS EXCEPTION
            throw new BusinessException(ErrorCode.TAP_OFF_WO_TAP_ON_EXCEPTION);
        }
        return trip;
    }

    private Trip handleTapOn(Tap tap) {
        Trip trip = null;
        if (cardTapMap.containsKey(tap.getCard())) {
            Tap tapOn = popTapOnByCard(tap.getCard());
            trip = makeUncompletedTripByTap(tapOn);
            cardTapMap.put(tap.getCard(), tap);
        } else {
            // No Tap with this Card in the Map, add it
            cardTapMap.put(tap.getCard(), tap);
        }
        return trip;
    }

    @Override
    public void writeTrips(String tripsCsvFileAndPath) throws BusinessException {
        try {
            CsvUtil.WriteTrips(tripsCsvFileAndPath, trips);
        } catch (BusinessException e) {
            throw new BusinessException(ErrorCode.WRITE_TRIPS_EXCEPTION, e);
        }
    }

    private @NotNull Trip makeCanceledTripByTaps(Tap tapOn, Tap tapOff) {
        Trip trip;
        // Passenger went nowhere, the Trip is CANCELED
        trip = new Trip(
                0L,
                tapOn,
                tapOff,
                0.0f,
                TripStatus.CANCELLED
        );
        return trip;
    }

    private @NotNull Trip makeCompletedTripByTaps(@NotNull Tap tapOn, @NotNull Tap tapOff) {
        //everything is normal, make a COMPLETED trip
        Line line1 = new Line(tapOff.getStop(), tapOn.getStop());
        return new Trip(
                0L,
                tapOn,
                tapOff,
                LineChargeRepository.LINE_CHARGES.get(line1).getChargeAmount(),
                TripStatus.COMPLETED
        );
    }

    @Contract("_ -> new")
    private @NotNull Trip makeUncompletedTripByTap(Tap tapOn) {
        // The Card is already topped-on and its Trip is UNCOMPLETED, make it,
        // remove previous TapOn and add new Tap to the map
        return new Trip(
                0L,
                tapOn,
                null,
                tapOn.getStop().getMaxCharge(),
                TripStatus.UNCOMPLETED
        );
    }

    private Tap popTapOnByCard(Card card) {
        Tap tapOn = cardTapMap.get(card);
        cardTapMap.remove(card);
        return tapOn;
    }
}
