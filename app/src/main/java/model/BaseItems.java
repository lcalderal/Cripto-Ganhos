package model;

import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.criptoganhos.R;

public class BaseItems extends AppCompatActivity {

//    public TextView valAtual, percentual, saldo, moeda;
    public Button btnInvestimentos, btnCadastro;

    public void getXMLMenu(){
        btnInvestimentos = (Button) findViewById(R.id.btnInvest);
        btnCadastro = (Button) findViewById(R.id.btnCadastrar);
    }

//    public void getXMLInvestimentos(){
//        valAtual = (TextView) findViewById(R.id.txtResultAtual);
//        percentual = (TextView) findViewById(R.id.txtResultPercent);
//        saldo = (TextView) findViewById(R.id.txtSaldo);
//        moeda = (TextView) findViewById(R.id.txtMoeda);
//    }
}
