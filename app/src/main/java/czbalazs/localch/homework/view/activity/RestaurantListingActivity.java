package czbalazs.localch.homework.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import czbalazs.localch.homework.R;
import czbalazs.localch.homework.model.Restaurant;
import czbalazs.localch.homework.view.adapter.RestaurantListAdapter;
import czbalazs.localch.homework.viewmodel.RestaurantViewModel;

public class RestaurantListingActivity extends AppCompatActivity {

    private static final Integer PAGE_SIZE = 10;

    private RestaurantViewModel restaurantViewModel;
    private RestaurantListAdapter adapter;
    private LinearLayoutManager layoutManager;

    private List<Restaurant> restaurants = new ArrayList<>();

    private ProgressBar progressBar;
    private RecyclerView restaurantRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_listing);

        initialization();

        getRestaurants();
    }

    private void initialization() {
        progressBar = findViewById(R.id.progress_circular);
        restaurantRecyclerView = findViewById(R.id.restaurants_recycler_view);

        layoutManager = new LinearLayoutManager(RestaurantListingActivity.this);
        restaurantRecyclerView.setLayoutManager(layoutManager);

        // improves performance
        restaurantRecyclerView.setHasFixedSize(true);

        adapter = new RestaurantListAdapter(RestaurantListingActivity.this, restaurants);
        restaurantRecyclerView.setAdapter(adapter);

        restaurantViewModel = ViewModelProvider.AndroidViewModelFactory
                                                .getInstance(getApplication())
                                                .create(RestaurantViewModel.class);

        restaurantRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int visibleItemCount = layoutManager.getChildCount();
                int totalItemCount = layoutManager.getItemCount();
                int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();

                if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount
                        && firstVisibleItemPosition >= 0
                        && totalItemCount >= PAGE_SIZE) {
                    restaurantViewModel.fetchNextRestaurantPage();
                }
            }
        });
    }

    private void getRestaurants() {
        restaurantViewModel.getRestaurants().observe(this, restaurantResponse -> {
            if (restaurantResponse != null) {
                restaurants.addAll(restaurantResponse);
                progressBar.setVisibility(View.GONE);
                adapter.notifyDataSetChanged();
            }
        });
    }

}
