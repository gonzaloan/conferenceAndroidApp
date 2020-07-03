package tech.nullpointerexception.conf.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import tech.nullpointerexception.conf.R
import tech.nullpointerexception.conf.model.Speaker

class SpeakerAdapter(val speakerListener: SpeakerListener) :
    RecyclerView.Adapter<SpeakerAdapter.ViewHolder>() {

    var listSpeakers = ArrayList<Speaker>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_speaker, parent, false
        )
    )

    override fun getItemCount() = listSpeakers.size

    override fun onBindViewHolder(holder: SpeakerAdapter.ViewHolder, position: Int) {

        val speaker = listSpeakers[position] as Speaker

        holder.tvSpeakerName.text = speaker.name
        holder.tvItemSpeakerWork.text = speaker.workplace
        Glide.with(holder.itemView.context)
            .load(speaker.image)
            .apply(RequestOptions.circleCropTransform())
            .into(holder.tvItemSpeakerImage)


        holder.itemView.setOnClickListener {
            speakerListener.onSpeakerlicked(speaker, position)
        }
    }

    fun updateData(data: List<Speaker>) {
        listSpeakers.clear()
        listSpeakers.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvSpeakerName = itemView.findViewById<TextView>(R.id.tvItemSpeakerName)
        val tvItemSpeakerWork = itemView.findViewById<TextView>(R.id.tvItemSpeakerWork)
        val tvItemSpeakerImage = itemView.findViewById<ImageView>(R.id.tvItemSpeakerImage)
    }
}