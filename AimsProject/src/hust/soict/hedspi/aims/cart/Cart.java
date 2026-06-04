package hust.soict.hedspi.aims.cart;


import javax.naming.LimitExceededException;

import hust.soict.hedspi.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
 
public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;

    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    private FilteredList<Media> filteredItems = new FilteredList<>(itemsOrdered, p -> true);

    public FilteredList<Media> getFilteredItems(){
        return this.filteredItems;
    }

    // Phương thức thêm Media vào giỏ hàng
    public void addMedia(Media media) throws LimitExceededException {
        // 1. Kiểm tra xem giỏ hàng đã đầy chưa (ví dụ giới hạn là 20 phần tử)
        if (itemsOrdered.size() >= 20) {
            throw new LimitExceededException("ERROR: The cart is full! Cannot add more items.");
        }
        
        // 2. Kiểm tra xem sản phẩm đã tồn tại chưa
        if (!itemsOrdered.contains(media)) {
            itemsOrdered.add(media);
            System.out.println("The media '" + media.getTitle() + "' has been added.");
        } else {
            throw new IllegalArgumentException("ERROR: The media '" + media.getTitle() + "' is already in the cart.");
        }
    }

    // Phương thức xóa Media khỏi giỏ hàng
    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("The media '" + media.getTitle() + "' has been removed.");
        } else {
            // Thay vì in ra dòng chữ, ta ném ngoại lệ Runtime
            throw new IllegalArgumentException("ERROR: The media '" + media.getTitle() + "' was not found in the cart.");
        }
    }

    // Cập nhật phương thức tính tổng tiền
    public float totalCost() {
        float total = 0.0f;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    // Phương thức in danh sách giỏ hàng (Cập nhật từ bài trước)
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    public ObservableList<Media> getItemsOrdered() {
        return this.itemsOrdered;
    }
}
