package czbalazs.localch.homework.model;

import com.google.gson.annotations.SerializedName;

public class Icon {

    @SerializedName("src")
    private String urlString;

    public String getUrlString() {
        return urlString;
    }
}
