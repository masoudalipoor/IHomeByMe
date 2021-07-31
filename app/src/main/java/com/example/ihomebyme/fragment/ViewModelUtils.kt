package com.example.ihomebyme.fragment

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView

inline fun <reified R : ViewModel> Fragment.viewModel() = lazy { getViewModel<R>() }

inline fun <reified R : ViewModel> Fragment.getViewModel() =
     ViewModelProviders.of(this).get(R::class.java)


//inline fun <reified R : View> view() = getview<R>()
//
//inline fun <reified R: View > getview() =
//     R::class.java

