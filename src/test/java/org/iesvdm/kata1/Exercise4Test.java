

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
        Assertions.fail("Refactor to stream. Don't forget to comment this out or delete it when you are done.");

        //TODO
        // Replace by stream of petAges
        var petAges = List.of(1);

        var uniqueAges = Set.copyOf(petAges);

        var expectedSet = Set.of(1, 2, 3, 4);
        Assertions.assertEquals(expectedSet, uniqueAges);

        //TODO
        // Replace by stream
        // IntSummaryStatistics is a class in JDK 8 use it over petAges
        var stats = new IntSummaryStatistics();
        

        //TODO
        // Replace 0 by stream over petAges
        Assertions.assertEquals(stats.getMin(), 0);
        Assertions.assertEquals(stats.getMax(), 0);
        Assertions.assertEquals(stats.getSum(), 0);
        Assertions.assertEquals(stats.getAverage(), 0.0, 0.0);
        Assertions.assertEquals(stats.getCount(), 0);



        //TODO
        // Replace by correct stream
        // All age > 0
        Assertions.assertTrue(false);
        //TODO
        // No one ages == 0
        Assertions.assertFalse(true);
        //TODO
        // No one age < 0
        Assertions.assertTrue(false);
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
