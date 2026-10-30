package com.example.seminar4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Magazin> magazine = new ArrayList<>();

    TextView tvMagazin;
    ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvMagazin = findViewById(R.id.tvMagazin);
        Button btnAdauga = findViewById(R.id.btnAdauga);
        Button btnAdaugaAI = findViewById(R.id.btnAdaugaAI);
        Button btnLista = findViewById(R.id.btnLista);

        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                Bundle bundle = result.getData().getExtras();
                Magazin magazin = (Magazin) bundle.getSerializable("magazin");
                magazine.add(magazin);
                tvMagazin.setText(magazin.toString());
                Toast.makeText(this, "Magazin adaugat in lista!", Toast.LENGTH_SHORT).show();
            }
        });

        btnAdauga.setOnClickListener(v -> {
            Intent intent = new Intent(this, AdaugaMagazinActivity.class);
            launcher.launch(intent);
        });

        btnAdaugaAI.setOnClickListener(v -> {
            Intent intent = new Intent(this, AdaugaMagazinAIActivity.class);
            launcher.launch(intent);
        });

        btnLista.setOnClickListener(v -> {
            Intent intent = new Intent(this, ListaMagazineActivity.class);
            startActivity(intent);
        });
    }
}