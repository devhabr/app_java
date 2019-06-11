package com.example.water.marketplace.login;


import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.water.marketplace.R;
import com.example.water.marketplace.api.ServerConfig;
import com.example.water.marketplace.api.ServerConnect;
import com.example.water.marketplace.api.ServerConnectSetting;
import com.example.water.marketplace.login.profile.ProfileSetting;
import com.example.water.marketplace.login.session.SessionUser;
import com.example.water.marketplace.login.signup.SignUp;
import com.example.water.marketplace.model.account.LoginBody;
import com.example.water.marketplace.model.account.LoginUser;
import com.example.water.marketplace.model.error.ErrorApi;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignIn extends Fragment {
    private Retrofit mRestAdapter;
    private ServerConnectSetting serverConnectSetting;

private Fragment fragment;
    private EditText mUserIdView;
    private EditText mPasswordView;
    private ProgressDialog progressDialog;

    public SignIn() {

    }


  private Button buttonSign;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);
        ButterKnife.bind(this, view);
        getActivity().setTitle(" ");
        mRestAdapter = new Retrofit.Builder()
                .baseUrl(ServerConfig.WATER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        serverConnectSetting = mRestAdapter.create(ServerConnectSetting.class);
        mUserIdView = (EditText) view.findViewById(R.id.user_id);
        mPasswordView = (EditText) view.findViewById(R.id.password);
        buttonSign = (Button)  view.findViewById(R.id.email_sign_in_button);
        buttonSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();

            }
        });
       // ((AppCompatActivity) getActivity()).getSupportActionBar().hide();



        return view;



    }



    private void attemptLogin() {


        String id_user = mUserIdView.getText().toString();
        String password = mPasswordView.getText().toString();

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Search user...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        Call<LoginUser> loginCall = serverConnectSetting.login(new LoginBody(id_user, password));
            loginCall.enqueue(new Callback<LoginUser>() {
                @Override
                public void onResponse(Call<LoginUser> call, Response<LoginUser> response) {
                    progressDialog.hide();
                    if (!response.isSuccess()) {
                        String error = "Contact admin";
                        if (response.errorBody()
                                .contentType()
                                .subtype()
                                .equals("json")) {
                          //  ErrorApi apiError = ErrorApi.fromResponseBody(response.errorBody());

                        //    error = apiError.getMessage();
                        //    Log.d("LoginActivity", apiError.getDeveloperMessage());
                        } else {
                            try {
                                Log.d("LoginActivity", response.errorBody().string());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                        showLoginError(error);
                        return;
                    }

                    SessionUser.get(getContext()).saveAffiliate(response.body());
                    openFragments();
                }

                @Override
                public void onFailure(Call<LoginUser> call, Throwable t) {
                    progressDialog.hide();
                    showLoginError(t.getMessage());
                }
            });

    }



    private void openFragments() {
        fragment = new ProfileSetting();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_left);
        fragmentTransaction.replace(R.id.home_cont_frg,fragment);
        fragmentTransaction.commit();
    }

    private void showLoginError(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_LONG).show();
    }


}
