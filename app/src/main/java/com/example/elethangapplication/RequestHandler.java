package com.example.elethangapplication;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;

public class RequestHandler {

    private RequestHandler(){}

    public static Response get(String url) throws IOException{
        HttpURLConnection conn = setupConnection(url);
        return getResponse(conn);
    }

    public static Response post(String url, String request) throws IOException{
        HttpURLConnection conn = setupConnection(url);
        return postResponse(conn,request);
    }

    private static HttpURLConnection setupConnection(String url) throws IOException{
        URL urlObj = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
        conn.setConnectTimeout(10000);
        conn.setReadTimeout(10000);
        return conn;
    }

    private static Response getResponse(HttpURLConnection conn) throws IOException{
        int responseCode = conn.getResponseCode();
        InputStream is;
        if (responseCode < 400){
            is = conn.getInputStream();
        } else {
            is = conn.getErrorStream();
        }
        StringBuilder builder = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String sor = br.readLine();
        while (sor != null){
            builder.append(sor);
            sor = br.readLine();
        }
        br.close();
        is.close();
        return new Response(responseCode, builder.toString());
    }

    private static Response postResponse(HttpURLConnection conn, String request) throws IOException{
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);//felkészül, hogy szeretne elküldeni valamit
        OutputStream outputStream = conn.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write(request);
        bw.flush();
        int responseCode = conn.getResponseCode();
        InputStream is;
        if (responseCode < 400){
            is = conn.getInputStream();
        } else {
            is = conn.getErrorStream();
        }
        StringBuilder builder = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String sor = br.readLine();
        while (sor != null){
            builder.append(sor);
            sor = br.readLine();
        }
        br.close();
        is.close();
        return new Response(responseCode, builder.toString());
    }

    public static Response postAuth(String url, String request, String token) throws IOException {
        HttpURLConnection conn = setupConnection(url);
        conn.setRequestProperty("Authorization", "Bearer " + token);
        return postResponse(conn,request);
    }
}
