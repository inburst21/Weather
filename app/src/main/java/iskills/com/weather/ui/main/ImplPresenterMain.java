package iskills.com.weather.ui.main;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import iskills.com.weather.api.ApiDarkSky;
import iskills.com.weather.api.ApiGoogleGeo;
import iskills.com.weather.models.ResponseGoogleAddress;

/**
 * lennyhicks
 * 3/15/18
 */

public class ImplPresenterMain implements IPresenterMain {

    ViewMain viewMain;
    ApiGoogleGeo apiGoogleGeo;
    ApiDarkSky apiDarkSky;

    @Inject
    ImplPresenterMain(ViewMain viewMain, ApiGoogleGeo apiGoogleGeo, ApiDarkSky apiDarkSky){
        this.viewMain = viewMain;
        this.apiGoogleGeo = apiGoogleGeo;
        this.apiDarkSky = apiDarkSky;
    }


    @Override
    public void getWeather(String address) {
        viewMain.showLoading(true);
        apiGoogleGeo.getAddress("Hindman")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(responseGoogleAddress -> {
                    if(responseGoogleAddress.getResults().size() > 0) {
                        ResponseGoogleAddress.GoogleLocation location = responseGoogleAddress.getResults().get(0).getGeometry().getLocation();
                        getWeatherForLocation(location);
                    } else if (responseGoogleAddress.getErrorMessage() != null) {
                        viewMain.showError(responseGoogleAddress.getErrorMessage());
                        viewMain.showLoading(false);
                    }
                });
    }

    private void getWeatherForLocation(ResponseGoogleAddress.GoogleLocation location){
        apiDarkSky.getWeather(location.getLatitude(), location.getLongitude())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(responseWeather -> {
                    viewMain.showWeather(responseWeather);
                    viewMain.showError(responseWeather.getCurrentProperties().getSummary());
                });
        viewMain.showLoading(false);
    }
}
