package com.example.advancedcalculator.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      github : https://github.com/HurleyJames
 *      time   : 2018/11/14 上午12:18
 *      desc   :
 * </pre>
 */
public class SingleLineZoomTextView extends TextView {
    private static final String TAG = "SingleLineZoomTextView";

    private Paint mPaint;
    private float mTextSize;

    public SingleLineZoomTextView(Context context) {
        super(context);
    }

    public SingleLineZoomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SingleLineZoomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * getTextSize返回值是以像素（px）为单位，而setTextSize默认是以sp为单位
     * 所以需要传入像素单位setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
     * @param text
     * @param textWidth
     */
    private void refitText(String text, int textWidth) {
        if (textWidth > 0) {
            mTextSize = this.getTextSize();
            mPaint = new Paint();
            mPaint.set(this.getPaint());
            int drawWid = 0;
            Drawable[] draws = getCompoundDrawables();
            for (int i = 0; i < draws.length; i++) {
                if (draws[i] != null) {
                    drawWid += draws[i].getBounds().width();
                }
            }

            //获得当前TextView的有效宽度
            int availableWidth = textWidth - this.getPaddingLeft()
                    - this.getPaddingRight() - getCompoundDrawablePadding() - drawWid;
            //所有字符所占像素宽度
            float textWidths = getTextLength(mTextSize, text);
            while (textWidths > availableWidth) {
                //这里传入单位为px
                mPaint.setTextSize(--mTextSize);
                textWidths = getTextLength(mTextSize, text);
            }
            //这里设置单位为px
            this.setTextSize(TypedValue.COMPLEX_UNIT_PX, mTextSize);
        }
    }

    /**
     * 字符串所占像素宽度
     * @param textSize
     * @param text
     * @return
     */
    private float getTextLength(float textSize, String text) {
        mPaint.setTextSize(textSize);
        return mPaint.measureText(text);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        refitText(getText().toString(), this.getWidth());
    }

}
