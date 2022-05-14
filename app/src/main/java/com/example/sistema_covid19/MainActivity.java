package com.example.sistema_covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {


    //Declarando os EditText
    EditText et_usr,et_senha;
    Rotinas_BD rotinas;
    AlertDialog.Builder alert_padrao;
    AlertDialog.Builder alert_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Esconder título do app
        getSupportActionBar().hide();
        rotinas = new Rotinas_BD(this);
        rotinas.criar_abrir_tabela_usuarios();
        rotinas.db.close();
        //Atribuindo valores para os EditText
        et_usr = findViewById(R.id.et_usr);
        et_senha = findViewById(R.id.et_senha);
    }

    public void cad_usr(View v){
        Intent intent_cad_usr = new Intent(this,tela_cad_usr.class);
        startActivity(intent_cad_usr);
    }

    public void tentar_login(View v) {
        if (!et_usr.getText().toString().equals("") && !et_senha.getText().toString().equals("")) {
            if (rotinas.tentar_login(et_usr.getText().toString(), et_senha.getText().toString())) {
                alert_login = new AlertDialog.Builder(this);
                alert_login.setMessage("Login realizado com sucesso!");
                alert_login.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                et_usr.setText("");
                                et_senha.setText("");
                                autorizar_login();
                            }
                        });
                alert_login.show();
            }
        } else {
            Msg_Alerta.alert_dialog("Os campos devem ser preenchidos!",this);
        }
    }
    public void autorizar_login(){
        Intent intent_tela_login = new Intent(this,tela_apos_login.class);
        startActivity(intent_tela_login);
    }
}