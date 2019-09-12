import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("io")
@Implements("Archive")
public class Archive extends AbstractArchive {
	@ObfuscatedName("ao")
	@Export("Archive_crc")
	static CRC32 Archive_crc;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lkx;"
	)
	@Export("archiveDisk")
	ArchiveDisk archiveDisk;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lkx;"
	)
	@Export("masterDisk")
	ArchiveDisk masterDisk;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 1156949557
	)
	@Export("index")
	int index;
	@ObfuscatedName("b")
	volatile boolean field3128;
	@ObfuscatedName("ag")
	boolean field3132;
	@ObfuscatedName("at")
	@Export("validGroups")
	volatile boolean[] validGroups;
	@ObfuscatedName("av")
	@ObfuscatedGetter(
		intValue = -1676614799
	)
	@Export("indexCrc")
	int indexCrc;
	@ObfuscatedName("an")
	@ObfuscatedGetter(
		intValue = 1205835049
	)
	@Export("indexVersion")
	int indexVersion;
	@ObfuscatedName("al")
	@ObfuscatedGetter(
		intValue = 668240441
	)
	int field3137;

	static {
		Archive_crc = new CRC32();
	}

	@ObfuscatedSignature(
		signature = "(Lkx;Lkx;IZZZ)V"
	)
	public Archive(ArchiveDisk var1, ArchiveDisk var2, int var3, boolean var4, boolean var5, boolean var6) {
		super(var4, var5);
		this.field3128 = false;
		this.field3132 = false;
		this.field3137 = -1;
		this.archiveDisk = var1;
		this.masterDisk = var2;
		this.index = var3;
		this.field3132 = var6;
		int var8 = this.index;
		if (DevicePcmPlayerProvider.NetCache_reference != null) {
			DevicePcmPlayerProvider.NetCache_reference.offset = var8 * 8 + 5;
			int var9 = DevicePcmPlayerProvider.NetCache_reference.readInt();
			int var10 = DevicePcmPlayerProvider.NetCache_reference.readInt();
			this.loadIndex(var9, var10);
		} else {
			Varps.requestNetFile((Archive)null, 255, 255, 0, (byte)0, true);
			NetCache.NetCache_archives[var8] = this;
		}

	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-2104600002"
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

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "780456172"
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
				var2 = class336.NetCache_responseArchiveBuffer.offset * 99 / (class336.NetCache_responseArchiveBuffer.array.length - NetCache.NetCache_currentResponse.padding) + 1;
			} else {
				var2 = 0;
			}

			return var2;
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "2123503233"
	)
	@Export("loadGroup")
	void loadGroup(int var1) {
		if (this.archiveDisk != null && this.validGroups != null && this.validGroups[var1]) {
			PlayerType.method4120(var1, this.archiveDisk, this);
		} else {
			Varps.requestNetFile(this, this.index, var1, super.groupCrcs[var1], (byte)2, true);
		}

	}

	@ObfuscatedName("dh")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1760954432"
	)
	public boolean method4265() {
		return this.field3128;
	}

	@ObfuscatedName("do")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-185115723"
	)
	@Export("percentage")
	public int percentage() {
		if (this.field3128) {
			return 100;
		} else if (super.groups != null) {
			return 99;
		} else {
			int var2 = this.index;
			long var3 = (long)(var2 + 16711680);
			int var1;
			if (NetCache.NetCache_currentResponse != null && var3 == NetCache.NetCache_currentResponse.key) {
				var1 = class336.NetCache_responseArchiveBuffer.offset * 99 / (class336.NetCache_responseArchiveBuffer.array.length - NetCache.NetCache_currentResponse.padding) + 1;
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

	@ObfuscatedName("dm")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-288401160"
	)
	@Export("loadIndex")
	void loadIndex(int var1, int var2) {
		this.indexCrc = var1;
		this.indexVersion = var2;
		if (this.masterDisk != null) {
			PlayerType.method4120(this.index, this.masterDisk, this);
		} else {
			Varps.requestNetFile(this, 255, this.index, this.indexCrc, (byte)0, true);
		}

	}

	@ObfuscatedName("dy")
	@ObfuscatedSignature(
		signature = "(I[BZZB)V",
		garbageValue = "-101"
	)
	@Export("write")
	void write(int var1, byte[] var2, boolean var3, boolean var4) {
		if (var3) {
			if (this.field3128) {
				throw new RuntimeException();
			}

			if (this.masterDisk != null) {
				class96.method2259(this.index, var2, this.masterDisk);
			}

			this.decodeIndex(var2);
			this.loadAllLocal();
		} else {
			var2[var2.length - 2] = (byte)(super.groupVersions[var1] >> 8);
			var2[var2.length - 1] = (byte)super.groupVersions[var1];
			if (this.archiveDisk != null) {
				class96.method2259(var1, var2, this.archiveDisk);
				this.validGroups[var1] = true;
			}

			if (var4) {
				super.groups[var1] = UserComparator8.method3365(var2, false);
			}
		}

	}

	@ObfuscatedName("dd")
	@ObfuscatedSignature(
		signature = "(Lkx;I[BZI)V",
		garbageValue = "-1896487213"
	)
	@Export("load")
	void load(ArchiveDisk var1, int var2, byte[] var3, boolean var4) {
		int var5;
		if (var1 == this.masterDisk) {
			if (this.field3128) {
				throw new RuntimeException();
			} else if (var3 == null) {
				Varps.requestNetFile(this, 255, this.index, this.indexCrc, (byte)0, true);
			} else {
				Archive_crc.reset();
				Archive_crc.update(var3, 0, var3.length);
				var5 = (int)Archive_crc.getValue();
				if (var5 != this.indexCrc) {
					Varps.requestNetFile(this, 255, this.index, this.indexCrc, (byte)0, true);
				} else {
					Buffer var9 = new Buffer(TaskHandler.decompressBytes(var3));
					int var7 = var9.readUnsignedByte();
					if (var7 != 5 && var7 != 6) {
						throw new RuntimeException(var7 + "," + this.index + "," + var2);
					} else {
						int var8 = 0;
						if (var7 >= 6) {
							var8 = var9.readInt();
						}

						if (var8 != this.indexVersion) {
							Varps.requestNetFile(this, 255, this.index, this.indexCrc, (byte)0, true);
						} else {
							this.decodeIndex(var3);
							this.loadAllLocal();
						}
					}
				}
			}
		} else {
			if (!var4 && var2 == this.field3137) {
				this.field3128 = true;
			}

			if (var3 != null && var3.length > 2) {
				Archive_crc.reset();
				Archive_crc.update(var3, 0, var3.length - 2);
				var5 = (int)Archive_crc.getValue();
				int var6 = ((var3[var3.length - 2] & 255) << 8) + (var3[var3.length - 1] & 255);
				if (var5 == super.groupCrcs[var2] && var6 == super.groupVersions[var2]) {
					this.validGroups[var2] = true;
					if (var4) {
						super.groups[var2] = UserComparator8.method3365(var3, false);
					}

				} else {
					this.validGroups[var2] = false;
					if (this.field3132 || var4) {
						Varps.requestNetFile(this, this.index, var2, super.groupCrcs[var2], (byte)2, var4);
					}

				}
			} else {
				this.validGroups[var2] = false;
				if (this.field3132 || var4) {
					Varps.requestNetFile(this, this.index, var2, super.groupCrcs[var2], (byte)2, var4);
				}

			}
		}
	}

	@ObfuscatedName("dp")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1002718108"
	)
	@Export("loadAllLocal")
	void loadAllLocal() {
		this.validGroups = new boolean[super.groups.length];

		int var1;
		for (var1 = 0; var1 < this.validGroups.length; ++var1) {
			this.validGroups[var1] = false;
		}

		if (this.archiveDisk == null) {
			this.field3128 = true;
		} else {
			this.field3137 = -1;

			for (var1 = 0; var1 < this.validGroups.length; ++var1) {
				if (super.fileCounts[var1] > 0) {
					Friend.method5190(var1, this.archiveDisk, this);
					this.field3137 = var1;
				}
			}

			if (this.field3137 == -1) {
				this.field3128 = true;
			}

		}
	}

	@ObfuscatedName("dn")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "305356325"
	)
	public boolean method4283(int var1) {
		return this.validGroups[var1];
	}

	@ObfuscatedName("de")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "-1930544538"
	)
	public boolean method4261(int var1) {
		return this.getGroupFileIds(var1) != null;
	}

	@ObfuscatedName("da")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "64"
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

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/CharSequence;I)I",
		garbageValue = "1683994137"
	)
	@Export("hashString")
	public static int hashString(CharSequence var0) {
		int var1 = var0.length();
		int var2 = 0;

		for (int var3 = 0; var3 < var1; ++var3) {
			var2 = (var2 << 5) - var2 + MenuAction.charToByteCp1252(var0.charAt(var3));
		}

		return var2;
	}
}
