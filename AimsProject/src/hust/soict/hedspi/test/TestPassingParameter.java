package hust.soict.hedspi.test;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class TestPassingParameter {

    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);

        System.out.println("The title has changed:");
        System.out.println(oldTitle + " -> " + dvd.getTitle());
    }

    public static void main(String[] args) {

        DigitalVideoDisc jungleDVD =
                new DigitalVideoDisc(
                        1,
                        "Jungle",
                        "Animation",
                        "Disney",
                        120,
                        19.95f);

        DigitalVideoDisc cinderellaDVD =
                new DigitalVideoDisc(
                        2,
                        "Cinderella",
                        "Animation",
                        "Disney",
                        90,
                        18.5f);

        System.out.println("Before swap:");
        System.out.println("jungle dvd title: "
                + jungleDVD.getTitle());

        System.out.println("cinderella dvd title: "
                + cinderellaDVD.getTitle());

        swap(jungleDVD, cinderellaDVD);

        System.out.println("After swap:");
        System.out.println("jungle dvd title: "
                + jungleDVD.getTitle());

        System.out.println("cinderella dvd title: "
                + cinderellaDVD.getTitle());

        changeTitle(jungleDVD, "New Jungle");

        System.out.println("After changing title:");
        System.out.println(jungleDVD.getTitle());
    }
}