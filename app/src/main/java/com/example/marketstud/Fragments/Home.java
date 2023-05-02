package com.example.marketstud.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.marketstud.Card1Activity;
import com.example.marketstud.Card2Activity;
import com.example.marketstud.Card3Activity;
import com.example.marketstud.Card4Activity;
import com.example.marketstud.R;
import com.example.marketstud.databinding.FragmentHomeBinding;


public class Home extends Fragment implements View.OnClickListener {


    FragmentHomeBinding binding;

    private CardView card1, card2, card3, card4;

    public Home() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        card1 = view.findViewById(R.id.card1);
        card2 = view.findViewById(R.id.card2);
        card3 = view.findViewById(R.id.card3);
        card4 = view.findViewById(R.id.card4);

        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        binding=null;
    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()) {
            case R.id.card1:
                i = new Intent(getActivity(), Card1Activity.class);
                startActivity(i);
                break;
            case R.id.card2:
                i = new Intent(getActivity(), Card2Activity.class);
                startActivity(i);
                break;
            case R.id.card3:
                i = new Intent(getActivity(), Card3Activity.class);
                startActivity(i);
                break;
            case R.id.card4:
                i = new Intent(getActivity(), Card4Activity.class);
                startActivity(i);
                break;
            default:
                break;
        }
    }

}