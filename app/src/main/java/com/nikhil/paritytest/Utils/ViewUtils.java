package com.nikhil.paritytest.Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ViewUtils {

    public static String getDate(long milliSeconds, String dateFormat)
    {
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return formatter.format(calendar.getTime());
    }
}
