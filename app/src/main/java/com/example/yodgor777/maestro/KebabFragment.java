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
public class KebabFragment extends Fragment {
    public RecyclerView mListView;
    SearchView searchView;
    private ItemsDataHolder itemsDataHolder[] = new ItemsDataHolder[]{

            new ItemsDataHolder("Kebab", " Accessories: Iceberg lettuce, tomato, red onion, fefferoni,(except pizza orders).\n" +
                    "Sauce: kebab sauce, beanrnaise sauce, garlic dressing.", new ItemsHolder[]{


                    new ItemsHolder("1.Kebabpizza", "-Onions,champ,kebab meat,kebab souce.", "75:-"),
                    new ItemsHolder("2.Kebab Pizza Hawaii", "-Onions,pineapple, kebab sauce.", "75:-"),
                    new ItemsHolder("3.Kebab with bread", "-Lettuce,red onion,tomato,kebab sauce.", "65:-"),
                    new ItemsHolder("4.Kebab with fries", "-Lettuce,red onion,tomato,kebab sauce.", "75:-"),
                    new ItemsHolder("5.Kebab Roll", "-Lettuce,red onion, tomato, kebab sauce", "70:-"),
                    new ItemsHolder("6.Kebab with Rice", "-Lettuce,red onion, tomato, kebab sauce", "75:-")


            }),


    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.kebab, container, false);


        mListView = (RecyclerView) v.findViewById(R.id.PizzaList);
        searchView = (SearchView) v.findViewById(R.id.searchView);

        // creating adapter for a listView. getActivity means getting context from base class. and second one is layout for a one row
        // last param is out list of items.
        final KebabAdapter mAdapter = new KebabAdapter(getActivity(), itemsDataHolder);
        //setting this adapter to list view simple.
        StickyHeaderLayoutManager layoutManager = new StickyHeaderLayoutManager();
        mListView.setLayoutManager(layoutManager);
        mListView.setAdapter(mAdapter);

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


        return v;
    }

}
