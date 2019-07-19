import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eb")
@Implements("UserComparator7")
public class UserComparator7 extends AbstractUserComparator {
	@ObfuscatedName("q")
	@Export("reversed")
	final boolean reversed;

	public UserComparator7(boolean var1) {
		this.reversed = var1;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Ljz;Ljz;S)I",
		garbageValue = "10090"
	)
	@Export("compareBuddy")
	int compareBuddy(Buddy var1, Buddy var2) {
		if (var1.world != 0 && var2.world != 0) {
			return this.reversed ? var1.int2 - var2.int2 : var2.int2 - var1.int2;
		} else {
			return this.compareUser(var1, var2);
		}
	}

	public int compare(Object var1, Object var2) {
		return this.compareBuddy((Buddy)var1, (Buddy)var2);
	}
}
