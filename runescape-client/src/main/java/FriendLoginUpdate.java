import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jp")
@Implements("FriendLoginUpdate")
public class FriendLoginUpdate extends Link {
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 235623703
	)
	public int field3613;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Ljt;"
	)
	@Export("username")
	public Username username;
	@ObfuscatedName("l")
	@Export("world")
	public short world;

	@ObfuscatedSignature(
		signature = "(Ljt;I)V"
	)
	FriendLoginUpdate(Username var1, int var2) {
		this.field3613 = (int)(SoundCache.method2480() / 1000L);
		this.username = var1;
		this.world = (short)var2;
	}
}
