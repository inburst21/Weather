package iskills.com.weather.ui.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.ButterKnife;
import iskills.com.weather.R;
import iskills.com.weather.models.ResponseWeather;
import iskills.com.weather.utils.Utils;

/**
 * lennyhicks
 * 3/21/18
 */

public class AdapterWeatherHourly extends RecyclerView.Adapter<AdapterWeatherHourly.ViewHolderWeatherHourly> {

    private List<ResponseWeather.HourlyProperties.HourlyData> models;

    public AdapterWeatherHourly(List<ResponseWeather.HourlyProperties.HourlyData> models) {
        this.models = models;
    }

    public void setModels(List<ResponseWeather.HourlyProperties.HourlyData> models) {
        this.models = models;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolderWeatherHourly onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new ViewHolderWeatherHourly(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderWeatherHourly holder, int position) {
        holder.bindData(models.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.item_hourly_data;
    }

    @Override
    public int getItemCount() {
        return models.size();
    }


    class ViewHolderWeatherHourly extends RecyclerView.ViewHolder {

        TextView temp;
        TextView icon;
        TextView time;

        ViewHolderWeatherHourly(View itemView) {
            super(itemView);
            ButterKnife.bind(itemView);
            temp = itemView.findViewById(R.id.texttemp);
            icon = itemView.findViewById(R.id.texticon);
            time = itemView.findViewById(R.id.texttime);
        }

        void bindData(final ResponseWeather.HourlyProperties.HourlyData viewModel) {
            temp.setText(Utils.formatTemp(viewModel.getTemp()));
            icon.setText(Utils.getWeatherIcon(viewModel.getIcon()));
            time.setText(Utils.getTimeOfDay(viewModel.getTime()));
        }
    }
}