package ndk.utils_android14;

import android.util.Log;

public class LogUtils {

    public static void debug(String tag, String message, boolean isDebug) {
        if (isDebug) {
            Log.d(tag, message);
        }
    }
}
