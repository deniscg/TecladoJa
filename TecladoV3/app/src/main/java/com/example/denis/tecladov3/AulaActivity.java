package com.example.denis.tecladov3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import io.realm.Realm;

import static android.R.id.content;

public class AulaActivity extends AppCompatActivity {
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aula);
        //-----------------------------------------
         realm = Realm.getDefaultInstance();
        //-----------------------------------------
        final TextView output = (TextView) findViewById(R.id.aula01_M1_msg04_1);
        output.setMovementMethod(LinkMovementMethod.getInstance());
        //-------------------------------------
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("Seu titulo aqui");     //Titulo para ser exibido na sua Action Bar em frente à seta
        //-------------------------------------

        Button avan1 =(Button)findViewById(R.id.aula01_M1_btnaula01M1);
        avan1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {  //Estrutura do botão
                setContentView(R.layout.aula01_2);
            }
        });
        /*
        Button avan2 =(Button)findViewById(R.id.aula02_M1_btnaula022M1);
        avan2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {  //Estrutura do botão
                setContentView(R.layout.aula01_3);
            }
        });
        Button avan3 =(Button)findViewById(R.id.btnaula03M1);
        avan3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {  //Estrutura do botão
                setContentView(R.layout.aula01_4);
            }
        });
        Button avan4 =(Button)findViewById(R.id.btnaula04M1);
        avan4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {  //Estrutura do botão
                setContentView(R.layout.aula01_5);
            }
        });
        Button avan5 =(Button)findViewById(R.id.btnaula05M1);
        avan5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {  //Estrutura do botão
                Gerencia gerencia = new Gerencia();
                gerencia.setNome("Denis");
                gerencia.setEmail("denis@gmail.com");
                gerencia.setModulo("modulo01");
                gerencia.setNotas("1");

                long key2=realm.where(Gerencia.class).count();
                int numeroid =(int)key2;
                gerencia.getNome();
                gerencia.getEmail();
                gerencia.getId();
                gerencia.getModulo();
                gerencia.getNotas();

                realm.beginTransaction();
                realm.copyToRealm(gerencia);
                realm.commitTransaction();

                Intent intent = new Intent(AulaActivity.this, Aula02Activity.class);
                startActivity(intent);


            }
        });*/

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
    /* public void avancar(View v) {

       String tipodelayout = String.valueOf(R.layout.aula01_2);
        Intent intent = new Intent(getContext(), AulaActivity.class);
        Bundle params = new Bundle();
        params.putString("layout", tipodelayout);
        intent.putExtras(params);
        startActivity(intent);
        setContentView(R.layout.tela);
    }
    private Context getContext()
    {
        return this;
    }*/

    public void clickAction(View view){
        switch (view.getId()){
            case R.id.aula02_M1_btnaula022M1:
                setContentView(R.layout.aula01_3);
                break;
            case R.id.aula03_M1_btnaula03M1:
                setContentView(R.layout.aula01_4);
                break;
            case R.id.aula04_M1_btnaula04M1:
                setContentView(R.layout.aula01_5);
                break;
            case R.id.aula05_M1_btnaula05M1:
                Gerencia gerencia = new Gerencia();
                gerencia.setNome("Denis");
                gerencia.setEmail("denis@gmail.com");
                gerencia.setModulo("modulo01");
                gerencia.setNotas("1");

                long key2=realm.where(Gerencia.class).count();
                int numeroid =(int)key2;
                gerencia.getNome();
                gerencia.getEmail();
                gerencia.getId();
                gerencia.getModulo();
                gerencia.getNotas();

                realm.beginTransaction();
                realm.copyToRealm(gerencia);
                realm.commitTransaction();

                Intent intent = new Intent(AulaActivity.this, Aula02Activity.class);
                startActivity(intent);

                break;

        }
    }
}
