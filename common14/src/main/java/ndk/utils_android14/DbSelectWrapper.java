package ndk.utils_android14;

import android.content.Context;
import android.view.View;

import ndk.utils_android1.NetworkUtils1;
import ndk.utils_android1.ProgressBarUtils1;
import ndk.utils_android1.ToastUtils1;

public class DbSelectWrapper {

    public static void executeDbSelectHttpGet(String taskURL, Context context, View progressBar, View view, String applicationName, HttpApiSelectTask3.AsyncResponseJSONArray asyncResponseJsonArray) {

        executeDbSelectHttpGet(context, progressBar, view, new DbSelect(taskURL, context, progressBar, view, applicationName, asyncResponseJsonArray));
    }

    public static void executeDbSelectHttpGet(String taskURL, Context context, View progressBar, View view, String applicationName, HttpApiSelectTask3.AsyncResponseJSONObject asyncResponseJsonObject) {

        executeDbSelectHttpGet(context, progressBar, view, new DbSelect(taskURL, context, progressBar, view, applicationName, asyncResponseJsonObject));
    }

    public static void executeDbSelectHttpGet(Context context, View progressBar, View view, DbSelect dbSelect) {

        if (NetworkUtils1.isOnline(context)) {

            ProgressBarUtils1.showProgress(true, context, progressBar, view);
            dbSelect.execute();

        } else {

            ToastUtils1.longToast(context, "Internet is unavailable...");
        }
    }
}
