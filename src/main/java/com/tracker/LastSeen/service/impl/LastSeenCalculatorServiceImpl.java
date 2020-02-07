package com.tracker.LastSeen.service.impl;

import com.tracker.LastSeen.constants.LastSeenConstants;
import com.tracker.LastSeen.enums.LastSeenDurationEnum;
import com.tracker.LastSeen.service.LastSeenCalculatorService;
import com.tracker.LastSeen.util.LastSeenHelper;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class LastSeenCalculatorServiceImpl implements LastSeenCalculatorService {
    @Override
    public String calculateDaysDifference(String lastSeenDateTime) {
        int minutes = 0, hours = 0, days = 0, months = 0, years = 0;
        String dateNow = new SimpleDateFormat(LastSeenConstants.DATE_FORMAT_PATTERN).format(new Date());
        try {
            Date d1 = new SimpleDateFormat(LastSeenConstants.DATE_FORMAT_PATTERN).parse(lastSeenDateTime);
            Date d2 = new SimpleDateFormat(LastSeenConstants.DATE_FORMAT_PATTERN).parse(dateNow);

            long diff = d2.getTime() - d1.getTime();
            if (diff < 0) {
                throw new IllegalArgumentException();
            }
//            System.out.println("Difference between  " + d1 + " and " + d2 + " is "
//                    + (diff / (1000 * 60 * 60 * 24)) + " days.");

            minutes = (int) ((diff > 0) ? (diff / (1000 * 60)) : 0);
            hours = (minutes > 0) ? (minutes / 60) : 0;
            days = (hours > 0) ? (hours / 24) : 0;
            months = (days > 0) ? (days / 30) : 0;
            years = (months > 0) ? (months / 12) : 0;

            if (years > 0) {
                return LastSeenHelper.getLastSeenInWords(years, LastSeenDurationEnum.YEARS);
            } else if (months > 0) {
                return LastSeenHelper.getLastSeenInWords(months, LastSeenDurationEnum.MONTHS);
            } else if (days > 0) {
                return LastSeenHelper.getLastSeenInWords(days, LastSeenDurationEnum.DAYS);
            } else if (hours > 0) {
                return LastSeenHelper.getLastSeenInWords(hours, LastSeenDurationEnum.HOURS);
            } else if (minutes > 0) {
                return LastSeenHelper.getLastSeenInWords(minutes, LastSeenDurationEnum.MINUTES);
            }
            return LastSeenConstants.ONLINE;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return LastSeenConstants.INVALID_TIME;
    }
}
