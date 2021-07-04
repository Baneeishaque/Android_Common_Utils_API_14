package ndk.utils_android14;

import android.content.Context;
import android.view.View;

import androidx.core.util.Pair;

import ndk.utils_android1.NetworkUtils1;
import ndk.utils_android1.ProgressBarUtils1;
import ndk.utils_android1.ToastUtils1;

public class HttpApiSelectTaskWrapper14 {

    public static void executeNonSplashForegroundPostWithParametersAndStatusCheckOnAsyncResponseJsonArrayFirstElement(String task_URL, Pair[] nameValuePairs, Context context, View progressView, View loginFormView, String applicationName, HttpApiSelectTask14.AsyncResponseJSONArray asyncResponseJSONArray) {

        if (NetworkUtils1.isOnline(context)) {

            ProgressBarUtils1.showProgress(true, context, progressView, loginFormView);
            new HttpApiSelectTask14(task_URL, nameValuePairs, context, progressView, loginFormView, applicationName, asyncResponseJSONArray).execute();

        } else {

            ToastUtils1.longToast(context, "Internet is unavailable...");
        }
    }

    public static void executeNonSplashForegroundPostWithOutParametersAndStatusCheckOnAsyncResponseJsonArrayFirstElement(String task_URL, Context context, View progressView, View loginFormView, String applicationName, HttpApiSelectTask14.AsyncResponseJSONArray asyncResponseJSONArray) {

        if (NetworkUtils1.isOnline(context)) {

            ProgressBarUtils1.showProgress(true, context, progressView, loginFormView);
            new HttpApiSelectTask14(task_URL, context, progressView, loginFormView, applicationName, asyncResponseJSONArray).execute();

        } else {

            ToastUtils1.longToast(context, "Internet is unavailable...");
        }
    }


    public static void executeNonSplashForegroundPostWithParametersAndWithoutStatusCheckOnAsyncResponseJsonArrayFirstElement(String task_URL, Pair[] nameValuePairs, Context context, View progressView, View loginFormView, String applicationName, HttpApiSelectTask14.AsyncResponseJSONArray asyncResponseJSONArray) {

        if (NetworkUtils1.isOnline(context)) {

            ProgressBarUtils1.showProgress(true, context, progressView, loginFormView);
            new HttpApiSelectTask14(task_URL, nameValuePairs, context, progressView, loginFormView, applicationName, asyncResponseJSONArray, false).execute();

        } else {

            ToastUtils1.longToast(context, "Internet is unavailable...");
        }
    }

    public static void executeNonSplashForegroundPostWithParameters(String task_URL, Pair[] nameValuePairs, Context context, View progressView, View loginFormView, String applicationName, HttpApiSelectTask14.AsyncResponseJSONObject asyncResponseJSONObject) {

        if (NetworkUtils1.isOnline(context)) {

            ProgressBarUtils1.showProgress(true, context, progressView, loginFormView);
            new HttpApiSelectTask14(task_URL, nameValuePairs, context, progressView, loginFormView, applicationName, asyncResponseJSONObject).execute();

        } else {

            ToastUtils1.longToast(context, "Internet is unavailable...");
        }
    }
}
