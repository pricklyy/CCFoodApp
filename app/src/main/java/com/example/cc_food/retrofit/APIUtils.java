package com.example.cc_food.retrofit;

public class APIUtils {
    public static final String BASE_URL = "http://192.168.2.102/foodapp/";
    public static DataClient dataClient(){
        // gui va nhan du lieu ve
        return RetroFitClient.getClient(BASE_URL).create(DataClient.class);
    }
}
