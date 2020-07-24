package com.example.paises.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.paises.MainActivity;
import com.example.paises.MainActivity2;
import com.example.paises.Model.Pais;
import com.example.paises.R;

import java.util.ArrayList;

public class AdaptadorPais extends RecyclerView.Adapter<AdaptadorPais.ViewHolderPaises>{

    ArrayList<Pais> listaPaises;
    //Activity activity;
    private Context Ctx;
    int posicionMarcada=0;

    public AdaptadorPais(ArrayList<Pais> listaPaises, Context mCtx) {
        this.listaPaises = listaPaises;
        Ctx=mCtx;
    }

    @Override
    public ViewHolderPaises onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.ly_paises,null,false);
        return new ViewHolderPaises(view);
    }

    @Override
    public void onBindViewHolder(AdaptadorPais.ViewHolderPaises holder, final int position) {
        Pais pais = listaPaises.get(position);
        holder.lblPais.setText(listaPaises.get(position).getName());
        Glide.with(Ctx)
                .load(pais.getImagen())
                .into(holder.imgImagen);

        final int pos=position;

        /*holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mContext, GalleryActivity.class);
                intent.putExtra("image_url", mImages.get(position));
                intent.putExtra("image_name", mImageNames.get(position));
                mContext.startActivity(intent);
            }
        });*/

        holder.imgImagen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                posicionMarcada=pos;
                notifyDataSetChanged();
            }
        });

        if(posicionMarcada==position){
            Intent intent= new Intent(Ctx, MainActivity2.class);
            intent.putExtra("pais",listaPaises.get(position).getName());
            Ctx.startActivity(intent);
        }
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
