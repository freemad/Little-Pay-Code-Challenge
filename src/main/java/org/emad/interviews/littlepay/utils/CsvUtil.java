package org.emad.interviews.littlepay.utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.emad.interviews.littlepay.entities.Tap;
import org.emad.interviews.littlepay.entities.Trip;
import org.emad.interviews.littlepay.enums.ErrorCode;
import org.emad.interviews.littlepay.enums.TapType;
import org.emad.interviews.littlepay.exceptions.BusinessException;
import org.emad.interviews.littlepay.repositories.BusRepository;
import org.emad.interviews.littlepay.repositories.CardRepository;
import org.emad.interviews.littlepay.repositories.CompanyRepository;
import org.emad.interviews.littlepay.repositories.StopRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvUtil {

    private static final String[] TAPS_CSV_HEADER = {"ID", "DateTimeUTC", "TapType", "StopId", "CompanyId", "BusID", "PAN"};
    private static final String[] TRIPS_CSV_HEADER = {"Started", "Finished", "DurationSecs", "FromStopId", "ToStopId", "ChargeAmount", "CompanyId", "BusID", "PAN", "Status"};
    private static final String DELIMITER = ", ";

    public static List<Tap> GetTaps(String csvFilePath) throws BusinessException {
        Reader reader = null;
        Iterable<CSVRecord> csvTaps = null;
        try {
            reader = new FileReader(csvFilePath);
            CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                    .setHeader(TAPS_CSV_HEADER)
                    .setSkipHeaderRecord(true)
                    .setDelimiter(DELIMITER)
                    .build();
            csvTaps = csvFormat.parse(reader);
        } catch (FileNotFoundException e) {
            throw new BusinessException(ErrorCode.FILE_NOT_FOUND_EXCEPTION, e);
        } catch (IOException e) {
            throw new BusinessException(ErrorCode.IO_EXCEPTION, e);
        }
        List<Tap> taps = new ArrayList<>();
        for (CSVRecord record :
                csvTaps) {
            taps.add(new Tap(
                            Long.getLong(record.get("ID")),
                            DateTimeUtil.FromString(record.get("DateTimeUTC")),
                            TapType.valueOf(record.get("TapType")),
                            StopRepository.STOPS.get(record.get("StopId")),
                            CompanyRepository.COMPANIES.get(record.get("CompanyId")),
                            BusRepository.BUSES.get(record.get("BusID")),
                            CardRepository.CARDS.get(record.get("PAN"))
                    )
            );
        }
        return taps;
    }

    public static void WriteTrips(String tripsCsvPathAndFile, List<Trip> trips) throws BusinessException {
//        StringWriter writer = new StringWriter();
        Writer writer = null;
        try {
            writer = new FileWriter(tripsCsvPathAndFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                .setHeader(TRIPS_CSV_HEADER)
                .setDelimiter(DELIMITER)
                .build();

        try (final CSVPrinter printer = new CSVPrinter(writer, csvFormat)) {
            trips.forEach((trip) -> {
                try {
                    printer.printRecord(
                            DateTimeUtil.ToString(trip.getTapOn().getDateTime()),
                            (trip.getTapOff() != null) ? DateTimeUtil.ToString(trip.getTapOff().getDateTime()) : "NA",
                            trip.getDuration(),
                            trip.getTapOn().getStop().getStopId(),
                            (trip.getTapOff() != null) ? trip.getTapOff().getStop().getStopId() : "NA",
                            "$" + trip.getChargeAmount(),
                            trip.getTapOn().getCompany().getCompanyId(),
                            trip.getTapOn().getBus().getBusId(),
                            trip.getTapOn().getCard().getPan(),
                            trip.getStatus()
                    );
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException | RuntimeException e) {
            throw new BusinessException(ErrorCode.IO_EXCEPTION, e);
        }
    }
}
