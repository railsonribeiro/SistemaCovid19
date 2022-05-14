package com.example.sistema_covid19;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class tela_apos_login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_apos_login);

        //Esconder título do app
        getSupportActionBar().hide();
    }
    public void cad_pac(View v){
        Intent intent_cad_pac = new Intent(this,tela_cad_pac.class);
        startActivity(intent_cad_pac);
    }
    public void listar_pac(View v){
        Intent intent_listar_pac = new Intent(this,Tela_Listar_Pac.class);
        startActivity(intent_listar_pac);
    }
    public void listar_pac_risco(View v){
        Intent intent_listar_pac_risco = new Intent(this,tela_listar_risco.class);
        startActivity(intent_listar_pac_risco);
    }
    public void procurar_cpf(View v){
        Intent intent_procurar_cpf= new Intent(this,Procurar_Paciente.class);
        startActivity(intent_procurar_cpf);
    }
}