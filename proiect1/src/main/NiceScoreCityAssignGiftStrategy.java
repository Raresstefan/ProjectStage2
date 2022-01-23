package main;

import enums.Cities;

import java.util.*;
import java.util.stream.Collectors;

public class NiceScoreCityAssignGiftStrategy implements AssignGiftStrategy {
    private List<ChildInput> children;

    public NiceScoreCityAssignGiftStrategy(final List<ChildInput> children) {
        this.children = children;
    }
    /**
     * Creates a list with all the cities of all
     * the children
     */
    public List<Cities> createListOfCities() {
        List<Cities> cities = new ArrayList<>();
        for (ChildInput childInput : this.children) {
            if (!cities.contains(childInput.getCity())) {
                cities.add(childInput.getCity());
            }
        }
        return cities;
    }
    /**
     * Creates a map in which we store the city and it's
     * calculated average score
     */
    public Map<Cities, Double> calcAverageScoreCities(final List<Cities> cities) {
        Map<Cities, Double> map = new HashMap<>();
        for (Cities city : cities) {
            Double sumAverageScore = 0.0;
            int childrenNumber = 0;
            for (ChildInput childInput : this.children) {
                if (childInput.getCity().equals(city)) {
                    sumAverageScore += childInput.getAverageScore();
                    childrenNumber++;
                }
            }
            map.put(city, sumAverageScore / childrenNumber);
        }
        return map;
    }
    /**
     * Sorts the list of cities by their average scores
     * If they have the same average score, sorts them in
     * lexicographical order
     */
    public void sortCities(final List<Cities> cities, final Map<Cities, Double> citiesScores) {
        int i, j;
        for (i = 0; i < cities.size() - 1; i++) {
            for (j = i + 1; j < cities.size(); j++) {
                if (citiesScores.get(cities.get(i)).
                        compareTo(citiesScores.get(cities.get(j))) < 0) {
                    Collections.swap(cities, i, j);
                } else if (citiesScores.get(cities.get(i)).
                        compareTo(citiesScores.get(cities.get(j))) == 0) {
                    if (cities.get(i).toString().compareTo(cities.get(j).toString()) > 0) {
                        Collections.swap(cities, i, j);
                    }
                }
            }
        }
    }
    /**
     * Creates a map in which we store the city and the list of
     * children that live in that city
     */
    public Map<Cities, List<ChildInput>> citiesAndChildren(final List<Cities> cities) {
        Map<Cities, List<ChildInput>> map = new HashMap<>();
        for (Cities city : cities) {
            List<ChildInput> children = this.children.stream().
                    filter(c -> c.getCity().equals(city)).collect(Collectors.toList());
            map.put(city, children);
        }
        return map;
    }
    /**
     * Creates a list where we store the order of the children
     * for whom santa assigns the gifts
     */
    public List<ChildInput> orderChildren(final List<Cities> cities,
                                          final Map<Cities, List<ChildInput>> map) {
        List<ChildInput> children = new ArrayList<>();
        for (Cities city : cities) {
            for (ChildInput childInput : map.get(city)) {
                children.add(childInput);
            }
        }
        return children;
    }
    /**
     * Method overriden by every assignGift strategy
     * It returns a list of children in the order in which
     * santa assigns them gifts
     */
    @Override
    public List<ChildInput> sortChildren() {
        List<Cities> cities = createListOfCities();
        Map<Cities, Double> citiesAndScores = calcAverageScoreCities(cities);
        sortCities(cities, citiesAndScores);
        Map<Cities, List<ChildInput>> citiesChildren = citiesAndChildren(cities);
        List<ChildInput> orderedChildren = orderChildren(cities, citiesChildren);
        return orderedChildren;
    }
}
