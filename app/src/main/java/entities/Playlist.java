package entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by domicile on 14/03/2017.
 */

public class Playlist {

    //TODO: create the missing properties (1-String path-to-image) and add to constructors

    private String name;
    private boolean visibility;
    private String pathtoimage;
    private Map<String, Integer> musicList;
    private List<String> modList;


    public Playlist(){}

    public Playlist(String name, String pathtoimage, boolean visibility){

        //TODO: once addjoinplaylistactivity done take these creators out and insert the parameters in the constructor
        List<String> modlist = new ArrayList<>();
        modlist.add("CREATOR ID HERE");
        Map<String, Integer> musiclist = new HashMap<>();
        musiclist.put("No song", 1);

        this.name=name;
        this.pathtoimage=pathtoimage;
        this.visibility=visibility;
        this.modList= modlist;
        this.musicList=musiclist;
    }
}
