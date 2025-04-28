package com.util.timemanager;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DstAutoAdjustment {
    public static void main(String[] args) {
        ZoneId zone = ZoneId.of("America/New_York");

        // Before DST starts 
        ZonedDateTime beforeDST = ZonedDateTime.of(2025, 3, 8, 12, 0, 0, 0, zone); // March 8, 2025
        System.out.println("Before DST Offset: " + beforeDST.getOffset());

        // After DST starts 
        ZonedDateTime afterDST = ZonedDateTime.of(2025, 3, 9, 12, 0, 0, 0, zone); // March 9, 2025
        System.out.println("After DST starts Offset: " + afterDST.getOffset());

        // After DST ends  
        ZonedDateTime afterDSTEnds = ZonedDateTime.of(2025, 11, 3, 12, 0, 0, 0, zone); // November 3, 2025
        System.out.println("After DST ends Offset: " + afterDSTEnds.getOffset());
    }
    
    // 
    
    
    
    
}
