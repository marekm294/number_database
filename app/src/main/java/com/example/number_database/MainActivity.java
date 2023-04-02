package com.example.number_database;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
        getSupportActionBar().setTitle("Menu");
        checkIfNotEmpty();
        dialog = new Dialog(this);
    }

    public void allNumbers(View v){
        Intent intent = new Intent(this, DrawAllActivity.class);
        intent.putExtra("all", true);
        intent.putExtra("origin", 0);
        startActivity(intent);
    }

    public void oneNumber(View v){
        dialog.setContentView(R.layout.my_popup);
        Button finish = dialog.findViewById(R.id.popup_xBtn);
        Button zero = dialog.findViewById(R.id.popup_zeroBtn);
        Button one = dialog.findViewById(R.id.popup_oneBtn);
        Button two = dialog.findViewById(R.id.popup_twoBtn);
        Button three = dialog.findViewById(R.id.popup_threeBtn);
        Button four = dialog.findViewById(R.id.popup_fourBtn);
        Button five = dialog.findViewById(R.id.popup_fiveBtn);
        Button six = dialog.findViewById(R.id.popup_sixBtn);
        Button seven = dialog.findViewById(R.id.popup_sevenBtn);
        Button eight = dialog.findViewById(R.id.popup_eightBtn);
        Button nine = dialog.findViewById(R.id.popup_nineBtn);

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DrawAllActivity.class);
                intent.putExtra("origin", 0);
                startActivity(intent);
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DrawAllActivity.class);
                intent.putExtra("origin", 1);
                startActivity(intent);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DrawAllActivity.class);
                intent.putExtra("origin", 2);
                startActivity(intent);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DrawAllActivity.class);
                intent.putExtra("origin", 3);
                startActivity(intent);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DrawAllActivity.class);
                intent.putExtra("origin", 4);
                startActivity(intent);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DrawAllActivity.class);
                intent.putExtra("origin", 5);
                startActivity(intent);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DrawAllActivity.class);
                intent.putExtra("origin", 6);
                startActivity(intent);
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DrawAllActivity.class);
                intent.putExtra("origin", 7);
                startActivity(intent);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DrawAllActivity.class);
                intent.putExtra("origin", 8);
                startActivity(intent);
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DrawAllActivity.class);
                intent.putExtra("origin", 9);
                startActivity(intent);
            }
        });
        dialog.show();

    }

    public void settings(View v){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }


    public void checkIfNotEmpty(){
        DataBasaHelper dataBasaHelper = new DataBasaHelper(MainActivity.this);
        if(dataBasaHelper.getSizeOfDb() == 0)
            dataBasaHelper.addZeros();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case(R.id.finish):
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}