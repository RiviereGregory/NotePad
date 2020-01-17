package gri.riverjach

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NoteListActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var notes: MutableList<Note>
    lateinit var adapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)

        notes = mutableListOf<Note>()
        notes.add(Note("Note 1", "blablablabla"))
        notes.add(Note("Memo Bob", "Aenean eu nunc id nibh scelerisque vulputate. Pellentesque iaculis velit nec enim mattis faucibus"))
        notes.add(Note("Memo Bobette", "Duis sit amet commodo ex, vitae hendrerit nisl"))
        notes.add(Note("pourquoi Kotlin ?", "Parce que"))

        adapter = NoteAdapter(notes, this)

        val recyclerView = findViewById<RecyclerView>(R.id.notes_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    override fun onClick(view: View) {
        if (view.tag != null){
            Log.i("NoteListActivity", "Click sur une note")
        }
    }
}
