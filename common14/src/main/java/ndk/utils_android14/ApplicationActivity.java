package ndk.utils_android14;

import android.content.Context;

import ndk.utils_android1.LogUtilsWrapper;

public abstract class ApplicationActivity extends ActivityWithContexts {

    public class ApplicationLogUtils extends LogUtilsWrapper {

        @Override
        public String configureTAG() {

            return configureApplicationTag();
        }

        @Override
        public Context configureCurrentApplicationContext() {

            return currentApplicationContext;
        }
    }

    public abstract String configureApplicationTag();

    public ApplicationLogUtils applicationLogUtils = new ApplicationLogUtils();
}
