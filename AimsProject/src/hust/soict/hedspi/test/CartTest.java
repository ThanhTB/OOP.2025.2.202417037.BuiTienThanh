package hust.soict.hedspi.test;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {

        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(
                1,
                "The Lion King",
                "Animation",
                "Roger Allers",
                87,
                19.95f);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc(
                2,
                "Star Wars",
                "Science Fiction",
                "George Lucas",
                124,
                24.95f);

        cart.addMedia(dvd1);
        cart.addMedia(dvd2);

        cart.print();
    }
}