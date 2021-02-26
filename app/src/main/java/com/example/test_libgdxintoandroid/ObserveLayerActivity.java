package com.example.test_libgdxintoandroid;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.constraintlayout.widget.ConstraintLayout;

public class ObserveLayerActivity extends AppCompatActivity {

    public int clickcount=0;
    private ViewGroup mainLayout;
    private ImageView image;

    private int xDelta;
    private int yDelta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observelayer);
        overridePendingTransition(0,0); //supprimer l'animation au changement d'activité
        TextView tv2 = findViewById(R.id.textView2);
        tv2.setVisibility(View.INVISIBLE);
        Button bt3 = findViewById(R.id.buttonClearGrass);
        bt3.setVisibility(View.INVISIBLE);
        ImageView imgv2 = findViewById(R.id.grassyLandscapeCutOff);
        imgv2.setAlpha(0f);
        ImageView imgv3 = findViewById(R.id.gifShovel);
        imgv3.setVisibility(View.INVISIBLE);
        ImageView imgv4 = findViewById(R.id.grassyLandscapeClean);
        imgv4.setVisibility(View.INVISIBLE);
        Button bt4 = findViewById(R.id.buttonLayerNew);
        bt4.setVisibility(View.INVISIBLE);


        mainLayout = (ConstraintLayout) findViewById(R.id.constraintLayout);
        image = (ImageView) findViewById(R.id.trowel);
        image.setClickable(false);

        image.setVisibility(View.INVISIBLE);

        image.setOnTouchListener(onTouchListener());
    }

    public void goLayerNext(View view) {
        Intent intent = new Intent(ObserveLayerActivity.this, LayerActivity2.class);
        ObserveLayerActivity.this.startActivity(intent);
    }

    public void nextStep2(View view) {
        TextView tv1 = findViewById(R.id.textView);
        tv1.setText("During the last summer, a pedestrian survey allowed us to find some archaeological objects.");
        Button bt2 = findViewById(R.id.buttonNextStep2);
        bt2.setVisibility(View.INVISIBLE);
        TextView tv2 = findViewById(R.id.textView2);
        tv2.setVisibility(View.VISIBLE);
        Button bt3 = findViewById(R.id.buttonClearGrass);
        bt3.setVisibility(View.VISIBLE);
    }

    public void clearGrass(View view) {
        clickcount=clickcount+1;
        ImageView imgv3 = findViewById(R.id.gifShovel);
        imgv3.setVisibility(View.VISIBLE);
        if(clickcount==1)
        {
            ImageView imgv2 = findViewById(R.id.grassyLandscapeCutOff);
            imgv2.setAlpha(0.20f);
        }
        if(clickcount==1)
        {
            ImageView imgv2 = findViewById(R.id.grassyLandscapeCutOff);
            imgv2.setAlpha(0.40f);
        }
        if(clickcount==2)
        {
            ImageView imgv2 = findViewById(R.id.grassyLandscapeCutOff);
            imgv2.setAlpha(0.60f);
        }
        if(clickcount==3)
        {
            ImageView imgv2 = findViewById(R.id.grassyLandscapeCutOff);
            imgv2.setAlpha(0.80f);
        }
        if(clickcount==3)
        {
            ImageView imgv1 = findViewById(R.id.grassyLandscape);
            imgv1.setVisibility(View.INVISIBLE);
            ImageView imgv2 = findViewById(R.id.grassyLandscapeCutOff);
            imgv2.setAlpha(0.95f);
        }
        if(clickcount==4)
        {
            ImageView imgv1 = findViewById(R.id.grassyLandscape);
            imgv1.setVisibility(View.INVISIBLE);
            ImageView imgv2 = findViewById(R.id.grassyLandscapeCutOff);
            imgv2.setAlpha(1f);
        }
        if(clickcount==5)
        {
            imgv3.setVisibility(View.INVISIBLE);
            Button bt3 = findViewById(R.id.buttonClearGrass);
            bt3.setVisibility(View.INVISIBLE);
            TextView tv1 = findViewById(R.id.textView);
            tv1.setText("Well done! It is time to clean the first vegetal layer now. Let's use the trowel.");
            TextView tv2 = findViewById(R.id.textView);
            tv2.setText("Pick the tool in the dirt and bring it down the screen to have a flat dirt.");

            image = (ImageView) findViewById(R.id.trowel);
            image.setVisibility(View.VISIBLE);
            image.setClickable(true);
        }
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

                if (x >= 297 && x <= 730 && y >= 2280) {
                    ImageView imgv4 = findViewById(R.id.grassyLandscapeClean);
                    imgv4.setVisibility(View.VISIBLE);
                    image = (ImageView) findViewById(R.id.trowel);
                    image.setVisibility(View.INVISIBLE);

                    TextView tv1 = findViewById(R.id.textView);
                    tv1.setText("Great! Now let's see what is next.");
                    TextView tv2 = findViewById(R.id.textView2);
                    tv2.setText("Click on the top right button.");
                    Button bt4 = findViewById(R.id.buttonLayerNew);
                    bt4.setVisibility(View.VISIBLE);
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