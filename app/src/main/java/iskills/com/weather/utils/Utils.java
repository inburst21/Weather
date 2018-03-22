package iskills.com.weather.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * lennyhicks
 * 2/27/18
 */

public class Utils {

    private static String getEmojiByUnicode(int unicode) {
        return new String(Character.toChars(unicode));
    }

    public static String getWeatherIcon(String weather) {
        return getEmojiByUnicode(Icons.getWeather(weather));
    }

    public static String formatTemp(double temperatureMin) {
        return Math.round(temperatureMin) + getEmojiByUnicode(Icons.degree);
    }

    public static String getDay(long time) {
        return formatTime(time).toString();
    }

    public static String getTimeOfDay(long time) {
        DateFormat dateFormat = new SimpleDateFormat("h a", Locale.getDefault());
        return dateFormat.format(formatTime(time));
    }

    public static String formatPrecip(double precipProbability) {
        return getWeatherIcon("rain") + Math.round(precipProbability) + "%";
    }

    //Timezone works at a JVM level so only has to be set once
    public static void setTimeZone(String timeZone) {
        TimeZone.setDefault(TimeZone.getTimeZone(timeZone));
    }

    private static Date formatTime(long time) {
        Timestamp timestamp = new Timestamp(time * 1000);
        return new Date(timestamp.getTime());
    }
}
