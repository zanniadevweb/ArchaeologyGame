package com.example.test_libgdxintoandroid;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        overridePendingTransition(0,0); //supprimer l'animation au changement d'activité
    }

    // afficher app. photo
    public void displayPlayGame(View view) {
        Intent intent = new Intent(MainActivity.this, LayerActivity.class);
        MainActivity.this.startActivity(intent);
    }

}

