package ndk.utils_android14;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import ndk.utils_android1.ExceptionUtils1;
import ndk.utils_android1.HttpGet;
import ndk.utils_android1.LogUtilsWrapper1;
import ndk.utils_android1.NetworkUtils1;
import ndk.utils_android1.ProgressBarUtils1;
import ndk.utils_android1.ToastUtils1;

public class DbSelect extends AsyncTask<Void, Void, String[]> {

    private boolean isJsonObjectResponse;
    private boolean isJsonArrayResponse;
    private boolean isResponse;

    private boolean isForeGround = true;

    private boolean isSplashScreen;

    private boolean checkError;

    private TemporaryLogUtilsWrapper temporaryLogUtilsWrapper = new TemporaryLogUtilsWrapper();

    private String URL;
    private String TAG;

    private Context context;
    private View progressBar;
    private View form;

    private HttpApiSelectTask14.AsyncResponseJSONObject asyncResponseJsonObject = null;
    private HttpApiSelectTask14.AsyncResponseJSONArray asyncResponseJsonArray = null;
    private HttpApiSelectTask14.AsyncResponse asyncResponse = null;

    private boolean isProgressBarPresent = true;

    // Returns JSON object
    public DbSelect(String URL, Context context, View progressBar, View form, String TAG, HttpApiSelectTask14.AsyncResponseJSONObject asyncResponseJsonObject) {

        this.URL = URL;
        this.context = context;
        this.progressBar = progressBar;
        this.form = form;
        this.TAG = TAG;
        this.asyncResponseJsonObject = asyncResponseJsonObject;
        isResponse = false;
        isJsonObjectResponse = true;
    }

    // Get With Parameters - Returns JSON array
    public DbSelect(String URL, Context context, View progressBar, View form, String TAG, HttpApiSelectTask14.AsyncResponseJSONArray asyncResponseJsonArray) {

        this.URL = URL;
        this.context = context;
        this.progressBar = progressBar;
        this.form = form;
        this.TAG = TAG;
        this.asyncResponseJsonArray = asyncResponseJsonArray;
        isResponse = false;
        isJsonArrayResponse = true;
    }

    @Override
    protected String[] doInBackground(Void... params) {

        temporaryLogUtilsWrapper.debug("URL is " + URL);
        return HttpGet.perform(URL);
    }

    protected void onPostExecute(String[] networkActionResponseArray) {

        if (isProgressBarPresent) {

            ProgressBarUtils1.showProgress(false, context, progressBar, form);
        }

        temporaryLogUtilsWrapper.debug("Network Action status is " + networkActionResponseArray[0]);
        temporaryLogUtilsWrapper.debug("Network Action response is " + networkActionResponseArray[1]);

        if (isResponse) {

            if (networkActionResponseArray[0].equals("1")) {

                asyncResponse.processFinish("exception");
                informError(networkActionResponseArray[1]);

            } else {

                asyncResponse.processFinish(networkActionResponseArray[1]);
            }

        } else if (isJsonObjectResponse) {

            if (networkActionResponseArray[0].equals("1")) {

                informError(networkActionResponseArray[1]);

            } else {

                try {

                    asyncResponseJsonObject.processFinish(new JSONObject(networkActionResponseArray[1]));

                } catch (JSONException e) {

                    ExceptionUtils1.handleException(isForeGround, context, TAG, e);
                }
            }

        } else if (isJsonArrayResponse) {

            if (networkActionResponseArray[0].equals("1")) {

                informError(networkActionResponseArray[1]);

            } else {

                try {

                    JSONArray jsonArray = new JSONArray(networkActionResponseArray[1]);

                    if (checkError) {

                        if (jsonArray.getJSONObject(0).getString("status").equals("1")) {

                            if (isForeGround) {

                                ToastUtils1.longToast(context, "No Entries...");
                            }
                            temporaryLogUtilsWrapper.debug("No Entries...");

                        } else if (jsonArray.getJSONObject(0).getString("status").equals("0")) {

                            this.asyncResponseJsonArray.processFinish(jsonArray);
                        }
                    } else {

                        asyncResponseJsonArray.processFinish(jsonArray);
                    }
                } catch (JSONException e) {

                    ExceptionUtils1.handleException(isForeGround, context, TAG, e);
                }
            }
        }
    }

    private void informError(String error) {

        processNetworkError(error);
        handleSplashScreen();
    }

    private void handleSplashScreen() {

        if (isSplashScreen) {

            ((AppCompatActivity) context).finish();
        }
    }

    private void processNetworkError(String errorMessage) {

        if (isForeGround) {

            //TODO : Short Toast
            //TODO : Add more error scenarios
            //TODO : Feedback from below error toast

            NetworkUtils1.displayFriendlyExceptionMessage(context, errorMessage);
            ToastUtils1.longToast(context, "Error...");
        }

        temporaryLogUtilsWrapper.debug("Error...");
    }

    protected void onCancelled() {

        if (isProgressBarPresent) {

            ProgressBarUtils1.showProgress(false, this.context, this.progressBar, this.form);
        }
    }

    //    TODO : Implement as Interface with default methods
    class TemporaryLogUtilsWrapper extends LogUtilsWrapper1 {

        @Override
        public String configureApplicationTag() {
            return TAG;
        }

        @Override
        public Context configureCurrentApplicationContext() {

            return context;
        }
    }
}
