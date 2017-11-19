package com.example.denis.tecladov3;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import butterknife.OnClick;

public class InstrucaoActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    //@Bind(R.id.main_layout)
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrucao);
        sharedPreferences = getSharedPreferences(getString(R.string.pref_key), Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString(getString(R.string.pref_text), "config");
        editor.apply();

        hideKeyboard();
        Toast.makeText(this,"Bem Vindo:", Toast.LENGTH_LONG).show();
        /*
        @OnClick(R.id.btnSave) void savePreferences() {

        }*/
    }
    private void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
