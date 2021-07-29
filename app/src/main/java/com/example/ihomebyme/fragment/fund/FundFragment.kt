package com.example.ihomebyme.fragment.fund

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ihomebyme.R
import com.example.ihomebyme.adapter.FundAdapter
import com.example.ihomebyme.db.dao.FundDao
import com.example.ihomebyme.db.entity.FundEntity
import com.example.ihomebyme.fragment.getViewModel
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_found.*
import java.lang.IllegalArgumentException
import javax.inject.Inject

@AndroidEntryPoint
class FoundFragment : Fragment(R.layout.fragment_found), FundAdapter.CellClickListener {

//    private var fundadapter: FundAdapter? = null

    @Inject
    lateinit var fundAdapter: FundAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewmodel = getViewModel<FundViewModel>()



        with(viewmodel) {

            addFundButton.setOnClickListener {
                insertFund(FundEntity(fundNameEditText.text.toString(), 0))
            }

            allFund.observe(viewLifecycleOwner) { funds ->
                fundRecyclerView.layoutManager = LinearLayoutManager(context)
                fundAdapter = FundAdapter()
                fundRecyclerView.adapter = fundAdapter

            }
        }
    }

    override fun onCellClickListener(data: FundEntity) {

    }


}
















//Observable.zip(Observable.just(cache), Observable.just(expire), { cache, expire ->
//    Pair(cache, expire)
//}).flatMap {
//    checkData(it.first!!, it.second!!)
//}.subscribe(
//{ next ->
//    next?.let { checkData(cache = true, expire = false)
//        Log.e("next one", next.toString())
//    }
//},
//{ error ->
//    checkData(cache = false, expire = true)
//    Log.e("error", error.message.toString())
//})





//fun checkData(cache: Boolean, expire: Boolean): Observable<Any>? {
//    return if (cache && !expire) Observable.just(
//        fundNameEditText.text.toString(),
//        fundPayEditText.text.toString().toDouble()
//    )
//    else throw IllegalArgumentException("Not value in this case")
//}