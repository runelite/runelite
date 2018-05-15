package net.runelite.client.plugins.chatcommands.killsimulator;

import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class BossHandler {

    private final Map<String, Boss> bosses;

    public BossHandler() {
        bosses = new HashMap<String, Boss>();
        try {
            for(Method m : Boss.class.getMethods()) {
                if(m.getReturnType().equals(Boss.class)) {
                    Boss boss = (Boss) m.invoke(null);
                    for(String name : boss.getNames()) {
                        bosses.put(name, boss);
                    }
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void simulateKills(Client client, String bossName, int amountOfKills) {
        Boss boss = bosses.get(bossName.toLowerCase());
        if(boss == null) {
            client.addChatMessage(ChatMessageType.SERVER, "", "I'm afraid we don't have the boss " + bossName + " yet!", null);
            return;
        }
        if(amountOfKills < 1) {
            client.addChatMessage(ChatMessageType.SERVER, "", "The amount of kills should be greater than 0!", null);
            return;
        }
        client.addChatMessage(ChatMessageType.SERVER, "", String.format("Here's the loot from killing x%s %s!", amountOfKills, bossName), null);
        CounterList<String> counter = new CounterList<String>();
        for(int i = 0; i < amountOfKills; i++) {
            String drop = boss.getDrops().getRandom();
            counter.add(drop);
        }
        counter.forEach((drop, amount) -> {
            client.addChatMessage(ChatMessageType.SERVER, "", String.format("You have recieved x%s %s", amount, drop), null);
        });
    }
}
