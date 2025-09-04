package com.bankorganizer;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class CategoryParser
{
    public static List<CategoryRule> parse(String configString)
    {
        List<CategoryRule> rules = new ArrayList<>();
        if (configString == null || configString.isEmpty())
        {
            return rules;
        }

        // Split categories by comma
        String[] parts = configString.split(",");
        for (String part : parts)
        {
            String[] fields = part.split("\\|");
            if (fields.length == 3)
            {
                try
                {
                    String name = fields[0].trim();
                    String pattern = fields[1].trim();
                    Color color = Color.decode(fields[2].trim());
                    rules.add(new CategoryRule(name, pattern, color));
                }
                catch (NumberFormatException ignored)
                {
                    // skip invalid color codes
                }
            }
        }
        return rules;
    }
}
