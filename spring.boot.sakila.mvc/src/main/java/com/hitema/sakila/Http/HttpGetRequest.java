/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hitema.sakila.Http;

/**
 *
 * class HttpGetRequest for recup data with url api on parameter
 */
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class HttpGetRequest extends HttpRequest
{
    public HttpGetRequest(String url)
    {
        super(url);
    }

    public String makeHttpRequest()
    {
        String text = "";
        HttpURLConnection urlConnection = null;

        try
        {
            URL urlToRequest = new URL(this.getUrl());
            urlConnection = (HttpURLConnection) urlToRequest.openConnection();
            urlConnection.setRequestMethod("GET");
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());

            this.setResponseCode(urlConnection.getResponseCode());
            text = new Scanner(in).useDelimiter("\\A").next();
        }
        catch (Exception e)
        {
            text = "";
        }
        finally
        {
            if(urlConnection != null) urlConnection.disconnect();
        }

        return text;
    }
}