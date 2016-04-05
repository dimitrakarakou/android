
package com.example.android_lab.mypega;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.Fragment;

import org.w3c.dom.Text;

import java.util.Stack;

public class MainActivity extends AppCompatActivity implements InformationFragment.OnFragmentInteractionListener,
        HelpFragment.OnFragmentInteractionListener, TeacherListFragment.OnFragmentInteractionListener,
        TeacherInfoFragment.OnFragmentInteractionListener, MapFragment.OnFragmentInteractionListener,
        AboutFragment.OnFragmentInteractionListener{

    public static Stack<String> mFragmentStack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentStack = new Stack<String>();
        MainActivityFragment mainFrag = new MainActivityFragment();
        String tag = mainFrag.toString();
        mFragmentStack.add(tag);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, mainFrag).commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem backToList= menu.findItem(R.id.back_teacher_list_settings);
        backToList.setVisible(false);
        MenuItem fragMapBack= menu.findItem(R.id.map_action_settings);
        fragMapBack.setVisible(false);
        MenuItem infoMemu = menu.findItem(R.id.information_settings);
        infoMemu.setVisible(false);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                String nameOfCurrentFragent = mFragmentStack.peek();

                MainActivityFragment mainFrag = new MainActivityFragment();
                String tag = mainFrag.toString();
                mFragmentStack.add(tag);

                if (nameOfCurrentFragent != null) {

                    if (nameOfCurrentFragent.substring(0, 12).equals("MainActivity")) {

                    }
                    else if (nameOfCurrentFragent.substring(0, 12).equals("HelpFragment")) {
                        TextView txt = (TextView) findViewById(R.id.helpTxt);
                        Animation anim1 = AnimationUtils.loadAnimation(this, R.anim.alpha_tween);
                        txt.startAnimation(anim1);
                        ImageView helpImage = (ImageView)findViewById(R.id.helpImageView);
                        helpImage.startAnimation(anim1);
                        MainActivityFragment.helpFrag = false;
                    }

                    else if (nameOfCurrentFragent.substring(0, 12).equals("AboutFragmen")) {
                        TextView aboutTxt = (TextView) findViewById(R.id.aboutText);
                        Animation anim1 = AnimationUtils.loadAnimation(this, R.anim.alpha_tween);
                        aboutTxt.startAnimation(anim1);
                        ImageView aboutImage = (ImageView)findViewById(R.id.helpImageView);
                        aboutImage.startAnimation(anim1);
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment, mainFrag).commit();
                }
            }


            if (id == R.id.help_settings) {
                HelpFragment helpFrag = new HelpFragment();
                String nameOfCurrentFragent = mFragmentStack.peek();

                String tag = helpFrag.toString();
                mFragmentStack.add(tag);

                if (nameOfCurrentFragent != null) {

                    if (nameOfCurrentFragent.substring(0, 12).equals("HelpFragment")) {

                    }
                    else if (nameOfCurrentFragent.substring(0, 12).equals("MainActivity")){
                        Animation anim1 = AnimationUtils.loadAnimation(this, R.anim.alpha_tween);
                        Button btn = (Button) findViewById(R.id.button);
                        btn.startAnimation(anim1);
                        Button mapBtn = (Button) findViewById(R.id.map_btn);
                        mapBtn.startAnimation(anim1);
                        Button infoBtn = (Button) findViewById(R.id.info_btn);
                        infoBtn.startAnimation(anim1);
                        ImageView mainImage = (ImageView)findViewById(R.id.mainImageView);
                        mainImage.startAnimation(anim1);
                    }
                    getFragmentManager().beginTransaction().replace(R.id.fragment, helpFrag).commit();
                }
            }

        if (id == R.id.about_action_settings) {
            AboutFragment aboutFrag = new AboutFragment();
            String nameOfCurrentFragent = mFragmentStack.peek();

            String tag = aboutFrag.toString();
            mFragmentStack.add(tag);

            if (nameOfCurrentFragent != null) {

                if (nameOfCurrentFragent.substring(0, 12).equals("AboutFragmen")) {

                }
                else if (nameOfCurrentFragent.substring(0, 12).equals("MainActivity")){
                    Animation anim1 = AnimationUtils.loadAnimation(this, R.anim.alpha_tween);
                    Button btn = (Button) findViewById(R.id.button);
                    btn.startAnimation(anim1);
                    Button mapBtn = (Button) findViewById(R.id.map_btn);
                    mapBtn.startAnimation(anim1);
                    Button infoBtn = (Button) findViewById(R.id.info_btn);
                    infoBtn.startAnimation(anim1);
                    ImageView mainImage = (ImageView)findViewById(R.id.mainImageView);
                    mainImage.startAnimation(anim1);
                }
                getFragmentManager().beginTransaction().replace(R.id.fragment, aboutFrag).commit();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    public void onFragmentInteraction(Uri uri){

    }
}
