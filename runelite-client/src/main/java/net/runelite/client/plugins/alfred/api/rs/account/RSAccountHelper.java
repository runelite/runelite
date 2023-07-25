package net.runelite.client.plugins.alfred.api.rs.account;

import net.runelite.api.GameState;
import net.runelite.client.config.ConfigProfile;
import net.runelite.client.plugins.alfred.Alfred;
import net.runelite.client.util.WorldUtil;
import net.runelite.http.api.worlds.World;
import net.runelite.http.api.worlds.WorldResult;

public class RSAccountHelper {

    public RSAccountHelper() {
    }

    public void login() {
        ConfigProfile profile = Alfred.getProfileManager().lock().findProfile("griffinscape@protonmail.com");
        System.out.println(profile.getPassword());
        Alfred.getKeyboard().pressEnter();
        changeWorld(326);
        Alfred.sleep(300);
        Alfred.getClient().setUsername("griffinscape@protonmail.com");
        Alfred.getClient().setPassword("VXqpUu6sVkv7eDvsyz07");
        Alfred.sleep(300);
        Alfred.getKeyboard().pressEnter();
        Alfred.sleepUntil(() -> Alfred.getClient().getGameState() == GameState.LOGGED_IN, 100, 1000 * 15);
        Alfred.sleep(500, 2000);
        Alfred.api.widgets().leftClickWidget(24772685);
        Alfred.sleep(1000);
    }

    public void changeWorld(int worldNumber) {
        WorldResult worldResult = Alfred.getWorldService().getWorlds();

        World world = worldResult.findWorld(worldNumber);
        if (world == null) {
            return;
        }

        Alfred.getClientThread().invokeOnClientThread(() -> {
            net.runelite.api.World newWorld = Alfred.getClient().createWorld();
            newWorld.setActivity(world.getActivity());
            newWorld.setAddress(world.getAddress());
            newWorld.setId(world.getId());
            newWorld.setPlayerCount(world.getPlayers());
            newWorld.setLocation(world.getLocation());
            newWorld.setTypes(WorldUtil.toWorldTypes(world.getTypes()));
            Alfred.getClient().changeWorld(newWorld);
            return null;
        });
    }
}
