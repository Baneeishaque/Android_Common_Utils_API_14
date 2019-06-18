package ndk.utils_android14;

public class LogUtilsWrapperBase {

    private static String tag;
    private static boolean isDebug;

    public LogUtilsWrapperBase(String tag, boolean isDebug) {
        LogUtilsWrapperBase.tag = tag;
        LogUtilsWrapperBase.isDebug = isDebug;
    }

    private static void debug(String message) {
        LogUtils.debug(tag, message, isDebug);
    }
}
