package com.example.test_libgdxintoandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class AppPhotoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_photo);

        overridePendingTransition(0,0); //supprimer l'animation au changement d'activité
    }

    // retour accueil
    public void displayAccueil(View view) {
        Intent intent = new Intent(AppPhotoActivity.this, MainActivity.class);
        AppPhotoActivity.this.startActivity(intent);
    }
}