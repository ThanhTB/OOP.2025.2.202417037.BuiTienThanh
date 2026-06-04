package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
    private List<String> authors = new ArrayList<String>();

    public Book(String title, String category, float cost) {
        // Gọi constructor của Disc
        super(title, category, cost);
    }

    // Phương thức thêm tác giả
    public void addAuthor(String authorName) {
        // Kiểm tra xem tác giả đã tồn tại trong danh sách chưa
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("Added author: " + authorName);
        } else {
            System.out.println("Author '" + authorName + "' is already in the list.");
        }
    }

    // Phương thức xóa tác giả
    public void removeAuthor(String authorName) {
        // Kiểm tra xem tác giả có trong danh sách không trước khi xóa
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Removed author: " + authorName);
        } else {
            throw new IllegalStateException("ERROR: Author '" + authorName + "' not found in the list.");
        }
    }

    @Override
    public String toString() {
        return "Book - " + getTitle() + " - " + getCategory() + " - " + authors + " - " + getCost() + " $";
    }
}
