package comw.example.user.Currency;

import android.app.Application;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application{

    private static ApiNationalBank apiNationalBank;
    private Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();

        // create OkHTTPClient
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
        okHttpClientBuilder.addInterceptor(logging);

        retrofit = new Retrofit.Builder().
                baseUrl("https://bank.gov.ua"). // базовая часть адреса
                addConverterFactory(GsonConverterFactory.create()). // конвертер необходимый для преобразования JSON-а в объекты
                client(okHttpClientBuilder.build()).
                build();

        apiNationalBank = retrofit.create(ApiNationalBank.class); // Создаем объект, при помощи которого будем выполнять запросы
    }
    public static ApiNationalBank getApi() {
        return apiNationalBank;
    }
}