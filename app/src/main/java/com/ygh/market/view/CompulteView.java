package com.ygh.market.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public class CompulteView extends ViewGroup {

    private boolean expan;
    private View first, second;

    public CompulteView(Context context) {
        super(context);
    }

    public CompulteView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CompulteView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        int childCount = getChildCount();
        if (childCount != 2) {
            throw new IllegalArgumentException("The Layout should be contain 2 child!");
        } else {
            first = getChildAt(0);
            second = getChildAt(1);
        }

        setOnClickListener(v -> {
            expan = !expan;
            requestLayout();
        });
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        measureChildWithMargins(first, widthMeasureSpec, 0, heightMeasureSpec, 0);

        int measureWidth = first.getMeasuredWidth();
        int measureHeight = first.getMeasuredHeight();

        if (expan) {
            measureChildWithMargins(second, 0, measureWidth, heightMeasureSpec, measureHeight);

            measureWidth = Math.max(measureWidth, second.getMeasuredWidth());
            measureHeight += second.getMeasuredHeight();
        }

        setMeasuredDimension(measureWidth, measureHeight);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        first.layout(l, t, r, t + first.getMeasuredHeight());

        if (expan) {
            second.layout(l, t + first.getMeasuredHeight(), r, b);
        }
    }

}
