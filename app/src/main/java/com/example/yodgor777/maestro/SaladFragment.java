package com.example.yodgor777.maestro;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import org.zakariya.stickyheaders.StickyHeaderLayoutManager;

import static android.content.Context.INPUT_METHOD_SERVICE;

/**
 * Created by yodgor777 on 2016-12-21.
 */
public class SaladFragment extends Fragment {


    public RecyclerView mListView;
    SearchView searchView;
    private ItemsDataHolder itemsDataHolder[] = new ItemsDataHolder[]{

            new ItemsDataHolder("Salads", "Iceberg lettuce, cucembers, corn, peppers,\n" +
                    "tomato, red onion and dressing included in all salads.", "75:-", new ItemsHolder[]{

                    new ItemsHolder("1.Shrimp Salad", "-Shrimp,eggs,", "75:-"),
                    new ItemsHolder("2.Chicken Salad", "-Chicken,pineapple. ", "75:-"),
                    new ItemsHolder("3.Parma Salad", "-Parma ham, mozzarella.", "65:-"),
                    new ItemsHolder("4.Tuna Salad", "-Tuna,eggs.", "75:-"),
                    new ItemsHolder("5.Greek salad", "-Feta cheese,olives", "70:-"),
                    new ItemsHolder("6.American Salad", "-Ham,cheese,pineapple", "75:-")


            }),


    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_salad, container, false);
        mListView = (RecyclerView) v.findViewById(R.id.PizzaList);
        searchView = (SearchView) v.findViewById(R.id.searchView);


        final SaladAdapter mAdapter = new SaladAdapter(getActivity(), itemsDataHolder);
        //setting this adapter to list view simple.
        StickyHeaderLayoutManager layoutManager = new StickyHeaderLayoutManager();
        mListView.setLayoutManager(layoutManager);
        mListView.setAdapter(mAdapter);

        v.findViewById(R.id.OrderNow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri number = Uri.parse("tel:0470723344");
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
                startActivity(callIntent);
            }
        });

        v.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mAdapter.getFilter().filter(newText);
                return true;
            }
        });
        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputMethodManager im = ((InputMethodManager) getActivity().getSystemService(INPUT_METHOD_SERVICE));
                im.showSoftInput(searchView, 0);
            }
        });


        mListView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            /**
             * Callback method to be invoked when the RecyclerView has been scrolled. This will be
             * called after the scroll has completed.
             * <p>
             * This callback will also be called if visible item range changes after a layout
             * calculation. In that case, dx and dy will be 0.
             *
             * @param recyclerView The RecyclerView which scrolled.
             * @param dx           The amount of horizontal scroll.
             * @param dy           The amount of vertical scroll.
             */
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {
                    searchView.setVisibility(View.GONE);
                } else {
                    searchView.setVisibility(View.VISIBLE);
                }
            }

        });
        return v;
    }

}


