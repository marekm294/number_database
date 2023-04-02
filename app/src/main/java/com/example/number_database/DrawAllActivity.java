package com.example.number_database;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.AndroidException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.zip.Inflater;

public class DrawAllActivity extends AppCompatActivity {

    private int origin;
    private boolean allOrOne;
    private TextView txt;
    private String[] myNumbers;
    private MyDraw myDraw;
    private DataBasaHelper dataBasaHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_all);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        myNumbers = getResources().getStringArray(R.array.numbers);
        dataBasaHelper = new DataBasaHelper(this);

        allOrOne = getIntent().getBooleanExtra("all", false);
        origin = getIntent().getIntExtra("origin", 0);

        getSupportActionBar().setTitle(myNumbers[origin]);

        myDraw = new MyDraw(this);
        setContentView(myDraw);
        checkPermissions();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_draw_all, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.draw_all_saveAndNext:
                Bitmap bitmap = getBitmapFromView(myDraw);
                int saveNumber = getSequence();
                saveImg(saveNumber, bitmap);
                nextImg();
                myDraw.clearDraw();
                return true;
            case R.id.menu_draw_all_width_8px:
                changeDrawWidth(8);
                return true;
            case R.id.menu_draw_all_width_11px:
                changeDrawWidth(11);
                return true;
            case R.id.menu_draw_all_width_14px:
                changeDrawWidth(14);
                return true;
            case R.id.menu_draw_all_width_17px:
                changeDrawWidth(17);
                return true;
            case R.id.menu_draw_all_width_20px:
                changeDrawWidth(20);
                return true;
            case R.id.menu_draw_all_width_23px:
                changeDrawWidth(23);
                return true;
            case R.id.menu_draw_all_width_26px:
                changeDrawWidth(26);
                return true;
            case R.id.draw_all_clear:
                myDraw.clearDraw();
                return true;
            case R.id.draw_all_camera:
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 100);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            try {
                Bitmap captureImage = (Bitmap) data.getExtras().get("data");
                int saveNumber = getSequence();
                saveImg(saveNumber, captureImage);
                nextImg();
                myDraw.clearDraw();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }


    private void changeDrawWidth(float f){
        if(myDraw.getPath().isEmpty())
            myDraw.setBrushWidth(f);
        else
            Toast.makeText(DrawAllActivity.this, "Šířku lze změnit pouze u prázdného obrázku.", Toast.LENGTH_SHORT).show();
    }

    private void nextImg(){
        if(allOrOne) {
            if (++origin < 10)
                getSupportActionBar().setTitle(myNumbers[origin]);
            else {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
        }

    }
    private int getSequence(){
        int returnValue = 0;
        Numbers numbers = dataBasaHelper.getAll();
        switch(origin){
            case 0:
                returnValue = numbers.getZero();
                dataBasaHelper.updateZero(returnValue + 1);
                break;
            case 1:
                returnValue = numbers.getOne();
                dataBasaHelper.updateOne(returnValue + 1);
                break;
            case 2:
                returnValue = numbers.getTwo();
                dataBasaHelper.updateTwo(returnValue + 1);
                break;
            case 3:
                returnValue = numbers.getThree();
                dataBasaHelper.updateThree(returnValue + 1);
                break;
            case 4:
                returnValue = numbers.getFour();
                dataBasaHelper.updateFour(returnValue + 1);
                break;
            case 5:
                returnValue = numbers.getFive();
                dataBasaHelper.updateFive(returnValue + 1);
                break;
            case 6:
                returnValue = numbers.getSix();
                dataBasaHelper.updateSix(returnValue + 1);
                break;
            case 7:
                returnValue = numbers.getSeven();
                dataBasaHelper.updateSeven(returnValue + 1);
                break;
            case 8:
                returnValue = numbers.getEight();
                dataBasaHelper.updateEight(returnValue + 1);
                break;
            case 9:
                returnValue = numbers.getNine();
                dataBasaHelper.updateNine(returnValue + 1);
                break;
        }
        return returnValue;
    }
    private void saveImg(int saveNumber, Bitmap bitmap){

        String filename = myNumbers[origin] + "_" + Integer.toString(saveNumber) + ".png";
        File file = Environment.getExternalStorageDirectory();
        File dir = new File(file.getPath() + "/numbers/");
        boolean b = dir.mkdirs();
        File outFile = new File(dir, filename);


        FileOutputStream outputStream = null;
        try{
            outputStream = new FileOutputStream(outFile);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);

        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            outputStream.flush();
        }catch(Exception e) {
            e.printStackTrace();
        }

        try{
            outputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void checkPermissions(){
        if(ContextCompat.checkSelfPermission(DrawAllActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);
            Toast.makeText(getApplicationContext(), "Toto je nutné pro ukládání souborů.", Toast.LENGTH_SHORT).show();
        }

        if(ContextCompat.checkSelfPermission(DrawAllActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);
            Toast.makeText(getApplicationContext(), "Toto je nutné pro ukládání souborů.", Toast.LENGTH_SHORT).show();
        }
        if(ContextCompat.checkSelfPermission(DrawAllActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, PackageManager.PERMISSION_GRANTED);
            Toast.makeText(getApplicationContext(), "Toto je nutné pro focení.", Toast.LENGTH_SHORT).show();
        }


    }
    private Bitmap getBitmapFromView(View view) {

        Bitmap bitmap;
        if(Build.VERSION.SDK_INT >= 28){
            bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            view.draw(canvas);        }
        else {
            view.setDrawingCacheEnabled(true);
            bitmap = Bitmap.createBitmap(view.getDrawingCache());
            view.setDrawingCacheEnabled(false);
        }
        return bitmap;
    }

}