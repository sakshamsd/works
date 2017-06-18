package com.example.admin.works;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;

import org.json.JSONArray;

import java.util.ArrayList;

public class home_admin extends AppCompatActivity {
    //RecyclerView recyclerView;
   // TextView title, sub_title;

   LinearLayout content;

    // recyclerAdapter recyclerAdapter;

    dbhelper dbhelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_admin);




        content = (LinearLayout) findViewById(R.id.content_user);
        dbhelper = new dbhelper(this);
        populateData();


    }

    public void populateData() {
        content.removeAllViews();
        ArrayList<UserInfo> list = dbhelper.getUserList();
        for (int i = 0; i < list.size(); i++) {
            final UserInfo info = list.get(i);



            View v = LayoutInflater.from(this).inflate(R.layout.activity_home_admin,null);

            final TextView id, name, address;

            id = (TextView) v.findViewById(R.id.user_id);
            name = (TextView) v.findViewById(R.id.user_name);
            address = (TextView) v.findViewById(R.id.user_address);

            id.setText(info.id);
            name.setText(info.name);
            address.setText(info.address);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(home_admin.this, DetailActivity.class);
                    intent.putExtra("id",info.id);
                    startActivity(intent);
                }
            });

            content.addView(v);




        }


    }

    @Override
    protected void onResume() {
        super.onResume();
        populateData();
    }


}
