package com.example.denis.tecladov3;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CursoAdapter extends ArrayAdapter<Curso>{
    Context contexto;

    ArrayList<Curso> curso;
    public CursoAdapter(Context context, int resouce, ArrayList<Curso> objects){
        super(context, resouce,objects);//super executa um construtor da classe mae
        this.contexto = context;
        this.curso=objects;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View linhaView = LayoutInflater.from(contexto).inflate(R.layout.listar_cursos, parent,false);


        TextView modulo =(TextView)linhaView.findViewById(R.id.modulo);
        TextView aula =(TextView)linhaView.findViewById(R.id.aula);
        TextView horas =(TextView)linhaView.findViewById(R.id.horas);
        modulo.setText(curso.get(position).getModulo());
        aula.setText(curso.get(position).getAula());
        horas.setText(curso.get(position).getHoras());
        //-------------------------------------------------
        ImageView imagem =(ImageView)linhaView.findViewById(R.id.img);
        imagem.setImageResource(curso.get(position).getImagem());

        return linhaView;
    }

}
