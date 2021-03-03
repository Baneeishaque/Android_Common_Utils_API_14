package ndk.utils_android14;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import android.widget.Button;

public class ButtonUtils14 {
    
    public static Button associateClickAction(AppCompatActivity currentAppCompatActivity, int buttonId, View.OnClickListener onClickListener) {

        Button button = currentAppCompatActivity.findViewById(buttonId);
        button.setOnClickListener(onClickListener);
        return button;
    }
}