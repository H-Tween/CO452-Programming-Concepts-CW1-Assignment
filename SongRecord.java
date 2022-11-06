public class SongRecord {
    public String TrackName;
    public String ArtistName;
    public Integer PlayCount;

    public SongRecord(
        String trackName,
        String artistName,
        Integer playCount
    ) {
        TrackName = trackName;
        ArtistName = artistName;
        PlayCount = playCount;
    }

    public String PrintDetails() {
        return (String.format("%s | %s | %s", TrackName, ArtistName, PlayCount));
    }
}
