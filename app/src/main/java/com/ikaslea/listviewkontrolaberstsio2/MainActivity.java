package com.ikaslea.listviewkontrolaberstsio2;

import android.os.Bundle;
import android.widget.AdapterView;
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
        ListView listViewIdiomas = findViewById(R.id.ListView1);
        TextView textViewSeleccionado = findViewById(R.id.textViewSeleccionado);


        ArrayList<Hizkuntzak> idiomas = new ArrayList<>();
        idiomas.add(new Hizkuntzak(getString(R.string.castellano), getString(R.string.frase_castellano)));
        idiomas.add(new Hizkuntzak(getString(R.string.euskera), getString(R.string.frase_euskera)));
        idiomas.add(new Hizkuntzak(getString(R.string.ingles), getString(R.string.frase_ingles)));
        idiomas.add(new Hizkuntzak(getString(R.string.aleman), getString(R.string.frase_aleman)));
        idiomas.add(new Hizkuntzak(getString(R.string.noruego), getString(R.string.frase_noruego)));


        HizkuntzaAdapter adapter = new HizkuntzaAdapter(this, idiomas);
        listViewIdiomas.setAdapter(adapter);


        listViewIdiomas.setOnItemClickListener((AdapterView<?> parent, android.view.View view, int position, long id) -> {

            textViewSeleccionado.setText(idiomas.get(position).getFrase());
        });
    }
}