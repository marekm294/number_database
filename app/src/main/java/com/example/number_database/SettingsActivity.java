package com.example.number_database;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AlertDialog;

import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    EditText et0;
    EditText et1;
    EditText et2;
    EditText et3;
    EditText et4;
    EditText et5;
    EditText et6;
    EditText et7;
    EditText et8;
    EditText et9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
        getSupportActionBar().setTitle("Nastavení");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        joinETs();
        setETs();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.settings_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case (R.id.settings_save):
                AlertDialog.Builder confirmSave = new AlertDialog.Builder(SettingsActivity.this);
                confirmSave.setCancelable(false);
                confirmSave.setMessage("Opravdu chcete uložit změnu? Hrozí přeskočení některých čísel.");
                confirmSave.setPositiveButton("ANO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        checkEmptyETs();
                        saveIt();
                        setETHints();
                    }
                });
                confirmSave.setNegativeButton("NE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                AlertDialog showConfirmSave = confirmSave.create();
                showConfirmSave.show();
                return true;
            case(R.id.setting_plusAll):
                checkEmptyETs();
                et0.setText(Integer.toString(Integer.parseInt(et0.getText().toString()) + 1));
                et1.setText(Integer.toString(Integer.parseInt(et1.getText().toString()) + 1));
                et2.setText(Integer.toString(Integer.parseInt(et2.getText().toString()) + 1));
                et3.setText(Integer.toString(Integer.parseInt(et3.getText().toString()) + 1));
                et4.setText(Integer.toString(Integer.parseInt(et4.getText().toString()) + 1));
                et5.setText(Integer.toString(Integer.parseInt(et5.getText().toString()) + 1));
                et6.setText(Integer.toString(Integer.parseInt(et6.getText().toString()) + 1));
                et7.setText(Integer.toString(Integer.parseInt(et7.getText().toString()) + 1));
                et8.setText(Integer.toString(Integer.parseInt(et8.getText().toString()) + 1));
                et9.setText(Integer.toString(Integer.parseInt(et9.getText().toString()) + 1));
                saveIt();
                setETHints();
                return true;
            case(R.id.setting_reset):
                Numbers numbers = new Numbers(0,0,0,0,0,0,0,0,0,0);
                DataBasaHelper dataBasaHelper = new DataBasaHelper(this);
                dataBasaHelper.updateAll(numbers);
                setETHints();
                setETs();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void setETs(){
        DataBasaHelper dataBasaHelper = new DataBasaHelper(SettingsActivity.this);
        Numbers numbers = dataBasaHelper.getAll();

        et0.setText(numbers.getStringZero());
        et1.setText(numbers.getStringOne());
        et2.setText(numbers.getStringTwo());
        et3.setText(numbers.getStringThree());
        et4.setText(numbers.getStringFour());
        et5.setText(numbers.getStringFive());
        et6.setText(numbers.getStringSix());
        et7.setText(numbers.getStringSeven());
        et8.setText(numbers.getStringEight());
        et9.setText(numbers.getStringNine());

        setETHints();

    }
    public void setETHints(){
        DataBasaHelper dataBasaHelper = new DataBasaHelper(SettingsActivity.this);
        Numbers numbers = dataBasaHelper.getAll();

        et0.setHint(numbers.getStringZero());
        et1.setHint(numbers.getStringOne());
        et2.setHint(numbers.getStringTwo());
        et3.setHint(numbers.getStringThree());
        et4.setHint(numbers.getStringFour());
        et5.setHint(numbers.getStringFive());
        et6.setHint(numbers.getStringSix());
        et7.setHint(numbers.getStringSeven());
        et8.setHint(numbers.getStringEight());
        et9.setHint(numbers.getStringNine());
    }
    public void plusThis(View v){
        checkEmptyETs();

        if(v == findViewById(R.id.plus0))
            et0.setText(Integer.toString(Integer.parseInt(et0.getText().toString()) + 1));
        if(v == findViewById(R.id.plus1))
            et1.setText(Integer.toString(Integer.parseInt(et1.getText().toString()) + 1));
        if(v == findViewById(R.id.plus2))
            et2.setText(Integer.toString(Integer.parseInt(et2.getText().toString()) + 1));
        if(v == findViewById(R.id.plus3))
            et3.setText(Integer.toString(Integer.parseInt(et3.getText().toString()) + 1));
        if(v == findViewById(R.id.plus4))
            et4.setText(Integer.toString(Integer.parseInt(et4.getText().toString()) + 1));
        if(v == findViewById(R.id.plus5))
            et5.setText(Integer.toString(Integer.parseInt(et5.getText().toString()) + 1));
        if(v == findViewById(R.id.plus6))
            et6.setText(Integer.toString(Integer.parseInt(et6.getText().toString()) + 1));
        if(v == findViewById(R.id.plus7))
            et7.setText(Integer.toString(Integer.parseInt(et7.getText().toString()) + 1));
        if(v == findViewById(R.id.plus8))
            et8.setText(Integer.toString(Integer.parseInt(et8.getText().toString()) + 1));
        if(v == findViewById(R.id.plus9))
            et9.setText(Integer.toString(Integer.parseInt(et9.getText().toString()) + 1));
    }

    private void joinETs(){
        et0 = findViewById(R.id.et0);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        et4 = findViewById(R.id.et4);
        et5 = findViewById(R.id.et5);
        et6 = findViewById(R.id.et6);
        et7 = findViewById(R.id.et7);
        et8 = findViewById(R.id.et8);
        et9 = findViewById(R.id.et9);
    }
    private void checkEmptyETs(){
        DataBasaHelper dataBasaHelper = new DataBasaHelper(SettingsActivity.this);
        Numbers numbers = dataBasaHelper.getAll();
        if(et0.getText().toString().length() == 0 || et0.getText().toString().equals("-") || Integer.parseInt(et0.getText().toString()) < 0)
            et0.setText(numbers.getStringZero());
        if(et1.getText().toString().length() == 0 || et1.getText().toString().equals("-") || Integer.parseInt(et1.getText().toString()) < 0)
            et1.setText(numbers.getStringOne());
        if(et2.getText().toString().length() == 0 || et2.getText().toString().equals("-") || Integer.parseInt(et2.getText().toString()) < 0)
            et2.setText(numbers.getStringTwo());
        if(et3.getText().toString().length() == 0 || et3.getText().toString().equals("-") || Integer.parseInt(et3.getText().toString()) < 0)
            et3.setText(numbers.getStringThree());
        if(et4.getText().toString().length() == 0 || et4.getText().toString().equals("-") || Integer.parseInt(et4.getText().toString()) < 0)
            et4.setText(numbers.getStringFour());
        if(et5.getText().toString().length() == 0 || et5.getText().toString().equals("-") || Integer.parseInt(et5.getText().toString()) < 0)
            et5.setText(numbers.getStringFive());
        if(et6.getText().toString().length() == 0 || et6.getText().toString().equals("-") || Integer.parseInt(et6.getText().toString()) < 0)
            et6.setText(numbers.getStringSix());
        if(et7.getText().toString().length() == 0 || et7.getText().toString().equals("-") || Integer.parseInt(et7.getText().toString()) < 0)
            et7.setText(numbers.getStringSeven());
        if(et8.getText().toString().length() == 0 || et8.getText().toString().equals("-") || Integer.parseInt(et8.getText().toString()) < 0)
            et8.setText(numbers.getStringEight());
        if(et9.getText().toString().length() == 0 || et9.getText().toString().equals("-") || Integer.parseInt(et9.getText().toString()) < 0)
            et9.setText(numbers.getStringNine());

    }
    private void saveIt(){
        Numbers numbers = new Numbers();
        numbers.setZero(et0.getText().toString());
        numbers.setOne(et1.getText().toString());
        numbers.setTwo(et2.getText().toString());
        numbers.setThree(et3.getText().toString());
        numbers.setFour(et4.getText().toString());
        numbers.setFive(et5.getText().toString());
        numbers.setSix(et6.getText().toString());
        numbers.setSeven(et7.getText().toString());
        numbers.setEight(et8.getText().toString());
        numbers.setNine(et9.getText().toString());

        DataBasaHelper dataBasaHelper = new DataBasaHelper(SettingsActivity.this);
        dataBasaHelper.updateAll(numbers);

    }

}