package net.runelite.rs.api;

import net.runelite.api.ServerPacket;
import net.runelite.mapping.Import;

public interface RSServerPacket extends ServerPacket {
    @Import("packetId")
    @Override
    int id();

    @Import("packetLength")
    @Override
    int size();
}
