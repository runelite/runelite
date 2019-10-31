import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ij")
@Implements("Archive")
public class Archive extends AbstractArchive {
	@ObfuscatedName("ar")
	@Export("Archive_crc")
	static CRC32 Archive_crc;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lke;"
	)
	@Export("archiveDisk")
	ArchiveDisk archiveDisk;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lke;"
	)
	@Export("masterDisk")
	ArchiveDisk masterDisk;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -697196869
	)
	@Export("index")
	int index;
	@ObfuscatedName("y")
	volatile boolean field3145;
	@ObfuscatedName("aa")
	boolean field3139;
	@ObfuscatedName("aw")
	@Export("validGroups")
	volatile boolean[] validGroups;
	@ObfuscatedName("aq")
	@ObfuscatedGetter(
		intValue = 1007467833
	)
	@Export("indexCrc")
	int indexCrc;
	@ObfuscatedName("ad")
	@ObfuscatedGetter(
		intValue = -722952975
	)
	@Export("indexVersion")
	int indexVersion;
	@ObfuscatedName("ag")
	@ObfuscatedGetter(
		intValue = 372476733
	)
	int field3148;

	static {
		Archive_crc = new CRC32();
	}

	@ObfuscatedSignature(
		signature = "(Lke;Lke;IZZZ)V"
	)
	public Archive(ArchiveDisk var1, ArchiveDisk var2, int var3, boolean var4, boolean var5, boolean var6) {
		super(var4, var5);
		this.field3145 = false;
		this.field3139 = false;
		this.field3148 = -1;
		this.archiveDisk = var1;
		this.masterDisk = var2;
		this.index = var3;
		this.field3139 = var6;
		int var8 = this.index;
		if (Calendar.NetCache_reference != null) {
			Calendar.NetCache_reference.offset = var8 * 8 + 5;
			int var9 = Calendar.NetCache_reference.readInt();
			int var10 = Calendar.NetCache_reference.readInt();
			this.loadIndex(var9, var10);
		} else {
			BuddyRankComparator.requestNetFile((Archive)null, 255, 255, 0, (byte)0, true);
			NetCache.NetCache_archives[var8] = this;
		}

	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "117"
	)
	@Export("loadRegionFromGroup")
	void loadRegionFromGroup(int var1) {
		Tile.method3021(this.index, var1);
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "-778670663"
	)
	@Export("groupLoadPercent")
	int groupLoadPercent(int var1) {
		if (super.groups[var1] != null) {
			return 100;
		} else {
			return this.validGroups[var1] ? 100 : PcmPlayer.method2638(this.index, var1);
		}
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "664192835"
	)
	@Export("loadGroup")
	void loadGroup(int var1) {
		if (this.archiveDisk != null && this.validGroups != null && this.validGroups[var1]) {
			ArchiveDisk var2 = this.archiveDisk;
			byte[] var4 = null;
			synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
				for (ArchiveDiskAction var6 = (ArchiveDiskAction)ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.last(); var6 != null; var6 = (ArchiveDiskAction)ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.previous()) {
					if (var6.key == (long)var1 && var2 == var6.archiveDisk && var6.type == 0) {
						var4 = var6.data;
						break;
					}
				}
			}

			if (var4 != null) {
				this.load(var2, var1, var4, true);
			} else {
				byte[] var5 = var2.read(var1);
				this.load(var2, var1, var5, true);
			}
		} else {
			BuddyRankComparator.requestNetFile(this, this.index, var1, super.groupCrcs[var1], (byte)2, true);
		}

	}

	@ObfuscatedName("dm")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1944128769"
	)
	public boolean method4409() {
		return this.field3145;
	}

	@ObfuscatedName("di")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1888934237"
	)
	@Export("percentage")
	public int percentage() {
		if (this.field3145) {
			return 100;
		} else if (super.groups != null) {
			return 99;
		} else {
			int var1 = PcmPlayer.method2638(255, this.index);
			if (var1 >= 100) {
				var1 = 99;
			}

			return var1;
		}
	}

	@ObfuscatedName("dn")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "1627267757"
	)
	@Export("loadIndex")
	public void loadIndex(int var1, int var2) {
		this.indexCrc = var1;
		this.indexVersion = var2;
		if (this.masterDisk != null) {
			int var3 = this.index;
			ArchiveDisk var4 = this.masterDisk;
			byte[] var6 = null;
			synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
				for (ArchiveDiskAction var8 = (ArchiveDiskAction)ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.last(); var8 != null; var8 = (ArchiveDiskAction)ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.previous()) {
					if (var8.key == (long)var3 && var4 == var8.archiveDisk && var8.type == 0) {
						var6 = var8.data;
						break;
					}
				}
			}

			if (var6 != null) {
				this.load(var4, var3, var6, true);
			} else {
				byte[] var7 = var4.read(var3);
				this.load(var4, var3, var7, true);
			}
		} else {
			BuddyRankComparator.requestNetFile(this, 255, this.index, this.indexCrc, (byte)0, true);
		}

	}

	@ObfuscatedName("dr")
	@ObfuscatedSignature(
		signature = "(I[BZZB)V",
		garbageValue = "4"
	)
	@Export("write")
	public void write(int var1, byte[] var2, boolean var3, boolean var4) {
		if (var3) {
			if (this.field3145) {
				throw new RuntimeException();
			}

			if (this.masterDisk != null) {
				int var5 = this.index;
				ArchiveDisk var6 = this.masterDisk;
				ArchiveDiskAction var7 = new ArchiveDiskAction();
				var7.type = 0;
				var7.key = (long)var5;
				var7.data = var2;
				var7.archiveDisk = var6;
				synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
					ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.addFirst(var7);
				}

				ItemContainer.method1250();
			}

			this.decodeIndex(var2);
			this.loadAllLocal();
		} else {
			var2[var2.length - 2] = (byte)(super.groupVersions[var1] >> 8);
			var2[var2.length - 1] = (byte)super.groupVersions[var1];
			if (this.archiveDisk != null) {
				ArchiveDisk var11 = this.archiveDisk;
				ArchiveDiskAction var14 = new ArchiveDiskAction();
				var14.type = 0;
				var14.key = (long)var1;
				var14.data = var2;
				var14.archiveDisk = var11;
				synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
					ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.addFirst(var14);
				}

				ItemContainer.method1250();
				this.validGroups[var1] = true;
			}

			if (var4) {
				super.groups[var1] = MusicPatchPcmStream.method4064(var2, false);
			}
		}

	}

	@ObfuscatedName("do")
	@ObfuscatedSignature(
		signature = "(Lke;I[BZI)V",
		garbageValue = "-1897627904"
	)
	@Export("load")
	public void load(ArchiveDisk var1, int var2, byte[] var3, boolean var4) {
		int var5;
		if (var1 == this.masterDisk) {
			if (this.field3145) {
				throw new RuntimeException();
			}

			if (var3 == null) {
				BuddyRankComparator.requestNetFile(this, 255, this.index, this.indexCrc, (byte)0, true);
				return;
			}

			Archive_crc.reset();
			Archive_crc.update(var3, 0, var3.length);
			var5 = (int)Archive_crc.getValue();
			if (var5 != this.indexCrc) {
				BuddyRankComparator.requestNetFile(this, 255, this.index, this.indexCrc, (byte)0, true);
				return;
			}

			Buffer var9 = new Buffer(ArchiveLoader.decompressBytes(var3));
			int var7 = var9.readUnsignedByte();
			if (var7 != 5 && var7 != 6) {
				throw new RuntimeException(var7 + "," + this.index + "," + var2);
			}

			int var8 = 0;
			if (var7 >= 6) {
				var8 = var9.readInt();
			}

			if (var8 != this.indexVersion) {
				BuddyRankComparator.requestNetFile(this, 255, this.index, this.indexCrc, (byte)0, true);
				return;
			}

			this.decodeIndex(var3);
			this.loadAllLocal();
		} else {
			if (!var4 && var2 == this.field3148) {
				this.field3145 = true;
			}

			if (var3 == null || var3.length <= 2) {
				this.validGroups[var2] = false;
				if (this.field3139 || var4) {
					BuddyRankComparator.requestNetFile(this, this.index, var2, super.groupCrcs[var2], (byte)2, var4);
				}

				return;
			}

			Archive_crc.reset();
			Archive_crc.update(var3, 0, var3.length - 2);
			var5 = (int)Archive_crc.getValue();
			int var6 = ((var3[var3.length - 2] & 255) << 8) + (var3[var3.length - 1] & 255);
			if (var5 != super.groupCrcs[var2] || var6 != super.groupVersions[var2]) {
				this.validGroups[var2] = false;
				if (this.field3139 || var4) {
					BuddyRankComparator.requestNetFile(this, this.index, var2, super.groupCrcs[var2], (byte)2, var4);
				}

				return;
			}

			this.validGroups[var2] = true;
			if (var4) {
				super.groups[var2] = MusicPatchPcmStream.method4064(var3, false);
			}
		}

	}

	@ObfuscatedName("ds")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "0"
	)
	@Export("loadAllLocal")
	void loadAllLocal() {
		this.validGroups = new boolean[super.groups.length];

		int var1;
		for (var1 = 0; var1 < this.validGroups.length; ++var1) {
			this.validGroups[var1] = false;
		}

		if (this.archiveDisk == null) {
			this.field3145 = true;
		} else {
			this.field3148 = -1;

			for (var1 = 0; var1 < this.validGroups.length; ++var1) {
				if (super.fileCounts[var1] > 0) {
					ArchiveDisk var2 = this.archiveDisk;
					ArchiveDiskAction var4 = new ArchiveDiskAction();
					var4.type = 1;
					var4.key = (long)var1;
					var4.archiveDisk = var2;
					var4.archive = this;
					synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
						ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.addFirst(var4);
					}

					ItemContainer.method1250();
					this.field3148 = var1;
				}
			}

			if (this.field3148 == -1) {
				this.field3145 = true;
			}

		}
	}

	@ObfuscatedName("dz")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "139739095"
	)
	public boolean method4417(int var1) {
		return this.validGroups[var1];
	}

	@ObfuscatedName("dj")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "308980057"
	)
	public boolean method4436(int var1) {
		return this.getGroupFileIds(var1) != null;
	}

	@ObfuscatedName("df")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "52"
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
