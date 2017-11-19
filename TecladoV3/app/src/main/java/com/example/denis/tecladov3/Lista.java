package com.example.denis.tecladov3;

import android.location.Location;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.denis.tecladov3.UserModel;
import com.example.denis.tecladov3.LineAdapter;
import com.example.denis.tecladov3.Atualizar;

import java.util.ArrayList;
import java.util.List;


import butterknife.BindView;
import butterknife.ButterKnife;

public class Lista extends  AppCompatActivity  {
    final List<UserModel> livros = new ArrayList<UserModel>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        final UserModel obj = new UserModel();// = new UserModel("Denis","Autor","sucesso",1.2);// recupera do banco de dados ou webservice
        obj.setNomeAutor("Denis");
        obj.setDescricao("Autor");
        obj.setNomeLivro("Sucesso");
        obj.setPreco(1.2);
        livros.add(obj);
        obj.setNomeAutor("Lis");
        obj.setDescricao("Autora");
        obj.setNomeLivro("Sucesso");
        obj.setPreco(1.0);
        livros.add(obj);
        recyclerView.setAdapter(new LineAdapter(livros, this));
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layout);

    }


}
