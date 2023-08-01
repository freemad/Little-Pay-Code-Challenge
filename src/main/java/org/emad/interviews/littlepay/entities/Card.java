package org.emad.interviews.littlepay.entities;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Card {

    private long id;
    private String pan;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;
        return ((Card) o).getPan().equals(pan);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (pan == null ? 0 : pan.hashCode());
        return hash;
    }
}
