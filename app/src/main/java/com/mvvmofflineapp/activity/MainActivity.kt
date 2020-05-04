package com.mvvmofflineapp.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.mvvmofflineapp.R
import com.mvvmofflineapp.adapters.RecyclerAdapter
import com.mvvmofflineapp.model.ListDataModel
import com.mvvmofflineapp.viewmodel.CommonViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var mRecyclerAdapter: RecyclerAdapter? = null
    private var mDividerItemDecoration: DividerItemDecoration? = null
    private var commonViewModel: CommonViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        commonViewModel = ViewModelProviders.of(this).get(CommonViewModel::class.java)
        callViewModel()

        setAdapter()
    }

    private fun callViewModel() {

        commonViewModel?.getListData()?.observe(this, Observer { model: ListDataModel? ->
            if (model != null) {

                if (model.resultCode == 200 && model.dbDataAvailable == 1 && model.internetAvailable != 1) {
                    //Toast.makeText(this, "Response failed", Toast.LENGTH_SHORT).show()
                    txtNetworkCheck.visibility = View.VISIBLE
                    linRetry.visibility = View.GONE
                    txtNetworkCheck.text = "No internet connection"
                } else if (model.resultCode == 200 && (model.dbDataAvailable == 1 || model.internetAvailable == 1)) {
                    txtNetworkCheck.visibility = View.GONE
                    linRetry.visibility = View.GONE
                    mRecyclerAdapter?.addUsers(model.resultsList)
                } else {
                    linRecyclerView.visibility = View.GONE
                    linRetry.visibility = View.VISIBLE
                }
            }
        })
    }

    private fun setAdapter() {
        mRecyclerAdapter = RecyclerAdapter()
        recyclerview?.layoutManager = LinearLayoutManager(this)
        recyclerview?.adapter = mRecyclerAdapter

        mDividerItemDecoration = DividerItemDecoration(
            recyclerview?.context, LinearLayoutManager.VERTICAL
        )
        recyclerview?.addItemDecoration(mDividerItemDecoration!!)
    }
}
