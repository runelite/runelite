package net.runelite.api.util;

import org.apache.commons.lang3.StringUtils;

public class Text {

    private static final StringBuilder SB = new StringBuilder(64);

    public static String removeTags(String str, boolean removeLevels)
    {
        if (removeLevels)
        {
            int levelIdx =  StringUtils.lastIndexOf(str, "  (level");
            if (levelIdx >= 0)
            {
                str = str.substring(0, levelIdx);
            }
        }

        int strLen = str.length();

        int open, close;
        if ((open = StringUtils.indexOf(str, '<')) == -1
                || (close = StringUtils.indexOf(str, '>', open)) == -1)
        {
            return strLen == str.length() ? str : str.substring(0, strLen - 1);
        }

        // If the string starts with a < we can maybe take a shortcut if this
        // is the only tag in the string (take the substring after it)
        if (open == 0)
        {
            if ((open = close + 1) >= strLen)
            {
                return "";
            }

            if ((open = StringUtils.indexOf(str, '<', open)) == -1
                    || (StringUtils.indexOf(str, '>', open)) == -1)
            {
                return StringUtils.substring(str, close + 1);
            }

            // Whoops, at least we know the last value so we can go back to where we were
            // before :)
            open = 0;
        }

        SB.setLength(0);
        int i = 0;
        do
        {
            while (open != i)
            {
                SB.append(str.charAt(i++));
            }

            i = close + 1;
        }
        while ((open = StringUtils.indexOf(str, '<', close)) != -1
                && (close = StringUtils.indexOf(str, '>', open)) != -1
                && i < strLen);

        while (i < strLen)
        {
            SB.append(str.charAt(i++));
        }

        return SB.toString();
    }

    public static String removeTags(String str)
    {
        return removeTags(str, false);
    }
}
