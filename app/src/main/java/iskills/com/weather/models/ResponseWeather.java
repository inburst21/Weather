package iskills.com.weather.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * lennyhicks
 * 2/26/18
 */

public class ResponseWeather implements Parcelable {
    @SerializedName("latitude")
    private double latitude;

    @SerializedName("longitude")
    private double longitude;

    @SerializedName("currently")
    private CurrentProperties currentProperties;

    @SerializedName("daily")
    private DailyProperties dailyProperties;

    @SerializedName("hourly")
    private HourlyProperties hourlyProperties;

    @SerializedName("timezone")
    private String timezone;


    private ResponseWeather(Parcel in) {
        latitude = in.readDouble();
        longitude = in.readDouble();
    }

    public static final Creator<ResponseWeather> CREATOR = new Creator<ResponseWeather>() {
        @Override
        public ResponseWeather createFromParcel(Parcel in) {
            return new ResponseWeather(in);
        }

        @Override
        public ResponseWeather[] newArray(int size) {
            return new ResponseWeather[size];
        }
    };

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public CurrentProperties getCurrentProperties() {
        return currentProperties;
    }

    public DailyProperties getDailyProperties() {
        return dailyProperties;
    }

    public HourlyProperties getHourlyProperties() {
        return hourlyProperties;
    }

    public String getTimezone() {
        return timezone;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(latitude);
        parcel.writeDouble(longitude);
    }

    public class CurrentProperties {

        @SerializedName("summary")
        private String summary;

        @SerializedName("icon")
        private String icon;

        @SerializedName("temperature")
        private double temperature;

        @SerializedName("precipProbability")
        private double precipProbability;

        public String getSummary() {
            return summary;
        }

        public double getTemperature() {
            return temperature;
        }

        public String getIcon() {
            return icon;
        }

        public double getPrecipProbability() {
            return precipProbability;
        }
    }

    public class DailyProperties {

        @SerializedName("data")
        private List<DailyData> dailyData;

        public List<DailyData> getDailyData() {
            return dailyData;
        }

        public class DailyData {
            @SerializedName("temperatureMin")
            private double temperatureMin;

            @SerializedName("temperatureMax")
            private double temperatureMax;

            @SerializedName("precipProbability")
            private double precipProbability;

            @SerializedName("icon")
            private String icon;

            @SerializedName("time")
            private long time;

            public double getTemperatureMin() {
                return temperatureMin;
            }

            public double getTemperatureMax() {
                return temperatureMax;
            }

            public double getPrecipProbability() {
                return precipProbability;
            }

            public String getIcon() {
                return icon;
            }

            public long getTime() {
                return time;
            }
        }
    }

    public class HourlyProperties {

        @SerializedName("data")
        private List<HourlyData> hourlyData;

        public List<HourlyData> getHourlyData() {
            return hourlyData;
        }

        public class HourlyData {

            @SerializedName("time")
            private long time;

            @SerializedName("icon")
            private String icon;

            @SerializedName("temperature")
            private double temp;

            public long getTime() {
                return time;
            }

            public String getIcon() {
                return icon;
            }

            public double getTemp() {
                return temp;
            }
        }
    }
}