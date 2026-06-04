package hust.soict.hedspi.aims.media.comparator;

import java.util.Comparator;

import hust.soict.hedspi.aims.media.Media;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        // So sánh Cost trước (Giảm dần)
        int costCompare = Float.compare(m2.getCost(), m1.getCost());
        if (costCompare != 0) {
            return costCompare;
        }
        // Nếu Cost bằng nhau, so sánh Title (A-Z)
        return m1.getTitle().compareToIgnoreCase(m2.getTitle());
    }
}