package ndk.utils_android14;

import android.content.Context;

import ndk.utils_android1.ApplicationSpecificationWrapper1;
import ndk.utils_android1.LogUtilsWrapper1;

public abstract class ApplicationActivity14 extends ActivityWithContexts14 {

    public class ApplicationLogUtils extends LogUtilsWrapper1 {

        @Override
        public String configureTAG() {

            return configureApplicationTag();
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

            return configureApplicationTag();
        }
    }

    public ApplicationSpecification applicationSpecification = new ApplicationSpecification();

    public abstract String configureApplicationTag();
}
