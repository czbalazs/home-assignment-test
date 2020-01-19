package czbalazs.localch.homework.networking;

import czbalazs.localch.homework.model.response.RestaurantResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("/coding-session-rest-api/restaurants")
    Call<RestaurantResponse> fetchRestaurants();

}
