package iskills.com.weather.di.modules;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * lennyhicks
 * 3/15/18
 */

@Module
public class ModuleApp {

    @Provides
    @Singleton
    Application provideApplication(Application application) {
        return application;
    }

}
