package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public class Track implements Playable{
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
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

    @Override
    public boolean equals(Object obj) {
        // 1. Kiểm tra xem đối tượng so sánh có chính là nó không
        if (this == obj) {
            return true;
        }

        // 2. Kiểm tra null và kiểm tra xem obj có phải là kiểu Track không
        if (obj == null || !(obj instanceof Track)) {
            return false;
        }

        // 3. Ép kiểu Object về Track 
        Track other = (Track) obj;

        // 4. So sánh title và length
        if (this.title == null) {
            return other.title == null && this.length == other.length;
        }
        
        return this.title.equalsIgnoreCase(other.getTitle()) 
            && this.length == other.getLength();
    }
}
