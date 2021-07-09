package com.api_ex

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class api_adapter(private val api_list: ArrayList<ApiModel>) :
    RecyclerView.Adapter<api_adapter.ViewHolder>() {
    var clicked: ((String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.api_showimg, parent, false)
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(api_list[position])
    }

    override fun getItemCount(): Int {
        return api_list.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(imageDataModel: ApiModel) {
            val setImg = itemView.findViewById<ImageView>(R.id.img)
            val setName = itemView.findViewById<TextView>(R.id.ImgName)
            setName.text = imageDataModel.title
            Picasso.get().load(imageDataModel.url).into(setImg)

            setImg.setOnClickListener {
             clicked?.invoke(imageDataModel.url!!)
            }
        }
    }

}