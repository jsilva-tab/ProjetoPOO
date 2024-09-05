import java.util.ArrayList;
import java.util.List;

public class PetDAOImpl implements PetDAO {
    private List<Pet> pets = new ArrayList<>();

    @Override
    public void addPet(Pet pet) {
        pets.add(pet);
    }

    @Override
    public Pet getPetById(int id) {
        for (Pet pet : pets) {
            if (pet.getId() == id) {
                return pet;
            }
        }
        return null;
    }

    @Override
    public List<Pet> getAllPets() {
        return new ArrayList<>(pets);
    }

    @Override
    public void updatePet(Pet pet) {
        Pet existingPet = getPetById(pet.getId());
        if (existingPet != null) {
            existingPet.setNome(pet.getNome());
            existingPet.setEspecie(pet.getEspecie());
            existingPet.setRaca(pet.getRaca());
            existingPet.setIdade(pet.getIdade());
        }
    }

    @Override
    public void deletePet(int id) {
        Pet pet = getPetById(id);
        if (pet != null) {
            pets.remove(pet);
        }
    }
}