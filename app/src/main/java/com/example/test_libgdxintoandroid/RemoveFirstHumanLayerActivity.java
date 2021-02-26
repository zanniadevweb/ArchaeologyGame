package com.example.test_libgdxintoandroid;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class RemoveFirstHumanLayerActivity extends AppCompatActivity {

    public int clickcount=0;
    private ViewGroup mainLayout;
    private ImageView ceramic1;

    private int xDelta;
    private int yDelta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_removefirsthumanlayer);
        overridePendingTransition(0,0); //supprimer l'animation au changement d'activité
        Button bt1 = findViewById(R.id.buttonNewFidings);
        bt1.setVisibility(View.INVISIBLE);


        mainLayout = (ConstraintLayout) findViewById(R.id.constraintLayout);
        ceramic1 = (ImageView) findViewById(R.id.ceramic1);
        ceramic1.setOnTouchListener(onTouchListener());
    }


    public void goCheckFirstFindings(View view) {
        Intent intent = new Intent(RemoveFirstHumanLayerActivity.this, Findings.class);
        RemoveFirstHumanLayerActivity.this.startActivity(intent);
    }

    private View.OnTouchListener onTouchListener() {
        return new View.OnTouchListener() {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent event) {

                final int x = (int) event.getRawX();
                final int y = (int) event.getRawY();

                Log.d("x", "X==" + x);
                Log.d("y ", "Y==" + y);

                if (x >= 780 && y <= 1078) {
                    ceramic1 = (ImageView) findViewById(R.id.ceramic1);
                    ceramic1.setVisibility(View.INVISIBLE);

                    TextView tv1 = findViewById(R.id.textView);
                    tv1.setText("It is time to check our findings with the team.");
                    TextView tv2 = findViewById(R.id.textView2);
                    tv2.setText("Click on the top right button.");
                    Button bt1 = findViewById(R.id.buttonNewFidings);
                    bt1.setVisibility(View.VISIBLE);
                }

                switch (event.getAction() & MotionEvent.ACTION_MASK) {

                    case MotionEvent.ACTION_DOWN:
                        ConstraintLayout.LayoutParams lParams = (ConstraintLayout.LayoutParams)
                                view.getLayoutParams();

                        xDelta = x - lParams.leftMargin;
                        yDelta = y - lParams.topMargin;
                        break;

                    case MotionEvent.ACTION_MOVE:
                        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) view
                                .getLayoutParams();
                        layoutParams.leftMargin = x - xDelta;
                        layoutParams.topMargin = y - yDelta;
                        layoutParams.rightMargin = 0;
                        layoutParams.bottomMargin = 0;
                        view.setLayoutParams(layoutParams);
                        break;
                }
                mainLayout.invalidate();
                return true;
            }
        };
    }

}