package com.example.fut;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.fut.R;

public class CadastrarJogosActivity extends AppCompatActivity {

    private EditText etGols;
    private EditText etPlacar;
    private EditText etHorario;
    private Spinner spGinasios;
    private String[] vetorGinasios = {"Ginasio1 ", "Ginasio2 ", " Ginasio3 ", "Ginasio4 "};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_jogador);

        this.incializaComponentes();

        String gols = etGols.getText().toString();
        String placar = etPlacar.getText().toString();
        String horario = etHorario.getText().toString();

        ArrayAdapter<String> adapterGinasios = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, vetorGinasios);
        this.spGinasios.setAdapter(adapterGinasios);

    }
    private void incializaComponentes(){
        this.etGols = findViewById(R.id.et_gols);
        this.etHorario = findViewById(R.id.et_horario);
        this.etPlacar = findViewById(R.id.et_placar);
    }
}
