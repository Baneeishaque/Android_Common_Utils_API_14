package ndk.utils_android14;

import androidx.core.util.Pair;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;

import ndk.utils_android1.StringUtils1;

public class HttpPostUtils14 {

    public static ArrayList<NameValuePair> generateHttpPostParameters(Pair[] parameterPairs) {

        ArrayList<NameValuePair> parameters = new ArrayList<>(parameterPairs.length);

        for (Pair parameterPair : parameterPairs) {

            parameters.add(new BasicNameValuePair(parameterPair.first != null ? parameterPair.first.toString() : null, parameterPair.second != null ? parameterPair.second.toString() : null));
        }

        return parameters;
    }

    public static String toStringOnNameValuePairs(Pair[] nameValuePairs) {

        return "Parameters : " + toStringOnStringPairs(nameValuePairs);
    }

    public static String toStringOnStringPairs(Pair[] parameterPairs) {

        StringBuilder result = new StringBuilder();
        for (Pair parameterPair : parameterPairs) {

            result.append(parameterPair.first != null ? parameterPair.first.toString() : "").append(" : ").append(parameterPair.second != null ? parameterPair.second.toString() : "").append(", ");
        }
        return StringUtils1.removeLast2Characters(result.toString());
    }
}
