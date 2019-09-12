import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("bv")
@Implements("ArchiveLoader")
public class ArchiveLoader {
	@ObfuscatedName("nd")
	@ObfuscatedGetter(
		intValue = -1623387895
	)
	@Export("widgetDragDuration")
	static int widgetDragDuration;
	@ObfuscatedName("sx")
	@ObfuscatedGetter(
		intValue = -1229165351
	)
	@Export("foundItemIndex")
	static int foundItemIndex;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1875812039
	)
	static int field510;
	@ObfuscatedName("eg")
	@Export("worldHost")
	static String worldHost;
	@ObfuscatedName("fe")
	@ObfuscatedSignature(
		signature = "Lks;"
	)
	static AbstractSocket field512;
	@ObfuscatedName("go")
	@ObfuscatedGetter(
		intValue = -652150827
	)
	static int field508;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lio;"
	)
	@Export("archive")
	final Archive archive;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -1519742751
	)
	@Export("groupCount")
	final int groupCount;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 1438963135
	)
	@Export("loadedCount")
	int loadedCount;

	@ObfuscatedSignature(
		signature = "(Lio;Ljava/lang/String;)V"
	)
	ArchiveLoader(Archive var1, String var2) {
		this.loadedCount = 0;
		this.archive = var1;
		this.groupCount = var1.getGroupCount();
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-856910986"
	)
	@Export("isLoaded")
	boolean isLoaded() {
		this.loadedCount = 0;

		for (int var1 = 0; var1 < this.groupCount; ++var1) {
			if (!this.archive.method4261(var1) || this.archive.method4283(var1)) {
				++this.loadedCount;
			}
		}

		return this.loadedCount >= this.groupCount;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Lkt;II)V",
		garbageValue = "593682033"
	)
	@Export("readPlayerUpdate")
	static void readPlayerUpdate(PacketBuffer var0, int var1) {
		boolean var2 = var0.readBits(1) == 1;
		if (var2) {
			Players.Players_pendingUpdateIndices[++Players.Players_pendingUpdateCount - 1] = var1;
		}

		int var3 = var0.readBits(2);
		Player var4 = Client.players[var1];
		if (var3 == 0) {
			if (var2) {
				var4.field607 = false;
			} else if (Client.localPlayerIndex == var1) {
				throw new RuntimeException();
			} else {
				Players.Players_regions[var1] = (var4.plane << 28) + (class4.baseX * 64 + var4.pathX[0] >> 13 << 14) + (ScriptEvent.baseY + var4.pathY[0] >> 13);
				if (var4.field945 != -1) {
					Players.Players_orientations[var1] = var4.field945;
				} else {
					Players.Players_orientations[var1] = var4.orientation;
				}

				Players.Players_targetIndices[var1] = var4.targetIndex;
				Client.players[var1] = null;
				if (var0.readBits(1) != 0) {
					Message.updateExternalPlayer(var0, var1);
				}

			}
		} else {
			int var5;
			int var6;
			int var7;
			if (var3 == 1) {
				var5 = var0.readBits(3);
				var6 = var4.pathX[0];
				var7 = var4.pathY[0];
				if (var5 == 0) {
					--var6;
					--var7;
				} else if (var5 == 1) {
					--var7;
				} else if (var5 == 2) {
					++var6;
					--var7;
				} else if (var5 == 3) {
					--var6;
				} else if (var5 == 4) {
					++var6;
				} else if (var5 == 5) {
					--var6;
					++var7;
				} else if (var5 == 6) {
					++var7;
				} else if (var5 == 7) {
					++var6;
					++var7;
				}

				if (Client.localPlayerIndex == var1 && (var4.x * -78439701 < 1536 || var4.y < 1536 || var4.x * -78439701 >= 11776 || var4.y >= 11776)) {
					var4.resetPath(var6, var7);
					var4.field607 = false;
				} else if (var2) {
					var4.field607 = true;
					var4.tileX = var6;
					var4.tileY = var7;
				} else {
					var4.field607 = false;
					var4.method1189(var6, var7, Players.field1220[var1]);
				}

			} else if (var3 == 2) {
				var5 = var0.readBits(4);
				var6 = var4.pathX[0];
				var7 = var4.pathY[0];
				if (var5 == 0) {
					var6 -= 2;
					var7 -= 2;
				} else if (var5 == 1) {
					--var6;
					var7 -= 2;
				} else if (var5 == 2) {
					var7 -= 2;
				} else if (var5 == 3) {
					++var6;
					var7 -= 2;
				} else if (var5 == 4) {
					var6 += 2;
					var7 -= 2;
				} else if (var5 == 5) {
					var6 -= 2;
					--var7;
				} else if (var5 == 6) {
					var6 += 2;
					--var7;
				} else if (var5 == 7) {
					var6 -= 2;
				} else if (var5 == 8) {
					var6 += 2;
				} else if (var5 == 9) {
					var6 -= 2;
					++var7;
				} else if (var5 == 10) {
					var6 += 2;
					++var7;
				} else if (var5 == 11) {
					var6 -= 2;
					var7 += 2;
				} else if (var5 == 12) {
					--var6;
					var7 += 2;
				} else if (var5 == 13) {
					var7 += 2;
				} else if (var5 == 14) {
					++var6;
					var7 += 2;
				} else if (var5 == 15) {
					var6 += 2;
					var7 += 2;
				}

				if (Client.localPlayerIndex == var1 && (var4.x * -78439701 < 1536 || var4.y < 1536 || var4.x * -78439701 >= 11776 || var4.y >= 11776)) {
					var4.resetPath(var6, var7);
					var4.field607 = false;
				} else if (var2) {
					var4.field607 = true;
					var4.tileX = var6;
					var4.tileY = var7;
				} else {
					var4.field607 = false;
					var4.method1189(var6, var7, Players.field1220[var1]);
				}

			} else {
				var5 = var0.readBits(1);
				int var8;
				int var9;
				int var10;
				int var11;
				if (var5 == 0) {
					var6 = var0.readBits(12);
					var7 = var6 >> 10;
					var8 = var6 >> 5 & 31;
					if (var8 > 15) {
						var8 -= 32;
					}

					var9 = var6 & 31;
					if (var9 > 15) {
						var9 -= 32;
					}

					var10 = var8 + var4.pathX[0];
					var11 = var9 + var4.pathY[0];
					if (Client.localPlayerIndex == var1 && (var4.x * -78439701 < 1536 || var4.y < 1536 || var4.x * -78439701 >= 11776 || var4.y >= 11776)) {
						var4.resetPath(var10, var11);
						var4.field607 = false;
					} else if (var2) {
						var4.field607 = true;
						var4.tileX = var10;
						var4.tileY = var11;
					} else {
						var4.field607 = false;
						var4.method1189(var10, var11, Players.field1220[var1]);
					}

					var4.plane = (byte)(var7 + var4.plane & 3);
					if (Client.localPlayerIndex == var1) {
						MouseRecorder.plane = var4.plane;
					}

				} else {
					var6 = var0.readBits(30);
					var7 = var6 >> 28;
					var8 = var6 >> 14 & 16383;
					var9 = var6 & 16383;
					var10 = (class4.baseX * 64 + var8 + var4.pathX[0] & 16383) - class4.baseX * 64;
					var11 = (var9 + ScriptEvent.baseY + var4.pathY[0] & 16383) - ScriptEvent.baseY;
					if (Client.localPlayerIndex != var1 || var4.x * -78439701 >= 1536 && var4.y >= 1536 && var4.x * -78439701 < 11776 && var4.y < 11776) {
						if (var2) {
							var4.field607 = true;
							var4.tileX = var10;
							var4.tileY = var11;
						} else {
							var4.field607 = false;
							var4.method1189(var10, var11, Players.field1220[var1]);
						}
					} else {
						var4.resetPath(var10, var11);
						var4.field607 = false;
					}

					var4.plane = (byte)(var7 + var4.plane & 3);
					if (Client.localPlayerIndex == var1) {
						MouseRecorder.plane = var4.plane;
					}

				}
			}
		}
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1052068547"
	)
	static final boolean method1099() {
		return ViewportMouse.ViewportMouse_isInViewport;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(ILcu;ZB)I",
		garbageValue = "1"
	)
	static int method1096(int var0, Script var1, boolean var2) {
		Widget var3;
		if (var0 >= 2000) {
			var0 -= 1000;
			var3 = Player.getWidget(Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize]);
		} else {
			var3 = var2 ? UserComparator9.field1941 : MidiPcmStream.field2410;
		}

		if (var0 == ScriptOpcodes.CC_CALLONRESIZE) {
			if (Interpreter.field1066 >= 10) {
				throw new RuntimeException();
			} else if (var3.onResize == null) {
				return 0;
			} else {
				ScriptEvent var4 = new ScriptEvent();
				var4.widget = var3;
				var4.args = var3.onResize;
				var4.field550 = Interpreter.field1066 + 1;
				Client.scriptEvents.addFirst(var4);
				return 1;
			}
		} else {
			return 2;
		}
	}
}
