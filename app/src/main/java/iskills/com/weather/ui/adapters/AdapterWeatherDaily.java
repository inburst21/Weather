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

public class AdapterWeatherDaily extends RecyclerView.Adapter<AdapterWeatherDaily.ViewHolderWeatherDaily> {

    private List<ResponseWeather.DailyProperties.DailyData> models;

    public AdapterWeatherDaily(List<ResponseWeather.DailyProperties.DailyData> models) {
        this.models = models;
    }

    public void setModels(List<ResponseWeather.DailyProperties.DailyData> models) {
        this.models = models;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolderWeatherDaily onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new ViewHolderWeatherDaily(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderWeatherDaily holder, int position) {
        holder.bindData(models.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.item_daily_data;
    }

    @Override
    public int getItemCount() {
        return models.size();
    }


    class ViewHolderWeatherDaily extends RecyclerView.ViewHolder {

        TextView temp;
        TextView tempMax;
        TextView icon;
        TextView time;

        ViewHolderWeatherDaily(View itemView) {
            super(itemView);
            ButterKnife.bind(itemView);
            temp = itemView.findViewById(R.id.texttemp);
            tempMax = itemView.findViewById(R.id.texttempmax);
            icon = itemView.findViewById(R.id.texticon);
            time = itemView.findViewById(R.id.texttime);
        }

        void bindData(final ResponseWeather.DailyProperties.DailyData viewModel) {
            temp.setText(Utils.formatTemp(viewModel.getTemperatureMin()));
            tempMax.setText(Utils.formatTemp(viewModel.getTemperatureMax()));
            icon.setText(Utils.getWeatherIcon(viewModel.getIcon()));
            time.setText(Utils.getDay(viewModel.getTime()));
        }
    }
}