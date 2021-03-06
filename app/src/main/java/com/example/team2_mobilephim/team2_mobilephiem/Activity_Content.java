package com.example.team2_mobilephim.team2_mobilephiem;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.TabHost;
import android.widget.VideoView;

public class Activity_Content extends AppCompatActivity {
    TabHost tabhost;
    VideoView vview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        TabHost host = (TabHost) findViewById(R.id.tabHost);
        try {
            String link = getIntent().getStringExtra("urls");
            vview = (VideoView) findViewById(R.id.videoView);
            MediaController mediaController = new MediaController(this);
            mediaController.setAnchorView(vview);
            Uri video = Uri.parse(link);
            vview.setMediaController(mediaController);
            vview.setVideoURI(video);
            vview.start();
        }catch (Exception e){
            e.printStackTrace();
        }

        host.setup();

        TabHost.TabSpec tab1 = host.newTabSpec("Information");
        tab1.setContent(R.id.tab1);
        tab1.setIndicator("Information");
        host.addTab(tab1);
        
        tab1 = host.newTabSpec("Server");
        tab1.setContent(R.id.tab2);
        tab1.setIndicator("Server");
        host.addTab(tab1);
    }
}
