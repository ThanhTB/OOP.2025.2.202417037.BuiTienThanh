package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.media.comparator.MediaComparatorByCostTitle;
import hust.soict.hedspi.aims.media.comparator.MediaComparatorByTitleCost;
import java.util.Comparator;

public abstract class Media implements Comparable<Media>{
    private int id;
    private String title;
    private String category;
    private float cost;

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    private static int nbMedia = 0;

    public Media(String title, String category, float cost) {
        if (cost < 0) {
            throw new IllegalArgumentException("ERROR: Cost cannot be negative!");
        }
        nbMedia++;
        this.id = nbMedia;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
        
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public float getCost() {
        return cost;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (!(obj instanceof Media)) {
            return false; 
        }
        
        Media other = (Media) obj;
        
        if (this.title == null) {
            if (other.title != null) {
                return false;
            }
        } else if (!this.title.equalsIgnoreCase(other.title)) {
            return false; 
        }
        
        if (Float.compare(this.cost, other.cost) != 0) {
            return false;
        }
        
        return true;
    }    
    
    @Override
    public int compareTo(Media other) {
        if (other == null) {
            throw new NullPointerException("The media object to compare cannot be null.");
        }
        
        String thisTitle = (this.title != null) ? this.title : "";
        String otherTitle = (other.getTitle() != null) ? other.getTitle() : "";
        
        int titleCompare = thisTitle.compareToIgnoreCase(otherTitle);
        
        if (titleCompare != 0) {
            return titleCompare; 
        }
        
        return Float.compare(this.cost, other.getCost());
    }
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
}
