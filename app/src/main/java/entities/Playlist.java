package entities;

import java.util.List;
import java.util.Map;

/**
 * Created by domicile on 14/03/2017.
 */

public class Playlist {

    private String name;
    private boolean visibility;
    private String pathtoimage;
    private Map<String, Integer> musicList;
    private List<String> modList;


    public Playlist(){}

    public Playlist(String name, String pathtoimage, boolean visibility){
        this.name=name;
        this.pathtoimage=pathtoimage;
        this.visibility=visibility;
    }
}
