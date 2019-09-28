import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fd")
@Implements("BuddyRankComparator")
public class BuddyRankComparator extends AbstractUserComparator {
	@ObfuscatedName("z")
	@Export("reversed")
	final boolean reversed;

	public BuddyRankComparator(boolean var1) {
		this.reversed = var1;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Ljl;Ljl;I)I",
		garbageValue = "-1443378495"
	)
	@Export("compareBuddy")
	int compareBuddy(Buddy var1, Buddy var2) {
		if (var2.rank != var1.rank) {
			return this.reversed ? var1.rank - var2.rank : var2.rank - var1.rank;
		} else {
			return this.compareUser(var1, var2);
		}
	}

	public int compare(Object var1, Object var2) {
		return this.compareBuddy((Buddy)var1, (Buddy)var2);
	}

	@ObfuscatedName("hs")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "96"
	)
	@Export("getNewestMenuIdx")
	static final int getNewestMenuIdx() {
		return Client.menuOptionsCount - 1;
	}
}
