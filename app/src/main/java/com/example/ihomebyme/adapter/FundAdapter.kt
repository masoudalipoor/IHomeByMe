package com.example.ihomebyme.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ihomebyme.R
import com.example.ihomebyme.db.entity.FundEntity
import com.example.ihomebyme.db.entity.ProjectEntity
import kotlinx.android.synthetic.main.fund_list.view.*

class FundAdapter constructor(
    private var listOfFundMember: List<FundEntity>,
    private var context: Context?
) :
    RecyclerView.Adapter<FundAdapter.ViewHolderFund>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FundAdapter.ViewHolderFund =
        ViewHolderFund(LayoutInflater.from(context).inflate(R.layout.fund_list, parent, false))

    override fun onBindViewHolder(holder: FundAdapter.ViewHolderFund, position: Int) {
        val fund: FundEntity = listOfFundMember[position]

        with(holder) {
            name.text = fund.fundName
            pay.text = fund.fundPay.toString()
        }

    }

    override fun getItemCount(): Int = listOfFundMember.size

    class ViewHolderFund(view: View) : RecyclerView.ViewHolder(view) {
        val name = view.fundNameTextView
        val pay = view.fundPayTextView
    }
}