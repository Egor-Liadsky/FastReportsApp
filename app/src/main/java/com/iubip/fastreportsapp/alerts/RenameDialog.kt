package com.iubip.fastreportsapp.alerts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.iubip.fastreportsapp.databinding.ExportDialogBinding
import com.iubip.fastreportsapp.databinding.RenameDialogBinding
import com.iubip.fastreportsapp.utils.Constants

class RenameDialog : DialogFragment(){

    private lateinit var binding: RenameDialogBinding
    private val viewModel by viewModels<RenameViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = RenameDialogBinding.inflate(inflater, container, false)

//        viewModel.renameFile()

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.40).toInt()
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }
}