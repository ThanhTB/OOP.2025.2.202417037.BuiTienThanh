package hust.soict.hedspi.test.Polymorphism;

import java.util.ArrayList;
import java.util.List;
import hust.soict.hedspi.aims.media.*;

public class PolymorphismTest {
    public static void main(String[] args) {
        List<Media> mediae = new ArrayList<Media>();

        // Tạo các đối tượng cụ thể
        Media cd = new CompactDisc("Greatest Hits", "Music", 15.5f, 60, "Director A", "Artist B");
        Media dvd = new DigitalVideoDisc("Star Wars", "Sci-Fi", "George Lucas", 124, 24.99f);
        Media book = new Book("Ishura", "Supernatural", 20.0f);

        // Thêm vào danh sách chung kiểu Media
        mediae.add(cd);
        mediae.add(dvd);
        mediae.add(book);

        // Duyệt danh sách và in ra
        for (Media m : mediae) {
            System.out.println(m.toString());
        }
    }
}
