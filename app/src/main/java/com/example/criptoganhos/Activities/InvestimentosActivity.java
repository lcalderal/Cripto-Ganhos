package com.example.criptoganhos.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.criptoganhos.R;

import java.util.ArrayList;
import java.util.List;

import adapter.InvestimentosAdapter;
import helper.DataBaseHelper;
import helper.InvestDAO;
import model.CallCoins;
import model.CoinCallback;
import model.InvestimentosItem;

public class InvestimentosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investimentos);

        setRecycleView();
    }

    private void setRecycleView(){
        RecyclerView rvInvestimentos = (RecyclerView) findViewById(R.id.list);

        InvestDAO investDAO = new InvestDAO(this);

        InvestimentosAdapter adapter = new InvestimentosAdapter(investDAO.listar());
        rvInvestimentos.setAdapter(adapter);
        rvInvestimentos.setLayoutManager(new LinearLayoutManager(this));
    }
}