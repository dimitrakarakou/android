package com.example.android_lab.mypega;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TeacherListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TeacherListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TeacherListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TeacherListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TeacherListFragment newInstance(String param1, String param2) {
        TeacherListFragment fragment = new TeacherListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public TeacherListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_teacher_list, container, false);

        final ListView teachersList = (ListView)rootView.findViewById(R.id.teachersListView);

        MainActivityFragment.teacherFrag = true;
        MainActivity.mFragmentStack.add("TeacherFragment");

        //Database code
        //Put Data in DataBase

        DBHelper helper = new DBHelper(getActivity());
        ContentValues args = new ContentValues();
        final ArrayList<String> arrayNameSQL = new ArrayList<String>();

        //Read data

        final Cursor cur = helper.getReadableDatabase().rawQuery("SELECT name FROM teachers_list", null);
        if(cur.moveToFirst()){
            do{
                arrayNameSQL.add(cur.getString(cur.getColumnIndex("name")));

            } while(cur.moveToNext());
        }
        helper.close();

        final ArrayAdapter<String> adapterSQL = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, arrayNameSQL);

        teachersList.setAdapter(adapterSQL);

        teachersList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TeacherInfoFragment teacherInfo = new TeacherInfoFragment();
                Bundle args = new Bundle();
                args.putInt("position", position);
                teacherInfo.setArguments(args);

                getFragmentManager().beginTransaction().replace(R.id.fragment, teacherInfo).commit();
            }
        });

        return rootView;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        MenuItem fragMenuHelp= menu.findItem(R.id.help_settings);
        fragMenuHelp.setVisible(false);
        MenuItem fragMenuInfo= menu.findItem(R.id.information_settings);
        fragMenuInfo.setVisible(false);
        MenuItem fragBackTeachetList= menu.findItem(R.id.back_teacher_list_settings);
        fragBackTeachetList.setVisible(false);
        MenuItem fragMapBack= menu.findItem(R.id.map_action_settings);
        fragMapBack.setVisible(false);
        MenuItem fragAbout= menu.findItem(R.id.about_action_settings);
        fragAbout.setVisible(false);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
        }
        return super.onOptionsItemSelected(item);
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
