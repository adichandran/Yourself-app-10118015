package com.adichandra.yourselfapp.fragment.navigation;

/*
 * NIM   : 10118015
 * NAMA  : Adi Chandra Nugraha
 * KELAS : IF1
 * TGL   : 12/05/2021
 * Deskripsi : Membuat Tampilan FragmentDaily
 * */

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adichandra.yourselfapp.R;
import com.adichandra.yourselfapp.adapter.AdapterDailyAct;
import com.adichandra.yourselfapp.adapter.AdapterFriendAct;
import com.adichandra.yourselfapp.model.modelApp;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentDaily#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentDaily extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentDaily() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentDaily.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentDaily newInstance(String param1, String param2) {
        FragmentDaily fragment = new FragmentDaily();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_daily, container, false);

        final FragmentActivity fragment = getActivity();
        final FragmentActivity fragment2 = getActivity();
        RecyclerView recyclerView = view.findViewById(R.id.daily_act);
        RecyclerView recyclerView2 = view.findViewById(R.id.friend_act);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(fragment2, LinearLayoutManager.HORIZONTAL,false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(fragment, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView2.setLayoutManager(layoutManager2);
        modelApp model = new modelApp();


        // Daily Activity Value
        int[] imgDaily = {R.drawable.praying, R.drawable.game, R.drawable.trading, R.drawable.tv};
        String[] dailyAct = {
                "Solat", "Bermain Game", "Trading", "Menonton TV"
        };

        model.setImgDaily(imgDaily);
        model.setDailyAct(dailyAct);

        //Friend List Value
        int[] imgFriend = {R.drawable.fr1, R.drawable.fr2, R.drawable.fr3, R.drawable.fr4, R.drawable.fr5};
        String[] friendAct = {
                "Dara Putri Lestari", "Neng Devi Yanti", "Irfan Maulana", "M. Alfi Akbar", "M. Geisha"
        };

        model.setImgFriend(imgFriend);
        model.setFriendAct(friendAct);

        //
        new Thread(new Runnable() {
            @Override
            public void run() {
                final AdapterDailyAct adapter = new AdapterDailyAct(fragment, model.getDailyAct(),model.getImgDaily());
                fragment.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView.setAdapter(adapter);
                    }

                });
            }
        }).start();

        //
        new Thread(new Runnable() {
            @Override
            public void run() {
                final AdapterFriendAct adapter = new AdapterFriendAct(fragment,model.getFriendAct(), model.getImgFriend());
                fragment.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView2.setAdapter(adapter);
                    }

                });
            }
        }).start();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Daily Activity");
    }

}