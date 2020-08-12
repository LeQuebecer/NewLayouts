package com.example.testinglayouts;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TestFragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TestFragment1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    Menu menu;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private FragmentOneListener listener;
    private TestInterfaces interfacesListener;
    private Button mainButton, otherButton;
    TextView textOne;


    //This is my interface
    public interface FragmentOneListener {
        //Each of these methods will direct me to a different fragment screen
        public void mainScreen();
        //This above should call all the shit I need to do for the FragmentTransaction to dump me back into main. Below the same for screen Two
        public void screenTwo();
        public void setText();
    }

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    public TestFragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TestFragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static TestFragment1 newInstance(String param1, String param2) {
        TestFragment1 fragment = new TestFragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Get back some arguments
        int someInt = getArguments().getInt("SomeInt", 0);
        String someTitle = getArguments().getString("Some String", "");


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_test1, container, false);
        textOne = v.findViewById(R.id.textOne);
        mainButton = v.findViewById(R.id.returnToMainOne);
        otherButton = v.findViewById(R.id.changeTo2);
        mainButton.setOnClickListener(new View.OnClickListener(){
          @Override
            public void onClick(View v){
              //The issue is that THIS seems to be null. Why is that?
              if(listener != null){
                  System.out.println("Why is the Listener Not Null, Dave?");
                  listener.mainScreen();
              }else{
                  System.out.println("Why is the Listener Null, Dave?");
              }

          }

        });

        otherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.screenTwo();
            }
        });

        //This should set the
        listener.setText();

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentOneListener) {
            listener = (FragmentOneListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FragmentAListener");
        }

    }


    public void setTextString(String s){
        if (textOne != null){
            textOne.setText(s);
        }else{
            System.out.printf("textOne is utterly empty");
        }

    }
}