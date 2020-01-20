package czbalazs.localch.homework.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import czbalazs.localch.homework.R;
import czbalazs.localch.homework.model.Restaurant;

public class RestaurantListAdapter extends RecyclerView.Adapter<RestaurantListAdapter.RestaurantViewHolder> {

    private Context context;
    private List<Restaurant> restaurantList;

    public RestaurantListAdapter(Context context, List<Restaurant> restaurantList) {
        this.context = context;
        this.restaurantList = restaurantList;
    }

    @NonNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listing_restaurant_row, parent, false);
        return new RestaurantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantViewHolder holder, int position) {
        Restaurant restaurant = restaurantList.get(position);

        holder.titleTextView.setText(restaurant.getTitle());
        holder.subtitleTextView.setText(restaurant.getSubtitle());
        holder.categoriesTextView.setText(restaurant.getCategoriesFormatted());

        Glide.with(context)
                .load(restaurant.getIconHolder().getThumbnailIcon().getUrlString())
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(8)))
                .placeholder(R.drawable.process_animation)
                .into(holder.thumbnail);

        Glide.with(context)
                .load(restaurant.getPrimaryAction().getIconUrl())
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(8)))
                .placeholder(R.drawable.process_animation)
                .into(holder.primaryActionIcon);

        Glide.with(context)
                .load(restaurant.getIconHolder().getBadgeIconUrl())
                .centerCrop()
                .placeholder(R.drawable.process_animation)
                .into(holder.categoryIcon);

        holder.callView.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse(restaurant.getPrimaryAction().getUri()));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }

    public class RestaurantViewHolder extends RecyclerView.ViewHolder {

        private final ImageView thumbnail;
        private final RelativeLayout callView;
        private final ImageView primaryActionIcon;
        private final ImageView categoryIcon;
        private final TextView titleTextView;
        private final TextView subtitleTextView;
        private final TextView categoriesTextView;

        public RestaurantViewHolder(@NonNull View itemView) {
            super(itemView);

            thumbnail = itemView.findViewById(R.id.rest_listing_thumbnail);
            callView = itemView.findViewById(R.id.rest_listing_call_view);
            primaryActionIcon = itemView.findViewById(R.id.primary_action_button);
            categoryIcon = itemView.findViewById(R.id.rest_listing_category_icon);
            titleTextView = itemView.findViewById(R.id.rest_listing_title);
            subtitleTextView = itemView.findViewById(R.id.rest_listing_subtitle);
            categoriesTextView = itemView.findViewById(R.id.rest_listing_categories);
        }
    }
}
