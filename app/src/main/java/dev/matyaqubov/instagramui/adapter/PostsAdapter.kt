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

class PostsAdapter(var context: Context, var items:ArrayList<Int>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val  view=LayoutInflater.from(parent.context).inflate(R.layout.item_photos_view,parent,false)
        return PhotosViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var item=items[position]

        if (holder is PhotosViewHolder){
            holder.apply {
                photo.setImageResource(item)
                tv_position.text="${position+1}/${items.size}"

            }
        }
    }

    override fun getItemCount(): Int {
       return items.size
    }

    class PhotosViewHolder(view: View):RecyclerView.ViewHolder(view){
        var photo=view.findViewById<ImageView>(R.id.post_photo)
        var tv_position=view.findViewById<TextView>(R.id.tv_position)
    }
}