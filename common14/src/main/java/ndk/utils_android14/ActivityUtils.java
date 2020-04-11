package ndk.utils_android14;

import android.content.Context;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;

import com.github.kimkevin.cachepot.CachePot;

import java.util.Objects;

public class ActivityUtils extends ndk.utils_android1.ActivityUtils {

    public static void startActivityWithFinish(Context activityContext, Class activity) {
        startActivity(activityContext, activity);
        ((AppCompatActivity) activityContext).finish();
    }

    public static void startActivityWithFinish(Context activityContext, Intent intent) {
        startActivity(activityContext, intent);
        ((AppCompatActivity) activityContext).finish();
    }

    public static Intent getIntentWithStringExtras(Context context, Class activity, Pair[] extras) {
        Intent intent = new Intent(context, activity);
        if (extras.length != 0) {
            for (Pair extra : extras) {
                intent.putExtra(extra.first != null ? extra.first.toString() : null, extra.second != null ? extra.second.toString() : null);
            }
        }
        return intent;
    }

    public static void startActivityWithStringExtras(Context activityContext, Class activity, Pair[] extras) {
        startActivity(activityContext, getIntentWithStringExtras(activityContext, activity, extras));
    }

    public static void startActivityForResultWithStringExtras(Context activityContext, Class activity, Pair[] extras, int request_code) {
        ((AppCompatActivity) activityContext).startActivityForResult(getIntentWithStringExtras(activityContext, activity, extras), request_code);
    }

    public static Intent getIntentWithIntegerExtras(Context context, Class activity, Pair[] extras) {
        Intent intent = new Intent(context, activity);
        if (extras.length != 0) {
            for (Pair extra : extras) {
                intent.putExtra(extra.first != null ? extra.first.toString() : null, Integer.parseInt(Objects.requireNonNull(extra.second != null ? extra.second.toString() : null)));
            }
        }
        return intent;
    }

    public static void startActivityWithIntegerExtras(Context activityContext, Class activity, Pair[] extras) {
        startActivity(activityContext, getIntentWithIntegerExtras(activityContext, activity, extras));
    }

    public static void startActivityWithIntegerExtrasAndFinish(Context activityContext, Class activity, Pair[] extras) {
        startActivityWithFinish(activityContext, getIntentWithIntegerExtras(activityContext, activity, extras));
    }

    public static void startActivityWithFinishAndTabIndex(Context activityContext, Class activity, int tabIndex) {
        startActivityWithFinish(activityContext, getIntentWithIntegerExtras(activityContext, activity, new Pair[]{new Pair<>("tab_index", tabIndex)}));
    }

    public static void startActivityWithObjectPushAndFinish(Context activityContext, Class activity, Object objectToPush) {
        CachePot.getInstance().push(objectToPush);
        startActivityWithFinish(activityContext, activity);
    }

    public static void startActivityWithObjectPush(Context activityContext, Class activity, Object objectToPush) {
        CachePot.getInstance().push(objectToPush);
        startActivity(activityContext, activity);
    }

    public static void startActivityWithObjectPushAndIntegerExtras(Context activityContext, Class activity, Pair[] extras, Object objectToPush) {
        CachePot.getInstance().push(objectToPush);
        startActivity(activityContext, getIntentWithIntegerExtras(activityContext, activity, extras));
    }

    public static void startActivityWithObjectPushAndIntegerExtrasAndFinish(Context activityContext, Class activity, Pair[] extras, Object objectToPush) {
        CachePot.getInstance().push(objectToPush);
        startActivityWithFinish(activityContext, getIntentWithIntegerExtras(activityContext, activity, extras));
    }

    public static void startActivityWithObjectPushAndOrigin(Context activityContext, Class activity, Object objectToPush, String origin) {
        CachePot.getInstance().push(objectToPush);
        startActivity(activityContext, getIntentWithStringExtras(activityContext, activity, new Pair[]{new Pair<>("origin", origin)}));
    }

    public static void startActivityWithObjectPushAndFinishAndOrigin(Context activityContext, Class activity, Object objectToPush, String origin) {
        startActivityWithObjectPushAndOrigin(activityContext, activity, objectToPush, origin);
        ((AppCompatActivity) activityContext).finish();
    }

    public static void startActivityWithStringExtrasAndFinish(Context context, Class activity, Pair[] extras) {
        startActivityWithFinish(context, getIntentWithStringExtras(context, activity, extras));
    }
}