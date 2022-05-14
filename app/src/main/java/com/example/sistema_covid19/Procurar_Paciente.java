package com.example.sistema_covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Procurar_Paciente extends AppCompatActivity {

    EditText et_procurar_cpf;
    Rotinas_BD rotinas;
    Pacientes paciente_encontrado;

    EditText et_pac_nome, et_pac_cpf, et_pac_telefone, et_pac_data_nasc, et_pac_rua, et_pac_numerocasa;
    EditText et_pac_bairro, et_pac_cidade, et_pac_sigla, et_pac_cep, et_pac_email, et_pac_comorbidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_procurar_paciente);

        //Esconder título do app
        getSupportActionBar().hide();

        //Referenciando os EditText
        /*
        et_pac_nome = findViewById(R.id.et_procurar_nome);
        et_pac_cpf = findViewById(R.id.et_procurar_cpf);
        et_pac_telefone = findViewById(R.id.et_procurar_telefone);
        et_pac_data_nasc = findViewById(R.id.et_procurar_nascimento);
        et_pac_rua = findViewById(R.id.et_procurar_rua);
        et_pac_numerocasa = findViewById(R.id.et_procurar_ncasa);
        et_pac_bairro = findViewById(R.id.et_procurar_bairro);
        et_pac_cidade = findViewById(R.id.et_procurar_cidade);
        et_pac_sigla = findViewById(R.id.et_procurar_sigla);
        et_pac_cep = findViewById(R.id.et_procurar_cep);
        et_pac_email = findViewById(R.id.et_procurar_email);
        et_pac_comorbidade = findViewById(R.id.et_procurar_comorb);
        et_procurar_cpf = findViewById(R.id.et_buscar_cpf_pac);

         */
        //Criando e fechando banco de dados pelo Construtor da classe caso não exista
        rotinas = new Rotinas_BD(this);
    }
    //TODO: Corrigir este método (Colocar inclusive estas tarefas para a Rotinas_BD)
    public void procurar_pac(View v) {

        paciente_encontrado = rotinas.procurar_cpf(et_procurar_cpf.getText().toString());

        if (paciente_encontrado != null) {
            et_pac_nome.setText(paciente_encontrado.getS_pac_nome());
            et_pac_cpf.setText(paciente_encontrado.getS_pac_cpf());
            et_pac_telefone.setText(paciente_encontrado.getS_pac_telefone());
            et_pac_data_nasc.setText(paciente_encontrado.getS_pac_data_nasc());
            et_pac_rua.setText(paciente_encontrado.getS_pac_rua());
            et_pac_numerocasa.setText(paciente_encontrado.getS_pac_numerocasa());
            et_pac_bairro.setText(paciente_encontrado.getS_pac_bairro());
            et_pac_cidade.setText(paciente_encontrado.getS_pac_cidade());
            et_pac_sigla.setText(paciente_encontrado.getS_pac_sigla());
            et_pac_cep.setText(paciente_encontrado.getS_pac_cep());
            et_pac_email.setText(paciente_encontrado.getS_pac_email());
            et_pac_comorbidade.setText(paciente_encontrado.getS_pac_comorbidade());
        }
    }
}