package com.mesum.blitzcric;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatImageView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatImageView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatImageView;

public class HexagonImageView extends AppCompatImageView {
    private Path hexagonPath;
    private RectF outerRect;
    private RectF innerRect;
    private Paint outerPaint;
    private Paint innerPaint;

    public HexagonImageView(Context context) {
        super(context);
        init();
    }

    public HexagonImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HexagonImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        hexagonPath = new Path();

        // Set up outer background paint
        outerPaint = new Paint();
        outerPaint.setColor(R.color.hexagonouter); // Change the color as needed
        outerPaint.setStyle(Paint.Style.FILL);

        // Set up inner background paint
        innerPaint = new Paint();
        innerPaint.setColor(R.color.hexagoninner); // Change the color as needed
        innerPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        // Calculate outer and inner rectangles
        outerRect = new RectF(0, 0, getMeasuredWidth(), getMeasuredHeight());
        innerRect = new RectF(
                outerRect.left + 10, // Adjust the padding as needed
                outerRect.top + 10, // Adjust the padding as needed
                outerRect.right - 10, // Adjust the padding as needed
                outerRect.bottom - 10 // Adjust the padding as needed
        );
    }



    @Override
    protected void onDraw(Canvas canvas) {
        hexagonPath.reset();
        float centerX = getWidth() / 2f;
        float centerY = getHeight() / 2f;
        float radius = Math.min(getWidth() / 2f, getHeight() / 2f);

        // Define the points of the hexagon
        float x = radius * (float) Math.cos(2 * Math.PI * 30 / 360f);
        float y = radius * (float) Math.sin(2 * Math.PI * 30 / 360f);
        hexagonPath.moveTo(centerX + x, centerY + y);
        for (int i = 1; i < 6; i++) {
            x = radius * (float) Math.cos(2 * Math.PI * (30 + 60 * i) / 360f);
            y = radius * (float) Math.sin(2 * Math.PI * (30 + 60 * i) / 360f);
            hexagonPath.lineTo(centerX + x, centerY + y);
        }
        hexagonPath.close();

        // Draw outer background color in the hexagon shape
        canvas.drawPath(hexagonPath, outerPaint);

        // Clip the canvas with the hexagon path
        canvas.clipPath(hexagonPath);

        // Draw inner background color
        canvas.drawRect(innerRect, innerPaint);

        super.onDraw(canvas);
    }


}
