package cn.zhaiyifan.rememberedittext;

import android.content.Context;
import android.content.res.TypedArray;
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

    private static final int DEFAULT_REMEMBER_COUNT = 3;
    private static final int ICON_MARGIN = 10;

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

            mDeleteDrawable = getResources().getDrawable(a.getResourceId(
                    R.styleable.RememberEditText_deleteIcon, R.drawable.abc_ic_clear_mtrl_alpha));
            if (mDeleteDrawable != null) {
                mDeleteDrawable.setBounds(0, 0, mDeleteDrawable.getIntrinsicWidth(), mDeleteDrawable.getIntrinsicHeight());
            }

            mDropDownDrawable = getResources().getDrawable(a.getResourceId(
                    R.styleable.RememberEditText_dropDownIcon, R.drawable.abc_spinner_mtrl_am_alpha));
            if (mDropDownDrawable != null) {
                mDropDownDrawable.setBounds(0, 0, mDropDownDrawable.getIntrinsicWidth(), mDropDownDrawable.getIntrinsicHeight());
            }

            mRememberCount = a.getInt(R.styleable.RememberEditText_rememberCount, DEFAULT_REMEMBER_COUNT);
            mRememberId = a.getString(R.styleable.RememberEditText_rememberId);
            // if not set rememberId, use view id
            if (null == mRememberId) {
                mRememberId = String.valueOf(getId());
            }

            mAutoFill = a.getBoolean(R.styleable.RememberEditText_autoFill, true);
        } finally {
            a.recycle();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(getMeasuredWidth() - mDropDownDrawable.getIntrinsicWidth()
                - mDeleteDrawable.getIntrinsicWidth() - ICON_MARGIN, 0);
        mDeleteDrawable.draw(canvas);
        canvas.translate(mDeleteDrawable.getIntrinsicWidth() + ICON_MARGIN, 0);
        mDropDownDrawable.draw(canvas);
        canvas.restore();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    /**
     * Clear all cache managed by RememberEditText.
     */
    public static void clearCache() {

    }
}