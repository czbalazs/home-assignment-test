package czbalazs.localch.homework.model.response;

import com.google.gson.annotations.SerializedName;

public class Action {

    private String uri;

    private String type;

    @SerializedName("icon_url")
    private String iconUrl;

    public String getUri() {
        return uri;
    }

    public String getType() {
        return type;
    }

    public String getIconUrl() {
        return iconUrl;
    }
}
