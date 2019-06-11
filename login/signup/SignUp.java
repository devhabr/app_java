package com.example.water.marketplace.login.signup;


import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.water.marketplace.R;
import com.example.water.marketplace.api.ServerConfig;
import com.example.water.marketplace.api.ServerConnectSetting;
import com.example.water.marketplace.login.profile.ProfileSetting;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignUp extends Fragment{


private AppBarLayout appBarLayout;
    private  Button buttonss;
    public SignUp() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_sign_up, container, false);
        ButterKnife.bind(this, v);
        buttonss = (Button) v.findViewById(R.id.sign_up_btn);
        buttonss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openFragments();
            }
        });
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        return v;
    }


    private void openFragments() {
        Fragment fragment = new StepInfo();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_left);
        fragmentTransaction.replace(R.id.home_cont_frg,fragment);
        fragmentTransaction.commit();
    }

}
