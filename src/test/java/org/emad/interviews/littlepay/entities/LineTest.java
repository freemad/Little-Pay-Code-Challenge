package org.emad.interviews.littlepay.entities;

import org.junit.Assert;
import org.junit.Test;

public class LineTest {

    @Test
    public void whenLineStopsAreEqual_thenLinesAreEqual() {
        Stop stop1 = new Stop(1, "Stop1", 10.0f);
        Stop stop2 = new Stop(2, "Stop2", 20.0f);
        Line line1 = new Line(stop1, stop2);
        Line line2 = new Line(stop2, stop1);
        Assert.assertEquals(line1, line2);
    }

    @Test
    public void whenStopInLineStops_thenIsStopInReturnsTrue() {
        Stop stop1 = new Stop(1, "Stop1", 10.0f);
        Stop stop2 = new Stop(2, "Stop2", 20.0f);
        Line line = new Line(stop1, stop2);
        Assert.assertTrue(line.isStopIn(stop1));
    }

    @Test
    public void whenStopNotInLineStops_thenIsStopInReturnsFalse() {
        Stop stop1 = new Stop(1, "Stop1", 10.0f);
        Stop stop2 = new Stop(2, "Stop2", 20.0f);
        Stop stop3 = new Stop(3, "Stop3", 30.0f);
        Line line = new Line(stop1, stop2);
        Assert.assertFalse(line.isStopIn(stop3));
    }

}
