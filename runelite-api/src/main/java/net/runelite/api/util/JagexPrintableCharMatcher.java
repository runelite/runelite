package net.runelite.api.util;

import com.google.common.base.CharMatcher;

class JagexPrintableCharMatcher extends CharMatcher
{
    @Override
    public boolean matches(char c)
    {
        // Characters which are printable
        return (c >= 32 && c <= 126)
                || c == 128
                || (c >= 160 && c <= 255);
    }
}