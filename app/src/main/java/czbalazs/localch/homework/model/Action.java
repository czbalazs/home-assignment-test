package czbalazs.localch.homework.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Action implements Serializable {

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
