import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fd")
@Implements("UserComparator3")
public class UserComparator3 extends AbstractUserComparator {
	@ObfuscatedName("gp")
	@ObfuscatedSignature(
		signature = "Lls;"
	)
	@Export("redHintArrowSprite")
	static Sprite redHintArrowSprite;
	@ObfuscatedName("s")
	@Export("reversed")
	final boolean reversed;

	public UserComparator3(boolean var1) {
		this.reversed = var1;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Ljt;Ljt;I)I",
		garbageValue = "-1087585771"
	)
	@Export("compareBuddy")
	int compareBuddy(Buddy var1, Buddy var2) {
		if (var2.world != var1.world) {
			return this.reversed ? var1.world - var2.world : var2.world - var1.world;
		} else {
			return this.compareUser(var1, var2);
		}
	}

	public int compare(Object var1, Object var2) {
		return this.compareBuddy((Buddy)var1, (Buddy)var2);
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1811114805"
	)
	public static int method3371() {
		return ++MouseHandler.MouseHandler_idleCycles - 1;
	}

	@ObfuscatedName("fj")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "35"
	)
	@Export("processOverheadText")
	static final void processOverheadText() {
		int[] var0 = Players.Players_indices;

		int var1;
		for (var1 = 0; var1 < Players.Players_count; ++var1) {
			Player var2 = Client.players[var0[var1]];
			if (var2 != null && var2.overheadTextCyclesRemaining > 0) {
				--var2.overheadTextCyclesRemaining;
				if (var2.overheadTextCyclesRemaining == 0) {
					var2.overheadText = null;
				}
			}
		}

		for (var1 = 0; var1 < Client.npcCount; ++var1) {
			int var4 = Client.npcIndices[var1];
			NPC var3 = Client.npcs[var4];
			if (var3 != null && var3.overheadTextCyclesRemaining > 0) {
				--var3.overheadTextCyclesRemaining;
				if (var3.overheadTextCyclesRemaining == 0) {
					var3.overheadText = null;
				}
			}
		}

	}
}
