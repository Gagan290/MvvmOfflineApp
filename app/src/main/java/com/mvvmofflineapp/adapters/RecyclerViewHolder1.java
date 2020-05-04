package com.mvvmofflineapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import com.mvvmofflineapp.R;
import com.mvvmofflineapp.repository.database.tables.TableResult;

public class RecyclerViewHolder1 extends RecyclerView.ViewHolder {

    //    private ListItemBinding mListItemBinding;
    private View itemView;
    ImageView img_user;

    /*public RecyclerViewHolder1(ListItemBinding listItemBinding) {
        super(listItemBinding.getRoot());
        this.mListItemBinding = listItemBinding;
    }*/

    public RecyclerViewHolder1(View itemView) {
        super(itemView);
//        this.itemView = itemView;
        img_user = itemView.findViewById(R.id.img_user);
        //this.mListItemBinding = listItemBinding;
    }

    public void setResult(TableResult result) {
//        RecyclerAdapter1.Companion.setImage(img_user, result.getPicture());
        /*itemView.setResult(result);
        itemView.executePendingBindings();*/
    }
}
