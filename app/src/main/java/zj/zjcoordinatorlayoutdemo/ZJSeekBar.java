package zj.zjcoordinatorlayoutdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public class ZJSeekBar extends View {

    private int lastX;
    int progress;
    private int diff;
    private Bitmap mBitmap;
    private Rect mDestRect;
    private Paint mBitPaint;
    private Context mContext = null;

    public ZJSeekBar(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public ZJSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    public ZJSeekBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int x = (int) event.getRawX();
        int y = (int) event.getRawY();
        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN: {
                break;
            }

            case MotionEvent.ACTION_MOVE: {
                ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
                diff = (x - lastX);
                int left = layoutParams.leftMargin + diff;

                layoutParams.leftMargin = left;
                setLayoutParams(layoutParams);
                requestLayout();

                if (diff > 0) {
                    progress += 5;
                } else {
                    progress -= 5;
                }


                break;
            }

            case MotionEvent.ACTION_UP: {

                break;
            }

        }
        lastX = x;
        return true;
    }

    private void init() {
        mBitmap = ((BitmapDrawable) mContext.getResources().getDrawable(R.mipmap.bottombt)).getBitmap();
        mDestRect = new Rect(0, 0, ScreenUtils.px2dip(mContext,105f), ScreenUtils.px2dip(mContext,105f));
        mBitPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBitPaint.setFilterBitmap(true);
        mBitPaint.setDither(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(mBitmap, null, mDestRect, mBitPaint);
    }

    public int getProgcess() {
        return progress;
    }




}