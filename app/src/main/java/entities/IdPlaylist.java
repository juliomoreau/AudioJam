package entities;

import java.util.List;

/**
 * Created by domicile on 26/04/2017.
 */

public class IdPlaylist {


    private List<String> token;

    public IdPlaylist() {
    }

    public IdPlaylist(List<String> token) {
        this.token = token;
    }

    public List<String> getToken() {
        return this.token;
    }

    public void setToken(List<String> token) {
        this.token = token;
    }
}
