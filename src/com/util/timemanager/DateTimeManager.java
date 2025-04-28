package com.util.timemanager;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateTimeManager {
    
    public ZonedDateTime getCurrentTime(ZoneId zoneId) {
        return ZonedDateTime.now(zoneId);
    }

    public long getCurrentTimeInMillis(ZoneId zoneId) {
        return ZonedDateTime.now(zoneId).toInstant().toEpochMilli();
    }

    

    public DayOfWeek getWeekday(long millis, ZoneId zoneId) {
        return Instant.ofEpochMilli(millis).atZone(zoneId).getDayOfWeek();
    }

    public String getMonth(long millis, ZoneId zoneId) {
        return Instant.ofEpochMilli(millis).atZone(zoneId).getMonth().name();
    }

    public int getYear(long millis, ZoneId zoneId) {
        return Instant.ofEpochMilli(millis).atZone(zoneId).getYear();
    }
    
    public ZonedDateTime dstAdjustment(LocalDate date, LocalTime time, ZoneId zone) {
    	
    	 return  ZonedDateTime.of(date, time, zone);

      
    }
}




