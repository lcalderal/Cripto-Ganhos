package helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import model.CallCoins;
import model.CoinCallback;
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
    public boolean salvar(InvestimentosItem investimento) {
        ContentValues cv = new ContentValues();

        cv.put("moeda", investimento.getMoeda());
        cv.put("val_comp", investimento.getValComprado());
        cv.put("qtd_moeda", investimento.getQtdMoeda());

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
    public boolean atualizar(InvestimentosItem investimento) {
        return false;
    }

    @Override
    public boolean deletar(InvestimentosItem investimento) {
        return false;
    }

    @Override
    public List<InvestimentosItem> listar() {
        List<InvestimentosItem> investimentos = new ArrayList<>();
        Cursor cursor = ler.rawQuery("SELECT * FROM coins", null);

        while (cursor.moveToNext()){
            String[] resultado = new String[5];
            resultado[0] = cursor.getString(cursor.getColumnIndex("moeda"));
            resultado[1] = cursor.getString(cursor.getColumnIndex("qtd_moeda"));
            resultado[2] = cursor.getString(cursor.getColumnIndex("val_comp"));
            resultado[3] = "Aguardando API...";

            investimentos.add(new InvestimentosItem(resultado));
        }
        cursor.close();
        return investimentos;
    }
}
