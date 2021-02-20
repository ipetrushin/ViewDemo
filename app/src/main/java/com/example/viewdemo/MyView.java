package com.example.viewdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;

class Snowflake{
    float x = 100,y = 100,velocity = 2;
    Paint p = new Paint();
    /// конструктор для генерации снежинки со случайной скоростью и координатами
    public void draw(Canvas c) {
        p.setColor(Color.WHITE);
        c.drawCircle(x,y,50,p);
    }
    public void fall(){
        y += velocity;
    }
}

public class MyView extends View {
    float x = 100, y = 100;
    ArrayList<Snowflake> snowflakes = new ArrayList<>();

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        for (int i = 0; i < 100; i++) {
            snowflakes.add(new Snowflake());
        }
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.rgb(0,0,40));
        for (Snowflake s: snowflakes) {
            s.draw(canvas);
        }
        /* canvas.drawColor(Color.RED);
        Paint p = new Paint();
        p.setColor(Color.YELLOW);
        canvas.drawCircle(x,y, 20, p);
        */

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x = event.getX();
        y = event.getY();
        invalidate();
        for (Snowflake s: snowflakes) {
            s.fall();
        }
        return super.onTouchEvent(event);
    }
}
