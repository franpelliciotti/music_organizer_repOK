import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * This version can play the files.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class MusicOrganizer
{
    // A player for the music files.
    private MusicPlayer player;
    // An ArrayList for storing music tracks.
    private ArrayList<Track> tracks;
        
    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        tracks = new ArrayList<>();
        player = new MusicPlayer();
    }
    
    /**
     * Add a track file to the collection.
     * @param filename The file name of the track to be added.
     * Precondition: @param filename can't be empty.
     * Postcondition: the filename is given to a new track, and it's added to tracks.
     */
    public void addFile(String filename)
    {
        if(filename.trim().isEmpty())
            throw new IllegalArgumentException("filename can't be empty");
        int original = tracks.size();
        tracks.add(new Track(filename));
        assert tracks.size() == original + 1;
    }
    
    /**
     * Add a track to the collection.
     * @param track The track to be added.
     * Precondition: @param track must exists into tracks, and can't be null.
     * Postcondition: track is added to tracks.
     */
    public void addTrack(Track track)
    {
        if(track == null)
            throw new IllegalArgumentException("track can't be null");
        if(!trackFound(track))
            throw new IllegalArgumentException("track can't be found");
        int original = tracks.size();
        tracks.add(track);
        assert tracks.size() == original + 1;
    }
    
    /**
     * Return the number of tracks in the collection.
     * @return The number of tracks in the collection.
     */
    public int getNumberOfTracks()
    {
        return tracks.size();
    }

    /**
     * List a track from the collection.
     * @param index The index of the track to be listed.
     */
    public void listTrack(int index)
    {
        if(!indexValid(index))
            throw new IllegalArgumentException("Index must be valid (Greater than or equal to zero, and lower than tracks.size())");
        System.out.print("Track " + index + ": ");
        Track track = tracks.get(index);
        System.out.println(track.getDetails());
    }
    
    /**
     * Show a list of all the tracks in the collection.
     */
    public void listAllTracks()
    {
        System.out.println("Track listing: ");
        for(Track track : tracks) {
            System.out.println(track.getDetails());
        }
        System.out.println();
    }
    
    /**
     * List all tracks by the given artist.
     * @param artist The artist's name.
     */
    public void listByArtist(String artist)
    {
        if(artist.trim().isEmpty())
            throw new IllegalArgumentException("artist can't be empty");
        for(Track track : tracks) {
            if(track.getArtist().contains(artist)) {
                System.out.println(track.getDetails());
            }
        }
    }
    
    /**
     * Remove a track from the collection.
     * @param index The index of the track to be removed.
     */
    public void removeTrack(int index)
    {
        if(!indexValid(index))
            throw new IllegalArgumentException("Index must be valid (Greater than or equal to zero, and lower than tracks.size())");
        tracks.remove(index);
    }
    
    /**
     * Determine whether the given index is valid for the collection.
     * Print an error message if it is not.
     * @param index The index to be checked.
     * @return true if the index is valid, false otherwise.
     */
    private boolean indexValid(int index)
    {
        // The return value.
        // Set according to whether the index is valid or not.
        boolean valid;
        if(index < 0) {
            System.out.println("Index cannot be negative: " + index);
            valid = false;
        }
        else if(index >= tracks.size()) {
            System.out.println("Index is too large: " + index);
            valid = false;
        }
        else {
            valid = true;
        }
        return valid;
    }
    
    private boolean trackFound(Track track){
        boolean found = false;
        for(int i = 0; i < tracks.size(); i++){
            if(tracks.get(i).equals(track)){
                found = true;
            }
        }
        return found;
    }
} 
