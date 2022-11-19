package com.iubip.fastreportsapp.fragments.templates

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.iubip.fastreportsapp.R
import com.iubip.fastreportsapp.databinding.FragmentTemplateBinding
import com.iubip.fastreportsapp.fragments.BaseAdapter
import com.iubip.fastreportsapp.fragments.BaseItemType
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TemplateFragment : Fragment() {

    private val viewModel by viewModels<TemplateViewModel>()
    private lateinit var binding: FragmentTemplateBinding
    private var templateAdapter = BaseAdapter(
        onClick = { clickCard(it) }
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentTemplateBinding.inflate(inflater, container, false)

        viewModel.getContentFolder()

        binding.floatingButton.popupButton.setOnClickListener {
            if (binding.floatingButton.createFolderButton.isVisible) {
                showButtons(false, binding.floatingButton.createFolderButton)
                showButtons(false, binding.floatingButton.createTemplateButton)
                showButtons(false, binding.floatingButton.donwloadTemplateButton)
            } else {
                showButtons(true, binding.floatingButton.createFolderButton)
                showButtons(true, binding.floatingButton.createTemplateButton)
                showButtons(true, binding.floatingButton.donwloadTemplateButton)            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.templatesRcView.adapter = templateAdapter
        observableData()
    }

    private fun observableData() {
        viewModel.response.observe(viewLifecycleOwner) {
            templateAdapter.submitList(it)
        }
    }

    private fun clickCard(item: BaseItemType.File) {
        findNavController().navigate(R.id.action_templateFragment_to_folderItemFragment,
            bundleOf("aaa" to item.id))
    }

    fun showButtons(value: Boolean, view: View) {
        if (value) {
            view.visibility = View.VISIBLE
            view.alpha = 0f
            view.translationY = view.height.toFloat()
            view.animate()
                .setDuration(200)
                .translationY(0f)
                .setListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator?) {
                        super.onAnimationEnd(animation)
                    }
                }).alpha(1f).start()
        } else {
            view.visibility = View.VISIBLE
            view.alpha = 1f
            view.translationY = 0f
            view.animate()
                .setDuration(200)
                .translationY(view.height.toFloat())
                .setListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator?) {
                        view.visibility = View.GONE
                        super.onAnimationEnd(animation)
                    }
                }).alpha(0f).start()
        }
    }
}