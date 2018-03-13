package iskills.com.weather.application.builder;

import dagger.Module;
import dagger.Provides;
import iskills.com.weather.api.ApiDarkSky;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * lennyhicks
 * 2/28/18
 */

@Module
public class ModuleServiceApiDarkSky {

    private static final String BASE_URL = "https://api.darksky.net/forecast/";

    @ScopeApp
    @Provides
    ApiDarkSky provideApiService(OkHttpClient client, GsonConverterFactory gson, RxJavaCallAdapterFactory rxAdapter) {
        Retrofit retrofit = new Retrofit.Builder().client(client)
                .baseUrl(BASE_URL).addConverterFactory(gson).
                        addCallAdapterFactory(rxAdapter).build();

        return retrofit.create(ApiDarkSky.class);
    }
}