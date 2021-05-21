package model;


import retrofit2.Call;
import retrofit2.http.GET;

public interface BinanceService {

    public static final String BASE_URL = "https://api1.binance.com/api/v3/";

    //DogeCoin
    @GET("ticker/24hr?symbol=DOGEBRL")
    Call<Coins> getDOGE();

    //Bitcoin
    @GET("ticker/24hr?symbol=BTCBRL")
    Call<Coins> getBTC();

    //ChaiLink
    @GET("ticker/24hr?symbol=LINKBRL")
    Call<Coins> getLINK();

    //Ethereum
    @GET("ticker/24hr?symbol=ETHBRL")
    Call<Coins> getETH();

    //LiteCoin
    @GET("ticker/24hr?symbol=LTCBRL")
    Call<Coins> getLTC();

    //Binance
    @GET("ticker/24hr?symbol=BNBBRL")
    Call<Coins> getBNB();

    //XRP
    @GET("ticker/24hr?symbol=XRPBRL")
    Call<Coins> getXRP();

    //Cardano
    @GET("ticker/24hr?symbol=ADABRL")
    Call<Coins> getADA();

}