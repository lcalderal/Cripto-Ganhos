package model;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CallCoins {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BinanceService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    BinanceService service = retrofit.create(BinanceService.class);

    public void callDOGE(final CoinCallback coinCallback){
        Call<Coins> requestDOGE = service.getDOGE();

        requestDOGE.enqueue(new Callback<Coins>() {

            @Override
            public void onResponse(Call<Coins> call, Response<Coins> response) {
                if (!response.isSuccessful()){
                    Log.e("-----------", "ERRO REQUEST: " + response.code());
                }

                Coins coinsInfo = response.body();
                coinCallback.CallSuccess(coinsInfo.getLastPrice());

                Log.d("-----------", "DOGE SYMBOL: " + coinsInfo.getSymbol());
                Log.d("-----------", "DOGE LASTPRICE: " + coinsInfo.getLastPrice());

            }

            @Override
            public void onFailure(Call<Coins> call, Throwable t) {
                Log.e("-----------", "ERRO: " + t.getMessage());
                Log.d("-----------", "ERROR DOGE");
            }
        });
    }

    public void callBTC(CoinCallback coinCallback){
        Call<Coins> requestBTC = service.getBTC();

        requestBTC.enqueue(new Callback<Coins>() {
            @Override
            public void onResponse(Call<Coins> call, Response<Coins> response) {
                if (!response.isSuccessful()){
                    Log.e("-----------", "ERRO REQUEST: " + response.code());
                }

                Coins coinsInfo = response.body();
                coinCallback.CallSuccess(coinsInfo.getLastPrice());

                Log.d("-----------", "BTC RESPONSE CODE: " + response.code());
                Log.d("-----------", "BTC SYMBOL: " + coinsInfo.getSymbol());
                Log.d("-----------", "BTC LASTPRICE: " + coinsInfo.getLastPrice());

            }

            @Override
            public void onFailure(Call<Coins> call, Throwable t) {
                Log.e("-----------", "ERRO: " + t.getMessage());
                Log.d("-----------", "ERROR BTC");
            }
        });
    }

    public void callLINK(CoinCallback coinCallback){
        Call<Coins> requestBTC = service.getLINK();

        requestBTC.enqueue(new Callback<Coins>() {
            @Override
            public void onResponse(Call<Coins> call, Response<Coins> response) {
                if (!response.isSuccessful()){
                    Log.e("-----------", "ERRO REQUEST: " + response.code());
                }

                Coins coinsInfo = response.body();
                coinCallback.CallSuccess(coinsInfo.getLastPrice());

                Log.d("-----------", "LINK RESPONSE CODE: " + response.code());
                Log.d("-----------", "LINK SYMBOL: " + coinsInfo.getSymbol());
                Log.d("-----------", "LINK LASTPRICE: " + coinsInfo.getLastPrice());

            }

            @Override
            public void onFailure(Call<Coins> call, Throwable t) {
                Log.e("-----------", "ERRO: " + t.getMessage());
                Log.d("-----------", "ERROR LINK");
            }
        });
    }

    public void callLTC(CoinCallback coinCallback){
        Call<Coins> requestBTC = service.getLTC();

        requestBTC.enqueue(new Callback<Coins>() {
            @Override
            public void onResponse(Call<Coins> call, Response<Coins> response) {
                if (!response.isSuccessful()){
                    Log.e("-----------", "ERRO REQUEST: " + response.code());
                }

                Coins coinsInfo = response.body();
                coinCallback.CallSuccess(coinsInfo.getLastPrice());

                Log.d("-----------", "LTC RESPONSE CODE: " + response.code());
                Log.d("-----------", "LTC SYMBOL: " + coinsInfo.getSymbol());
                Log.d("-----------", "LTC LASTPRICE: " + coinsInfo.getLastPrice());

            }

            @Override
            public void onFailure(Call<Coins> call, Throwable t) {
                Log.e("-----------", "ERRO: " + t.getMessage());
                Log.d("-----------", "ERROR LTC");
            }
        });
    }

    public void callBNB(CoinCallback coinCallback){
        Call<Coins> requestBTC = service.getBNB();

        requestBTC.enqueue(new Callback<Coins>() {
            @Override
            public void onResponse(Call<Coins> call, Response<Coins> response) {
                if (!response.isSuccessful()){
                    Log.e("-----------", "ERRO REQUEST: " + response.code());
                }

                Coins coinsInfo = response.body();
                coinCallback.CallSuccess(coinsInfo.getLastPrice());

                Log.d("-----------", "BNB RESPONSE CODE: " + response.code());
                Log.d("-----------", "BNB SYMBOL: " + coinsInfo.getSymbol());
                Log.d("-----------", "BNB LASTPRICE: " + coinsInfo.getLastPrice());

            }

            @Override
            public void onFailure(Call<Coins> call, Throwable t) {
                Log.e("-----------", "ERRO: " + t.getMessage());
                Log.d("-----------", "ERROR BNB");
            }
        });
    }

    public void callXRP(CoinCallback coinCallback){
        Call<Coins> requestBTC = service.getXRP();

        requestBTC.enqueue(new Callback<Coins>() {
            @Override
            public void onResponse(Call<Coins> call, Response<Coins> response) {
                if (!response.isSuccessful()){
                    Log.e("-----------", "ERRO REQUEST: " + response.code());
                }

                Coins coinsInfo = response.body();
                coinCallback.CallSuccess(coinsInfo.getLastPrice());

                Log.d("-----------", "XRP RESPONSE CODE: " + response.code());
                Log.d("-----------", "XRP SYMBOL: " + coinsInfo.getSymbol());
                Log.d("-----------", "XRP LASTPRICE: " + coinsInfo.getLastPrice());

            }

            @Override
            public void onFailure(Call<Coins> call, Throwable t) {
                Log.e("-----------", "ERRO: " + t.getMessage());
                Log.d("-----------", "ERROR XRP");
            }
        });
    }

    public void callADA(CoinCallback coinCallback){
        Call<Coins> requestBTC = service.getADA();

        requestBTC.enqueue(new Callback<Coins>() {
            @Override
            public void onResponse(Call<Coins> call, Response<Coins> response) {
                if (!response.isSuccessful()){
                    Log.e("-----------", "ERRO REQUEST: " + response.code());
                }

                Coins coinsInfo = response.body();
                coinCallback.CallSuccess(coinsInfo.getLastPrice());

                Log.d("-----------", "ADA RESPONSE CODE: " + response.code());
                Log.d("-----------", "ADA SYMBOL: " + coinsInfo.getSymbol());
                Log.d("-----------", "ADA LASTPRICE: " + coinsInfo.getLastPrice());

            }

            @Override
            public void onFailure(Call<Coins> call, Throwable t) {
                Log.e("-----------", "ERRO: " + t.getMessage());
                Log.d("-----------", "ERROR ADA");
            }
        });
    }

    public void callETH(CoinCallback coinCallback){
        Call<Coins> requestBTC = service.getETH();

        requestBTC.enqueue(new Callback<Coins>() {
            @Override
            public void onResponse(Call<Coins> call, Response<Coins> response) {
                if (!response.isSuccessful()){
                    Log.e("-----------", "ERRO REQUEST: " + response.code());
                }

                Coins coinsInfo = response.body();
                coinCallback.CallSuccess(coinsInfo.getLastPrice());

                Log.d("-----------", "ETH RESPONSE CODE: " + response.code());
                Log.d("-----------", "ETH SYMBOL: " + coinsInfo.getSymbol());
                Log.d("-----------", "ETH LASTPRICE: " + coinsInfo.getLastPrice());

            }

            @Override
            public void onFailure(Call<Coins> call, Throwable t) {
                Log.e("-----------", "ERRO: " + t.getMessage());
                Log.d("-----------", "ERROR ETH");
            }
        });
    }

}
