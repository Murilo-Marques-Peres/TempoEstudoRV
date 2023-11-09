package com.example.newstudiescalc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Tempos> mListTempos;
    private RecyclerView rvListagem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int x = 0;

        mListTempos = new ArrayList<>();
        mListTempos.add(new Tempos(0,0,0,0));
        mListTempos.add(new Tempos(0,0,0,0));
        mListTempos.add(new Tempos(x,x,x,x));
        mListTempos.add(new Tempos(x,x,x,x));


        rvListagem = findViewById(R.id.rvListagem);
        rvListagem.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvListagem.setLayoutManager(layoutManager);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rvListagem.addItemDecoration(itemDecoration);

        Adaptador adaptador = new Adaptador();
        rvListagem.setAdapter(adaptador);
        adaptador.atualizarListagemCompleta(mListTempos);


    }
}