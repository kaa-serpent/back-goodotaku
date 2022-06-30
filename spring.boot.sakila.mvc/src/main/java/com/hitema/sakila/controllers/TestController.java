package com.hitema.sakila.controllers;

import com.hitema.sakila.Http.HttpGetRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8082")
@RestController
public class TestController {
    private static final Logger log = LoggerFactory.getLogger(WelcomeController.class);

    @RequestMapping("/test")
    public ModelAndView anime(HttpSession session) throws IOException, JSONException
    {
        @SuppressWarnings("unchecked")
        List<String> messages = (List<String>) session.getAttribute("MY_SESSION_MESSAGES");

        if (messages == null)
        {
            messages = new ArrayList<>();
        }

        for(String s : messages)
        {
            System.out.println(s);
        }

        ArrayList<Object> animus = new ArrayList<>();

        String url = "https://kitsu.io/api/edge/anime";
        int j = 0;
        do
        {
            HttpGetRequest hgr = new HttpGetRequest(url);
            String result = hgr.makeHttpRequest();
            JSONObject o = new JSONObject(result);
            JSONArray data = o.getJSONArray("data");

            for(int i = 0; i < data.length(); i++)
            {
                JSONObject oo = data.getJSONObject(i);
                animus.add(oo);
            }

            JSONObject links = o.getJSONObject("links");

            url = links.getString("next");
        } while(++j < 1);

        ModelAndView mv = new ModelAndView("actors");
        mv.addObject("animus", animus);
        return mv;
    }
    @RequestMapping("/animu/{id}")
    public ModelAndView animu(@PathVariable("id") long id) throws IOException, JSONException
    {
        ArrayList<Object> genres = new ArrayList<>();
        ArrayList<Object> reviews = new ArrayList<>();
        ArrayList<Object> episodes = new ArrayList<>();


        String url = "https://kitsu.io/api/edge/anime/" + id;
        HttpGetRequest hgr = new HttpGetRequest(url);
        String result = hgr.makeHttpRequest();
        JSONObject o = new JSONObject(result);

        JSONObject anime = o.getJSONObject("data");

        url = "https://kitsu.io/api/edge/anime/" + id + "/genres";
        hgr = new HttpGetRequest(url);
        result = hgr.makeHttpRequest();
        o = new JSONObject(result);
        JSONArray gen = o.getJSONArray("data");

        for(int i = 0; i < gen.length(); i++)
        {
            genres.add(gen.getJSONObject(i));
        }

        url = "https://kitsu.io/api/edge/anime/" + id + "/reviews";
        hgr = new HttpGetRequest(url);
        result = hgr.makeHttpRequest();
        o = new JSONObject(result);
        JSONArray rev = o.getJSONArray("data");

        for(int i = 0; i < rev.length(); i++)
        {
            reviews.add(rev.getJSONObject(i));
        }

        url = "https://kitsu.io/api/edge/anime/" + id + "/episodes";
        hgr = new HttpGetRequest(url);
        result = hgr.makeHttpRequest();
        o = new JSONObject(result);
        JSONArray eps = o.getJSONArray("data");

        for(int i = 0; i < eps.length(); i++)
        {
            episodes.add(eps.getJSONObject(i));
        }

        ModelAndView mv = new ModelAndView("animu");
        mv.addObject("anime", anime);
        mv.addObject("genres", genres);
        mv.addObject("reviews", reviews);
        mv.addObject("episodes", episodes);

        return mv;
    }
    @RequestMapping("/animu/delete/{id}")
    public ModelAndView deleteAnime(@PathVariable("id") long id) throws IOException, JSONException
    {
        ArrayList<Object> genres = new ArrayList<>();

        String url = "https://kitsu.io/api/edge/anime/" + id;
        HttpGetRequest hgr = new HttpGetRequest(url);
        String result = hgr.makeHttpRequest();
        JSONObject o = new JSONObject(result);

        JSONObject anime = o.getJSONObject("data");

        url = "https://kitsu.io/api/edge/anime/" + id + "/genres";
        hgr = new HttpGetRequest(url);
        result = hgr.makeHttpRequest();
        o = new JSONObject(result);
        JSONArray gen = o.getJSONArray("data");

        for(int i = 0; i < gen.length(); i++)
        {
            genres.add(gen.getJSONObject(i));
        }

        ModelAndView mv = new ModelAndView("animu");
        mv.addObject("anime", anime);
        mv.addObject("genres", genres);
        return mv;
    }
}