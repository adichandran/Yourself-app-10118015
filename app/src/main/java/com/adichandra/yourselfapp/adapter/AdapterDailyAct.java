package com.adichandra.yourselfapp.adapter;

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

/*
 * NIM   : 10118015
 * NAMA  : Adi Chandra Nugraha
 * KELAS : IF1
 * TGL   : 22/05/2021
 * Deskripsi : Membuat AdapterDailyAct
 * */

public class AdapterDailyAct extends RecyclerView.Adapter<AdapterDailyAct.DailyViewHolder> {

    private final Context context;
    private final String[] dailyAct;
    private final int[] imgDaily;

    public AdapterDailyAct(Context context, String[] dailyAct, int[] imgDaily) {
        this.context = context;
        this.dailyAct = dailyAct;
        this.imgDaily = imgDaily;
    }

    @NonNull
    @Override
    public AdapterDailyAct.DailyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_dailylist, parent, false);
        return new AdapterDailyAct.DailyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull AdapterDailyAct.DailyViewHolder holder, int position) {
        holder.imageView.setImageResource(imgDaily[position]);
        holder.textView.setText(dailyAct[position]);
    }

    @Override
    public int getItemCount() {
        return dailyAct.length;
    }

    public class DailyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;

        public DailyViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.img_daily);
            textView = itemView.findViewById(R.id.txt_daily);
        }
    }

}
