package com.chrismyers.trustkitsampleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.datatheorem.android.trustkit.TrustKit;

import java.util.UUID;

import javax.net.ssl.SSLHandshakeException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TrustKit.initializeWithNetworkSecurityConfiguration(this);
    }

    public void RunCheck(View view) {
        EditText input = findViewById(R.id.editUsername);
        String inputValue = input.getText().toString();
        String fakeSecureValue = UUID.randomUUID().toString();
        String url = "https://api.github.com/users/" + inputValue + "?secureValue=" + fakeSecureValue;
        new GitHubAsyncCall().execute(url);
    }

    protected void HandleResponse(String result) {
        ((TextView)findViewById(R.id.txtResult)).setText(result);
    }

    public class GitHubAsyncCall extends GithubApiRepository {
        @Override
        protected void onPostExecute(Boolean isValid) {
            super.onPostExecute(isValid);

            if (this._exception != null && this._exception.getClass() == SSLHandshakeException.class) {
                HandleResponse("SSL pinning validation error occurred!");
            } else if (this._exception != null) {
                HandleResponse("Error occurred calling API!");
            } else {
                HandleResponse(isValid ? "Valid user found" : "No valid user found!");
            }

        }
    }


}
