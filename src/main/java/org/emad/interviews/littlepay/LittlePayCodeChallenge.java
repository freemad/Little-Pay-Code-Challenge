package org.emad.interviews.littlepay;

import org.emad.interviews.littlepay.entities.Tap;
import org.emad.interviews.littlepay.exceptions.BusinessException;
import org.emad.interviews.littlepay.services.StopService;
import org.emad.interviews.littlepay.services.TapService;
import org.emad.interviews.littlepay.services.TripService;

import java.util.List;

public class LittlePayCodeChallenge {
    public static void main(String[] args) {
        System.out.println("Hi Examiner! :)");

        StopService stopService = new StopService();
        stopService.updateStops();
        TapService tapService = new TapService();
        TripService tripService = new TripService();
        try {
            String tapsFile = args[0];
            String tripsFile = args[1];
            List<Tap> taps = tapService.readTaps(tapsFile);
            tripService.calculateTrips(taps);
            tripService.writeTrips(tripsFile);
        } catch (BusinessException e) {
            e.printStackTrace();
        }
    }
}
