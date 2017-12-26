package com.application1.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.application1.R;
import com.application1.activity.MainActivity;

/**
 * Created by Ramya on 10/25/2017.
 */

public class MenFragment extends Fragment implements View.OnClickListener{

    public static MenFragment newInstance() {
        return new MenFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_men, container, false);
        LinearLayout llShoe=(LinearLayout)rootView.findViewById(R.id.ll_men_shoe);
        LinearLayout llWallet=(LinearLayout)rootView.findViewById(R.id.ll_men_wallet);
        LinearLayout llJacket=(LinearLayout)rootView.findViewById(R.id.ll_men_jacket);

        llJacket.setOnClickListener(this);
        llWallet.setOnClickListener(this);
        llShoe.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.ll_men_jacket:
                ((MainActivity)getActivity()).setTabFragment(5);
                break;
            case R.id.ll_men_shoe:
                ((MainActivity)getActivity()).setTabFragment(5);
                break;
            case R.id.ll_men_wallet:
                ((MainActivity)getActivity()).setTabFragment(5);
                break;
        }
    }
}
