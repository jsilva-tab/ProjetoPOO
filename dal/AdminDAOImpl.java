import java.util.ArrayList;
import java.util.List;

public class AdminDAOImpl implements AdminDAO {
    private List<Admin> admins = new ArrayList<>();

    @Override
    public void addAdmin(Admin admin) {
        admins.add(admin);
    }

    @Override
    public Admin getAdminByLogin(String login) {
        for (Admin admin : admins) {
            if (admin.getLogin().equals(login)) {
                return admin;
            }
        }
        return null;
    }

    @Override
    public List<Admin> getAllAdmins() {
        return new ArrayList<>(admins);
    }

    @Override
    public void updateAdmin(Admin admin) {
        Admin existingAdmin = getAdminByLogin(admin.getLogin());
        if (existingAdmin != null) {
            existingAdmin.setSenha(admin.getSenha());
        }
    }

    @Override
    public void deleteAdmin(String login) {
        Admin admin = getAdminByLogin(login);
        if (admin != null) {
            admins.remove(admin);
        }
    }
}