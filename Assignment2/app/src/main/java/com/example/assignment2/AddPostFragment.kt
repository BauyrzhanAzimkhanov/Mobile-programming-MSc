package com.example.assignment2

import android.media.Image
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment

class AddPostFragment : Fragment() {
    private lateinit var createPostButton: Button
    private lateinit var imagePreviewImageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_post, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createPostButton = view.findViewById(R.id.create_post_button)
        imagePreviewImageView = view.findViewById(R.id.image_preview_image_view)
        imagePreviewImageView.setImageResource(R.drawable.upload_image_icon)
        createPostButton.setOnClickListener {
            Toast.makeText((activity as MainActivity?), "Added your post!", Toast.LENGTH_LONG).show()
        }
    }
}