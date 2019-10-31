import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jf")
@Implements("Friend")
public class Friend extends Buddy {
	@ObfuscatedName("a")
	boolean field3613;
	@ObfuscatedName("t")
	boolean field3611;

	Friend() {
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Ljf;I)I",
		garbageValue = "-1251947576"
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
		} else if (this.field3613 && !var1.field3613) {
			return -1;
		} else if (!this.field3613 && var1.field3613) {
			return 1;
		} else if (this.field3611 && !var1.field3611) {
			return -1;
		} else if (!this.field3611 && var1.field3611) {
			return 1;
		} else {
			return super.world != 0 ? super.int2 - var1.int2 : var1.int2 - super.int2;
		}
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		signature = "(Ljg;I)I",
		garbageValue = "105019827"
	)
	@Export("compareTo_user")
	public int compareTo_user(User var1) {
		return this.compareToFriend((Friend)var1);
	}

	public int compareTo(Object var1) {
		return this.compareToFriend((Friend)var1);
	}
}
