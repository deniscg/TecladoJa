package com.example.denis.tecladov3;

import android.content.Intent;
import android.location.Location;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.denis.tecladov3.UserModel;
import com.example.denis.tecladov3.LineAdapter;
import com.example.denis.tecladov3.Atualizar;

import java.util.ArrayList;
import java.util.List;


import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmResults;

public class Lista extends  AppCompatActivity  {
    final List<UserModel> livros = new ArrayList<UserModel>();
    Realm Consult_realm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        //-------------------------------------
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("Histórico");     //Titulo para ser exibido na sua Action Bar em frente à seta
        //-------------------------------------
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);

        Consult_realm = Realm.getDefaultInstance();
        try{
            final List<UserModel> livros = new ArrayList<UserModel>();
            RealmResults<DadosCurso> usuawrioview = Consult_realm.where(DadosCurso.class).findAll();
            for (DadosCurso itens:usuawrioview) {
                UserModel userModel = new UserModel();
                userModel.setNomeLivro(itens.getHistorico());
                livros.add(userModel);
            }

            recyclerView.setAdapter(new LineAdapter(livros, this));
            RecyclerView.LayoutManager layout = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
            recyclerView.setLayoutManager(layout);


        }
        catch (Exception e){
            Toast.makeText(this, "Deu Errado", Toast.LENGTH_SHORT).show();

        }

/*
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
        recyclerView.setAdapter(new LineAdapter(usuarioview, this));
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layout);*/

    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:  //ID do seu botão (gerado automaticamente pelo android, usando como está, deve funcionar
                //setContentView(R.layout.activity_curso);
                startActivity(new Intent(this, CursoActivity.class));  //O efeito ao ser pressionado do botão (no caso abre a activity)
                finishAffinity();  //Método para matar a activity e não deixa-lá indexada na pilhagem
                return true;
            // break;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
