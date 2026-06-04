package hust.soict.hedspi.aims;

import java.util.Scanner;

import javax.naming.LimitExceededException;

import hust.soict.hedspi.aims.cart.*;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.exception.PlayerException; 

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        initStoreData();

        int choice;
        while (true) {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1: viewStore(); break;
                case 2: updateStore(); break;
                case 3: viewCart(); break;
                case 0: 
                    System.out.println("Goodbye!");
                    System.exit(0);
                default: 
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void viewStore() {
        store.printStore();
        while (true) {
            storeMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                System.out.print("Enter media title: ");
                String title = scanner.nextLine();
                Media media = store.searchByTitle(title); 
                if (media != null) {
                    System.out.println(media.toString());
                    handleMediaDetails(media);
                } else System.out.println("Media not found.");
            } else if (choice == 2) {
                addToCartFromStore();
            } else if (choice == 3) {
                playMediaFromStore();
            } else if (choice == 4) {
                viewCart();
            } else if (choice == 0) break;
        }
    }

    public static void storeMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }

    public static void handleMediaDetails(Media media) {
        while (true) {
            mediaDetailsMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                try {
                    cart.addMedia(media);
                } catch (LimitExceededException | IllegalArgumentException e) {
                    System.err.println(e.getMessage());
                }
            } else if (choice == 2) {
                if (media instanceof Playable) {
                    // Cập nhật bọc khối try-catch cho hàm play() tại chi tiết Media
                    try {
                        ((Playable) media).play();
                    } catch (PlayerException e) {
                        System.err.println(e.getMessage());
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("This media cannot be played.");
                }
            } else if (choice == 0) break;
        }
    }

    public static void viewCart() {
        cart.print();
        while (true) {
            cartMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: filterCart(); break;
                case 2: sortCart(); break;
                case 3: removeFromCart(); break;
                case 4: playMediaFromCart(); break;
                case 5: 
                    System.out.println("Order created successfully!");
                    cart = new Cart(); // Empty cart
                    return;
                case 0: return;
            }
        }
    }

    private static void filterCart() {
        System.out.println("1. Filter by ID | 2. Filter by Title");
        int option = scanner.nextInt(); scanner.nextLine();
        System.out.print("Enter keyword: ");
        
        if (option == 1) {
            System.out.println("Filtering functionality under development.");
        } else {
            System.out.println("Filtering functionality under development.");
        }
    }

    private static void sortCart() {
        System.out.println("1. Sort by Title | 2. Sort by Cost");
        int option = scanner.nextInt(); 
        scanner.nextLine();
        
        if (option == 1) {
            System.out.println("Filtering functionality under development.");
        } else if (option == 2) {
            System.out.println("Filtering functionality under development.");
        }
    }

    private static void removeFromCart() {
        System.out.print("Enter title to remove from cart: ");
        String title = scanner.nextLine();
        Media m = store.searchByTitle(title); 
        if (m != null) {
            cart.removeMedia(m);
        } else {
            System.out.println("Media not found in cart.");
        }
    }

    private static void playMediaFromCart() {
        System.out.print("Enter title to play from cart: ");
        String title = scanner.nextLine();
        Media m = store.searchByTitle(title);
        
        if (m instanceof Playable) {
            // Cập nhật bọc khối try-catch cho hàm play() tại Giỏ hàng
            try {
                ((Playable) m).play();
            } catch (PlayerException e) {
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("This media cannot be played or not found.");
        }
    }

    private static void addToCartFromStore() {
        System.out.print("Enter title to add: ");
        String title = scanner.nextLine();
        Media m = store.searchByTitle(title);
        if (m != null) {
            try {
                cart.addMedia(m);
                // Dòng in này chỉ chạy nếu add thành công (không ném ngoại lệ)
                System.out.println("Items in cart: " + cart.getItemsOrdered().size()); 
            } catch (LimitExceededException e) {
                System.err.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        } else System.out.println("Not found.");
    }

    private static void playMediaFromStore() {
        System.out.print("Enter title to play: ");
        String title = scanner.nextLine();
        Media m = store.searchByTitle(title);
        if (m instanceof Playable) {
            // Cập nhật bọc khối try-catch cho hàm play() tại Cửa hàng
            try {
                ((Playable) m).play();
            } catch (PlayerException e) {
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("Not playable.");
        }
    }

    private static void updateStore() {
        System.out.println("1. Add Media | 2. Remove Media");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1) {
            System.out.println("Functionality under development.");
        } else if (choice == 2) {
            System.out.print("Enter title to remove: ");
            String title = scanner.nextLine();
            Media m = store.searchByTitle(title);
            if (m != null) store.removeMedia(m);
        }
    }

    private static void initStoreData() {
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Sci-Fi", "George Lucas", 124, 24.95f));
        store.addMedia(new Book("Java Programming", "Education", 15.0f));
        // 1 DVD lỗi độ dài bằng 0 hoặc âm để kiểm tra ném ngoại lệ:
        store.addMedia(new DigitalVideoDisc("DVD Loi Length", "Test", "Unknown", 0, 0.0f));
    }
}