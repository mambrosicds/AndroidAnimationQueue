package com.codigo.animation;

import android.view.animation.Animation;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Represents a queue of animations to be performed one after the following
 * Created by marcosambrosi on 3/11/14.
 */
public class AnimationQueue extends ArrayList<AnimationPerformer> implements Iterator<AnimationPerformer>{

    /**
     *
     */
    public interface AnimationQueueListener{
        public void onQueueStarted();
        public void onQueueFinished();
    }

    /**
     *
     */
    public AnimationQueue() {
        super();
    }

    private int mIndex = 0;
    private AnimationQueueListener mListener;

    /**
     *
     */
    public void start(){
        if(this.mListener != null) {
            this.mListener.onQueueStarted();
        }
        //start the animations
        executeNext();
    }

    /**
     *
     */
    public void cancelAllAnimations(){
        for(AnimationPerformer performer : this){
            if(performer.isStarted()){
                performer.getAnimation().cancel();
            }
        }
    }

    /**
     *
     */
    public void restart(){
        mIndex = 0;
        start();
    }

    /**
     *
     * @param object
     * @return
     */
    @Override
    public boolean add(AnimationPerformer object) {
        return super.add(object);
    }

    /**
     *
     */
    private synchronized void executeNext(){
        final AnimationPerformer performer = next();

        performer.getAnimation().setAnimationListener(new Animation.AnimationListener() {
              @Override
              public void onAnimationStart(Animation animation) {
                  if(performer.getListener() != null){
                      performer.getListener().onAnimationStart(animation);
                  }
              }

              @Override
              public void onAnimationEnd(Animation animation) {
                 if(performer.getListener() != null){
                     performer.getListener().onAnimationEnd(animation);
                 }

                 if(hasNext()){
                     executeNext();
                 }else{
                    if(mListener != null){
                        mListener.onQueueFinished();
                    }
                 }
              }

              @Override
              public void onAnimationRepeat(Animation animation) {
                  if(performer.getListener() != null){
                      performer.getListener().onAnimationRepeat(animation);
                  }
              }
        });
        performer.startAnimation();
    }

    /**
     *
     * @return
     */
    @Override
    public boolean hasNext() {
        return (mIndex < this.size());
    }

    /**
     *
     * @return
     */
    @Override
    public AnimationPerformer next() {
        int index = mIndex++;
        if(index < this.size()){
            return this.get(index);
        }
        return null;
    }

    /**
     *
     */
    @Override
    public void remove() {

    }

    /**
     *
     * @return
     */
    public AnimationQueueListener getListener() {
        return mListener;
    }

    /**
     *
     * @param listener
     */
    public void setListener(AnimationQueueListener listener) {
        this.mListener = listener;
    }
}
