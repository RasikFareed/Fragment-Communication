package com.example.rasik.fragmentcommunication;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by rasik on 21/9/17.
 */

public class Fragment_2 extends Fragment {

    Button button2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

   }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, viewGroup, false);
        button2 = view.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment_3 fragment_3 = new Fragment_3();
                FragmentTransaction ft = ((MainActivity) getActivity()).fragmentManager.beginTransaction();
                ft.setCustomAnimations(R.anim.enter_anim,R.anim.exit_anim,0,0);
                ft.replace(((MainActivity)getActivity()).fragmentLayout.getId(), fragment_3, "fragment3").addToBackStack(fragment_3.getClass().getName());
                ft.commit();
            }
        });
        return view;
    }
}
