package com.example.testinglayouts;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private FragmentMainListener listener;
    Button buttonOne, buttonTwo;

    //This is my interface
    public interface FragmentMainListener {
        //Each of these methods will direct me to a different fragment screen
        public void screenOne();
        //This above should call all the shit I need to do for the FragmentTransaction to dump me back into main. Below the same for screen Two
        public void screenTwo();
    }

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    FragmentManager fm;
    Button button;

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment main.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
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
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        buttonOne = v.findViewById(R.id.buttonOne);
        buttonTwo = v.findViewById(R.id.buttonTwo);
        buttonOne.setOnClickListener(new View.OnClickListener(){
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

        buttonTwo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //The issue is that THIS seems to be null. Why is that?
                if(listener != null){
                    System.out.println("Why is the Listener Not Null, Dave?");
                    listener.screenTwo();
                }else{
                    System.out.println("Why is the Listener Null, Dave?");
                }

            }

        });


        return v;


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentMainListener) {
            listener = (FragmentMainListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FragmentAListener");
        }
    }



}