package com.example.fut;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.fut.R;

public class CadastrarJogadorActivity extends AppCompatActivity {

    private EditText etNome;
    private EditText etEmail;
    private EditText etIdade;
    private EditText etNumeroCamiseta;
    private EditText etSenha;
    private EditText etTelefone;
    private Button btCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_jogador);

        this.inicializaComponentes();

            this.btCadastrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String nome = etNome.getText().toString();
                    String email = etEmail.getText().toString();
                    String telefone = etTelefone.getText().toString();
                    String senha = etSenha.getText().toString();
                    int idade = Integer.parseInt(etIdade.getText().toString());
                    int numeroCamiseta = Integer.parseInt(etNumeroCamiseta.getText().toString());

                }
            });



    }
    private void inicializaComponentes(){
        this.etNome = findViewById(R.id.et_Nome);
        this.etEmail = findViewById(R.id.et_email);
        this.etTelefone = findViewById(R.id.et_telefone);
        this.etSenha = findViewById(R.id.et_senha);
        this.etIdade = findViewById(R.id.et_idade);
        this.etNumeroCamiseta = findViewById(R.id.et_numero_camiseta);

    }
}
