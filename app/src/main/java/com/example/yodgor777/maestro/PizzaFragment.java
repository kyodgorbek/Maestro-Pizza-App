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
 * A simple {@link Fragment} subclass.
 */
public class PizzaFragment extends Fragment {


    public RecyclerView mListView;
    SearchView searchView;
    private ItemsDataHolder itemsDataHolder[] = new ItemsDataHolder[]{
            //this is catogorie

            // you only need to change these items list on other fragments all codes are same just copy paste.
            new ItemsDataHolder("Classics", "65:-", new ItemsHolder[]{

                    new ItemsHolder("1. Vesuvio", "-Ham,\n", "65:-"),
                    new ItemsHolder("2.Hawaii", "-Ham,pineapple\n", "65:-"),
                    new ItemsHolder("3.Tomaso", "-Ham,shrimps.\n", "65:-"),
                    new ItemsHolder("4.Capricciosa", "-Mushrooms,ham\n", "65:-"),
                    new ItemsHolder("5.Fungi", "-Mushrooms,ham.\n", "65:-"),
                    new ItemsHolder("6.Calzone", "-Ham,pineapple\n", "65:-"),
                    new ItemsHolder("7.Caruso", "-Minced beef,garlic.\n", "65:-"),
                    new ItemsHolder("8.St.Lopez", "-Ground,beef,with onions.\n", "65:-"),
                    new ItemsHolder("9.Banana", "-Ham,banana\n", "65:-"),
                    new ItemsHolder("10.La Bella", "-Tuna,onions.\n", "65:-"),
                    new ItemsHolder("11.La Bussola", "-Mushrooms,shrimps\n", "65:-"),
                    new ItemsHolder("12. Marinara", "-Shrimps,olives.\n", "65:-"),
                    new ItemsHolder("13.Maestro", "-Salami,olives.\n", "70:-"),
                    new ItemsHolder("14.La mafia", "-Bacon,onion\n", "70:-"),
                    new ItemsHolder("15.Campus", "-Salami,artichoke\n", "70:-"),


            }),


            new ItemsDataHolder("Stars", "60:-", new ItemsHolder[]{
                    //these are items in catogorie
                    new ItemsHolder("16.Vegetariana", "-Champ,onions,peppers,olives,pineapple,artchoke", "70:-"),
                    new ItemsHolder("17.Tutti Frutti", "-Champ,ham,pineapple,banana", "70:-"),
                    new ItemsHolder("18.Palumbo", "-Champ,skinka,räkor", "70:-"),
                    new ItemsHolder("19.Quattro Stagioni", "-Champ,ham,shrimps,clams.", "70:-"),
                    new ItemsHolder("20.Princess", "-Ham,pineapple,banana,shrimps", "70:-"),
                    new ItemsHolder("21.Americana", "-Salami,chorizo,garlic,peppers,olives", "70:-"),
                    new ItemsHolder("22.Siciliana", "-Anchovies,shrimps,olives,garlic", "70:-"),
                    new ItemsHolder("23.Santiago", "-Champ,onions,shrimp,ground beef,pineapple,garlic", "70:-"),
                    new ItemsHolder("24.Byblos", "-Champ,ham,onions,meat sauce,shrimp", "70:-"),
                    new ItemsHolder("25.Poseidon", "-Krabfish,tuna,clams,shrimp", "70:-"),
                    new ItemsHolder("26.Ciao Ciao", "-Champ,onions,pork,garlic.(baked)", "70:-"),
            }),

            new ItemsDataHolder("Cult", "75:-", new ItemsHolder[]{
                    new ItemsHolder("27.Scarface", "-Salami,Onions,Olives,Peppers,Garlic,\nfefforoni.", "75:-"),
                    new ItemsHolder("28.Godfather", "-Pineapple,onion,chicken,fresh\ntomatoes,garlic dressing.", "75:-"),
                    new ItemsHolder("29.Rocky", "-Champ,onions,shrimps,pork,garlic,\nbearnaise sauce", "75:-"),
                    new ItemsHolder("30.Rambo", "-Ham,pineapple,onion,pork,shrimps,\ncurry.", "75:-"),
                    new ItemsHolder("31.Terminator", "-Mozzarella,red onion,cucumber,fresh\ntomatoes,smoked ham garlic dressing.", "75:-"),
                    new ItemsHolder("32.Titanic", "-Champ,onions,chicken,fresh\ntomatoes,garlic.", "75:-"),
                    new ItemsHolder("33.Top Gun", "-Ham,pork,pineapple,asparagus,\npeppers,garlic,bearnaise sauce.", "75:-"),
                    new ItemsHolder("34.Spartacus", "-Champ,beef,garlic,peppers.fresh\ntomatoes,bearnaise sauce..", "75:-"),
                    new ItemsHolder("35.Cobra", "-Champ,bacon,ground beef,shrimps,\ngarlic dressing.", "75:-"),
                    new ItemsHolder("36.Fight Club", "-Champ,onions,salami,beef,\ngorgonzola bearnaise sauce.", "75:-"),
                    new ItemsHolder("37.Matrix", "-Champ,bacon,ground beef,peppers,\nartichokes olives,hot sauce,garlic\ndressing.", "75:-"),
                    new ItemsHolder("38.Die Hard", "-Gorgonzola,mozzarella,riddarcheese,\nfeta cheese.", "75:-"),
                    new ItemsHolder("39.Gladiator Club", "-Champ,ham,beef,shrimps,fresh\ntomatoes,artchoke bearnaise sauce", "75:-"),
                    new ItemsHolder("40.Braveheart", "-Red onion,minced meat,feta cheese,\nolives,fresh tomatoes, garlic dressing.", "75:-"),

            }),

            new ItemsDataHolder("Icons", "75:-", new ItemsHolder[]{
                    new ItemsHolder("41.Stallone", "-Champ,onions,pork,beef,pineapple,\nasparagus and bearnaise sauce.", "75:-"),
                    new ItemsHolder("42.Arnold", "-Tuna,clams,shrimps,asparagus\nartichoke,fresh tomatoes.", "75:-"),
                    new ItemsHolder("43.Monroe", "-Ground beef,peppers,meat\nsauce,pineapple,jalapenos,asparagus,\ngarlic", "75:-"),
                    new ItemsHolder("44.Spielbeg", "-Onions,chicken,pineapple,peanuts,\njalapeno curry,fries,kebab sauce.", "75:-"),
                    new ItemsHolder("45.Bergman", "-Champ,ham,onions,peppers,pork,\nbearnaise sauce.(Half Baked)", "75:-"),
                    new ItemsHolder("46.Eastwood", "-Chicken,pineapple,banana,shrimps,\nfresh tomatoes,peanuts,bearnaise\nsauce..", "75:-"),
                    new ItemsHolder("47.Pacino", "-Champ,pineapple,banana,pork\nsalami, bacon,shrimps,curry,bearnaise\nsauce.", "75:-"),
                    new ItemsHolder("48.De Niro", "-Champ,onions,kebab meat,fries\nkebab sauce.", "75:-"),
                    new ItemsHolder("50.Elvis", "-Ham,pineapple,banana,bacon\nshrimps pork,sauce bearnaise", "75:-"),

            }),

            new ItemsDataHolder("Mexican Pizzas", "75:-", new ItemsHolder[]{
                    new ItemsHolder("51.Azteka", "-Champ,ham,fresh tomatoes,taco\nsauce,jalapeno bearnaise sauce.", "75:-"),
                    new ItemsHolder("52.Rodriguez", "-Champ,onions,ground beef,hot\nsauce,taco sauce,jalapeno,garlic\ndressing.", "75:-"),
                    new ItemsHolder("53.Ortega", "-Champ,onions,pork,taco,sauce,\njalapeno garlic dressing.", "75:-"),
                    new ItemsHolder("54.Mexico City", "-Chicken,fresh tomatoes,taco sauce,\njalapeno,garlic dressing.", "75:-"),
                    new ItemsHolder("55.El Toro", "-Feta cheese,fresh tomatoes,onions,\nolives  atchokes,ground beef,\njalapeno,garlic dressing.", "75:-"),


            }),
            new ItemsDataHolder("Really hungry?", "100:-", new ItemsHolder[]{
                    new ItemsHolder("The hangover pizza", "-Mozzarella,champ,red onion,bacon\npork,kebab meat,fries,bearnaise\nsauce & kebab sauce.", "75:-"),


            }),

    };



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_pizza, container, false);


        mListView = (RecyclerView) v.findViewById(R.id.PizzaList);
        searchView = (SearchView) v.findViewById(R.id.searchView);


        final ItemsAdapter mAdapter = new ItemsAdapter(getActivity(), itemsDataHolder);
        //setting this adapter to list view simple.
        final StickyHeaderLayoutManager layoutManager = new StickyHeaderLayoutManager();
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
