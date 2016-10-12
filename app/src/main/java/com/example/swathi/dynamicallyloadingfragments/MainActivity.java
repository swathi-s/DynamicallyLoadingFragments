package com.example.swathi.dynamicallyloadingfragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextClock;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    TextView loginTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.new_user);

        loginTxt = (TextView) findViewById(R.id.load_login);

        FragmentManager fragment = getFragmentManager();

        FragmentTransaction fragmentTransaction = fragment.beginTransaction();

        LoginFragment loginFragment = new LoginFragment();

        fragmentTransaction.add(R.id.fragment_container,loginFragment);

        fragmentTransaction.commit();

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RegisterFragment registerFragment = new RegisterFragment();

                FragmentManager fragmentManager = getFragmentManager();

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container,registerFragment);
                fragmentTransaction.commit();
            }
        });

        loginTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                LoginFragment loginFragment = new LoginFragment();

                fragmentTransaction.replace(R.id.fragment_container,loginFragment);
                fragmentTransaction.commit();
            }
        });
    }
}
