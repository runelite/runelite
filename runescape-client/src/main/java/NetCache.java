import java.applet.Applet;
import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ip")
@Implements("NetCache")
public class NetCache {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lku;"
	)
	@Export("NetCache_socket")
	public static AbstractSocket NetCache_socket;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 2131672897
	)
	@Export("NetCache_loadTime")
	public static int NetCache_loadTime;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		longValue = -9118761504647630833L
	)
	public static long field3149;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Llh;"
	)
	@Export("NetCache_pendingPriorityWrites")
	public static NodeHashTable NetCache_pendingPriorityWrites;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 2036501335
	)
	@Export("NetCache_pendingPriorityWritesCount")
	public static int NetCache_pendingPriorityWritesCount;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Llh;"
	)
	@Export("NetCache_pendingPriorityResponses")
	public static NodeHashTable NetCache_pendingPriorityResponses;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -158120331
	)
	@Export("NetCache_pendingPriorityResponsesCount")
	public static int NetCache_pendingPriorityResponsesCount;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lia;"
	)
	@Export("NetCache_pendingWritesQueue")
	public static DualNodeDeque NetCache_pendingWritesQueue;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Llh;"
	)
	@Export("NetCache_pendingWrites")
	static NodeHashTable NetCache_pendingWrites;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -1944921257
	)
	@Export("NetCache_pendingWritesCount")
	public static int NetCache_pendingWritesCount;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Llh;"
	)
	@Export("NetCache_pendingResponses")
	public static NodeHashTable NetCache_pendingResponses;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -2059126107
	)
	@Export("NetCache_pendingResponsesCount")
	public static int NetCache_pendingResponsesCount;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lkc;"
	)
	@Export("NetCache_responseHeaderBuffer")
	public static Buffer NetCache_responseHeaderBuffer;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 1307039295
	)
	public static int field3161;
	@ObfuscatedName("s")
	@Export("NetCache_crc")
	public static CRC32 NetCache_crc;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "[Lij;"
	)
	@Export("NetCache_archives")
	public static Archive[] NetCache_archives;
	@ObfuscatedName("f")
	public static byte field3165;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 1710765987
	)
	@Export("NetCache_crcMismatches")
	public static int NetCache_crcMismatches;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 685821675
	)
	@Export("NetCache_ioExceptions")
	public static int NetCache_ioExceptions;

	static {
		NetCache_loadTime = 0;
		NetCache_pendingPriorityWrites = new NodeHashTable(4096);
		NetCache_pendingPriorityWritesCount = 0;
		NetCache_pendingPriorityResponses = new NodeHashTable(32);
		NetCache_pendingPriorityResponsesCount = 0;
		NetCache_pendingWritesQueue = new DualNodeDeque();
		NetCache_pendingWrites = new NodeHashTable(4096);
		NetCache_pendingWritesCount = 0;
		NetCache_pendingResponses = new NodeHashTable(4096);
		NetCache_pendingResponsesCount = 0;
		NetCache_responseHeaderBuffer = new Buffer(8);
		field3161 = 0;
		NetCache_crc = new CRC32();
		NetCache_archives = new Archive[256];
		field3165 = 0;
		NetCache_crcMismatches = 0;
		NetCache_ioExceptions = 0;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Ljava/applet/Applet;Ljava/lang/String;I)V",
		garbageValue = "2000682989"
	)
	public static void method4472(Applet var0, String var1) {
		class51.applet = var0;
		if (var1 != null) {
			class51.field416 = var1;
		}

	}

	@ObfuscatedName("fl")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1138314742"
	)
	@Export("load")
	static void load() {
		int var0;
		if (Client.titleLoadingStage == 0) {
			WorldMapArea.scene = new Scene(4, 104, 104, Tiles.Tiles_heights);

			for (var0 = 0; var0 < 4; ++var0) {
				Client.collisionMaps[var0] = new CollisionMap(104, 104);
			}

			FloorDecoration.sceneMinimapSprite = new Sprite(512, 512);
			Login.Login_loadingText = "Starting game engine...";
			Login.Login_loadingPercent = 5;
			Client.titleLoadingStage = 20;
		} else if (Client.titleLoadingStage == 20) {
			Login.Login_loadingText = "Prepared visibility map";
			Login.Login_loadingPercent = 10;
			Client.titleLoadingStage = 30;
		} else if (Client.titleLoadingStage == 30) {
			BuddyRankComparator.archive0 = WorldMapSectionType.newArchive(0, false, true, true);
			LoginPacket.archive1 = WorldMapSectionType.newArchive(1, false, true, true);
			AbstractWorldMapIcon.archive2 = WorldMapSectionType.newArchive(2, true, false, true);
			SpriteMask.archive3 = WorldMapSectionType.newArchive(3, false, true, true);
			NetFileRequest.archive4 = WorldMapSectionType.newArchive(4, false, true, true);
			WorldMapRectangle.archive5 = WorldMapSectionType.newArchive(5, true, true, true);
			class216.archive6 = WorldMapSectionType.newArchive(6, true, true, true);
			Language.archive7 = WorldMapSectionType.newArchive(7, false, true, true);
			GrandExchangeOfferUnitPriceComparator.archive8 = WorldMapSectionType.newArchive(8, false, true, true);
			WorldMapSprite.archive9 = WorldMapSectionType.newArchive(9, false, true, true);
			WorldMapID.archive10 = WorldMapSectionType.newArchive(10, false, true, true);
			Decimator.archive11 = WorldMapSectionType.newArchive(11, false, true, true);
			Occluder.archive12 = WorldMapSectionType.newArchive(12, false, true, true);
			UrlRequest.archive13 = WorldMapSectionType.newArchive(13, true, false, true);
			class192.archive14 = WorldMapSectionType.newArchive(14, false, true, true);
			Coord.archive15 = WorldMapSectionType.newArchive(15, false, true, true);
			DesktopPlatformInfoProvider.archive17 = WorldMapSectionType.newArchive(17, true, true, true);
			WorldMapDecoration.archive18 = WorldMapSectionType.newArchive(18, false, true, true);
			ReflectionCheck.archive19 = WorldMapSectionType.newArchive(19, false, true, true);
			Actor.archive20 = WorldMapSectionType.newArchive(20, false, true, true);
			Login.Login_loadingText = "Connecting to update server";
			Login.Login_loadingPercent = 20;
			Client.titleLoadingStage = 40;
		} else if (Client.titleLoadingStage == 40) {
			byte var33 = 0;
			var0 = var33 + BuddyRankComparator.archive0.percentage() * 4 / 100;
			var0 += LoginPacket.archive1.percentage() * 4 / 100;
			var0 += AbstractWorldMapIcon.archive2.percentage() * 2 / 100;
			var0 += SpriteMask.archive3.percentage() * 2 / 100;
			var0 += NetFileRequest.archive4.percentage() * 6 / 100;
			var0 += WorldMapRectangle.archive5.percentage() * 4 / 100;
			var0 += class216.archive6.percentage() * 2 / 100;
			var0 += Language.archive7.percentage() * 56 / 100;
			var0 += GrandExchangeOfferUnitPriceComparator.archive8.percentage() * 2 / 100;
			var0 += WorldMapSprite.archive9.percentage() * 2 / 100;
			var0 += WorldMapID.archive10.percentage() * 2 / 100;
			var0 += Decimator.archive11.percentage() * 2 / 100;
			var0 += Occluder.archive12.percentage() * 2 / 100;
			var0 += UrlRequest.archive13.percentage() * 2 / 100;
			var0 += class192.archive14.percentage() * 2 / 100;
			var0 += Coord.archive15.percentage() * 2 / 100;
			var0 += ReflectionCheck.archive19.percentage() / 100;
			var0 += WorldMapDecoration.archive18.percentage() / 100;
			var0 += Actor.archive20.percentage() / 100;
			var0 += DesktopPlatformInfoProvider.archive17.method4409() && DesktopPlatformInfoProvider.archive17.isFullyLoaded() ? 1 : 0;
			if (var0 != 100) {
				if (var0 != 0) {
					Login.Login_loadingText = "Checking for updates - " + var0 + "%";
				}

				Login.Login_loadingPercent = 30;
			} else {
				WorldMapID.method610(BuddyRankComparator.archive0, "Animations");
				WorldMapID.method610(LoginPacket.archive1, "Skeletons");
				WorldMapID.method610(NetFileRequest.archive4, "Sound FX");
				WorldMapID.method610(WorldMapRectangle.archive5, "Maps");
				WorldMapID.method610(class216.archive6, "Music Tracks");
				WorldMapID.method610(Language.archive7, "Models");
				WorldMapID.method610(GrandExchangeOfferUnitPriceComparator.archive8, "Sprites");
				WorldMapID.method610(Decimator.archive11, "Music Jingles");
				WorldMapID.method610(class192.archive14, "Music Samples");
				WorldMapID.method610(Coord.archive15, "Music Patches");
				WorldMapID.method610(ReflectionCheck.archive19, "World Map");
				WorldMapID.method610(WorldMapDecoration.archive18, "World Map Geography");
				WorldMapID.method610(Actor.archive20, "World Map Ground");
				class192.spriteIds = new GraphicsDefaults();
				class192.spriteIds.decode(DesktopPlatformInfoProvider.archive17);
				Login.Login_loadingText = "Loaded update list";
				Login.Login_loadingPercent = 30;
				Client.titleLoadingStage = 45;
			}
		} else if (Client.titleLoadingStage == 45) {
			boolean var32 = !Client.isLowDetail;
			PcmPlayer.PcmPlayer_sampleRate = 486202500;
			InterfaceParent.PcmPlayer_stereo = var32;
			ParamDefinition.PcmPlayer_count = 2;
			MidiPcmStream var28 = new MidiPcmStream();
			var28.method3899(9, 128);
			class80.pcmPlayer0 = PendingSpawn.method1856(GameShell.taskHandler, 0, 22050);
			class80.pcmPlayer0.setStream(var28);
			Clock.method3641(Coord.archive15, class192.archive14, NetFileRequest.archive4, var28);
			MenuAction.pcmPlayer1 = PendingSpawn.method1856(GameShell.taskHandler, 1, 2048);
			FloorUnderlayDefinition.pcmStreamMixer = new PcmStreamMixer();
			MenuAction.pcmPlayer1.setStream(FloorUnderlayDefinition.pcmStreamMixer);
			AbstractWorldMapIcon.decimator = new Decimator(22050, PcmPlayer.PcmPlayer_sampleRate * 22050);
			Login.Login_loadingText = "Prepared sound engine";
			Login.Login_loadingPercent = 35;
			Client.titleLoadingStage = 50;
			ModelData0.WorldMapElement_fonts = new Fonts(GrandExchangeOfferUnitPriceComparator.archive8, UrlRequest.archive13);
		} else {
			int var20;
			if (Client.titleLoadingStage == 50) {
				FontName[] var35 = new FontName[]{FontName.FontName_verdana15, FontName.FontName_verdana13, FontName.FontName_verdana11, FontName.FontName_bold12, FontName.FontName_plain11, FontName.FontName_plain12};
				var20 = var35.length;
				Fonts var25 = ModelData0.WorldMapElement_fonts;
				FontName[] var26 = new FontName[]{FontName.FontName_verdana15, FontName.FontName_verdana13, FontName.FontName_verdana11, FontName.FontName_bold12, FontName.FontName_plain11, FontName.FontName_plain12};
				Client.fontsMap = var25.createMap(var26);
				if (Client.fontsMap.size() < var20) {
					Login.Login_loadingText = "Loading fonts - " + Client.fontsMap.size() * 100 / var20 + "%";
					Login.Login_loadingPercent = 40;
				} else {
					class51.fontPlain11 = (Font)Client.fontsMap.get(FontName.FontName_plain11);
					ArchiveDiskActionHandler.fontPlain12 = (Font)Client.fontsMap.get(FontName.FontName_plain12);
					class43.fontBold12 = (Font)Client.fontsMap.get(FontName.FontName_bold12);
					class216.platformInfo = Client.platformInfoProvider.get();
					Login.Login_loadingText = "Loaded fonts";
					Login.Login_loadingPercent = 40;
					Client.titleLoadingStage = 60;
				}
			} else if (Client.titleLoadingStage == 60) {
				var0 = GrandExchangeOfferNameComparator.method182(WorldMapID.archive10, GrandExchangeOfferUnitPriceComparator.archive8);
				var20 = MusicPatch.method4037();
				if (var0 < var20) {
					Login.Login_loadingText = "Loading title screen - " + var0 * 100 / var20 + "%";
					Login.Login_loadingPercent = 50;
				} else {
					Login.Login_loadingText = "Loaded title screen";
					Login.Login_loadingPercent = 50;
					Tile.updateGameState(5);
					Client.titleLoadingStage = 70;
				}
			} else {
				Archive var2;
				if (Client.titleLoadingStage == 70) {
					if (!AbstractWorldMapIcon.archive2.isFullyLoaded()) {
						Login.Login_loadingText = "Loading config - " + AbstractWorldMapIcon.archive2.loadPercent() + "%";
						Login.Login_loadingPercent = 60;
					} else {
						ArchiveLoader.method1235(AbstractWorldMapIcon.archive2);
						MusicPatchNode2.method3831(AbstractWorldMapIcon.archive2);
						Archive var34 = AbstractWorldMapIcon.archive2;
						Archive var27 = Language.archive7;
						KitDefinition.KitDefinition_archive = var34;
						class43.KitDefinition_modelsArchive = var27;
						KitDefinition.KitDefinition_fileCount = KitDefinition.KitDefinition_archive.getGroupFileCount(3);
						var2 = AbstractWorldMapIcon.archive2;
						Archive var3 = Language.archive7;
						boolean var29 = Client.isLowDetail;
						ObjectDefinition.ObjectDefinition_archive = var2;
						ObjectDefinition.ObjectDefinition_modelsArchive = var3;
						ObjectDefinition.ObjectDefinition_isLowDetail = var29;
						Script.method2373(AbstractWorldMapIcon.archive2, Language.archive7);
						Archive var30 = AbstractWorldMapIcon.archive2;
						StructDefinition.StructDefinition_archive = var30;
						Archive var6 = AbstractWorldMapIcon.archive2;
						Archive var31 = Language.archive7;
						boolean var8 = Client.isMembersWorld;
						Font var9 = class51.fontPlain11;
						ItemDefinition.ItemDefinition_archive = var6;
						ItemDefinition.ItemDefinition_modelArchive = var31;
						ItemDefinition.ItemDefinition_inMembersWorld = var8;
						ItemDefinition.ItemDefinition_fileCount = ItemDefinition.ItemDefinition_archive.getGroupFileCount(10);
						class30.ItemDefinition_fontPlain11 = var9;
						class197.method3845(AbstractWorldMapIcon.archive2, BuddyRankComparator.archive0, LoginPacket.archive1);
						PacketWriter.method2419(AbstractWorldMapIcon.archive2, Language.archive7);
						AttackOption.method2221(AbstractWorldMapIcon.archive2);
						WorldMapSection0.method263(AbstractWorldMapIcon.archive2);
						TileItemPile.Widget_setArchives(SpriteMask.archive3, Language.archive7, GrandExchangeOfferUnitPriceComparator.archive8, UrlRequest.archive13);
						Archive var10 = AbstractWorldMapIcon.archive2;
						class1.InvDefinition_archive = var10;
						class30.method607(AbstractWorldMapIcon.archive2);
						Archive var11 = AbstractWorldMapIcon.archive2;
						VarcInt.VarcInt_archive = var11;
						Archive var12 = AbstractWorldMapIcon.archive2;
						ParamDefinition.ParamDefinition_archive = var12;
						class1.varcs = new Varcs();
						TaskHandler.method3622(AbstractWorldMapIcon.archive2, GrandExchangeOfferUnitPriceComparator.archive8, UrlRequest.archive13);
						Archive var13 = AbstractWorldMapIcon.archive2;
						Archive var14 = GrandExchangeOfferUnitPriceComparator.archive8;
						HealthBarDefinition.HealthBarDefinition_archive = var13;
						HealthBarDefinition.HitSplatDefinition_spritesArchive = var14;
						Archive var15 = AbstractWorldMapIcon.archive2;
						Archive var16 = GrandExchangeOfferUnitPriceComparator.archive8;
						WorldMapElement.WorldMapElement_archive = var16;
						if (var15.isFullyLoaded()) {
							AbstractByteArrayCopier.WorldMapElement_count = var15.getGroupFileCount(35);
							GrandExchangeOfferTotalQuantityComparator.WorldMapElement_cached = new WorldMapElement[AbstractByteArrayCopier.WorldMapElement_count];

							for (int var17 = 0; var17 < AbstractByteArrayCopier.WorldMapElement_count; ++var17) {
								byte[] var18 = var15.takeFile(35, var17);
								GrandExchangeOfferTotalQuantityComparator.WorldMapElement_cached[var17] = new WorldMapElement(var17);
								if (var18 != null) {
									GrandExchangeOfferTotalQuantityComparator.WorldMapElement_cached[var17].decode(new Buffer(var18));
									GrandExchangeOfferTotalQuantityComparator.WorldMapElement_cached[var17].method4533();
								}
							}
						}

						Login.Login_loadingText = "Loaded config";
						Login.Login_loadingPercent = 60;
						Client.titleLoadingStage = 80;
					}
				} else if (Client.titleLoadingStage == 80) {
					var0 = 0;
					if (class1.compass == null) {
						class1.compass = MenuAction.SpriteBuffer_getSprite(GrandExchangeOfferUnitPriceComparator.archive8, class192.spriteIds.compass, 0);
					} else {
						++var0;
					}

					if (class4.redHintArrowSprite == null) {
						class4.redHintArrowSprite = MenuAction.SpriteBuffer_getSprite(GrandExchangeOfferUnitPriceComparator.archive8, class192.spriteIds.field3787, 0);
					} else {
						++var0;
					}

					IndexedSprite[] var1;
					IndexedSprite[] var5;
					IndexedSprite var7;
					int var21;
					int var22;
					if (GrandExchangeOfferWorldComparator.mapSceneSprites == null) {
						var2 = GrandExchangeOfferUnitPriceComparator.archive8;
						var21 = class192.spriteIds.mapScenes;
						if (!class32.method618(var2, var21, 0)) {
							var1 = null;
						} else {
							var5 = new IndexedSprite[class325.SpriteBuffer_spriteCount];

							for (var22 = 0; var22 < class325.SpriteBuffer_spriteCount; ++var22) {
								var7 = var5[var22] = new IndexedSprite();
								var7.width = class325.SpriteBuffer_spriteWidth;
								var7.height = class325.SpriteBuffer_spriteHeight;
								var7.xOffset = SecureRandomFuture.SpriteBuffer_xOffsets[var22];
								var7.yOffset = HealthBar.SpriteBuffer_yOffsets[var22];
								var7.subWidth = SecureRandomCallable.SpriteBuffer_spriteWidths[var22];
								var7.subHeight = AttackOption.SpriteBuffer_spriteHeights[var22];
								var7.palette = class325.SpriteBuffer_spritePalette;
								var7.pixels = class325.SpriteBuffer_pixels[var22];
							}

							WorldMapData_1.method787();
							var1 = var5;
						}

						GrandExchangeOfferWorldComparator.mapSceneSprites = var1;
					} else {
						++var0;
					}

					if (FriendLoginUpdate.headIconPkSprites == null) {
						FriendLoginUpdate.headIconPkSprites = class83.SpriteBuffer_getSpriteArray(GrandExchangeOfferUnitPriceComparator.archive8, class192.spriteIds.headIconsPk, 0);
					} else {
						++var0;
					}

					if (Login.headIconPrayerSprites == null) {
						Login.headIconPrayerSprites = class83.SpriteBuffer_getSpriteArray(GrandExchangeOfferUnitPriceComparator.archive8, class192.spriteIds.field3790, 0);
					} else {
						++var0;
					}

					if (class14.headIconHintSprites == null) {
						class14.headIconHintSprites = class83.SpriteBuffer_getSpriteArray(GrandExchangeOfferUnitPriceComparator.archive8, class192.spriteIds.field3786, 0);
					} else {
						++var0;
					}

					if (GrandExchangeOfferOwnWorldComparator.mapMarkerSprites == null) {
						GrandExchangeOfferOwnWorldComparator.mapMarkerSprites = class83.SpriteBuffer_getSpriteArray(GrandExchangeOfferUnitPriceComparator.archive8, class192.spriteIds.field3791, 0);
					} else {
						++var0;
					}

					if (TextureProvider.crossSprites == null) {
						TextureProvider.crossSprites = class83.SpriteBuffer_getSpriteArray(GrandExchangeOfferUnitPriceComparator.archive8, class192.spriteIds.field3793, 0);
					} else {
						++var0;
					}

					if (class42.mapDotSprites == null) {
						class42.mapDotSprites = class83.SpriteBuffer_getSpriteArray(GrandExchangeOfferUnitPriceComparator.archive8, class192.spriteIds.field3794, 0);
					} else {
						++var0;
					}

					if (NetSocket.scrollBarSprites == null) {
						var2 = GrandExchangeOfferUnitPriceComparator.archive8;
						var21 = class192.spriteIds.field3795;
						if (!class32.method618(var2, var21, 0)) {
							var1 = null;
						} else {
							var5 = new IndexedSprite[class325.SpriteBuffer_spriteCount];

							for (var22 = 0; var22 < class325.SpriteBuffer_spriteCount; ++var22) {
								var7 = var5[var22] = new IndexedSprite();
								var7.width = class325.SpriteBuffer_spriteWidth;
								var7.height = class325.SpriteBuffer_spriteHeight;
								var7.xOffset = SecureRandomFuture.SpriteBuffer_xOffsets[var22];
								var7.yOffset = HealthBar.SpriteBuffer_yOffsets[var22];
								var7.subWidth = SecureRandomCallable.SpriteBuffer_spriteWidths[var22];
								var7.subHeight = AttackOption.SpriteBuffer_spriteHeights[var22];
								var7.palette = class325.SpriteBuffer_spritePalette;
								var7.pixels = class325.SpriteBuffer_pixels[var22];
							}

							WorldMapData_1.method787();
							var1 = var5;
						}

						NetSocket.scrollBarSprites = var1;
					} else {
						++var0;
					}

					if (VarcInt.modIconSprites == null) {
						var2 = GrandExchangeOfferUnitPriceComparator.archive8;
						var21 = class192.spriteIds.field3796;
						if (!class32.method618(var2, var21, 0)) {
							var1 = null;
						} else {
							var5 = new IndexedSprite[class325.SpriteBuffer_spriteCount];

							for (var22 = 0; var22 < class325.SpriteBuffer_spriteCount; ++var22) {
								var7 = var5[var22] = new IndexedSprite();
								var7.width = class325.SpriteBuffer_spriteWidth;
								var7.height = class325.SpriteBuffer_spriteHeight;
								var7.xOffset = SecureRandomFuture.SpriteBuffer_xOffsets[var22];
								var7.yOffset = HealthBar.SpriteBuffer_yOffsets[var22];
								var7.subWidth = SecureRandomCallable.SpriteBuffer_spriteWidths[var22];
								var7.subHeight = AttackOption.SpriteBuffer_spriteHeights[var22];
								var7.palette = class325.SpriteBuffer_spritePalette;
								var7.pixels = class325.SpriteBuffer_pixels[var22];
							}

							WorldMapData_1.method787();
							var1 = var5;
						}

						VarcInt.modIconSprites = var1;
					} else {
						++var0;
					}

					if (var0 < 11) {
						Login.Login_loadingText = "Loading sprites - " + var0 * 100 / 12 + "%";
						Login.Login_loadingPercent = 70;
					} else {
						AbstractFont.AbstractFont_modIconSprites = VarcInt.modIconSprites;
						class4.redHintArrowSprite.normalize();
						var20 = (int)(Math.random() * 21.0D) - 10;
						int var24 = (int)(Math.random() * 21.0D) - 10;
						var21 = (int)(Math.random() * 21.0D) - 10;
						int var4 = (int)(Math.random() * 41.0D) - 20;
						GrandExchangeOfferWorldComparator.mapSceneSprites[0].shiftColors(var4 + var20, var24 + var4, var4 + var21);
						Login.Login_loadingText = "Loaded sprites";
						Login.Login_loadingPercent = 70;
						Client.titleLoadingStage = 90;
					}
				} else if (Client.titleLoadingStage == 90) {
					if (!WorldMapSprite.archive9.isFullyLoaded()) {
						Login.Login_loadingText = "Loading textures - " + "0%";
						Login.Login_loadingPercent = 90;
					} else {
						WorldMapArea.textureProvider = new TextureProvider(WorldMapSprite.archive9, GrandExchangeOfferUnitPriceComparator.archive8, 20, 0.8D, Client.isLowDetail ? 64 : 128);
						Rasterizer3D.Rasterizer3D_setTextureLoader(WorldMapArea.textureProvider);
						Rasterizer3D.Rasterizer3D_setBrightness(0.8D);
						Client.titleLoadingStage = 100;
					}
				} else if (Client.titleLoadingStage == 100) {
					var0 = WorldMapArea.textureProvider.getLoadedPercentage();
					if (var0 < 100) {
						Login.Login_loadingText = "Loading textures - " + var0 + "%";
						Login.Login_loadingPercent = 90;
					} else {
						Login.Login_loadingText = "Loaded textures";
						Login.Login_loadingPercent = 90;
						Client.titleLoadingStage = 110;
					}
				} else if (Client.titleLoadingStage == 110) {
					class3.mouseRecorder = new MouseRecorder();
					GameShell.taskHandler.newThreadTask(class3.mouseRecorder, 10);
					Login.Login_loadingText = "Loaded input handler";
					Login.Login_loadingPercent = 92;
					Client.titleLoadingStage = 120;
				} else if (Client.titleLoadingStage == 120) {
					if (!WorldMapID.archive10.tryLoadFileByNames("huffman", "")) {
						Login.Login_loadingText = "Loading wordpack - " + 0 + "%";
						Login.Login_loadingPercent = 94;
					} else {
						Huffman var19 = new Huffman(WorldMapID.archive10.takeFileByNames("huffman", ""));
						VerticalAlignment.method4504(var19);
						Login.Login_loadingText = "Loaded wordpack";
						Login.Login_loadingPercent = 94;
						Client.titleLoadingStage = 130;
					}
				} else if (Client.titleLoadingStage == 130) {
					if (!SpriteMask.archive3.isFullyLoaded()) {
						Login.Login_loadingText = "Loading interfaces - " + SpriteMask.archive3.loadPercent() * 4 / 5 + "%";
						Login.Login_loadingPercent = 96;
					} else if (!Occluder.archive12.isFullyLoaded()) {
						Login.Login_loadingText = "Loading interfaces - " + (80 + Occluder.archive12.loadPercent() / 6) + "%";
						Login.Login_loadingPercent = 96;
					} else if (!UrlRequest.archive13.isFullyLoaded()) {
						Login.Login_loadingText = "Loading interfaces - " + (96 + UrlRequest.archive13.loadPercent() / 50) + "%";
						Login.Login_loadingPercent = 96;
					} else {
						Login.Login_loadingText = "Loaded interfaces";
						Login.Login_loadingPercent = 98;
						Client.titleLoadingStage = 140;
					}
				} else if (Client.titleLoadingStage == 140) {
					Login.Login_loadingPercent = 100;
					if (!ReflectionCheck.archive19.tryLoadGroupByName(WorldMapCacheName.field288.name)) {
						Login.Login_loadingText = "Loading world map - " + ReflectionCheck.archive19.groupLoadPercentByName(WorldMapCacheName.field288.name) / 10 + "%";
					} else {
						if (Login.worldMap == null) {
							Login.worldMap = new WorldMap();
							Login.worldMap.init(ReflectionCheck.archive19, WorldMapDecoration.archive18, Actor.archive20, class43.fontBold12, Client.fontsMap, GrandExchangeOfferWorldComparator.mapSceneSprites);
						}

						Login.Login_loadingText = "Loaded world map";
						Client.titleLoadingStage = 150;
					}
				} else if (Client.titleLoadingStage == 150) {
					Tile.updateGameState(10);
				}
			}
		}
	}
}
