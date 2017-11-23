package com.example.denis.tecladov3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.Realm;
import io.realm.RealmResults;

import java.util.ArrayList;

import static android.R.attr.id;

public class CursoActivity extends AppCompatActivity {
    private int[] notas = new int[5];
    int posicao =0;
    MediaPlayer mp;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curso);
        Realm.init(this);
        //----------------------------

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Modulos");
    
        //-----------------------------
        SharedPreferences settings = getSharedPreferences(getString(R.string.preferencia), 0);
        final String result = settings.getString(getString(R.string.chave), null);


        if (result!="som") {

            mp = MediaPlayer.create(this, R.raw.aplausos);
            try {
                mp.start();
                Thread.sleep(500);
                mp.stop();
            } catch (InterruptedException e) {

            }
        }
        //----------------------------


        final ArrayList<Curso> curso = new ArrayList<>();
        Curso modulo01 = new Curso();
        modulo01.setAula("Aula 01 " );
        modulo01.setModulo("Modulo 01");
        modulo01.setHoras("2 horas");
        modulo01.setImagem(R.drawable.curso01);
        curso.add(modulo01);
        Curso modulo02 = new Curso();
        modulo02.setAula("Aula 02 " );
        modulo02.setModulo("Modulo 01 ");
        modulo02.setHoras("2 horas");
        modulo02.setImagem(R.drawable.curso02);
        curso.add(modulo02);
        Curso modulo03 = new Curso();
        modulo03.setAula("Aula 03" );
        modulo03.setModulo("Modulo 01 ");
        modulo03.setHoras("2 horas");
        modulo03.setImagem(R.drawable.curso03);
        curso.add(modulo03);
        Curso modulo04 = new Curso();
        modulo04.setAula("Aula 04" );
        modulo04.setModulo("Modulo 01 ");
        modulo04.setHoras("2 horas");
        modulo04.setImagem(R.drawable.curso04);
        curso.add(modulo04);


        final ListView lista = (ListView)findViewById(R.id.cursos);
        ArrayAdapter adapter = new CursoAdapter(CursoActivity.this, R.layout.listar_cursos,curso);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapter, View view,
                                    int posicao, long id) {
                // TODO Auto-generated method stub
               // Toast.makeText(CursoActivity.this,"Posição Selecionada:" + posicao, Toast.LENGTH_LONG).show();
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, InstrucaoActivity.class);
            startActivity(intent);
            // return true;
        }
        if (id == R.id.action_hitorico) {

            Intent intent = new Intent(this, Lista.class);
            startActivity(intent);
            // return true;
        }
        switch (item.getItemId()) {
            case android.R.id.home:  //ID do seu botão (gerado automaticamente pelo android, usando como está, deve funcionar
                //setContentView(R.layout.activity_curso);
                startActivity(new Intent(this, IntroducaoActivity.class));  //O efeito ao ser pressionado do botão (no caso abre a activity)
                finishAffinity();  //Método para matar a activity e não deixa-lá indexada na pilhagem
                return true;

            // break;


            default:
                return super.onOptionsItemSelected(item);
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.teclado, menu);

        return true;
    }


    private void alert(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

}
