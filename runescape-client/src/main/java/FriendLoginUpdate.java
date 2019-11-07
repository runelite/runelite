import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jj")
@Implements("FriendLoginUpdate")
public class FriendLoginUpdate extends Link {
	@ObfuscatedName("gr")
	@ObfuscatedSignature(
		signature = "[Llx;"
	)
	@Export("headIconPkSprites")
	static Sprite[] headIconPkSprites;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1234988847
	)
	public int field3624;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lju;"
	)
	@Export("username")
	public Username username;
	@ObfuscatedName("v")
	@Export("world")
	public short world;

	@ObfuscatedSignature(
		signature = "(Lju;I)V"
	)
	FriendLoginUpdate(Username var1, int var2) {
		this.field3624 = (int)(PlayerAppearance.currentTimeMillis() / 1000L);
		this.username = var1;
		this.world = (short)var2;
	}
}
