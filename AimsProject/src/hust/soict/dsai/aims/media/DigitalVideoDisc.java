package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc {
    private String director;
    private int length;
    private static int nbDigitalVideoDiscs = 0;
    public DigitalVideoDisc(int id, String title, String category, int length){
        super();
        this.title = title;
    }
    @Override
    public String getTitle() {
        return title;
    }
    @Override
    public String getCategory() {
        return category;
    }
    @Override
    public String getDirector() {
        return director;
    }
    @Override
    public int getLength() {
        return length;
    }
    @Override
    public float getCost() {
        return cost;
    }
    public DigitalVideoDisc(String title) {
        super.title = title;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }
    public DigitalVideoDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int getId() {
        return id;
    }
    @Override
    public String toString(){
        return "DVD - " + title + " - " + category + " - " + director + " - " + length + " - " + cost + " $";
    }
    public boolean isMatch(String title) {
        return this.title.equalsIgnoreCase(title);
    }
}
