package ndk.utils_android14;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;

import ndk.utils_android1.ApplicationSpecificationWrapper1;
import ndk.utils_android1.LogUtilsWrapper1;
import ndk.utils_android1.SharedPreferencesUtils1;

public abstract class ApplicationActivity14 extends ActivityWithContexts14 {

    public SharedPreferences applicationSharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        applicationSharedPreferences = SharedPreferencesUtils1.getSharedPreferences(currentApplicationContext, configureCurrentApplicationName());
    }

    public class ApplicationLogUtils extends LogUtilsWrapper1 {

        @Override
        public String configureApplicationTag() {

            return configureCurrentApplicationName();
        }

        @Override
        public Context configureCurrentApplicationContext() {

            return currentApplicationContext;
        }
    }

    public ApplicationLogUtils applicationLogUtils = new ApplicationLogUtils();

    public class ApplicationSpecification extends ApplicationSpecificationWrapper1 {

        @Override
        public String configureApplicationName() {

            return configureCurrentApplicationName();
        }
    }

    public ApplicationSpecification applicationSpecification = new ApplicationSpecification();

    public abstract String configureCurrentApplicationName();
}
