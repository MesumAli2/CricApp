package com.mesum.blitzcric

import android.content.Context
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class PlayerAdapter(private val playerList: List<CricketPlayer>) : RecyclerView.Adapter<PlayerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context: Context = parent.context
        val inflater = LayoutInflater.from(context)
        val itemView: View = inflater.inflate(R.layout.rv_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val player: CricketPlayer = playerList[position]
        holder.cricterNameTextView.text = player.name
        holder.cricTypeTextView.text = player.type
        holder.ivProfile.setImageDrawable(player.profile)
    }

    override fun getItemCount(): Int {
        return playerList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivProfile: CircleImageView = itemView.findViewById(R.id.ivProfile)
        val cricterNameTextView: TextView = itemView.findViewById(R.id.cricter_name)
        val cricTypeTextView: TextView = itemView.findViewById(R.id.cric_type)
    }
}
