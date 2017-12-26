package com.application1.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.application1.R;
import com.application1.activity.MainActivity;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private int menIndex, womenIndex, merchandiseIndex, startIndex, endIndex;
    private ImageView ivMen, ivWomen, ivMerchandise;
    private ArrayList<Integer> menImages, womenImages, merchandise;


    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        ivMen = (ImageView) rootView.findViewById(R.id.iv_men);
        ivWomen = (ImageView) rootView.findViewById(R.id.iv_women);
        ivMerchandise = (ImageView) rootView.findViewById(R.id.iv_merchandise);
        menImages = new ArrayList<>();
        womenImages = new ArrayList<>();
        merchandise = new ArrayList<>();

        ivMen.setOnClickListener(this);
        ivWomen.setOnClickListener(this);
        ivMerchandise.setOnClickListener(this);

        menImages.add(R.drawable.men_jacket_1);
        menImages.add(R.drawable.shoe_men_1);
        menImages.add(R.drawable.men_wallet_1);

        womenImages.add(R.drawable.women_jacket_1);
        womenImages.add(R.drawable.shoe_women_1);
        womenImages.add(R.drawable.women_wallet_1);

        merchandise.add(R.drawable.men_jacket_3);
        merchandise.add(R.drawable.men_wallet_3);
        merchandise.add(R.drawable.women_jacket_3);
        merchandise.add(R.drawable.shoe_men_3);
        merchandise.add(R.drawable.women_wallet_3);

        startIndex = 0;
        endIndex = 2;

        return rootView;
    }


    public void nextImageForMen() {
        ivMen.setImageResource(menImages.get(menIndex));
        Animation rotateimage = AnimationUtils.loadAnimation(getContext(), R.anim.fab_slide_in_from_right);
        ivMen.startAnimation(rotateimage);
        menIndex++;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (menIndex > endIndex) {
                    menIndex--;
                    previousImageForMen();
                } else {
                    nextImageForMen();
                }

            }
        }, 3000); // here 1000(1 second) interval to change from current  to next image

    }

    public void previousImageForMen() {
        ivMen.setImageResource(menImages.get(menIndex));
        Animation rotateimage = AnimationUtils.loadAnimation(getContext(), R.anim.fab_slide_in_from_right);
        ivMen.startAnimation(rotateimage);
        menIndex--;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (menIndex < startIndex) {
                    menIndex++;
                    nextImageForMen();
                } else {
                    previousImageForMen(); // here 1000(1 second) interval to change from current  to previous image
                }
            }
        }, 3000);
    }

    public void nextImageForWomen() {
        ivWomen.setImageResource(womenImages.get(womenIndex));
        Animation rotateimage = AnimationUtils.loadAnimation(getContext(), R.anim.fab_slide_in_from_right);
        ivWomen.startAnimation(rotateimage);
        womenIndex++;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (womenIndex > endIndex) {
                    womenIndex--;
                    previousImageForWomen();
                } else {
                    nextImageForWomen();
                }

            }
        }, 3000); // here 1000(1 second) interval to change from current  to next image

    }

    public void previousImageForWomen() {
        ivWomen.setImageResource(womenImages.get(womenIndex));
        Animation rotateimage = AnimationUtils.loadAnimation(getContext(), R.anim.fab_slide_in_from_right);
        ivWomen.startAnimation(rotateimage);
        womenIndex--;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (womenIndex < startIndex) {
                    womenIndex++;
                    nextImageForWomen();
                } else {
                    previousImageForWomen(); // here 1000(1 second) interval to change from current  to previous image
                }
            }
        }, 3000);

    }

    public void nextImageForMerchandise() {
        ivMerchandise.setImageResource(merchandise.get(merchandiseIndex));
        Animation rotateimage = AnimationUtils.loadAnimation(getContext(), R.anim.fab_slide_in_from_right);
        ivMerchandise.startAnimation(rotateimage);
        merchandiseIndex++;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (merchandiseIndex > endIndex) {
                    merchandiseIndex--;
                    previousImageForMerchandise();
                } else {
                    nextImageForMerchandise();
                }

            }
        }, 3000); // here 1000(1 second) interval to change from current  to next image

    }

    public void previousImageForMerchandise() {
        ivMerchandise.setImageResource(merchandise.get(merchandiseIndex));
        Animation rotateimage = AnimationUtils.loadAnimation(getContext(), R.anim.fab_slide_in_from_right);
        ivMerchandise.startAnimation(rotateimage);
        merchandiseIndex--;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (merchandiseIndex < startIndex) {
                    merchandiseIndex++;
                    nextImageForMerchandise();
                } else {
                    previousImageForMerchandise(); // here 1000(1 second) interval to change from current  to previous image
                }
            }
        }, 3000);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_men:
                ((MainActivity) getActivity()).setTabFragment(4);
                break;
            case R.id.iv_women:
                ((MainActivity) getActivity()).setTabFragment(4);
                break;
            case R.id.iv_merchandise:
                ((MainActivity) getActivity()).setTabFragment(4);
                break;
        }
    }
}
