package com.liangfeizc.magnifierview;

import android.content.Context;
import android.graphics.Color;
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
    private MagnifierView mMagnifierView;

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
        mMagnifierView = new MagnifierView(getContext());
        mMagnifierView.setBackgroundColor(Color.BLACK);

        mPopupWindow = new PopupWindow(getContext());
        mPopupWindow.setContentView(mMagnifierView);
        mPopupWindow.setWidth(100);
        mPopupWindow.setHeight(100);
    }

    private void show(float x, float y) {
        mPopupWindow.dismiss();
        mPopupWindow.showAtLocation(this, Gravity.BOTTOM, (int) x, (int) y);
    }

    @Override
    public boolean onTouchEvent(@NonNull MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                return true;
            case MotionEvent.ACTION_MOVE:
                Log.d(TAG, "onTouchVent " + event.getX() + ", " + event.getY());
                show(event.getX(), event.getY());
                return true;
        }
        return super.onTouchEvent(event);
    }
}
