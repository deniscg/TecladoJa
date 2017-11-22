package com.example.denis.tecladov3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmConfiguration;

import static android.R.id.content;

public class AulaActivity extends AppCompatActivity {
    Realm realm;
    WebView mWebView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aula);
        try {
            //-----------------------------------------
            realm = Realm.getDefaultInstance();
            //-----------------------------------------
            //final TextView output = (TextView) findViewById(R.id.aula04_M1_btnaula04M1);
            //output.setMovementMethod(LinkMovementMethod.getInstance());

            //-------------------------------------
            getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
            getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
            getSupportActionBar().setTitle("Modulo01");     //Titulo para ser exibido na sua Action Bar em frente à seta
            //-------------------------------------

            ImageButton avan1 =(ImageButton)findViewById(R.id.aula01_M1_btnaula01M1);
            avan1.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {  //Estrutura do botão
                    setContentView(R.layout.aula01_2);
                }
            });

        }catch (Exception e){
            Toast.makeText(this," Erro no Inicio:", Toast.LENGTH_LONG).show();
        }
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
            case R.id.aula05_web:
                try{
                            mWebView.setWebViewClient(new MyBrowser());
                            mWebView.getSettings().setLoadsImagesAutomatically(true);
                            mWebView.getSettings().setJavaScriptEnabled(true);
                            mWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                            mWebView.loadUrl("https://www.youtube.com/watch?v=Hb82O8Ey8bg");;

                }catch (Exception e){
                    Toast.makeText(this," Erro no web:", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.aula05_M1_btnaula05M1:
                setContentView(R.layout.aula01_6);
                break;
            case R.id.aula06_M1_btnaula06M1:
                try{

                    DadosCurso dados = new DadosCurso();
                    long key=realm.where(DadosCurso.class).count();
                    dados.setId(String.valueOf(key));
                    dados.setHistorico("você concluiu 25% do curso");

                    realm.beginTransaction();
                    realm.copyToRealm(dados);
                    realm.commitTransaction();

                    Intent intent = new Intent(AulaActivity.this, Lista.class);
                    startActivity(intent);
                    Toast.makeText(this, "Histórico", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(this," Erro no banco:", Toast.LENGTH_LONG).show();
                }


                break;

        }
    }
    private class MyBrowser extends WebViewClient{
        public boolean overrideUrlLoanding(WebView view,String url){
            view.loadUrl(url);
            return true;
        }
    }
}
