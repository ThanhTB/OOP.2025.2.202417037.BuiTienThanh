package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();
    public CompactDisc(){
        super();
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public String getCategory() {
        return super.getCategory();
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public String getTitle() {
        return super.getTitle();
    }

    @Override
    public float getCost() {
        return super.getCost();
    }

    public ArrayList<Track> getTracks() {
        return tracks;
    }
    
    public void  addTrack(Track track){
        if(trackInTrackList(track)){
            System.out.println("existed");
        }
        else{
            try {
                tracks.add(track);
                System.out.println("has been added");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public void removeTrack(Track track){
        if(!trackInTrackList(track)){
            System.out.println("not existed");
        }
        else{
            try {
                tracks.remove(track);
                System.out.println("has been removed");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public boolean trackInTrackList(Track track){
        return tracks.contains(track);
    } 
    
    public int getLengths(){
        int sum = 0;
        for(Track track : tracks){
            sum += track.getLength();
        }
        return sum; 
    }
}
