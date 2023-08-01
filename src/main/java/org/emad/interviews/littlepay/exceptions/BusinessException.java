package org.emad.interviews.littlepay.exceptions;

import lombok.Getter;

@Getter
public class BusinessException
        extends Exception
        implements IBusinessException {
    private static final long serialVersionUID = 1705011925175026136L;

    private final IErrorCode errorCode;
    private final String additionalInfo;
    private final Throwable cause;
    private final boolean enableSuppression;
    private final boolean writableStackTrace;

    public BusinessException(IErrorCode errorCode, Throwable cause) {
        this(errorCode, "", cause, false, true);
    }

    protected BusinessException(IErrorCode errorCode, String additionalInfo, Throwable cause,
                                boolean enableSuppression, boolean writableStackTrace) {
        super(errorCode.getMessage(), cause, enableSuppression, writableStackTrace);
        this.errorCode = errorCode;
        this.additionalInfo = additionalInfo;
        this.cause = cause;
        this.enableSuppression = enableSuppression;
        this.writableStackTrace = writableStackTrace;
    }
}
