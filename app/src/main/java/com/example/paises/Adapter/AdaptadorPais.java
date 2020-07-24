package com.example.paises.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.paises.Model.Pais;
import com.example.paises.R;

import java.util.ArrayList;

public class AdaptadorPais extends RecyclerView.Adapter<AdaptadorPais.ViewHolderPaises>{
    ArrayList<Pais> listaPaises;
    Activity activity;

    public AdaptadorPais(ArrayList<Pais> listaPaises, Activity activity) {
        this.listaPaises = listaPaises;
        this.activity = activity;
    }

    @Override
    public ViewHolderPaises onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.ly_paises,null,false);
        return new ViewHolderPaises(view);
    }

    @Override
    public void onBindViewHolder(AdaptadorPais.ViewHolderPaises holder, int position) {
        Pais pais = listaPaises.get(position);
        holder.lblPais.setText(listaPaises.get(position).getName());
        Glide.with(activity)
                .load(pais.getImagen())
                .into(holder.imgImagen);
    }

    @Override
    public int getItemCount() {
        return listaPaises.size();
    }

    public class ViewHolderPaises extends RecyclerView.ViewHolder {

        TextView lblPais;
        ImageView imgImagen;

        public ViewHolderPaises(View itemView) {
            super(itemView);
            lblPais = (TextView) itemView.findViewById(R.id.lblPais);
            imgImagen = (ImageView) itemView.findViewById(R.id.imgImagen);
        }
    }
}
