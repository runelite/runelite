package net.runelite.client;

import com.google.common.base.Strings;
import okhttp3.HttpUrl;

import javax.inject.Named;

public class RuneLiteHttpUrlProvider {

    static HttpUrl provideApiBase(@Named("runelite.api.base") String s)
    {
        final String prop = System.getProperty("runelite.http-service.url");
        return HttpUrl.get(Strings.isNullOrEmpty(prop) ? s : prop);
    }

    static HttpUrl provideSession(@Named("runelite.session") String s)
    {
        final String prop = System.getProperty("runelite.session.url");
        return HttpUrl.get(Strings.isNullOrEmpty(prop) ? s : prop);
    }

    static HttpUrl provideStaticBase(@Named("runelite.static.base") String s)
    {
        final String prop = System.getProperty("runelite.static.url");
        return HttpUrl.get(Strings.isNullOrEmpty(prop) ? s : prop);
    }

    static HttpUrl provideWs(@Named("runelite.ws") String s)
    {
        final String prop = System.getProperty("runelite.ws.url");
        return HttpUrl.get(Strings.isNullOrEmpty(prop) ? s : prop);
    }
}
