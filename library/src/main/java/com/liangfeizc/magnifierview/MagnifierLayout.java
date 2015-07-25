package com.liangfeizc.magnifierview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.PopupWindow;

/**
 * Created by liangfeizc on 7/25/15.
 */
public class MagnifierLayout extends FrameLayout {
    private static final String TAG = "MagnifierLayout";

    private PopupWindow mPopupWindow;

    public MagnifierLayout(Context context) {
        super(context);
        init();
    }

    public MagnifierLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MagnifierLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPopupWindow = new PopupWindow(getContext());
        mPopupWindow.setWidth(100);
        mPopupWindow.setHeight(100);
    }

    private void show(float x, float y) {
        mPopupWindow.showAtLocation(this, Gravity.BOTTOM, (int) x, (int) y);
    }

    @Override
    public boolean onTouchEvent(@NonNull MotionEvent event) {
        Log.d(TAG, "onTouchVent " + event.getX() + ", " + event.getY());

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                return true;
            case MotionEvent.ACTION_MOVE:
                show(event.getX(), event.getY());
                return true;
        }
        return super.onTouchEvent(event);
    }
}
