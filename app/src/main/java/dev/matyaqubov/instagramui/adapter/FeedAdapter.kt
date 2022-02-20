package dev.matyaqubov.instagramui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.google.android.material.imageview.ShapeableImageView
import dev.matyaqubov.instagramui.R
import dev.matyaqubov.instagramui.model.Feed
import dev.matyaqubov.instagramui.model.Story

class FeedAdapter(var context: Context, var items: ArrayList<Feed>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private val TYPE_ITEM_STORY = 0
        private val TYPE_ITEM_ADs = 3
        private val TYPE_ITEM_POST = 1
        private val TYPE_ITEM_POST_PHOTOS = 2
    }

    override fun getItemViewType(position: Int): Int {
        if (items[position].isads) return TYPE_ITEM_ADs
        if (items[position].stories.size > 0) {
            return TYPE_ITEM_STORY
        } else if (items[position].post!!.photos.isNotEmpty()) {
            return TYPE_ITEM_POST_PHOTOS
        } else {
            return TYPE_ITEM_POST
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_ITEM_STORY) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_feed_story, parent, false)
            return StoryViewHolder(context, view)
        }
        if (viewType == TYPE_ITEM_POST_PHOTOS) {
            val view =
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_feed_post_photos, parent, false)
            return PostsViewHolder(context, view)
        }

        if (viewType== TYPE_ITEM_ADs){
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_feed_ads, parent, false)
            return PostViewHolder(view)
        }
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_feed_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val feed = items[position]
        if (holder is StoryViewHolder) {
            var recyclerView = holder.recyclerView
            refreshAdapter(feed.stories, recyclerView)
        }
        if (holder is PostViewHolder) {
            holder.apply {
                iv_profile.setImageResource(feed.post!!.profile)
                iv_photo.setImageResource(feed.post!!.photo)
                tv_fullname.text = feed.post!!.fullname
            }
        }
        if (holder is PostsViewHolder) {

            holder.apply {
                iv_profile.setImageResource(feed.post!!.profile)
                tv_fullname.text = feed.post!!.fullname
            }
            var recyclerView=holder.recyclerView
            val snapHelper=PagerSnapHelper()
            snapHelper.attachToRecyclerView(recyclerView)
            refreshPostsAdapter(feed.post!!.photos, recyclerView)

        }

    }

    private fun refreshAdapter(stories: ArrayList<Story>, recyclerView: RecyclerView) {
        val adapter = StoryAdapter(context, stories)
        recyclerView.adapter = adapter
    }

    private fun refreshPostsAdapter(photos: ArrayList<Int>, recyclerView: RecyclerView) {
        val adapter = PostsAdapter(context, photos)
        recyclerView.adapter = adapter
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class StoryViewHolder(context: Context, view: View) : RecyclerView.ViewHolder(view) {
        var recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)

        init {
            recyclerView.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
    }

    class PostsViewHolder(context: Context, view: View) : RecyclerView.ViewHolder(view) {
        var recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        var iv_profile = view.findViewById<ShapeableImageView>(R.id.iv_profile)
        var tv_fullname = view.findViewById<TextView>(R.id.tv_fullname)
        var iv_like = view.findViewById<ImageView>(R.id.iv_like)
        var iv_comment = view.findViewById<ImageView>(R.id.iv_comment)
        var iv_send = view.findViewById<ImageView>(R.id.iv_send)
        var iv_save = view.findViewById<ImageView>(R.id.iv_save)
        var tv_caption = view.findViewById<TextView>(R.id.tv_caption)

        init {
            recyclerView.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
    }

    class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var iv_profile = view.findViewById<ShapeableImageView>(R.id.iv_profile)
        var iv_photo = view.findViewById<ImageView>(R.id.iv_photo)
        var tv_fullname = view.findViewById<TextView>(R.id.tv_fullname)
        var iv_like = view.findViewById<ImageView>(R.id.iv_like)
        var iv_comment = view.findViewById<ImageView>(R.id.iv_comment)
        var iv_send = view.findViewById<ImageView>(R.id.iv_send)
        var iv_save = view.findViewById<ImageView>(R.id.iv_save)
        var tv_caption = view.findViewById<TextView>(R.id.tv_caption)
    }
}