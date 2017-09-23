package com.example.rasik.fragmentcommunication;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import static com.example.rasik.fragmentcommunication.R.layout.fragment_3;

/**
 * Created by rasik on 21/9/17.
 */

public class Fragment_3 extends Fragment{

    Fragment_1 fragment_1 = new Fragment_1();
    Button button3;
    EditText txt3;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        View view = inflater.inflate(fragment_3, viewGroup, false);
        button3 = view.findViewById(R.id.button3);
        txt3 = view.findViewById(R.id.txt3);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();
                String myText = txt3.getText().toString();
                bundle.putString("params", myText);
                fragment_1.setArguments(bundle);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.setCustomAnimations(R.anim.enter_anim,R.anim.exit_anim,0,0);
                ft.replace(((MainActivity)getActivity()).fragmentLayout.getId(), fragment_1, "FirstFragment");
                ft.commit();
                hideKeyboard(getActivity());

            }
        });
        return view;
    }
    public static void hideKeyboard(Context ctx) {
        InputMethodManager inputManager = (InputMethodManager) ctx
                .getSystemService(Context.INPUT_METHOD_SERVICE);

        View v = ((Activity) ctx).getCurrentFocus();
        if (v == null)
            return;

        inputManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }
}
