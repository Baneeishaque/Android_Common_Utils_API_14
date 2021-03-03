package ndk.utils_android14;

import androidx.core.util.Pair;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;

public class HttpPostUtils {

    public static ArrayList<NameValuePair> generateHttpPostParameters(Pair[] parameterPairs) {
        ArrayList<NameValuePair> parameters = new ArrayList<>(parameterPairs.length);

        for (Pair parameterPair : parameterPairs) {
            parameters.add(new BasicNameValuePair(parameterPair.first != null ? parameterPair.first.toString() : null, parameterPair.second != null ? parameterPair.second.toString() : null));
        }

        return parameters;
    }
}
