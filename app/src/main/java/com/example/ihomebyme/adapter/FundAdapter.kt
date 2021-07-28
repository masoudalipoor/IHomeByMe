package com.example.ihomebyme.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ihomebyme.R
import com.example.ihomebyme.db.entity.FundEntity
import kotlinx.android.synthetic.main.fund_list.view.*
import javax.inject.Inject

class FundAdapter @Inject constructor(
//    private var listOfFundMember: List<FundEntity>,
//    private var context: Context?,
//    private val cellClickListener: CellClickListener
) :
    RecyclerView.Adapter<FundAdapter.ViewHolderFund>() {

    private var listOfFundMember: List<FundEntity>? = null
    private var context: Context? = null
    private val cellClickListener: CellClickListener?= null

    var onItemClick: ((FundEntity) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FundAdapter.ViewHolderFund =
        ViewHolderFund(LayoutInflater.from(context).inflate(R.layout.fund_list, parent, false))

    override fun onBindViewHolder(holder: FundAdapter.ViewHolderFund, position: Int) {
        val fund: FundEntity = listOfFundMember!![position]

        with(holder) {
            name.text = fund.fundName
            pay.text = fund.fundPay.toString()
        }
    }

    override fun getItemCount(): Int = listOfFundMember!!.size

    inner class ViewHolderFund(view: View) : RecyclerView.ViewHolder(view) {
        
        val name = view.fundNameTextView
        val pay = view.fundPayTextView
        val payEditText = view.fundPayEditText
        val addInfo = view.addNewInfoRl
        val confirmInfo = view.confirmNewInfoButton

        val top = view.topRl.setOnClickListener {
            cellClickListener?.onCellClickListener(listOfFundMember!![adapterPosition])
        }
    }

    interface CellClickListener {
        fun onCellClickListener(data: FundEntity)
    }
}