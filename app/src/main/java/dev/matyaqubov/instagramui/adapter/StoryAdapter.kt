package dev.matyaqubov.instagramui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.matyaqubov.instagramui.R
import dev.matyaqubov.instagramui.model.Story

class StoryAdapter(var context: Context,var items:ArrayList<Story>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val  view=LayoutInflater.from(parent.context).inflate(R.layout.item_story_view,parent,false)
        return StoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var story=items[position]

        if (holder is StoryViewHolder){
            holder.apply {
                iv_profile.setImageResource(story.profile)
                tv_fullname.text=story.fullname
            }
        }
    }

    override fun getItemCount(): Int {
       return items.size
    }

    class StoryViewHolder(view: View):RecyclerView.ViewHolder(view){
        var iv_profile=view.findViewById<ImageView>(R.id.iv_profile)
        var tv_fullname=view.findViewById<TextView>(R.id.tv_fullname)
    }
}