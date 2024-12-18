package com.ikaslea.listviewkontrolaberstsio2;

import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridViewIdiomas = findViewById(R.id.gridViewIdiomas);
        TextView textViewSeleccionado = findViewById(R.id.textViewSeleccionado);


        ArrayList<Hizkuntzak> hizkuntzak = new ArrayList<>();
        for (int i = 1; i <= 29; i++) {
            int nombreResId = getResources().getIdentifier("idioma_" + i, "string", getPackageName());
            int fraseResId = getResources().getIdentifier("frase_" + i, "string", getPackageName());

            if (nombreResId != 0 && fraseResId != 0) {
                String nombre = getString(nombreResId);
                String frase = getString(fraseResId);
                hizkuntzak.add(new Hizkuntzak(nombre, frase));
            } else {
                Log.e("MainActivity", "Errekurtsoa ez da aurkitu: Hizkuntza" + i + " edo Esaldi" + i);
            }
        }


        HizkuntzaAdapter adapter = new HizkuntzaAdapter(this, hizkuntzak);
        gridViewIdiomas.setAdapter(adapter);


        gridViewIdiomas.setOnItemClickListener((AdapterView<?> parent, android.view.View view, int position, long id) -> {
            String frase = hizkuntzak.get(position).getFrase();
            textViewSeleccionado.setText(frase);
        });


        textViewSeleccionado.setText("Ez da larunbata eta euria ari du");
    }
}