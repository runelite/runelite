import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fi")
@Implements("UserComparator5")
public class UserComparator5 extends AbstractUserComparator {
	@ObfuscatedName("ax")
	static String field1986;
	@ObfuscatedName("q")
	@Export("reversed")
	final boolean reversed;

	public UserComparator5(boolean var1) {
		this.reversed = var1;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Ljz;Ljz;I)I",
		garbageValue = "-604876330"
	)
	@Export("compareBuddy")
	int compareBuddy(Buddy var1, Buddy var2) {
		if (var1.world != 0) {
			if (var2.world == 0) {
				return this.reversed ? -1 : 1;
			}
		} else if (var2.world != 0) {
			return this.reversed ? 1 : -1;
		}

		return this.compareUser(var1, var2);
	}

	public int compare(Object var1, Object var2) {
		return this.compareBuddy((Buddy)var1, (Buddy)var2);
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)[Lhn;",
		garbageValue = "-1282154756"
	)
	@Export("PlayerType_values")
	public static PlayerType[] PlayerType_values() {
		return new PlayerType[]{PlayerType.PlayerType_playerModerator, PlayerType.PlayerType_jagexModerator, PlayerType.PlayerType_ironman, PlayerType.PlayerType_ultimateIronman, PlayerType.PlayerType_normal, PlayerType.PlayerType_hardcoreIronman};
	}

	@ObfuscatedName("iy")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "1669969690"
	)
	@Export("setTapToDrop")
	static void setTapToDrop(boolean var0) {
		Client.tapToDrop = var0;
	}
}
