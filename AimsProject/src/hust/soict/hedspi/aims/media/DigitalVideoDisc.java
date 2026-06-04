package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
    private String director;
    private int length;

    // 1. Class attribute (Của chung - dùng static)
    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        // Gọi constructor của Disc
        super(title, category, cost, length, director);
    }
    
    public String getDirector() {
        return director;
    }
    public int getLength() {
        return length;
    }

    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }
    
    @Override
    public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory() + " - " + director + 
            " - " + length + ": " + getCost() + " $";
    }

    public boolean isMatch(String title) {
        // Sử dụng getTitle() thay vì this.title
        return this.getTitle().toLowerCase().contains(title.toLowerCase());
    }

    public void play() throws PlayerException{
        if(this.getLength() > 0){
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        } else {
            System.err.println("ERROR: DVD length is non-positive!");    
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }
    }   
}
