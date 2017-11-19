package com.example.denis.tecladov3;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by rafael on 27/12/16.
 */

public class Atualizar extends RecyclerView.ViewHolder{//NossoViewHolder

    final TextView nome;
    final Button deletar;
    //final TextView descricao;
   // final TextView preco;
   // final TextView autor;

    public Atualizar(View view) {
        super(view);
        nome = (TextView) view.findViewById(R.id.textview_nome);
        deletar =(Button) view.findViewById(R.id.deletar);
        // restante das buscas
    }





}


//-----------------
