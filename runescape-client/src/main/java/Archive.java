import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("id")
@Implements("Archive")
public class Archive extends AbstractArchive {
	@ObfuscatedName("ai")
	@Export("Archive_crc")
	static CRC32 Archive_crc;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Lkv;"
	)
	@Export("archiveDisk")
	ArchiveDisk archiveDisk;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lkv;"
	)
	@Export("masterDisk")
	ArchiveDisk masterDisk;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -1228227843
	)
	@Export("index")
	int index;
	@ObfuscatedName("o")
	volatile boolean field3132;
	@ObfuscatedName("av")
	boolean field3133;
	@ObfuscatedName("am")
	@Export("validGroups")
	volatile boolean[] validGroups;
	@ObfuscatedName("af")
	@ObfuscatedGetter(
		intValue = 1456312337
	)
	@Export("indexCrc")
	int indexCrc;
	@ObfuscatedName("az")
	@ObfuscatedGetter(
		intValue = -1798815125
	)
	@Export("indexVersion")
	int indexVersion;
	@ObfuscatedName("aj")
	@ObfuscatedGetter(
		intValue = -1710593501
	)
	int field3131;

	static {
		Archive_crc = new CRC32();
	}

	@ObfuscatedSignature(
		signature = "(Lkv;Lkv;IZZZ)V"
	)
	public Archive(ArchiveDisk var1, ArchiveDisk var2, int var3, boolean var4, boolean var5, boolean var6) {
		super(var4, var5);
		this.field3132 = false;
		this.field3133 = false;
		this.field3131 = -1;
		this.archiveDisk = var1;
		this.masterDisk = var2;
		this.index = var3;
		this.field3133 = var6;
		int var8 = this.index;
		if (Decimator.NetCache_reference != null) {
			Decimator.NetCache_reference.offset = var8 * 8 + 5;
			int var9 = Decimator.NetCache_reference.readInt();
			int var10 = Decimator.NetCache_reference.readInt();
			this.loadIndex(var9, var10);
		} else {
			BuddyRankComparator.requestNetFile((Archive)null, 255, 255, 0, (byte)0, true);
			NetCache.NetCache_archives[var8] = this;
		}

	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "502266240"
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

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "-1902634670"
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
			if (NetCache.NetCache_currentResponse != null && var4 == NetCache.NetCache_currentResponse.key) {
				var2 = NetCache.NetCache_responseArchiveBuffer.offset * 99 / (NetCache.NetCache_responseArchiveBuffer.array.length - NetCache.NetCache_currentResponse.padding) + 1;
			} else {
				var2 = 0;
			}

			return var2;
		}
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1800831619"
	)
	@Export("loadGroup")
	void loadGroup(int var1) {
		if (this.archiveDisk != null && this.validGroups != null && this.validGroups[var1]) {
			WorldMapIcon_0.method191(var1, this.archiveDisk, this);
		} else {
			BuddyRankComparator.requestNetFile(this, this.index, var1, super.groupCrcs[var1], (byte)2, true);
		}

	}

	@ObfuscatedName("cs")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "581718104"
	)
	public boolean method4177() {
		return this.field3132;
	}

	@ObfuscatedName("co")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-35"
	)
	@Export("percentage")
	public int percentage() {
		if (this.field3132) {
			return 100;
		} else if (super.groups != null) {
			return 99;
		} else {
			int var1 = class160.method3383(255, this.index);
			if (var1 >= 100) {
				var1 = 99;
			}

			return var1;
		}
	}

	@ObfuscatedName("dr")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "-1"
	)
	@Export("loadIndex")
	void loadIndex(int var1, int var2) {
		this.indexCrc = var1;
		this.indexVersion = var2;
		if (this.masterDisk != null) {
			WorldMapIcon_0.method191(this.index, this.masterDisk, this);
		} else {
			BuddyRankComparator.requestNetFile(this, 255, this.index, this.indexCrc, (byte)0, true);
		}

	}

	@ObfuscatedName("dd")
	@ObfuscatedSignature(
		signature = "(I[BZZB)V",
		garbageValue = "-44"
	)
	@Export("write")
	void write(int var1, byte[] var2, boolean var3, boolean var4) {
		if (var3) {
			if (this.field3132) {
				throw new RuntimeException();
			}

			if (this.masterDisk != null) {
				GameShell.method1005(this.index, var2, this.masterDisk);
			}

			this.decodeIndex(var2);
			this.loadAllLocal();
		} else {
			var2[var2.length - 2] = (byte)(super.groupVersions[var1] >> 8);
			var2[var2.length - 1] = (byte)super.groupVersions[var1];
			if (this.archiveDisk != null) {
				GameShell.method1005(var1, var2, this.archiveDisk);
				this.validGroups[var1] = true;
			}

			if (var4) {
				super.groups[var1] = Entity.method3209(var2, false);
			}
		}

	}

	@ObfuscatedName("dv")
	@ObfuscatedSignature(
		signature = "(Lkv;I[BZI)V",
		garbageValue = "54929376"
	)
	@Export("load")
	void load(ArchiveDisk var1, int var2, byte[] var3, boolean var4) {
		int var5;
		if (var1 == this.masterDisk) {
			if (this.field3132) {
				throw new RuntimeException();
			} else if (var3 == null) {
				BuddyRankComparator.requestNetFile(this, 255, this.index, this.indexCrc, (byte)0, true);
			} else {
				Archive_crc.reset();
				Archive_crc.update(var3, 0, var3.length);
				var5 = (int)Archive_crc.getValue();
				if (var5 != this.indexCrc) {
					BuddyRankComparator.requestNetFile(this, 255, this.index, this.indexCrc, (byte)0, true);
				} else {
					Buffer var9 = new Buffer(Player.decompressBytes(var3));
					int var7 = var9.readUnsignedByte();
					if (var7 != 5 && var7 != 6) {
						throw new RuntimeException(var7 + "," + this.index + "," + var2);
					} else {
						int var8 = 0;
						if (var7 >= 6) {
							var8 = var9.readInt();
						}

						if (var8 != this.indexVersion) {
							BuddyRankComparator.requestNetFile(this, 255, this.index, this.indexCrc, (byte)0, true);
						} else {
							this.decodeIndex(var3);
							this.loadAllLocal();
						}
					}
				}
			}
		} else {
			if (!var4 && var2 == this.field3131) {
				this.field3132 = true;
			}

			if (var3 != null && var3.length > 2) {
				Archive_crc.reset();
				Archive_crc.update(var3, 0, var3.length - 2);
				var5 = (int)Archive_crc.getValue();
				int var6 = ((var3[var3.length - 2] & 255) << 8) + (var3[var3.length - 1] & 255);
				if (var5 == super.groupCrcs[var2] && var6 == super.groupVersions[var2]) {
					this.validGroups[var2] = true;
					if (var4) {
						super.groups[var2] = Entity.method3209(var3, false);
					}

				} else {
					this.validGroups[var2] = false;
					if (this.field3133 || var4) {
						BuddyRankComparator.requestNetFile(this, this.index, var2, super.groupCrcs[var2], (byte)2, var4);
					}

				}
			} else {
				this.validGroups[var2] = false;
				if (this.field3133 || var4) {
					BuddyRankComparator.requestNetFile(this, this.index, var2, super.groupCrcs[var2], (byte)2, var4);
				}

			}
		}
	}

	@ObfuscatedName("da")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1518016463"
	)
	@Export("loadAllLocal")
	void loadAllLocal() {
		this.validGroups = new boolean[super.groups.length];

		int var1;
		for (var1 = 0; var1 < this.validGroups.length; ++var1) {
			this.validGroups[var1] = false;
		}

		if (this.archiveDisk == null) {
			this.field3132 = true;
		} else {
			this.field3131 = -1;

			for (var1 = 0; var1 < this.validGroups.length; ++var1) {
				if (super.fileCounts[var1] > 0) {
					BuddyRankComparator.method3376(var1, this.archiveDisk, this);
					this.field3131 = var1;
				}
			}

			if (this.field3131 == -1) {
				this.field3132 = true;
			}

		}
	}

	@ObfuscatedName("dh")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "512289174"
	)
	public boolean method4185(int var1) {
		return this.validGroups[var1];
	}

	@ObfuscatedName("dm")
	@ObfuscatedSignature(
		signature = "(IB)Z",
		garbageValue = "-5"
	)
	public boolean method4199(int var1) {
		return this.getGroupFileIds(var1) != null;
	}

	@ObfuscatedName("dj")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "119"
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
