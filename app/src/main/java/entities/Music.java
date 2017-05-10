package entities;

import android.media.Image;

import java.net.URL;

/**
 * Created by domicile on 20/02/2017.
 */

public class Music {

    private String name;
    private Image cover;
    private int score;
    private String urltoken;

    public Music(String urltoken){
        this.urltoken = urltoken;
    }

    public Music(String name, int score, String urltoken){
        this.name = name;
        this.score = score;
        this.urltoken = urltoken;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Image getCover() {
        return cover;
    }

    public void setCover(Image cover) {
        this.cover = cover;
    }

    public int getRating() {
        return score;
    }

    public void setRating(int rating) {
        this.score = rating;
    }

    public String getToken() {
        return urltoken;
    }

    public void setToken(String token) {
        this.urltoken = token;
    }
}
