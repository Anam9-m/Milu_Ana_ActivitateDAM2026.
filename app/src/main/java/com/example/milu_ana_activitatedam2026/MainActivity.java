package com.example.milu_ana_activitatedam2026;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvRezultat;

    private final ActivityResultLauncher<Intent> deschideAdaugare = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            rezultat -> {
                if (rezultat.getResultCode() == RESULT_OK && rezultat.getData() != null) {
                    Magazin magazin = (Magazin) rezultat.getData().getSerializableExtra("magazin");
                    if (magazin != null) {
                        tvRezultat.setText(magazin.toString());
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvRezultat = findViewById(R.id.tvRezultat);
        Button btnAdauga = findViewById(R.id.btnAdauga);

        btnAdauga.setOnClickListener(v ->
                deschideAdaugare.launch(new Intent(MainActivity.this, ActivitateNouaMagazin.class)));
    }
}