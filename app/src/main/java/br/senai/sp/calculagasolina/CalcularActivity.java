package br.senai.sp.calculagasolina;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class CalcularActivity extends AppCompatActivity {

    AlertDialog alerta;
    TextView tvMelhor, tvPior, tvQual;
    LinearLayout llPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_calcular);
        tvMelhor = findViewById(R.id.tvMelhor);
        tvPior = findViewById(R.id.tvPior);
        tvQual = findViewById(R.id.tvQual);
        llPrincipal = findViewById(R.id.llPrincipal);
        Intent valores = getIntent();

        float fAlcool = valores.getFloatExtra("Alcool", 0);
        float fGasolina = valores.getFloatExtra("Gasolina", 0);
        float fAlcoolLitro = valores.getFloatExtra("AlcoolLitro", 0);
        float fGasolinaLitro = valores.getFloatExtra("GasolinaLitro", 0);

        float GastaGasolina = fGasolina / fGasolinaLitro;
        float GastaAlcool = fAlcool / fAlcoolLitro;

        String sMelhor, sPior, sVencedor;

        if (GastaGasolina > GastaAlcool) {
            sVencedor = "O melhor para abastecer é Álcool";
            sPior = "\nO preço do kilometro da gasolinha é: " + GastaGasolina;
            sMelhor = "\nO preço do kilometro do álcool é: " + GastaAlcool;
        } else if (GastaGasolina < GastaAlcool) {
            sVencedor = "O melhor para abastecer é Gasolina";
            sPior = "\nO preço do kilometro do ácool é: " + GastaAlcool;
            sMelhor = "\nO preço do kilometro da gasolinha é: " + GastaGasolina;
        } else {
            sVencedor = "\nNão tem melhor para abastecer";
            sPior = "";
            sMelhor = "\nO preço do kilometro dos dois é: " + GastaGasolina;
        }

        AlertDialog.Builder criaAlerta = new AlertDialog.Builder(this);
        criaAlerta.setTitle("Melhor Combustivel");
        criaAlerta.setMessage(sVencedor + sMelhor + sPior);


        criaAlerta.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alerta.dismiss();
                Intent intencao = new Intent(CalcularActivity.this, ValoresActivity.class);
                startActivity(intencao);
                finish();
            }
        });

        alerta = criaAlerta.create();
        alerta.show();
    }
}
