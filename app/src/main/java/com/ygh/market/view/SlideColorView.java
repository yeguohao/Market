package com.ygh.market.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

public class SlideColorView extends View {

    private static final String TAG = "SlideColorView";

    private int color;
    private float offsetX;
    private int showWidth;
    private int width;
    private float preLeft = -1;
    private int jia;
    private Paint paint;

    public SlideColorView(Context context, int color, int offsetX) {
        super(context);
        this.color = color;
        this.offsetX = offsetX;
        this.paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.paint.setColor(color);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        width = getWidth();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float left = offsetX * width;
        canvas.drawRect(left, 0, left + showWidth, getHeight(), paint);
    }

    public void setOffsetX(float offsetX) {
        Log.e(TAG, "setOffsetX: " + offsetX);
        if (this.offsetX != offsetX) {
            this.offsetX = offsetX;
            postInvalidate();
        }
    }

    public void setShowWidth(int showWidth) {
        this.showWidth = showWidth;
    }
}
