package com.ikaslea.listviewkontrolaberstsio2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class HizkuntzaAdapter extends BaseAdapter {
    private final Context context;
    private final ArrayList<Hizkuntzak> idiomas;

    public HizkuntzaAdapter(Context context, ArrayList<Hizkuntzak> idiomas) {
        this.context = context;
        this.idiomas = idiomas;
    }

    @Override
    public int getCount() {
        return idiomas.size();
    }

    @Override
    public Object getItem(int position) {
        return idiomas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }

        Hizkuntzak idioma = (Hizkuntzak) getItem(position);

        TextView textPrincipal = convertView.findViewById(R.id.textPrincipal);
        TextView textSecundario = convertView.findViewById(R.id.textSecundario);

        textPrincipal.setText(idioma.getNombre());
        textSecundario.setText(idioma.getFrase());

        return convertView;
    }
}
