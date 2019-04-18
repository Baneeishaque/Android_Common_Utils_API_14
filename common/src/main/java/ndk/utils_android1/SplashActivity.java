package ndk.utils_android1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

//TODO : Full screen splash
//TODO : Develop tests

public abstract class SplashActivity extends Context_Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        // Splash screen timer
        int SPLASH_TIME_OUT = 3000;
        /*
         * Showing splash screen with a timer. This will be useful when you
         * want to show case your app logo / company logo
         */
        new Handler().postDelayed(() -> {
            // This method will be executed once the timer is over
            // Start your app main activity
            Intent i = new Intent(activity_context, configureNextClass());
            startActivity(i);

            // close this activity
            finish();
        }, SPLASH_TIME_OUT);
    }

    protected abstract Class<?> configureNextClass();
}

