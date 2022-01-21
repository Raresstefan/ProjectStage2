package main;

import enums.Cities;

import java.util.*;
import java.util.stream.Collectors;

public class NiceScoreCityAssignGiftStrategy implements AssignGiftStrategy {
    private List<ChildInput> children;

    public NiceScoreCityAssignGiftStrategy(final List<ChildInput> children) {
        this.children = children;
    }
    public List<Cities> createListOfCities() {
        List<Cities> cities = new ArrayList<>();
        for (ChildInput childInput : this.children) {
            if (!cities.contains(childInput.getCity())) {
                cities.add(childInput.getCity());
            }
        }
        return cities;
    }
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
//            Double averageScoreCity = (Double) sumAverageScore / childrenNumber;
            map.put(city, sumAverageScore / childrenNumber);
        }
        return map;
    }



    public void sortCities(final List<Cities> cities, final Map<Cities, Double> citiesScores) {
        int i, j;
        for (i = 0; i < cities.size() - 1; i++) {
            for (j = i + 1; j < cities.size(); j++) {
//                Double scoreCityI = citiesScores.get(cities.get(i));
//                Double scoreCityJ = citiesScores.get(cities.get(j));
                if (citiesScores.get(cities.get(i)).compareTo(citiesScores.get(cities.get(j))) < 0) {
                    Collections.swap(cities, i, j);
                } else if (citiesScores.get(cities.get(i)).compareTo(citiesScores.get(cities.get(j))) == 0) {
                    if (cities.get(i).toString().compareTo(cities.get(j).toString()) > 0) {
                        Collections.swap(cities, i, j);
                    }
                }
            }
        }
    }

    public void sortChildrenById(final List<ChildInput> children) {
        int i, j;
        for (i = 0; i < children.size() - 1; i++) {
            for (j = i + 1; j < children.size(); j++) {
                if (children.get(i).getId() > children.get(j).getId()) {
                    Collections.swap(children, i, j);
                }
            }
        }
    }

    public Map<Cities, List<ChildInput>> citiesAndChildren(final List<Cities> cities) {
        Map<Cities, List<ChildInput>> map = new HashMap<>();
        for (Cities city : cities) {
            List<ChildInput> children = this.children.stream().
                    filter(c -> c.getCity().equals(city)).collect(Collectors.toList());
            map.put(city, children);
        }
        return map;
    }

    public List<ChildInput> orderChildren(final List<Cities> cities, final Map<Cities, List<ChildInput>> map) {
        List<ChildInput> children = new ArrayList<>();
        for (Cities city : cities) {
            for (ChildInput childInput : map.get(city)) {
                children.add(childInput);
            }
//            children.addAll(map.get(city));
        }
        return children;
    }

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
