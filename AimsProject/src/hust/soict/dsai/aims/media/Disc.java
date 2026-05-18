package hust.soict.dsai.aims.media;

public class Disc extends Media {
    private int length;
    private String director;
    public Disc() {
        super();
    }
    @Override
    public int getId() {
        return super.getId();
    }
    @Override
    public String getCategory() {
        return super.getCategory();
    }
    @Override
    public String getTitle() {
        return super.getTitle();
    }
    @Override
    public float getCost() {
        return super.getCost();
    }
    public int getLength() {
        return length;
    }
    public String getDirector() {
        return director;
    }
}
