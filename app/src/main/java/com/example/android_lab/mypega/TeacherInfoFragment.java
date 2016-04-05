package com.example.android_lab.mypega;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TeacherInfoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TeacherInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TeacherInfoFragment extends Fragment {
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
     * @return A new instance of fragment TeacherInfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TeacherInfoFragment newInstance(String param1, String param2) {
        TeacherInfoFragment fragment = new TeacherInfoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public TeacherInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        MenuItem fragMenuHelp= menu.findItem(R.id.help_settings);
        fragMenuHelp.setVisible(false);
        MenuItem fragMenuInfo= menu.findItem(R.id.information_settings);
        fragMenuInfo.setVisible(false);
        MenuItem fragMenuMain= menu.findItem(R.id.action_settings);
        fragMenuMain.setVisible(false);
        MenuItem fragMapBack= menu.findItem(R.id.map_action_settings);
        fragMapBack.setVisible(false);
        MenuItem fragMenuList= menu.findItem(R.id.back_teacher_list_settings);
        fragMenuList.setVisible(true);
        MenuItem fragAbout= menu.findItem(R.id.about_action_settings);
        fragAbout.setVisible(false);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
       if (id == R.id.back_teacher_list_settings) {
           TeacherListFragment teacherlList = new TeacherListFragment();
           getFragmentManager().beginTransaction().replace(R.id.fragment, teacherlList).commit();

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView= inflater.inflate(R.layout.fragment_teacher_info, container, false);
        DBHelper helper = new DBHelper(getActivity());
        ContentValues args = new ContentValues();
        final ArrayList<String> arraySQL = new ArrayList<String>();
        final ArrayList<String> arrayEmailSQL = new ArrayList<String>();
        final ArrayList<String> arrayPhotoSQL = new ArrayList<String>();

        final Cursor cur = helper.getReadableDatabase().rawQuery("SELECT name FROM teachers_list", null);
        if(cur.moveToFirst()){
            do{
                arraySQL.add(cur.getString(cur.getColumnIndex("name")));

            } while(cur.moveToNext());
        }

        final Cursor cur1 = helper.getReadableDatabase().rawQuery("SELECT email FROM teachers_list", null);
        if(cur1.moveToFirst()){
            do{
                arrayEmailSQL.add(cur1.getString(cur1.getColumnIndex("email")));

            } while(cur1.moveToNext());
        }

        final Cursor cur2 = helper.getReadableDatabase().rawQuery("SELECT photo FROM teachers_list", null);
        if(cur2.moveToFirst()){
            do {
                arrayEmailSQL.add(cur2.getString(cur2.getColumnIndex("photo")));

            } while(cur2.moveToNext());
        }

        helper.close();

        Bundle b = getArguments();
        int teacherNumber = b.getInt("position");
        TextView nameTxt =(TextView) rootView.findViewById(R.id.teacherName);
        nameTxt.setText(arraySQL.get(teacherNumber).toString());

        TextView emailTxt =(TextView) rootView.findViewById(R.id.teacherEmail);
        emailTxt.setText(arrayEmailSQL.get(teacherNumber).toString());

        ImageView iv = (ImageView)rootView.findViewById(R.id.teacherImage);



        switch (teacherNumber)
        {
            case 0: iv.setImageResource(R.drawable.ilioudis);break;
            case 1: iv.setImageResource(R.drawable.oikonomou);break;
            case 2: iv.setImageResource(R.drawable.litidis);break;
            case 3: iv.setImageResource(R.drawable.keramopoulos);break;
            case 4: iv.setImageResource(R.drawable.bratanis);break;
            case 5: iv.setImageResource(R.drawable.bratanis);break;
            case 6: iv.setImageResource(R.drawable.rapsomanikis);break;
            case 7: iv.setImageResource(R.drawable.stamatis);break;
            case 8: iv.setImageResource(R.drawable.moisiadis);break;
         }


        return rootView;
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
