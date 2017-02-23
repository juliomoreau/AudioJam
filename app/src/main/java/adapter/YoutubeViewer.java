package adapter;

import android.content.Context;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubePlayerView;

/**
 * Created by domicile on 19/02/2017.
 */

public class YoutubeViewer extends YouTubeBaseActivity{

    YouTubePlayerView YTView = new YouTubePlayerView(getBaseContext());
}