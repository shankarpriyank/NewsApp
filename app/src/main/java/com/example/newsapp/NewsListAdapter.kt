package com.example.newsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_news.view.*

class NewsListAdapter( private val listner:newsclicked):RecyclerView.Adapter<newsviewholder>() {
   private val items: ArrayList<News> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): newsviewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        val viewHolder = newsviewholder(view)
        view.setOnClickListener {
        listner.itemonclick(items[viewHolder.adapterPosition])
    }
        return viewHolder

    }

    override fun onBindViewHolder(holder: newsviewholder, position: Int) {
        val currentitem =items[position]
        holder.titleview.text=currentitem.title
        holder.author.text=currentitem.author
        Glide.with(holder.itemView.context).load(currentitem.imageUrl).into(holder.image)

    }

    override fun getItemCount(): Int {
        return items.size

    }fun updatenews(updatednews:ArrayList<News>){
        items.clear()
        items.addAll(updatednews)
        notifyDataSetChanged()
}
}
class newsviewholder(itemView:View):RecyclerView.ViewHolder(itemView){
    val titleview:TextView=itemView.title
    val image:ImageView= itemView.image
    val author:TextView=itemView.author
}
interface newsclicked {
    fun itemonclick(item:News)



}