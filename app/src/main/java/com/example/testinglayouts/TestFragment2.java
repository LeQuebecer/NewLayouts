package com.example.testinglayouts;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TestFragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TestFragment2 extends Fragment{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private FragmentTwoListener listener;
    Button buttonOne, buttonTwo;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    //This is my interface
    public interface FragmentTwoListener {
        //Each of these methods will direct me to a different fragment screen
        public void mainScreen();
        //This above should call all the shit I need to do for the FragmentTransaction to dump me back into main. Below the same for screen Two
        public void screenOne();
    }


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private FragmentManager fm;

    public TestFragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment test2.
     */
    // TODO: Rename and change types and number of parameters
    public static TestFragment2 newInstance(String param1, String param2) {
        TestFragment2 fragment = new TestFragment2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_test2,
                container, false);

        buttonOne = view.findViewById(R.id.backtoMain2);
        buttonTwo = view.findViewById(R.id.changeTo1);

        buttonOne.setOnClickListener(new View.OnClickListener(){
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

        buttonTwo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //The issue is that THIS seems to be null. Why is that?
                if(listener != null){
                    System.out.println("Why is the Listener Not Null, Dave?");
                    listener.screenOne();
                }else{
                    System.out.println("Why is the Listener Null, Dave?");
                }

            }

        });


        return view;
    }


    //This seems to attach the Listener and is mandatory for it to exist.

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentTwoListener) {
            listener = (FragmentTwoListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FragmentAListener");
        }
    }



}