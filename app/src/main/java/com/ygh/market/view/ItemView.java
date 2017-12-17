package com.ygh.market.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemView extends FrameLayout {

    private TextView mainText;
    private TextView subText;
    private ImageView her;

    private LayoutParams mainParams;
    private LayoutParams subParams;
    private LayoutParams herParams;

    public ItemView(@NonNull Context context) {
        super(context);
        initChild();
    }

    public ItemView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initChild();
    }

    public ItemView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initChild();
    }

    private void initChild() {
        mainText = new TextView(getContext());
        subText = new TextView(getContext());
        her = new ImageView(getContext());

        initStyle();
        initParams();
    }

    private void initParams() {
        mainParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        subParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        herParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        mainParams.gravity = Gravity.CENTER | Gravity.START;
        subParams.gravity = Gravity.CENTER | Gravity.START;
        herParams.gravity = Gravity.CENTER | Gravity.END;

        subParams.topMargin = 20;
    }

    private void initStyle() {
        mainText.setTextSize(15);
        subText.setTextSize(12);

        mainText.setTextColor(Color.BLACK);
        subText.setTextColor(Color.GRAY);
        
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        int childCount = getChildCount();
        if (childCount != 0) {
            throw new IllegalArgumentException("The Layout should be not contain child View!");
        }

        addView(mainText, mainParams);
        addView(subText, subParams);
        addView(her, herParams);
    }
}
