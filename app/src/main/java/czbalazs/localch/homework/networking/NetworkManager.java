package czbalazs.localch.homework.networking;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;;

public class NetworkManager {

    private static Retrofit retrofit;
    private static final String BASE_URL = "https://storage.googleapis.com/";

    public static ApiService getInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(ApiService.class);
    }

}
