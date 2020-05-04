package com.mvvmofflineapp.adapters;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.mvvmofflineapp.R;
import com.mvvmofflineapp.databinding.ListItemBinding;
import com.mvvmofflineapp.repository.database.tables.TableResult;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private List<TableResult> mResults = new ArrayList<>();

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ListItemBinding listItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.list_item, parent, false);
        return new RecyclerViewHolder(listItemBinding);
    }

    public void addUsers(List<TableResult> results) {
        this.mResults = results;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        TableResult result = mResults.get(position);
        holder.setResult(result);
    }

    @Override
    public int getItemCount() {
        return mResults.size();
    }

    @BindingAdapter({"android:src"})
    public static void setImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).into(imageView);
        imageView.setAdjustViewBounds(true);
    }

    @BindingAdapter({"text"})
    public static void setName(TextView textView, TableResult name) {
        String string = String.valueOf((name.getTitle()).charAt(0)).toUpperCase() + name.getTitle().substring(1)
                + " " + String.valueOf((name.getFirstName()).charAt(0)).toUpperCase() + name.getFirstName().substring(1)
                + " " + String.valueOf((name.getLastName()).charAt(0)).toUpperCase() + name.getLastName().substring(1);
        textView.setText(string);
    }
}
