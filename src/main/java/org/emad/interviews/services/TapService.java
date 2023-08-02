package org.emad.interviews.services;

import org.emad.interviews.littlepay.entities.Tap;
import org.emad.interviews.littlepay.enums.ErrorCode;
import org.emad.interviews.littlepay.exceptions.BusinessException;
import org.emad.interviews.littlepay.interfaces.ITapsReader;
import org.emad.interviews.littlepay.utils.CsvUtil;

import java.util.Collections;
import java.util.List;

public class TapService implements ITapsReader {

    public TapService() {
    }

    @Override
    public List<Tap> readTaps(String csvFile) throws BusinessException {
        try {
            List<Tap> taps = CsvUtil.GetTaps(csvFile);
            Collections.sort(taps);
            return taps;
        } catch (BusinessException e) {
            throw new BusinessException(ErrorCode.READ_TAPS_EXCEPTION, e);
        }
    }
}
