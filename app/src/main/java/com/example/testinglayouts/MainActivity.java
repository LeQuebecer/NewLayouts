package com.example.testinglayouts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;


import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity implements TestFragment1.FragmentOneListener, TestFragment2.FragmentTwoListener, MainFragment.FragmentMainListener{



    private TestFragment1 testFragment1;
    private TestFragment2 testFragment2;
    private MainFragment mainFragment;
    static Logger LOG = Logger.getLogger(MainActivity.class.getName());
    Button buttonOne, buttonTwo;
    FragmentManager fm;
    FragmentTransaction fmt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testFragment1 = new TestFragment1();
        testFragment2 = new TestFragment2();
        mainFragment = new MainFragment();

        if (findViewById(R.id.theFiller) != null) {
            if(savedInstanceState != null){
                return;
            }

            MainFragment mainFragment = new MainFragment();
            mainFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.theFiller, mainFragment).commit();
        }

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.new_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void getFragmentOne(View v){


        Bundle args = new Bundle();
        testFragment1.setArguments(args);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

// Replace whatever is in the fragment_container view with this fragment,
// and add the transaction to the back stack so the user can navigate back
        transaction.replace(R.id.theFiller, testFragment1);
        transaction.addToBackStack(null);

// Commit the transaction
        transaction.commit();
    }

    public void getFragmentTwo(View v){


        Bundle args = new Bundle();
        testFragment2.setArguments(args);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

// Replace whatever is in the fragment_container view with this fragment,
// and add the transaction to the back stack so the user can navigate back
        transaction.replace(R.id.theFiller, testFragment2);
        transaction.addToBackStack(null);

// Commit the transaction
        transaction.commit();
    }


    public void getFragmentMain(View v){


        Bundle args = new Bundle();
        mainFragment.setArguments(args);
        fmt = getSupportFragmentManager().beginTransaction();
        fmt.replace(R.id.theFiller, mainFragment);
        fmt.addToBackStack(null);


// Commit the transaction
        fmt.commit();
    }


    @Override
    public void mainScreen() {
        System.out.println("Why am I in the Main Activity, Dave?");
        //New problem is that this DOES NOT WORK.
        Bundle args = new Bundle();
        mainFragment.setArguments(args);
        fmt = getSupportFragmentManager().beginTransaction();
        fmt.replace(R.id.theFiller, mainFragment);
        fmt.addToBackStack(null);
        fmt.commit();
    }

    @Override
    public void screenOne() {
        Bundle args = new Bundle();
        testFragment1.setArguments(args);
        fmt = getSupportFragmentManager().beginTransaction();
        fmt.replace(R.id.theFiller, testFragment1);
        fmt.addToBackStack(null);
        fmt.commit();
    }

    @Override
    public void screenTwo() {

        Bundle args = new Bundle();
        testFragment2.setArguments(args);
        fmt = getSupportFragmentManager().beginTransaction();
        fmt.replace(R.id.theFiller, testFragment2);
        fmt.addToBackStack(null);
        fmt.commit();
    }
}