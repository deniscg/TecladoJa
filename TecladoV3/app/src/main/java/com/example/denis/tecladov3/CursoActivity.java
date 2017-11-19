package com.example.denis.tecladov3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.Realm;
import io.realm.RealmResults;

import java.util.ArrayList;

public class CursoActivity extends AppCompatActivity {
    private int[] notas = new int[5];
    int posicao =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curso);
        Realm.init(this);


        final ArrayList<Curso> curso = new ArrayList<>();
        Curso teste = new Curso();
        for (int i=0;i<5;i++){
            teste.setNome("Teclado");
            teste.setAula("Aula " + String.valueOf(i));
            teste.setModulo("Modulo "+String.valueOf(i));
            teste.setHoras("2 horas");
            teste.setImagem(R.drawable.ic_menu_camera);
            curso.add(teste);
        }

        final ListView lista = (ListView)findViewById(R.id.cursos);
        ArrayAdapter adapter = new CursoAdapter(CursoActivity.this, R.layout.listar_cursos,curso);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapter, View view,
                                    int posicao, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(CursoActivity.this,"Posição Selecionada:" + posicao, Toast.LENGTH_LONG).show();
                if(posicao==0){
                    Intent intent = new Intent(CursoActivity.this, AulaActivity.class);
                    startActivity(intent);
                    //setContentView(R.layout.tela);
                }
            }
        });
    }
    public  void lanacarNotas(int nota){
        notas[posicao]=nota;
        posicao++;
    }
    public  int totalnotas( ){
        return posicao;
    }


}
