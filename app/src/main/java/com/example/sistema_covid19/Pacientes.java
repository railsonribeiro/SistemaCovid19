package com.example.sistema_covid19;
public class Pacientes {

    private String s_pac_nome,s_pac_cpf,s_pac_telefone,s_pac_data_nasc,s_pac_rua,s_pac_numerocasa;
    private String s_pac_bairro,s_pac_cidade,s_pac_sigla,s_pac_cep,s_pac_email,s_pac_comorbidade;

    public Pacientes(String s_pac_nome, String s_pac_cpf, String s_pac_telefone, String s_pac_data_nasc, String s_pac_rua, String s_pac_numerocasa, String s_pac_bairro, String s_pac_cidade, String s_pac_sigla, String s_pac_cep, String s_pac_email, String s_pac_comorbidade) {

        //Atribuindo os valores para as variáveis da classe
        this.s_pac_nome = s_pac_nome;
        this.s_pac_cpf = s_pac_cpf;
        this.s_pac_telefone = s_pac_telefone;
        this.s_pac_data_nasc = s_pac_data_nasc;
        this.s_pac_rua = s_pac_rua;
        this.s_pac_numerocasa = s_pac_numerocasa;
        this.s_pac_bairro = s_pac_bairro;
        this.s_pac_cidade = s_pac_cidade;
        this.s_pac_sigla = s_pac_sigla;
        this.s_pac_cep = s_pac_cep;
        this.s_pac_email = s_pac_email;
        this.s_pac_comorbidade = s_pac_comorbidade;
    }

    public String getS_pac_nome() {
        return s_pac_nome;
    }

    public void setS_pac_nome(String s_pac_nome) {
        this.s_pac_nome = s_pac_nome;
    }

    public String getS_pac_cpf() {
        return s_pac_cpf;
    }

    public void setS_pac_cpf(String s_pac_cpf) {
        this.s_pac_cpf = s_pac_cpf;
    }

    public String getS_pac_telefone() {
        return s_pac_telefone;
    }

    public void setS_pac_telefone(String s_pac_telefone) {
        this.s_pac_telefone = s_pac_telefone;
    }

    public String getS_pac_data_nasc() {
        return s_pac_data_nasc;
    }

    public void setS_pac_data_nasc(String s_pac_data_nasc) {
        this.s_pac_data_nasc = s_pac_data_nasc;
    }

    public String getS_pac_rua() {
        return s_pac_rua;
    }

    public void setS_pac_rua(String s_pac_rua) {
        this.s_pac_rua = s_pac_rua;
    }

    public String getS_pac_numerocasa() {
        return s_pac_numerocasa;
    }

    public void setS_pac_numerocasa(String s_pac_numerocasa) {
        this.s_pac_numerocasa = s_pac_numerocasa;
    }

    public String getS_pac_bairro() {
        return s_pac_bairro;
    }

    public void setS_pac_bairro(String s_pac_bairro) {
        this.s_pac_bairro = s_pac_bairro;
    }

    public String getS_pac_cidade() {
        return s_pac_cidade;
    }

    public void setS_pac_cidade(String s_pac_cidade) {
        this.s_pac_cidade = s_pac_cidade;
    }

    public String getS_pac_sigla() {
        return s_pac_sigla;
    }

    public void setS_pac_sigla(String s_pac_sigla) {
        this.s_pac_sigla = s_pac_sigla;
    }

    public String getS_pac_cep() {
        return s_pac_cep;
    }

    public void setS_pac_cep(String s_pac_cep) {
        this.s_pac_cep = s_pac_cep;
    }

    public String getS_pac_email() {
        return s_pac_email;
    }

    public void setS_pac_email(String s_pac_email) {
        this.s_pac_email = s_pac_email;
    }

    public String getS_pac_comorbidade() {
        return s_pac_comorbidade;
    }

    public void setS_pac_comorbidade(String s_pac_comorbidade) {
        this.s_pac_comorbidade = s_pac_comorbidade;
    }
}
