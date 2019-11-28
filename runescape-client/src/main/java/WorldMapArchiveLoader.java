import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lr")
@Implements("WorldMapArchiveLoader")
public class WorldMapArchiveLoader {
	@ObfuscatedName("z")
	@Export("cacheName")
	String cacheName;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lhf;"
	)
	@Export("archive")
	AbstractArchive archive;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -1643456433
	)
	@Export("percentLoaded")
	int percentLoaded;
	@ObfuscatedName("y")
	@Export("loaded")
	boolean loaded;

	@ObfuscatedSignature(
		signature = "(Lhf;)V"
	)
	WorldMapArchiveLoader(AbstractArchive var1) {
		this.percentLoaded = 0;
		this.loaded = false;
		this.archive = var1;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "-102"
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

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "421887253"
	)
	@Export("load")
	int load() {
		if (this.percentLoaded < 33) {
			if (!this.archive.tryLoadFileByNames(WorldMapCacheName.field303.name, this.cacheName)) {
				return this.percentLoaded;
			}

			this.percentLoaded = 33;
		}

		if (this.percentLoaded == 33) {
			if (this.archive.isValidFileName(WorldMapCacheName.field307.name, this.cacheName) && !this.archive.tryLoadFileByNames(WorldMapCacheName.field307.name, this.cacheName)) {
				return this.percentLoaded;
			}

			this.percentLoaded = 66;
		}

		if (this.percentLoaded == 66) {
			if (!this.archive.tryLoadFileByNames(this.cacheName, WorldMapCacheName.field306.name)) {
				return this.percentLoaded;
			}

			this.percentLoaded = 100;
			this.loaded = true;
		}

		return this.percentLoaded;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-2116319250"
	)
	@Export("isLoaded")
	boolean isLoaded() {
		return this.loaded;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-54"
	)
	@Export("getPercentLoaded")
	int getPercentLoaded() {
		return this.percentLoaded;
	}
}
