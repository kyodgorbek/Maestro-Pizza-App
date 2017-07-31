package com.example.yodgor777.maestro;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import org.zakariya.stickyheaders.SectioningAdapter;

import java.util.ArrayList;

/**
 * Created by yodgor777 on 2017-01-05.
 */

public class OtherAdapter extends SectioningAdapter implements Filterable {
    static String TAG = "Adapter";
    private Context context;
    private ItemsDataHolder listItems[] = null;
    private ItemsDataHolder OriganalListItems[] = null;

    OtherAdapter(Context context, ItemsDataHolder[] listItems) {
        this.context = context;
        this.listItems = listItems;
        OriganalListItems = listItems;
    }

    @Override
    public int getNumberOfSections() {

        Log.d(TAG, "getNumberOfSections: " + listItems.length);
        return listItems.length;
    }

    @Override
    public int getNumberOfItemsInSection(int sectionIndex) {
        Log.d(TAG, "getNumberOfItemsInSection: " + listItems[sectionIndex].CatItemsHolder.length);
        return listItems[sectionIndex].CatItemsHolder.length;
    }

    @Override
    public boolean doesSectionHaveHeader(int sectionIndex) {
        return true;
    }

    @Override
    public boolean doesSectionHaveFooter(int sectionIndex) {
        return false;
    }

    @Override
    public OtherAdapter.ItemViewHolder onCreateItemViewHolder(ViewGroup parent, int itemType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.salad_item, null);
        Log.d(TAG, "onCreateItemViewHolder: called");
        return new OtherAdapter.ItemViewHolder(v);
    }

    @Override
    public OtherAdapter.HeaderViewHolder onCreateHeaderViewHolder(ViewGroup parent, int headerType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.salad_header, null);
        Log.d(TAG, "onCreateHeaderViewHolder: called");
        return new OtherAdapter.HeaderViewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindItemViewHolder(SectioningAdapter.ItemViewHolder viewHolder, int sectionIndex, int itemIndex, int itemType) {
        SaladAdapter.ItemViewHolder holder = (SaladAdapter.ItemViewHolder) viewHolder;
        String ItemName = listItems[sectionIndex].CatItemsHolder[itemIndex].itemName;
        String flavorName = listItems[sectionIndex].CatItemsHolder[itemIndex].itemFlavor;

        holder.FlavorName.setText(flavorName);
        holder.ItemName.setText(ItemName);

        Log.d(TAG, "onBindItemViewHolder: items set " + sectionIndex + " item index " + itemIndex);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindHeaderViewHolder(SectioningAdapter.HeaderViewHolder viewHolder, int sectionIndex, int headerType) {
        String CatName = listItems[sectionIndex].CatName;
        String CatPrice = listItems[sectionIndex].CatEndText;
        String Shorttext = listItems[sectionIndex].SmallText;
        SaladAdapter.HeaderViewHolder holder = (SaladAdapter.HeaderViewHolder) viewHolder;
        holder.CatNAme.setText(CatName);
        holder.Price.setText(CatPrice);
        holder.ShortTExt.setText(Shorttext);
        Log.d(TAG, "onBindHeaderViewHolder: sectio index " + sectionIndex);
    }


    //searchview is done in pizza fragment. but the issue is it shuld be hide when user scroll the list
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                FilterResults filterResults = new FilterResults();
                ArrayList<ItemsDataHolder> filteredItems = new ArrayList<>();
                if (charSequence == null || charSequence.length() == 0 || charSequence == "") {
                    filterResults.count = OriganalListItems.length;
                    filterResults.values = OriganalListItems;
                } else {
                    for (ItemsDataHolder item : OriganalListItems) {
                        if (item.CatName.contains(charSequence)
                                || item.CatEndText.contains(charSequence)) {
                            filteredItems.add(item);
                        }
                        for (ItemsHolder innerItem : item.CatItemsHolder) {
                            if (innerItem.itemFlavor.contains(charSequence) ||
                                    innerItem.itemName.contains(charSequence) ||
                                    innerItem.Price.contains(charSequence)) {
                                filteredItems.add(item);
                            }
                        }
                    }

                    ItemsDataHolder FilteredArrayItems[] = new ItemsDataHolder[filteredItems.size()];


                    for (int i = 0; i < filteredItems.size(); i++) {
                        FilteredArrayItems[i] = filteredItems.get(i);
                    }
                    filterResults.count = FilteredArrayItems.length;
                    filterResults.values = FilteredArrayItems;
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                listItems = (ItemsDataHolder[]) filterResults.values;
                notifyAllSectionsDataSetChanged();
            }
        };
    }


    private class HeaderViewHolder extends SectioningAdapter.HeaderViewHolder {
        TextView CatNAme, Price, ShortTExt;

        public HeaderViewHolder(View itemView) {
            super(itemView);

            CatNAme = (TextView) itemView.findViewById(R.id.HeaderName);
            Price = (TextView) itemView.findViewById(R.id.HeaderPrice);
            ShortTExt = (TextView) itemView.findViewById(R.id.headerSortText);
        }
    }

    private class ItemViewHolder extends SectioningAdapter.ItemViewHolder {
        TextView ItemName, FlavorName;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ItemName = (TextView) itemView.findViewById(R.id.ItemName);
            FlavorName = (TextView) itemView.findViewById(R.id.FlavorName);

        }
    }
}


