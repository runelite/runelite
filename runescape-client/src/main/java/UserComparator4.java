import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("en")
@Implements("UserComparator4")
public class UserComparator4 implements Comparator {
	@ObfuscatedName("u")
	@Export("reversed")
	final boolean reversed;

	public UserComparator4(boolean var1) {
		this.reversed = var1;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Ljt;Ljt;I)I",
		garbageValue = "-955614748"
	)
	@Export("compare_bridged")
	int compare_bridged(Buddy var1, Buddy var2) {
		return this.reversed ? var1.int2 - var2.int2 : var2.int2 - var1.int2;
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	public int compare(Object var1, Object var2) {
		return this.compare_bridged((Buddy)var1, (Buddy)var2);
	}
}
