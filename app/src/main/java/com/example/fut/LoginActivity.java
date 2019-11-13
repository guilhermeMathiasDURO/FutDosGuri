package com.example.fut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fut.R;

public class LoginActivity extends AppCompatActivity {

    private Button btCriarConta;
    private Button btJaTenhoConta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


       this.Inicializar();

        this.btJaTenhoConta.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent tela3 = new Intent(LoginActivity.this, EntrarActivity.class);
        startActivity(tela3);
    }
});
        this.btCriarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent tela2 = new Intent(LoginActivity.this, CadastrarClubeActivity.class);
            startActivity(tela2);
        }
    });

    }
    public void Inicializar(){
        this.btJaTenhoConta = findViewById(R.id.bt_ja_tenho_conta);
        this.btCriarConta = findViewById(R.id.bt_criar_conta_clube);
    }
}
