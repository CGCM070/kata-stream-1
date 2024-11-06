package org.iesvdm.kata1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Exercise1Test extends PetDomainForKata {
    @Test
    @Tag("KATA")
    public void getFirstNamesOfAllPeople() {
        //TODO
        // Replace empty list firstNames with a stream transformation on people.
        List<String> firstNames = this.people.stream().map(Person::getFirstName).toList();


        var expectedFirstNames = Arrays.asList("Mary", "Bob", "Ted", "Jake", "Barry", "Terry", "Harry", "John");
        Assertions.assertIterableEquals(expectedFirstNames, firstNames);
    }

    @Test
    @Tag("KATA")
    public void getNamesOfMarySmithsPets() {
        Optional<Person> optionalPerson = this.getPersonNamed("Mary Smith");
        List<String> names = new ArrayList<>();
        if (optionalPerson.isPresent()) {
            List<Pet> pets = optionalPerson.get().getPets();

            //TODO
            names = optionalPerson.get().getPets().stream().map(Pet::getName).toList();
            names.forEach(System.out::println);
            // Replace empty list name with a stream transformation on pets
        }

//        Assertions.assertEquals("Tabby", names.get(0));
    }

    @Test
    @Tag("KATA")
    @DisplayName("getPeopleWithCats 🐱")
    public void getPeopleWithCats() {
        //TODO
        // Replace empty list with a positive filtering stream on people
        List<Person> peopleWithCats = this.people.stream()
                .filter(person -> person.getPets().stream()
                                .anyMatch(pet -> pet.getType()
                                .equals(PetType.CAT)))
                                .toList();
        var expectedFirstNames = Arrays.asList("Smith", "Smith");

        Assertions.assertEquals(expectedFirstNames, peopleWithCats.stream().map(Person::getLastName).toList());
    }

    @Test
    @Tag("KATA")
    @DisplayName("getPeopleWithoutCats 🐱")
    public void getPeopleWithoutCats() {
        //TODO
        // Replace empty list with a negative filtering stream on people
        List<Person> peopleWithoutCats = this.people.stream()
                .filter(person -> person.getPets().stream()
                                 .noneMatch(pet -> pet.getType()
                                .equals(PetType.CAT)))
                                .toList();

        var expectedFirstNames = Arrays.asList("Smith", "Snake", "Bird", "Turtle", "Hamster", "Doe");
        Assertions.assertIterableEquals(expectedFirstNames, peopleWithoutCats.stream().map(Person::getLastName).toList());
    }
}
