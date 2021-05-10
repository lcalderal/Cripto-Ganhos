package com.example.criptoganhos.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.criptoganhos.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import helper.DataBaseHelper;
import helper.InvestDAO;
import model.Investimento;
import model.InvestimentosItem;

public class CadastrarActivity extends AppCompatActivity {

    private Spinner spinner;
    private Button btnCadastrar;
    private EditText[] resultados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        getXML();
        createSpinner();

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCadastrarCLick();
            }
        });
    }

    private void createSpinner(){
        spinner.getBackground().setColorFilter(Color.parseColor("#2B8EE4"), PorterDuff.Mode.SRC_ATOP);

        List<String> coins = new ArrayList<>(Arrays.asList("Selecione uma moeda","BITCOIN", "ETHERUM", "LINK", "XRP", "BNB"));

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, coins);
        dataAdapter.setDropDownViewResource(R.layout.spinner_item);
        spinner.setAdapter(dataAdapter);
    }

    private void onCadastrarCLick(){
        String moeda = spinner.getSelectedItem().toString();
        String valComp = resultados[0].getText().toString();
        String qtdMoeda = resultados[1].getText().toString();

        DataBaseHelper db = new DataBaseHelper(getApplicationContext());
        //String[] dados = {moeda+";" + valComp+";" + qtdMoeda+";" + "aguardando host;aguardando host;aguardando host"};

        String[] dados = {moeda, valComp, qtdMoeda};

        InvestDAO investDAO = new InvestDAO(getApplicationContext());
        Investimento investimento = new Investimento(dados);

        investDAO.salvar(investimento);

//        if (spinner.getSelectedItem().toString().equals("Selecione uma moeda")){
//
//        }
    }

    private void getXML(){
        spinner = (Spinner) findViewById(R.id.spinner);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);

        resultados = new EditText[5];
        resultados[0] = findViewById(R.id.edtPreco);
        resultados[1] = findViewById(R.id.edtQtd);
    }
}