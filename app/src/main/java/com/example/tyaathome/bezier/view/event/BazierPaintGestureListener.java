package com.example.tyaathome.bezier.view.event;

import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * Created by tyaathome on 2016/7/29.
 */
public class BazierPaintGestureListener extends GestureDetector.SimpleOnGestureListener {

    private DoubleTapListener listener;

    public BazierPaintGestureListener(DoubleTapListener listener) {
        this.listener = listener;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        if(listener != null) {
            listener.onDoubleTap();
        }
        return super.onDoubleTap(e);
    }
}
