import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jj")
@Implements("FriendLoginUpdate")
public class FriendLoginUpdate extends Link {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("Widget_archive")
	static AbstractArchive Widget_archive;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 1496749481
	)
	public int field3623;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Ljc;"
	)
	@Export("username")
	public Username username;
	@ObfuscatedName("p")
	@Export("world")
	public short world;

	@ObfuscatedSignature(
		signature = "(Ljc;I)V"
	)
	FriendLoginUpdate(Username var1, int var2) {
		this.field3623 = (int)(WorldMapID.currentTimeMillis() / 1000L);
		this.username = var1;
		this.world = (short)var2;
	}

	@ObfuscatedName("f")
	static double method5301(double var0) {
		return Math.exp(var0 * -var0 / 2.0D) / Math.sqrt(6.283185307179586D);
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		signature = "(Lcz;I)V",
		garbageValue = "-651295245"
	)
	public static final void method5300(class97 var0) {
		ChatChannel.pcmPlayerProvider = var0;
	}
}
