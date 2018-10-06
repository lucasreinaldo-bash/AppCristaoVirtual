package vostore.cristaovirtual;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.shrikanthravi.library.NightModeButton;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FraseFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FraseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FraseFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    NightModeButton nightModeButton;
    RelativeLayout relativeLayout;

    public static FraseFragment newInstance() {
        // Required empty public constructor
        FraseFragment fraseFragment = new FraseFragment();
        return fraseFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View rootView = inflater.inflate(R.layout.fragment_frase,
                container, false);



        relativeLayout = rootView.findViewById(R.id.rootLayout);
        nightModeButton = rootView.findViewById(R.id.nightModeButton);

        final int colorFrom = getResources().getColor(R.color.white);
        final int colorTo = getResources().getColor(R.color.dark);


        nightModeButton.setOnSwitchListener(new NightModeButton.OnSwitchListener() {
            @Override
            public void onSwitchListener(boolean isNight) {
                if (isNight) {
                    //Function to change color
                    animateBackground(colorFrom,colorTo);
                    animateStatusActionBar(getResources().getColor(R.color.colorPrimary),colorTo);

                } else {
                    animateBackground(colorTo,colorFrom);
                    animateStatusActionBar(colorTo,getResources().getColor(R.color.colorPrimary));
                }
            }
        });
        return rootView;
    }


    public static FraseFragment newInstance(String param1, String param2) {


        return new FraseFragment();
    }


    public void animateBackground(int colorFrom,int colorTo){
        ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
        colorAnimation.setDuration(250); // milliseconds
        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                relativeLayout.setBackgroundColor((int) animator.getAnimatedValue());
            }

        });
        colorAnimation.start();
    }
    public void animateStatusActionBar(int colorFrom,int colorTo){
        ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
        colorAnimation.setDuration(250); // milliseconds
        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                getActivity().getWindow().setStatusBarColor((int) animator.getAnimatedValue());
                ((AppCompatActivity)getActivity()).getSupportActionBar().setBackgroundDrawable(new ColorDrawable((int) animator.getAnimatedValue()));
            }

        });
        colorAnimation.start();
    }



}
