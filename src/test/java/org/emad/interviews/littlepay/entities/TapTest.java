package org.emad.interviews.littlepay.entities;

import org.emad.interviews.littlepay.enums.TapType;
import org.emad.interviews.littlepay.utils.DateTimeUtil;
import org.junit.Assert;
import org.junit.Test;

public class TapTest {

    @Test
    public void whenTapDateTimeIsBeforeAnother_thenTapIsLessThanAnother() {
        Tap tap1 = new Tap(1L, DateTimeUtil.FromString("22-01-2023 13:04:59"),
                TapType.ON, new Stop(), new Company(), new Bus(), new Card());
        Tap tap2 = new Tap(1L, DateTimeUtil.FromString("22-01-2023 13:05:00"),
                TapType.ON, new Stop(), new Company(), new Bus(), new Card());
        Assert.assertEquals(-1, tap1.compareTo(tap2));
    }
}
