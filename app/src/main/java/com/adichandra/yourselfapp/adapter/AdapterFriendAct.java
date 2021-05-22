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

public class AdapterFriendAct extends RecyclerView.Adapter<AdapterFriendAct.DailyViewHolder> {

    private final Context context;
    private final String[] friendAct;
    private final int[] imgFriend;

    public AdapterFriendAct(Context context, String[] friendAct, int[] imgFriend) {
        this.context = context;
        this.friendAct = friendAct;
        this.imgFriend = imgFriend;
    }

    @NonNull
    @Override
    public AdapterFriendAct.DailyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_friendlist, parent, false);
        return new AdapterFriendAct.DailyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull AdapterFriendAct.DailyViewHolder holder, int position) {
        holder.imageView.setImageResource(imgFriend[position]);
        holder.textView.setText(friendAct[position]);
    }

    @Override
    public int getItemCount() {
        return friendAct.length;
    }

    public class DailyViewHolder extends RecyclerView.ViewHolder{

        CircleImageView imageView;
        TextView textView;

        public DailyViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.img_friend);
            textView = itemView.findViewById(R.id.txt_friend);
        }
    }
}
