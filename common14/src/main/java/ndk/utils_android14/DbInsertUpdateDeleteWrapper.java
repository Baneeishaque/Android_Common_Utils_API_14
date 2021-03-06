package ndk.utils_android14;

import android.content.Context;
import android.view.View;

import org.apache.http.NameValuePair;

import java.util.ArrayList;

import ndk.utils_android1.NetworkUtils1;
import ndk.utils_android1.ProgressBarUtils1;
import ndk.utils_android1.ToastUtils1;

public class DbInsertUpdateDeleteWrapper {

    public static void executeDbInsertUpdateDeletePostWithParameters(String taskURL, ArrayList<NameValuePair> parameters, Context context, View progressBar, View view, String applicationName, HttpApiSelectTask14.AsyncResponseJSONObject asyncResponseJsonObject) {

        if (NetworkUtils1.isOnline(context)) {

            ProgressBarUtils1.showProgress(true, context, progressBar, view);

            DbInsertUpdateDelete dbInsertUpdateDelete = new DbInsertUpdateDelete(taskURL, parameters, context, progressBar, view, applicationName, asyncResponseJsonObject);
            dbInsertUpdateDelete.execute();

        } else {

            ToastUtils1.longToast(context, "Internet is unavailable...");
        }
    }

    public static void executeDbInsertUpdateDeletePostWithParameters(String taskURL, ArrayList<NameValuePair> parameters, Context context, View progressBar, View view, String applicationName, HttpApiSelectTask14.AsyncResponseJSONArray asyncResponseJsonArray) {

        if (NetworkUtils1.isOnline(context)) {

            ProgressBarUtils1.showProgress(true, context, progressBar, view);

            DbInsertUpdateDelete dbInsertUpdateDelete = new DbInsertUpdateDelete(taskURL, parameters, context, progressBar, view, applicationName, asyncResponseJsonArray);
            dbInsertUpdateDelete.execute();

        } else {

            ToastUtils1.longToast(context, "Internet is unavailable...");
        }
    }

    public static void executeDbInsertUpdateDeletePostWithParameters(String taskURL, ArrayList<NameValuePair> parameters, Context context, View progressBar, View view, String applicationName, HttpApiSelectTask14.AsyncResponse asyncResponse) {

        if (NetworkUtils1.isOnline(context)) {

            ProgressBarUtils1.showProgress(true, context, progressBar, view);

            DbInsertUpdateDelete dbInsertUpdateDelete = new DbInsertUpdateDelete(taskURL, parameters, context, progressBar, view, applicationName, asyncResponse);
            dbInsertUpdateDelete.execute();

        } else {

            ToastUtils1.longToast(context, "Internet is unavailable...");
        }
    }
}
