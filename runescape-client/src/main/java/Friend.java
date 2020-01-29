import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jy")
@Implements("Friend")
public class Friend extends Buddy {
	@ObfuscatedName("c")
	boolean field3618;
	@ObfuscatedName("t")
	boolean field3619;

	Friend() {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Ljy;S)I",
		garbageValue = "30306"
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
		} else if (this.field3618 && !var1.field3618) {
			return -1;
		} else if (!this.field3618 && var1.field3618) {
			return 1;
		} else if (this.field3619 && !var1.field3619) {
			return -1;
		} else if (!this.field3619 && var1.field3619) {
			return 1;
		} else {
			return super.world != 0 ? super.int2 - var1.int2 : var1.int2 - super.int2;
		}
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		signature = "(Ljk;I)I",
		garbageValue = "-746331144"
	)
	@Export("compareTo_user")
	public int compareTo_user(User var1) {
		return this.compareToFriend((Friend)var1);
	}

	public int compareTo(Object var1) {
		return this.compareToFriend((Friend)var1);
	}

	@ObfuscatedName("gm")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1214522869"
	)
	@Export("getWindowedMode")
	static int getWindowedMode() {
		return Client.isResizable ? 2 : 1;
	}
}
