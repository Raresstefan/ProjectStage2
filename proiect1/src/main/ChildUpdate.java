package main;

import enums.Category;
import enums.ElvesType;

import java.util.List;
public class ChildUpdate {
    private int id;
    private Double niceScore;
    private List<Category> giftsPreferences;
    private ElvesType elf;
    /**
     * Getter for the type of elf
     */
    public ElvesType getElf() {
        return elf;
    }

    /**
     * Getter for the id
     */
    public int getId() {
        return id;
    }
    /**
     * Getter for the nice score
     */
    public Double getNiceScore() {
        return niceScore;
    }
    /**
     * Getter for the list of gift preferences
     */
    public List<Category> getGiftsPreferences() {
        return giftsPreferences;
    }
}
