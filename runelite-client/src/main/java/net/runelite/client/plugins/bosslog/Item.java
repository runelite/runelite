package net.runelite.client.plugins.bosslog;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Item
{
    @Getter
    private final int id;
    @Getter
    private final int quantity;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private int price;
}
