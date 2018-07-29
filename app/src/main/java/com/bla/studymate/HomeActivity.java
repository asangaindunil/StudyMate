package com.bla.studymate;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.bla.studymate.fragments.GroupsFragment;
import com.bla.studymate.fragments.NewGroupFragment;
import com.bla.studymate.fragments.UsersFragment;

public class HomeActivity extends AppCompatActivity
        implements GroupsFragment.OnFragmentInteractionListener,
                    UsersFragment.OnFragmentInteractionListener,
                    NewGroupFragment.OnFragmentInteractionListener {

    private ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //set screen actionbar title
        toolbar = getSupportActionBar();
        toolbar.setTitle("Groups");

        loadFragment(new GroupsFragment());
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.action_groups:
                    toolbar.setTitle("Groups");
                    fragment = new GroupsFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.action_users:
                    toolbar.setTitle("Users");
                    fragment = new UsersFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.action_add:
                    toolbar.setTitle("Create a group");
                    fragment = new NewGroupFragment();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        //todo
    }
}
