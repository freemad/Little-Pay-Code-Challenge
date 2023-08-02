package org.emad.interviews.littlepay.enums;

import org.emad.interviews.littlepay.exceptions.IErrorCode;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum ErrorCode implements IErrorCode {

    READ_TAPS_EXCEPTION(1001, "READ_TAPS_EXCEPTION", "READ_TAPS_EXCEPTION"),
    WRITE_TRIPS_EXCEPTION(1002, "WRITE_TRIPS_EXCEPTION", "WRITE_TRIPS_EXCEPTION"),
    TAP_OFF_WO_TAP_ON_EXCEPTION(1003, "TAP_OFF_WO_TAP_ON_EXCEPTION", "TAP_OFF_WO_TAP_ON_EXCEPTION"),
    IO_EXCEPTION(1004, "IO_EXCEPTION", "IO_EXCEPTION"),
    FILE_NOT_FOUND_EXCEPTION(1005, "FILE_NOT_FOUND_EXCEPTION", "FILE_NOT_FOUND_EXCEPTION");

    private final int code;
    private final String message;
    private final String detail;

    ErrorCode(int code, String message, String detail) {
        this.code = code;
        this.message = message;
        this.detail = detail;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getDetail() {
        return detail;
    }

    public static List<ErrorCode> getCodesAsList() {
        return Stream.of(ErrorCode.values()).collect(Collectors.toList());
    }
}
