package org.emad.interviews.littlepay.entities;

import org.junit.Assert;
import org.junit.Test;

public class CardTest {

    @Test
    public void whenPANIsEqual_thenCardsAreEqual() {
        String PAN = "4111111111111111";
        Card card1 = new Card(1L, PAN);
        Card card2 = new Card(2L, PAN);
        Assert.assertEquals(card1, card2);
    }

    @Test
    public void whenPANsNotEqual_thenCardsNotEqual() {
        String PAN1 = "4111111111111111";
        String PAN2 = "4111111111111112";
        Card card1 = new Card(1L, PAN1);
        Card card2 = new Card(2L, PAN2);
        Assert.assertNotEquals(card1, card2);
    }
}
