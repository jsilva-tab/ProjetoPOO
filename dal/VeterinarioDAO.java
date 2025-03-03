import java.util.List;

public interface VeterinarioDAO {
    void addVeterinario(Veterinario veterinario);
    Veterinario getVeterinarioByCrmv(String crmv);
    List<Veterinario> getAllVeterinarios();
    void updateVeterinario(Veterinario veterinario);
    void deleteVeterinario(String crmv);
}