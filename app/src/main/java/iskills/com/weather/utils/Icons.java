package iskills.com.weather.utils;

/**
 * lennyhicks
 * 2/27/18
 */

class Icons {
    private static int clear_day = 0x1F31E;
    private static int clear_night = 0x1F303;
    private static int rain = 0x2614;
    private static int snow = 0x2744;
    private static int sleet = snow;
    private static int wind = 0x1F343;
    private static int fog = 0x1F301;
    private static int cloudy = 0x2601;
    private static int partly_cloudy_day = 0x26C5;
    private static int partly_cloudy_night = cloudy;
    private static int unknown = 0x1F615;

    static int getWeather(String weather){
        switch (weather) {
            case "clear-day" : return clear_day;
            case "clear-night" : return clear_night;
            case "rain" : return rain;
            case "snow" : return snow;
            case "sleet" : return sleet;
            case "wind" : return wind;
            case "fog" : return fog;
            case "cloudy" : return cloudy;
            case "partly-cloudy-day" : return partly_cloudy_day;
            case "partly-cloudy-night" : return partly_cloudy_night;
            default: return unknown;
        }
    }
}