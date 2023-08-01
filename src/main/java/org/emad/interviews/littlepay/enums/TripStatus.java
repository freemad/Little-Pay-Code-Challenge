package org.emad.interviews.littlepay.enums;

public enum TripStatus {
    COMPLETED ("COMPLETED"),
    UNCOMPLETED ("UNCOMPLETED"),
    CANCELLED ("CANCELLED");

    private final String status;

    TripStatus(String status) {
        this.status = status;
    }
}
