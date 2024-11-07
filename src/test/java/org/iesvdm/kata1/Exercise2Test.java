package org.iesvdm.kata1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Exercise2Test extends PetDomainForKata
{
    @Test
    @Tag("KATA")
    @DisplayName("doAnyPeopleHaveCats 🐱?")
    public void doAnyPeopleHaveCats()
    {
        // replace null with a Predicate lambda which checks for PetType.CAT
        Predicate<Person> predicate = p -> p.getPets().stream().anyMatch(pet -> pet.getType().equals(PetType.CAT));


        // replace false by a check in a stream of people
        Assertions.assertTrue(() -> this.people.stream().anyMatch(predicate));
    }

    @Test
    @Tag("KATA")
    public void doAllPeopleHavePets()
    {

        Predicate<Person> predicate = Person::isPetPerson;

        // replace with a method call send to people that checks if all people have pets
        boolean result =   people.stream().allMatch(predicate);
        Assertions.assertFalse(result);
    }

    @Test
    @Tag("KATA")
    @DisplayName("howManyPeopleHaveCats 🐱?")
    public void howManyPeopleHaveCats()
    {

        // replace with a method call send to this.people that checks how many people have cats
        int count = 0;
        count = (int) people.stream().filter(p -> p.hasPet(PetType.CAT)).count();

        Assertions.assertEquals(2, count);
    }

    @Test
    @Tag("KATA")
    public void findMarySmith()
    {
        // replace with a stream on people to obtain Mary Smith
        Person result = new Person("", "");
        result = people.stream().filter(p -> p.named("Mary Smith")).findFirst().orElse(null);
        Assertions.assertEquals("Mary", result.getFirstName());
        Assertions.assertEquals("Smith", result.getLastName());
    }

    @Test
    @Tag("KATA")
    @DisplayName("findPetNamedSerpy 🐍")
    public void findPetNamedSerpy()
    {
        // transform this into a list of pets from people
        List<Pet> petList = new ArrayList<>();
        petList = people.stream().flatMap(p -> p.getPets().stream()).toList();
        // obtain serpySnake pet from petList

        Pet serpySnake = new Pet(PetType.BIRD,"", 0);
        serpySnake = petList.stream().filter(p -> p.getName().equals("Serpy")).findFirst().orElse(null);

        Assertions.assertEquals("🐍",serpySnake.getType().toString());
    }

    @Test
    @Tag("KATA")
    public void getPeopleWithPets()
    {
        // replace with only the pet owners
        List<Person> petPeople = new ArrayList<>();
        petPeople = people.stream().filter(Person::isPetPerson).toList();

        Assertions.assertEquals(7, petPeople.size());
    }

    @Test
    @Tag("KATA")
    public void getAllPetTypesOfAllPeople()
    {
        Function<Person, Map<PetType, Long>> function = Person::getPetTypes;
        // use the previous function to obtain the set of pet type

        Set<PetType> petTypes = new HashSet<>();
        petTypes = people.stream().flatMap(p -> p.getPets().stream()).map(Pet::getType).collect(Collectors.toSet());

        var expectedSet = Set.of(PetType.CAT, PetType.DOG, PetType.TURTLE, PetType.HAMSTER, PetType.BIRD, PetType.SNAKE);
        Assertions.assertEquals(expectedSet, petTypes);
    }

    @Test
    @Tag("KATA")
    public void getAllPetEmojisOfAllPeople()
    {
        Function<Person, Map<String, Long>> function = Person::getPetEmojis;
        // use the previous function to obtain the set of emojis
        Set<String> petEmojis = new HashSet<>();
        function.apply(people.get(0)).keySet().forEach(petEmojis::add);

        petEmojis = people.stream().flatMap(p -> p.getPetEmojis().keySet().stream()).collect(Collectors.toSet());
//        petEmojis.forEach(System.out::println);
        var expected = Set.of("🐱", "🐶", "🐢", "🐹", "🐦", "🐍");
        Assertions.assertEquals(expected, petEmojis);
    }

    @Test
    @Tag("KATA")
    public void getFirstNamesOfAllPeople()
    {

        // transform this.people into a list of first names
        List<String> firstNames = new ArrayList<>();
        firstNames = people.stream().map(Person::getFirstName).toList();
        var expectedList = List.of("Mary", "Bob", "Ted", "Jake", "Barry", "Terry", "Harry", "John");
        Assertions.assertEquals(expectedList, firstNames);
    }

    @Test
    @Tag("KATA")
    @DisplayName("doAnyPeopleHaveCatsRefactor 🐱?")
    public void doAnyPeopleHaveCatsRefactor()
    {

        // test with a stream on people, if anyone has a cat at least
        boolean peopleHaveCatsLambda = false;
        peopleHaveCatsLambda = people.stream().anyMatch(p -> p.hasPet(PetType.CAT));
        Assertions.assertTrue(peopleHaveCatsLambda);

    }

    @Test
    @Tag("KATA")
    @DisplayName("doAllPeopleHaveCatsRefactor 🐱?")
    public void doAllPeopleHaveCatsRefactor()
    {

        // test if all the people have cats
        boolean peopleHaveCats = true;
        peopleHaveCats = people.stream().allMatch(p -> p.hasPet(PetType.CAT));

        Assertions.assertFalse(peopleHaveCats);
    }

    @Test
    @Tag("KATA")
    @DisplayName("getPeopleWithCatsRefactor 🐱?")
    public void getPeopleWithCatsRefactor()
    {
        // obtain persons with cats
        List<Person> peopleWithCats = new ArrayList<>();
        peopleWithCats = people.stream().filter(p -> p.hasPet(PetType.CAT)).toList();
        Assertions.assertEquals(2, peopleWithCats.size());
    }

    @Test
    @Tag("KATA")
    @DisplayName("getPeopleWithoutCatsRefactor 🐱?")
    public void getPeopleWithoutCatsRefactor()
    {
        // obtain persons without cats
        List<Person> peopleWithoutCats = new ArrayList<>();
        peopleWithoutCats = people.stream().filter(p -> !p.hasPet(PetType.CAT)).toList();

        Assertions.assertEquals(6, peopleWithoutCats.size());
    }
}
