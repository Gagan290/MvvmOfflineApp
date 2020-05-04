package com.mvvmofflineapp.adapters

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.mvvmofflineapp.R
import com.mvvmofflineapp.repository.database.tables.TableResult
import java.util.*

class RecyclerAdapter1 : RecyclerView.Adapter<RecyclerViewHolder1>() {
    private var mResults: List<TableResult> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder1 {
//        val view: View =LayoutInflater.from(parent.context).inflate(LayoutInflater.from(parent.context), R.layout.list_item, parent, false)
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return RecyclerViewHolder1(view)
    }

    fun addUsers(results: List<TableResult>) {
        this.mResults = results
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder1, position: Int) {
        val result = mResults[position]
//        holder.setResult(result)

        result.picture?.let { setImage(holder.img_user, it) }
    }

    override fun getItemCount(): Int {
        return mResults.size
    }


    /*companion object {

        @BindingAdapter("android:src")*/
    fun setImage(imageView: ImageView, url: String) {
        Glide.with(imageView.context).load(url).into(imageView)
        imageView.adjustViewBounds = true
    }

    @BindingAdapter("text")
    fun setName(textView: TextView, name: TableResult) {
        val string = (name.title!!.get(0).toString().toUpperCase() + name.title!!.substring(1)
                + " " + name.firstName?.get(0).toString().toUpperCase() + name.firstName?.substring(1)
                + " " + name.lastName?.get(0).toString().toUpperCase() + name.lastName?.substring(1))
        textView.setText(string)
    }
    //}
}
