package com.example.admin.works;

import android.content.ContentValues;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

public class Signup extends Fragment {

    TextView name, email, mobile, address, username, password, con_pass;
    RadioGroup gender;

    int id;

    Button signup;

    dbhelper dbhelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View  view= inflater.inflate(R.layout.activity_signup, null);




        dbhelper = new dbhelper(getActivity());
        id = getActivity().getIntent().getIntExtra("id",0);

        name = (TextView) view.findViewById(R.id.name);
        email = (TextView) view.findViewById(R.id.email);
        mobile = (TextView) view.findViewById(R.id.mobile);
        address = (TextView) view.findViewById(R.id.address);
        username = (TextView) view.findViewById(R.id.username);
        password = (TextView) view.findViewById(R.id.password);
        con_pass = (TextView) view.findViewById(R.id.con_pass);
        //gender = (RadioGroup) view.findViewById(R.id.gender);
        signup = (Button) view.findViewById(R.id.sign_up);

        if(id!=0){
            UserInfo info = dbhelper.getUserInfo(id+"");

            name.setText(info.name);
            email.setText(info.email);
            mobile.setText(info.mobile);
            address.setText(info.address);
            username.setText(info.username);
        }

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nameValue = name.getText().toString();
                String emailValue = email.getText().toString();
                String mobileValue = mobile.getText().toString();
                String addressValue = address.getText().toString();
                String usernameValue = username.getText().toString();
                String passwordValue = password.getText().toString();
                String con_passValue = con_pass.getText().toString();

               // RadioButton checkedRB = (RadioButton) findViewById(gender.getCheckedRadioButtonId());
               // String genderValue = checkedRB.getText().toString();

                ContentValues cv = new ContentValues();

                cv.put("name",nameValue );
              //  cv.put("gender",genderValue );
                cv.put("email",emailValue );
                cv.put("mobile",mobileValue );
                cv.put("address",addressValue );
                cv.put("username",usernameValue );
                cv.put("password",passwordValue );
                cv.put("con_pass",con_passValue );


                if(id==0){
                    dbhelper.insertUser(cv);
                    Toast.makeText(getActivity(),"User Info Inserted",Toast.LENGTH_LONG).show();

                }
                else {
                    dbhelper.update(cv, String.valueOf(id));
                    Toast.makeText(getActivity(),"User Info Updated",Toast.LENGTH_LONG).show();
                   getActivity().finish();

                }



            }
        });
        return view;

    }


}
