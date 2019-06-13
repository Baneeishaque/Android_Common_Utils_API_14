package ndk.utils_android14;

import android.content.pm.PackageManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public abstract class PermissionActivity extends ContextActivity {

    PermissionAcceptedActions permissionAcceptedActions;
    PermissionDeniedActions permissionDeniedActions;

    public void getRuntimePermission(PermissionGrantedActions permissionGrantedActions, PermissionAcceptedActions permissionAcceptedActions, PermissionDeniedActions permissionDeniedActions) {
        this.permissionAcceptedActions = permissionAcceptedActions;
        this.permissionDeniedActions = permissionDeniedActions;
        if (ContextCompat.checkSelfPermission(activityContext, configurePermission()) != 0) {
            ActivityCompat.requestPermissions((AppCompatActivity) activityContext, new String[]{configurePermission()}, configure_PERMISSION_REQUEST_CODE());
        } else {
            permissionGrantedActions.configurePermissionGrantedActions();
        }
    }

    protected abstract String configurePermission();

    protected abstract int configure_PERMISSION_REQUEST_CODE();

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == configure_PERMISSION_REQUEST_CODE()) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                permissionAcceptedActions.configurePermissionAcceptedActions();
            } else {
                permissionDeniedActions.configurePermissionDeniedActions();
            }
        }
    }
}
