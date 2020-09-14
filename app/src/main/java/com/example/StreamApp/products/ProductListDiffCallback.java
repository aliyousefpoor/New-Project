package com.example.StreamApp.products;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

import com.example.StreamApp.data.model.Product;

import java.util.List;

public class ProductListDiffCallback extends DiffUtil.Callback {
    private List<Product> oldProductsList;
    private List<Product> newProductsList;

    public ProductListDiffCallback(List<Product> oldProductsList, List<Product> newProductsList) {
        this.oldProductsList = oldProductsList;
        this.newProductsList = newProductsList;
    }

    @Override
    public int getOldListSize() {
        return oldProductsList.size();
    }

    @Override
    public int getNewListSize() {
            return newProductsList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldProductsList.get(oldItemPosition).getId() == newProductsList.get(newItemPosition).getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        Product oldList = oldProductsList.get(oldItemPosition);
        Product newList = newProductsList.get(newItemPosition);
        return oldList.getName().equals(newList.getName());
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}