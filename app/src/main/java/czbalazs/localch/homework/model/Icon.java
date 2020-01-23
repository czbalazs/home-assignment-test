package czbalazs.localch.homework.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Icon implements Serializable {

    @SerializedName("src")
    private String urlString;

    public String getUrlString() {
        return urlString;
    }
}
