package com.ygh.market.view;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public class FixedTextTabLayout extends ViewGroup {

    private static final String TAG = "FixedTextTabLayout";

    private SlideColorView underSlideView;
    private int childCount, childWidth;
    private float p;
    private Context context;
    private ViewPager viewPager;

    public FixedTextTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        childCount = getChildCount();
        p = 100f / childCount;

        underSlideView = new SlideColorView(context, Color.WHITE, 0);
        addView(underSlideView, new MarginLayoutParams(LayoutParams.MATCH_PARENT, 2));

        addListener();
    }

    private void addListener() {
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            if (child == underSlideView) continue;

            final int j = i;
            child.setOnClickListener(v -> {
                if (viewPager != null && viewPager.getCurrentItem() != j) {
                    viewPager.setCurrentItem(j);
                }
            });
        }
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);

        childWidth = width / childCount;

        underSlideView.setShowWidth(childWidth);

        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            if (child == underSlideView) continue;

            measureChildWithMargins(child, widthMeasureSpec, width - childWidth, heightMeasureSpec, 0);
        }

        measureChildWithMargins(underSlideView, widthMeasureSpec, 0, heightMeasureSpec, 0);

        Log.e(TAG,  "" + width );
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            if (child == underSlideView) continue;

            int left = i * childWidth;
            int right = left + childWidth;

            child.layout(left, t, right, b);
        }

        underSlideView.layout(l, b - 2, r, b);
    }

    public void setupWithViewPager(ViewPager viewPager) {
        this.viewPager = viewPager;
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                float x = p * position + positionOffset;
                Log.e(TAG, "onPageScrolled: " + x );
                underSlideView.setOffsetX(x);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}
