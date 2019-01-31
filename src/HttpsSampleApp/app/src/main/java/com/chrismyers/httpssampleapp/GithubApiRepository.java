package com.chrismyers.httpssampleapp;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class GithubApiRepository extends AsyncTask<String, Void, Boolean> {
    protected Exception _exception;


    @Override
    protected Boolean doInBackground(String... urls) {
        HttpsURLConnection urlCon = null;
        try {
            URL url = new URL(urls[0]);

            urlCon = (HttpsURLConnection)url.openConnection();
            urlCon.setRequestProperty("Accept", "application/json");


            InputStream in = new BufferedInputStream(urlCon.getInputStream());
            String data = readStreamString(in);
            GithubUser user = (GithubUser)(new Gson().fromJson(data, GithubUser.class));
            return user.login != null && user.login.length() > 0;
        }
        catch (FileNotFoundException ex) {
            return false;
        }
        catch (Exception e) {
            this._exception = e;
            return false;
        } finally {
            if (urlCon != null)
                urlCon.disconnect();
        }
    }

    private String readStreamString(InputStream in) throws IOException {
        byte[] bArr = readAllBytes(in);
        return new String(bArr, "UTF8");
    }

    private byte[] readAllBytes(InputStream in) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();

        int nRead;
        byte[] data = new byte[16384];
        while ((nRead = in.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }

        return buffer.toByteArray();
    }
}
