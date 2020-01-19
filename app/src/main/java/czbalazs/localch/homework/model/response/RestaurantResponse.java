package czbalazs.localch.homework.model.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import czbalazs.localch.homework.model.Restaurant;

public class RestaurantResponse {

    @SerializedName("results")
    private List<Restaurant> restaurants;

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
