package entities;

import android.media.Image;

import java.net.URL;

/**
 * Created by domicile on 20/02/2017.
 */

public class Music {

    private String name;
    private Image cover;
    private int rating;
    private String token;

    public Music(String ytLink){
        this.token = ytLink;
    }

    public Music(String name, int rating, String ytLink){
        this.name = name;
        this.rating = rating;
        this.token = ytLink;
    }
}
