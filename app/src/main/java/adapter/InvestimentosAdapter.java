package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.criptoganhos.R;

import java.util.List;

import model.BaseCalls;
import model.CallCoins;
import model.CoinCallback;
import model.InvestimentosItem;

public class InvestimentosAdapter extends RecyclerView.Adapter<InvestimentosAdapter.ViewHolder>{

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView moeda, percentual, valAtual, valComprado, qtdMoeda, saldo;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            moeda = itemView.findViewById(R.id.txtMoeda);
            qtdMoeda = itemView.findViewById(R.id.txtResultQtd);
            percentual = itemView.findViewById(R.id.txtResultPercent);
            valAtual = itemView.findViewById(R.id.txtResultAtual);
            valComprado = itemView.findViewById(R.id.txtResultComprado);
            saldo = itemView.findViewById(R.id.txtResultSaldo);
        }
    }

    private final List<InvestimentosItem> investList;
    public InvestimentosAdapter(List<InvestimentosItem> invest) {
        investList = invest;
    }

    @NonNull
    @Override
    public InvestimentosAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View investView = inflater.inflate(R.layout.investimentos_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(investView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull InvestimentosAdapter.ViewHolder holder, int position) {
        InvestimentosItem investimento = investList.get(position);
        CallCoins callCoins = new CallCoins();
        BaseCalls baseCalls = new BaseCalls();

        String moeda = holder.moeda.getText().toString();

        holder.moeda.setText(investimento.getMoeda());
        holder.valComprado.setText(investimento.getValComprado());
        holder.qtdMoeda.setText(investimento.getQtdMoeda());
        holder.valAtual.setText(investimento.getValAtual());

        switch (moeda){
            case "DOGE":
                break;

            case "BTC":
                break;

            case "BNB":
                break;

            case "LINK":
                break;

            case "LTC":
                break;

            case "ADA":
                break;

            case "ETH":
                break;

            case "XRP":
                break;
        }


        if (moeda.equals("DOGE")){
            callCoins.callDOGE(new CoinCallback() {
                @Override
                public void CallSuccess(String lastPrice) {
                    holder.valAtual.setText(lastPrice);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return investList.size();
    }
}
