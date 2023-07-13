package com.hs.util;

import org.apache.log4j.Logger;

import java.sql.Timestamp;

public class DateTimeFormat {

   static Logger logger=Logger.getLogger(DateTimeFormat.class);

    public static Timestamp dateTime_Lacal(String time) {
        char[] times = time.toCharArray();
        times[10] = ' ';
        String timeStr = "";
        for (int i = 0; i < times.length; i++) {
            timeStr += times[i];
        }
        timeStr += ":00";
        logger.info(timeStr);
        Timestamp dateTime = Timestamp.valueOf(timeStr);
        return dateTime;
    }
}
