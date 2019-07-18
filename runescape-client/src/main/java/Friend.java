import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("js")
@Implements("Friend")
public class Friend extends Buddy {
	@ObfuscatedName("q")
	boolean field3650;
	@ObfuscatedName("w")
	boolean field3651;

	Friend() {
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Ljs;I)I",
		garbageValue = "-1814764429"
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
		} else if (this.field3650 && !var1.field3650) {
			return -1;
		} else if (!this.field3650 && var1.field3650) {
			return 1;
		} else if (this.field3651 && !var1.field3651) {
			return -1;
		} else if (!this.field3651 && var1.field3651) {
			return 1;
		} else {
			return super.world != 0 ? super.int2 - var1.int2 : var1.int2 - super.int2;
		}
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		signature = "(Ljd;I)I",
		garbageValue = "-1938562722"
	)
	@Export("compareTo_user")
	public int compareTo_user(User var1) {
		return this.compareToFriend((Friend)var1);
	}

	public int compareTo(Object var1) {
		return this.compareToFriend((Friend)var1);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lhp;IIB)Z",
		garbageValue = "-3"
	)
	@Export("SpriteBuffer_loadSprite")
	public static boolean SpriteBuffer_loadSprite(AbstractArchive var0, int var1, int var2) {
		byte[] var3 = var0.takeFile(var1, var2);
		if (var3 == null) {
			return false;
		} else {
			class185.SpriteBuffer_decode(var3);
			return true;
		}
	}

	@ObfuscatedName("fv")
	@ObfuscatedSignature(
		signature = "(Lbq;I)V",
		garbageValue = "230469601"
	)
	static final void method5226(Actor var0) {
		if (var0.field948 != 0) {
			if (var0.targetIndex != -1) {
				Object var1 = null;
				if (var0.targetIndex < 32768) {
					var1 = Client.npcs[var0.targetIndex];
				} else if (var0.targetIndex >= 32768) {
					var1 = Client.players[var0.targetIndex - 32768];
				}

				if (var1 != null) {
					int var2 = var0.x - ((Actor)var1).x;
					int var3 = var0.y - ((Actor)var1).y;
					if (var2 != 0 || var3 != 0) {
						var0.orientation = (int)(Math.atan2((double)var2, (double)var3) * 325.949D) & 2047;
					}
				} else if (var0.false0) {
					var0.targetIndex = -1;
					var0.false0 = false;
				}
			}

			if (var0.field976 != -1 && (var0.pathLength == 0 || var0.field1007 > 0)) {
				var0.orientation = var0.field976;
				var0.field976 = -1;
			}

			int var4 = var0.orientation - var0.field950 & 2047;
			if (var4 == 0 && var0.false0) {
				var0.targetIndex = -1;
				var0.false0 = false;
			}

			if (var4 != 0) {
				++var0.field1009;
				boolean var6;
				if (var4 > 1024) {
					var0.field950 -= var0.field948;
					var6 = true;
					if (var4 < var0.field948 || var4 > 2048 - var0.field948) {
						var0.field950 = var0.orientation;
						var6 = false;
					}

					if (var0.movementSequence == var0.readySequence && (var0.field1009 > 25 || var6)) {
						if (var0.turnLeftSequence != -1) {
							var0.movementSequence = var0.turnLeftSequence;
						} else {
							var0.movementSequence = var0.walkSequence;
						}
					}
				} else {
					var0.field950 += var0.field948;
					var6 = true;
					if (var4 < var0.field948 || var4 > 2048 - var0.field948) {
						var0.field950 = var0.orientation;
						var6 = false;
					}

					if (var0.readySequence == var0.movementSequence && (var0.field1009 > 25 || var6)) {
						if (var0.turnRightSequence != -1) {
							var0.movementSequence = var0.turnRightSequence;
						} else {
							var0.movementSequence = var0.walkSequence;
						}
					}
				}

				var0.field950 &= 2047;
			} else {
				var0.field1009 = 0;
			}

		}
	}
}
