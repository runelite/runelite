import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ij")
@Implements("Archive")
public class Archive extends AbstractArchive {
	@ObfuscatedName("am")
	@Export("Archive_crc")
	static CRC32 Archive_crc;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lke;"
	)
	@Export("archiveDisk")
	ArchiveDisk archiveDisk;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lke;"
	)
	@Export("masterDisk")
	ArchiveDisk masterDisk;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -485019115
	)
	@Export("index")
	int index;
	@ObfuscatedName("j")
	volatile boolean field3158;
	@ObfuscatedName("af")
	boolean field3163;
	@ObfuscatedName("ad")
	@Export("validGroups")
	volatile boolean[] validGroups;
	@ObfuscatedName("ai")
	@ObfuscatedGetter(
		intValue = -811032565
	)
	@Export("indexCrc")
	int indexCrc;
	@ObfuscatedName("ag")
	@ObfuscatedGetter(
		intValue = -714735647
	)
	@Export("indexVersion")
	int indexVersion;
	@ObfuscatedName("ao")
	@ObfuscatedGetter(
		intValue = -1499508755
	)
	int field3168;

	static {
		Archive_crc = new CRC32();
	}

	@ObfuscatedSignature(
		signature = "(Lke;Lke;IZZZ)V"
	)
	public Archive(ArchiveDisk var1, ArchiveDisk var2, int var3, boolean var4, boolean var5, boolean var6) {
		super(var4, var5);
		this.field3158 = false;
		this.field3163 = false;
		this.field3168 = -1;
		this.archiveDisk = var1;
		this.masterDisk = var2;
		this.index = var3;
		this.field3163 = var6;
		WorldMapIcon_0.method224(this, this.index);
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-64779180"
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

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "-1387572162"
	)
	@Export("groupLoadPercent")
	int groupLoadPercent(int var1) {
		if (super.groups[var1] != null) {
			return 100;
		} else if (this.validGroups[var1]) {
			return 100;
		} else {
			int var3 = this.index;
			long var4 = (long)((var3 << 16) + var1);
			int var2;
			if (NetCache.NetCache_currentResponse != null && NetCache.NetCache_currentResponse.key == var4) {
				var2 = class32.NetCache_responseArchiveBuffer.offset * 99 / (class32.NetCache_responseArchiveBuffer.array.length - NetCache.NetCache_currentResponse.padding) + 1;
			} else {
				var2 = 0;
			}

			return var2;
		}
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "130067407"
	)
	@Export("loadGroup")
	void loadGroup(int var1) {
		if (this.archiveDisk != null && this.validGroups != null && this.validGroups[var1]) {
			PlayerType.method4210(var1, this.archiveDisk, this);
		} else {
			ClientPreferences.requestNetFile(this, this.index, var1, super.groupCrcs[var1], (byte)2, true);
		}

	}

	@ObfuscatedName("dw")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "0"
	)
	public boolean method4345() {
		return this.field3158;
	}

	@ObfuscatedName("de")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-77"
	)
	@Export("percentage")
	public int percentage() {
		if (this.field3158) {
			return 100;
		} else if (super.groups != null) {
			return 99;
		} else {
			int var2 = this.index;
			long var3 = (long)(var2 + 16711680);
			int var1;
			if (NetCache.NetCache_currentResponse != null && NetCache.NetCache_currentResponse.key == var3) {
				var1 = class32.NetCache_responseArchiveBuffer.offset * 99 / (class32.NetCache_responseArchiveBuffer.array.length - NetCache.NetCache_currentResponse.padding) + 1;
			} else {
				var1 = 0;
			}

			int var5 = var1;
			if (var1 >= 100) {
				var5 = 99;
			}

			return var5;
		}
	}

	@ObfuscatedName("dx")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-1360359241"
	)
	@Export("loadIndex")
	void loadIndex(int var1, int var2) {
		this.indexCrc = var1;
		this.indexVersion = var2;
		if (this.masterDisk != null) {
			PlayerType.method4210(this.index, this.masterDisk, this);
		} else {
			ClientPreferences.requestNetFile(this, 255, this.index, this.indexCrc, (byte)0, true);
		}

	}

	@ObfuscatedName("dc")
	@ObfuscatedSignature(
		signature = "(I[BZZI)V",
		garbageValue = "1341522635"
	)
	@Export("write")
	void write(int var1, byte[] var2, boolean var3, boolean var4) {
		if (var3) {
			if (this.field3158) {
				throw new RuntimeException();
			}

			if (this.masterDisk != null) {
				TileItem.method2144(this.index, var2, this.masterDisk);
			}

			this.decodeIndex(var2);
			this.loadAllLocal();
		} else {
			var2[var2.length - 2] = (byte)(super.groupVersions[var1] >> 8);
			var2[var2.length - 1] = (byte)super.groupVersions[var1];
			if (this.archiveDisk != null) {
				TileItem.method2144(var1, var2, this.archiveDisk);
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

	@ObfuscatedName("dk")
	@ObfuscatedSignature(
		signature = "(Lke;I[BZB)V",
		garbageValue = "45"
	)
	@Export("load")
	void load(ArchiveDisk var1, int var2, byte[] var3, boolean var4) {
		int var5;
		if (var1 == this.masterDisk) {
			if (this.field3158) {
				throw new RuntimeException();
			}

			if (var3 == null) {
				ClientPreferences.requestNetFile(this, 255, this.index, this.indexCrc, (byte)0, true);
				return;
			}

			Archive_crc.reset();
			Archive_crc.update(var3, 0, var3.length);
			var5 = (int)Archive_crc.getValue();
			if (var5 != this.indexCrc) {
				ClientPreferences.requestNetFile(this, 255, this.index, this.indexCrc, (byte)0, true);
				return;
			}

			Buffer var11 = new Buffer(class226.decompressBytes(var3));
			int var12 = var11.readUnsignedByte();
			if (var12 != 5 && var12 != 6) {
				throw new RuntimeException(var12 + "," + this.index + "," + var2);
			}

			int var8 = 0;
			if (var12 >= 6) {
				var8 = var11.readInt();
			}

			if (var8 != this.indexVersion) {
				ClientPreferences.requestNetFile(this, 255, this.index, this.indexCrc, (byte)0, true);
				return;
			}

			this.decodeIndex(var3);
			this.loadAllLocal();
		} else {
			if (!var4 && var2 == this.field3168) {
				this.field3158 = true;
			}

			if (var3 == null || var3.length <= 2) {
				this.validGroups[var2] = false;
				if (this.field3163 || var4) {
					ClientPreferences.requestNetFile(this, this.index, var2, super.groupCrcs[var2], (byte)2, var4);
				}

				return;
			}

			Archive_crc.reset();
			Archive_crc.update(var3, 0, var3.length - 2);
			var5 = (int)Archive_crc.getValue();
			int var6 = ((var3[var3.length - 2] & 255) << 8) + (var3[var3.length - 1] & 255);
			if (var5 != super.groupCrcs[var2] || var6 != super.groupVersions[var2]) {
				this.validGroups[var2] = false;
				if (this.field3163 || var4) {
					ClientPreferences.requestNetFile(this, this.index, var2, super.groupCrcs[var2], (byte)2, var4);
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

	@ObfuscatedName("dj")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1169710133"
	)
	@Export("loadAllLocal")
	void loadAllLocal() {
		this.validGroups = new boolean[super.groups.length];

		int var1;
		for (var1 = 0; var1 < this.validGroups.length; ++var1) {
			this.validGroups[var1] = false;
		}

		if (this.archiveDisk == null) {
			this.field3158 = true;
		} else {
			this.field3168 = -1;

			for (var1 = 0; var1 < this.validGroups.length; ++var1) {
				if (super.fileCounts[var1] > 0) {
					class40.method780(var1, this.archiveDisk, this);
					this.field3168 = var1;
				}
			}

			if (this.field3168 == -1) {
				this.field3158 = true;
			}

		}
	}

	@ObfuscatedName("dp")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "2065580050"
	)
	public boolean method4354(int var1) {
		return this.validGroups[var1];
	}

	@ObfuscatedName("di")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "581589057"
	)
	public boolean method4355(int var1) {
		return this.getGroupFileIds(var1) != null;
	}

	@ObfuscatedName("dn")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1792861334"
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
}
