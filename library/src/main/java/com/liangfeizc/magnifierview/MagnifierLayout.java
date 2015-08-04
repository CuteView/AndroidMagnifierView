package com.liangfeizc.magnifierview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.ViewGroup;
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

        mPopupWindow = new PopupWindow(mMagnifierView,
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mPopupWindow.setContentView(mMagnifierView);
        mPopupWindow.setBackgroundDrawable(new ColorDrawable(Color.RED));
        mPopupWindow.setWidth(100);
        mPopupWindow.setHeight(100);
    }

    private void show(float x, float y) {
        mPopupWindow.showAtLocation(this, Gravity.NO_GRAVITY, (int) x, (int) y);
    }

    @Override
    public boolean onTouchEvent(@NonNull MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "onTouchVent " + event.getRawX() + ", " + event.getRawY());
                if (mPopupWindow.isShowing()) {
                    mPopupWindow.dismiss();
                }
                show(event.getRawX(), event.getRawY());
                return true;
            case MotionEvent.ACTION_MOVE:
                mPopupWindow.update((int) event.getRawX(), (int) event.getRawY(), -1, -1);
                //show(event.getX(), event.getY());
                return true;
        }
        return super.onTouchEvent(event);
    }
}
