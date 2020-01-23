package czbalazs.localch.homework.viewmodel;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import czbalazs.localch.homework.model.Restaurant;
import czbalazs.localch.homework.repository.RestaurantRepository;

public class RestaurantViewModel extends AndroidViewModel {

    private LiveData<List<Restaurant>> restaurants;
    private RestaurantRepository restaurantRepository;
    private boolean isLoading;

    public RestaurantViewModel(@NonNull Application application) {
        super(application);

        restaurantRepository = new RestaurantRepository();
        this.restaurants = restaurantRepository.fetchRestaurants();
    }


    public LiveData<List<Restaurant>> getRestaurants() {
        return restaurants;
    }

    public void fetchNextRestaurantPage() {
        restaurantRepository.fetchRestaurants();
    }
}
