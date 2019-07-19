import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bv")
@Implements("ObjectSound")
public final class ObjectSound extends Node {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Ljh;"
	)
	@Export("objectSounds")
	static NodeDeque objectSounds;
	@ObfuscatedName("kt")
	@ObfuscatedGetter(
		intValue = -1438835767
	)
	@Export("menuHeight")
	static int menuHeight;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 621824935
	)
	int field1078;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1620734975
	)
	int field1083;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -1755977344
	)
	int field1090;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 75852160
	)
	int field1077;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 1222659712
	)
	int field1082;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 526073997
	)
	int field1091;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -675228961
	)
	@Export("soundEffectId")
	int soundEffectId;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Ldh;"
	)
	@Export("stream1")
	RawPcmStream stream1;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 1323025429
	)
	int field1086;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -1728328017
	)
	int field1081;
	@ObfuscatedName("u")
	@Export("soundEffectIds")
	int[] soundEffectIds;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 398204327
	)
	int field1089;
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Liy;"
	)
	@Export("obj")
	ObjectDefinition obj;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Ldh;"
	)
	@Export("stream2")
	RawPcmStream stream2;

	static {
		objectSounds = new NodeDeque();
	}

	ObjectSound() {
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2146253621"
	)
	@Export("set")
	void set() {
		int var1 = this.soundEffectId;
		ObjectDefinition var2 = this.obj.transform();
		if (var2 != null) {
			this.soundEffectId = var2.ambientSoundId;
			this.field1091 = var2.int4 * 128;
			this.field1086 = var2.int5;
			this.field1081 = var2.int6;
			this.soundEffectIds = var2.field3367;
		} else {
			this.soundEffectId = -1;
			this.field1091 = 0;
			this.field1086 = 0;
			this.field1081 = 0;
			this.soundEffectIds = null;
		}

		if (var1 != this.soundEffectId && this.stream1 != null) {
			SecureRandomCallable.pcmStreamMixer.removeSubStream(this.stream1);
			this.stream1 = null;
		}

	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(IIIS)Lcx;",
		garbageValue = "17061"
	)
	@Export("getWorldMapScript")
	static Script getWorldMapScript(int var0, int var1, int var2) {
		int var3 = (var1 << 8) + var0;
		Script var5 = class49.getWorldMapScript(var3, var0);
		if (var5 != null) {
			return var5;
		} else {
			int var4 = GraphicsDefaults.getWorldMapScriptIdCategory(var2, var0);
			var5 = class49.getWorldMapScript(var4, var0);
			return var5 != null ? var5 : null;
		}
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		signature = "(ILhv;ZB)V",
		garbageValue = "22"
	)
	static void method1824(int var0, Coord var1, boolean var2) {
		WorldMapArea var3 = WorldMapID.getWorldMap().getMapArea(var0);
		int var4 = Client.localPlayer.plane;
		int var5 = MusicPatchNode2.baseX * 64 + (Client.localPlayer.x >> 7);
		int var6 = class1.baseY * 64 + (Client.localPlayer.y >> 7);
		Coord var7 = new Coord(var4, var5, var6);
		WorldMapID.getWorldMap().method6315(var3, var7, var1, var2);
	}

	@ObfuscatedName("gu")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1435918510"
	)
	static final void method1826() {
		Client.field767 = 0;
		int var0 = MusicPatchNode2.baseX * 64 + (Client.localPlayer.x >> 7);
		int var1 = class1.baseY * 64 + (Client.localPlayer.y >> 7);
		if (var0 >= 3053 && var0 <= 3156 && var1 >= 3056 && var1 <= 3136) {
			Client.field767 = 1;
		}

		if (var0 >= 3072 && var0 <= 3118 && var1 >= 9492 && var1 <= 9535) {
			Client.field767 = 1;
		}

		if (Client.field767 == 1 && var0 >= 3139 && var0 <= 3199 && var1 >= 3008 && var1 <= 3062) {
			Client.field767 = 0;
		}

	}

	@ObfuscatedName("kf")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-472154636"
	)
	static void method1827() {
		if (PendingSpawn.field944 != null) {
			Client.field924 = Client.cycle;
			PendingSpawn.field944.method4320();

			for (int var0 = 0; var0 < Client.players.length; ++var0) {
				if (Client.players[var0] != null) {
					PendingSpawn.field944.method4316(MusicPatchNode2.baseX * 64 + (Client.players[var0].x >> 7), class1.baseY * 64 + (Client.players[var0].y >> 7));
				}
			}
		}

	}
}
