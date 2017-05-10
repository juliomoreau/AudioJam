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

    public Music(String ytLink){
        this.urltoken = ytLink;
    }

    public Music(String name, int rating, String ytLink){
        this.name = name;
        this.score = rating;
        this.urltoken = ytLink;
    }
    public Music(){};
    public Image getCover() {
        return cover;
    }

    public void setCover(Image cover) {
        this.cover = cover;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrltoken() {
        return urltoken;
    }

    public void setUrltoken(String urltoken) {
        this.urltoken = urltoken;
    }
}