package org.emad.interviews.littlepay.exceptions;

public interface IBusinessException {
    IErrorCode getErrorCode();

    String getAdditionalInfo();

    Throwable getCause();

    boolean isEnableSuppression();

    boolean isWritableStackTrace();
}
