package util;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.annotation.RequiresApi;

import com.example.criptoganhos.R;

public class ErrorAnimationHelper {
    View currentView;
    public boolean needInfo = false;

    Drawable errorBackground;
    Drawable correctBackground;

    public ErrorAnimationHelper(View v){
        currentView = v;

        errorBackground = v.getResources().getDrawable(R.drawable.edittext_error);
        correctBackground = v.getResources().getDrawable(R.drawable.edittext_normal);
    }

    /**
     *  setErrorAnimation and setMontoErrorAnimation gets the view object, passed by parameter, and plays a color changing of ANIMATION_TIME duration.
     */

    public Animation setErrorAnimation(final EditText v){
        Animation animation = new AlphaAnimation(Constants.STARTING_ALPHA, Constants.ENDING_ALPHA);
        animation.setRepeatCount(Constants.ANIMATION_TIME);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                v.setBackground(errorBackground);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                v.setBackground(correctBackground);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });

        return animation;
    }

    private Animation setMontoErrorAnimation(final EditText v){
        Animation animation = new AlphaAnimation(Constants.STARTING_ALPHA, Constants.ENDING_ALPHA);
        animation.setRepeatCount(Constants.ANIMATION_TIME);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                v.setTextColor(v.getResources().getColor(R.color.red));
            }

            //VERIFICAR AQUI A COR QUE SERÁ DEPOIS DA ANIMAÇÃO
            @Override
            public void onAnimationEnd(Animation animation) {
                v.setTextColor(v.getResources().getColor(R.color.black));
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });

        return animation;
    }

    private Animation setErrorAnimation(final RadioGroup v){
        Animation animation = new AlphaAnimation(Constants.STARTING_ALPHA, Constants.ENDING_ALPHA);
        animation.setRepeatCount(Constants.ANIMATION_TIME);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onAnimationStart(Animation animation) {
                for(int i = 0; i < v.getChildCount()-1; i++){
                    RadioButton rb = (RadioButton) v.getChildAt(i);
                    rb.setButtonTintList(ColorStateList.valueOf(v.getResources().getColor(R.color.red)));
                }
            }

            //VERIFICAR AQUI A COR QUE SERÁ DEPOIS DA ANIMAÇÃO
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onAnimationEnd(Animation animation) {
                for(int i = 0; i < v.getChildCount()-1; i++){
                    RadioButton rb = (RadioButton) v.getChildAt(i);
                    rb.setButtonTintList(ColorStateList.valueOf(v.getResources().getColor(R.color.black)));
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });

        return animation;
    }

    private Animation setErrorAnimation(final Spinner v){
        Animation animation = new AlphaAnimation(Constants.STARTING_ALPHA, Constants.ENDING_ALPHA);
        animation.setRepeatCount(Constants.ANIMATION_TIME);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                v.setBackground(errorBackground);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                v.setBackground(correctBackground);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });

        return animation;
    }

    /**
     * This is called when a card needs to check if the current view object (EditText, Spinner, etc) has information inside of it or not.
     * The function plays by its own a missing information animation based on what type of object called it.
     */

    public boolean checkIfIsEmpty(EditText v){
        if(v.getText().toString().length() == 0 || v.getText().toString().equals(Constants.EMPTY_VALUE)){
            v.startAnimation(setErrorAnimation(v));
            return true;
        }
        return false;
    }

    public boolean checkIfIsEmpty(EditText v, boolean isMonto){
        if(v.getText().toString().length() == 0 || v.getText().toString().equals(Constants.EMPTY_VALUE)){
            v.startAnimation(setMontoErrorAnimation(v));
            return true;
        }
        return false;
    }

    public boolean checkIfIsEmpty(Spinner v){
        if(v.getSelectedItem() == null){
            v.startAnimation(setErrorAnimation(v));
            return true;
        }
        return false;
    }

    public boolean checkIfIsEmpty(RadioGroup v){
        if(v.getCheckedRadioButtonId() == -1){
            v.startAnimation(setErrorAnimation(v));
            return true;
        }
        return false;
    }
}
