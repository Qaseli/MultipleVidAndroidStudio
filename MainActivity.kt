package com.example.multiplevideo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Audio.Media
import androidx.recyclerview.widget.LinearLayoutManager
import edmt.dev.videoplayer.utils.VerticalSpacingItemDecorator
import kotlinx.android.synthetic.main.activity_main.*
import java.util.Arrays

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initVideos();

    }
    private fun initVideos(){
        val layoutManager = LinearLayoutManager (this);
        video_player.layoutManager = layoutManager;
        val verticalItemDecor = VerticalSpacingItemDecorator(10)
        video_player.addItemDeciration(verticalItemDecor)

        val sourceVideos : ArrayList<MediaObject> = ArrayList(sampleVideoList())
        video_player.setMediaObject(sourceVideos)
        val adapter = VideoPlayerRecyclerAdapter(sourceVideos,initGlide())
        video_player.adapter = adapter

    }
    private fun initGlide(): RequestManager?{
        val options = RequestOptions()
            .placeholder(R.drawable.white_background)
            .error(R.drawable.white_background)
        return  Glide.with(this).setDefaultRequestOptions(options)
    }

    private fun  sampleVideoList(): List<MediaObject>? {
        return ListOf(
                MediaObject("Big Buck Bunny",
                    "https://commomdatastorage-googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
                    "https://i.ytimg.com/vi/aqz-KR-bpKQ/maxresdefault.jpg",
                    "")
        )
    };

}
