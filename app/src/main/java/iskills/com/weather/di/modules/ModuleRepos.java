package iskills.com.weather.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import iskills.com.weather.api.ApiDarkSky;
import iskills.com.weather.api.ApiGoogleGeo;
import iskills.com.weather.di.qualifiers.GoogleGeo;
import iskills.com.weather.di.qualifiers.Weather;
import retrofit2.Retrofit;

/**
 * lennyhicks
 * 3/22/18
 */
@Module
public class ModuleRepos {

    @Singleton
    @Provides
    ApiDarkSky provideDarkSky(@Weather Retrofit retrofit){
        return retrofit.create(ApiDarkSky.class);
    }

    @Singleton
    @Provides
    ApiGoogleGeo provideGoogleGeo(@GoogleGeo Retrofit retrofit){
        return retrofit.create(ApiGoogleGeo.class);
    }
}
