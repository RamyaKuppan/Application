package com.application1.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.application1.R;

/**
 * Created by Ramya on 10/25/2017.
 */

public class ProductViewAdapter extends RecyclerView.Adapter {


    private final LayoutInflater inflater;

    public ProductViewAdapter(Context context)
    {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        View headerView = inflater.inflate(R.layout.layout_product_view, parent, false);
        viewHolder = new ProductHolder(headerView);
        return viewHolder;    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    private class ProductHolder extends RecyclerView.ViewHolder
    {

        ProductHolder(View itemView) {
            super(itemView);
        }
    }
}
