package iskills.com.weather.api;

import iskills.com.weather.BuildConfig;
import iskills.com.weather.models.ResponseGoogleAddress;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * lennyhicks
 * 2/28/18
 */

public interface ApiGoogleGeo {
        @GET("json?api_key="+ BuildConfig.API_KEY_GOOGLEGEO)
        Observable<ResponseGoogleAddress> getAddress(@Query("address") String address);
}
