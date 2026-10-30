package com.example.seminar4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AdaugaMagazinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adauga_magazin);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText etDenumire = findViewById(R.id.etDenumire);
        EditText etNrAngajati = findViewById(R.id.etNrAngajati);
        EditText etSuprafata = findViewById(R.id.etSuprafata);
        Spinner spnOras = findViewById(R.id.spnOras);
        RadioButton rbAlimentar = findViewById(R.id.rbAlimentar);
        CheckBox cbParcare = findViewById(R.id.cbParcare);
        Switch swNonStop = findViewById(R.id.swNonStop);
        RatingBar rbRating = findViewById(R.id.rbRating);
        Button btnSalvare = findViewById(R.id.btnSalvare);

        String[] orase = {"Bucuresti", "Cluj", "Iasi"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, orase);
        spnOras.setAdapter(adapter);

        btnSalvare.setOnClickListener(v -> {
            if (etDenumire.getText().toString().isEmpty()
                    || etNrAngajati.getText().toString().isEmpty()
                    || etSuprafata.getText().toString().isEmpty()) {
                Toast.makeText(this, "Completeaza toate campurile", Toast.LENGTH_SHORT).show();
                return;
            }

            String tip;
            if (rbAlimentar.isChecked()) {
                tip = "Alimentar";
            } else {
                tip = "Electronice";
            }

            Magazin magazin = new Magazin(
                    etDenumire.getText().toString(),
                    Integer.parseInt(etNrAngajati.getText().toString()),
                    Float.parseFloat(etSuprafata.getText().toString()),
                    spnOras.getSelectedItem().toString(),
                    tip,
                    cbParcare.isChecked(),
                    swNonStop.isChecked(),
                    rbRating.getRating());

            Bundle bundle = new Bundle();
            bundle.putSerializable("magazin", magazin);

            Intent intent = new Intent();
            intent.putExtras(bundle);
            setResult(RESULT_OK, intent);
            finish();
        });
    }
}