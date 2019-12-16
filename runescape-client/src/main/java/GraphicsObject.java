import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bp")
@Implements("GraphicsObject")
public final class GraphicsObject extends Entity {
	@ObfuscatedName("gp")
	@ObfuscatedSignature(
		signature = "[Lls;"
	)
	@Export("headIconPrayerSprites")
	static Sprite[] headIconPrayerSprites;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -1192844989
	)
	@Export("id")
	int id;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1714996375
	)
	@Export("cycleStart")
	int cycleStart;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Liv;"
	)
	@Export("sequenceDefinition")
	SequenceDefinition sequenceDefinition;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 1267418181
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -474548897
	)
	@Export("x")
	int x;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 60095829
	)
	@Export("y")
	int y;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 464992447
	)
	@Export("height")
	int height;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -945304711
	)
	@Export("frame")
	int frame;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 53235765
	)
	@Export("frameCycle")
	int frameCycle;
	@ObfuscatedName("d")
	@Export("isFinished")
	boolean isFinished;

	GraphicsObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		this.frame = 0;
		this.frameCycle = 0;
		this.isFinished = false;
		this.id = var1;
		this.plane = var2;
		this.x = var3;
		this.y = var4;
		this.height = var5;
		this.cycleStart = var7 + var6;
		int var8 = ClientPacket.SpotAnimationDefinition_get(this.id).sequence;
		if (var8 != -1) {
			this.isFinished = false;
			this.sequenceDefinition = WorldMapSection0.SequenceDefinition_get(var8);
		} else {
			this.isFinished = true;
		}

	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "0"
	)
	@Export("advance")
	final void advance(int var1) {
		if (!this.isFinished) {
			this.frameCycle += var1;

			while (this.frameCycle > this.sequenceDefinition.frameLengths[this.frame]) {
				this.frameCycle -= this.sequenceDefinition.frameLengths[this.frame];
				++this.frame;
				if (this.frame >= this.sequenceDefinition.frameIds.length) {
					this.isFinished = true;
					break;
				}
			}

		}
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(I)Ldw;",
		garbageValue = "822221372"
	)
	@Export("getModel")
	protected final Model getModel() {
		SpotAnimationDefinition var1 = ClientPacket.SpotAnimationDefinition_get(this.id);
		Model var2;
		if (!this.isFinished) {
			var2 = var1.getModel(this.frame);
		} else {
			var2 = var1.getModel(-1);
		}

		return var2 == null ? null : var2;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Lkl;I)V",
		garbageValue = "-2045791963"
	)
	@Export("updatePlayer")
	static final void updatePlayer(PacketBuffer var0) {
		var0.importIndex();
		int var1 = Client.localPlayerIndex;
		Player var2 = Message.localPlayer = Client.players[var1] = new Player();
		var2.index = var1;
		int var3 = var0.readBits(30);
		byte var4 = (byte)(var3 >> 28);
		int var5 = var3 >> 14 & 16383;
		int var6 = var3 & 16383;
		var2.pathX[0] = var5 - MusicPatchPcmStream.baseX * 64;
		var2.x = (var2.pathX[0] << 7) + (var2.transformedSize() << 6);
		var2.pathY[0] = var6 - ScriptEvent.baseY * 64;
		var2.y = (var2.pathY[0] << 7) + (var2.transformedSize() << 6);
		UrlRequest.Client_plane = var2.plane = var4;
		if (Players.field1228[var1] != null) {
			var2.read(Players.field1228[var1]);
		}

		Players.Players_count = 0;
		Players.Players_indices[++Players.Players_count - 1] = var1;
		Players.field1230[var1] = 0;
		Players.Players_emptyIdxCount = 0;

		for (int var7 = 1; var7 < 2048; ++var7) {
			if (var1 != var7) {
				int var8 = var0.readBits(18);
				int var9 = var8 >> 16;
				int var10 = var8 >> 8 & 597;
				int var11 = var8 & 597;
				Players.Players_regions[var7] = (var10 << 14) + var11 + (var9 << 28);
				Players.Players_orientations[var7] = 0;
				Players.Players_targetIndices[var7] = -1;
				Players.Players_emptyIndices[++Players.Players_emptyIdxCount - 1] = var7;
				Players.field1230[var7] = 0;
			}
		}

		var0.exportIndex();
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(Lkq;I)Ljava/lang/String;",
		garbageValue = "2062021922"
	)
	public static String method2028(Buffer var0) {
		return class195.method3664(var0, 32767);
	}

	@ObfuscatedName("lo")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1979767282"
	)
	static void method2030() {
		if (class215.field2534 != null) {
			Client.field749 = Client.cycle;
			class215.field2534.method4304();

			for (int var0 = 0; var0 < Client.players.length; ++var0) {
				if (Client.players[var0] != null) {
					class215.field2534.method4303(MusicPatchPcmStream.baseX * 64 + (Client.players[var0].x >> 7), ScriptEvent.baseY * 64 + (Client.players[var0].y >> 7));
				}
			}
		}

	}
}
