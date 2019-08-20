import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kc")
@Implements("FriendLoginUpdate")
public class FriendLoginUpdate extends Link {
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1546177207
	)
	@Export("friendUpdateTimeSecs")
	public int friendUpdateTimeSecs;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Ljv;"
	)
	@Export("username")
	public Username username;
	@ObfuscatedName("k")
	@Export("world")
	public short world;

	@ObfuscatedSignature(
		signature = "(Ljv;I)V"
	)
	FriendLoginUpdate(Username var1, int var2) {
		this.friendUpdateTimeSecs = (int)(DirectByteArrayCopier.currentTimeMs() / 1000L);
		this.username = var1;
		this.world = (short)var2;
	}
}
