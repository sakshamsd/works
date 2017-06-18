package com.example.admin.works.activities;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.works.R;
import com.example.admin.works.Signup;
import com.example.admin.works.dbhelper;
import com.example.admin.works.home_admin;

public class Signin extends Fragment {

    EditText username, password;
    Button signin, signup;

    com.example.admin.works.dbhelper dbhelper;


    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_signin, null);





        dbhelper = new dbhelper(getActivity());

        username = (EditText) view.findViewById(R.id.user);
        password = (EditText) view.findViewById(R.id.password);

        signin = (Button) view.findViewById(R.id.signin);
        signup = (Button) view.findViewById(R.id.signup);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Signup.class);
                startActivity(intent);
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String usernameValue = username.getText().toString();
                String passwordValue = password.getText().toString();
                if(dbhelper.login(usernameValue, passwordValue)){
                    Intent intent = new Intent(getActivity(), home_admin.class);
                    startActivity(intent);
                    Toast.makeText(getActivity(), "Login Successful", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getActivity(), "Login Failure", Toast.LENGTH_LONG).show();
                }

            }
        });

        return view;

    }


}
