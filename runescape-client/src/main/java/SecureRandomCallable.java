import java.util.concurrent.Callable;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bi")
@Implements("SecureRandomCallable")
public class SecureRandomCallable implements Callable {
	@ObfuscatedName("ey")
	@ObfuscatedSignature(
		signature = "Lia;"
	)
	@Export("archive20")
	static Archive archive20;
	@ObfuscatedName("fd")
	@ObfuscatedGetter(
		intValue = 696755763
	)
	static int field530;
	@ObfuscatedName("gq")
	@ObfuscatedGetter(
		intValue = 1829192953
	)
	static int field531;
	@ObfuscatedName("gd")
	@ObfuscatedSignature(
		signature = "[Llt;"
	)
	@Export("headIconHintSprites")
	static Sprite[] headIconHintSprites;
	@ObfuscatedName("kk")
	@ObfuscatedGetter(
		intValue = -821699027
	)
	@Export("menuY")
	static int menuY;

	SecureRandomCallable() {
	}

	public Object call() {
		return class51.method896();
	}
}
