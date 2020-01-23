package czbalazs.localch.homework.view.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import czbalazs.localch.homework.R;
import czbalazs.localch.homework.model.Restaurant;

public class RestaurantDetailActivity extends AppCompatActivity {

    public static final String RESTAURANT_EXTRA_KEY = "restaurant";

    private Restaurant restaurant;
    private TextView titleTextView;
    private TextView subtitleTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_details);

        initialize();
        setupUI();
    }

    private void initialize() {
        titleTextView = findViewById(R.id.rest_detail_title);
        subtitleTextView = findViewById(R.id.rest_detail_subtitle);

        restaurant = (Restaurant) getIntent().getExtras().getSerializable(RESTAURANT_EXTRA_KEY);
    }

    private void setupUI() {
        titleTextView.setText(restaurant.getTitle());
        subtitleTextView.setText(restaurant.getSubtitle());
    }
}
