package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btCriarConta;
    private Button btJaTenhoConta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.btJaTenhoConta = findViewById(R.id.bt_ja_tenho_conta);
        this.btCriarConta = findViewById(R.id.bt_criar_conta);


        this.btCriarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent tela2 = new Intent(MainActivity.this,Tela2Activity.class);
            startActivity(tela2);
            Intent tela3 = new Intent(MainActivity.this,Tela3Activity.class);
            startActivity(tela3);

        }

    });

    }
}
