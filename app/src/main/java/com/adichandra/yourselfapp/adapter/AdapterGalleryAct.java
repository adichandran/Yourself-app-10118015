package com.adichandra.yourselfapp.adapter;

/*
 * NIM   : 10118015
 * NAMA  : Adi Chandra Nugraha
 * KELAS : IF1
 * TGL   : 22/05/2021
 * Deskripsi : Membuat AdapterFriendAct
 * */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.adichandra.yourselfapp.R;

import org.jetbrains.annotations.NotNull;

import de.hdodenhof.circleimageview.CircleImageView;
import soup.neumorphism.NeumorphImageView;

public class AdapterGalleryAct extends RecyclerView.Adapter<AdapterGalleryAct.DailyViewHolder> {

    private final Context context;
    private final int[] imgGallery;

    public AdapterGalleryAct(Context context, int[] imgGallery) {
        this.context = context;
        this.imgGallery = imgGallery;
    }

    @NonNull
    @Override
    public AdapterGalleryAct.DailyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_gallery, parent, false);
        return new AdapterGalleryAct.DailyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull AdapterGalleryAct.DailyViewHolder holder, int position) {
        holder.imageView.setImageResource(imgGallery[position]);
    }

    @Override
    public int getItemCount() {
        return imgGallery.length;
    }

    public class DailyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;

        public DailyViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.img_gallery);
        }
    }
}
