package gri.riverjach

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter(val notes: List<Note>, val itemClickListenner: View.OnClickListener) :
    RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView = itemView.findViewById(R.id.card_view) as CardView
        val titleView = cardView.findViewById<TextView>(R.id.title)
        val excerptView = cardView.findViewById<TextView>(R.id.excerpt)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewItem =
            LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        return ViewHolder(viewItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = notes[position]
        holder.cardView.setOnClickListener(itemClickListenner)
        holder.cardView.tag = position
        holder.titleView.text = note.title
        holder.excerptView.text = note.text
    }

    override fun getItemCount(): Int {
        return notes.size
    }
}