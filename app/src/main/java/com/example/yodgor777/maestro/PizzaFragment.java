package com.example.yodgor777.maestro;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.yodgor777.maestro.R.id.container;


/**
 * A simple {@link Fragment} subclass.
 */
public class PizzaFragment extends Fragment {


    String ItemNames[] = {   "1.Vesuvio",
                             "2.Hawaii",
                             "3.Tomaso",
                             "4.Caoricciosa",
                             "5.Fungi",
                             "6.Calzone",
                             "7.Caruso",
                             "8.St.Tropez",
                             "9.Banana",
                             "10.La Bella",
                             "11.La Bussola",
                             "12.Marinara",
                             "13.Maestro",
                             "14.La mafia",
                             "15.Campus",};


    String ItemFlavors[] ={"-Hama.",
                           "-Ham,pineapple.",
                           "-Ham,shrimps.",
                           "-Mushrooms,ham.",
                           "-Mushrooms.",
                           "-Ham(baked).",
                           "-Minded beef,garlic.",
                           "-Ground beef,with onions.",
                           "-Ham,banana.",
                           "-Tuna,onions.",
                           "-Mushrooms,shrimps",
                           "-Shrimps,mussels.",
                           "-Salami.olives.",
                           "-Bacon,onion.",
                           "-Salami,artichoke"};

    public PizzaFragment() {
        // Required empty public constructor
    }



    private ArrayList<PizzaHolder> mPizzaHolder = new ArrayList<>();


     public ListView mListView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View v =  inflater.inflate(R.layout.fragment_pizza, container, false);

       mListView = (ListView) mListView.findViewById(R.id.listview);

        for(int i = 0; i < 50; i++){

            PizzaHolder mHolder = new PizzaHolder();
            mHolder.itemName = ItemNames[i];
            mHolder.itemFlavor = ItemFlavors[i];
            mPizzaHolder.add(mHolder);
        }








        return v;
    }

}
