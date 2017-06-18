package com.example.admin.works.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.admin.works.R;
import com.example.admin.works.adapter.recyclerAdapter;
import com.example.admin.works.dummy_list;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 5/18/2017.
 */

public class recyclerview_activity extends Fragment implements com.example.admin.works.adapter.recyclerAdapter.OnDummyListener, com.example.admin.works.adapter.recyclerAdapter.OnDummyLongClickListener {
    RecyclerView recyclerView;
    recyclerAdapter recyclerAdapter;
    private List<dummy_list> players = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.recyclerview_main, null);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        recyclerAdapter = new recyclerAdapter(getContext(), players, this, this);

        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);


        playersList();




        return view;
    }


    public void playersList(){
        dummy_list dummy_list = new dummy_list("Keylor Navas","Costa Rica","28");
        players.add(dummy_list);


        dummy_list = new dummy_list("Dani Carvajal","Spain","23");
        players.add(dummy_list);

        dummy_list = new dummy_list("Pepe","Portugal","34");
        players.add(dummy_list);

        dummy_list = new dummy_list("Sergio Ramos","Spain","31");
        players.add(dummy_list);

        dummy_list = new dummy_list("Raphael Varane","France","23");
        players.add(dummy_list);

        dummy_list = new dummy_list("Nacho Fernandez","Spain","26");
        players.add(dummy_list);

        dummy_list = new dummy_list("Cristiano Ronaldo","Portugal","32");
        players.add(dummy_list);

        dummy_list = new dummy_list("Toni Kroos","Germanya","26");
        players.add(dummy_list);

        dummy_list = new dummy_list("Karim Benzema","France","28");
        players.add(dummy_list);

        dummy_list = new dummy_list("James Rodriguez","Columbia","25");
        players.add(dummy_list);

        dummy_list = new dummy_list("Gareth Bale","Wales","28");
        players.add(dummy_list);

        dummy_list = new dummy_list("Marcelo","Brazil","28");
        players.add(dummy_list);

        dummy_list = new dummy_list("Keylor Navas","Costa Rica","28");
        players.add(dummy_list);

        dummy_list = new dummy_list("Keylor Navas","Costa Rica","28");
        players.add(dummy_list);

        dummy_list = new dummy_list("Keylor Navas","Costa Rica","28");
        players.add(dummy_list);

        dummy_list = new dummy_list("Keylor Navas","Costa Rica","28");
        players.add(dummy_list);

        recyclerAdapter.notifyDataSetChanged();


        Log.d("myapp", "added player list");
    }

    @Override
    public void OnClick(dummy_list dummy) {
        Log.d("myappclick", dummy.toString() + " was clicked");
        Log.d("myappclick", dummy.getName());
    }


    @Override
    public void OnLongClick(dummy_list dummy) {
        String name = dummy.getName();

       Toast.makeText(getContext(),name,Toast.LENGTH_SHORT).show();
    }
}
