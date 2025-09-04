package com.bankorganizer;

import java.awt.Color;

public class CategoryRule
{
    public final String name;
    public final String pattern;
    public final Color color;

    public CategoryRule(String name, String pattern, Color color)
    {
        this.name = name;
        this.pattern = pattern.toLowerCase();
        this.color = color;
    }

    public boolean matches(String itemName)
    {
        return itemName != null && itemName.toLowerCase().contains(pattern);
    }
}
