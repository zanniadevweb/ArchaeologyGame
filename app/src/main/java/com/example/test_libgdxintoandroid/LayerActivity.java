package com.example.test_libgdxintoandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

public class LayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layers);
        overridePendingTransition(0,0); //supprimer l'animation au changement d'activité
        Button bt1 = findViewById(R.id.buttonDiggingActivity);
        bt1.setClickable(false);
        ImageView imgv1 = findViewById(R.id.handclick);
        imgv1.setVisibility(View.INVISIBLE);
        ImageView imgv2 = findViewById(R.id.rectanglearea);
        imgv2.setVisibility(View.INVISIBLE);
    }

    public void displayAccueil(View view) {
        Intent intent = new Intent(LayerActivity.this, MainActivity.class);
        LayerActivity.this.startActivity(intent);
    }

    public void onDiggingActivity(View view) {
        Intent intent = new Intent(LayerActivity.this, ObserveLayerActivity.class);
        LayerActivity.this.startActivity(intent);
    }

    public void nextStep1(View view) {
        TextView tv1 = findViewById(R.id.titre);
        tv1.setText("Click on the first layer");
        Button bt2 = findViewById(R.id.buttonNextStep1);
        bt2.setVisibility(View.INVISIBLE);
        Button bt1 = findViewById(R.id.buttonDiggingActivity);
        ImageView imgv1 = findViewById(R.id.handclick);
        imgv1.setVisibility(View.VISIBLE);
        ImageView imgv2 = findViewById(R.id.rectanglearea);
        imgv2.setVisibility(View.VISIBLE);
        bt1.setClickable(true);
    }

}