package comw.example.user;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import retrofit2.http.Url;;

public interface ApiNationalBank {

    @GET()
    Call<List<CurrencyData>> getCurrencyToday(@Url String url);
}
