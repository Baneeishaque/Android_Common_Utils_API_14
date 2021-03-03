package ndk.utils_android14;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityWithContexts extends AppCompatActivity {

    public Context currentActivityContext = this, currentApplicationContext;
    public AppCompatActivity currentAppCompatActivity = this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        currentApplicationContext = getApplicationContext();
    }
}
