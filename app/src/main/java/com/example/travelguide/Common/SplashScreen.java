package com.example.travelguide.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.travelguide.R;
import com.example.travelguide.User.UserDashboard;

public class SplashScreen extends AppCompatActivity {
    private static int SPLASH_TIMER = 5000;
    //variable
    ImageView backgroundImage;
    TextView simpletext;

//Animation
    Animation sideAnim, bottomAnim;
    SharedPreferences onBoardingScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);
        //hooks-
        backgroundImage = findViewById(R.id.background_image);
        simpletext = findViewById(R.id.simpletext);

        //Animation
        sideAnim = AnimationUtils.loadAnimation(this,R.anim.side_anim);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_anim);

        backgroundImage.setAnimation(sideAnim);
       simpletext.setAnimation(bottomAnim);

new Handler().postDelayed(new Runnable()
{

    @Override
    public void run() {

        onBoardingScreen = getSharedPreferences("onBoardingScreen", MODE_PRIVATE);
        boolean isFirstTime = onBoardingScreen.getBoolean("firstTime", true);

        if (isFirstTime) {

            SharedPreferences.Editor editor = onBoardingScreen.edit();
            editor.putBoolean("firstTime",false);
            editor.commit();
            Intent intent = new Intent(getApplicationContext(), OnBoarding.class);
            startActivity(intent);
            finish();

        }
        else{
            Intent intent = new Intent(getApplicationContext(), UserDashboard.class);
            startActivity(intent);
            finish();

        }
    }
},SPLASH_TIMER);
    }
}