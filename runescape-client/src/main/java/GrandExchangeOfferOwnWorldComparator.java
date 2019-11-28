import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bw")
@Implements("GrandExchangeOfferOwnWorldComparator")
public class GrandExchangeOfferOwnWorldComparator implements Comparator {
	@ObfuscatedName("qx")
	@ObfuscatedGetter(
		intValue = 785039360
	)
	static int field639;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lez;"
	)
	@Export("World_request")
	static UrlRequest World_request;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 1039309317
	)
	@Export("loginBoxCenter")
	static int loginBoxCenter;
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		signature = "Llw;"
	)
	static Bounds field638;
	@ObfuscatedName("u")
	@Export("filterWorlds")
	boolean filterWorlds;

	GrandExchangeOfferOwnWorldComparator() {
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Ly;Ly;I)I",
		garbageValue = "415242896"
	)
	@Export("compare_bridged")
	int compare_bridged(GrandExchangeEvent var1, GrandExchangeEvent var2) {
		if (var2.world == var1.world) {
			return 0;
		} else {
			if (this.filterWorlds) {
				if (Client.worldId == var1.world) {
					return -1;
				}

				if (var2.world == Client.worldId) {
					return 1;
				}
			}

			return var1.world < var2.world ? -1 : 1;
		}
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	public int compare(Object var1, Object var2) {
		return this.compare_bridged((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
	}

	@ObfuscatedName("fj")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2027936966"
	)
	@Export("load")
	static void load() {
		int var0;
		if (Client.titleLoadingStage == 0) {
			class2.scene = new Scene(4, 104, 104, Tiles.Tiles_heights);

			for (var0 = 0; var0 < 4; ++var0) {
				Client.collisionMaps[var0] = new CollisionMap(104, 104);
			}

			Interpreter.sceneMinimapSprite = new Sprite(512, 512);
			Login.Login_loadingText = "Starting game engine...";
			Login.Login_loadingPercent = 5;
			Client.titleLoadingStage = 20;
		} else if (Client.titleLoadingStage == 20) {
			Login.Login_loadingText = "Prepared visibility map";
			Login.Login_loadingPercent = 10;
			Client.titleLoadingStage = 30;
		} else if (Client.titleLoadingStage == 30) {
			GrandExchangeOfferAgeComparator.archive0 = GameShell.newArchive(0, false, true, true);
			class43.archive1 = GameShell.newArchive(1, false, true, true);
			class288.archive2 = GameShell.newArchive(2, true, false, true);
			WorldMapID.archive3 = GameShell.newArchive(3, false, true, true);
			SpriteMask.archive4 = GameShell.newArchive(4, false, true, true);
			DirectByteArrayCopier.archive5 = GameShell.newArchive(5, true, true, true);
			AbstractWorldMapData.archive6 = GameShell.newArchive(6, true, true, true);
			ClientPacket.archive7 = GameShell.newArchive(7, false, true, true);
			WorldMapRegion.archive8 = GameShell.newArchive(8, false, true, true);
			class2.archive9 = GameShell.newArchive(9, false, true, true);
			class81.archive10 = GameShell.newArchive(10, false, true, true);
			ScriptFrame.archive11 = GameShell.newArchive(11, false, true, true);
			class267.archive12 = GameShell.newArchive(12, false, true, true);
			class269.archive13 = GameShell.newArchive(13, true, false, true);
			class162.archive14 = GameShell.newArchive(14, false, true, true);
			class210.archive15 = GameShell.newArchive(15, false, true, true);
			AbstractWorldMapIcon.archive17 = GameShell.newArchive(17, true, true, true);
			UserComparator9.archive18 = GameShell.newArchive(18, false, true, true);
			class13.archive19 = GameShell.newArchive(19, false, true, true);
			class60.archive20 = GameShell.newArchive(20, false, true, true);
			Login.Login_loadingText = "Connecting to update server";
			Login.Login_loadingPercent = 20;
			Client.titleLoadingStage = 40;
		} else if (Client.titleLoadingStage == 40) {
			byte var30 = 0;
			var0 = var30 + GrandExchangeOfferAgeComparator.archive0.percentage() * 4 / 100;
			var0 += class43.archive1.percentage() * 4 / 100;
			var0 += class288.archive2.percentage() * 2 / 100;
			var0 += WorldMapID.archive3.percentage() * 2 / 100;
			var0 += SpriteMask.archive4.percentage() * 6 / 100;
			var0 += DirectByteArrayCopier.archive5.percentage() * 4 / 100;
			var0 += AbstractWorldMapData.archive6.percentage() * 2 / 100;
			var0 += ClientPacket.archive7.percentage() * 56 / 100;
			var0 += WorldMapRegion.archive8.percentage() * 2 / 100;
			var0 += class2.archive9.percentage() * 2 / 100;
			var0 += class81.archive10.percentage() * 2 / 100;
			var0 += ScriptFrame.archive11.percentage() * 2 / 100;
			var0 += class267.archive12.percentage() * 2 / 100;
			var0 += class269.archive13.percentage() * 2 / 100;
			var0 += class162.archive14.percentage() * 2 / 100;
			var0 += class210.archive15.percentage() * 2 / 100;
			var0 += class13.archive19.percentage() / 100;
			var0 += UserComparator9.archive18.percentage() / 100;
			var0 += class60.archive20.percentage() / 100;
			var0 += AbstractWorldMapIcon.archive17.method4345() && AbstractWorldMapIcon.archive17.isFullyLoaded() ? 1 : 0;
			if (var0 != 100) {
				if (var0 != 0) {
					Login.Login_loadingText = "Checking for updates - " + var0 + "%";
				}

				Login.Login_loadingPercent = 30;
			} else {
				class266.method5064(GrandExchangeOfferAgeComparator.archive0, "Animations");
				class266.method5064(class43.archive1, "Skeletons");
				class266.method5064(SpriteMask.archive4, "Sound FX");
				class266.method5064(DirectByteArrayCopier.archive5, "Maps");
				class266.method5064(AbstractWorldMapData.archive6, "Music Tracks");
				class266.method5064(ClientPacket.archive7, "Models");
				class266.method5064(WorldMapRegion.archive8, "Sprites");
				class266.method5064(ScriptFrame.archive11, "Music Jingles");
				class266.method5064(class162.archive14, "Music Samples");
				class266.method5064(class210.archive15, "Music Patches");
				class266.method5064(class13.archive19, "World Map");
				class266.method5064(UserComparator9.archive18, "World Map Geography");
				class266.method5064(class60.archive20, "World Map Ground");
				Actor.spriteIds = new GraphicsDefaults();
				Actor.spriteIds.decode(AbstractWorldMapIcon.archive17);
				Login.Login_loadingText = "Loaded update list";
				Login.Login_loadingPercent = 30;
				Client.titleLoadingStage = 45;
			}
		} else if (Client.titleLoadingStage == 45) {
			GrandExchangeOfferAgeComparator.method170(22050, !Client.isLowDetail, 2);
			MidiPcmStream var33 = new MidiPcmStream();
			var33.method3775(9, 128);
			MenuAction.pcmPlayer0 = HealthBarUpdate.method1776(GameShell.taskHandler, 0, 22050);
			MenuAction.pcmPlayer0.setStream(var33);
			BuddyRankComparator.method3483(class210.archive15, class162.archive14, SpriteMask.archive4, var33);
			class60.pcmPlayer1 = HealthBarUpdate.method1776(GameShell.taskHandler, 1, 2048);
			ClientPacket.pcmStreamMixer = new PcmStreamMixer();
			class60.pcmPlayer1.setStream(ClientPacket.pcmStreamMixer);
			LoginScreenAnimation.decimator = new Decimator(22050, Messages.PcmPlayer_sampleRate);
			Login.Login_loadingText = "Prepared sound engine";
			Login.Login_loadingPercent = 35;
			Client.titleLoadingStage = 50;
			WorldMapID.WorldMapElement_fonts = new Fonts(WorldMapRegion.archive8, class269.archive13);
		} else {
			int var1;
			if (Client.titleLoadingStage == 50) {
				FontName[] var32 = new FontName[]{FontName.FontName_verdana13, FontName.FontName_bold12, FontName.FontName_verdana11, FontName.FontName_plain12, FontName.FontName_verdana15, FontName.FontName_plain11};
				var1 = var32.length;
				Fonts var28 = WorldMapID.WorldMapElement_fonts;
				FontName[] var27 = new FontName[]{FontName.FontName_verdana13, FontName.FontName_bold12, FontName.FontName_verdana11, FontName.FontName_plain12, FontName.FontName_verdana15, FontName.FontName_plain11};
				Client.fontsMap = var28.createMap(var27);
				if (Client.fontsMap.size() < var1) {
					Login.Login_loadingText = "Loading fonts - " + Client.fontsMap.size() * 100 / var1 + "%";
					Login.Login_loadingPercent = 40;
				} else {
					AttackOption.fontPlain11 = (Font)Client.fontsMap.get(FontName.FontName_plain11);
					Player.fontPlain12 = (Font)Client.fontsMap.get(FontName.FontName_plain12);
					JagexCache.fontBold12 = (Font)Client.fontsMap.get(FontName.FontName_bold12);
					NPC.platformInfo = Client.platformInfoProvider.get();
					Login.Login_loadingText = "Loaded fonts";
					Login.Login_loadingPercent = 40;
					Client.titleLoadingStage = 60;
				}
			} else {
				Archive var2;
				int var23;
				Archive var34;
				if (Client.titleLoadingStage == 60) {
					var34 = class81.archive10;
					var2 = WorldMapRegion.archive8;
					var23 = 0;
					if (var34.tryLoadFileByNames("title.jpg", "")) {
						++var23;
					}

					if (var2.tryLoadFileByNames("logo", "")) {
						++var23;
					}

					if (var2.tryLoadFileByNames("logo_deadman_mode", "")) {
						++var23;
					}

					if (var2.tryLoadFileByNames("logo_seasonal_mode", "")) {
						++var23;
					}

					if (var2.tryLoadFileByNames("titlebox", "")) {
						++var23;
					}

					if (var2.tryLoadFileByNames("titlebutton", "")) {
						++var23;
					}

					if (var2.tryLoadFileByNames("runes", "")) {
						++var23;
					}

					if (var2.tryLoadFileByNames("title_mute", "")) {
						++var23;
					}

					if (var2.tryLoadFileByNames("options_radio_buttons,0", "")) {
						++var23;
					}

					if (var2.tryLoadFileByNames("options_radio_buttons,2", "")) {
						++var23;
					}

					if (var2.tryLoadFileByNames("options_radio_buttons,4", "")) {
						++var23;
					}

					if (var2.tryLoadFileByNames("options_radio_buttons,6", "")) {
						++var23;
					}

					var2.tryLoadFileByNames("sl_back", "");
					var2.tryLoadFileByNames("sl_flags", "");
					var2.tryLoadFileByNames("sl_arrows", "");
					var2.tryLoadFileByNames("sl_stars", "");
					var2.tryLoadFileByNames("sl_button", "");
					byte var29 = 12;
					if (var23 < var29) {
						Login.Login_loadingText = "Loading title screen - " + var23 * 100 / var29 + "%";
						Login.Login_loadingPercent = 50;
					} else {
						Login.Login_loadingText = "Loaded title screen";
						Login.Login_loadingPercent = 50;
						class81.updateGameState(5);
						Client.titleLoadingStage = 70;
					}
				} else if (Client.titleLoadingStage == 70) {
					if (!class288.archive2.isFullyLoaded()) {
						Login.Login_loadingText = "Loading config - " + class288.archive2.loadPercent() + "%";
						Login.Login_loadingPercent = 60;
					} else {
						Archive var31 = class288.archive2;
						FloorOverlayDefinition.FloorOverlayDefinition_archive = var31;
						var34 = class288.archive2;
						FloorUnderlayDefinition.FloorUnderlayDefinition_archive = var34;
						CollisionMap.method3615(class288.archive2, ClientPacket.archive7);
						AbstractWorldMapIcon.method625(class288.archive2, ClientPacket.archive7, Client.isLowDetail);
						var2 = class288.archive2;
						Archive var3 = ClientPacket.archive7;
						NPCDefinition.NpcDefinition_archive = var2;
						NPCDefinition.NpcDefinition_modelArchive = var3;
						NetFileRequest.method4230(class288.archive2);
						SoundSystem.method2529(class288.archive2, ClientPacket.archive7, Client.isMembersWorld, AttackOption.fontPlain11);
						class83.method2090(class288.archive2, GrandExchangeOfferAgeComparator.archive0, class43.archive1);
						Archive var24 = class288.archive2;
						Archive var25 = ClientPacket.archive7;
						SpotAnimationDefinition.SpotAnimationDefinition_archive = var24;
						SpotAnimationDefinition.SpotAnimationDefinition_modelArchive = var25;
						class185.method3665(class288.archive2);
						Archive var6 = class288.archive2;
						VarpDefinition.VarpDefinition_archive = var6;
						VarpDefinition.VarpDefinition_fileCount = VarpDefinition.VarpDefinition_archive.getGroupFileCount(16);
						Archive var7 = WorldMapID.archive3;
						Archive var8 = ClientPacket.archive7;
						Archive var9 = WorldMapRegion.archive8;
						Archive var10 = class269.archive13;
						InvDefinition.Widget_archive = var7;
						FriendLoginUpdate.Widget_modelsArchive = var8;
						Widget.Widget_spritesArchive = var9;
						Widget.Widget_fontsArchive = var10;
						FloorDecoration.Widget_interfaceComponents = new Widget[InvDefinition.Widget_archive.getGroupCount()][];
						Widget.Widget_loadedInterfaces = new boolean[InvDefinition.Widget_archive.getGroupCount()];
						Archive var11 = class288.archive2;
						InvDefinition.InvDefinition_archive = var11;
						PacketBufferNode.method3679(class288.archive2);
						Archive var12 = class288.archive2;
						VarcInt.VarcInt_archive = var12;
						Archive var13 = class288.archive2;
						ParamDefinition.ParamDefinition_archive = var13;
						AttackOption.varcs = new Varcs();
						Archive var14 = class288.archive2;
						Archive var15 = WorldMapRegion.archive8;
						Archive var16 = class269.archive13;
						HitSplatDefinition.HitSplatDefinition_archive = var14;
						HitSplatDefinition.field3328 = var15;
						HitSplatDefinition.HitSplatDefinition_fontsArchive = var16;
						Player.method1285(class288.archive2, WorldMapRegion.archive8);
						Archive var17 = class288.archive2;
						Archive var18 = WorldMapRegion.archive8;
						class223.WorldMapElement_archive = var18;
						if (var17.isFullyLoaded()) {
							WorldMapElement.WorldMapElement_count = var17.getGroupFileCount(35);
							WorldMapElement.WorldMapElement_cached = new WorldMapElement[WorldMapElement.WorldMapElement_count];

							for (int var19 = 0; var19 < WorldMapElement.WorldMapElement_count; ++var19) {
								byte[] var20 = var17.takeFile(35, var19);
								WorldMapElement.WorldMapElement_cached[var19] = new WorldMapElement(var19);
								if (var20 != null) {
									WorldMapElement.WorldMapElement_cached[var19].decode(new Buffer(var20));
									WorldMapElement.WorldMapElement_cached[var19].method4461();
								}
							}
						}

						Login.Login_loadingText = "Loaded config";
						Login.Login_loadingPercent = 60;
						Client.titleLoadingStage = 80;
					}
				} else if (Client.titleLoadingStage == 80) {
					var0 = 0;
					if (class40.compass == null) {
						class40.compass = class288.SpriteBuffer_getSprite(WorldMapRegion.archive8, Actor.spriteIds.compass, 0);
					} else {
						++var0;
					}

					if (class225.redHintArrowSprite == null) {
						class225.redHintArrowSprite = class288.SpriteBuffer_getSprite(WorldMapRegion.archive8, Actor.spriteIds.field3808, 0);
					} else {
						++var0;
					}

					IndexedSprite[] var22;
					if (GrandExchangeOfferTotalQuantityComparator.mapSceneSprites == null) {
						var2 = WorldMapRegion.archive8;
						var23 = Actor.spriteIds.mapScenes;
						if (!GraphicsObject.method2030(var2, var23, 0)) {
							var22 = null;
						} else {
							var22 = WallDecoration.method3341();
						}

						GrandExchangeOfferTotalQuantityComparator.mapSceneSprites = var22;
					} else {
						++var0;
					}

					if (FontName.headIconPkSprites == null) {
						FontName.headIconPkSprites = UserComparator5.SpriteBuffer_getSpriteArray(WorldMapRegion.archive8, Actor.spriteIds.headIconsPk, 0);
					} else {
						++var0;
					}

					if (UrlRequest.headIconPrayerSprites == null) {
						UrlRequest.headIconPrayerSprites = UserComparator5.SpriteBuffer_getSpriteArray(WorldMapRegion.archive8, Actor.spriteIds.field3799, 0);
					} else {
						++var0;
					}

					if (SequenceDefinition.headIconHintSprites == null) {
						SequenceDefinition.headIconHintSprites = UserComparator5.SpriteBuffer_getSpriteArray(WorldMapRegion.archive8, Actor.spriteIds.field3804, 0);
					} else {
						++var0;
					}

					if (AttackOption.mapMarkerSprites == null) {
						AttackOption.mapMarkerSprites = UserComparator5.SpriteBuffer_getSpriteArray(WorldMapRegion.archive8, Actor.spriteIds.field3805, 0);
					} else {
						++var0;
					}

					if (KeyHandler.crossSprites == null) {
						KeyHandler.crossSprites = UserComparator5.SpriteBuffer_getSpriteArray(WorldMapRegion.archive8, Actor.spriteIds.field3806, 0);
					} else {
						++var0;
					}

					if (WorldMapData_0.mapDotSprites == null) {
						WorldMapData_0.mapDotSprites = UserComparator5.SpriteBuffer_getSpriteArray(WorldMapRegion.archive8, Actor.spriteIds.field3807, 0);
					} else {
						++var0;
					}

					if (GrandExchangeOfferTotalQuantityComparator.scrollBarSprites == null) {
						var2 = WorldMapRegion.archive8;
						var23 = Actor.spriteIds.field3800;
						if (!GraphicsObject.method2030(var2, var23, 0)) {
							var22 = null;
						} else {
							var22 = WallDecoration.method3341();
						}

						GrandExchangeOfferTotalQuantityComparator.scrollBarSprites = var22;
					} else {
						++var0;
					}

					if (class192.modIconSprites == null) {
						var2 = WorldMapRegion.archive8;
						var23 = Actor.spriteIds.field3809;
						if (!GraphicsObject.method2030(var2, var23, 0)) {
							var22 = null;
						} else {
							var22 = WallDecoration.method3341();
						}

						class192.modIconSprites = var22;
					} else {
						++var0;
					}

					if (var0 < 11) {
						Login.Login_loadingText = "Loading sprites - " + var0 * 100 / 12 + "%";
						Login.Login_loadingPercent = 70;
					} else {
						AbstractFont.AbstractFont_modIconSprites = class192.modIconSprites;
						class225.redHintArrowSprite.normalize();
						var1 = (int)(Math.random() * 21.0D) - 10;
						int var26 = (int)(Math.random() * 21.0D) - 10;
						var23 = (int)(Math.random() * 21.0D) - 10;
						int var4 = (int)(Math.random() * 41.0D) - 20;
						GrandExchangeOfferTotalQuantityComparator.mapSceneSprites[0].shiftColors(var4 + var1, var26 + var4, var4 + var23);
						Login.Login_loadingText = "Loaded sprites";
						Login.Login_loadingPercent = 70;
						Client.titleLoadingStage = 90;
					}
				} else if (Client.titleLoadingStage == 90) {
					if (!class2.archive9.isFullyLoaded()) {
						Login.Login_loadingText = "Loading textures - " + "0%";
						Login.Login_loadingPercent = 90;
					} else {
						JagexCache.textureProvider = new TextureProvider(class2.archive9, WorldMapRegion.archive8, 20, 0.8D, Client.isLowDetail ? 64 : 128);
						Rasterizer3D.Rasterizer3D_setTextureLoader(JagexCache.textureProvider);
						Rasterizer3D.Rasterizer3D_setBrightness(0.8D);
						Client.titleLoadingStage = 100;
					}
				} else if (Client.titleLoadingStage == 100) {
					var0 = JagexCache.textureProvider.getLoadedPercentage();
					if (var0 < 100) {
						Login.Login_loadingText = "Loading textures - " + var0 + "%";
						Login.Login_loadingPercent = 90;
					} else {
						Login.Login_loadingText = "Loaded textures";
						Login.Login_loadingPercent = 90;
						Client.titleLoadingStage = 110;
					}
				} else if (Client.titleLoadingStage == 110) {
					class2.mouseRecorder = new MouseRecorder();
					GameShell.taskHandler.newThreadTask(class2.mouseRecorder, 10);
					Login.Login_loadingText = "Loaded input handler";
					Login.Login_loadingPercent = 92;
					Client.titleLoadingStage = 120;
				} else if (Client.titleLoadingStage == 120) {
					if (!class81.archive10.tryLoadFileByNames("huffman", "")) {
						Login.Login_loadingText = "Loading wordpack - " + 0 + "%";
						Login.Login_loadingPercent = 94;
					} else {
						Huffman var21 = new Huffman(class81.archive10.takeFileByNames("huffman", ""));
						Messages.method2230(var21);
						Login.Login_loadingText = "Loaded wordpack";
						Login.Login_loadingPercent = 94;
						Client.titleLoadingStage = 130;
					}
				} else if (Client.titleLoadingStage == 130) {
					if (!WorldMapID.archive3.isFullyLoaded()) {
						Login.Login_loadingText = "Loading interfaces - " + WorldMapID.archive3.loadPercent() * 4 / 5 + "%";
						Login.Login_loadingPercent = 96;
					} else if (!class267.archive12.isFullyLoaded()) {
						Login.Login_loadingText = "Loading interfaces - " + (80 + class267.archive12.loadPercent() / 6) + "%";
						Login.Login_loadingPercent = 96;
					} else if (!class269.archive13.isFullyLoaded()) {
						Login.Login_loadingText = "Loading interfaces - " + (96 + class269.archive13.loadPercent() / 50) + "%";
						Login.Login_loadingPercent = 96;
					} else {
						Login.Login_loadingText = "Loaded interfaces";
						Login.Login_loadingPercent = 98;
						Client.titleLoadingStage = 140;
					}
				} else if (Client.titleLoadingStage == 140) {
					Login.Login_loadingPercent = 100;
					if (!class13.archive19.tryLoadGroupByName(WorldMapCacheName.field304.name)) {
						Login.Login_loadingText = "Loading world map - " + class13.archive19.groupLoadPercentByName(WorldMapCacheName.field304.name) / 10 + "%";
					} else {
						if (WorldMapRegion.worldMap == null) {
							WorldMapRegion.worldMap = new WorldMap();
							WorldMapRegion.worldMap.init(class13.archive19, UserComparator9.archive18, class60.archive20, JagexCache.fontBold12, Client.fontsMap, GrandExchangeOfferTotalQuantityComparator.mapSceneSprites);
						}

						Login.Login_loadingText = "Loaded world map";
						Client.titleLoadingStage = 150;
					}
				} else if (Client.titleLoadingStage == 150) {
					class81.updateGameState(10);
				}
			}
		}
	}
}
