package com.example.android_lab.mypega;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    public static boolean teacherFrag = false;
    public static boolean helpFrag = false;

    public MainActivityFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        final View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        Button btn = (Button)rootView.findViewById(R.id.button);
        Button map_button = (Button)rootView.findViewById(R.id.map_btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TeacherListFragment teacherList = new TeacherListFragment();
                Button btn = (Button) rootView.findViewById(R.id.button);
                Animation anim1 = AnimationUtils.loadAnimation(getContext(), R.anim.alpha_tween);
                btn.startAnimation(anim1);
                getFragmentManager().beginTransaction().replace(R.id.fragment, teacherList).commit();
            }
        });

        map_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MapFragment showMap = new MapFragment();
                getFragmentManager().beginTransaction().replace(R.id.fragment, showMap).commit();

            }
        });


        Button info_button = (Button)rootView.findViewById(R.id.info_btn);

        info_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InformationFragment infoFrag = new InformationFragment();
                getFragmentManager().beginTransaction().replace(R.id.fragment, infoFrag).commit();

            }
        });


        ImageView mainImage = (ImageView)rootView.findViewById(R.id.mainImageView);
        mainImage.setImageResource(R.drawable.lamaitei);


        return rootView;
    }



}
