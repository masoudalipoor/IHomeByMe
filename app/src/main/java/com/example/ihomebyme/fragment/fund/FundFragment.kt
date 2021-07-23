package com.example.ihomebyme.fragment.fund

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.ihomebyme.R
import com.example.ihomebyme.fragment.getViewModel

class FoundFragment : Fragment(R.layout.fragment_found) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewmodel = getViewModel<FundViewModel>()
    }
}