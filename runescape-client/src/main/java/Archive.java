import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("if")
@Implements("Archive")
public class Archive extends AbstractArchive {
	@ObfuscatedName("aw")
	@Export("Archive_crc")
	static CRC32 Archive_crc;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lkg;"
	)
	@Export("archiveDisk")
	ArchiveDisk archiveDisk;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lkg;"
	)
	@Export("masterDisk")
	ArchiveDisk masterDisk;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -1842467633
	)
	@Export("index")
	int index;
	@ObfuscatedName("q")
	volatile boolean field3130;
	@ObfuscatedName("aa")
	boolean field3131;
	@ObfuscatedName("av")
	@Export("validGroups")
	volatile boolean[] validGroups;
	@ObfuscatedName("as")
	@ObfuscatedGetter(
		intValue = -1109025613
	)
	@Export("indexCrc")
	int indexCrc;
	@ObfuscatedName("ak")
	@ObfuscatedGetter(
		intValue = -1689263625
	)
	@Export("indexVersion")
	int indexVersion;
	@ObfuscatedName("au")
	@ObfuscatedGetter(
		intValue = 756827345
	)
	int field3128;

	static {
		Archive_crc = new CRC32();
	}

	@ObfuscatedSignature(
		signature = "(Lkg;Lkg;IZZZ)V"
	)
	public Archive(ArchiveDisk var1, ArchiveDisk var2, int var3, boolean var4, boolean var5, boolean var6) {
		super(var4, var5);
		this.field3130 = false;
		this.field3131 = false;
		this.field3128 = -1;
		this.archiveDisk = var1;
		this.masterDisk = var2;
		this.index = var3;
		this.field3131 = var6;
		class48.method862(this, this.index);
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "236985177"
	)
	@Export("loadRegionFromGroup")
	void loadRegionFromGroup(int var1) {
		int var2 = this.index;
		long var3 = (long)((var2 << 16) + var1);
		NetFileRequest var5 = (NetFileRequest)NetCache.NetCache_pendingWrites.get(var3);
		if (var5 != null) {
			NetCache.NetCache_pendingWritesQueue.addLast(var5);
		}

	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(IS)I",
		garbageValue = "6161"
	)
	@Export("groupLoadPercent")
	int groupLoadPercent(int var1) {
		if (super.groups[var1] != null) {
			return 100;
		} else {
			return this.validGroups[var1] ? 100 : Clock.method3489(this.index, var1);
		}
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1606315041"
	)
	@Export("loadGroup")
	void loadGroup(int var1) {
		if (this.archiveDisk != null && this.validGroups != null && this.validGroups[var1]) {
			class30.method543(var1, this.archiveDisk, this);
		} else {
			class226.requestNetFile(this, this.index, var1, super.groupCrcs[var1], (byte)2, true);
		}

	}

	@ObfuscatedName("de")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "-47"
	)
	public boolean method4246() {
		return this.field3130;
	}

	@ObfuscatedName("df")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1662836587"
	)
	@Export("percentage")
	public int percentage() {
		if (this.field3130) {
			return 100;
		} else if (super.groups != null) {
			return 99;
		} else {
			int var1 = Clock.method3489(255, this.index);
			if (var1 >= 100) {
				var1 = 99;
			}

			return var1;
		}
	}

	@ObfuscatedName("di")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-190190944"
	)
	@Export("loadIndex")
	public void loadIndex(int var1, int var2) {
		this.indexCrc = var1;
		this.indexVersion = var2;
		if (this.masterDisk != null) {
			class30.method543(this.index, this.masterDisk, this);
		} else {
			class226.requestNetFile(this, 255, this.index, this.indexCrc, (byte)0, true);
		}

	}

	@ObfuscatedName("dr")
	@ObfuscatedSignature(
		signature = "(I[BZZI)V",
		garbageValue = "-1214934891"
	)
	@Export("write")
	public void write(int var1, byte[] var2, boolean var3, boolean var4) {
		if (var3) {
			if (this.field3130) {
				throw new RuntimeException();
			}

			if (this.masterDisk != null) {
				ByteArrayPool.method5805(this.index, var2, this.masterDisk);
			}

			this.decodeIndex(var2);
			this.loadAllLocal();
		} else {
			var2[var2.length - 2] = (byte)(super.groupVersions[var1] >> 8);
			var2[var2.length - 1] = (byte)super.groupVersions[var1];
			if (this.archiveDisk != null) {
				ByteArrayPool.method5805(var1, var2, this.archiveDisk);
				this.validGroups[var1] = true;
			}

			if (var4) {
				Object[] var5 = super.groups;
				Object var7;
				if (var2 == null) {
					var7 = null;
				} else if (var2.length > 136) {
					DirectByteArrayCopier var8 = new DirectByteArrayCopier();
					var8.set(var2);
					var7 = var8;
				} else {
					var7 = var2;
				}

				var5[var1] = var7;
			}
		}

	}

	@ObfuscatedName("dg")
	@ObfuscatedSignature(
		signature = "(Lkg;I[BZI)V",
		garbageValue = "-1566911980"
	)
	@Export("load")
	void load(ArchiveDisk var1, int var2, byte[] var3, boolean var4) {
		int var5;
		if (var1 == this.masterDisk) {
			if (this.field3130) {
				throw new RuntimeException();
			}

			if (var3 == null) {
				class226.requestNetFile(this, 255, this.index, this.indexCrc, (byte)0, true);
				return;
			}

			Archive_crc.reset();
			Archive_crc.update(var3, 0, var3.length);
			var5 = (int)Archive_crc.getValue();
			if (var5 != this.indexCrc) {
				class226.requestNetFile(this, 255, this.index, this.indexCrc, (byte)0, true);
				return;
			}

			Buffer var11 = new Buffer(Skills.decompressBytes(var3));
			int var12 = var11.readUnsignedByte();
			if (var12 != 5 && var12 != 6) {
				throw new RuntimeException(var12 + "," + this.index + "," + var2);
			}

			int var8 = 0;
			if (var12 >= 6) {
				var8 = var11.readInt();
			}

			if (var8 != this.indexVersion) {
				class226.requestNetFile(this, 255, this.index, this.indexCrc, (byte)0, true);
				return;
			}

			this.decodeIndex(var3);
			this.loadAllLocal();
		} else {
			if (!var4 && var2 == this.field3128) {
				this.field3130 = true;
			}

			if (var3 == null || var3.length <= 2) {
				this.validGroups[var2] = false;
				if (this.field3131 || var4) {
					class226.requestNetFile(this, this.index, var2, super.groupCrcs[var2], (byte)2, var4);
				}

				return;
			}

			Archive_crc.reset();
			Archive_crc.update(var3, 0, var3.length - 2);
			var5 = (int)Archive_crc.getValue();
			int var6 = ((var3[var3.length - 2] & 255) << 8) + (var3[var3.length - 1] & 255);
			if (var5 != super.groupCrcs[var2] || var6 != super.groupVersions[var2]) {
				this.validGroups[var2] = false;
				if (this.field3131 || var4) {
					class226.requestNetFile(this, this.index, var2, super.groupCrcs[var2], (byte)2, var4);
				}

				return;
			}

			this.validGroups[var2] = true;
			if (var4) {
				Object[] var7 = super.groups;
				Object var9;
				if (var3 == null) {
					var9 = null;
				} else if (var3.length > 136) {
					DirectByteArrayCopier var10 = new DirectByteArrayCopier();
					var10.set(var3);
					var9 = var10;
				} else {
					var9 = var3;
				}

				var7[var2] = var9;
			}
		}

	}

	@ObfuscatedName("dh")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1822102759"
	)
	@Export("loadAllLocal")
	void loadAllLocal() {
		this.validGroups = new boolean[super.groups.length];

		int var1;
		for (var1 = 0; var1 < this.validGroups.length; ++var1) {
			this.validGroups[var1] = false;
		}

		if (this.archiveDisk == null) {
			this.field3130 = true;
		} else {
			this.field3128 = -1;

			for (var1 = 0; var1 < this.validGroups.length; ++var1) {
				if (super.fileCounts[var1] > 0) {
					WorldMapLabelSize.method186(var1, this.archiveDisk, this);
					this.field3128 = var1;
				}
			}

			if (this.field3128 == -1) {
				this.field3130 = true;
			}

		}
	}

	@ObfuscatedName("dl")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "1057662007"
	)
	public boolean method4266(int var1) {
		return this.validGroups[var1];
	}

	@ObfuscatedName("da")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "693879570"
	)
	public boolean method4275(int var1) {
		return this.getGroupFileIds(var1) != null;
	}

	@ObfuscatedName("dp")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-576778169"
	)
	@Export("loadPercent")
	public int loadPercent() {
		int var1 = 0;
		int var2 = 0;

		int var3;
		for (var3 = 0; var3 < super.groups.length; ++var3) {
			if (super.fileCounts[var3] > 0) {
				var1 += 100;
				var2 += this.groupLoadPercent(var3);
			}
		}

		if (var1 == 0) {
			return 100;
		} else {
			var3 = var2 * 100 / var1;
			return var3;
		}
	}

	@ObfuscatedName("gh")
	@ObfuscatedSignature(
		signature = "(ZB)V",
		garbageValue = "0"
	)
	@Export("addNpcsToScene")
	static final void addNpcsToScene(boolean var0) {
		for (int var1 = 0; var1 < Client.npcCount; ++var1) {
			NPC var2 = Client.npcs[Client.npcIndices[var1]];
			if (var2 != null && var2.isVisible() && var2.definition.isVisible == var0 && var2.definition.transformIsVisible()) {
				int var3 = var2.x >> 7;
				int var4 = var2.y >> 7;
				if (var3 >= 0 && var3 < 104 && var4 >= 0 && var4 < 104) {
					if (var2.field925 == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
						if (Client.tileLastDrawnActor[var3][var4] == Client.viewportDrawCount) {
							continue;
						}

						Client.tileLastDrawnActor[var3][var4] = Client.viewportDrawCount;
					}

					long var5 = KeyHandler.calculateTag(0, 0, 1, !var2.definition.isInteractable, Client.npcIndices[var1]);
					var2.playerCycle = Client.cycle;
					class14.scene.drawEntity(UrlRequest.Client_plane, var2.x, var2.y, ScriptEvent.getTileHeight(var2.field925 * 64 - 64 + var2.x, var2.field925 * 64 - 64 + var2.y, UrlRequest.Client_plane), var2.field925 * 64 - 64 + 60, var2, var2.rotation, var5, var2.isWalking);
				}
			}
		}

	}
}
