package com.example.fut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.fut.R;

public class CadastrarClubeActivity extends AppCompatActivity {

    private EditText etNomeClube;
    private EditText etQntdJogadores;
    private EditText etCnpj;
    private EditText etNumeroClube;
    private EditText etTecnico;
    private Button btCriar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_clube);

        this.Inicializar();

this.btCriar.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent tela5 = new Intent (CadastrarClubeActivity.this, CadastrarClubeActivity.class );
        startActivity(tela5);
    }
});
    }
    public void Inicializar(){
        this.etNomeClube = findViewById(R.id.et_nome_clube);
        this.etQntdJogadores = findViewById(R.id.et_qntd_jogador);
        this.etCnpj = findViewById(R.id.et_cnpj);
        this.etNumeroClube = findViewById(R.id.et_numero_clube);
        this.etTecnico = findViewById(R.id.et_tecnico);
        this.btCriar = findViewById(R.id.bt_criar);

    }
}
