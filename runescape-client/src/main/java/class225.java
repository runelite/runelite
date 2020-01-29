import java.io.DataInputStream;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hv")
public class class225 {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/Throwable;I)V",
		garbageValue = "1575191798"
	)
	@Export("RunException_sendStackTrace")
	public static void RunException_sendStackTrace(String var0, Throwable var1) {
		if (var1 != null) {
			var1.printStackTrace();
		} else {
			try {
				String var2 = "";
				if (var1 != null) {
					var2 = Bounds.method6058(var1);
				}

				if (var0 != null) {
					if (var1 != null) {
						var2 = var2 + " | ";
					}

					var2 = var2 + var0;
				}

				System.out.println("Error: " + var2);
				var2 = var2.replace(':', '.');
				var2 = var2.replace('@', '_');
				var2 = var2.replace('&', '_');
				var2 = var2.replace('#', '_');
				if (RunException.RunException_applet == null) {
					return;
				}

				URL var3 = new URL(RunException.RunException_applet.getCodeBase(), "clienterror.ws?c=" + GZipDecompressor.RunException_revision + "&u=" + RunException.localPlayerName + "&v1=" + TaskHandler.javaVendor + "&v2=" + class216.javaVersion + "&ct=" + RunException.clientType + "&e=" + var2);
				DataInputStream var4 = new DataInputStream(var3.openStream());
				var4.read();
				var4.close();
			} catch (Exception var5) {
			}

		}
	}

	@ObfuscatedName("fh")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "48"
	)
	@Export("load")
	static void load() {
		int var0;
		if (Client.titleLoadingStage == 0) {
			ServerBuild.scene = new Scene(4, 104, 104, Tiles.Tiles_heights);

			for (var0 = 0; var0 < 4; ++var0) {
				Client.collisionMaps[var0] = new CollisionMap(104, 104);
			}

			WorldMapRectangle.sceneMinimapSprite = new Sprite(512, 512);
			Login.Login_loadingText = "Starting game engine...";
			Login.Login_loadingPercent = 5;
			Client.titleLoadingStage = 20;
		} else if (Client.titleLoadingStage == 20) {
			Login.Login_loadingText = "Prepared visibility map";
			Login.Login_loadingPercent = 10;
			Client.titleLoadingStage = 30;
		} else if (Client.titleLoadingStage == 30) {
			GrandExchangeEvent.archive0 = class51.newArchive(0, false, true, true);
			class65.archive1 = class51.newArchive(1, false, true, true);
			GrandExchangeOfferWorldComparator.archive2 = class51.newArchive(2, true, false, true);
			class267.archive3 = class51.newArchive(3, false, true, true);
			Client.archive4 = class51.newArchive(4, false, true, true);
			NetSocket.archive5 = class51.newArchive(5, true, true, true);
			MouseHandler.archive6 = class51.newArchive(6, true, true, true);
			BuddyRankComparator.archive7 = class51.newArchive(7, false, true, true);
			UserComparator8.archive8 = class51.newArchive(8, false, true, true);
			GrandExchangeOfferNameComparator.archive9 = class51.newArchive(9, false, true, true);
			HealthBar.archive10 = class51.newArchive(10, false, true, true);
			GrandExchangeOffer.archive11 = class51.newArchive(11, false, true, true);
			MilliClock.archive12 = class51.newArchive(12, false, true, true);
			MouseHandler.archive13 = class51.newArchive(13, true, false, true);
			class189.archive14 = class51.newArchive(14, false, true, true);
			WorldMapSection1.archive15 = class51.newArchive(15, false, true, true);
			Client.archive17 = class51.newArchive(17, true, true, true);
			UserComparator2.archive18 = class51.newArchive(18, false, true, true);
			Clock.archive19 = class51.newArchive(19, false, true, true);
			SecureRandomCallable.archive20 = class51.newArchive(20, false, true, true);
			Login.Login_loadingText = "Connecting to update server";
			Login.Login_loadingPercent = 20;
			Client.titleLoadingStage = 40;
		} else if (Client.titleLoadingStage == 40) {
			byte var35 = 0;
			var0 = var35 + GrandExchangeEvent.archive0.percentage() * 4 / 100;
			var0 += class65.archive1.percentage() * 4 / 100;
			var0 += GrandExchangeOfferWorldComparator.archive2.percentage() * 2 / 100;
			var0 += class267.archive3.percentage() * 2 / 100;
			var0 += Client.archive4.percentage() * 6 / 100;
			var0 += NetSocket.archive5.percentage() * 4 / 100;
			var0 += MouseHandler.archive6.percentage() * 2 / 100;
			var0 += BuddyRankComparator.archive7.percentage() * 56 / 100;
			var0 += UserComparator8.archive8.percentage() * 2 / 100;
			var0 += GrandExchangeOfferNameComparator.archive9.percentage() * 2 / 100;
			var0 += HealthBar.archive10.percentage() * 2 / 100;
			var0 += GrandExchangeOffer.archive11.percentage() * 2 / 100;
			var0 += MilliClock.archive12.percentage() * 2 / 100;
			var0 += MouseHandler.archive13.percentage() * 2 / 100;
			var0 += class189.archive14.percentage() * 2 / 100;
			var0 += WorldMapSection1.archive15.percentage() * 2 / 100;
			var0 += Clock.archive19.percentage() / 100;
			var0 += UserComparator2.archive18.percentage() / 100;
			var0 += SecureRandomCallable.archive20.percentage() / 100;
			var0 += Client.archive17.method4372() && Client.archive17.isFullyLoaded() ? 1 : 0;
			if (var0 != 100) {
				if (var0 != 0) {
					Login.Login_loadingText = "Checking for updates - " + var0 + "%";
				}

				Login.Login_loadingPercent = 30;
			} else {
				WorldMapLabel.method438(GrandExchangeEvent.archive0, "Animations");
				WorldMapLabel.method438(class65.archive1, "Skeletons");
				WorldMapLabel.method438(Client.archive4, "Sound FX");
				WorldMapLabel.method438(NetSocket.archive5, "Maps");
				WorldMapLabel.method438(MouseHandler.archive6, "Music Tracks");
				WorldMapLabel.method438(BuddyRankComparator.archive7, "Models");
				WorldMapLabel.method438(UserComparator8.archive8, "Sprites");
				WorldMapLabel.method438(GrandExchangeOffer.archive11, "Music Jingles");
				WorldMapLabel.method438(class189.archive14, "Music Samples");
				WorldMapLabel.method438(WorldMapSection1.archive15, "Music Patches");
				WorldMapLabel.method438(Clock.archive19, "World Map");
				WorldMapLabel.method438(UserComparator2.archive18, "World Map Geography");
				WorldMapLabel.method438(SecureRandomCallable.archive20, "World Map Ground");
				class222.spriteIds = new GraphicsDefaults();
				class222.spriteIds.decode(Client.archive17);
				Login.Login_loadingText = "Loaded update list";
				Login.Login_loadingPercent = 30;
				Client.titleLoadingStage = 45;
			}
		} else if (Client.titleLoadingStage == 45) {
			class14.method173(22050, !Client.isLowDetail, 2);
			MidiPcmStream var39 = new MidiPcmStream();
			var39.method3819(9, 128);
			WorldMapLabelSize.pcmPlayer0 = AbstractWorldMapIcon.method627(GameShell.taskHandler, 0, 22050);
			WorldMapLabelSize.pcmPlayer0.setStream(var39);
			MouseRecorder.method1208(WorldMapSection1.archive15, class189.archive14, Client.archive4, var39);
			class43.pcmPlayer1 = AbstractWorldMapIcon.method627(GameShell.taskHandler, 1, 2048);
			class2.pcmStreamMixer = new PcmStreamMixer();
			class43.pcmPlayer1.setStream(class2.pcmStreamMixer);
			WorldMapSection1.decimator = new Decimator(22050, PcmPlayer.field1398);
			Login.Login_loadingText = "Prepared sound engine";
			Login.Login_loadingPercent = 35;
			Client.titleLoadingStage = 50;
			NetSocket.WorldMapElement_fonts = new Fonts(UserComparator8.archive8, MouseHandler.archive13);
		} else {
			int var1;
			if (Client.titleLoadingStage == 50) {
				FontName[] var38 = new FontName[]{FontName.FontName_plain12, FontName.FontName_verdana13, FontName.FontName_bold12, FontName.FontName_verdana11, FontName.FontName_verdana15, FontName.FontName_plain11};
				var1 = var38.length;
				Fonts var34 = NetSocket.WorldMapElement_fonts;
				FontName[] var32 = new FontName[]{FontName.FontName_plain12, FontName.FontName_verdana13, FontName.FontName_bold12, FontName.FontName_verdana11, FontName.FontName_verdana15, FontName.FontName_plain11};
				Client.fontsMap = var34.createMap(var32);
				if (Client.fontsMap.size() < var1) {
					Login.Login_loadingText = "Loading fonts - " + Client.fontsMap.size() * 100 / var1 + "%";
					Login.Login_loadingPercent = 40;
				} else {
					WorldMapData_0.fontPlain11 = (Font)Client.fontsMap.get(FontName.FontName_plain11);
					class13.fontPlain12 = (Font)Client.fontsMap.get(FontName.FontName_plain12);
					class1.fontBold12 = (Font)Client.fontsMap.get(FontName.FontName_bold12);
					NetSocket.platformInfo = Client.platformInfoProvider.get();
					Login.Login_loadingText = "Loaded fonts";
					Login.Login_loadingPercent = 40;
					Client.titleLoadingStage = 60;
				}
			} else {
				Archive var2;
				int var27;
				Archive var41;
				if (Client.titleLoadingStage == 60) {
					var41 = HealthBar.archive10;
					var2 = UserComparator8.archive8;
					var27 = 0;
					if (var41.tryLoadFileByNames("title.jpg", "")) {
						++var27;
					}

					if (var2.tryLoadFileByNames("logo", "")) {
						++var27;
					}

					if (var2.tryLoadFileByNames("logo_deadman_mode", "")) {
						++var27;
					}

					if (var2.tryLoadFileByNames("logo_seasonal_mode", "")) {
						++var27;
					}

					if (var2.tryLoadFileByNames("titlebox", "")) {
						++var27;
					}

					if (var2.tryLoadFileByNames("titlebutton", "")) {
						++var27;
					}

					if (var2.tryLoadFileByNames("runes", "")) {
						++var27;
					}

					if (var2.tryLoadFileByNames("title_mute", "")) {
						++var27;
					}

					if (var2.tryLoadFileByNames("options_radio_buttons,0", "")) {
						++var27;
					}

					if (var2.tryLoadFileByNames("options_radio_buttons,2", "")) {
						++var27;
					}

					if (var2.tryLoadFileByNames("options_radio_buttons,4", "")) {
						++var27;
					}

					if (var2.tryLoadFileByNames("options_radio_buttons,6", "")) {
						++var27;
					}

					var2.tryLoadFileByNames("sl_back", "");
					var2.tryLoadFileByNames("sl_flags", "");
					var2.tryLoadFileByNames("sl_arrows", "");
					var2.tryLoadFileByNames("sl_stars", "");
					var2.tryLoadFileByNames("sl_button", "");
					byte var33 = 12;
					if (var27 < var33) {
						Login.Login_loadingText = "Loading title screen - " + var27 * 100 / var33 + "%";
						Login.Login_loadingPercent = 50;
					} else {
						Login.Login_loadingText = "Loaded title screen";
						Login.Login_loadingPercent = 50;
						Projectile.updateGameState(5);
						Client.titleLoadingStage = 70;
					}
				} else if (Client.titleLoadingStage == 70) {
					if (!GrandExchangeOfferWorldComparator.archive2.isFullyLoaded()) {
						Login.Login_loadingText = "Loading config - " + GrandExchangeOfferWorldComparator.archive2.loadPercent() + "%";
						Login.Login_loadingPercent = 60;
					} else {
						Archive var37 = GrandExchangeOfferWorldComparator.archive2;
						FloorOverlayDefinition.FloorOverlayDefinition_archive = var37;
						class83.method2109(GrandExchangeOfferWorldComparator.archive2);
						var41 = GrandExchangeOfferWorldComparator.archive2;
						var2 = BuddyRankComparator.archive7;
						KitDefinition.KitDefinition_archive = var41;
						KitDefinition.KitDefinition_modelsArchive = var2;
						CollisionMap.KitDefinition_fileCount = KitDefinition.KitDefinition_archive.getGroupFileCount(3);
						Archive var3 = GrandExchangeOfferWorldComparator.archive2;
						Archive var28 = BuddyRankComparator.archive7;
						boolean var5 = Client.isLowDetail;
						ObjectDefinition.ObjectDefinition_archive = var3;
						ObjectDefinition.ObjectDefinition_modelsArchive = var28;
						ObjectDefinition.ObjectDefinition_isLowDetail = var5;
						Archive var6 = GrandExchangeOfferWorldComparator.archive2;
						Archive var36 = BuddyRankComparator.archive7;
						NPCDefinition.NpcDefinition_archive = var6;
						NPCDefinition.NpcDefinition_modelArchive = var36;
						GraphicsObject.method2063(GrandExchangeOfferWorldComparator.archive2);
						Archive var8 = GrandExchangeOfferWorldComparator.archive2;
						Archive var9 = BuddyRankComparator.archive7;
						boolean var10 = Client.isMembersWorld;
						Font var11 = WorldMapData_0.fontPlain11;
						ItemDefinition.ItemDefinition_archive = var8;
						ItemDefinition.ItemDefinition_modelArchive = var9;
						class298.ItemDefinition_inMembersWorld = var10;
						ItemDefinition.ItemDefinition_fileCount = ItemDefinition.ItemDefinition_archive.getGroupFileCount(10);
						ItemDefinition.ItemDefinition_fontPlain11 = var11;
						TilePaint.method3149(GrandExchangeOfferWorldComparator.archive2, GrandExchangeEvent.archive0, class65.archive1);
						Archive var12 = GrandExchangeOfferWorldComparator.archive2;
						Archive var13 = BuddyRankComparator.archive7;
						SpotAnimationDefinition.SpotAnimationDefinition_archive = var12;
						ArchiveDiskActionHandler.SpotAnimationDefinition_modelArchive = var13;
						Archive var14 = GrandExchangeOfferWorldComparator.archive2;
						class287.VarbitDefinition_archive = var14;
						Archive var15 = GrandExchangeOfferWorldComparator.archive2;
						VarpDefinition.VarpDefinition_archive = var15;
						VarpDefinition.VarpDefinition_fileCount = VarpDefinition.VarpDefinition_archive.getGroupFileCount(16);
						SoundSystem.method2562(class267.archive3, BuddyRankComparator.archive7, UserComparator8.archive8, MouseHandler.archive13);
						Archive var16 = GrandExchangeOfferWorldComparator.archive2;
						InvDefinition.InvDefinition_archive = var16;
						Archive var17 = GrandExchangeOfferWorldComparator.archive2;
						GrandExchangeOfferAgeComparator.EnumDefinition_archive = var17;
						Archive var18 = GrandExchangeOfferWorldComparator.archive2;
						VarcInt.VarcInt_archive = var18;
						Archive var19 = GrandExchangeOfferWorldComparator.archive2;
						ParamDefinition.ParamDefinition_archive = var19;
						class197.varcs = new Varcs();
						Archive var20 = GrandExchangeOfferWorldComparator.archive2;
						Archive var21 = UserComparator8.archive8;
						Archive var22 = MouseHandler.archive13;
						class49.HitSplatDefinition_archive = var20;
						HitSplatDefinition.field3329 = var21;
						HitSplatDefinition.HitSplatDefinition_fontsArchive = var22;
						Archive var23 = GrandExchangeOfferWorldComparator.archive2;
						Archive var24 = UserComparator8.archive8;
						HealthBarDefinition.HealthBarDefinition_archive = var23;
						HealthBarDefinition.HitSplatDefinition_spritesArchive = var24;
						Varcs.method2212(GrandExchangeOfferWorldComparator.archive2, UserComparator8.archive8);
						Login.Login_loadingText = "Loaded config";
						Login.Login_loadingPercent = 60;
						Client.titleLoadingStage = 80;
					}
				} else if (Client.titleLoadingStage == 80) {
					var0 = 0;
					if (Entity.compass == null) {
						Entity.compass = WorldMapSection1.SpriteBuffer_getSprite(UserComparator8.archive8, class222.spriteIds.compass, 0);
					} else {
						++var0;
					}

					if (ArchiveLoader.redHintArrowSprite == null) {
						ArchiveLoader.redHintArrowSprite = WorldMapSection1.SpriteBuffer_getSprite(UserComparator8.archive8, class222.spriteIds.field3796, 0);
					} else {
						++var0;
					}

					IndexedSprite var7;
					IndexedSprite[] var26;
					IndexedSprite[] var29;
					int var30;
					if (VertexNormal.mapSceneSprites == null) {
						var2 = UserComparator8.archive8;
						var27 = class222.spriteIds.mapScenes;
						if (!class228.method4199(var2, var27, 0)) {
							var26 = null;
						} else {
							var29 = new IndexedSprite[class326.SpriteBuffer_spriteCount];

							for (var30 = 0; var30 < class326.SpriteBuffer_spriteCount; ++var30) {
								var7 = var29[var30] = new IndexedSprite();
								var7.width = GZipDecompressor.SpriteBuffer_spriteWidth;
								var7.height = class326.SpriteBuffer_spriteHeight;
								var7.xOffset = Huffman.SpriteBuffer_xOffsets[var30];
								var7.yOffset = NPC.SpriteBuffer_yOffsets[var30];
								var7.subWidth = class326.SpriteBuffer_spriteWidths[var30];
								var7.subHeight = class326.SpriteBuffer_spriteHeights[var30];
								var7.palette = class326.SpriteBuffer_spritePalette;
								var7.pixels = class326.SpriteBuffer_pixels[var30];
							}

							DynamicObject.method2292();
							var26 = var29;
						}

						VertexNormal.mapSceneSprites = var26;
					} else {
						++var0;
					}

					Sprite[] var40;
					if (Ignored.headIconPkSprites == null) {
						var2 = UserComparator8.archive8;
						var27 = class222.spriteIds.headIconsPk;
						if (!class228.method4199(var2, var27, 0)) {
							var40 = null;
						} else {
							var40 = HorizontalAlignment.method4783();
						}

						Ignored.headIconPkSprites = var40;
					} else {
						++var0;
					}

					if (class40.headIconPrayerSprites == null) {
						var2 = UserComparator8.archive8;
						var27 = class222.spriteIds.field3799;
						if (!class228.method4199(var2, var27, 0)) {
							var40 = null;
						} else {
							var40 = HorizontalAlignment.method4783();
						}

						class40.headIconPrayerSprites = var40;
					} else {
						++var0;
					}

					if (SecureRandomCallable.headIconHintSprites == null) {
						var2 = UserComparator8.archive8;
						var27 = class222.spriteIds.field3800;
						if (!class228.method4199(var2, var27, 0)) {
							var40 = null;
						} else {
							var40 = HorizontalAlignment.method4783();
						}

						SecureRandomCallable.headIconHintSprites = var40;
					} else {
						++var0;
					}

					if (StructDefinition.mapMarkerSprites == null) {
						var2 = UserComparator8.archive8;
						var27 = class222.spriteIds.field3803;
						if (!class228.method4199(var2, var27, 0)) {
							var40 = null;
						} else {
							var40 = HorizontalAlignment.method4783();
						}

						StructDefinition.mapMarkerSprites = var40;
					} else {
						++var0;
					}

					if (WorldMapData_0.crossSprites == null) {
						var2 = UserComparator8.archive8;
						var27 = class222.spriteIds.field3802;
						if (!class228.method4199(var2, var27, 0)) {
							var40 = null;
						} else {
							var40 = HorizontalAlignment.method4783();
						}

						WorldMapData_0.crossSprites = var40;
					} else {
						++var0;
					}

					if (AbstractWorldMapData.mapDotSprites == null) {
						var2 = UserComparator8.archive8;
						var27 = class222.spriteIds.field3805;
						if (!class228.method4199(var2, var27, 0)) {
							var40 = null;
						} else {
							var40 = HorizontalAlignment.method4783();
						}

						AbstractWorldMapData.mapDotSprites = var40;
					} else {
						++var0;
					}

					if (class192.scrollBarSprites == null) {
						var2 = UserComparator8.archive8;
						var27 = class222.spriteIds.field3804;
						if (!class228.method4199(var2, var27, 0)) {
							var26 = null;
						} else {
							var29 = new IndexedSprite[class326.SpriteBuffer_spriteCount];

							for (var30 = 0; var30 < class326.SpriteBuffer_spriteCount; ++var30) {
								var7 = var29[var30] = new IndexedSprite();
								var7.width = GZipDecompressor.SpriteBuffer_spriteWidth;
								var7.height = class326.SpriteBuffer_spriteHeight;
								var7.xOffset = Huffman.SpriteBuffer_xOffsets[var30];
								var7.yOffset = NPC.SpriteBuffer_yOffsets[var30];
								var7.subWidth = class326.SpriteBuffer_spriteWidths[var30];
								var7.subHeight = class326.SpriteBuffer_spriteHeights[var30];
								var7.palette = class326.SpriteBuffer_spritePalette;
								var7.pixels = class326.SpriteBuffer_pixels[var30];
							}

							DynamicObject.method2292();
							var26 = var29;
						}

						class192.scrollBarSprites = var26;
					} else {
						++var0;
					}

					if (InterfaceParent.modIconSprites == null) {
						var2 = UserComparator8.archive8;
						var27 = class222.spriteIds.field3795;
						if (!class228.method4199(var2, var27, 0)) {
							var26 = null;
						} else {
							var29 = new IndexedSprite[class326.SpriteBuffer_spriteCount];

							for (var30 = 0; var30 < class326.SpriteBuffer_spriteCount; ++var30) {
								var7 = var29[var30] = new IndexedSprite();
								var7.width = GZipDecompressor.SpriteBuffer_spriteWidth;
								var7.height = class326.SpriteBuffer_spriteHeight;
								var7.xOffset = Huffman.SpriteBuffer_xOffsets[var30];
								var7.yOffset = NPC.SpriteBuffer_yOffsets[var30];
								var7.subWidth = class326.SpriteBuffer_spriteWidths[var30];
								var7.subHeight = class326.SpriteBuffer_spriteHeights[var30];
								var7.palette = class326.SpriteBuffer_spritePalette;
								var7.pixels = class326.SpriteBuffer_pixels[var30];
							}

							DynamicObject.method2292();
							var26 = var29;
						}

						InterfaceParent.modIconSprites = var26;
					} else {
						++var0;
					}

					if (var0 < 11) {
						Login.Login_loadingText = "Loading sprites - " + var0 * 100 / 12 + "%";
						Login.Login_loadingPercent = 70;
					} else {
						AbstractFont.AbstractFont_modIconSprites = InterfaceParent.modIconSprites;
						ArchiveLoader.redHintArrowSprite.normalize();
						var1 = (int)(Math.random() * 21.0D) - 10;
						int var31 = (int)(Math.random() * 21.0D) - 10;
						var27 = (int)(Math.random() * 21.0D) - 10;
						int var4 = (int)(Math.random() * 41.0D) - 20;
						VertexNormal.mapSceneSprites[0].shiftColors(var1 + var4, var4 + var31, var27 + var4);
						Login.Login_loadingText = "Loaded sprites";
						Login.Login_loadingPercent = 70;
						Client.titleLoadingStage = 90;
					}
				} else if (Client.titleLoadingStage == 90) {
					if (!GrandExchangeOfferNameComparator.archive9.isFullyLoaded()) {
						Login.Login_loadingText = "Loading textures - " + "0%";
						Login.Login_loadingPercent = 90;
					} else {
						Language.textureProvider = new TextureProvider(GrandExchangeOfferNameComparator.archive9, UserComparator8.archive8, 20, 0.8D, Client.isLowDetail ? 64 : 128);
						Rasterizer3D.Rasterizer3D_setTextureLoader(Language.textureProvider);
						Rasterizer3D.Rasterizer3D_setBrightness(0.8D);
						Client.titleLoadingStage = 100;
					}
				} else if (Client.titleLoadingStage == 100) {
					var0 = Language.textureProvider.getLoadedPercentage();
					if (var0 < 100) {
						Login.Login_loadingText = "Loading textures - " + var0 + "%";
						Login.Login_loadingPercent = 90;
					} else {
						Login.Login_loadingText = "Loaded textures";
						Login.Login_loadingPercent = 90;
						Client.titleLoadingStage = 110;
					}
				} else if (Client.titleLoadingStage == 110) {
					class16.mouseRecorder = new MouseRecorder();
					GameShell.taskHandler.newThreadTask(class16.mouseRecorder, 10);
					Login.Login_loadingText = "Loaded input handler";
					Login.Login_loadingPercent = 92;
					Client.titleLoadingStage = 120;
				} else if (Client.titleLoadingStage == 120) {
					if (!HealthBar.archive10.tryLoadFileByNames("huffman", "")) {
						Login.Login_loadingText = "Loading wordpack - " + 0 + "%";
						Login.Login_loadingPercent = 94;
					} else {
						Huffman var25 = new Huffman(HealthBar.archive10.takeFileByNames("huffman", ""));
						TilePaint.method3150(var25);
						Login.Login_loadingText = "Loaded wordpack";
						Login.Login_loadingPercent = 94;
						Client.titleLoadingStage = 130;
					}
				} else if (Client.titleLoadingStage == 130) {
					if (!class267.archive3.isFullyLoaded()) {
						Login.Login_loadingText = "Loading interfaces - " + class267.archive3.loadPercent() * 4 / 5 + "%";
						Login.Login_loadingPercent = 96;
					} else if (!MilliClock.archive12.isFullyLoaded()) {
						Login.Login_loadingText = "Loading interfaces - " + (80 + MilliClock.archive12.loadPercent() / 6) + "%";
						Login.Login_loadingPercent = 96;
					} else if (!MouseHandler.archive13.isFullyLoaded()) {
						Login.Login_loadingText = "Loading interfaces - " + (96 + MouseHandler.archive13.loadPercent() / 50) + "%";
						Login.Login_loadingPercent = 96;
					} else {
						Login.Login_loadingText = "Loaded interfaces";
						Login.Login_loadingPercent = 98;
						Client.titleLoadingStage = 140;
					}
				} else if (Client.titleLoadingStage == 140) {
					Login.Login_loadingPercent = 100;
					if (!Clock.archive19.tryLoadGroupByName(WorldMapCacheName.field313.name)) {
						Login.Login_loadingText = "Loading world map - " + Clock.archive19.groupLoadPercentByName(WorldMapCacheName.field313.name) / 10 + "%";
					} else {
						if (WorldMapIcon_0.worldMap == null) {
							WorldMapIcon_0.worldMap = new WorldMap();
							WorldMapIcon_0.worldMap.init(Clock.archive19, UserComparator2.archive18, SecureRandomCallable.archive20, class1.fontBold12, Client.fontsMap, VertexNormal.mapSceneSprites);
						}

						Login.Login_loadingText = "Loaded world map";
						Client.titleLoadingStage = 150;
					}
				} else if (Client.titleLoadingStage == 150) {
					Projectile.updateGameState(10);
				}
			}
		}
	}
}
