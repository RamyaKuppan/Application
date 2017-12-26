package com.application1.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.application1.R;
import com.application1.adapter.ProductViewAdapter;

/**
 * Created by Ramya on 10/25/2017.
 */

public class ProductViewFragment extends Fragment {

    public static ProductViewFragment newInstance()
    {
        return new ProductViewFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_product_view,container,false);

        RecyclerView rvProductView=(RecyclerView)view.findViewById(R.id.rv_product_photo);

        GridLayoutManager manager=new GridLayoutManager(getActivity(),2);

        ProductViewAdapter adapter=new ProductViewAdapter(getActivity());
        rvProductView.setLayoutManager(manager);
        rvProductView.setAdapter(adapter);

        return view;
    }
}
