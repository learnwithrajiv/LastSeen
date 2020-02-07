package com.tracker.LastSeen.util;

import com.tracker.LastSeen.constants.LastSeenConstants;
import com.tracker.LastSeen.enums.LastSeenDurationEnum;

public class LastSeenHelper {

    public static String getLastSeenInWords (int timeGap, LastSeenDurationEnum lastSeenDurationEnum) {
        StringBuilder lastSeenInWords = new StringBuilder(LastSeenConstants.LAST_SEEN_TEXT);
        lastSeenInWords.append(LastSeenConstants.SPACE_DELIMITER);

        lastSeenInWords.append(timeGap + LastSeenConstants.SPACE_DELIMITER);
        switch (lastSeenDurationEnum) {
            case YEARS:
                lastSeenInWords.append((timeGap > 1) ? LastSeenDurationEnum.YEARS.getDuration() : LastSeenDurationEnum.YEAR.getDuration());
                break;
            case MONTHS:
                lastSeenInWords.append((timeGap > 1) ? LastSeenDurationEnum.MONTHS.getDuration() : LastSeenDurationEnum.MONTH.getDuration());
                break;
            case DAYS:
                lastSeenInWords.append((timeGap > 1) ? LastSeenDurationEnum.DAYS.getDuration() : LastSeenDurationEnum.DAY.getDuration());
                break;
            case HOURS:
                lastSeenInWords.append((timeGap > 1) ? LastSeenDurationEnum.HOURS.getDuration() : LastSeenDurationEnum.HOUR.getDuration());
                break;
            case MINUTES:
                lastSeenInWords.append((timeGap > 1) ? LastSeenDurationEnum.MINUTES.getDuration() : LastSeenDurationEnum.MINUTE.getDuration());
                break;
            default:

        }
        lastSeenInWords.append(LastSeenConstants.SPACE_DELIMITER);
        lastSeenInWords.append(LastSeenConstants.AGO);
        return lastSeenInWords.toString();
    }
}
