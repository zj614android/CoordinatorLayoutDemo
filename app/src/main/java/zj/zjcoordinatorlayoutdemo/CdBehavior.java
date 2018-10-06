package zj.zjcoordinatorlayoutdemo;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SeekBar;

/**
 * Created by Administrator on 2017/7/23.
 */

public class CdBehavior extends CoordinatorLayout.Behavior {


    public CdBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    /**
     * 是否依赖（或者说是否顺从，是否成为被协调者）
     *
     * @param parent     父布局（协调者布局）
     * @param child      被协调者
     * @param dependency 协调者
     * @return
     */
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        if (dependency.getId() == R.id.seekBar1) {
            return true;
        }
        return false;
    }

    /**
     * 具体动作
     *
     * @param parent     父布局(协调者布局)
     * @param child      被协调者
     * @param dependency 协调者
     * @return
     */
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        setChildBehavior(getCoordinatorPar(dependency), child);
        return super.onDependentViewChanged(parent, child, dependency);
    }

    /**
     * 获取协调者seekBar的进度
     */
    public int getCoordinatorPar(View dependency) {
        return  ((ZJSeekBar)dependency).getProgcess();
    }


    /**
     * 根据协调者的进度，调整被协调者执行的动画
     */
    private void setChildBehavior(int progress, View child) {
        child.setRotation(Float.valueOf(progress));
    }

}
