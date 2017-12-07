package com.ygh.market.view;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

public class SlideColorView extends View {

    private int color;
    private float offsetX;
    private int showWidth;

    public SlideColorView(Context context, int color, int offsetX) {
        super(context);
        this.color = color;
        this.offsetX = offsetX;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        float left = offsetX * showWidth;
        canvas.clipRect(left, 0, left + showWidth, getHeight());
        canvas.drawColor(color);
        canvas.restore();
    }

    public void setOffsetX(float offsetX) {
        if (this.offsetX != offsetX) {
            this.offsetX = offsetX;
            invalidate();
        }
    }

    public void setShowWidth(int showWidth) {
        this.showWidth = showWidth;
    }
}
