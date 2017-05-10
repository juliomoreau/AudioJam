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

    public String name;
    public String token;
    public boolean visibility;
    public String pathtoimage;
    public List<Music> musicList;
    public List<String> modList;

    public Playlist(){}

    public Playlist(String name, String pathtoimage, boolean visibility, String userID){

        //TODO: once addjoinplaylistactivity done take these creators out and insert the parameters in the constructor
        //TODO: find value to insert as first music or none if possible
        List<String> modlist = new ArrayList<>();
        modlist.add(userID);
        List<Music> musiclist = new ArrayList<>();
        musiclist.add(new Music("Name of song", 0, "tokenvalue"));

        this.name=name;
        this.pathtoimage=pathtoimage;
        this.visibility=visibility;
        this.modList= modlist;
        this.musicList=musiclist;
    }

    public void addMod(String userID){
        this.modList.add(userID);
    }

    public void addMusic(Music music){
        this.musicList.add(music);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    public String getPathtoimage() {
        return pathtoimage;
    }

    public void setPathtoimage(String pathtoimage) {
        this.pathtoimage = pathtoimage;
    }

    public List<Music> getMusicList() {
        return musicList;
    }

    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
    }

    public List<String> getModList() {
        return modList;
    }

    public void setModList(List<String> modList) {
        this.modList = modList;
    }
}
