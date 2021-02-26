package com.example.test_libgdxintoandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Findings extends AppCompatActivity {

        @Override
        protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findings);
            overridePendingTransition(0,0); //supprimer l'animation au changement d'activité
    }

}
