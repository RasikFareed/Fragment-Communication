package com.example.rasik.fragmentcommunication;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by rasik on 21/9/17.
 */

public class Fragment_1 extends Fragment {

    Button button;
    TextView txtview;
    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onResume() {
        super.onResume();
        if(getArguments()!=null) {
            Bundle bundle = getArguments();
            String mytext = bundle.getString("params");
            txtview.setText(mytext);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, viewGroup, false);
        button = view.findViewById(R.id.button);
        txtview = view.findViewById(R.id.textView);
       button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment_2 fragment_2 = new Fragment_2();
                FragmentTransaction ft = ((MainActivity) getActivity()).fragmentManager.beginTransaction();
                ft.setCustomAnimations(R.anim.enter_anim,R.anim.exit_anim,0,0);
                ft.replace(((MainActivity)getActivity()).fragmentLayout.getId(), fragment_2,"fragment2").addToBackStack(fragment_2.getClass().getName());
                ft.commit();
            }
        });

        return view;
    }
}
