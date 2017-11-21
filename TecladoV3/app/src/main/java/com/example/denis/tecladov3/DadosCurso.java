package com.example.denis.tecladov3;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import io.realm.RealmObject;

/**
 * Created by rafael on 27/12/16.
 */

public class DadosCurso  extends RealmObject {
    private String id;
    private String Historico;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHistorico() {
        return Historico;
    }

    public void setHistorico(String historico) {
        Historico = historico;
    }
}

