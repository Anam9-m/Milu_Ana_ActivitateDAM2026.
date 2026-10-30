package com.example.seminar4;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ListaMagazineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista_magazine);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ListView lvMagazine = findViewById(R.id.lvMagazine);

        ArrayAdapter<Magazin> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, MainActivity.magazine);
        lvMagazine.setAdapter(adapter);

        lvMagazine.setOnItemClickListener((parent, view, position, id) -> {
            Magazin magazin = MainActivity.magazine.get(position);
            Toast.makeText(this, magazin.toString(), Toast.LENGTH_LONG).show();
        });

        lvMagazine.setOnItemLongClickListener((parent, view, position, id) -> {
            MainActivity.magazine.remove(position);
            adapter.notifyDataSetChanged();
            Toast.makeText(this, "Magazin sters", Toast.LENGTH_SHORT).show();
            return true;
        });
    }
}