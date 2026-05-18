package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {

    public DigitalVideoDisc(int id, String title,
            String category, String director,
            int length, float cost) {

        super(id, title, category, director, length, cost);
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + getTitle());
        System.out.println("DVD length: " + getLength());
    }

    @Override
    public String toString() {
        return "DVD - " + getTitle() + " - "
                + getCategory() + " - "
                + getDirector() + " - "
                + getLength() + ": "
                + getCost() + "$";
    }
}