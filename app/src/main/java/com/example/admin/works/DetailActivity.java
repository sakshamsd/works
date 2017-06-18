package com.example.admin.works;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.BundleCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Admin on 5/15/2017.
 */

public class DetailActivity extends AppCompatActivity {


    dbhelper dbhelper;
    String id;
    Button update, delete;
    TextView _id, name,email, address, mobile, username;

    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.user_detail);

        id = getIntent().getStringExtra("id");
        dbhelper = new dbhelper(this);

        _id = (TextView) findViewById(R.id.id_id);
        name = (TextView) findViewById(R.id.id_name);
        mobile = (TextView) findViewById(R.id.id_mobile);
        address = (TextView) findViewById(R.id.id_address);
        username = (TextView) findViewById(R.id.id_username);
        email = (TextView) findViewById(R.id.id_email);
        populateData();


        update = (Button) findViewById(R.id.update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailActivity.this, Signup.class);
                intent.putExtra("id", Integer.parseInt(String.valueOf(id)));
                startActivity(intent);
            }
        });

        delete = (Button) findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmation();
            }
        });

    }

    public void populateData(){
        UserInfo info = dbhelper.getUserInfo(id);


        _id.setText("ID:"+info.id);
        name.setText("Name:"+info.name);
        email.setText("Email:"+ info.email);
        mobile.setText("Mobile:"+info.mobile);
        address.setText("Address:"+info.address);
        username.setText("Username:"+info.username);

    }


    public void onResume(){
        super.onResume();
        populateData();

    }

    public void confirmation(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Delete User?");
        alert.setMessage("Are you sure?");
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dbhelper.deleteUser(id);
                finish();

            }
        });
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alert.show();
    }

}
