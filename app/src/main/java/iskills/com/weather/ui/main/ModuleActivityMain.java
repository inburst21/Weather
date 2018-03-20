package iskills.com.weather.ui.main;

import dagger.Module;
import dagger.Provides;
import iskills.com.weather.api.ApiDarkSky;
import iskills.com.weather.api.ApiGoogleGeo;

/**
 * lennyhicks
 * 3/15/18
 */

@Module
public class ModuleActivityMain {

    @Provides
    ViewMain provideMainView(ActivityMain activityMain) {
        return activityMain;
    }

    @Provides
    IPresenterMain provideMainPresenter(ViewMain mainView, ApiGoogleGeo apiGoogleGeo, ApiDarkSky apiDarkSky) {
        return new ImplPresenterMain(mainView, apiGoogleGeo, apiDarkSky);
    }



}
