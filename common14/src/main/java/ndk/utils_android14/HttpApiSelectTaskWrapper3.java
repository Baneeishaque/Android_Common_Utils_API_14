package ndk.utils_android14;

import android.content.Context;
import android.view.View;

import androidx.core.util.Pair;

import ndk.utils_android1.NetworkUtils1;
import ndk.utils_android1.ProgressBarUtils1;
import ndk.utils_android1.ToastUtils1;

public class HttpApiSelectTaskWrapper3 {

    public static void execute(String task_URL, Context context, View progressView, View loginFormView, String applicationName, Pair[] nameValuePairs, HttpApiSelectTask3.AsyncResponseJSONArray asyncResponseJSONArray) {

        if (NetworkUtils1.isOnline(context)) {

            ProgressBarUtils1.showProgress(true, context, progressView, loginFormView);
            new HttpApiSelectTask3(task_URL, context, progressView, loginFormView, applicationName, nameValuePairs, asyncResponseJSONArray).execute();

        } else {

            ToastUtils1.longToast(context, "Internet is unavailable...");
        }
    }
}
