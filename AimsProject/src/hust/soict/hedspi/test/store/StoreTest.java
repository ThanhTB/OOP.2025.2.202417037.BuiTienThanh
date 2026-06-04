package hust.soict.hedspi.test.store;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        // Tạo các DVD mẫu
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);

        // Test thêm DVD
        store.addMedia(dvd1);
        store.addMedia(dvd2);

        // Test xóa DVD hiện có
        store.removeMedia(dvd2);

        // Test xóa DVD không tồn tại (đã bị xóa ở trên)
        store.removeMedia(dvd2);
    }
}
