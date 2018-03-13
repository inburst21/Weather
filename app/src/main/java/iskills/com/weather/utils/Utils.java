package iskills.com.weather.utils;

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
}
