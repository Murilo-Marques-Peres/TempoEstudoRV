package com.example.newstudiescalc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.NossoViewHolder> {
    private ArrayList<Tempos> mlistTempos = new ArrayList<>();
    @NonNull
    @Override
    public NossoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itens, parent, false);
        NossoViewHolder viewHolder = new NossoViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NossoViewHolder holder, int position) {
        Tempos tempos = mlistTempos.get(position);
    }

    @Override
    public int getItemCount() {
        if(mlistTempos == null){
            return 0;
        }
        return mlistTempos.size();
    }


    public class NossoViewHolder extends RecyclerView.ViewHolder{
        NumberPicker mPrimeiraHora,mPrimeiroMinuto, mSegundaHora, mSegundoMinuto;
        Button mButtonCalcular;
        TextView mTextViewTempo;

        public NossoViewHolder(@NonNull View itemView) {
            super(itemView);
            mPrimeiraHora = itemView.findViewById(R.id.primeiroNumber);
            mPrimeiroMinuto = itemView.findViewById(R.id.segundoNumber);
            mSegundaHora = itemView.findViewById(R.id.terceiroNumber);
            mSegundoMinuto = itemView.findViewById(R.id.quartoNumber);
            mButtonCalcular = itemView.findViewById(R.id.buttonCalcular);

            mPrimeiraHora.setMaxValue(24);
            mPrimeiraHora.setMinValue(0);
            mPrimeiroMinuto.setMaxValue(59);
            mPrimeiroMinuto.setMinValue(0);

            mSegundaHora.setMaxValue(24);
            mSegundaHora.setMinValue(0);
            mSegundoMinuto.setMaxValue(59);
            mSegundoMinuto.setMinValue(0);

            mTextViewTempo = itemView.findViewById(R.id.textViewTempo);

            mButtonCalcular.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mPrimeiroMinuto.getValue() < mSegundoMinuto.getValue()){
                        int diferencaMinutos1 = mSegundoMinuto.getValue() - mPrimeiroMinuto.getValue();
                        int diferencaHora1 = mSegundaHora.getValue() - mPrimeiraHora.getValue();
                        Toast.makeText(view.getContext(), String.valueOf(diferencaHora1) + "H:" + String.valueOf(diferencaMinutos1) + "Min", Toast.LENGTH_LONG).show();
                        mTextViewTempo.setText(String.valueOf(diferencaHora1) + "H:" + String.valueOf(diferencaMinutos1) + "Min");
                    }
                    if(mPrimeiroMinuto.getValue() > mSegundoMinuto.getValue()){
                        int min1 = 60 - mPrimeiroMinuto.getValue() + mSegundoMinuto.getValue();
                        int hora1 = mSegundaHora.getValue() - (mPrimeiraHora.getValue() + 1);
                        mTextViewTempo.setText(String.valueOf(hora1) + "H:" + String.valueOf(min1) + "Min");
                        Toast.makeText(view.getContext(), String.valueOf(hora1) + "H:" + String.valueOf(min1) + "Min", Toast.LENGTH_LONG).show();
                    }
                    if(mPrimeiroMinuto.getValue() == mSegundoMinuto.getValue()){
                        int diferencaHora = mSegundaHora.getValue() - mPrimeiraHora.getValue();
                        mTextViewTempo.setText(String.valueOf(diferencaHora) + "H:0Min");
                        Toast.makeText(view.getContext(), diferencaHora + "H:" + "0Min", Toast.LENGTH_LONG).show();
                    }

                    //Toast.makeText(view.getContext(), String.valueOf(mPrimeiraHora.getValue()), Toast.LENGTH_LONG).show();
                }
            });
        }
    }
    public void atualizarListagemCompleta(ArrayList<Tempos> mlistTempos) {
        this.mlistTempos = mlistTempos;
        notifyDataSetChanged();
    }

}
