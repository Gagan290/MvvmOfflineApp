package com.mvvmofflineapp.adapters;

import android.support.v7.widget.RecyclerView;
import com.mvvmofflineapp.databinding.ListItemBinding;
import com.mvvmofflineapp.repository.database.tables.TableResult;


public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    private ListItemBinding mListItemBinding;

    public RecyclerViewHolder(ListItemBinding listItemBinding) {
        super(listItemBinding.getRoot());
        this.mListItemBinding = listItemBinding;
    }

    public void setResult(TableResult result) {
        mListItemBinding.setResult(result);
        mListItemBinding.executePendingBindings();
    }
}
