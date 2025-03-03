import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VeterinarioDAOImpl implements VeterinarioDAO {

    @Override
    public void addVeterinario(Veterinario veterinario) {
        String sql = "INSERT INTO veterinarios (crmv, nome, especialidade) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, veterinario.getCrmv());
            stmt.setString(2, veterinario.getNome());
            stmt.setString(3, veterinario.getEspecialidade());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Veterinario getVeterinarioByCrmv(String crmv) {
        String sql = "SELECT * FROM veterinarios WHERE crmv = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, crmv);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Veterinario(
                    rs.getString("crmv"),
                    rs.getString("nome"),
                    rs.getString("especialidade")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Veterinario> getAllVeterinarios() {
        List<Veterinario> veterinarios = new ArrayList<>();
        String sql = "SELECT * FROM veterinarios";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                veterinarios.add(new Veterinario(
                    rs.getString("crmv"),
                    rs.getString("nome"),
                    rs.getString("especialidade")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return veterinarios;
    }

    @Override
    public void updateVeterinario(Veterinario veterinario) {
        String sql = "UPDATE veterinarios SET nome = ?, especialidade = ? WHERE crmv = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, veterinario.getNome());
            stmt.setString(2, veterinario.getEspecialidade());
            stmt.setString(3, veterinario.getCrmv());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteVeterinario(String crmv) {
        String sql = "DELETE FROM veterinarios WHERE crmv = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, crmv);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}