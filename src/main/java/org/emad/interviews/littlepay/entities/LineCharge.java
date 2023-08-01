package org.emad.interviews.littlepay.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LineCharge {

    private int id;
    private Line line;
    private float chargeAmount;
}
