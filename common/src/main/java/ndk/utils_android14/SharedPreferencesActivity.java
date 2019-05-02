package ndk.utils_android14;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

public abstract class SharedPreferencesActivity extends AppCompatActivity {

    public SharedPreferences get_shared_preferences() {
        return getApplicationContext().getSharedPreferences(configure_APPLICATION_NAME(), Context.MODE_PRIVATE);
    }

    protected abstract String configure_APPLICATION_NAME();
}
