package com.example.denis.tecladov3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.example.denis.tecladov3.Curso;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class CadastroActivity extends AppCompatActivity {
    ImageButton ok;
    ImageButton cancel;
    Realm realm;
    EditText nome,telefone,email,senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        ok =(ImageButton)findViewById(R.id.cadastra_confirma_btn);
        cancel =(ImageButton)findViewById(R.id.cadastra_cancela_btn);
        nome=(EditText)findViewById(R.id.Cad_nome_edt);
        telefone=(EditText)findViewById(R.id.Cad_Telefone_edt);
        email=(EditText)findViewById(R.id.Cad_Email_edt);
        senha=(EditText)findViewById(R.id.Cad_senha_edt);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    realm = Realm.getDefaultInstance();

                    Cadastro cadastro = new Cadastro();
                    long key=realm.where(Cadastro.class).count();
                    cadastro.setId(String.valueOf(key));
                    cadastro.setNome(nome.getText().toString());
                    cadastro.setTelefone(telefone.getText().toString());
                    cadastro.setEmail(email.getText().toString());
                    cadastro.setSenha(senha.getText().toString());


                    realm.beginTransaction();
                    realm.copyToRealm(cadastro);
                    realm.commitTransaction();

                    Intent intent = new Intent(CadastroActivity.this, LoginActivity.class);
                    startActivity(intent);
                    Toast.makeText(CadastroActivity.this," Cadastro com Sucesso!:", Toast.LENGTH_LONG).show();
                }catch (Exception e){
                    Toast.makeText(CadastroActivity.this," Erro no cadastro:", Toast.LENGTH_LONG).show();
                }

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CadastroActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });
    }

}
