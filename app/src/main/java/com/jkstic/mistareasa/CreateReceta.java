package com.jkstic.mistareasa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class CreateReceta extends AppCompatActivity {

    LinearLayout scAliment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_receta);

        scAliment = findViewById(R.id.scAliment);
    }

    public void createAliment(View view){
        TextInputEditText txname = new TextInputEditText(this);
        txname.setText("");
        EditText tx = new EditText(this);


        LinearLayout linea = new LinearLayout(this);
        linea.addView(txname);
        linea.addView(tx);
        scAliment.addView(linea);
    }
}