package com.example.sistema_covid19;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class tela_listar_risco extends AppCompatActivity {

    SQLiteDatabase db = null;
    Cursor cursor;
    AlertDialog.Builder alert_padrao;
    Rotinas_BD rotinas;
    RecyclerView recyclerview2;
    //Criando uma lista de pacientes
    private List<Pacientes> lista_pacientes_risco;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_listar_risco);

        //Esconder título do app
        getSupportActionBar().hide();

        recyclerview2 = findViewById(R.id.recyclerView2);
        rotinas = new Rotinas_BD(this);
        rotinas.criar_abrir_tabela_pacientes();
        rotinas.db.close();

        //Chamando método de listar pacientes
        listar_pac_risco();

        //Instanciando o adapter
        Novo_Adapter adapter2 = new Novo_Adapter(lista_pacientes_risco);


        /*
        Layout Manager -> definir o layout do recyclerview
        Adapter -> faz a ponte entre o Layout Manager e o Dataset
        Dataset -> dados da do recyclerview
         */

        //Criando o LayoutManager
        RecyclerView.LayoutManager lm = new LinearLayoutManager(getApplicationContext());

        //Criando o Adapter
        recyclerview2.setAdapter(adapter2);
        //Fixar o tamanho da lista
        recyclerview2.setHasFixedSize(true);

        //Passando o Layout Manager para o RecyclerView
        recyclerview2.setLayoutManager(lm);
    }

    public void listar_pac_risco() {
        lista_pacientes_risco = new ArrayList<>(rotinas.listar_pac_risco());
        if(lista_pacientes_risco == null){
            Msg_Alerta.alert_dialog("Não há pacientes cadastrados!",this);
            finish();
        }
    }
}