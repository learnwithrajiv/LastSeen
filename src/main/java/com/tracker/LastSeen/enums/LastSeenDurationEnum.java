package com.tracker.LastSeen.enums;

public enum LastSeenDurationEnum {
    YEARS("years"), YEAR("year"), MONTHS("months"), MONTH("month"), DAYS("days"), DAY("day"), HOURS("hours"), HOUR("hour"), MINUTES("minutes"), MINUTE("minute");

    private String duration;

    public String getDuration()
    {
        return this.duration;
    }

    private LastSeenDurationEnum(String duration)
    {
        this.duration = duration;
    }
}
