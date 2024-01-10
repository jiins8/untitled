package DAM1.UF6.P3.PlaylistDAO;

import java.sql.SQLException;
import java.util.List;

public interface PlaylistDao {
    public int create(Playlist playlist) throws SQLException;
    public Playlist read(int idPlaylist) throws SQLException;
    public void update(Playlist playlist) throws SQLException;
    public void delete(int idPlaylist) throws SQLException;
    public List<Playlist> getPlaylist() throws SQLException;
}
