package com.ikaslea.listviewkontrolaberstsio2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

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

        ViewHolder holder;

        if (convertView == null) {

            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);


            holder = new ViewHolder();
            holder.textPrincipal = convertView.findViewById(R.id.textPrincipal);
            holder.textSecundario = convertView.findViewById(R.id.textSecundario);


            convertView.setTag(holder);
        } else {

            holder = (ViewHolder) convertView.getTag();
        }


        Hizkuntzak idioma = idiomas.get(position);
        holder.textPrincipal.setText(idioma.getNombre());
        holder.textSecundario.setText(idioma.getFrase());

        return convertView;
    }
    static class ViewHolder {
        TextView textPrincipal;
        TextView textSecundario;
    }
}
