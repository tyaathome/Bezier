package com.example.tyaathome.bezier.view.myview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

import com.example.tyaathome.bezier.R;
import com.example.tyaathome.bezier.view.event.BazierPaintGestureListener;
import com.example.tyaathome.bezier.view.event.DoubleTapListener;

/**
 * Created by tyaathome on 2016/7/29.
 */
public class BazierPaint extends View {

    private Paint mPaint;
    private Path mPath;

    private float offset = ViewConfiguration.get(getContext()).getScaledTouchSlop();

    private float mX;
    private float mY;

    private GestureDetector detector;

    private boolean isUseBazierPaint = true;

    public BazierPaint(Context context) {
        super(context);
        init(context);
    }

    public BazierPaint(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
        initAttrs(context, attrs);
    }

    public BazierPaint(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
        initAttrs(context, attrs);
    }

    private void init(Context context) {
        initPaint();
        detector = new GestureDetector(context, new BazierPaintGestureListener(new DoubleTapListener() {
            @Override
            public void onDoubleTap() {
                if(mPath != null) {
                    mPath.reset();
                    invalidate();
                }
            }
        }));
    }

    private void initPaint() {
        mPath = new Path();
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        mPaint.setColor(Color.RED);
    }

    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.BazierPaint);
        isUseBazierPaint = a.getBoolean(R.styleable.BazierPaint_userBazierPaint, true);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        detector.onTouchEvent(event);

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //mPath.reset();
                mX = event.getX();
                mY = event.getY();
                mPath.moveTo(mX, mY);
                break;
            case MotionEvent.ACTION_MOVE:
                float x = event.getX();
                float y = event.getY();
                float preX = mX;
                float preY = mY;
                float dx = Math.abs(x - preX);
                float dy = Math.abs(y - preY);
                //if(dx > offset && dy > offset) {
                    float cx = (x + preX) / 2;
                    float cy = (y + preY) / 2;
                if(isUseBazierPaint) {
                    mPath.quadTo(preX, preY, cx, cy);
                } else {
                    mPath.lineTo(cx, cy);
                }
                    mX = x;
                    mY = y;
                //}
                break;
        }
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(mPath, mPaint);
    }
}
