package main;

import java.util.List;

public interface AssignGiftStrategy {
    /**
     * Method overriden by every assignGift strategy
     * It returns a list of children in the order in which
     * santa assigns them gifts
     */
    List<ChildInput> sortChildren();
}
