package com.example.restaurants.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurants.Confirm;
import com.example.restaurants.MainActivity;
import com.example.restaurants.R;

import com.example.restaurants.model.QueueList;
import com.example.restaurants.model.QueueList.DummyItem;
import com.example.restaurants.ui.manageMenu.ManageMenuFragment;

import java.util.List;

import static androidx.recyclerview.widget.LinearLayoutManager.VERTICAL;

public class HomeFragment extends Fragment implements MyItemRecyclerViewAdapter.OnListFragmentInteractionListener{

    //private MyItemRecyclerViewAdapter.OnListFragmentInteractionListener mListener;
    private final List<DummyItem> mValues = QueueList.ITEMS;
    private static final String TAG = "HomeFragment";


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Set the adapter
        Context context = view.getContext();
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new MyItemRecyclerViewAdapter(mValues, this));

        return view;
    }
    /*
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MyItemRecyclerViewAdapter.OnListFragmentInteractionListener) {
            mListener = (MyItemRecyclerViewAdapter.OnListFragmentInteractionListener.) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    } */
    /*
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }*/

    @Override
    public void onListFragmentInteraction(int position) {
        Log.d(TAG, "onClick: ");
        Intent intent = new Intent(this.getActivity(), Confirm.class);
        intent.putExtra("selected_note", String.valueOf(mValues.get(position)));
        startActivity(intent);
    }

    /*
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(DummyItem item);
    } */
}