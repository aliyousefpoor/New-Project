package com.example.bottomnavigation.homeTab.h_adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.bottomnavigation.R;
import com.example.bottomnavigation.RtlLinearLayoutManager;
import com.example.bottomnavigation.homeTab.h_model.Headeritem;
import com.example.bottomnavigation.homeTab.h_model.Homeitem;

import java.util.List;

public class MultipleTypeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = "MultipleTypeAdapter";

    private static final int ViewPager_Type = 1;
    private static final int HorizontalList_Type = 2;

    private Context context;
    private List<Homeitem> homeList;
    private List<Headeritem> headerList;



    public MultipleTypeAdapter(Context context, List<Homeitem> homeList , List<Headeritem> headerList) {

        this.context = context;
        this.homeList = homeList;
        this.headerList = headerList;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return ViewPager_Type;
        } else {
            return HorizontalList_Type;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        RecyclerView.ViewHolder holder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());


        switch (viewType) {
            case ViewPager_Type:
                View pagerview = inflater.inflate(R.layout.header_item_layout, parent, false);
                holder = new ViewPagerVH(pagerview);
                break;

            case HorizontalList_Type:
                View listview = inflater.inflate(R.layout.home_item_layout, parent, false);
                holder = new ListVH(listview);
                break;
        }

        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        switch (getItemViewType(position)) {

            case ViewPager_Type:
                Log.d(TAG, "ViewPager_Type: "+ position);
                final ViewPagerVH pager_holder = (ViewPagerVH) holder;
                pager_holder.viewPager.setAdapter(new ViewPagerAdapter(headerList,context));
                break;

            case HorizontalList_Type:

                final ListVH list_holder = (ListVH) holder;
                Log.d(TAG, "HorizontalList_Type: " + position);

                list_holder.title.setText(homeList.get(position -1).getTitle());
                list_holder.pro_recyclerView.setAdapter(new ProductAdapter(homeList.get(position -1).getProducts(), context));
                list_holder.pro_recyclerView.setLayoutManager(new RtlLinearLayoutManager(context, RtlLinearLayoutManager.HORIZONTAL, false));
                list_holder.pro_recyclerView.setHasFixedSize(true);


                break;
        }

    }

    @Override
    public int getItemCount() {
        return homeList.size() + 1;
    }


    static class ViewPagerVH extends RecyclerView.ViewHolder {

        private ViewPager viewPager;

        public ViewPagerVH(@NonNull View itemView) {
            super(itemView);

            viewPager = itemView.findViewById(R.id.vp_img);

        }

    }

    static class ListVH extends RecyclerView.ViewHolder {

        private TextView title;
        private RecyclerView pro_recyclerView;

        public ListVH(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            pro_recyclerView = itemView.findViewById(R.id.product_rv);

        }


    }
}
