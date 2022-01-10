package com.jkstic.mistareasa;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import com.jkstic.mistareasa.dto.RecetaDto;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

public class Recetas extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.jkstic.mistareasa.MESSAGE";
    LinearLayout scrollLinear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recetas);

        scrollLinear = findViewById(R.id.scroller);

        scrollLinear.addView(createLineViewReceta("receta1"));
        scrollLinear.addView(createLineViewReceta("receta2"));
        try
        {

            // Create URL
            URL githubEndpoint = new URL("http://localhost:8080/api/alimentos");

            // Create connection
            HttpsURLConnection myConnection = (HttpsURLConnection) githubEndpoint.openConnection();
            myConnection.setDoOutput(true);
            myConnection.setRequestMethod("GET");

            myConnection.setRequestProperty("Content-Type", "application/json");
            if (myConnection.getResponseCode() == 200) {

                BufferedReader in = new BufferedReader( new InputStreamReader(myConnection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                Log.e("r",response.toString());
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(this, response, Toast.LENGTH_LONG);
                toast.show();
            } else {
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(this, "ERROR", Toast.LENGTH_LONG);
                toast.show();
            }
            Toast toast = Toast.makeText(this, "COMPLET", Toast.LENGTH_LONG);
            toast.show();
        }catch(Exception ex) {
           Log.e("ServicioRest","Error!", ex);
        }
    }

    private LinearLayout createLineViewReceta(String name){
        Button bt1 = new Button(this);
        TextView tx = new TextView(this);

        bt1.setText("bt");
        tx.setText(name);

        RecetaDto rec =  new RecetaDto();
        rec.setName(name);

        bt1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent viewReceta = new Intent(v.getContext(),ViewReceta.class);
                viewReceta.putExtra(EXTRA_MESSAGE, name);

                Bundle bn = new Bundle();
                bn.putSerializable("dto",rec);
                viewReceta.putExtras(bn);
                startActivity(viewReceta);
            }
        });

        LinearLayout linea = new LinearLayout(this);
        linea.addView(bt1);
        linea.addView(tx);

        return linea;
    }


    public void addReceta(View view){
        Intent createReceta = new Intent(this,CreateReceta.class);
        startActivity(createReceta);
    }
}