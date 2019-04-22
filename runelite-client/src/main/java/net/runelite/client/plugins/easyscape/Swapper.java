package net.runelite.client.plugins.easyscape;

import lombok.Getter;
import lombok.Setter;

public class Swapper {

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

    public Swapper(String target, String optionOne, String optionTwo) {
        this.target = target;
        this.optionOne = optionOne;
        this.optionTwo = optionTwo;
        this.indexOne = -1;
        this.indexTwo = -1;
    }

    public boolean isReady() {
        return this.indexOne != -1 && this.indexTwo != -1;
    }
}
