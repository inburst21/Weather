package iskills.com.weather.application;

import android.app.Application;
import android.util.Log;

import com.squareup.leakcanary.LeakCanary;

import iskills.com.weather.BuildConfig;
import iskills.com.weather.application.builder.ComponentApp;
import iskills.com.weather.application.builder.DaggerComponentApp;
import iskills.com.weather.application.builder.ModuleAppContext;
import iskills.com.weather.models.ResponseGoogleAddress;
import timber.log.Timber;

/**
 * lennyhicks
 * 2/28/18
 */

public class AppController extends Application {

    private static ComponentApp appComponent;
    ResponseGoogleAddress.GoogleLocation location;

    @Override
    public void onCreate() {
        super.onCreate();
        initialiseLogger();
        initAppComponent();

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);

    }

    private void initAppComponent() {
        appComponent = DaggerComponentApp.builder().moduleAppContext(new ModuleAppContext(this)).build();

        appComponent.apiServiceGoogleGeo().getAddress("Paintsville, KY").asObservable().doOnNext(response ->
                location = response.getResults().get(0).getGeometry().getLocation());
        appComponent.apiServiceDarkSky()
                .getWeather(location.getLatitude(), location.getLatitude())
                .doOnNext(responseWeather -> Log.i("Weather", responseWeather.getCurrentProperties().getSummary()));
    }


    private void initialiseLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new Timber.Tree() {
                @Override
                protected void log(int priority, String tag, String message, Throwable t) {
                    //TODO  decide what to log in release version
                }
            });
        }
    }

    public static ComponentApp getNetComponent() {
        return appComponent;
    }
}
