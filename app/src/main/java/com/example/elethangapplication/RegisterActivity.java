package com.example.elethangapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

public class RegisterActivity extends AppCompatActivity {

    private EditText editName,editUsername,editemail,editpsw;
    private Button registerButton;
    private String name, username, email, password;

    private String url = "http://10.148.149.190:8000/api/register";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = editName.getText().toString().trim();
                username = editUsername.getText().toString().trim();
                email = editemail.getText().toString();
                password = editpsw.getText().toString();
                if (name.isEmpty() ){
                    Toast.makeText(RegisterActivity.this, "Név megadása kötelező ", Toast.LENGTH_SHORT).show();
                }else if (name.length() >255){
                    Toast.makeText(RegisterActivity.this, "Nem lehet több mint 255 karakter", Toast.LENGTH_SHORT).show();
                }else if (username.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Felhasználónév megadása kötelező", Toast.LENGTH_SHORT).show();
                }else if (username.length() > 255){
                    Toast.makeText(RegisterActivity.this, "Nem lehet több mint 255 karakter", Toast.LENGTH_SHORT).show();
                }else if (email.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Email megadása kötelező", Toast.LENGTH_SHORT).show();
                }else if (password.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Jelszó megadása kötelező", Toast.LENGTH_SHORT).show();
                }else if (password.length() <8 || password.length() >30){
                    Toast.makeText(RegisterActivity.this, "Jelszó minimum 8, maximum 30 karekter", Toast.LENGTH_SHORT).show();
                }else {
                    new RequestTask().execute();
                }
            }
        });
    }
    public void init(){
        editName = findViewById(R.id.editName);
        editUsername = findViewById(R.id.editRegisterUsername);
        editemail = findViewById(R.id.editemail);
        editpsw = findViewById(R.id.editpsw);
        registerButton = findViewById(R.id.registerButton);
    }
    private class RequestTask extends AsyncTask<Void, Void, Response> {

        @Override
        protected Response doInBackground(Void... voids) {

            Response response = null;
            try {
                String data = String.format("{\"name\":\"%s\",\"username\":\"%s\",\"email\":\"%s\",\"password\":\"%s\"}",name, username, email, password);
                response = RequestHandler.post(url, data);
            } catch (IOException e) {
                e.printStackTrace();
            }


            return response;
        }

        @Override
        protected void onPostExecute(Response response) {
            super.onPostExecute(response);
            if (response == null || response.getResponseCode() >= 400){
                Toast.makeText(RegisterActivity.this, "Hiba történt a regisztráció során", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(RegisterActivity.this, "Sikeres regisztráció!", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }

        }
    }
}