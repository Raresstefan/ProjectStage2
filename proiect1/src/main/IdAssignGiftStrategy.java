package main;

import java.util.Collections;
import java.util.List;

public class IdAssignGiftStrategy implements AssignGiftStrategy {
    private List<ChildInput> children;
    public IdAssignGiftStrategy(final List<ChildInput> children) {
        this.children = children;
    }
    /**
     * Sorts the list of children by their Id
     */
    public static void sortChildrenById(final List<ChildInput> children) {
        int i, j;
        for (i = 0; i < children.size() - 1; i++) {
            for (j = i + 1; j < children.size(); j++) {
                if (children.get(i).getId() > children.get(j).getId()) {
                    Collections.swap(children, i, j);
                }
            }
        }
    }
    /**
     * Method overriden by every assignGift strategy
     * It returns a list of children in the order in which
     * santa assigns them gifts
     */
    @Override
    public List<ChildInput> sortChildren() {
        sortChildrenById(this.children);
        return this.children;
    }
}
