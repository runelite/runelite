import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("h")
@Implements("WorldMapSectionType")
public enum WorldMapSectionType implements Enumerated {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lh;"
	)
	@Export("WORLDMAPSECTIONTYPE0")
	WORLDMAPSECTIONTYPE0(1, (byte)0),
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lh;"
	)
	@Export("WORLDMAPSECTIONTYPE1")
	WORLDMAPSECTIONTYPE1(2, (byte)1),
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lh;"
	)
	@Export("WORLDMAPSECTIONTYPE2")
	WORLDMAPSECTIONTYPE2(0, (byte)2),
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lh;"
	)
	@Export("WORLDMAPSECTIONTYPE3")
	WORLDMAPSECTIONTYPE3(3, (byte)3);

	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 1941114483
	)
	@Export("type")
	final int type;
	@ObfuscatedName("l")
	@Export("id")
	final byte id;

	WorldMapSectionType(int var3, byte var4) {
		this.type = var3;
		this.id = var4;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "320353268"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Lkx;B)V",
		garbageValue = "-61"
	)
	@Export("updatePlayer")
	static final void updatePlayer(PacketBuffer var0) {
		var0.importIndex();
		int var1 = Client.localPlayerIndex;
		Player var2 = Client.localPlayer = Client.players[var1] = new Player();
		var2.index = var1;
		int var3 = var0.readBits(30);
		byte var4 = (byte)(var3 >> 28);
		int var5 = var3 >> 14 & 16383;
		int var6 = var3 & 16383;
		var2.pathX[0] = var5 - MusicPatchNode2.baseX * 64;
		var2.x = (var2.pathX[0] << 7) + (var2.transformedSize() << 6);
		var2.pathY[0] = var6 - class1.baseY * 64;
		var2.y = (var2.pathY[0] << 7) + (var2.transformedSize() << 6);
		class42.plane = var2.plane = var4;
		if (Players.field1254[var1] != null) {
			var2.read(Players.field1254[var1]);
		}

		Players.Players_count = 0;
		Players.Players_indices[++Players.Players_count - 1] = var1;
		Players.field1252[var1] = 0;
		Players.Players_emptyIdxCount = 0;

		for (int var7 = 1; var7 < 2048; ++var7) {
			if (var7 != var1) {
				int var8 = var0.readBits(18);
				int var9 = var8 >> 16;
				int var10 = var8 >> 8 & 597;
				int var11 = var8 & 597;
				Players.Players_regions[var7] = (var10 << 14) + var11 + (var9 << 28);
				Players.Players_orientations[var7] = 0;
				Players.Players_targetIndices[var7] = -1;
				Players.Players_emptyIndices[++Players.Players_emptyIdxCount - 1] = var7;
				Players.field1252[var7] = 0;
			}
		}

		var0.exportIndex();
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		signature = "(ILcx;ZB)I",
		garbageValue = "1"
	)
	static int method239(int var0, Script var1, boolean var2) {
		int var3;
		if (var0 == ScriptOpcodes.CAM_FORCEANGLE) {
			HealthBarUpdate.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize];
			int var4 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1];
			if (!Client.isCameraLocked) {
				Client.camAngleX = var3;
				Client.camAngleY = var4;
			}

			return 1;
		} else if (var0 == ScriptOpcodes.CAM_GETANGLE_XA) {
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = Client.camAngleX;
			return 1;
		} else if (var0 == ScriptOpcodes.CAM_GETANGLE_YA) {
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = Client.camAngleY;
			return 1;
		} else if (var0 == ScriptOpcodes.CAM_SETFOLLOWHEIGHT) {
			var3 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
			if (var3 < 0) {
				var3 = 0;
			}

			Client.camFollowHeight = var3;
			return 1;
		} else if (var0 == ScriptOpcodes.CAM_GETFOLLOWHEIGHT) {
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = Client.camFollowHeight;
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		signature = "(ILcx;ZI)I",
		garbageValue = "-292172071"
	)
	static int method242(int var0, Script var1, boolean var2) {
		if (var0 == ScriptOpcodes.VIEWPORT_SETFOV) {
			HealthBarUpdate.Interpreter_intStackSize -= 2;
			Client.field782 = (short)ItemContainer.method1116(Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize]);
			if (Client.field782 <= 0) {
				Client.field782 = 256;
			}

			Client.field651 = (short)ItemContainer.method1116(Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1]);
			if (Client.field651 <= 0) {
				Client.field651 = 256;
			}

			return 1;
		} else if (var0 == ScriptOpcodes.VIEWPORT_SETZOOM) {
			HealthBarUpdate.Interpreter_intStackSize -= 2;
			Client.field906 = (short)Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize];
			if (Client.field906 <= 0) {
				Client.field906 = 256;
			}

			Client.field908 = (short)Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1];
			if (Client.field908 <= 0) {
				Client.field908 = 320;
			}

			return 1;
		} else if (var0 == ScriptOpcodes.VIEWPORT_CLAMPFOV) {
			HealthBarUpdate.Interpreter_intStackSize -= 4;
			Client.field820 = (short)Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize];
			if (Client.field820 <= 0) {
				Client.field820 = 1;
			}

			Client.field790 = (short)Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1];
			if (Client.field790 <= 0) {
				Client.field790 = 32767;
			} else if (Client.field790 < Client.field820) {
				Client.field790 = Client.field820;
			}

			Client.field732 = (short)Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 2];
			if (Client.field732 <= 0) {
				Client.field732 = 1;
			}

			Client.field659 = (short)Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 3];
			if (Client.field659 <= 0) {
				Client.field659 = 32767;
			} else if (Client.field659 < Client.field732) {
				Client.field659 = Client.field732;
			}

			return 1;
		} else if (var0 == ScriptOpcodes.VIEWPORT_GETEFFECTIVESIZE) {
			if (Client.viewportWidget != null) {
				UrlRequest.setViewportShape(0, 0, Client.viewportWidget.width, Client.viewportWidget.height, false);
				Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = Client.viewportWidth;
				Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = Client.viewportHeight;
			} else {
				Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = -1;
				Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = -1;
			}

			return 1;
		} else if (var0 == ScriptOpcodes.VIEWPORT_GETZOOM) {
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = Client.field906;
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = Client.field908;
			return 1;
		} else if (var0 == ScriptOpcodes.VIEWPORT_GETFOV) {
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = NetFileRequest.method4140(Client.field782);
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = NetFileRequest.method4140(Client.field651);
			return 1;
		} else {
			return 2;
		}
	}
}
