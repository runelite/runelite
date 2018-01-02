package net.runelite.api;

public interface NetWriter {

    ServerPacket currentServerPacket();

    ServerPacket getOldPacket1();

    ServerPacket getOldPacket2();

    ServerPacket getOldPacket3();
}
