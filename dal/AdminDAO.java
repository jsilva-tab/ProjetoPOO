import java.util.List;

public interface AdminDAO {
    void addAdmin(Admin admin);
    Admin getAdminByLogin(String login);
    List<Admin> getAllAdmins();
    void updateAdmin(Admin admin);
    void deleteAdmin(String login);
}