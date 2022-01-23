package main;

import enums.AgeCategory;

import java.util.List;

public class ChildFactory {
    /**
     * Method that returns a specific type of child
     * based on the category received as a parameter
     */
    public static AverageScoreStrategy createChild(final AgeCategory ageCategory,
                                                   final List<Double> scores) {
        if (ageCategory.equals(AgeCategory.BABY)) {
            return new BabyAverageScoreStrategy(scores);
        }
        if (ageCategory.equals(AgeCategory.KID)) {
            return new KidAverageScoreStrategy(scores);
        }
        if (ageCategory.equals(AgeCategory.TEEN)) {
            return new TeenAverageScoreStrategy(scores);
        }
        if (ageCategory.equals(AgeCategory.YOUNGADULT)) {
            return new YoungAdultStrategy(scores);
        }
        throw new IllegalArgumentException("The age category "
                +
                ageCategory + " is not recognized.");
    }
}
