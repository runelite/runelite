package net.runelite.rs.api;

import net.runelite.api.NetWriter;
import net.runelite.mapping.Import;

public interface RSNetWriter extends NetWriter {

    @Import("serverPacket")
    @Override
    RSServerPacket currentServerPacket();

    @Import("previousSecondPacket")
    @Override
    RSServerPacket getOldPacket1();

    @Import("previousThirdPacket")
    @Override
    RSServerPacket getOldPacket2();

    @Import("previousForthPacket")
    @Override
    RSServerPacket getOldPacket3();
}
