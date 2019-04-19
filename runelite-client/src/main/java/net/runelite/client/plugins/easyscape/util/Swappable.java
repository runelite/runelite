package net.runelite.client.plugins.easy.util;

import lombok.Getter;
import lombok.Setter;
import net.runelite.client.util.Text;

public class Swappable {

    @Getter
    private String target;

    @Getter
    private String optionOne;

    @Getter
    private String optionTwo;

    @Getter
    @Setter
    private int indexOne;

    @Getter
    @Setter
    private int indexTwo;

    public Swappable(String target, String optionOne, String optionTwo) {
        this.target = Text.removeTags(target.toLowerCase());
        this.optionOne = Text.removeTags(optionOne);
        this.optionTwo = Text.removeTags(optionTwo);
        this.indexOne = -1;
        this.indexTwo = -1;
    }

    public boolean isReady() {
        return this.indexOne != -1 && this.indexTwo != -1;
    }

}
