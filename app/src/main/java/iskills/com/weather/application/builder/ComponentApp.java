package iskills.com.weather.application.builder;

import dagger.Component;
import iskills.com.weather.api.ApiDarkSky;
import iskills.com.weather.api.ApiGoogleGeo;
import iskills.com.weather.utils.rx.RxSchedulers;

/**
 * lennyhicks
 * 2/28/18
 */

@ScopeApp
@Component(modules = {ModuleNetwork.class, ModuleAppContext.class, ModuleRx.class, ModuleServiceApiGoogleGeo.class, ModuleServiceApiDarkSky.class})
public interface ComponentApp {

    RxSchedulers rxSchedulers();

    ApiGoogleGeo apiServiceGoogleGeo();

    ApiDarkSky apiServiceDarkSky();

}
