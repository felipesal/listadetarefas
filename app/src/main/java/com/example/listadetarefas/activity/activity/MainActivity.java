package com.example.listadetarefas.activity.activity;

import android.content.Intent;
import android.os.Bundle;

import com.example.listadetarefas.R;
import com.example.listadetarefas.activity.adapter.AdapterListaTarefas;

import com.example.listadetarefas.activity.helper.ClickListener;
import com.example.listadetarefas.activity.model.Tarefa;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import static com.example.listadetarefas.activity.helper.ClickListener.*;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rview;
    private AdapterListaTarefas adapterListaTarefas;
    private List<Tarefa> listaTarefas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rview = findViewById(R.id.recyclerView);

        //evento de click
        rview.addOnItemTouchListener(
                new ClickListener(
                        getApplicationContext(),
                        rview,
                        new ClickListener.OnItemClickListener(){
                            @Override
                            public void onItemClick(View view, int position){
                                Log.i("clique", "onItemClick");
                            }

                            public void onLongItemClick(View view, int position){
                                Log.i("clique", "onLongItemClick");
                            }

                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AdicionarTarefaActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        carregarListaTarefas();
        super.onStart();
    }

    public void carregarListaTarefas(){

        Tarefa tarefa1 = new Tarefa();
        tarefa1.setTarefa("Andar de bike");

        Tarefa tarefa2 = new Tarefa();
        tarefa2.setTarefa("Cozinhar");

        listaTarefas.add(tarefa1);
        listaTarefas.add(tarefa2);

        adapterListaTarefas = new AdapterListaTarefas(listaTarefas);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());


        rview.setLayoutManager(layoutManager);
        rview.setHasFixedSize(true);
        rview.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        rview.setAdapter( adapterListaTarefas );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
