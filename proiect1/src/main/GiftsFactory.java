package main;

import java.util.List;

public class GiftsFactory {
    /**
     * Method that chooses the specified startegy to sort the given
     * list of children for assignning the gifts
     */
    public static AssignGiftStrategy sortChildren(final String strategy,
                                                  final List<ChildInput> children) {
        if (strategy.equals("id")) {
            return new IdAssignGiftStrategy(children);
        }
        if (strategy.equals("niceScore")) {
            return new NiceScoreAssignGiftStrategy(children);
        }
        if (strategy.equals("niceScoreCity")) {
            return new NiceScoreCityAssignGiftStrategy(children);
        }
        throw new IllegalArgumentException("The strategy " + strategy + " is not recognized.");
    }
}
