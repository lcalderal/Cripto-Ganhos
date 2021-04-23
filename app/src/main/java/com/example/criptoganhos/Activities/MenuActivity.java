package com.example.criptoganhos.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.criptoganhos.R;

public class MenuActivity extends AppCompatActivity {

    private Button btnInvestimentos, btnCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        getXML();
        setButtonFunctions();
    }

    private void setButtonFunctions(){
        Intent cadastrarActivity = new Intent(this, CadastrarActivity.class);
        Intent investimentosActivity = new Intent(this, InvestimentosActivity.class);

        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(cadastrarActivity);
            }
        });

        btnInvestimentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(investimentosActivity);
            }
        });

    }

    private void getXML(){
        btnInvestimentos = (Button) findViewById(R.id.btnInvest);
        btnCadastro = (Button) findViewById(R.id.btnCadastrar);
    }
}