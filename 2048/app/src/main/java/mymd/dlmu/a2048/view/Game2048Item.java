package mymd.dlmu.a2048.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by md on 2016/10/8.
 * email wbr0603@163.com
 */

public class Game2048Item extends View {

    /**
     * 该View上的数字
     */
    private int mNumber;
    private String mNumberVal;
    private Paint mPaint;
    /**
     * 绘制文字的区域
     */
    private Rect mBound;

    public Game2048Item(Context context) {
        super(context);
        mPaint = new Paint();
    }

    public Game2048Item(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
    }

    public Game2048Item(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
    }

    public void setNumber(int number) {
        mNumber = number;
        mNumberVal = number + "";
        mPaint.setTextSize(30.0f);
        mBound = new Rect();
        mPaint.getTextBounds(mNumberVal, 0, mNumberVal.length(), mBound);
        invalidate();
    }

    public int getNumber() {
        return mNumber;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        String mBgColor = " ";
        switch (mNumber) {
            case 0:
                mBgColor = "#CCC0B3";
                break;
            case 2:
                mBgColor = "#EEE4DA";
                break;
            case 4:
                mBgColor = "#EDE0C8";
                break;
            case 8:
                mBgColor = "#F2B179";// #F2B179
                break;
            case 16:
                mBgColor = "#F49563";
                break;
            case 32:
                mBgColor = "#F5794D";
                break;
            case 64:
                mBgColor = "#F55D37";
                break;
            case 128:
                mBgColor = "#EEE863";
                break;
            case 256:
                mBgColor = "#EDB04D";
                break;
            case 512:
                mBgColor = "#ECB04D";
                break;
            case 1024:
                mBgColor = "#EB9437";
                break;
            case 2048:
                mBgColor = "#EA7821";
                break;
            default:
                mBgColor = "#EA7821";
                break;
        }

        mPaint.setColor(Color.parseColor(mBgColor));
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawRect(0,0,getWidth(),getHeight(),mPaint);

        if(mNumber!=0){
            drawText(canvas);
        }
    }

    /**
     * 绘制文字
     *
     * @param canvas
     */
    private void drawText(Canvas canvas)
    {

        mPaint.setColor(Color.BLACK);
        float x = (getWidth() - mBound.width()) / 2;
        float y = getHeight() / 2 + mBound.height() / 2;
        canvas.drawText(mNumberVal, x, y, mPaint);
    }
}
