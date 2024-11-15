package net.runelite.client.plugins.test;

import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.ChatMessageType;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.Set;

@PluginDescriptor(
        name = "Test NPC Death Plugin",
        description = "Detects when an NPC dies after being within 10 units of the player and sends a test chat message",
        tags = {"npc", "death", "battle", "test"}
)
public class TestNpcDeathPlugin extends Plugin
{
    @Inject
    private Client client;

    // Set to track NPCs within 10 units of the player
    private final Set<Integer> npcIdsInRenderDistance = new HashSet<>();

    // Maximum distance (in units) within which we consider NPCs as "in render"
    private static final int MAX_RENDER_DISTANCE = 10;

    @Override
    protected void startUp() throws Exception
    {
        System.out.println("Test NPC Death Plugin started.");
    }

    @Override
    protected void shutDown() throws Exception
    {
        npcIdsInRenderDistance.clear();
        System.out.println("Test NPC Death Plugin stopped.");
    }

    @Subscribe
    public void onNpcSpawned(NpcSpawned event)
    {
        NPC npc = event.getNpc();
        if (npc == null) return;

        // Check if the NPC is within the player's render distance (10 units)
        WorldPoint npcLocation = npc.getWorldLocation();
        WorldPoint playerLocation = client.getLocalPlayer().getWorldLocation();

        // Calculate the distance between the player and the NPC
        int distance = playerLocation.distanceTo(npcLocation);

        // If the NPC is within 10 units, add it to the set
        if (distance <= MAX_RENDER_DISTANCE)
        {
            npcIdsInRenderDistance.add(npc.getIndex());
            System.out.println("NPC spawned within 10 unit range: " + npc.getId());
        }

        // Log the name of the NPC
        String npcName = npc.getName() != null ? npc.getName() : "Unnamed NPC";
        client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "NPC Spawned: " + npcName, null);

        // Log the name of the local player
        if (client.getLocalPlayer() != null) {
            client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Local Player: " + client.getLocalPlayer().getName(), null);
        } else {
            client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Local Player: None", null);
        }
    }

    @Subscribe
    public void onNpcDespawned(NpcDespawned event)
    {
        NPC npc = event.getNpc();
        if (npc == null) return;

        // Check if the NPC was within 10 units of the player
        if (npcIdsInRenderDistance.contains(npc.getIndex()))
        {
            // Remove the NPC from the render distance set after it despawns
            npcIdsInRenderDistance.remove(npc.getIndex());

            // Send a "test" message to the chat when the NPC dies (or despawns)
            String message = "NPC with ID " + npc.getId() + " has died or despawned!";
            client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", message, null);
            System.out.println("NPC Dead or Despawned: " + npc.getId());
        }
    }
}