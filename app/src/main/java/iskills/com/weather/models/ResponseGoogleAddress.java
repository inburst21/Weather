package iskills.com.weather.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * lennyhicks
 * 2/26/18
 */

public class ResponseGoogleAddress {
    @SerializedName("results")
    private List<Results> results;

    @SerializedName("error_message")
    private String errorMessage;

    public List<Results> getResults() {
        return results;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public class Results {

        @SerializedName("formatted_address")
        String addressName;

        @SerializedName("geometry")
        private Geometry geometry;

        public Geometry getGeometry() {
            return geometry;
        }

        public String getAddressName() {
            return addressName;
        }
    }

    public class Geometry {
        @SerializedName("location")
        private GoogleLocation location;

        public GoogleLocation getLocation() {
            return location;
        }
    }

    public class GoogleLocation {
        @SerializedName("lat")
        private double latitude;

        @SerializedName("lng")
        private double longitude;

        public double getLatitude() {
            return latitude;
        }

        public double getLongitude() {
            return longitude;
        }
    }
}

