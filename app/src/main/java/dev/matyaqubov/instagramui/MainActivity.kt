package dev.matyaqubov.instagramui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.matyaqubov.instagramui.adapter.FeedAdapter
import dev.matyaqubov.instagramui.model.Feed
import dev.matyaqubov.instagramui.model.Post
import dev.matyaqubov.instagramui.model.Story

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        recyclerView=findViewById(R.id.recyclerView)
        recyclerView.layoutManager=GridLayoutManager(this,1)
        refreshAdapter(getAllFeeds())
    }

    private fun refreshAdapter(feeds: java.util.ArrayList<Feed>) {
        val adapter=FeedAdapter(this,feeds)
        recyclerView.adapter=adapter
    }

    private fun getAllFeeds(): ArrayList<Feed> {
        val stories=ArrayList<Story>()
        stories.add(Story(R.drawable.profile_bogibek,"Matyaqubov"))
        stories.add(Story(R.drawable.profile_azizbek,"Azizbek"))
        stories.add(Story(R.drawable.profile_mine,"Jonibek"))
        stories.add(Story(R.drawable.profile_nazirov,"Nazirov"))
        stories.add(Story(R.drawable.profile_ogabek,"Bogibek"))
        stories.add(Story(R.drawable.profile_saidahmad,"Saidahmad"))

        val feeds=ArrayList<Feed>()
        feeds.add(Feed(stories))
        feeds.add(Feed(Post(R.drawable.profile_bogibek,"Matyaqubov",R.drawable.post_image_1)))
        //for 3 image
        feeds.add(Feed(Post(R.drawable.profile_ogabek,"Ogabek dev", arrayListOf(R.drawable.post_image_1,R.drawable.post_image_1,R.drawable.post_image_1))))
        //for ads
        feeds.add(Feed(Post(R.drawable.img_2,"yandex.adv",R.drawable.img),true))
        //simple post
        feeds.add(Feed(Post(R.drawable.profile_saidahmad,"Saidahmad",R.drawable.post_image_1)))
        feeds.add(Feed(Post(R.drawable.profile_nazirov,"Nazirov",R.drawable.post_image_1)))
        feeds.add(Feed(Post(R.drawable.profile_ogabek,"Ogabek dev",R.drawable.post_image_1)))
        feeds.add(Feed(Post(R.drawable.profile_mine,"Jonibek",R.drawable.post_image_1)))

        return feeds
    }
}