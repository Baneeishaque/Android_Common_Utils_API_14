package ndk.utils_android14;

public abstract class LogUtilsWrapperBase {

    public void debug(String message) {
        LogUtils.debug(configureTag(), message, configureIsDebug());
    }

    abstract boolean configureIsDebug();

    abstract String configureTag();
}
