package ndk.utils_android14;

public class LogUtilsWrapperBase {

    private static String tag;

    public LogUtilsWrapperBase(String tag) {

        LogUtilsWrapperBase.tag = tag;
    }

    public static void debug(String message) {
        LogUtils.debug(tag, message);
    }
}
