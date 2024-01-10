package DAM1.UF6.P1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Track {
    private int trackId;
    private String nom;
    private int albumId;
    private int mediaType;
    private int genreId;
    private String composer;
    private int miliseconds;
    private int bytes;
    private double unitPrice;

    private static Connection con = Connexio.getConnection();

    public Track() {
    }

    public Track(int trackId, String nom, int albumId, int mediaType, int genreId, String composer, int miliseconds, int bytes, double unitPrice) {
        this.trackId = trackId;
        this.nom = nom;
        this.albumId = albumId;
        this.mediaType = mediaType;
        this.genreId = genreId;
        this.composer = composer;
        this.miliseconds = miliseconds;
        this.bytes = bytes;
        this.unitPrice = unitPrice;
    }

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public int getMediaType() {
        return mediaType;
    }

    public void setMediaType(int mediaType) {
        this.mediaType = mediaType;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public int getMiliseconds() {
        return miliseconds;
    }

    public void setMiliseconds(int miliseconds) {
        this.miliseconds = miliseconds;
    }

    public int getBytes() {
        return bytes;
    }

    public void setBytes(int bytes) {
        this.bytes = bytes;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "Track{" +
                "trackId=" + trackId +
                ", nom='" + nom + '\'' +
                ", albumId=" + albumId +
                ", mediaType=" + mediaType +
                ", genreId=" + genreId +
                ", composer='" + composer + '\'' +
                ", miliseconds=" + miliseconds +
                ", bytes=" + bytes +
                ", unitPrice=" + unitPrice +
                '}' + "\n";
    }

    public List<Track> llistarTrack() {
        Statement stmt = null;
        List<Track> tracks = new ArrayList<>();
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM TRACK");
            while (rs.next()) {
                int trackId = rs.getInt("TrackId");
                String nom = rs.getString("Name");
                int albumId = rs.getInt("AlbumId");
                int mediaType = rs.getInt("MediaTypeId");
                int genreId = rs.getInt("GenreId");
                String compos = rs.getString("Composer");
                int milisecon = rs.getInt("Milliseconds");
                int bytes = rs.getInt("Bytes");
                int unitPrice = rs.getInt("UnitPrice");
                tracks.add(new Track(trackId, nom, albumId, mediaType, genreId, compos, milisecon, bytes, unitPrice));
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Operation done succesfully");
        return tracks;
    }

    public int creaTrack(String name, int albumId, int mediaType, int genreId, String composer, int miliseconds, int bytes, double unitPrice) {
        Statement stmt = null;
        int idTrackNou = -1;
        try {
            String query = "Select * from Track where TrackId = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, trackId);
            ResultSet resultSet = ps.executeQuery();

            if (!resultSet.next()) {
                System.out.println("Track amd id " + trackId + " no existeix");
            }
            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO Track (Name, AlbumId, MediaTypeId, GenreId, Composer, Milliseconds, Bytes, UnitPrice) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, albumId);
            preparedStatement.setInt(3, mediaType);
            preparedStatement.setInt(4, genreId);
            preparedStatement.setString(5, composer);
            preparedStatement.setInt(6, miliseconds);
            preparedStatement.setInt(7, bytes);
            preparedStatement.setDouble(8, unitPrice);
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            rs.next();

            idTrackNou = rs.getInt(1);
            preparedStatement.close();

            System.out.println("Record created successfully");
            return idTrackNou;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return trackId;
    }

    public Track seleccionaTrack(int idTrack) {
        Statement stmt = null;
        Track track = null;
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Track WHERE TrackId = ?");
            ps.setInt(1, idTrack);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int trackId = rs.getInt("TrackId");
                String nom = rs.getString("Name");
                int albumId = rs.getInt("AlbumId");
                int mediaType = rs.getInt("MediaTypeId");
                int genreId = rs.getInt("GenreId");
                String composer = rs.getString("Composer");
                int miliseconds = rs.getInt("Milliseconds");
                int bytes = rs.getInt("Bytes");
                double unitPrice = rs.getInt("UnitPrice");
                track = new Track(trackId, nom, albumId, mediaType, genreId, composer, miliseconds, bytes, unitPrice);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Operation done succesfully");
        return track;

    }

    public void eliminaTrack(int idTrack) {
        try {
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement("DELETE FROM Track where TrackId = ?");
            ps.setInt(1, idTrack);
            ps.executeUpdate();
            con.commit();
            ps.close();
        } catch (Exception e) {
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Operation done succesfully");
    }

    public void modificaTrack(int nouIdTrack, String name, int albumId, int mediaType, int genreId, String composer, int miliseconds, int bytes, double unitPrice) {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Track where TrackId = ?");
            ps.setInt(1, nouIdTrack);
            rs = ps.executeQuery();

            if (!rs.next()) {
                System.out.println("Track amb id " + trackId + " no existeix");
            }
            else {
                PreparedStatement ps2 = con.prepareStatement("UPDATE Track set Name = ?, AlbumId = ?, MediaTypeId = ?, GenreId = ?, Composer = ?, Milliseconds = ?, Bytes = ?, UnitPrice = ? WHERE TrackId =?");
                ps2.setString(1, name);
                ps2.setInt(2, albumId);
                ps2.setInt(3, mediaType);
                ps2.setInt(4, genreId);
                ps2.setString(5, composer);
                ps2.setInt(6, miliseconds);
                ps2.setInt(7, bytes);
                ps2.setDouble(8, unitPrice);
                ps2.setInt(9, nouIdTrack);
                ps2.executeUpdate();
                con.commit();
                ps2.close();
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Operation done succesfully");
    }
}
