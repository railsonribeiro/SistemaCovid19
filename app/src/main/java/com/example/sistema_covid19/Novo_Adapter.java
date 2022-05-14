package com.example.sistema_covid19;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Novo_Adapter extends RecyclerView.Adapter<Novo_Adapter.Novo_View_Holder> {

    private List<Pacientes> lista_pacientes;

    public Novo_Adapter(List<Pacientes> lista){
      this.lista_pacientes = lista;
    }

    @NonNull
    @Override
    public Novo_View_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //Carregando o layout adapter_lista
        View v_lista_pacientes = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_lista,parent,false);

        return new Novo_View_Holder(v_lista_pacientes);
    }

    @Override
    public void onBindViewHolder(@NonNull Novo_View_Holder holder, int position) {
        //Exibindo na tela os valores
        Pacientes pacientes = lista_pacientes.get(position);

        holder.pac_comorbidade.setText(holder.pac_comorbidade.getText().toString() + pacientes.getS_pac_comorbidade());
        holder.pac_nome.setText(holder.pac_nome.getText().toString() + pacientes.getS_pac_nome());
        holder.pac_cpf.setText(holder.pac_cpf.getText().toString() + pacientes.getS_pac_cpf());
        holder.pac_telefone.setText(holder.pac_telefone.getText().toString() + pacientes.getS_pac_telefone());
        holder.pac_data_nasc.setText(holder.pac_data_nasc.getText().toString() + pacientes.getS_pac_data_nasc());
        holder.pac_rua.setText(holder.pac_rua.getText().toString() + pacientes.getS_pac_rua());
        holder.pac_numerocasa.setText(holder.pac_numerocasa.getText().toString() + pacientes.getS_pac_numerocasa());
        holder.pac_email.setText(holder.pac_email.getText().toString() + pacientes.getS_pac_email());
        holder.pac_sigla.setText(holder.pac_sigla.getText().toString() + pacientes.getS_pac_sigla());
        holder.pac_bairro.setText(holder.pac_bairro.getText().toString() + pacientes.getS_pac_bairro());
        holder.pac_cidade.setText(holder.pac_cidade.getText().toString() + pacientes.getS_pac_cidade());
        holder.pac_cep.setText(holder.pac_cep.getText().toString() + pacientes.getS_pac_cep());
        holder.pac_num.setText("Paciente "+Integer.toString(position + 1));
    }

    @Override
    public int getItemCount() {
        return lista_pacientes.size();
    }

    public class Novo_View_Holder extends RecyclerView.ViewHolder{

        //Declarando os EditText

        TextView pac_num,pac_nome,pac_cpf,pac_telefone,pac_data_nasc,pac_rua,pac_numerocasa,n_pac;
        TextView pac_bairro,pac_cidade,pac_sigla,pac_cep,pac_email,pac_comorbidade;


        public Novo_View_Holder(@NonNull View itemView) {
            super(itemView);

            //Referenciando as variáveis
            pac_num = itemView.findViewById(R.id.tv_n_pac);
            pac_comorbidade = itemView.findViewById(R.id.tv_comorbidade);
            pac_nome = itemView.findViewById(R.id.tv_nome);
            pac_cpf = itemView.findViewById(R.id.tv_cpf);
            pac_telefone = itemView.findViewById(R.id.tv_telefone);
            pac_data_nasc = itemView.findViewById(R.id.tv_data_nasc);
            pac_rua = itemView.findViewById(R.id.tv_rua);
            pac_numerocasa = itemView.findViewById(R.id.tv_numero_casa);
            pac_bairro = itemView.findViewById(R.id.tv_bairro);
            pac_cidade = itemView.findViewById(R.id.tv_cidade);
            pac_sigla = itemView.findViewById(R.id.tv_sigla);
            pac_cep = itemView.findViewById(R.id.tv_cep);
            pac_email = itemView.findViewById(R.id.tv_email);


        }
    }
}
