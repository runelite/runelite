package net.runelite.client.util;

import lombok.Data;

@Data
public class Prioritized<T>
{
    final T object;
    final int priority;
}
