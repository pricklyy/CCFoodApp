package com.example.cc_food.account_load_image;

public class APIUtils {
    public static final String BASE_URL = "http://10.24.25.221/foodapp/";
    public static DataClient dataClient() {
        // gui va nhan du lieu ve
        return RetroFitClient.getClient(BASE_URL).create(DataClient.class);
    }
}
