package com.example.criptoganhos.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.criptoganhos.R;

import model.BaseItems;

public class MenuActivity extends BaseItems {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        getXMLMenu();
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

}