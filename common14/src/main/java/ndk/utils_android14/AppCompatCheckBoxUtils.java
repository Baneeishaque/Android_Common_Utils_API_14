package ndk.utils_android14;

import android.content.Context;
import android.view.Gravity;
import android.widget.CompoundButton;
import android.widget.TableRow;

import androidx.appcompat.widget.AppCompatCheckBox;

public class AppCompatCheckBoxUtils {

    public static AppCompatCheckBox attachListenerToCheckBox(AppCompatCheckBox appCompatCheckBox, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        appCompatCheckBox.setOnCheckedChangeListener(onCheckedChangeListener);
        return appCompatCheckBox;
    }

    private static AppCompatCheckBox generateCheckedCheckBox(Context context) {
        AppCompatCheckBox appCompatCheckBox = new AppCompatCheckBox(context);
        appCompatCheckBox.setChecked(true);
        return appCompatCheckBox;
    }

    private static AppCompatCheckBox generateCheckedCustomDrawableCheckBox(Context context, int drawable) {
        AppCompatCheckBox appCompatCheckBox = generateCheckedCheckBox(context);
        appCompatCheckBox.setButtonDrawable(drawable);
        return appCompatCheckBox;
    }

    public static AppCompatCheckBox generateCheckedCustomDrawableTableRowRightAlignedCheckBox(Context context, int drawable) {
        AppCompatCheckBox appCompatCheckBox = generateCheckedCustomDrawableCheckBox(context, drawable);
        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.MATCH_PARENT);
        layoutParams.gravity = Gravity.END;
        appCompatCheckBox.setLayoutParams(layoutParams);
        return appCompatCheckBox;
    }

    private AppCompatCheckBox generateCheckedCustomDrawableTableRowRightAlignedCheckBoxWithListener(Context context, int drawable, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {

        AppCompatCheckBox appCompatCheckBox = generateCheckedCustomDrawableTableRowRightAlignedCheckBox(context, drawable);
        appCompatCheckBox.setOnCheckedChangeListener(onCheckedChangeListener);
        return appCompatCheckBox;
    }
}
