package com.example.denis.tecladov3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;

public class TecladoActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    MediaPlayer mp;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private ImageButton  inicio ;
    private ImageButton cadastrar ;
    Realm Inicio_realm;
    TextView email,senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teclado);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);//Preferences
        Inicio_realm = Realm.getDefaultInstance();
        //-------------------------------------------------------------------
        inicio = (ImageButton)findViewById(R.id.teclado_login);
        inicio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {  //Estrutura do botão
                email=(TextView)findViewById(R.id.editText);
                senha=(TextView)findViewById(R.id.editText2);
                String confirmEmail = email.getText().toString();
                String confirmSenha = senha.getText().toString();
                Cadastro usuarioview;
                String retor_Email="";
                String retor_Senha="";

                try{
                    usuarioview =Inicio_realm.where(Cadastro.class).equalTo("email", confirmEmail).findFirst();
                    retor_Email=usuarioview.getNome().toString();
                    retor_Senha=usuarioview.getSenha();
                }
                catch (Exception e){
                    Toast.makeText(TecladoActivity.this, "Erro Banco", Toast.LENGTH_SHORT).show();
                }

                if(confirmEmail==retor_Email&& confirmSenha==retor_Senha){
                    Intent intent = new Intent(TecladoActivity.this, CursoActivity.class);
                    startActivity(intent);
                }
                Toast.makeText(TecladoActivity.this, "Senaha incorreta", Toast.LENGTH_SHORT).show();
            }
        });
        cadastrar = (ImageButton)findViewById(R.id.teclado_cadastra);
        cadastrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {  //Estrutura do botão
                Intent intent = new Intent(TecladoActivity.this, CadastroActivity.class);
                startActivity(intent);
            }
        });
        //--------------------------------------------------------------------
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.teclado, menu);
/*
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView)item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                alert("Buscar o texto:" + s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });*/
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(TecladoActivity.this,InstrucaoActivity.class);
            startActivity(intent);
           // return true;
        }
        /*if (id == R.id.aula02) {
            String tipodelayout = String.valueOf(R.layout.aula01_2);
            Intent intent = new Intent(this, AulaActivity.class);
            Bundle params = new Bundle();
            params.putString("layout", tipodelayout);
            intent.putExtras(params);
            startActivity(intent);
            // return true;
        }
        if (id == R.id.aula03) {

            Intent intent = new Intent(this, Lista.class);
            startActivity(intent);
            // return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void alert(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

}
