import java.awt.FontMetrics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("km")
@Implements("Ignored")
public class Ignored extends User {
	@ObfuscatedName("ab")
	@Export("loginScreenFontMetrics")
	static FontMetrics loginScreenFontMetrics;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1613598915
	)
	@Export("id")
	int id;

	Ignored() {
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lkm;I)I",
		garbageValue = "105996759"
	)
	@Export("compareTo_ignored")
	int compareTo_ignored(Ignored var1) {
		return this.id - var1.id;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		signature = "(Ljd;I)I",
		garbageValue = "-1956183743"
	)
	@Export("compareTo_user")
	public int compareTo_user(User var1) {
		return this.compareTo_ignored((Ignored)var1);
	}

	public int compareTo(Object var1) {
		return this.compareTo_ignored((Ignored)var1);
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-54"
	)
	static void method5235() {
		class335.SpriteBuffer_xOffsets = null;
		StructDefinition.SpriteBuffer_yOffsets = null;
		class335.SpriteBuffer_spriteWidths = null;
		class335.SpriteBuffer_spriteHeights = null;
		DefaultsGroup.SpriteBuffer_spritePalette = null;
		class4.SpriteBuffer_pixels = null;
	}
}
