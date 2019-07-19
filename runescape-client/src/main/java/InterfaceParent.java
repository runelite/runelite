import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bo")
@Implements("InterfaceParent")
public class InterfaceParent extends Node {
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -1594443761
	)
	@Export("group")
	int group;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -721304619
	)
	@Export("type")
	int type;
	@ObfuscatedName("e")
	boolean field567;

	InterfaceParent() {
		this.field567 = false;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "-673878359"
	)
	public static boolean method1119(int var0) {
		return (var0 & 1) != 0;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Lkx;II)V",
		garbageValue = "2052544381"
	)
	@Export("updatePlayers")
	static final void updatePlayers(PacketBuffer var0, int var1) {
		int var2 = var0.offset;
		Players.Players_pendingUpdateCount = 0;
		MouseHandler.method1037(var0);

		for (int var3 = 0; var3 < Players.Players_pendingUpdateCount; ++var3) {
			int var4 = Players.Players_pendingUpdateIndices[var3];
			Player var5 = Client.players[var4];
			int var6 = var0.readUnsignedByte();
			if ((var6 & 8) != 0) {
				var6 += var0.readUnsignedByte() << 8;
			}

			WorldMapEvent.method736(var0, var4, var5, var6);
		}

		if (var0.offset - var2 != var1) {
			throw new RuntimeException(var0.offset - var2 + " " + var1);
		}
	}
}
