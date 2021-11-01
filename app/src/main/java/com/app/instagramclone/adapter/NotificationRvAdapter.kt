package com.app.instagramclone.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.instagramclone.R
import kotlinx.android.synthetic.main.notification_rv_item.view.*

class NotificationRvAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.notification_rv_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when {
            position % 3 == 0 -> {
                holder.itemView.acceptMb.visibility = View.GONE
                holder.itemView.rejectMb.visibility = View.GONE
                holder.itemView.contentTv.text = "Darlene Robert commented on your post"
                holder.itemView.profileIv.visibility = View.INVISIBLE
                holder.itemView.notificationTypeCv.visibility = View.VISIBLE
                holder.itemView.notificationTypeIv.setImageResource(R.drawable.ic_chat_unfilled)
            }
            position % 2 == 0 -> {
                holder.itemView.acceptMb.visibility = View.GONE
                holder.itemView.rejectMb.visibility = View.GONE
                holder.itemView.profileIv.visibility = View.INVISIBLE
                holder.itemView.notificationTypeCv.visibility = View.VISIBLE
                holder.itemView.contentTv.text = "Darlene Robert liked your post"
                holder.itemView.notificationTypeIv.setImageResource(R.drawable.ic_heart_unfilled)
            }
            else -> {
                holder.itemView.acceptMb.visibility = View.VISIBLE
                holder.itemView.rejectMb.visibility = View.VISIBLE
                holder.itemView.profileIv.visibility = View.VISIBLE
                holder.itemView.notificationTypeCv.visibility = View.GONE
                holder.itemView.contentTv.text = "Darlene Robert requested to follow you"
            }
        }
    }

    override fun getItemCount(): Int {
        return 20
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}