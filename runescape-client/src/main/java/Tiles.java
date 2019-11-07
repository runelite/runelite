import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("bd")
@Implements("Tiles")
public final class Tiles {
	@ObfuscatedName("a")
	@Export("Tiles_heights")
	static int[][][] Tiles_heights;
	@ObfuscatedName("t")
	@Export("Tiles_renderFlags")
	static byte[][][] Tiles_renderFlags;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1836761935
	)
	@Export("Tiles_minPlane")
	static int Tiles_minPlane;
	@ObfuscatedName("v")
	static byte[][][] field485;
	@ObfuscatedName("l")
	static byte[][][] field482;
	@ObfuscatedName("c")
	static byte[][][] field483;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Llw;"
	)
	@Export("logoSprite")
	static IndexedSprite logoSprite;
	@ObfuscatedName("d")
	@Export("Tiles_hue")
	static int[] Tiles_hue;
	@ObfuscatedName("m")
	@Export("Tiles_saturation")
	static int[] Tiles_saturation;
	@ObfuscatedName("p")
	@Export("Tiles_lightness")
	static int[] Tiles_lightness;
	@ObfuscatedName("h")
	@Export("Tiles_hueMultiplier")
	static int[] Tiles_hueMultiplier;
	@ObfuscatedName("x")
	static int[][][] field488;
	@ObfuscatedName("s")
	static final int[] field489;
	@ObfuscatedName("b")
	static final int[] field490;
	@ObfuscatedName("z")
	static final int[] field491;
	@ObfuscatedName("f")
	static final int[] field498;
	@ObfuscatedName("g")
	static final int[] field493;
	@ObfuscatedName("w")
	static final int[] field494;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 1357513063
	)
	static int field495;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -1661743101
	)
	static int field496;
	@ObfuscatedName("fy")
	@ObfuscatedSignature(
		signature = "Lku;"
	)
	static AbstractSocket field499;
	@ObfuscatedName("hp")
	@ObfuscatedGetter(
		intValue = 194676221
	)
	static int field497;

	static {
		Tiles_heights = new int[4][105][105];
		Tiles_renderFlags = new byte[4][104][104];
		Tiles_minPlane = 99;
		field489 = new int[]{1, 2, 4, 8};
		field490 = new int[]{16, 32, 64, 128};
		field491 = new int[]{1, 0, -1, 0};
		field498 = new int[]{0, -1, 0, 1};
		field493 = new int[]{1, -1, -1, 1};
		field494 = new int[]{-1, -1, 1, 1};
		field495 = (int)(Math.random() * 17.0D) - 8;
		field496 = (int)(Math.random() * 33.0D) - 16;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(IB)I",
		garbageValue = "4"
	)
	@Export("iLog")
	public static int iLog(int var0) {
		int var1 = 0;
		if (var0 < 0 || var0 >= 65536) {
			var0 >>>= 16;
			var1 += 16;
		}

		if (var0 >= 256) {
			var0 >>>= 8;
			var1 += 8;
		}

		if (var0 >= 16) {
			var0 >>>= 4;
			var1 += 4;
		}

		if (var0 >= 4) {
			var0 >>>= 2;
			var1 += 2;
		}

		if (var0 >= 1) {
			var0 >>>= 1;
			++var1;
		}

		return var0 + var1;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		signature = "(ILcj;ZI)I",
		garbageValue = "-1896878651"
	)
	static int method1215(int var0, Script var1, boolean var2) {
		int var3;
		if (var0 == ScriptOpcodes.CAM_FORCEANGLE) {
			Interpreter.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			int var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			if (!Client.isCameraLocked) {
				Client.camAngleX = var3;
				Client.camAngleY = var4;
			}

			return 1;
		} else if (var0 == ScriptOpcodes.CAM_GETANGLE_XA) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.camAngleX;
			return 1;
		} else if (var0 == ScriptOpcodes.CAM_GETANGLE_YA) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.camAngleY;
			return 1;
		} else if (var0 == ScriptOpcodes.CAM_SETFOLLOWHEIGHT) {
			var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			if (var3 < 0) {
				var3 = 0;
			}

			Client.camFollowHeight = var3;
			return 1;
		} else if (var0 == ScriptOpcodes.CAM_GETFOLLOWHEIGHT) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.camFollowHeight;
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("iy")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "15"
	)
	@Export("resumePauseWidget")
	static void resumePauseWidget(int var0, int var1) {
		PacketBufferNode var2 = SoundSystem.getPacketBufferNode(ClientPacket.field2277, Client.packetWriter.isaacCipher);
		var2.packetBuffer.method5643(var1);
		var2.packetBuffer.writeIntME(var0);
		Client.packetWriter.addNode(var2);
	}
}
