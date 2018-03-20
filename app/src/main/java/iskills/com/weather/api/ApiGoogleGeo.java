package iskills.com.weather.api;

import io.reactivex.Observable;
import iskills.com.weather.BuildConfig;
import iskills.com.weather.models.ResponseGoogleAddress;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * lennyhicks
 * 2/28/18
 */

public interface ApiGoogleGeo {
        String URL = "http://maps.googleapis.com/maps/api/geocode/";
        @GET("json?api_key="+ BuildConfig.API_KEY_GOOGLEGEO)
        Observable<ResponseGoogleAddress> getAddress(@Query("address") String address);
}
