package main;

import java.util.Collections;
import java.util.List;

public class NiceScoreAssignGiftStrategy implements AssignGiftStrategy {
    List<ChildInput> children;

    public NiceScoreAssignGiftStrategy(List<ChildInput> children) {
        this.children = children;
    }

    @Override
    public List<ChildInput> sortChildren() {
        int i, j;
        for (i = 0; i < this.children.size() - 1; i++) {
            for (j = i + 1; j < this.children.size(); j++) {
                if (this.children.get(i).getAverageScore() < this.children.get(j).getAverageScore()) {
                    Collections.swap(children, i, j);
                } else if (this.children.get(i).getAverageScore().equals(this.children.get(j).getAverageScore())) {
                    if (this.children.get(i).getId() > this.children.get(j).getId()) {
                        Collections.swap(this.children, i, j);
                    }
                }
            }
        }
        return this.children;
    }
}
