package czbalazs.localch.homework.repository;

import android.util.Log;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import czbalazs.localch.homework.model.Restaurant;
import czbalazs.localch.homework.model.response.RestaurantResponse;
import czbalazs.localch.homework.networking.ApiService;
import czbalazs.localch.homework.networking.NetworkManager;
import czbalazs.localch.homework.repository.interfaces.RestaurantRepositoryInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RestaurantRepository implements RestaurantRepositoryInterface {

    private ApiService apiService;

    private final MutableLiveData<List<Restaurant>> data = new MutableLiveData<>();

    public RestaurantRepository() {
        apiService = NetworkManager.getInstance();
    }

    @Override
    public LiveData<List<Restaurant>> fetchRestaurants() {
        apiService.fetchRestaurants()
                .enqueue(new Callback<RestaurantResponse>() {
                    @Override
                    public void onResponse(Call<RestaurantResponse> call, Response<RestaurantResponse> response) {
                        if (response.body() != null) {
                            data.setValue(response.body().getRestaurants());
                        }

                }

                @Override
                public void onFailure(Call<RestaurantResponse> call, Throwable t) {
                        // TODO: Do proper error handling
                        Log.e(RestaurantRepository.class.toString(),
                                "fetchRestaurants failure: " + t.getMessage());
                }
        });

        return data;
    }

}
