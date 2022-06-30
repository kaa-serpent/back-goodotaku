/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hitema.sakila.Http;

/**
 *
 * Class HttpRequest
 */
public class HttpRequest
{
    private String url;
    private int responseCode = 0;

    public HttpRequest(String url)
    {
        this.url = url;
    }

    public int getResponseCode()
    {
        return this.responseCode;
    }
    
    public void setResponseCode(int code) { this.responseCode = code; }
    public String getUrl() { return this.url; }
}
