package br.senai.sp.calculagasolina;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ValoresActivity extends AppCompatActivity {

    EditText etGasolina, etGasolinaLitro, etAlcool, etAlcoolLitro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valores);

        etAlcool = findViewById(R.id.etAlcool);
        etAlcoolLitro = findViewById(R.id.etAlcoolLitro);
        etGasolina = findViewById(R.id.etGasolina);
        etGasolinaLitro = findViewById(R.id.etGasolinaLitro);
    }

    public void calcular(View v){
        Intent intencao = new Intent(ValoresActivity.this, CalcularActivity.class);
        intencao.putExtra("Alcool",        Float.parseFloat(etAlcool.getText().toString()));
        intencao.putExtra("Gasolina",      Float.parseFloat(etGasolina.getText().toString()));
        intencao.putExtra("AlcoolLitro",   Float.parseFloat(etAlcoolLitro.getText().toString()));
        intencao.putExtra("GasolinaLitro", Float.parseFloat(etGasolinaLitro.getText().toString()));
        startActivity(intencao);
        finish();
    }
}
