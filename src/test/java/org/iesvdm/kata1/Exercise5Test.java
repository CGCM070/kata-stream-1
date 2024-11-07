package org.iesvdm.kata1;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Exercise5Test extends PetDomainForKata {
    @Test
    @Tag("KATA")
    public void partitionPetAndNonPetPeople() {

        /**  partitioningBy
         * un método de la clase Collectors que se utiliza
         * para particionar los elementos de un stream en dos grupos basados en un predicado.
         * Devuelve un Collector que agrupa los elementos en un Map con claves booleanas (true o false),
         * dependiendo de si los elementos cumplen o no el predicado.
         * */

        var particion = this.people.stream()
                .collect(Collectors.partitioningBy(person -> !person.getPets().isEmpty()));

        List<Person> partitionListPetPeople = particion.get(true);
        List<Person> partitionListNotPetPeople = particion.get(false);

        Assertions.assertEquals(7, partitionListPetPeople.size());
        Assertions.assertEquals(1, partitionListNotPetPeople.size());
    }

    @Test
    @Tag("KATA")
    @DisplayName("getOldestPet - 🐶")
    public void getOldestPet() {

        // obtain the oldest pet
        Pet oldestPet = this.people.stream()
                .flatMap(person -> person.getPets().stream())
                .max(Comparator.comparing(Pet::getAge))
                .orElse(null);

        Assertions.assertEquals(PetType.DOG, oldestPet.getType());
        Assertions.assertEquals(4, oldestPet.getAge());
    }

    @Test
    @Tag("KATA")
    public void getAveragePetAge() {

        // obtain the average age of the pets
        double averagePetAge = this.people.stream()
                .flatMap(person -> person.getPets().stream())
                .mapToInt(Pet::getAge)
                .average()
                .orElse(0);
        Assertions.assertEquals(1.88888, averagePetAge, 0.00001);
    }

    @Test
    @Tag("KATA")
    public void addPetAgesToExistingSet() {



        // obtain the set of pet ages
        Set<Integer> petAges = this.people.stream()
                .flatMap(person -> person.getPets().stream())
                .map(Pet::getAge)
                .collect(Collectors.toSet());


        this.people.stream().forEach(person -> person.getPets().forEach(pet -> {
            System.out.println(pet.getAge());
        }));

        //Profe los valores de la lista son 2, 3, 2, 4, 1, 1, 1, 1, 1 , por lo qiue el set deberia ser 1, 2, 3, 4
//        var expectedSet = Set.of(1, 2, 3, 4, 5);
        var expectedSet = Set.of(1, 2, 3, 4);

        Assertions.assertEquals(expectedSet, petAges);
    }

    @Test
    @Tag("KATA")
    @DisplayName("findOwnerWithMoreThanOnePetOfTheSameType - 🐹 🐹")
    public void findOwnerWithMoreThanOnePetOfTheSameType() {
        // obtain owner with more than one pet of the same type
        Person petOwner = this.people.stream()
                .filter(person -> person.getPets().stream()
                        .collect(Collectors.groupingBy(Pet::getType, Collectors.counting()))
                        .values().stream().anyMatch(count -> count > 1))
                .findFirst()
                .orElse(new Person("Una", "Persona"));

        Assertions.assertEquals("Harry Hamster", petOwner.getFullName());


        //nombre y mascotas
//        this.people.stream().forEach(person -> {
//            System.out.println(person.getFullName());
//            person.getPets().forEach(pet -> {
//                System.out.println(pet.getType());
//            });
//        });


        String petEmojis = petOwner.getPets().stream()
                .map(pet -> pet.getType().toString())
                .collect(Collectors.joining(" "));

        // obtain the concatenation of the pet emojis of the owner
        Assertions.assertEquals("🐹 🐹", petEmojis);
    }
}
