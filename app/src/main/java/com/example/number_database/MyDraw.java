package com.example.number_database;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

public class MyDraw extends View {

    private Paint paint = new Paint();
    private Path path = new Path();
    private Paint drawPaint;
    private float brushWidth = 17;
    private Bitmap canvasBitmap;
    private Canvas drawCanvas;


    public MyDraw(Context context) {
        super(context);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeMiter(.5f);
        paint.setStrokeWidth(brushWidth);
        drawPaint = new Paint(Paint.DITHER_FLAG);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // Deklarace proměnných pro ukládání pozice dotyku
        float xPos = event.getX();
        float yPos = event.getY();

        // Zpracování akcí
        switch (event.getAction()) {
            // Při dotyku, se vyresetuje výchozí pozice
            case MotionEvent.ACTION_DOWN:
                path.moveTo(xPos, yPos);
                break;

            // Při pohybu nebo opuštění obrazovky
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_UP:
                // Nastaví se současné souřadnice
                path.lineTo(xPos, yPos);
                break;
        }
        // Překreslení
        invalidate();
        return true;
    }


    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
        canvas.drawPath(path, paint);
    }

    public void setBrushWidth(float newWidth){
        brushWidth = newWidth;
        paint.setStrokeWidth(brushWidth);
        invalidate();
    }
    public void clearDraw(){
        path.reset();
        invalidate();
    }
    public Path getPath(){
        return path;
    }

}
