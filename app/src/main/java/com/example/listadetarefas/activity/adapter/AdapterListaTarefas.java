package com.example.listadetarefas.activity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listadetarefas.R;
import com.example.listadetarefas.activity.model.Tarefa;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

public class AdapterListaTarefas extends RecyclerView.Adapter<AdapterListaTarefas.MyViewHolder> {

    public List<Tarefa> listaTarefa;

    public AdapterListaTarefas(List<Tarefa> lista){
        this.listaTarefa = lista;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View tarefasLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_lista, parent, false);

        return new MyViewHolder(tarefasLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Tarefa tarefa = listaTarefa.get(position);
        holder.tarefa.setText(tarefa.getTarefa());

    }

    @Override
    public int getItemCount() {
        return this.listaTarefa.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tarefa;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tarefa = itemView.findViewById(R.id.textTarefa);
        }
    }

}
