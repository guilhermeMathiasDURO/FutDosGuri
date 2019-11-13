package com.example.fut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.fut.R;

public class EntrarActivity extends AppCompatActivity {

    private EditText etEmail;
    private EditText etSenha;
    private Button btEntrarConta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrar);
        this.inicializar();

this.btEntrarConta.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Intent tela4 = new Intent(EntrarActivity.this, PrincipalActivity.class);
        startActivity(tela4);
    }
});
    }
    public void inicializar(){
        this.etEmail = findViewById(R.id.et_email);
        this.etSenha = findViewById(R.id.et_senha);
        this.btEntrarConta = findViewById(R.id.bt_entrar_conta);
    }

}


