import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ki")
@Implements("FriendLoginUpdate")
public class FriendLoginUpdate extends Link {
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 1923420853
	)
	public int field3636;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lku;"
	)
	@Export("username")
	public Username username;
	@ObfuscatedName("w")
	@Export("world")
	public short world;

	@ObfuscatedSignature(
		signature = "(Lku;I)V"
	)
	FriendLoginUpdate(Username var1, int var2) {
		this.field3636 = (int)(class217.currentTimeMillis() / 1000L);
		this.username = var1;
		this.world = (short)var2;
	}
}
