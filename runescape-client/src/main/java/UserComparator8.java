import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("el")
@Implements("UserComparator8")
public class UserComparator8 extends AbstractUserComparator {
	@ObfuscatedName("al")
	@ObfuscatedGetter(
		intValue = 1658128897
	)
	static int field1957;
	@ObfuscatedName("dz")
	@ObfuscatedSignature(
		signature = "Lid;"
	)
	@Export("archive3")
	static Archive archive3;
	@ObfuscatedName("s")
	@Export("reversed")
	final boolean reversed;

	public UserComparator8(boolean var1) {
		this.reversed = var1;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Ljt;Ljt;S)I",
		garbageValue = "-29933"
	)
	@Export("compareBuddy")
	int compareBuddy(Buddy var1, Buddy var2) {
		if (Client.worldId == var1.world) {
			if (var2.world != Client.worldId) {
				return this.reversed ? -1 : 1;
			}
		} else if (var2.world == Client.worldId) {
			return this.reversed ? 1 : -1;
		}

		return this.compareUser(var1, var2);
	}

	public int compare(Object var1, Object var2) {
		return this.compareBuddy((Buddy)var1, (Buddy)var2);
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(CS)C",
		garbageValue = "8860"
	)
	static char method3342(char var0) {
		return var0 != 181 && var0 != 402 ? Character.toTitleCase(var0) : var0;
	}
}
