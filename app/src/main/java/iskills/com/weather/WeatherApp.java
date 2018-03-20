package iskills.com.weather;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import iskills.com.weather.di.components.ComponentApp;
import iskills.com.weather.di.components.ComponentNet;
import iskills.com.weather.di.components.DaggerComponentApp;
import iskills.com.weather.di.components.DaggerComponentNet;

/**
 * lennyhicks
 * 3/15/18
 */

public class WeatherApp extends DaggerApplication {

    ComponentApp app;
    ComponentNet net;

    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        app = DaggerComponentApp.builder().application(this).build();
        net = DaggerComponentNet.create();
        return app;
    }
}
