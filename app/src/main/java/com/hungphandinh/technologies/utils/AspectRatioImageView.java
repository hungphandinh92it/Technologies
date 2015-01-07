package com.hungphandinh.technologies.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

public class AspectRatioImageView extends ImageView
{
  public AspectRatioImageView(Context paramContext)
  {
    super(paramContext);
  }

  public AspectRatioImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public AspectRatioImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    try
    {
      int i = MeasureSpec.getSize(paramInt1);
      setMeasuredDimension(i, i * getDrawable().getIntrinsicHeight() / getDrawable().getIntrinsicWidth());
      return;
    }
    catch (Exception localException)
    {
    	super.onMeasure(paramInt1, paramInt2);
    }
  }
}
