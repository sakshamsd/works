package com.example.admin.works.adapter;

import android.content.ClipData;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.works.R;

/**
 * Created by Admin on 5/18/2017.
 */

public class singleitem_adapter extends RecyclerView.Adapter< singleitem_adapter.item> {

    private Context context;
    private String[] items;

    public singleitem_adapter(Context context, String[] items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public item onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item_recyclerview, parent, false);
        item i = new item(view);

        return i;
    }

    @Override
    public void onBindViewHolder(item holder, int position) {
        ((item)holder).head.setText(items[position]);

    }

    @Override
    public int getItemCount() {
        return items.length;
    }

    public class item extends RecyclerView.ViewHolder{

        TextView head;

        public item(View itemView) {
            super(itemView);

            head = (TextView) itemView.findViewById(R.id.single_head);
        }
    }
}
