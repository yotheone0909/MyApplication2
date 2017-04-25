package com.example.yothin_indy.myapplication;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.FrameLayout;

/**
 * Created by Yothin_Error on 25/4/2560.
 */

public class CustomViewGroup extends FrameLayout {
    private Button btnHello;
    public CustomViewGroup(@NonNull Context context) {
        super(context);
        initInflate();
        initInstances();

    }

    public CustomViewGroup(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initInflate();
        initInstances();
    }

    public CustomViewGroup(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initInflate();
        initInstances();
    }

    @TargetApi(21)
    public CustomViewGroup(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initInflate();
        initInstances();
    }
    private void initInflate(){
        inflate(getContext(),R.layout.sample_layout,this);

    }
    private void initInstances(){
        btnHello = (Button) findViewById(R.id.btnCustomViewGroupHello);
    }
    public void setButtonText(String text){
        btnHello.setText(text);
    }
}
