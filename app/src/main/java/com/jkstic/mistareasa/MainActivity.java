package com.jkstic.mistareasa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickButtonRecetas(View view){
        Intent recetas = new Intent(this,Recetas.class);
        startActivity(recetas);
    }

    public void onClickButtonCalendar(View view){
        Intent calendar = new Intent(this, CalendarioView.class);
        startActivity(calendar);
    }

    public void onClickButtonAlimentos(View view){
        //Intent recetas = new Intent(this,Recetas.class);
        //startActivity(recetas);
    }
}