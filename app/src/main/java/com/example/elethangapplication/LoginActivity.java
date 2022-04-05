package com.example.elethangapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import com.example.elethangapplication.cat.Cat;
import com.example.elethangapplication.cat.CatFragment;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.Arrays;

public class LoginActivity extends AppCompatActivity {

    //otthon gép
    //private String url = "http://192.168.0.48:8000/login";
    //private String url = "http://10.0.2.2:8000/login";
    private String url = "http://10.0.2.2:8000/api/dogAdoption";
    private String body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        RequestTask task = new RequestTask();
        task.execute();
    }

    private class RequestTask extends AsyncTask<Void, Void, Response> {
        @Override
        protected Response doInBackground(Void... voids) {
            body = "{\n" +
                    "    \"adoption_type_id\" : 1,\n" +
                    "    \"user_id\": 2,\n" +
                    "    \"dog_id\": 17\n" +
                    "}";
            Response response = null;
            try {
                response = RequestHandler.post(url, body);
                Response finalResponse = response;
                runOnUiThread(()->{
                    Toast.makeText(LoginActivity.this, finalResponse.getContent(), Toast.LENGTH_SHORT).show();
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
            return response;
        }

        @Override
        protected void onPostExecute(Response response) {
            super.onPostExecute(response);
            if (response != null) {


            }
        }
    }
}