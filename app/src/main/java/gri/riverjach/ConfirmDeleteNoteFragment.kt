package gri.riverjach

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class ConfirmDeleteNoteFragment(val noteTitle: String = "") : DialogFragment() {

    interface ConfirmDeleteDialogListener {
        fun onDialogPositiveClick()
        fun onDialogNegativedClick()
    }

    var listener: ConfirmDeleteDialogListener? = null


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        builder.setMessage("Etes-vous sûr de supprime la note \"$noteTitle\" ?")
            .setPositiveButton("Supprimer",
                DialogInterface.OnClickListener { dialog, id -> listener?.onDialogPositiveClick() })
            .setNegativeButton("Annuler",
                DialogInterface.OnClickListener { dialog, id -> listener?.onDialogNegativedClick() })

        return builder.create()
    }
}