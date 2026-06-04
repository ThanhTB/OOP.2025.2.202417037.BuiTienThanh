package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import hust.soict.hedspi.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList<>();

    public String getArtist() { 
        return artist; 
    }

    public CompactDisc(String title, String category, float cost, int length, String director, String artist) {
        super(title, category, cost, length, director);
        this.artist = artist;
    }

    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track '" + track.getTitle() + "' is already in the list.");
        } else {
            tracks.add(track);
            System.out.println("Track '" + track.getTitle() + "' added.");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track '" + track.getTitle() + "' removed.");
        } else {
            System.out.println("Track '" + track.getTitle() + "' does not exist in the list.");
        }
    }

    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing CD: " + this.getTitle() + " (Artist: " + this.getArtist() + ")");
            System.out.println("Total tracks: " + this.tracks.size());
            
            Iterator<Track> iter = this.tracks.iterator();
            Track nextTrack;
            
            while (iter.hasNext()) {
                nextTrack = iter.next();
                try {
                    nextTrack.play();
                } catch (PlayerException e) {
                    System.err.println("ERROR: Track '" + nextTrack.getTitle() + "' failed to play inside CD!");
                    throw e; 
                }
            }
        } else {
            System.err.println("ERROR: CD length is non-positive!");
            throw new PlayerException("ERROR: CD length is non-positive!");
        }
    }
}
