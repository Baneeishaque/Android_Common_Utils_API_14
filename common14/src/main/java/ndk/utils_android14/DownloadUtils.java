package ndk.utils_android14;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;

import java.io.File;

import ndk.utils_android1.ToastUtils;

public class DownloadUtils {
    public static void download_apk_to_downloads(String application_name, float version_name, String update_URL, final Context context, String TAG) {
        //get destination to update file and set Uri.
        //Download directory in external storage.
        String destination = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/";
        String fileName = application_name + "_" + version_name + ".apk";
        destination += fileName;
        final Uri uri = Uri.parse("file://" + destination);

        //Delete update file if exists
        File file = new File(destination);
        if (file.exists()) {
            if (!file.delete()) {
                ToastUtils.longToast(context, "Deletion failure, please clear your downloads...");
            }
        }

        //get url of app on server
        String url = update_URL;

        //set download manager
        Log.d(TAG, url);
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        request.setDescription("Downloading Update...");
        request.setTitle(application_name + " " + version_name);

        //set destination
        request.setDestinationUri(uri);

        // get download service and enqueue file
        final DownloadManager manager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        final long downloadId = manager.enqueue(request);

        //set BroadcastReceiver to install app when .apk is downloaded
        BroadcastReceiver onComplete = new BroadcastReceiver() {
            public void onReceive(Context ctxt, Intent intent) {
                InstallApk.installApk(uri, manager, downloadId, context, this);
            }
        };

        //register receiver for when .apk download is compete
        context.registerReceiver(onComplete, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
    }
}
