package DAM1.UF6.P3.PlaylistDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlaylistDaoImplementacio implements PlaylistDao {
    static Connection con = Connexio.getConnection();

    @Override
    public int create(Playlist playlist) throws SQLException {
        PreparedStatement ps = con.prepareStatement("INSERT INTO Playlist(Name)VALUES (?)");
        ps.setString(1, playlist.getName());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        int n = rs.getInt(1);
        return n;
    }

    @Override
    public Playlist read(int idPlaylist) throws SQLException {
        PreparedStatement ps = con.prepareStatement("SELECT * FROM Playlist WHERE PlaylistId =?");
        ps.setInt(1, idPlaylist);

        Playlist playlist = new Playlist();
        ResultSet rs = ps.executeQuery();
        boolean check = false;
        while (rs.next()) {
            check = true;
            playlist.setPlaylistId(rs.getInt("PlaylistId"));
            playlist.setName(rs.getString("Name"));
        }
        if (check == true) {
            return playlist;
        } else return null;
    }

    @Override
    public void update(Playlist playlist) throws SQLException {
        PreparedStatement ps = con.prepareStatement("UPDATE Playlist SET Name =? WHERE PlaylistId =?");
        ps.setString(1, playlist.getName());
        ps.setInt(2, playlist.getPlaylistId());
        ps.executeUpdate();
    }

    @Override
    public void delete(int idPlaylist) throws SQLException {
        PreparedStatement ps = con.prepareStatement("DELETE FROM Playlist WHERE PlaylistId =?");
        ps.setInt(1, idPlaylist);
        ps.executeUpdate();
    }


    @Override
    public List<Playlist> getPlaylist() throws SQLException {
        PreparedStatement ps = con.prepareStatement("SELECT * FROM Playlist");
        ResultSet rs = ps.executeQuery();
        List<Playlist> ls = new ArrayList<>();

        while (rs.next()) {
            Playlist playlist = new Playlist();
            playlist.setPlaylistId(rs.getInt("PlaylistId"));
            playlist.setName(rs.getString("Name"));
            ls.add(playlist);
        }
        return ls;
    }
}
