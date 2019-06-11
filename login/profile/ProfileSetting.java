package com.example.water.marketplace.login.profile;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.water.marketplace.R;
import com.example.water.marketplace.login.SignIn;
import com.example.water.marketplace.login.session.SessionUser;


public class ProfileSetting extends Fragment {
private Fragment fragment=null;
private Button Logout;
    private Context context;
    public ProfileSetting() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_profile_setting, container, false);
        SessionUser();
        Logout = (Button)  v.findViewById(R.id.btn_logout);

        setHasOptionsMenu(true);
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SessionUser.get(getActivity()).logOut();
                SessionUser();
            }
        });


        return v;

    }

    private void SessionUser(){
        if(!SessionUser.get(getActivity()).isLoggedIn()){
            fragment = new SignIn();
        }else {

        }
        try {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.home_cont_frg,fragment);
            ft.setCustomAnimations(R.anim.exit_to_left,R.anim.enter_from_right);
            ft.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
