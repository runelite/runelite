package net.runelite.client.game;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.callback.ClientThread;
import net.runelite.http.api.hiscore.HiscoreClient;
import net.runelite.http.api.hiscore.HiscoreResult;

//import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


@Singleton
@Slf4j
public class HiscoreManager {

    private final Client client;
    private final ScheduledExecutorService scheduledExecutorService;
    private final ClientThread clientThread;

    private final HiscoreClient hiscoreClient = new HiscoreClient();
    private final LoadingCache<String, HiscoreResult> hiscoreLookups;

    @Inject
    public HiscoreManager(Client client, ScheduledExecutorService executor, ClientThread clientThread)
    {
        this.client = client;
        this.scheduledExecutorService = executor;
        this.clientThread = clientThread;

        hiscoreLookups = CacheBuilder.newBuilder()
                .maximumSize(128L)
                .expireAfterAccess(1, TimeUnit.HOURS)
                .build(new CacheLoader<String, HiscoreResult>()
                {
                    @Override
                    public HiscoreResult load(String username) throws Exception
                    {
                        return hiscoreClient.lookup(username);
                    }
                });
    }

    public HiscoreResult lookupUsername(String username) throws ExecutionException//, IOException
    {
        return hiscoreLookups.get(username);
    }

}
