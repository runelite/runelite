import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ef")
@Implements("GameObject")
public final class GameObject {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -373728187
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 351218671
	)
	@Export("centerY")
	int centerY;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -722622461
	)
	@Export("height")
	int height;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -1130119677
	)
	@Export("centerX")
	int centerX;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lel;"
	)
	@Export("entity")
	public Entity entity;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -1883842779
	)
	@Export("orientation")
	int orientation;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -1330255505
	)
	@Export("startX")
	int startX;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -941264089
	)
	@Export("endX")
	int endX;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -2072718285
	)
	@Export("startY")
	int startY;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -1022796885
	)
	@Export("endY")
	int endY;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1238429947
	)
	int field1904;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 792454525
	)
	@Export("lastDrawn")
	int lastDrawn;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		longValue = -8257733995685858193L
	)
	@Export("tag")
	public long tag;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -1096273189
	)
	@Export("flags")
	int flags;

	GameObject() {
		this.tag = 0L;
		this.flags = 0;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lhz;Lhz;S)V",
		garbageValue = "390"
	)
	@Export("NpcDefinition_setArchives")
	public static void NpcDefinition_setArchives(AbstractArchive var0, AbstractArchive var1) {
		NPCDefinition.NpcDefinition_archive = var0;
		NPCDefinition.NpcDefinition_modelArchive = var1;
	}

	@ObfuscatedName("x")
	public static String method3262(long var0) {
		if (var0 > 0L && var0 < 6582952005840035281L) {
			if (var0 % 37L == 0L) {
				return null;
			} else {
				int var2 = 0;

				for (long var3 = var0; var3 != 0L; var3 /= 37L) {
					++var2;
				}

				StringBuilder var5 = new StringBuilder(var2);

				while (var0 != 0L) {
					long var6 = var0;
					var0 /= 37L;
					var5.append(class288.base37Table[(int)(var6 - var0 * 37L)]);
				}

				return var5.reverse().toString();
			}
		} else {
			return null;
		}
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(II)Lkc;",
		garbageValue = "143572048"
	)
	public static PrivateChatMode method3263(int var0) {
		PrivateChatMode[] var1 = Frames.ChatMode_values();

		for (int var2 = 0; var2 < var1.length; ++var2) {
			PrivateChatMode var3 = var1[var2];
			if (var0 == var3.field3787) {
				return var3;
			}
		}

		return null;
	}

	@ObfuscatedName("gz")
	@ObfuscatedSignature(
		signature = "(Lby;ZI)V",
		garbageValue = "100665877"
	)
	@Export("addPlayerToScene")
	static void addPlayerToScene(Player var0, boolean var1) {
		if (var0 != null && var0.isVisible() && !var0.isHidden) {
			var0.isUnanimated = false;
			if ((Client.isLowDetail && Players.Players_count > 50 || Players.Players_count > 200) && var1 && var0.readySequence == var0.movementSequence) {
				var0.isUnanimated = true;
			}

			int var2 = var0.x * -78439701 >> 7;
			int var3 = var0.y >> 7;
			if (var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
				long var4 = WorldMapIcon_1.calculateTag(0, 0, 0, false, var0.index);
				if (var0.model0 != null && Client.cycle >= var0.animationCycleStart && Client.cycle < var0.animationCycleEnd) {
					var0.isUnanimated = false;
					var0.tileHeight = WorldMapAreaData.getTileHeight(var0.x * -78439701, var0.y, MouseRecorder.plane);
					var0.playerCycle = Client.cycle;
					WorldMapIcon_1.scene.addNullableObject(MouseRecorder.plane, var0.x * -78439701, var0.y, var0.tileHeight, 60, var0, var0.rotation, var4, var0.field601, var0.field602, var0.field609, var0.field604);
				} else {
					if ((var0.x * -78439701 & 127) == 64 && (var0.y & 127) == 64) {
						if (Client.tileLastDrawnActor[var2][var3] == Client.viewportDrawCount) {
							return;
						}

						Client.tileLastDrawnActor[var2][var3] = Client.viewportDrawCount;
					}

					var0.tileHeight = WorldMapAreaData.getTileHeight(var0.x * -78439701, var0.y, MouseRecorder.plane);
					var0.playerCycle = Client.cycle;
					WorldMapIcon_1.scene.drawEntity(MouseRecorder.plane, var0.x * -78439701, var0.y, var0.tileHeight, 60, var0, var0.rotation, var4, var0.isWalking);
				}
			}
		}

	}
}
