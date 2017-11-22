package com.example.denis.tecladov3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import com.example.denis.tecladov3.InstrucaoActivity;

import org.w3c.dom.Text;

import butterknife.OnClick;

public class InstrucaoActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Switch estado;
    private Boolean block01;
    private Boolean block02;


    //@Bind(R.id.main_layout)
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrucao);
        //-------------------------------------
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("Configurações");     //Titulo para ser exibido na sua Action Bar em frente à seta
        //-------------------------------------
        //--------------------------------------------------------------
        estado = (Switch)findViewById(R.id.switch1);//Botão liga desliga
        //--------------------------------------------------------------
        SharedPreferences settings = getSharedPreferences(getString(R.string.preferencia), 0);
        final String result = settings.getString(getString(R.string.chave), null);
        TextView mostra = (TextView)findViewById(R.id.instru_txt01);
        mostra.setText(result);

       // sharedPreferences = getSharedPreferences(getString(R.string.preferencia), Context.MODE_PRIVATE);
       // final String result = sharedPreferences.getString(getString(R.string.chave), "");//instrucao

        //-------------------------------------------------------
        if (result!="som" ) {//&& block01
            Toast.makeText(InstrucaoActivity.this,"não achei:", Toast.LENGTH_LONG).show();
            estado.setOnCheckedChangeListener (null);
            estado.setChecked(true);
            block01=false;
        }else if ( result=="som" ){//result!="" &&  block02
            Toast.makeText(InstrucaoActivity.this," achei:", Toast.LENGTH_LONG).show();
            estado.setOnCheckedChangeListener (null);
            estado.setChecked(false);
            block02=false;
        }
        //--------------------------------------------------------
        //this.recreate();
       // estado.setOnCheckedChangeListener ((CompoundButton.OnCheckedChangeListener) InstrucaoActivity.this);
        //--------------------------------------------------------------

        estado.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                estado.setOnCheckedChangeListener(this);
                if(b){
                    try{
                        sharedPreferences = getSharedPreferences(getString(R.string.preferencia), 0);
                        editor = sharedPreferences.edit();
                        editor.remove(getString(R.string.chave));
                        editor.commit();
                        editor.apply();
                        editor.clear();
                        editor.commit();

                    }catch (Exception e){
                        Toast.makeText(InstrucaoActivity.this,"Não remove:", Toast.LENGTH_LONG).show();
                    }


                    Toast.makeText(InstrucaoActivity.this,"Ativado:", Toast.LENGTH_LONG).show();

                }else{
                    try{
                        SharedPreferences settings = getSharedPreferences(getString(R.string.preferencia), 0);
                        SharedPreferences.Editor editor = settings.edit();
                        editor.putString("chave","som");

                        //Confirma a gravação dos dados
                        editor.commit();

                    }catch (Exception e ){
                        Toast.makeText(InstrucaoActivity.this,"Nâo Salva:", Toast.LENGTH_LONG).show();
                    }

                    Toast.makeText(InstrucaoActivity.this,"Som desativado:", Toast.LENGTH_LONG).show();
                }

            }
        });


    }
    public boolean onOptionsItemSelected(MenuItem item) {
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


}
