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

    private ViewMain viewMain;
    private ApiGoogleGeo apiGoogleGeo;
    private ApiDarkSky apiDarkSky;
    private boolean searching = true;

    @Inject
    ImplPresenterMain(ViewMain viewMain, ApiGoogleGeo apiGoogleGeo, ApiDarkSky apiDarkSky) {
        this.viewMain = viewMain;
        this.apiGoogleGeo = apiGoogleGeo;
        this.apiDarkSky = apiDarkSky;
    }


    @Override
    public void getWeather(String address) {
        viewMain.showLoading(true);
        apiGoogleGeo.getAddress(address)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(responseGoogleAddress -> {
                    if (responseGoogleAddress.getResults().size() > 0) {
                        viewMain.setLocation(responseGoogleAddress.getResults().get(0).getAddressName());
                        ResponseGoogleAddress.GoogleLocation location = responseGoogleAddress.getResults().get(0).getGeometry().getLocation();
                        getWeatherForLocation(location);
                        viewMain.showLoading(false);
                    } else if (responseGoogleAddress.getErrorMessage() != null) {
                        viewMain.showError(responseGoogleAddress.getErrorMessage());
                        searching = true;
                        viewMain.showSearch(searching);
                        viewMain.showLoading(false);
                    }
                }, throwable -> viewMain.showError(throwable.getMessage()));
    }

    @Override
    public void handleSearchButton() {
        if(searching){
            if(!viewMain.getLocation().isEmpty()) {
                getWeather(viewMain.getLocation());
                searching = false;
            }
        } else {
            searching = true;
        }
        viewMain.showSearch(searching);
    }

    private void getWeatherForLocation(ResponseGoogleAddress.GoogleLocation location) {
        apiDarkSky.getWeather(location.getLatitude(), location.getLongitude())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(responseWeather -> {
                    viewMain.showWeather(responseWeather);
                }, throwable -> viewMain.showError(throwable.getMessage()));
        viewMain.showLoading(false);
    }
}
