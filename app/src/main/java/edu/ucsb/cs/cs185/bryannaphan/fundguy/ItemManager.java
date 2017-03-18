package edu.ucsb.cs.cs185.bryannaphan.fundguy;
import android.content.ContentResolver;
import android.net.Uri;
import android.provider.MediaStore;
import java.io.IOException;
import android.widget.Adapter;
import java.util.ArrayList;

/**
 * Created by bryannaphan on 3/15/17.
 */

public class ItemManager {

    private Item item;
    private static ArrayList<Item> itemslist;
    private static ItemManager instance = new ItemManager();
    private ItemManagerListener listener;
    public static ItemAdapter adapter;



    public static ItemManager getInstance() {
        if (instance == null)
            instance = new ItemManager();
        return instance;
    }


    public int getSize(){
        return itemslist.size();
    }

    // Private constructor
    private ItemManager() {
        this.itemslist = new ArrayList<>();
        this.listener = new ItemManagerListener() {
            @Override
            public void onUpdate() {

            }
        };
    }

    public ArrayList getItemsList() {
        return itemslist;
    }

    public void add(Item item) {
        itemslist.add(item);
        listener.onUpdate();
        //notifyAll();
    }

    public void clear(Item item) {
        itemslist.clear();
        listener.onUpdate();
        //notifyAll();
    }

    public Item get(int index) {
        return itemslist.get(index);
    }

    public void setListener(ItemManagerListener listener) {
        this.listener = listener;
    }

    public interface ItemManagerListener {
        public void onUpdate();
    }

  /*
    public static void updateItem(Item item, String newTitle, String newDescription, float newAmount) {
        instance.add(item);
        item.setNewDetails(newTitle, newDescription, newAmount);
        adapter.notifyDataSetChanged();
    }
    */ 
}
