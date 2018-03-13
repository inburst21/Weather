package iskills.com.weather.application.builder;

import dagger.Module;
import dagger.Provides;
import iskills.com.weather.utils.rx.AppRxSchedulers;
import iskills.com.weather.utils.rx.RxSchedulers;

/**
 * lennyhicks
 * 2/28/18
 */

@Module
public class ModuleRx {

    @Provides
    RxSchedulers provideRxSchedulers() {
        return new AppRxSchedulers();
    }
}

