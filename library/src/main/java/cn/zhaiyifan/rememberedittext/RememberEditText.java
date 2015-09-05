package cn.zhaiyifan.rememberedittext;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.EditText;

public class RememberEditText extends EditText {

    private static final String PREFERENCE_KEY = "RememberEditText";

    private int mRememberCount = 1;
    private String mRememberId;
    private boolean mAutoFill = true;
    private Drawable mDeleteDrawable;
    private Drawable mDropDownDrawable;

    public RememberEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttrs(attrs);
    }

    public RememberEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(attrs);
    }

    private void initAttrs(AttributeSet attrs) {
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.RememberEditText);
        try {
            mDeleteDrawable = getResources().getDrawable(R.drawable.ic_delete, null);
            mDropDownDrawable = getResources().getDrawable(R.drawable.ic_drop_down, null);
        } finally {
            a.recycle();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mDeleteDrawable.draw(canvas);
        super.onDraw(canvas);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public static void clearCache() {

    }
}