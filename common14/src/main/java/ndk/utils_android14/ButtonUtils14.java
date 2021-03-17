package ndk.utils_android14;

import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ButtonUtils14 {

    public static Button associateClickAction(AppCompatActivity currentAppCompatActivity, int buttonId, View.OnClickListener onClickListener) {

        Button button = currentAppCompatActivity.findViewById(buttonId);
        button.setOnClickListener(onClickListener);
        return button;
    }
}