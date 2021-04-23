package helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.List;

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
    public boolean salvar(InvestimentosItem investimentosItem) {
        ContentValues cv = new ContentValues();
        cv.put("moeda", investimentosItem.getMoeda());
        cv.put("val_comp", investimentosItem.getValComprado());
        cv.put("qtd_moeda", investimentosItem.getQtdMoeda());

        try {
            escreve.insert(DataBaseHelper.TABELA_COINS,null, cv);
        }catch (Exception e){
            Log.e("INFODB", "Erro ao salvar os dados!" + e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public boolean atualizar(InvestimentosItem investimentosItem) {
        return false;
    }

    @Override
    public boolean deletar(InvestimentosItem investimentosItem) {
        return false;
    }

    @Override
    public List<InvestimentosItem> listar() {
        return null;
    }
}
