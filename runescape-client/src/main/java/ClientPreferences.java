import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bj")
@Implements("ClientPreferences")
public class ClientPreferences {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 1562806739
	)
	@Export("ClientPreferences_optionCount")
	static int ClientPreferences_optionCount;
	@ObfuscatedName("fb")
	@ObfuscatedSignature(
		signature = "Lkr;"
	)
	static AbstractSocket field1052;
	@ObfuscatedName("o")
	@Export("roofsHidden")
	boolean roofsHidden;
	@ObfuscatedName("e")
	@Export("titleMusicDisabled")
	boolean titleMusicDisabled;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -122570971
	)
	@Export("windowMode")
	int windowMode;
	@ObfuscatedName("g")
	@Export("rememberedUsername")
	String rememberedUsername;
	@ObfuscatedName("d")
	@Export("hideUsername")
	boolean hideUsername;
	@ObfuscatedName("l")
	@Export("parameters")
	LinkedHashMap parameters;

	static {
		ClientPreferences_optionCount = 6;
	}

	ClientPreferences() {
		this.windowMode = 1;
		this.rememberedUsername = null;
		this.hideUsername = false;
		this.parameters = new LinkedHashMap();
		this.method1849(true);
	}

	@ObfuscatedSignature(
		signature = "(Lkp;)V"
	)
	ClientPreferences(Buffer var1) {
		this.windowMode = 1;
		this.rememberedUsername = null;
		this.hideUsername = false;
		this.parameters = new LinkedHashMap();
		if (var1 != null && var1.array != null) {
			int var2 = var1.readUnsignedByte();
			if (var2 >= 0 && var2 <= ClientPreferences_optionCount) {
				if (var1.readUnsignedByte() == 1) {
					this.roofsHidden = true;
				}

				if (var2 > 1) {
					this.titleMusicDisabled = var1.readUnsignedByte() == 1;
				}

				if (var2 > 3) {
					this.windowMode = var1.readUnsignedByte();
				}

				if (var2 > 2) {
					int var3 = var1.readUnsignedByte();

					for (int var4 = 0; var4 < var3; ++var4) {
						int var5 = var1.readInt();
						int var6 = var1.readInt();
						this.parameters.put(var5, var6);
					}
				}

				if (var2 > 4) {
					this.rememberedUsername = var1.readStringCp1252NullTerminatedOrNull();
				}

				if (var2 > 5) {
					this.hideUsername = var1.readBoolean();
				}
			} else {
				this.method1849(true);
			}
		} else {
			this.method1849(true);
		}

	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "1265192708"
	)
	void method1849(boolean var1) {
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)Lkp;",
		garbageValue = "-1961223036"
	)
	@Export("toBuffer")
	Buffer toBuffer() {
		Buffer var1 = new Buffer(100);
		var1.writeByte(ClientPreferences_optionCount);
		var1.writeByte(this.roofsHidden ? 1 : 0);
		var1.writeByte(this.titleMusicDisabled ? 1 : 0);
		var1.writeByte(this.windowMode);
		var1.writeByte(this.parameters.size());
		Iterator var2 = this.parameters.entrySet().iterator();

		while (var2.hasNext()) {
			Entry var3 = (Entry)var2.next();
			var1.writeInt((Integer)var3.getKey());
			var1.writeInt((Integer)var3.getValue());
		}

		var1.writeStringCp1252NullTerminated(this.rememberedUsername != null ? this.rememberedUsername : "");
		var1.writeBoolean(this.hideUsername);
		return var1;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)[Llf;",
		garbageValue = "-1068264717"
	)
	@Export("FillMode_values")
	public static FillMode[] FillMode_values() {
		return new FillMode[]{FillMode.field3858, FillMode.SOLID, FillMode.field3854};
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;Ljava/lang/String;I)V",
		garbageValue = "-756119302"
	)
	@Export("addGameMessage")
	static void addGameMessage(int var0, String var1, String var2) {
		class173.addChatMessage(var0, var1, var2, (String)null);
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1958479056"
	)
	public static void method1854() {
		while (true) {
			ArchiveDiskAction var0;
			synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
				var0 = (ArchiveDiskAction)ArchiveDiskActionHandler.ArchiveDiskActionHandler_responseQueue.removeLast();
			}

			if (var0 == null) {
				return;
			}

			var0.archive.load(var0.archiveDisk, (int)var0.key, var0.data, false);
		}
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "([BIIIIIII[Lfv;I)V",
		garbageValue = "-1733201175"
	)
	static final void method1853(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, CollisionMap[] var8) {
		int var10;
		for (int var9 = 0; var9 < 8; ++var9) {
			for (var10 = 0; var10 < 8; ++var10) {
				if (var9 + var2 > 0 && var9 + var2 < 103 && var3 + var10 > 0 && var3 + var10 < 103) {
					int[] var10000 = var8[var1].flags[var9 + var2];
					var10000[var10 + var3] &= -16777217;
				}
			}
		}

		Buffer var13 = new Buffer(var0);

		for (var10 = 0; var10 < 4; ++var10) {
			for (int var11 = 0; var11 < 64; ++var11) {
				for (int var12 = 0; var12 < 64; ++var12) {
					if (var10 == var4 && var11 >= var5 && var11 < var5 + 8 && var12 >= var6 && var12 < var6 + 8) {
						WorldMapArea.loadTerrain(var13, var1, var2 + ModelData0.method3322(var11 & 7, var12 & 7, var7), var3 + ViewportMouse.method3059(var11 & 7, var12 & 7, var7), 0, 0, var7);
					} else {
						WorldMapArea.loadTerrain(var13, 0, -1, -1, 0, 0, 0);
					}
				}
			}
		}

	}

	@ObfuscatedName("gh")
	@ObfuscatedSignature(
		signature = "(Lba;I)Z",
		garbageValue = "-1602315616"
	)
	static boolean method1840(Player var0) {
		if (Client.drawPlayerNames == 0) {
			return false;
		} else {
			boolean var1;
			if (class192.localPlayer == var0) {
				var1 = (Client.drawPlayerNames & 8) != 0;
				return var1;
			} else {
				var1 = MouseRecorder.method1210() || LoginScreenAnimation.method1819() && var0.isFriend();
				if (!var1) {
					boolean var2 = (Client.drawPlayerNames & 2) != 0;
					var1 = var2 && var0.isClanMember();
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("hy")
	@ObfuscatedSignature(
		signature = "(S)V",
		garbageValue = "14321"
	)
	static final void method1852() {
		PacketBuffer var0 = Client.packetWriter.packetBuffer;
		var0.importIndex();
		int var1 = var0.readBits(8);
		int var2;
		if (var1 < Client.npcCount) {
			for (var2 = var1; var2 < Client.npcCount; ++var2) {
				Client.field828[++Client.field766 - 1] = Client.npcIndices[var2];
			}
		}

		if (var1 > Client.npcCount) {
			throw new RuntimeException("");
		} else {
			Client.npcCount = 0;

			for (var2 = 0; var2 < var1; ++var2) {
				int var3 = Client.npcIndices[var2];
				NPC var4 = Client.npcs[var3];
				int var5 = var0.readBits(1);
				if (var5 == 0) {
					Client.npcIndices[++Client.npcCount - 1] = var3;
					var4.npcCycle = Client.cycle;
				} else {
					int var6 = var0.readBits(2);
					if (var6 == 0) {
						Client.npcIndices[++Client.npcCount - 1] = var3;
						var4.npcCycle = Client.cycle;
						Client.field867[++Client.field690 - 1] = var3;
					} else {
						int var7;
						int var8;
						if (var6 == 1) {
							Client.npcIndices[++Client.npcCount - 1] = var3;
							var4.npcCycle = Client.cycle;
							var7 = var0.readBits(3);
							var4.method2083(var7, (byte)1);
							var8 = var0.readBits(1);
							if (var8 == 1) {
								Client.field867[++Client.field690 - 1] = var3;
							}
						} else if (var6 == 2) {
							Client.npcIndices[++Client.npcCount - 1] = var3;
							var4.npcCycle = Client.cycle;
							var7 = var0.readBits(3);
							var4.method2083(var7, (byte)2);
							var8 = var0.readBits(3);
							var4.method2083(var8, (byte)2);
							int var9 = var0.readBits(1);
							if (var9 == 1) {
								Client.field867[++Client.field690 - 1] = var3;
							}
						} else if (var6 == 3) {
							Client.field828[++Client.field766 - 1] = var3;
						}
					}
				}
			}

		}
	}
}
