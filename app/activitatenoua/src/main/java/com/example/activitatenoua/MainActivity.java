package com.example.activitatenoua;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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
    }

    public void deschideActivitate(View view ) {
        Intent it = new Intent(this, ActivitateRezultat.class);
        Bundle bundle = new Bundle();
        bundle.putString("mesaj", "Mesaj din prima activitate");
        bundle.putInt("numar1", 5);
        bundle.putInt("numar2", 5);

        it.putExtras(bundle);

        startActivity(it);// independent
        startActivityForResult(it, 52);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==52)
        {
            if(resultCode==RESULT_OK)
            {
                String mesaj=data.getStringExtra("altMesaj");
                int suma=data.getIntExtra("suma",0);
                StringBuilder builder=new StringBuilder();
                builder.append(mesaj);
                builder.append(" ");
                builder.append(suma);
                Toast.makeText(this,builder.toString(),Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Seminar","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.w("Seminar","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Seminar","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Seminar","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("Seminar","onDestroy");
    }

}