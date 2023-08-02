package org.emad.interviews.littlepay.repositories;

import org.emad.interviews.littlepay.entities.Card;

import java.util.HashMap;

public class CardRepository {

    public static HashMap<String, Card> CARDS = new HashMap<>();
    static {
        CARDS.put("5500005555555559", new Card(1, "5500005555555559"));
        CARDS.put("4111111111111111", new Card(2, "4111111111111111"));
    }
}

