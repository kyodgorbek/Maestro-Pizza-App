package com.example.yodgor777.maestro;

/**
 * Created by yodgor777 on 2016-12-26.
 */

public class ItemsDataHolder {

    public String CatName = "", CatEndText = "";
    public String SmallText = "";
    ItemsHolder CatItemsHolder[] = new ItemsHolder[]{};

    //this is for pizza,  kebab and others.
    public ItemsDataHolder(String CatName, String CatEndText, ItemsHolder items[]) {
        this.CatName = CatName;
        this.CatEndText = CatEndText;
        CatItemsHolder = items;
    }

    // this is for salad
    public ItemsDataHolder(String CatName, String smallText, String CatEndText, ItemsHolder items[]) {
        this.CatName = CatName;
        this.CatEndText = CatEndText;
        SmallText = smallText;
        CatItemsHolder = items;
    }
}
