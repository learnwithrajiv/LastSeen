package com.tracker.LastSeen.serviceImpl;

import com.tracker.LastSeen.service.LastSeenCalculatorService;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class LastSeenCalculatorServiceImpl implements LastSeenCalculatorService {
    @Override
    public String calculateDaysDifference(String dateStart) {
        int minutes = 0, hours = 0, days = 0, months = 0, years = 0;
        String dateNow = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date());
        StringBuilder lastSeenInWords = new StringBuilder("Last seen ");
        try {
            Date d1 = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse(dateStart);
            Date d2 = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse(dateNow);

            long diff = d2.getTime() - d1.getTime();

//            System.out.println("Difference between  " + d1 + " and " + d2 + " is "
//                    + (diff / (1000 * 60 * 60 * 24)) + " days.");

            minutes = (int) ((diff > 0) ? (diff / (1000 * 60)) : 0);
            hours = (minutes > 0) ? (minutes / 60) : 0;
            days = (hours > 0) ? (hours / 24) : 0;
            months = (days > 0) ? (days / 30) : 0;
            years = (months > 0) ? (months / 12) : 0;

            if (years > 0) {
                lastSeenInWords.append((years > 1) ? (years + " years ago") : (years + " year ago"));
            } else if (months > 0) {
                lastSeenInWords.append((months > 1) ? (months + " months ago") : (months + " month ago"));
            } else if (days > 0) {
                lastSeenInWords.append((days > 1) ? (days + " days ago") : (days + " day ago"));
            } else if (hours > 0) {
                lastSeenInWords.append((hours > 1) ? (hours + " hours ago") : (hours + " hour ago"));
            } else if (minutes > 0) {
                lastSeenInWords.append((minutes > 1) ? (minutes + " minutes ago") : (minutes + " minute ago"));
            } else {
                lastSeenInWords = new StringBuilder("");
            }

            return lastSeenInWords.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
