package org.emad.interviews.littlepay.exceptions;

public interface IErrorCode {
    int getCode();

    String getMessage();

    String getDetail();
}
