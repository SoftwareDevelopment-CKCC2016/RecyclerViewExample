package com.vanna.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by kruyvanna on 5/31/16.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    String mDataset[];

    ViewHolderClickListener viewHolderClickListener;

    public MyAdapter(String[] mDataset) {
        this.mDataset = mDataset;
    }

    public void setViewHolderClickListener(ViewHolderClickListener viewHolderClickListener) {
        this.viewHolderClickListener = viewHolderClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView;
        public ViewHolder(LinearLayout itemRowView) {
            super(itemRowView);
            mTextView = (TextView) itemRowView.findViewById(R.id.itemText);
            itemRowView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Log.d("ViewHolder", "onclick " + position);
                    viewHolderClickListener.onClick(position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row, parent, false);

        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        holder.mTextView.setText(mDataset[position]);
    }
}
