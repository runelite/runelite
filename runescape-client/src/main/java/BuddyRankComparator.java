import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ed")
@Implements("BuddyRankComparator")
public class BuddyRankComparator extends AbstractUserComparator {
	@ObfuscatedName("f")
	@Export("reversed")
	final boolean reversed;

	public BuddyRankComparator(boolean var1) {
		this.reversed = var1;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Ljt;Ljt;B)I",
		garbageValue = "70"
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

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(ZB)V",
		garbageValue = "-2"
	)
	public static void method3362(boolean var0) {
		if (class297.NetCache_socket != null) {
			try {
				Buffer var1 = new Buffer(4);
				var1.writeByte(var0 ? 2 : 3);
				var1.writeMedium(0);
				class297.NetCache_socket.write(var1.array, 0, 4);
			} catch (IOException var4) {
				try {
					class297.NetCache_socket.close();
				} catch (Exception var3) {
				}

				++NetCache.NetCache_ioExceptions;
				class297.NetCache_socket = null;
			}

		}
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Lhz;Lhz;I)Z",
		garbageValue = "-1979792654"
	)
	public static boolean method3363(AbstractArchive var0, AbstractArchive var1) {
		WorldMapElement.WorldMapElement_archive = var1;
		if (!var0.isFullyLoaded()) {
			return false;
		} else {
			class180.WorldMapElement_count = var0.getGroupFileCount(35);
			WorldMapElement.WorldMapElement_cached = new WorldMapElement[class180.WorldMapElement_count];

			for (int var2 = 0; var2 < class180.WorldMapElement_count; ++var2) {
				byte[] var3 = var0.takeFile(35, var2);
				WorldMapElement.WorldMapElement_cached[var2] = new WorldMapElement(var2);
				if (var3 != null) {
					WorldMapElement.WorldMapElement_cached[var2].decode(new Buffer(var3));
					WorldMapElement.WorldMapElement_cached[var2].method4360();
				}
			}

			return true;
		}
	}

	@ObfuscatedName("gd")
	@ObfuscatedSignature(
		signature = "(Lbn;III)V",
		garbageValue = "-49955773"
	)
	@Export("performPlayerAnimation")
	static void performPlayerAnimation(Player var0, int var1, int var2) {
		if (var0.sequence == var1 && var1 != -1) {
			int var3 = WorldMapSection0.SequenceDefinition_get(var1).field3495;
			if (var3 == 1) {
				var0.sequenceFrame = 0;
				var0.sequenceFrameCycle = 0;
				var0.sequenceDelay = var2;
				var0.field958 = 0;
			}

			if (var3 == 2) {
				var0.field958 = 0;
			}
		} else if (var1 == -1 || var0.sequence == -1 || WorldMapSection0.SequenceDefinition_get(var1).field3492 >= WorldMapSection0.SequenceDefinition_get(var0.sequence).field3492) {
			var0.sequence = var1;
			var0.sequenceFrame = 0;
			var0.sequenceFrameCycle = 0;
			var0.sequenceDelay = var2;
			var0.field958 = 0;
			var0.field926 = var0.pathLength;
		}

	}

	@ObfuscatedName("jg")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "73"
	)
	static void method3361(int var0) {
		LoginType.tempMenuAction = new MenuAction();
		LoginType.tempMenuAction.param0 = Client.menuArguments1[var0];
		LoginType.tempMenuAction.param1 = Client.menuArguments2[var0];
		LoginType.tempMenuAction.opcode = Client.menuOpcodes[var0];
		LoginType.tempMenuAction.identifier = Client.menuIdentifiers[var0];
		LoginType.tempMenuAction.action = Client.menuActions[var0];
	}
}
