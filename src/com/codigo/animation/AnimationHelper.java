package com.codigo.animation;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/**
 * Created by marcosambrosi on 3/11/14.
 */
public class AnimationHelper {


    public static Animation fadeInView(Context context, long duration){
        Animation a = animateView(context, android.R.anim.fade_in);
        a.setDuration(duration);
        return a;
    }

    public static Animation fadeOutView(Context context, long duration){
        Animation a = animateView(context, android.R.anim.fade_out);
        a.setDuration(duration);
        return a;
    }

    public static Animation animateView(Context context, int animationResource){
        Animation a = AnimationUtils.loadAnimation(context, animationResource);
        return  a;
    }

}
