import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("la")
@Implements("WorldMapArchiveLoader")
public class WorldMapArchiveLoader {
	@ObfuscatedName("u")
	@Export("cacheName")
	String cacheName;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("archive")
	AbstractArchive archive;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -726522089
	)
	@Export("percentLoaded")
	int percentLoaded;
	@ObfuscatedName("q")
	@Export("loaded")
	boolean loaded;

	@ObfuscatedSignature(
		signature = "(Lhz;)V"
	)
	WorldMapArchiveLoader(AbstractArchive var1) {
		this.percentLoaded = 0;
		this.loaded = false;
		this.archive = var1;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "-7"
	)
	@Export("reset")
	void reset(String var1) {
		if (var1 != null && !var1.isEmpty()) {
			if (var1 != this.cacheName) {
				this.cacheName = var1;
				this.percentLoaded = 0;
				this.loaded = false;
				this.load();
			}
		}
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1496070348"
	)
	@Export("load")
	int load() {
		if (this.percentLoaded < 33) {
			if (!this.archive.tryLoadFileByNames(WorldMapCacheName.field290.name, this.cacheName)) {
				return this.percentLoaded;
			}

			this.percentLoaded = 33;
		}

		if (this.percentLoaded == 33) {
			if (this.archive.isValidFileName(WorldMapCacheName.field291.name, this.cacheName) && !this.archive.tryLoadFileByNames(WorldMapCacheName.field291.name, this.cacheName)) {
				return this.percentLoaded;
			}

			this.percentLoaded = 66;
		}

		if (this.percentLoaded == 66) {
			if (!this.archive.tryLoadFileByNames(this.cacheName, WorldMapCacheName.field293.name)) {
				return this.percentLoaded;
			}

			this.percentLoaded = 100;
			this.loaded = true;
		}

		return this.percentLoaded;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "30"
	)
	@Export("isLoaded")
	boolean isLoaded() {
		return this.loaded;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-94"
	)
	@Export("getPercentLoaded")
	int getPercentLoaded() {
		return this.percentLoaded;
	}
}
