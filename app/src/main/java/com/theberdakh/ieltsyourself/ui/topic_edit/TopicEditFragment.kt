package com.theberdakh.ieltsyourself.ui.topic_edit

import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.theberdakh.ieltsyourself.R
import com.theberdakh.ieltsyourself.core.domain.model.Topic
import com.theberdakh.ieltsyourself.core.presentation.TopicEditViewModel
import com.theberdakh.ieltsyourself.databinding.FragmentTopicEditBinding
import com.theberdakh.ieltsyourself.ui.main.MainFragmentDirections
import kotlinx.coroutines.flow.onEach

class TopicEditFragment: Fragment(R.layout.fragment_topic_edit) {
    private lateinit var binding: FragmentTopicEditBinding
    private lateinit var viewModel: TopicEditViewModel
    private lateinit var topic: Topic
    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args: TopicEditFragmentArgs by navArgs()
        topic = args.topic

        binding = FragmentTopicEditBinding.bind(view)
        viewModel = ViewModelProvider(requireActivity())[TopicEditViewModel::class.java]
        navController = Navigation.findNavController(requireActivity(), R.id.parent_container)


       binding.apply {
           setNameField(tilEditTopicName, etEditTopicName, topic.name, getString(R.string.til_error_empty))
            setNameField(tilEditTopicDescription, etEditTopicDescription, topic.description)

            tbEditTopic.setNavigationOnClickListener {
                navController.popBackStack()
            }

           tvTopicEditDelete.setOnClickListener {
               MaterialAlertDialogBuilder(requireContext())
                   .setTitle(getString(R.string.delete))
                   .setMessage(getString(R.string.delete_dialog_topic, topic.name, topic.size))
                   .setPositiveButton(getString(R.string.delete)){dialog, position ->
                       lifecycleScope.launchWhenResumed {
                           viewModel.deleteTopic(topic)
                           viewModel.deleteTopicWithWords(topic)
                       }
                       dialog.dismiss()
                       navController.navigate(TopicEditFragmentDirections.actionTopicEditFragmentToMyTopicsFragment())
                   }
                   .setNegativeButton(R.string.cancel){dialog, position ->
                       dialog.dismiss()
                   }.show()

           }


            tbEditTopic.setOnMenuItemClickListener { menuItem ->
                when(menuItem.itemId){
                    R.id.action_top_edit_topic -> {
                        if (etEditTopicName.text.toString().isNotEmpty()){
                            val updatedTopic =  Topic(
                                id = topic.id,
                                name = etEditTopicName.text.toString(),
                                description = etEditTopicDescription.text.toString(),
                                size = topic.size,
                                status = topic.status
                            )
                            updateTopic(updatedTopic)
                            navController.navigate(TopicEditFragmentDirections.actionTopicEditFragmentToTopicFragment(updatedTopic))
                        }
                        true
                    }
                    else -> false
                }
            }
        }
    }

    private fun updateTopic(topic: Topic) {

        lifecycleScope.launchWhenResumed {
            viewModel.updateTopic(topic)

    }}

    private fun setNameField(til: TextInputLayout, et: TextInputEditText, value: String, error: String? = null) {
        et.setText(value)
        et.addTextChangedListener {
            til.error = if (et.text.toString().isEmpty()) error else null
        }
    }


}