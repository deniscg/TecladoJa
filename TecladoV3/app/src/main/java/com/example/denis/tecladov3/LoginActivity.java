package com.example.denis.tecladov3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class LoginActivity extends AppCompatActivity {
    ImageButton logar;
    ImageButton cadastrar;
    Realm Inicio_realm;
    EditText email,senha;
    RealmResults<Cadastro> recebe;
    String um;
    String dois;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Inicio_realm = Realm.getDefaultInstance();
        logar = (ImageButton)findViewById(R.id.teclado_login2);
        logar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(LoginActivity.this, IntroducaoActivity.class);
               // startActivity(intent);
                //--------------------------------
                Cadastro usuarioview;
                String retor_Email="";
                String retor_Senha="";
                //---------------------------------

                email=(EditText)findViewById(R.id.editText);
                senha=(EditText)findViewById(R.id.editText2);
                String confirmEmail = email.getText().toString();
                String confirmSenha = senha.getText().toString();

                try{

                    usuarioview =Inicio_realm.where(Cadastro.class).equalTo("email", confirmEmail).findFirst();
                    retor_Email=usuarioview.getEmail().toString();
                    retor_Senha=usuarioview.getSenha().toString();
                }
                catch (Exception e){
                    Toast.makeText(LoginActivity.this, "Erro Banco", Toast.LENGTH_SHORT).show();
                }
                try{
                    if(confirmEmail!=retor_Email && confirmSenha!=retor_Senha){
                        Toast.makeText(LoginActivity.this, "Logado ", Toast.LENGTH_SHORT).show();
                        Intent intent2 = new Intent(LoginActivity.this, IntroducaoActivity.class);
                        startActivity(intent2);

                    }else{
                        Toast.makeText(LoginActivity.this, "Senha errada", Toast.LENGTH_SHORT).show();
                    }


                    /*
                    for (Cadastro itens:recebe) {
                        if(itens.getNome().equals(confirmEmail)){
                            Toast.makeText(LoginActivity.this, "Parabéns", Toast.LENGTH_SHORT).show();
                            Intent intent2 = new Intent(LoginActivity.this, IntroducaoActivity.class);
                            startActivity(intent2);
                        }else {
                            Toast.makeText(LoginActivity.this, "Senha incorreta", Toast.LENGTH_SHORT).show();
                            break;
                        }
                    }*/
                }
                catch (Exception e){
                    Toast.makeText(LoginActivity.this, "Erro no For", Toast.LENGTH_SHORT).show();
                }
            }

        });
        cadastrar = (ImageButton)findViewById(R.id.teclado_cadastra2);
        cadastrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {  //Estrutura do botão
                Intent intent = new Intent(LoginActivity.this, CadastroActivity.class);
                startActivity(intent);
            }
        });


    }
}
