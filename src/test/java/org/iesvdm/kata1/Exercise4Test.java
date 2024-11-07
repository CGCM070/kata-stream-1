

package org.iesvdm.kata1;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.abs;


public class  Exercise4Test extends PetDomainForKata
{
    @Test
    @Tag("KATA")
    public void getAgeStatisticsOfPets()
    {
        // Replace by stream of petAges
        var petAges = this.people.stream()
                .map(Person::getPets)
                .flatMap(Collection::stream)
                .map(Pet::getAge)
                .collect(Collectors.toList());

        var uniqueAges = Set.copyOf(petAges);

        var expectedSet = Set.of(1, 2, 3, 4);
        Assertions.assertEquals(expectedSet, uniqueAges);


        // IntSummaryStatistics is a class in JDK 8 use it over petAges

        /**
         Devuelve si algún elemento de este stream coincide con el predicado proporcionado.
         Puede que no evalúe el predicado en todos los elementos si no es necesario para determinar el resultado.
         Si el stream está vacío, se devuelve `false` y el predicado no se evalúa.
         Esta es una operación terminal de cortocircuito.
         Parámetros:
         - `predicate`: un predicado sin interferencias y sin estado para aplicar a los elementos de este stream.
         Devuelve:
         - `true` si algún elemento del stream coincide con el predicado proporcionado, de lo contrario `false`.
         Nota de la API:
         Este método evalúa la cuantificación existencial del predicado sobre los elementos del stream (para algún x P(x)).
         *
         */
        var stats = petAges.stream().mapToInt(Integer::intValue).summaryStatistics();
        System.out.println(stats);





        // Replace 0 by stream over petAges
        Assertions.assertEquals(stats.getMin(), 1);
        Assertions.assertEquals(stats.getMax(), 4);
        Assertions.assertEquals(stats.getSum(), 17);
        Assertions.assertEquals(stats.getAverage(), 1.8888888888888888, 0.0);
        Assertions.assertEquals(stats.getCount(), 9);


        //TODO
        // Replace by correct stream
        // All age > 0
        Assertions.assertTrue(petAges.stream().allMatch(age -> age > 0));
        //TODO
        // No one ages == 0
        Assertions.assertFalse(petAges.stream().anyMatch(age -> age == 0));
        //TODO
        // No one age < 0
        Assertions.assertTrue(petAges.stream().noneMatch(age -> age < 0));
    }

    @Test
    @Tag("KATA")
    @DisplayName("bobSmithsPetNamesAsString - 🐱 🐶")
    public void bobSmithsPetNamesAsString()
    {
        Assertions.fail("Refactor to stream. Don't forget to comment this out or delete it when you are done.");

        //TODO
        // find Bob Smith
        Person person = new Person("una", "persona");

        //TODO
        // get Bob Smith's pets' names
        String names = "";
        Assertions.assertEquals("Dolly & Spot", names);
    }

    @Test
    @Tag("KATA")
    public void immutablePetCountsByEmoji()
    {
        Assertions.fail("Refactor to stream. Don't forget to comment this out or delete it when you are done.");

        //TODO
        // Unmodificable map of counts
        Map<String, Long> countsByEmoji = new HashMap<>();

        Assertions.assertEquals(
                Map.of("🐱", 2L, "🐶", 2L, "🐹", 2L, "🐍", 1L, "🐢", 1L, "🐦", 1L),
                countsByEmoji
        );
    }

    /**
     * The purpose of this test is to determine the top 3 pet types.
     */
    @Test
    @Tag("KATA")
    @DisplayName("topThreePets - 🐱 🐶 🐹")
    public void topThreePets()
    {
        Assertions.fail("Refactor to stream. Don't forget to comment this out or delete it when you are done.");

        //TODO
        // Obtain three top pets
        var favorites = new ArrayList<>();

        Assertions.assertEquals(3, favorites.size());

        Assertions.assertTrue(favorites.contains(new AbstractMap.SimpleEntry<>(PetType.CAT, Long.valueOf(2))));
        Assertions.assertTrue(favorites.contains(new AbstractMap.SimpleEntry<>(PetType.DOG, Long.valueOf(2))));
        Assertions.assertTrue(favorites.contains(new AbstractMap.SimpleEntry<>(PetType.HAMSTER, Long.valueOf(2))));

    }

    @Test
    @Tag("KATA")
    public void getMedianOfPetAges()
    {
        Assertions.fail("Refactor to stream. Don't forget to comment this out or delete it when you are done.");

        //TODO
        // Obtain pet ages
        var petAges = new ArrayList<Integer>();

        //TODO
        // sort pet ages
        var sortedPetAges = new ArrayList<Integer>();

        double median;
        if (0 == sortedPetAges.size() % 2)
        {
            //TODO
            //
            // The median of a list of even numbers is the average of the two middle items
            median = 0.0;
        }
        else
        {
            // The median of a list of odd numbers is the middle item
            median = sortedPetAges.get(abs(sortedPetAges.size() / 2)).doubleValue();
        }

        Assertions.assertEquals(2.0, median, 0.0);
    }
}
