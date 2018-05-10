package net.runelite.client.plugins.chatcommands.killsimulator.bosses;

import net.runelite.api.Client;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.plugins.chatcommands.killsimulator.CounterList;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

public class BossHandler {

    private static final Map<String, Boss> bosses;

    static {
        bosses = new HashMap<String, Boss>();
        bosses.put("zulrah", new Zulrah());
    }

    public void simulateKills(Boss boss, int amountOfKills) {
        CounterList<String> counter = new CounterList<String>();
        for(int i = 0; i < amountOfKills; i++) {
            String drop = boss.getDrops().getRandom();
            if(drop.equals(null)) {
                continue;
            }
            counter.add(drop);
        }
        counter.forEach((drop, amount) -> {
            System.out.printf("You have recieved x%s %s", amount, drop);
        });
    }

    public static Boss getByName(String name) {
        return bosses.get(name.toLowerCase());
    }
}
