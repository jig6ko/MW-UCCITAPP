package com.example.uccitapp

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DirectoryAdapter(private val memberList: List<DirectoryItem>) :
    RecyclerView.Adapter<MemberViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.directory_item, parent, false)
        return MemberViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MemberViewHolder, position: Int) {
        val member = memberList[position]
        holder.memberPhotoImageView.setImageResource(member.photo)
        holder.memberNameTextView.text = member.name
        holder.memberEmailTextView.text = member.email
        holder.memberPhoneTextView.text = member.phone
        holder.callButtonImageView.setOnClickListener {
            val dialIntent = Intent(Intent.ACTION_DIAL)
            dialIntent.data = Uri.parse("tel:${member.phone}")
            holder.itemView.context.startActivity(dialIntent)
        }
        holder.emailButtonImageView.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:${member.email}")
            }
            holder.itemView.context.startActivity(emailIntent)
        }
    }

    override fun getItemCount() = memberList.size
}