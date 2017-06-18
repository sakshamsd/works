package com.example.admin.works.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.works.R;
import com.example.admin.works.activities.Signin;
import com.example.admin.works.dummy_list;

import java.util.List;

/**
 * Created by Admin on 5/18/2017.
 */

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.MyViewHolder> {
    private List<dummy_list> players;
    Context context;
    OnDummyListener listener;
    OnDummyLongClickListener longClickListener;
    int selectedindex;



    public recyclerAdapter(Context context, List<dummy_list> players, OnDummyListener listener, OnDummyLongClickListener longClickListener) {

        this.players = players;
        this.context = context;
        this.listener = listener;
        this.longClickListener = longClickListener;

    }




    @Override
    public recyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_items,parent,false);
    Log.d("myapp", "oncreateviewholder");
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(final recyclerAdapter.MyViewHolder holder, final int position) {

        dummy_list player = players.get(position);

        holder.name.setText(player.getName());
        holder.nationality.setText(player.getNationality());
        holder.bind(player, listener, longClickListener);

        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(holder.img, position);
            }
        });


        //holder.age.setText(player.getAge());








        Log.d("myapp", player.getName());



    }

    private void showPopupMenu(View view, int itemposition) {
        selectedindex = itemposition;
        PopupMenu popup = new PopupMenu(context, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.dummy_popup, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }

    @Override
    public int getItemCount() {
        return players.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View. OnClickListener{
        TextView name, nationality, age, menu;
        ImageView img;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            name = (TextView) itemView.findViewById(R.id.name);
            nationality = (TextView) itemView.findViewById(R.id.nationality);
            img = (ImageView) itemView.findViewById(R.id.imageView);
            //age = (TextView) itemView.findViewById(R.id.age);
           // menu = (TextView) itemView.findViewById(R.id.menu);

        }

        @RequiresApi(api = Build.VERSION_CODES.M)
        public void bind(final dummy_list dummy, final OnDummyListener listener, final OnDummyLongClickListener longClickListener) {
            itemView.setOnLongClickListener(new View.OnLongClickListener(){
                @Override
                public boolean onLongClick(View v) {
                    longClickListener.OnLongClick(dummy);
                    return true;
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.OnClick(dummy);
                }
            });
        }



        @Override
        public void onClick(View view) {
            Log.d("toast", "clickable");
            Toast.makeText(context, "click", Toast.LENGTH_SHORT).show();
            context.startActivity(new Intent(context, Signin.class));
        }
    }

    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {
        public MyMenuItemClickListener() {

        }


        @Override
        public boolean onMenuItemClick(MenuItem item) {
            Log.d("myappmenu", item.toString());
            return false;
        }
    }

    public interface OnDummyListener {
        void OnClick(dummy_list dummy);
    }

    public interface OnDummyLongClickListener {
        void OnLongClick(dummy_list dummy);
    }
}
