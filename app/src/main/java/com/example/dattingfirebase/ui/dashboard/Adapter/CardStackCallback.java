package com.example.dattingfirebase.ui.dashboard.Adapter;

import androidx.recyclerview.widget.DiffUtil;

import com.example.dattingfirebase.ui.dashboard.Model.ItemModel;

import java.util.List;

public class CardStackCallback extends DiffUtil.Callback {

    private List<ItemModel> old, newList;

    public CardStackCallback(List<ItemModel> old, List<ItemModel> newList) {
        this.old = old;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return old.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return old.get(oldItemPosition).getImage() == newList.get(newItemPosition).getImage();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return old.get(oldItemPosition) == newList.get(newItemPosition);
    }
}
