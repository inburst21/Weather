package iskills.com.weather.ui.main;

import iskills.com.weather.models.ResponseWeather;

/**
 * lennyhicks
 * 3/15/18
 */

public interface ViewMain {
    void showWeather(ResponseWeather responseWeather);
    void showError(String errorMessage);
    void showLoading(boolean loading);
}
