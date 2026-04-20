package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
    private DigitalVideoDisc[] itemsInStore =
            new DigitalVideoDisc[100];
    private int qtyItemsInStore = 0;
    public void addDVD(DigitalVideoDisc dvd) {
        if (qtyItemsInStore < itemsInStore.length) {
            itemsInStore[qtyItemsInStore] = dvd;
            qtyItemsInStore++;
            System.out.println("The DVD has been added.");
        } else {
            System.out.println("The store is full.");
        }
    }
    public void removeDVD(DigitalVideoDisc dvd) {
        for (int i = 0; i < qtyItemsInStore; i++) {
            if (itemsInStore[i].equals(dvd)) {
                for (int j = i; j < qtyItemsInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[qtyItemsInStore - 1] = null;
                qtyItemsInStore--;
                System.out.println("The DVD has been removed.");
                return;
            }
        }
        System.out.println("DVD not found.");
    }
}