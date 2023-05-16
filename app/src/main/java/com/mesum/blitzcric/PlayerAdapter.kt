package com.mesum.blitzcric

import android.content.Context
import android.graphics.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.contentValuesOf
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class PlayerAdapter(private val playerList: List<CricketPlayer>,val context: Context) : RecyclerView.Adapter<PlayerAdapter.ViewHolder>() {

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


        val circleImageView: CircleImageView =  holder.ivProfile

        val targetSize = 50f
        val padding = 3f
        val drawable = player.profile
            val originalBitmap = Bitmap.createBitmap(drawable.intrinsicWidth, drawable.intrinsicHeight, Bitmap.Config.ARGB_8888)

        val resizedBitmap = Bitmap.createScaledBitmap(originalBitmap,
            targetSize.toInt(), targetSize.toInt(), false)

        val circleBitmap = Bitmap.createBitmap(resizedBitmap.width, resizedBitmap.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(circleBitmap)

        val paint = Paint().apply {
            isAntiAlias = true
            shader = BitmapShader(resizedBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        }

        canvas.drawCircle(resizedBitmap.width / 2f, resizedBitmap.height / 2f, resizedBitmap.width / 2f, paint)
        circleImageView.setImageBitmap(circleBitmap)
        circleImageView.setPadding(padding.toInt(), padding.toInt(), padding.toInt(),
            padding.toInt()
        )



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
