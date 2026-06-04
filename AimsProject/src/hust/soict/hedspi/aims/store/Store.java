package hust.soict.hedspi.aims.store;

import java.util.ArrayList;

import hust.soict.hedspi.aims.media.Media;

public class Store {
    // Chuyển từ mảng sang ArrayList để chứa mọi loại Media
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    // Phương thức thêm Media vào cửa hàng
    public void addMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println("The media '" + media.getTitle() + "' has been added to the store.");
        } else {
            System.out.println("The media '" + media.getTitle() + "' is already in the store.");
        }
    }

    // Phương thức xóa Media khỏi cửa hàng
    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("The media '" + media.getTitle() + "' has been removed from the store.");
        } else {
            System.out.println("The media '" + media.getTitle() + "' was not found in the store.");
        }
    }

    public void printStore() {
        if (itemsInStore.isEmpty()) {
            System.out.println("The store is currently empty!");
        } else {
            int count = 1;
            for (Media media : itemsInStore) {
                System.out.println(count + ". " + media.toString());
                count++;
            }
        }
    }

    public Media searchByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null; // Trả về null nếu không tìm thấy
    }

    public ArrayList<Media> getItemsInStore() {
        return this.itemsInStore;
    }
}
