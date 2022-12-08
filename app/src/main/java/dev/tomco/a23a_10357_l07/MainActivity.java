package dev.tomco.a23a_10357_l07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private BackgroundSound mBackgroundSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mBackgroundSound = new BackgroundSound(this);
        mBackgroundSound.execute();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mBackgroundSound.cancel(true);
    }
}

