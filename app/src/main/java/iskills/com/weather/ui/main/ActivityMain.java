package iskills.com.weather.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.DaggerActivity;
import iskills.com.weather.R;
import iskills.com.weather.models.ResponseWeather;
import iskills.com.weather.ui.adapters.AdapterWeatherDaily;
import iskills.com.weather.ui.adapters.AdapterWeatherHourly;
import iskills.com.weather.utils.Utils;

/**
 * lennyhicks
 * 3/15/18
 */

public class ActivityMain extends DaggerActivity implements ViewMain {

    @Inject
    IPresenterMain presenterMain;

    @BindView(R.id.progressBar)
    ProgressBar loadingSpinner;

    @BindView(R.id.weatherLayout)
    ConstraintLayout weatherLayout;

    @BindView(R.id.currentTemp)
    TextView currentTemp;

    @BindView(R.id.currentIcon)
    TextView currentIcon;

    @BindView(R.id.currentPrecipChance)
    TextView currentPrecipChance;

    @BindView(R.id.viewSearch)
    EditText viewSearch;

    @BindView(R.id.textLocation)
    TextView textLocation;

    @BindView(R.id.buttonSearch)
    Button buttonSearch;

    @BindView(R.id.hourlyData)
    RecyclerView hourlyData;

    @BindView(R.id.dailyData)
    RecyclerView dailyData;

    AdapterWeatherHourly adapterWeatherHourly;
    AdapterWeatherDaily adapterWeatherDaily;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        LinearLayoutManager hourly = new LinearLayoutManager(this);
        hourly.setOrientation(LinearLayoutManager.HORIZONTAL);
        hourlyData.setLayoutManager(hourly);
        adapterWeatherHourly = new AdapterWeatherHourly(new ArrayList<>());
        hourlyData.setAdapter(adapterWeatherHourly);

        LinearLayoutManager daily = new LinearLayoutManager(this);
        daily.setOrientation(LinearLayoutManager.HORIZONTAL);
        dailyData.setLayoutManager(daily);
        adapterWeatherDaily = new AdapterWeatherDaily(new ArrayList<>());
        dailyData.setAdapter(adapterWeatherDaily);

        buttonSearch.setOnClickListener(view -> presenterMain.handleSearchButton());

        viewSearch.setOnKeyListener((view, i, keyEvent) -> {
            if (keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                presenterMain.handleSearchButton();
                return true;
            }
            return false;
        });

    }

    @Override
    public void showWeather(ResponseWeather responseWeather) {
        Utils.setTimeZone(responseWeather.getTimezone());
        currentTemp.setText(Utils.formatTemp(responseWeather.getCurrentProperties().getTemperature()));
        currentIcon.setText(Utils.getWeatherIcon(responseWeather.getCurrentProperties().getIcon()));
        currentPrecipChance.setText(Utils.formatPrecip(responseWeather.getCurrentProperties().getPrecipProbability()));
        adapterWeatherHourly.setModels(responseWeather.getHourlyProperties().getHourlyData());
        adapterWeatherDaily.setModels(responseWeather.getDailyProperties().getDailyData());
    }

    @Override
    public void showError(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showLoading(boolean loading) {
        loadingSpinner.setVisibility(loading ? View.VISIBLE : View.GONE);
        weatherLayout.setVisibility(loading ? View.GONE : View.VISIBLE);
    }

    @Override
    public String getLocation() {
        hideKeyboard();
        return viewSearch.getText().toString();
    }

    @Override
    public void setLocation(String addressName) {
        textLocation.setText(addressName);
    }

    @Override
    public void showSearch(boolean searching) {
        viewSearch.setVisibility(searching ? View.VISIBLE : View.GONE);
        textLocation.setVisibility(searching ? View.GONE : View.VISIBLE);
    }

    private void hideKeyboard(){
        InputMethodManager imm = (InputMethodManager)this.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(viewSearch.getWindowToken(), 0);
    }

}
