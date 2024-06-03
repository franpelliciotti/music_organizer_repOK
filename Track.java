import java.util.ArrayList;
/**
 * 
 */
public class Track
{
    // The artist.
    private String artist;
    // The track's title.
    private String title;
    // Where the track is stored.
    private String filename;
    
    /**
     * Constructor for objects of class Track.
     * @param artist The track's artist.
     * @param title The track's title.
     * @param filename The track file. 
     */
    public Track(String artist, String title, String filename)
    {
        if(artist.trim().isEmpty())
            throw new IllegalArgumentException("artist can't be empty");
        if(title.trim().isEmpty())
            throw new IllegalArgumentException("title can't be empty");
        if(filename.trim().isEmpty())
            throw new IllegalArgumentException("filename can't be empty");
        setDetails(artist, title, filename);
        assert repOK(): "The class invariant is not respected";
    }
    
    /**
     * Constructor for objects of class Track.
     * It is assumed that the file name cannot be
     * decoded to extract artist and title details.
     * @param filename The track file. 
     */
    public Track(String filename)
    {
        if(filename.trim().isEmpty())
            throw new IllegalArgumentException("filename can't be empty");
        setDetails("unknown", "unknown", filename);
        assert repOK(): "The class invariant is not respected";
    }
    
    /**
     * Return the artist.
     * @return The artist.
     */
    public String getArtist()
    {
        return artist;
    }
    
    /**
     * Return the title.
     * @return The title.
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * Return the file name.
     * @return The file name.
     */
    public String getFilename()
    {
        return filename;
    }
        
    /**
     * Return details of the track: artist, title and file name.
     * @return The track's details.
     */
    public String getDetails()
    {
        return artist + ": " + title + "  (file: " + filename + ")";
    }
    
    /**
     * Set details of the track.
     * @param artist The track's artist.
     * @param title The track's title.
     * @param filename The track file. 
     */
    private void setDetails(String artist, String title, String filename)
    {
        this.artist = artist;
        this.title = title;
        this.filename = filename;
        assert repOK(): "The class invariant is not respected";
    }
    
    public boolean repOK(){
        return !(artist.trim().isEmpty()) && !(title.trim().isEmpty()) && !(filename.trim().isEmpty());
    }
}
