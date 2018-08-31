package comw.example.user.Currency;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;;

public interface ApiNationalBank {

    @GET()
    Call<List<CurrencyData>> getCurrencyToday(@Url String url);

    @GET("/NBUStatService/v1/statdirectory/exchange?valcode={Valcode}&date={Date}&json")
    Call<List<CurrencyData>> getCurrencyCodeDate(@Path("Valcode") String valCode, @Path("Date") String date);
}
