package com.example.aulasfat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button btnCalcular;
    private EditText edtPeso;
    private EditText edtAltura;
    private TextView txtResultado;
    Button btnAbrirSegundaTela; // Keep the declaration here

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main),
                (v, insets) -> {
                    Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                    v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                    return insets;
                });

        btnCalcular = findViewById(R.id.btnCalcular);
        edtPeso = findViewById(R.id.edtPeso);
        edtAltura = findViewById(R.id.edtAltura);
        txtResultado = findViewById(R.id.txtResultado);
        btnAbrirSegundaTela = findViewById(R.id.btnAbrirSegundaTela); // Initialize here

        btnCalcular.setOnClickListener(v -> {
            if(edtPeso.getText().toString().isEmpty() ||
                    edtAltura.getText().toString().isEmpty()){
                Toast.makeText(this,
                        "Preencha todos os campos",
                        Toast.LENGTH_SHORT
                ).show();
                return;
            }
            double peso = Double.parseDouble(edtPeso.getText().toString());
            double altura = Double.parseDouble(edtAltura.getText().toString());

            double imc = peso / (altura * altura);

            txtResultado.setText(String.format("Seu IMC é: %.2f", imc));
        }); // End of btnCalcular's OnClickListener

        // Set the OnClickListener for btnAbrirSegundaTela separately
        btnAbrirSegundaTela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Cria uma Intent para abrir a SecondActivity
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent); // inicia a nova Activity
            }
        });
    }
}
