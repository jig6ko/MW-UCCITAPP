package com.example.uccitapp

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MemberViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val memberPhotoImageView: ImageView = itemView.findViewById(R.id.memberPhotoImageView)
    val memberNameTextView: TextView = itemView.findViewById(R.id.memberNameTextView)
    val memberEmailTextView: TextView = itemView.findViewById(R.id.memberEmailTextView)
    val memberPhoneTextView: TextView = itemView.findViewById(R.id.memberPhoneTextView)
    val callButtonImageView: ImageView = itemView.findViewById(R.id.callButtonImageView)
    val emailButtonImageView: ImageView = itemView.findViewById(R.id.emailButtonImageView)
}
