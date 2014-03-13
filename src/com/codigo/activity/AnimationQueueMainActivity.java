package com.codigo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.TextView;
import android.widget.Toast;
import com.codigo.animation.AnimationHelper;
import com.codigo.animation.AnimationPerformer;
import com.codigo.animation.AnimationQueue;
import com.codigo.animation.R;

public class AnimationQueueMainActivity extends Activity implements AnimationQueue.AnimationQueueListener {

    TextView firstTextView;
    TextView secondTextView;
    TextView thirdTextView;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        firstTextView = (TextView) findViewById(R.id.firstTextView);
        secondTextView = (TextView) findViewById(R.id.secondTextView);
        thirdTextView = (TextView) findViewById(R.id.thirdTextView);


        int duration = 2000;

        AnimationQueue queue = new AnimationQueue();
        queue.setListener(this);


        AnimationPerformer cueFadeOutPerformer = new AnimationPerformer(AnimationHelper.fadeOutView(this, duration), firstTextView, new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                firstTextView.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        queue.add(cueFadeOutPerformer);

        AnimationPerformer secondFadeOutPerformer = new AnimationPerformer(AnimationHelper.fadeOutView(this, duration), secondTextView, new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                secondTextView.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        queue.add(secondFadeOutPerformer);

        AnimationPerformer thirdFadeOutPerformer = new AnimationPerformer(AnimationHelper.fadeOutView(this, duration), thirdTextView, new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                thirdTextView.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        queue.add(thirdFadeOutPerformer);


        AnimationPerformer thirdFadeInPerformer = new AnimationPerformer(AnimationHelper.fadeInView(this, duration), thirdTextView, new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                thirdTextView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        queue.add(thirdFadeInPerformer);

        AnimationPerformer secondFadeInPerformer = new AnimationPerformer(AnimationHelper.fadeInView(this, duration), secondTextView, new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                    secondTextView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        queue.add(secondFadeInPerformer);

        AnimationPerformer firstFadeInPerformer = new AnimationPerformer(AnimationHelper.fadeInView(this, duration), firstTextView, new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                firstTextView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        queue.add(firstFadeInPerformer);



        //start queue animations
        queue.start();
    }

    @Override
    public void onQueueStarted() {
        Toast.makeText(this, "Queue started", 1000).show();
    }

    @Override
    public void onQueueFinished() {
        Toast.makeText(this, "Queue finished", 1000).show();
    }
}
