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
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.adichandra.yourselfapp.R;

import org.jetbrains.annotations.NotNull;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterMusicAct extends RecyclerView.Adapter<AdapterMusicAct.DailyViewHolder> {

    private final Context context;
    private final String[] musicAct;

    public AdapterMusicAct(Context context, String[] musicAct) {
        this.context = context;
        this.musicAct = musicAct;
    }

    @NonNull
    @Override
    public AdapterMusicAct.DailyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_musiclist, parent, false);
        return new AdapterMusicAct.DailyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull AdapterMusicAct.DailyViewHolder holder, int position) {
        holder.textView.setText(musicAct[position]);
    }

    @Override
    public int getItemCount() {
        return musicAct.length;
    }

    public class DailyViewHolder extends RecyclerView.ViewHolder{

        TextView textView;

        public DailyViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.txt_music);

        }
    }
}
