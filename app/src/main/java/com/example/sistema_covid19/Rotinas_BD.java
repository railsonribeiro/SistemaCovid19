package com.example.sistema_covid19;



import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContextWrapper;
import android.database.Cursor;

import android.database.sqlite.SQLiteDatabase;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class Rotinas_BD extends AppCompatActivity {
    SQLiteDatabase db = null;
    Cursor cursor;
    Activity act;

    public Rotinas_BD(Activity act){
        this.act = act;
    }

    public void criar_abrir_tabela_pacientes(){
        try{
            ContextWrapper cw = new ContextWrapper(act);
            db = cw.openOrCreateDatabase("covid19_db",MODE_PRIVATE,null);
        }catch(Exception e1){
            Msg_Alerta.alert_dialog("Não foi possível criar/abrir o banco de dados!",act);
        }
        try{
            db.execSQL("CREATE TABLE IF NOT EXISTS pacientes_tab " +
                    //ALERTA: Alter o tipo de dados da data de nascimento depois
                    "(nome TEXT,cpf NUMERIC PRIMARY KEY, telefone NUMERIC, rua TEXT,data_nasc TEXT,numero_casa NUMERIC,bairro TEXT, cidade TEXT,sigla TEXT,cep NUMERIC, " +
                    "email TEXT, comorbidade TEXT)");
        }catch (Exception e2){
            Msg_Alerta.alert_dialog("Erro ao criar tabela!",act);
        }
    }
    public void criar_abrir_tabela_usuarios(){
        try{
            ContextWrapper cw = new ContextWrapper(act);
            db = cw.openOrCreateDatabase("covid19_db",MODE_PRIVATE,null);
        }catch(Exception e1){
            Msg_Alerta.alert_dialog("Não foi possível criar/abrir o banco de dados!",act);
        }
        try{
            db.execSQL("CREATE TABLE IF NOT EXISTS login_tab " +
                    "(cpf TEXT,nome TEXT,senha TEXT)");
        }catch (Exception e2){
            Msg_Alerta.alert_dialog("Erro ao criar tabela!",act);
        }
    }

    public Pacientes procurar_cpf(String et_procurar_cpf) {
        Pacientes paciente = null;
        criar_abrir_tabela_pacientes();

        cursor = db.query("pacientes_tab",
                new String[]{"nome", "cpf", "telefone", "data_nasc", "rua", "numero_casa", "bairro", "cidade", "sigla", "cep", "email", "comorbidade"}, null, null, null, null, null, null);
        if (cursor.getCount() != 0) {
            int i;
            for (i = 0; i < cursor.getCount(); i++) {
                cursor.moveToPosition(i);
                if (cursor.getString(1).equals(et_procurar_cpf)) {
                    db.close();
                    paciente = new Pacientes(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),
                            cursor.getString(6),cursor.getString(7),cursor.getString(8),cursor.getString(9),cursor.getString(10),cursor.getString(11));
                    return paciente;
                }
            }
            Msg_Alerta.alert_dialog("O CPF fornecido não está cadastrado!",act);
            db.close();
        } else {
            Msg_Alerta.alert_dialog("Não há registro de paciente!",act);
        }
        db.close();
        return paciente;
    }

    public void inserir_usuario(String cad_usr_cpf,String cad_usr_nome,String cad_usr_senha){
        criar_abrir_tabela_usuarios();
        db.execSQL("INSERT INTO login_tab (cpf,nome,senha) VALUES ('"+cad_usr_cpf+"','"+cad_usr_nome+"','"+cad_usr_senha+"');");
        db.close();
    }

    public boolean tentar_login(String et_usr, String et_senha) {
        int i;
        boolean existe_cpf = false;
        boolean liberar_login = false;
        criar_abrir_tabela_usuarios();
        cursor = db.query("login_tab",
                new String[]{"cpf", "nome", "senha"}, null, null, null, null, null, null);

        if (cursor.getCount() != 0) {
            for (i = 0; i < cursor.getCount(); ++i) {
                cursor.moveToPosition(i);
                //exibir_msg("CPF: " + cursor.getString(0)  + "\nNome: " + cursor.getString(1) + "\nSenha: " + cursor.getString(2));
                if (et_usr.equals(cursor.getString(0)) &&
                        et_senha.equals(cursor.getString(2))) {
                    liberar_login = true;
                    db.close();
                    return liberar_login;

                } else if (et_usr.equals(cursor.getString(0))) {

                    Msg_Alerta.alert_dialog("A senha fornecida está incorreta!",act);
                    existe_cpf = true;
                    break;
                }
            }
            if (existe_cpf == false) {
                Msg_Alerta.alert_dialog("O usuário fornecido não está cadastrado!",act);
            }
        } else {
            Msg_Alerta.alert_dialog("Não há nenhum usuário cadastrado!",act);
        }
        db.close();
        return liberar_login;
    }


    public void inserir_paciente(String s_pac_nome,String s_pac_cpf, String s_pac_telefone, String s_pac_data_nasc, String s_pac_rua, String s_pac_numerocasa,String s_pac_bairro,String s_pac_cidade, String s_pac_sigla, String s_pac_cep, String s_pac_email,String s_pac_comorbidade){
        criar_abrir_tabela_pacientes();
        db.execSQL("INSERT INTO pacientes_tab (nome,cpf,telefone,data_nasc,rua,numero_casa,bairro,cidade,sigla,cep,email,comorbidade) " +
                "VALUES('"+s_pac_nome+"','"+s_pac_cpf+"','"+s_pac_telefone+"','"+s_pac_data_nasc+"','"+s_pac_rua+"','"+s_pac_numerocasa+"','"+s_pac_bairro+"','"+s_pac_cidade+"','"+s_pac_sigla+"','"+s_pac_cep+"','"+s_pac_email+"','"+s_pac_comorbidade+"');");
        db.close();
    }

    public List<Pacientes> listar_pac() {
        int i;
        //Instanciando a classe abaixo para acessar a variável lista_pacientes
        Tela_Listar_Pac tlp= new Tela_Listar_Pac();

        List<Pacientes> lista_pacientes = new ArrayList<>();

        criar_abrir_tabela_pacientes();
        cursor = db.query("pacientes_tab",
                new String[]{"nome","cpf", "telefone","data_nasc","rua","numero_casa","bairro","cidade","sigla","cep","email","comorbidade"}, null, null, null, null, null, null);
        if (cursor.getCount() != 0) {
            for (i = 0; i < cursor.getCount(); ++i) {
                cursor.moveToPosition(i);
                //Criando a lista de paciente através da classe Pacientes_BD
                Pacientes pacientes = new Pacientes(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),
                        cursor.getString(6),cursor.getString(7),cursor.getString(8),cursor.getString(9),cursor.getString(10),cursor.getString(11));
                lista_pacientes.add(pacientes);
            }
            db.close();
            return lista_pacientes;

        }else{
            Msg_Alerta.alert_dialog("Não há registro de paciente!",act);
        }
        db.close();
        return lista_pacientes;
    }

    public List<Pacientes> listar_pac_risco() {
        int i;
        List<Pacientes> lista_pacientes_risco = new ArrayList<>();
        criar_abrir_tabela_pacientes();
        String consulta = "SELECT nome, cpf, telefone, data_nasc, rua, numero_casa, bairro, cidade, sigla, cep, email,comorbidade FROM pacientes_tab WHERE comorbidade != ''";
        cursor = db.rawQuery(consulta, null);

        if (cursor.getCount() != 0) {
            for (i = 0; i < cursor.getCount(); ++i) {
                cursor.moveToPosition(i);

                //Criando a lista de paciente através da classe Pacientes_BD
                Pacientes pacientes = new Pacientes(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),
                        cursor.getString(6),cursor.getString(7),cursor.getString(8),cursor.getString(9),cursor.getString(10),cursor.getString(11));
                lista_pacientes_risco.add(pacientes);
            }
            db.close();
            return lista_pacientes_risco;
        }else{
            Msg_Alerta.alert_dialog("Não há registro de paciente!",this);
        }

        return lista_pacientes_risco;
    }

    public void apagar_tabela(){
        criar_abrir_tabela_pacientes();
        db.execSQL("DROP TABLE pacientes_tab");
        db.close();
    }
}
