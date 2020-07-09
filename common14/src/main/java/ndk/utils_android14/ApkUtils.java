package ndk.utils_android14;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class ApkUtils {

    public static void deleteApkPackage(Context context) {

        Uri packageUri = Uri.parse("package:" + context.getPackageName());
        Intent uninstallIntent = new Intent(Intent.ACTION_UNINSTALL_PACKAGE, packageUri);
        context.startActivity(uninstallIntent);
    }
}
