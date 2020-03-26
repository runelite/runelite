import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ky")
@Implements("Friend")
public class Friend extends Buddy {
	@ObfuscatedName("rc")
	@ObfuscatedGetter(
		intValue = -1119785599
	)
	static int field3626;
	@ObfuscatedName("x")
	boolean field3625;
	@ObfuscatedName("m")
	boolean field3623;

	Friend() {
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lky;I)I",
		garbageValue = "-1645564523"
	)
	@Export("compareToFriend")
	int compareToFriend(Friend var1) {
		if (super.world == Client.worldId && Client.worldId != var1.world) {
			return -1;
		} else if (Client.worldId == var1.world && super.world != Client.worldId) {
			return 1;
		} else if (super.world != 0 && var1.world == 0) {
			return -1;
		} else if (var1.world != 0 && super.world == 0) {
			return 1;
		} else if (this.field3625 && !var1.field3625) {
			return -1;
		} else if (!this.field3625 && var1.field3625) {
			return 1;
		} else if (this.field3623 && !var1.field3623) {
			return -1;
		} else if (!this.field3623 && var1.field3623) {
			return 1;
		} else {
			return super.world != 0 ? super.int2 - var1.int2 : var1.int2 - super.int2;
		}
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		signature = "(Ljd;I)I",
		garbageValue = "-1956183743"
	)
	@Export("compareTo_user")
	public int compareTo_user(User var1) {
		return this.compareToFriend((Friend)var1);
	}

	public int compareTo(Object var1) {
		return this.compareToFriend((Friend)var1);
	}
}
