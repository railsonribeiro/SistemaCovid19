package com.example.sistema_covid19;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class Tela_Listar_Pac extends AppCompatActivity {

    RecyclerView recyclerview1;
    Rotinas_BD rotinas;
    //Criando uma lista de pacientes
    public List<Pacientes> lista_pacientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_listar_pac);

        //Esconder título do app
        getSupportActionBar().hide();

        rotinas = new Rotinas_BD(this);
        rotinas.criar_abrir_tabela_pacientes();
        rotinas.db.close();

        //Chamando método de listar pacientes
        listar_pac();

        recyclerview1 = findViewById(R.id.recyclerView1);

        //Instanciando o adapter
        Novo_Adapter adapter = new Novo_Adapter(lista_pacientes);

        /*
        Layout Manager -> definir o layout do recyclerview
        Adapter -> faz a ponte entre o Layout Manager e o Dataset
        Dataset -> dados da do recyclerview
         */

        //Criando o LayoutManager
        RecyclerView.LayoutManager lm = new LinearLayoutManager(getApplicationContext());

        //Criando o Adapter
        recyclerview1.setAdapter(adapter);
        //Fixar o tamanho da lista
        recyclerview1.setHasFixedSize(true);

        //Passando o Layout Manager para o RecyclerView
        recyclerview1.setLayoutManager(lm);
    }

    public void listar_pac() {
        //Guardando os pacientes encontrados da Class Rotina_BD
        lista_pacientes = new ArrayList<>(rotinas.listar_pac());

        if(lista_pacientes == null){
            Msg_Alerta.alert_dialog("Não há pacientes cadastrados!",this);
            finish();
        }
    }
}