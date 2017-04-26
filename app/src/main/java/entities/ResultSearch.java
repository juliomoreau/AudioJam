package entities;



import com.google.api.services.youtube.model.Thumbnail;

/**
 * Created by Jules on 16/04/2017.
 */

public class ResultSearch {

    public String videoName,videoImg,videoId;
    Thumbnail thumbnail;

    public ResultSearch(String videoName, String videoImg, String videoId, Thumbnail thumbnail){
        this.videoImg=videoImg;
        this.videoName=videoName;
        this.videoId=videoId;
        this.thumbnail=thumbnail;
    }


    public String getVideoId() {
        return videoId;
    }

    public String getVideoName() {
        return videoName;
    }

    public String getVideoImg() {
        return videoImg;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }
}
