package com.example.water.marketplace.login;


import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.transition.ChangeBounds;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.water.marketplace.R;
import com.example.water.marketplace.login.signup.SignUp;
import com.example.water.marketplace.login.signup.StepInfo;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;



public class SwitchLogin extends Fragment {
    private Fragment fragment;
    private Button signin;
    private ImageView imageview,logo;
    private Button signup;
    private FragmentTransaction fragmentTransaction;

    public SwitchLogin() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        View v = inflater.inflate(R.layout.fragment_switch_login, container, false);
        signin = v.findViewById(R.id.button);
        signup = v.findViewById(R.id.button2);
        logo =  v.findViewById(R.id.logo_switch);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment= new SignIn();

                openFragments();

            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           fragment= new SignUp();

                openFragments();

            }
        });
        imageview =  v.findViewById(R.id.bg);

        BitmapDrawable drawable = (BitmapDrawable) imageview.getDrawable();
        Bitmap bitmap = drawable.getBitmap();
        Bitmap blurred = blurRenderScript(bitmap, 10);
        imageview.setImageBitmap(blurred);
        return v;
    }

    @SuppressLint("NewApi")
    private Bitmap blurRenderScript(Bitmap smallBitmap, int radius) {

        try {
            smallBitmap = RGB565toARGB888(smallBitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }


        Bitmap bitmap = Bitmap.createBitmap(
                smallBitmap.getWidth(), smallBitmap.getHeight(),
                Bitmap.Config.ARGB_8888);

        RenderScript renderScript = RenderScript.create(getActivity());

        Allocation blurInput = Allocation.createFromBitmap(renderScript, smallBitmap);
        Allocation blurOutput = Allocation.createFromBitmap(renderScript, bitmap);

        ScriptIntrinsicBlur blur = ScriptIntrinsicBlur.create(renderScript,
                Element.U8_4(renderScript));
        blur.setInput(blurInput);
        blur.setRadius(radius);
        blur.forEach(blurOutput);
        blurOutput.copyTo(bitmap);
        renderScript.destroy();

        return bitmap;

    }

    private Bitmap RGB565toARGB888(Bitmap img) throws Exception {
        int numPixels = img.getWidth() * img.getHeight();
        int[] pixels = new int[numPixels];
        img.getPixels(pixels, 0, img.getWidth(), 0, 0, img.getWidth(), img.getHeight());
        Bitmap result = Bitmap.createBitmap(img.getWidth(), img.getHeight(), Bitmap.Config.ARGB_8888);
        result.setPixels(pixels, 0, result.getWidth(), 0, 0, result.getWidth(), result.getHeight());
        return result;
    }


    private void openFragments() {
        SwitchLogin fragmentOne = new SwitchLogin();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // Inflate transitions to apply
            Transition changeTransform = TransitionInflater.from(getActivity()).
                    inflateTransition(R.transition.default_transition);
            Transition explodeTransform = TransitionInflater.from(getActivity()).
                    inflateTransition(android.R.transition.explode);


            fragmentOne.setSharedElementReturnTransition(changeTransform);
            fragmentOne.setExitTransition(explodeTransform);

            fragment.setSharedElementEnterTransition(changeTransform);
            fragment.setEnterTransition(explodeTransform);
             fragmentTransaction = getFragmentManager().beginTransaction()
                    .replace(R.id.home_cont_frg, fragment)
                    .addToBackStack("transaction")
                    .addSharedElement(logo, "profile");

            fragmentTransaction.commit();
        }
        else {
            fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.home_cont_frg,fragment);
            fragmentTransaction.commit();
        }

    }

}
