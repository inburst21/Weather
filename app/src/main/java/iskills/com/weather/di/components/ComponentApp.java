package iskills.com.weather.di.components;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import iskills.com.weather.WeatherApp;
import iskills.com.weather.di.modules.ActivityBuilder;
import iskills.com.weather.di.modules.ModuleApp;
import iskills.com.weather.di.modules.ModuleNet;

/**
 * lennyhicks
 * 3/15/18
 */

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        ModuleApp.class,
        ModuleNet.class,
        ActivityBuilder.class})
public interface ComponentApp extends AndroidInjector<WeatherApp> {

    @Singleton
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        ComponentApp build();
    }

}

