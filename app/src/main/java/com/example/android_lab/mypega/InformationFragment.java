package com.example.android_lab.mypega;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link InformationFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link InformationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InformationFragment extends Fragment {
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
     * @return A new instance of fragment InformationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InformationFragment newInstance(String param1, String param2) {
        InformationFragment fragment = new InformationFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public InformationFragment() {
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_information, container, false);

        TextView info_txt = (TextView) rootView.findViewById(R.id.txtFragInfo);
        info_txt.setText("\nΚαλως ήρθατε στο κυκλό σεμιναρίων με τίτλο\n\n «Ανάπτυξη εφαρμογών κινητών τηλεφώνων». \n\nΤα σεμινάρια οργανώνονται από τα \n\nΤμήματα Μηχανικών Πληροφορικής των ΤΕΙ Ανατολικής Μακεδονίας-" +
                "Θράκης, του Αλεξάνδρειου ΤΕΙ Θεσσαλονίκης και του ΤΕΙ Στερεάς Ελλάδας, στο πλαίσιο του έργου ΠΕΓΑ/ΕΣΠΑ.\n\n" +
                "Το συγκεκριμένο πρόγραμμα δίνει την δυνατότητα στους αποφοίτους των Τμημάτων Πληροφορικής να συμπληρώσουν τις γνώσεις και τις προγραμματιστικές τους δεξιότητες σε θέματα που αφορούν στην ανάπτυξη εφαρμογών κινητών τηλεφώνων (ενδεικτικά για την" +
                "πλατφόρμα Android) χρησιμοποιώντας κατάλληλες γλώσσες προγραμματισμού, π.χ. Java, HTML 5 κλπ.. \n\nΣτο εξειδικευμένο αυτό ΠΕΓΑ, παράλληλα με τις γνώσεις που αφορούν την" +
                "ανάπτυξη εφαρμογών σε κινητές συσκευές οι εκπαιδευόμενοι θα χρησιμοποιήσουν σύγχρονα εργαλεία και πλατφόρμες ανάπτυξης (ενδεικτικά Android Studio & Google API) μεγιστοποιώντας τις δυνατότητες ενσωμάτωσης στις εφαρμογές έτοιμων εργαλείων που" +
                "διατίθενται ελεύθερα.");


        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        MenuItem fragMenuInfo= menu.findItem(R.id.help_settings);
        fragMenuInfo.setVisible(false);
        MenuItem fragAbout= menu.findItem(R.id.about_action_settings);
        fragAbout.setVisible(false);


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
