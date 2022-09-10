package net.runelite.api.packets;

import net.runelite.api.Buffer;

public interface PacketBuffer extends Buffer
{
	void setAutomated(boolean modified);

	IsaacCipher getIsaacCipher();

	boolean isAutomated();

	void consume();

	boolean isConsumed();
}
