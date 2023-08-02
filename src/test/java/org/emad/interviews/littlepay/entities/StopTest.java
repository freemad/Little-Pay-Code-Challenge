package org.emad.interviews.littlepay.entities;

import org.junit.Assert;
import org.junit.Test;

public class StopTest {

    @Test
    public void whenMaxChargeIsDifferent_thenStopsAreEqual() {
        Stop stop1 = new Stop(1, "Stop1", 10.0f);
        Stop stop2 = new Stop(1, "Stop1", 20.0f);
        Assert.assertEquals(stop1, stop2);
    }
}
