package iskills.com.weather.di.components;

import javax.inject.Singleton;

import dagger.Component;
import iskills.com.weather.api.ApiDarkSky;
import iskills.com.weather.api.ApiGoogleGeo;
import iskills.com.weather.di.modules.ModuleNet;
import iskills.com.weather.di.modules.ModuleRepos;

/**
 * lennyhicks
 * 3/22/18
 */

@Singleton
@Component(modules = {ModuleNet.class, ModuleRepos.class})
public interface ComponentRepos {
    ApiDarkSky getWeather();
    ApiGoogleGeo getGoogleGeo();
}
