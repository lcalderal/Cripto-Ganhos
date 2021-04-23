package helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    /** SEMPRE ATUALIZAR A VERSÃO DA TABELA EM UMA NOVA VERSÃO DE APP, CASO MUDE A TABELA*/
    public static int VERSION = 2;
    public static String NOME_DP = "DB_COINS";
    public static String TABELA_COINS = "coins";

    public DataBaseHelper(@Nullable Context context) {
        super(context, NOME_DP,null,  VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE IF NOT EXISTS " + TABELA_COINS +
                    " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    " moeda TEXT NOT NULL, " +
                    " val_comp  DECIMAL, " +
                    "qtd_moeda DECIMAL," +
                    " data DATE); ";

        try {
            db.execSQL(sql);
            Log.i("INFO DB", "Tabela criada!");

        }catch (Exception e){
            Log.i("INFO DB", "Erro ao criar a tabela" + e.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        /**AQUI VÃO OS COMANDO PARA ALTERAR A TABELA QUANDO O USUÁRIO RODAR O APP, COMO POR EXEMPLO, DROP TABLE E ALTER TABLE*/

        String sql = "DROP TABLE IF EXISTS " + TABELA_COINS + ";";

        try {
            db.execSQL(sql);
            onCreate(db);
            Log.i("INFO DB", "Tabela ATUALIZADA!");

        }catch (Exception e){
            Log.i("INFO DB", "Erro ao criar a tabela" + e.getMessage());
        }
    }
}
