package iskills.com.weather.api;

import iskills.com.weather.BuildConfig;
import iskills.com.weather.models.ResponseWeather;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * lennyhicks
 * 2/28/18
 */

public interface ApiDarkSky {
    @GET( BuildConfig.API_KEY_DARKSKY + "/{latitude},{longitude}")
    Observable<ResponseWeather> getWeather(@Path("latitude") double latitude, @Path("longitude")
            double longitude);
}