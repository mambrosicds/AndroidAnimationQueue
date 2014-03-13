package com.codigo.animation;

import android.view.View;
import android.view.animation.Animation;

/**
 * Created by marcosambrosi on 3/11/14.
 */
public class AnimationPerformer {

    private Animation mAnimation;
    private View mView;
    private Animation.AnimationListener mAnimationListener;
    private boolean mStarted;

    public AnimationPerformer(Animation animation, View view, Animation.AnimationListener animationListener) {
        this.mAnimation = animation;
        this.mView = view;
        this.mAnimationListener = animationListener;
        this.mStarted = false;
    }

    public void startAnimation(){
        mStarted = true;
        mView.startAnimation(mAnimation);
    }

    public boolean isStarted(){
        return  mStarted;
    }

    public Animation getAnimation() {
        return mAnimation;
    }

    public Animation.AnimationListener getListener() {
        return mAnimationListener;
    }
}
