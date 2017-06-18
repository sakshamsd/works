package com.example.admin.works.fragment;

import android.content.Context;
import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.admin.works.R;
import com.example.admin.works.adapter.singleitem_adapter;

public class singleItem_recycler extends Fragment {

    Context context;
    RecyclerView single_recycler;
    String items[]= {"item 1","item 2","item 3","item 4","item 5","item 6","item 7","item 8",
            "item 9","item 10","item 11","item 12","item 13","item 14","item 15","item 16","item 17"};

    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_single_item_recycler, null);

        single_recycler = (RecyclerView) view.findViewById(R.id.singleitem_recycler);

        single_recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        single_recycler.setAdapter(new singleitem_adapter(getActivity(), items));





        return view;


    }

    public void onConfigurationChanged(Configuration newConfig)
    {
        Log.d("tag", "config changed");
        super.onConfigurationChanged(newConfig);

        int orientation = newConfig.orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            Log.d("tag", "Portrait");
            setLinearLayout();
        }
        else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Log.d("tag", "Landscape");
            setGridLayout();
        }
        else
            Log.w("tag", "other: " + orientation);


    }

    //private void SetLayout() {
//        var o = orientation....
//        if (land) setGridLayout
//                else setLinearLayout
   // }

    private void setLinearLayout(){

        single_recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private void setGridLayout(){
        single_recycler.setLayoutManager(new GridLayoutManager(context, 2));

    }
}
