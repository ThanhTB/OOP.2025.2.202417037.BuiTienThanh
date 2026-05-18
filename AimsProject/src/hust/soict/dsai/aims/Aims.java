package hust.soict.dsai.aims;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Aims {
    public static void main(String[] args) {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Cinderella");
        System.out.println(dvd1.getId());
        System.out.println(dvd2.getId());
    }
}
