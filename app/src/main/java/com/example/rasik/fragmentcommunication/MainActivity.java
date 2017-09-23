package com.example.rasik.fragmentcommunication;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.FrameLayout;

public class MainActivity extends FragmentActivity {

    private Fragment_1 fragment_1;
    public FrameLayout fragmentLayout;
    public FragmentManager fragmentManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentLayout = (FrameLayout) findViewById(R.id.container);
        fragmentManager = getFragmentManager();
        fragment_1 = new Fragment_1();
        setFragment(fragment_1);



    }

    public void setFragment(Fragment_1 frag)
    {
        if (fragmentManager.findFragmentById(R.id.container) == null) {

            fragmentManager.beginTransaction().replace(R.id.container, frag,"fragment1").addToBackStack(frag.getClass().getName()).commit();
        }

    }

}