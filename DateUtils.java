package net.anapsil.droidfolio.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by anapsil on 22/08/15.
 */
public class DateUtils {
    public static String convert(long milis, String pattern) {
        Date date = new Date(milis);
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);

        return sdf.format(date);
    }
}
