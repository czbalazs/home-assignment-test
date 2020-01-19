package czbalazs.localch.homework.model;

import com.google.gson.annotations.SerializedName;

public class RestaurantIconHolder {

    @SerializedName("result_list")
    private Icon thumbnailIcon;

    @SerializedName("list_badge")
    private String badgeIconUrl;

    public Icon getThumbnailIcon() {
        return thumbnailIcon;
    }

    public String getBadgeIconUrl() {
        return badgeIconUrl;
    }
}
