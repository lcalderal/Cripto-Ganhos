package com.example.criptoganhos.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.opengl.GLDebugHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.criptoganhos.R;

import java.util.ArrayList;

import adapter.InvestimentosAdapter;
import adapter.RecyclerItemClickListener;
import helper.DataBaseHelper;
import model.InvestimentosItem;

public class InvestimentosActivity extends AppCompatActivity {

    ArrayList<InvestimentosItem> investimentosList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investimentos);

        setRecycleView();
    }

    private void setRecycleView(){
        RecyclerView rvInvestimentos = (RecyclerView) findViewById(R.id.list);

        DataBaseHelper db = new DataBaseHelper(getApplicationContext());

        String[] lista = {"BITCOIN;50%;R$ 7.500,00;R$ 5.500,00;1.2 BTC;R$ 2.500,00", "LINK;100%;R$ 10.000,00;R$ 5.000,00;1.0 BTC;R$ 5.000,00"};

        investimentosList = InvestimentosItem.createInvestimentosList(lista, 1);
        InvestimentosAdapter adapter = new InvestimentosAdapter(investimentosList);

        rvInvestimentos.setAdapter(adapter);
        rvInvestimentos.setLayoutManager(new LinearLayoutManager(this));
    }
}