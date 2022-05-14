package com.example.sistema_covid19;

import androidx.appcompat.app.AppCompatActivity;
import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class tela_cad_usr extends AppCompatActivity {

    //Variáveis dos componentes
    EditText et_cad_usr_nome;
    EditText et_cad_usr_cpf;
    EditText et_cad_usr_senha;
    Rotinas_BD rotinas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cad_usr);

        //Esconder título do app
        getSupportActionBar().hide();

        //atribuindo valores para as variáveis dos componentes
        et_cad_usr_nome = findViewById(R.id.et_cad_usr_nome);
        et_cad_usr_cpf = findViewById(R.id.et_cad_usr_cpf);
        et_cad_usr_senha = findViewById(R.id.et_cad_usr_senha);

        rotinas = new Rotinas_BD(this);
        rotinas.criar_abrir_tabela_usuarios();
        rotinas.db.close();
    }

    public void inserir_usuario(View v){
        //conversão dos EditText
        String cad_usr_cpf = et_cad_usr_cpf.getText().toString();
        String cad_usr_nome = et_cad_usr_nome.getText().toString();
        String cad_usr_senha = et_cad_usr_senha.getText().toString();
        if(!cad_usr_cpf.equals("") && !cad_usr_nome.equals("") && !cad_usr_senha.equals("")){
            try{
                //Fazer registro
                rotinas.inserir_usuario(cad_usr_cpf,cad_usr_nome,cad_usr_senha);
                Msg_Alerta.alert_dialog("Cadastro realizado com sucesso!",this);
                //limpar campos
                et_cad_usr_nome.setText("");
                et_cad_usr_cpf.setText("");
                et_cad_usr_senha.setText("");
            }
            catch (SQLiteConstraintException e1){
                Msg_Alerta.alert_dialog("Erro! O CPF já está cadastrado!",this);
            }
            catch(Exception e2){
                Msg_Alerta.alert_dialog("Erro inesperado!",this);
            }
        }else{
            Msg_Alerta.alert_dialog("Os campos NÃO podem ficar vazios!",this);
        }

    }
}