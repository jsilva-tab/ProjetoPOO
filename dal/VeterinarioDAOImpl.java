import java.util.ArrayList;
import java.util.List;

public class VeterinarioDAOImpl implements VeterinarioDAO {
    private List<Veterinario> veterinarios = new ArrayList<>();

    @Override
    public void addVeterinario(Veterinario veterinario) {
        veterinarios.add(veterinario);
    }

    @Override
    public Veterinario getVeterinarioByCrmv(String crmv) {
        for (Veterinario veterinario : veterinarios) {
            if (veterinario.getCrmv().equals(crmv)) {
                return veterinario;
            }
        }
        return null;
    }

    @Override
    public List<Veterinario> getAllVeterinarios() {
        return new ArrayList<>(veterinarios);
    }

    @Override
    public void updateVeterinario(Veterinario veterinario) {
        Veterinario existingVeterinario = getVeterinarioByCrmv(veterinario.getCrmv());
        if (existingVeterinario != null) {
            existingVeterinario.setNome(veterinario.getNome());
            existingVeterinario.setEspecialidade(veterinario.getEspecialidade());
        }
    }

    @Override
    public void deleteVeterinario(String crmv) {
        Veterinario veterinario = getVeterinarioByCrmv(crmv);
        if (veterinario != null) {
            veterinarios.remove(veterinario);
        }
    }
}