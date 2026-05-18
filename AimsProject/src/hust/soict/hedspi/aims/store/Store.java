package hust.soict.hedspi.aims.store;

import java.util.ArrayList;

import hust.soict.hedspi.aims.media.Media;

public class Store {
    private ArrayList<Media> itemsInStore =
            new ArrayList<Media>();

    public void addMedia(Media media) {
        itemsInStore.add(media);
        System.out.println("The media has been added");
    }

    public void removeMedia(Media media) {
        itemsInStore.remove(media);
        System.out.println("The media has been removed");
    }

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

    public void print() {
        System.out.println("******** STORE ********");

        for (Media media : itemsInStore) {
            System.out.println(media.toString());
        }
    }
}