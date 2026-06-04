package hust.soict.hedspi.aims.media.comparator;

import java.util.Comparator;

import hust.soict.hedspi.aims.media.Media;

public class MediaComparatorByTitleCost implements Comparator<Media>{
    @Override
    public int compare(Media m1, Media m2) {
        // So sánh theo tiêu đề (A-Z)
        int titleCompare = m1.getTitle().compareToIgnoreCase(m2.getTitle());
        if (titleCompare != 0) {
            return titleCompare;
        }
        // Nếu tiêu đề giống nhau, so sánh theo giá (Giảm dần)
        return Float.compare(m2.getCost(), m1.getCost());
    }
}
