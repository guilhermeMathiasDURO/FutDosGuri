package com.example.fut;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.fut.R;

public class EnderecoActivity extends AppCompatActivity {
    private EditText etCep;
    private EditText etEstado;
    private EditText etCidade;
    private EditText etBairro;
    private EditText etRua;
    private EditText etNumero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endereco);

        this.Inicializar();


    }
    public void Inicializar(){
        this.etCep = findViewById(R.id.et_cep);
        this.etEstado = findViewById(R.id.et_estado);
        this.etCidade = findViewById(R.id.et_cidade);
        this.etBairro = findViewById(R.id.et_bairro);
        this.etRua = findViewById(R.id.et_rua);
        this.etNumero = findViewById(R.id.et_numero);
    }
}
