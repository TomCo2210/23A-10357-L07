package dev.tomco.a23a_10357_l07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.textview.MaterialTextView;

public class MainActivity extends AppCompatActivity {

    private BackgroundSound mBackgroundSound;

    private MaterialTextView main_LBL_stepsX;
    private MaterialTextView main_LBL_stepsY;
    private StepDetector stepDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        initStepDetector();
    }

    private void initStepDetector() {
        stepDetector = new StepDetector(this, new StepCallback() {
            @Override
            public void stepX() {
                main_LBL_stepsX.setText("" + stepDetector.getStepCountX());
            }

            @Override
            public void stepY() {
                main_LBL_stepsY.setText("" + stepDetector.getStepCountY());
            }
        });
    }

    private void findViews() {
        main_LBL_stepsX = findViewById(R.id.main_LBL_stepsX);
        main_LBL_stepsY = findViewById(R.id.main_LBL_stepsY);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mBackgroundSound = new BackgroundSound(this);
        mBackgroundSound.execute();
        stepDetector.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mBackgroundSound.cancel(true);
        stepDetector.stop();
    }
}

