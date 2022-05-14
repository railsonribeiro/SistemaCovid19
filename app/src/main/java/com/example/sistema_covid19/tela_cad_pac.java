package com.example.sistema_covid19;
import androidx.appcompat.app.AppCompatActivity;
import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class tela_cad_pac extends AppCompatActivity {


    Rotinas_BD rotinas;

    //Declarando os EditText
    EditText et_pac_nome,et_pac_cpf,et_pac_telefone,et_pac_data_nasc,et_pac_rua,et_pac_numerocasa;
    EditText et_pac_bairro,et_pac_cidade,et_pac_sigla,et_pac_cep,et_pac_email,et_pac_comorbidade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cad_pac);

        //Esconder título do app
        getSupportActionBar().hide();

        //Referenciando os EditText
        et_pac_nome = findViewById(R.id.et_pac_nome);
        et_pac_cpf = findViewById(R.id.et_pac_cpf);
        et_pac_telefone = findViewById(R.id.et_pac_fone);
        et_pac_data_nasc = findViewById(R.id.et_pac_datanasc);
        et_pac_rua = findViewById(R.id.et_pac_rua);
        et_pac_numerocasa = findViewById(R.id.et_pac_numerocasa);
        et_pac_bairro = findViewById(R.id.et_pac_bairrro);
        et_pac_cidade = findViewById(R.id.et_pac_cidade);
        et_pac_sigla = findViewById(R.id.et_pac_sigla);
        et_pac_cep = findViewById(R.id.et_pac_cep);
        et_pac_email = findViewById(R.id.et_pac_email);
        et_pac_comorbidade = findViewById(R.id.et_pac_comorb);

        //Criando e fechando banco de dados pelo Construtor da classe caso não exista
        rotinas = new Rotinas_BD(this);
        rotinas.criar_abrir_tabela_pacientes();
        rotinas.db.close();
    }



    public void inserir_pac(View v){
        String s_pac_nome,s_pac_cpf,s_pac_telefone,s_pac_data_nasc,s_pac_rua,s_pac_numerocasa;
        String s_pac_bairro,s_pac_cidade,s_pac_sigla,s_pac_cep,s_pac_email,s_pac_comorbidade;
        //Pegando os valores dos EditText
        s_pac_nome = et_pac_nome.getText().toString();
        s_pac_cpf = et_pac_cpf.getText().toString();
        s_pac_telefone = et_pac_telefone.getText().toString();
        s_pac_data_nasc = et_pac_data_nasc.getText().toString();
        s_pac_rua = et_pac_rua.getText().toString();
        s_pac_numerocasa = et_pac_numerocasa.getText().toString();
        s_pac_bairro = et_pac_bairro.getText().toString();
        s_pac_cidade = et_pac_cidade.getText().toString();
        s_pac_sigla = et_pac_sigla.getText().toString();
        s_pac_cep = et_pac_cep.getText().toString();
        s_pac_email = et_pac_email.getText().toString();
        s_pac_comorbidade = et_pac_comorbidade.getText().toString();

        if(s_pac_nome.equals("") || s_pac_cpf.equals("") || s_pac_telefone.equals("") || s_pac_data_nasc.equals("") || s_pac_rua.equals("")
                || s_pac_numerocasa.equals("") || s_pac_bairro.equals("") || s_pac_cidade.equals("") || s_pac_sigla.equals("") || s_pac_cep.equals("")
                || s_pac_email.equals("")) {
            Msg_Alerta.alert_dialog("Todos campos obrigatórios devem ser preenchidos!",this);
        }else{
            try{
                rotinas.inserir_paciente(s_pac_nome,s_pac_cpf,s_pac_telefone,s_pac_data_nasc,s_pac_rua,s_pac_numerocasa,s_pac_bairro,s_pac_cidade,s_pac_sigla,s_pac_cep,s_pac_email,s_pac_comorbidade);
                Msg_Alerta.alert_dialog("Paciente cadastrado com sucesso!",this);

                //Limpando os dados
                et_pac_nome.setText("");
                et_pac_cpf.setText("");
                et_pac_telefone.setText("");
                et_pac_data_nasc.setText("");
                et_pac_rua.setText("");
                et_pac_numerocasa.setText("");
                et_pac_bairro.setText("");
                et_pac_cidade.setText("");
                et_pac_sigla.setText("");
                et_pac_cep.setText("");
                et_pac_email.setText("");
                et_pac_comorbidade.setText("");

            }catch (SQLiteConstraintException e3){
                Msg_Alerta.alert_dialog("O CPF fornecido já está cadastrado!",this);
                rotinas.db.close();
            }catch(Exception e4){
                Msg_Alerta.alert_dialog("Ocorreu um erro ao registar o paciente!",this);
                rotinas.db.close();
            }
        }
    }

}