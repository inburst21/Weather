package iskills.com.weather.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.DaggerActivity;
import iskills.com.weather.R;
import iskills.com.weather.models.ResponseWeather;

/**
 * lennyhicks
 * 3/15/18
 */

public class ActivityMain extends DaggerActivity implements ViewMain {

    @Inject
    IPresenterMain presenterMain;

    @BindView(R.id.progressBar)
    ProgressBar loadingSpinner;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenterMain.getWeather("Hindman");
    }

    @Override
    public void showWeather(ResponseWeather responseWeather) {
        responseWeather.getCurrentProperties().getTemperature();
        responseWeather.getCurrentProperties().getIcon();
        responseWeather.getCurrentProperties().getTemperature();
    }

    @Override
    public void showError(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showLoading(boolean loading) {
        loadingSpinner.setVisibility(loading ? View.VISIBLE : View.GONE);
    }
}
