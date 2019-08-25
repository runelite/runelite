import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ea")
@Implements("UserComparator4")
public class UserComparator4 implements Comparator {
	@ObfuscatedName("db")
	@ObfuscatedSignature(
		signature = "Liu;"
	)
	@Export("archive12")
	static Archive archive12;
	@ObfuscatedName("ga")
	@ObfuscatedSignature(
		signature = "Lly;"
	)
	@Export("redHintArrowSprite")
	static Sprite redHintArrowSprite;
	@ObfuscatedName("q")
	@Export("reversed")
	final boolean reversed;

	public UserComparator4(boolean var1) {
		this.reversed = var1;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Ljz;Ljz;I)I",
		garbageValue = "2005097552"
	)
	@Export("compare_bridged")
	int compare_bridged(Buddy var1, Buddy var2) {
		return this.reversed ? var1.int2 - var2.int2 : var2.int2 - var1.int2;
	}

	public int compare(Object var1, Object var2) {
		return this.compare_bridged((Buddy)var1, (Buddy)var2);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "1492423821"
	)
	public static boolean method3382(int var0) {
		return (var0 >> 29 & 1) != 0;
	}
}
