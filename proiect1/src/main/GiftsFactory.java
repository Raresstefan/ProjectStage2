package main;

import java.util.List;

public class GiftsFactory {


    public static AssignGiftStrategy sortChildren(final String strategy, final List<ChildInput> children) {
        switch (strategy) {
            case "id": return new IdAssignGiftStrategy(children);
            case "niceScore": return new NiceScoreAssignGiftStrategy(children);
            case "niceScoreCity": return new NiceScoreCityAssignGiftStrategy(children);
        }
        throw new IllegalArgumentException("The strategy " + strategy + " is not recognized.");
    }
}
