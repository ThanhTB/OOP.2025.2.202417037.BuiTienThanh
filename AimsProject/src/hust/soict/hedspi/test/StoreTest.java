package hust.soict.hedspi.test;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {

        Store store = new Store();

        DigitalVideoDisc dvd = new DigitalVideoDisc(
                1,
                "Avengers",
                "Action",
                "Marvel",
                120,
                25.5f);

        Book book = new Book(
                2,
                "Clean Code",
                "Programming",
                18.5f);

        store.addMedia(dvd);
        store.addMedia(book);

        store.print();
    }
}