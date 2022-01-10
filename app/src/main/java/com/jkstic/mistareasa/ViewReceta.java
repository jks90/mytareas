package com.jkstic.mistareasa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.jkstic.mistareasa.dto.RecetaDto;

public class ViewReceta extends AppCompatActivity {

    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_receta);

        title = findViewById(R.id.titleReceta);

        Intent intent = getIntent();
        String message = intent.getStringExtra(Recetas.EXTRA_MESSAGE);

        Bundle bn = intent.getExtras();
        RecetaDto receta = (RecetaDto) bn.getSerializable("dto");

        title.setText(receta.getName());
    }
}