package hust.soict.hedspi.aims;

import java.util.Scanner;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;

public class Aims {

    public static Store store = new Store();
    public static Cart cart = new Cart();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        DigitalVideoDisc dvd = new DigitalVideoDisc(
                1,
                "The Lion King",
                "Animation",
                "Roger Allers",
                87,
                19.95f);

        Book book = new Book(
                2,
                "Java Programming",
                "Education",
                15.5f);

        CompactDisc cd = new CompactDisc(
                3,
                "Greatest Hits",
                "Music",
                "Unknown",
                0,
                20.5f,
                "Michael Jackson");

        Track track1 = new Track("Track 1", 4);
        Track track2 = new Track("Track 2", 5);

        cd.addTrack(track1);
        cd.addTrack(track2);

        store.addMedia(dvd);
        store.addMedia(book);
        store.addMedia(cd);

        int choice;

        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

            case 1:
                viewStore();
                break;

            case 2:
                updateStore();
                break;

            case 3:
                seeCart();
                break;

            case 0:
                System.out.println("Goodbye!");
                break;

            default:
                System.out.println("Invalid choice!");
            }

        } while (choice != 0);
    }

    public static void showMenu() {
        System.out.println("\nAIMS:");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: ");
    }

    public static void viewStore() {

        store.print();

        System.out.println("\nOptions:");
        System.out.println("1. See media details");
        System.out.println("2. Add media to cart");
        System.out.println("3. Play media");
        System.out.println("0. Back");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {

        case 1:
            System.out.print("Enter media title: ");
            String title = scanner.nextLine();

            for (Media media : store.getItemsInStore()) {
                if (media.getTitle().equalsIgnoreCase(title)) {
                    System.out.println(media.toString());
                }
            }
            break;

        case 2:
            System.out.print("Enter media title: ");
            title = scanner.nextLine();

            for (Media media : store.getItemsInStore()) {
                if (media.getTitle().equalsIgnoreCase(title)) {
                    cart.addMedia(media);
                }
            }
            break;

        case 3:
            System.out.print("Enter media title: ");
            title = scanner.nextLine();

            for (Media media : store.getItemsInStore()) {

                if (media.getTitle().equalsIgnoreCase(title)
                        && media instanceof Playable) {

                    ((Playable) media).play();
                }
            }
            break;
        }
    }

    public static void updateStore() {

        System.out.println("\nOptions:");
        System.out.println("1. Add DVD");
        System.out.println("2. Add Book");
        System.out.println("3. Remove media");
        System.out.println("0. Back");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {

        case 1:

            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Title: ");
            String title = scanner.nextLine();

            System.out.print("Category: ");
            String category = scanner.nextLine();

            System.out.print("Director: ");
            String director = scanner.nextLine();

            System.out.print("Length: ");
            int length = scanner.nextInt();

            System.out.print("Cost: ");
            float cost = scanner.nextFloat();

            DigitalVideoDisc dvd =
                    new DigitalVideoDisc(
                            id,
                            title,
                            category,
                            director,
                            length,
                            cost);

            store.addMedia(dvd);
            break;

        case 2:

            System.out.print("ID: ");
            id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Title: ");
            title = scanner.nextLine();

            System.out.print("Category: ");
            category = scanner.nextLine();

            System.out.print("Cost: ");
            cost = scanner.nextFloat();

            Book book =
                    new Book(
                            id,
                            title,
                            category,
                            cost);

            store.addMedia(book);
            break;

        case 3:

            System.out.print("Enter media title: ");
            title = scanner.nextLine();

            Media found = null;

            for (Media media : store.getItemsInStore()) {
                if (media.getTitle().equalsIgnoreCase(title)) {
                    found = media;
                    break;
                }
            }

            if (found != null) {
                store.removeMedia(found);
            }

            break;
        }
    }

    public static void seeCart() {

        cart.print();

        System.out.println("\nOptions:");
        System.out.println("1. Search by ID");
        System.out.println("2. Search by Title");
        System.out.println("3. Remove media");
        System.out.println("4. Play media");
        System.out.println("5. Place order");
        System.out.println("0. Back");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {

        case 1:

            System.out.print("Enter ID: ");
            int id = scanner.nextInt();

            Media media = cart.searchById(id);

            if (media != null)
                System.out.println(media.toString());
            else
                System.out.println("Not found");

            break;

        case 2:

            System.out.print("Enter title: ");
            String title = scanner.nextLine();

            media = cart.searchByTitle(title);

            if (media != null)
                System.out.println(media.toString());
            else
                System.out.println("Not found");

            break;

        case 3:

            System.out.print("Enter title: ");
            title = scanner.nextLine();

            media = cart.searchByTitle(title);

            if (media != null)
                cart.removeMedia(media);

            break;

        case 4:

            System.out.print("Enter title: ");
            title = scanner.nextLine();

            media = cart.searchByTitle(title);

            if (media instanceof Playable) {
                ((Playable) media).play();
            }

            break;

        case 5:

            System.out.println("Order created!");
            break;
        }
    }
}