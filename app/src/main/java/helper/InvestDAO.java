package helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import model.Investimento;
import model.InvestimentosItem;

public class InvestDAO implements InterfaceInvestDAO{

    private SQLiteDatabase escreve;
    private SQLiteDatabase ler;

    public InvestDAO(Context context) {
        DataBaseHelper db = new DataBaseHelper(context);

        escreve = db.getWritableDatabase();
        ler = db.getReadableDatabase();
    }

    @Override
    public boolean salvar(Investimento investimento) {
        ContentValues cv = new ContentValues();

        cv.put("moeda", investimento.getMoedaDB());
        cv.put("val_comp", investimento.getValCompradoDB());
        cv.put("qtd_moeda", investimento.getQtdMoedaDB());

        try {
            escreve.insert(DataBaseHelper.TABELA_COINS,null, cv);
            Log.d("INFO --------", "SALVOOOU");
        }catch (Exception e){
            Log.e("INFODB", "Erro ao salvar os dados!" + e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public boolean atualizar(Investimento investimento) {
        return false;
    }

    @Override
    public boolean deletar(Investimento investimento) {
        return false;
    }

    @Override
    public List<Investimento> listar() {
        return null;
    }
}
