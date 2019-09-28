import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lj")
@Implements("WorldMapArchiveLoader")
public class WorldMapArchiveLoader {
	@ObfuscatedName("r")
	@Export("cacheName")
	String cacheName;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("archive")
	AbstractArchive archive;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -1787474783
	)
	@Export("percentLoaded")
	int percentLoaded;
	@ObfuscatedName("m")
	@Export("loaded")
	boolean loaded;

	@ObfuscatedSignature(
		signature = "(Lhp;)V"
	)
	WorldMapArchiveLoader(AbstractArchive var1) {
		this.percentLoaded = 0;
		this.loaded = false;
		this.archive = var1;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "98"
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

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1938361839"
	)
	@Export("load")
	int load() {
		if (this.percentLoaded < 33) {
			if (!this.archive.tryLoadFileByNames(WorldMapCacheName.field289.name, this.cacheName)) {
				return this.percentLoaded;
			}

			this.percentLoaded = 33;
		}

		if (this.percentLoaded == 33) {
			if (this.archive.isValidFileName(WorldMapCacheName.field283.name, this.cacheName) && !this.archive.tryLoadFileByNames(WorldMapCacheName.field283.name, this.cacheName)) {
				return this.percentLoaded;
			}

			this.percentLoaded = 66;
		}

		if (this.percentLoaded == 66) {
			if (!this.archive.tryLoadFileByNames(this.cacheName, WorldMapCacheName.field287.name)) {
				return this.percentLoaded;
			}

			this.percentLoaded = 100;
			this.loaded = true;
		}

		return this.percentLoaded;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "741397645"
	)
	@Export("isLoaded")
	boolean isLoaded() {
		return this.loaded;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1707041754"
	)
	@Export("getPercentLoaded")
	int getPercentLoaded() {
		return this.percentLoaded;
	}
}
