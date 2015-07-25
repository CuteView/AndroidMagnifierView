package com.liangfeizc.magnifierview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by liangfeizc on 7/22/15.
 */
public class MagnifierView extends View {
    private int mRadius = 10;
    private Paint mPaint;

    public MagnifierView(Context context) {
        super(context);
        init();
    }

    public MagnifierView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MagnifierView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(mRadius, mRadius, mRadius, mPaint);
    }
}
