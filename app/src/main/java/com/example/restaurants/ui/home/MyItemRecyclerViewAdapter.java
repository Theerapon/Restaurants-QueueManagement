package com.example.restaurants.ui.home;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurants.R;
import com.example.restaurants.model.QueueList;
//import  com.example.restaurants.ui.home.HomeFragment.OnListFragmentInteractionListener;

import java.util.List;


class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "MyItemRecyclerViewAdapter";
    private final List<QueueList.DummyItem> mValues;
    private final OnListFragmentInteractionListener mListener;


    public MyItemRecyclerViewAdapter(List<QueueList.DummyItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_item, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.item_contact.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("LongLogTag")
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: ");
                mListener.onListFragmentInteraction(viewHolder.getAdapterPosition());
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position){
        holder.mItem = mValues.get(position);
        holder.mQueueView.setText(mValues.get(position).queue);
        holder.mNameFoodView.setText(mValues.get(position).name_food);
        holder.mTimeView.setText(mValues.get(position).time);
        holder.mNameCustomerView.setText(mValues.get(position).name_customer);



    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private RelativeLayout item_contact;
        public final View mView;
        public final TextView mQueueView;
        public final TextView mNameFoodView;
        public final TextView mNameCustomerView;
        public final TextView mTimeView;
        public QueueList.DummyItem mItem;
        public final ImageView mImage;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            item_contact = view.findViewById(R.id.relativeLayout_recycler_view_item);
            mQueueView = view.findViewById(R.id.recycle_queue);
            mNameFoodView = view.findViewById(R.id.recycler_name_food);
            mNameCustomerView = view.findViewById(R.id.recycler_name_customer);
            mTimeView = view.findViewById(R.id.recycler_time);
            mImage = view.findViewById(R.id.imageView_restaurants);

        }

    }
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(int position);
    }
}

