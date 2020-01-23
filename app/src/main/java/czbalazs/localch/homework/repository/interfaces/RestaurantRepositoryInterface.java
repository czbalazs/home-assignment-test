package czbalazs.localch.homework.repository.interfaces;

import java.util.List;

import androidx.lifecycle.LiveData;
import czbalazs.localch.homework.model.Restaurant;

public interface RestaurantRepositoryInterface {

    LiveData<List<Restaurant>> fetchRestaurants();

}
