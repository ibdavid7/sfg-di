package guru.springframework.pets;

public interface BasePetServiceFactory {
    PetService getPetService(String petType);

}
