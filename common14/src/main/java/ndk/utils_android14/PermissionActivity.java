package ndk.utils_android14;

import android.content.pm.PackageManager;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import ndk.utils_android1.PermissionAcceptedActions;
import ndk.utils_android1.PermissionDeniedActions;
import ndk.utils_android1.PermissionGrantedActions;

public abstract class PermissionActivity extends ActivityWithContexts {

    PermissionAcceptedActions permissionAcceptedActions;
    PermissionDeniedActions permissionDeniedActions;

    public void getRuntimePermission(PermissionGrantedActions permissionGrantedActions, PermissionAcceptedActions permissionAcceptedActions, PermissionDeniedActions permissionDeniedActions) {

        this.permissionAcceptedActions = permissionAcceptedActions;
        this.permissionDeniedActions = permissionDeniedActions;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            {
                if (ContextCompat.checkSelfPermission(currentActivityContext, configurePermission()) != PackageManager.PERMISSION_GRANTED) {

                    if (shouldShowRequestPermissionRationale(configurePermission())) {

                        Toast.makeText(this, configurePermissionRequiredMessage(), Toast.LENGTH_LONG).show();

                    } else {

                        Toast.makeText(this, configurePermissionRequiredMessage(), Toast.LENGTH_SHORT).show();
                    }

                    ActivityCompat.requestPermissions((AppCompatActivity) currentActivityContext, new String[]{configurePermission()}, configurePermissionRequestCode());

                } else {

                    permissionGrantedActions.configurePermissionGrantedActions();
                }
            }

        } else {

            permissionGrantedActions.configurePermissionGrantedActions();
        }
    }

    public abstract String configurePermissionRequiredMessage();

    public abstract String configurePermission();

    public abstract int configurePermissionRequestCode();

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == configurePermissionRequestCode()) {

            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                permissionAcceptedActions.configurePermissionAcceptedActions();

            } else {

                permissionDeniedActions.configurePermissionDeniedActions();
            }
        }
    }
}
