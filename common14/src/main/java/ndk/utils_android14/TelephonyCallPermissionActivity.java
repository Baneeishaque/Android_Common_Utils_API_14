package ndk.utils_android14;

import android.Manifest;

public abstract class TelephonyCallPermissionActivity extends PermissionActivity {

    private static final int CALL_PERMISSION_REQUEST_CODE = 1;

    @Override
    public String configurePermissionRequiredMessage() {

        return getString(R.string.call_permission_required);
    }

    @Override
    public String configurePermission() {

        return Manifest.permission.CALL_PHONE;
    }

    @Override
    public int configurePermissionRequestCode() {

        return CALL_PERMISSION_REQUEST_CODE;
    }
}
