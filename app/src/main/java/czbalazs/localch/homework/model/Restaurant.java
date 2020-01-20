package czbalazs.localch.homework.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Restaurant {

    @SerializedName("title")
    private String title;

    @SerializedName("subtitle")
    private String subtitle;

    @SerializedName("categories")
    private List<Category> categories;

    @SerializedName("icons")
    private RestaurantIconHolder iconHolder;

    @SerializedName("primary_action")
    private Action primaryAction;

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public RestaurantIconHolder getIconHolder() {
        return iconHolder;
    }

    public Action getPrimaryAction() {
        return primaryAction;
    }

    public String getCategoriesFormatted() {
        StringBuilder stringBuilder = new StringBuilder();
        if (categories != null && categories.size() > 0) {
            for (Category category : categories) {
                stringBuilder.append(category.getName());
                stringBuilder.append(" · ");
            }
            stringBuilder.deleteCharAt(stringBuilder.length()-2);
        }
        return stringBuilder.toString();
    }

}
