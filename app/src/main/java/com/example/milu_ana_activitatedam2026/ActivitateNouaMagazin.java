package com.example.milu_ana_activitatedam2026;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ActivitateNouaMagazin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitate_noua_magazin);

        EditText etDenumire = findViewById(R.id.etDenumire);
        EditText etSuprafata = findViewById(R.id.etSuprafata);
        CheckBox cbNonStop = findViewById(R.id.cbGol);
        RadioGroup rgTip = findViewById(R.id.rgTip);
        Spinner spOras = findViewById(R.id.spOras);
        RatingBar rbRating = findViewById(R.id.rbRating);
        Switch swParcare = findViewById(R.id.swParcare);
        Button btnSalvare = findViewById(R.id.btnSalvare);

        btnSalvare.setOnClickListener(v -> {
            String denumire = etDenumire.getText().toString().trim();
            String suprafataText = etSuprafata.getText().toString().trim();

            if (denumire.isEmpty() || suprafataText.isEmpty()) {
                Toast.makeText(this, "Completează toate câmpurile!", Toast.LENGTH_SHORT).show();
                return;
            }

            RadioButton tipAles = findViewById(rgTip.getCheckedRadioButtonId());

            Magazin magazin = new Magazin(
                    denumire,
                    Integer.parseInt(suprafataText),
                    cbNonStop.isChecked(),
                    tipAles.getText().toString(),
                    spOras.getSelectedItem().toString(),
                    rbRating.getRating(),
                    swParcare.isChecked()
            );

            Intent rezultat = new Intent();
            rezultat.putExtra("magazin", magazin);
            setResult(RESULT_OK, rezultat);
            finish();
        });
    }
}