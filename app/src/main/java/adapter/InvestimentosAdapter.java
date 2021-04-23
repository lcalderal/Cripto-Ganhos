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

import model.InvestimentosItem;

public class InvestimentosAdapter extends RecyclerView.Adapter<InvestimentosAdapter.ViewHolder>{

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView moeda, percentual, valAtual, valComprado, qtdMoeda, saldo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            moeda = itemView.findViewById(R.id.txtMoeda);
            percentual = itemView.findViewById(R.id.txtResultPercent);
            valAtual = itemView.findViewById(R.id.txtResultAtual);
            valComprado = itemView.findViewById(R.id.txtResultComprado);
            qtdMoeda = itemView.findViewById(R.id.txtResultQtd);
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
        InvestimentosItem investimentos = investList.get(position);

        holder.moeda.setText(investimentos.getMoeda());
        holder.percentual.setText(investimentos.getPercentual());
        holder.valAtual.setText(investimentos.getValAtual());
        holder.valComprado.setText(investimentos.getValComprado());
        holder.qtdMoeda.setText(investimentos.getQtdMoeda());
        holder.saldo.setText(investimentos.getSaldo());


    }

    @Override
    public int getItemCount() {
        //------------------- VERIFICAR AQUI PQ PODE DAR ERRO NO TAMANHO
        return 2;
    }
}
