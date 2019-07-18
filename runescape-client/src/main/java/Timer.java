import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jr")
@Implements("Timer")
public class Timer {
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		longValue = 6201267541958518593L
	)
	long field3603;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		longValue = 756856931797943717L
	)
	long field3602;
	@ObfuscatedName("e")
	public boolean field3605;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		longValue = -8529689668980349377L
	)
	long field3607;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		longValue = 7000623641176783585L
	)
	long field3604;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		longValue = -3948903949639907735L
	)
	long field3606;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 886214165
	)
	int field3608;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -380369403
	)
	int field3609;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 2035223733
	)
	int field3601;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -1448804345
	)
	int field3610;

	public Timer() {
		this.field3603 = -1L;
		this.field3602 = -1L;
		this.field3605 = false;
		this.field3607 = 0L;
		this.field3604 = 0L;
		this.field3606 = 0L;
		this.field3608 = 0;
		this.field3609 = 0;
		this.field3601 = 0;
		this.field3610 = 0;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1547117629"
	)
	public void method5005() {
		this.field3603 = DirectByteArrayCopier.currentTimeMs();
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-602398430"
	)
	public void method4993() {
		if (this.field3603 != -1L) {
			this.field3604 = DirectByteArrayCopier.currentTimeMs() - this.field3603;
			this.field3603 = -1L;
		}

	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1668948707"
	)
	public void method4996(int var1) {
		this.field3602 = DirectByteArrayCopier.currentTimeMs();
		this.field3608 = var1;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-20"
	)
	public void method5014() {
		if (-1L != this.field3602) {
			this.field3607 = DirectByteArrayCopier.currentTimeMs() - this.field3602;
			this.field3602 = -1L;
		}

		++this.field3601;
		this.field3605 = true;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-481288218"
	)
	public void method4998() {
		this.field3605 = false;
		this.field3609 = 0;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "2054543133"
	)
	public void method5000() {
		this.method5014();
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(Lkf;I)V",
		garbageValue = "1450575552"
	)
	@Export("write")
	public void write(Buffer var1) {
		long var2 = this.field3604;
		var2 /= 10L;
		if (var2 < 0L) {
			var2 = 0L;
		} else if (var2 > 65535L) {
			var2 = 65535L;
		}

		var1.writeShort((int)var2);
		long var4 = this.field3607;
		var4 /= 10L;
		if (var4 < 0L) {
			var4 = 0L;
		} else if (var4 > 65535L) {
			var4 = 65535L;
		}

		var1.writeShort((int)var4);
		long var6 = this.field3606;
		var6 /= 10L;
		if (var6 < 0L) {
			var6 = 0L;
		} else if (var6 > 65535L) {
			var6 = 65535L;
		}

		var1.writeShort((int)var6);
		var1.writeShort(this.field3608);
		var1.writeShort(this.field3609);
		var1.writeShort(this.field3601);
		var1.writeShort(this.field3610);
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "([Ljava/lang/CharSequence;III)Ljava/lang/String;",
		garbageValue = "-1350169073"
	)
	public static String method5015(CharSequence[] var0, int var1, int var2) {
		if (var2 == 0) {
			return "";
		} else if (var2 == 1) {
			CharSequence var3 = var0[var1];
			return var3 == null ? "null" : var3.toString();
		} else {
			int var8 = var2 + var1;
			int var4 = 0;

			for (int var5 = var1; var5 < var8; ++var5) {
				CharSequence var6 = var0[var5];
				if (var6 == null) {
					var4 += 4;
				} else {
					var4 += var6.length();
				}
			}

			StringBuilder var9 = new StringBuilder(var4);

			for (int var10 = var1; var10 < var8; ++var10) {
				CharSequence var7 = var0[var10];
				if (var7 == null) {
					var9.append("null");
				} else {
					var9.append(var7);
				}
			}

			return var9.toString();
		}
	}

	@ObfuscatedName("ed")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1204156569"
	)
	@Export("load")
	static void load() {
		int var0;
		if (Client.titleLoadingStage == 0) {
			GrandExchangeOfferWorldComparator.scene = new Scene(4, 104, 104, Tiles.Tiles_heights);

			for (var0 = 0; var0 < 4; ++var0) {
				Client.collisionMaps[var0] = new CollisionMap(104, 104);
			}

			RouteStrategy.sceneMinimapSprite = new Sprite(512, 512);
			Login.Login_loadingText = "Starting game engine...";
			Login.Login_loadingPercent = 5;
			Client.titleLoadingStage = 20;
		} else if (Client.titleLoadingStage == 20) {
			Login.Login_loadingText = "Prepared visibility map";
			Login.Login_loadingPercent = 10;
			Client.titleLoadingStage = 30;
		} else if (Client.titleLoadingStage == 30) {
			class197.archive0 = class65.newArchive(0, false, true, true);
			class167.archive1 = class65.newArchive(1, false, true, true);
			class215.archive2 = class65.newArchive(2, true, false, true);
			class43.archive3 = class65.newArchive(3, false, true, true);
			class13.archive4 = class65.newArchive(4, false, true, true);
			WorldMapCacheName.archive5 = class65.newArchive(5, true, true, true);
			WorldMapRegion.archive6 = class65.newArchive(6, true, true, true);
			NPCDefinition.archive7 = class65.newArchive(7, false, true, true);
			Client.archive8 = class65.newArchive(8, false, true, true);
			class4.archive9 = class65.newArchive(9, false, true, true);
			WorldMapLabelSize.archive10 = class65.newArchive(10, false, true, true);
			class32.archive11 = class65.newArchive(11, false, true, true);
			UserComparator4.archive12 = class65.newArchive(12, false, true, true);
			class2.archive13 = class65.newArchive(13, true, false, true);
			Tile.archive14 = class65.newArchive(14, false, true, true);
			GrandExchangeOfferOwnWorldComparator.archive15 = class65.newArchive(15, false, true, true);
			WorldMapSprite.archive17 = class65.newArchive(17, true, true, true);
			Client.archive18 = class65.newArchive(18, false, true, true);
			ItemDefinition.archive19 = class65.newArchive(19, false, true, true);
			Entity.archive20 = class65.newArchive(20, false, true, true);
			Login.Login_loadingText = "Connecting to update server";
			Login.Login_loadingPercent = 20;
			Client.titleLoadingStage = 40;
		} else if (Client.titleLoadingStage == 40) {
			byte var30 = 0;
			var0 = var30 + class197.archive0.percentage() * 4 / 100;
			var0 += class167.archive1.percentage() * 4 / 100;
			var0 += class215.archive2.percentage() * 2 / 100;
			var0 += class43.archive3.percentage() * 2 / 100;
			var0 += class13.archive4.percentage() * 6 / 100;
			var0 += WorldMapCacheName.archive5.percentage() * 4 / 100;
			var0 += WorldMapRegion.archive6.percentage() * 2 / 100;
			var0 += NPCDefinition.archive7.percentage() * 56 / 100;
			var0 += Client.archive8.percentage() * 2 / 100;
			var0 += class4.archive9.percentage() * 2 / 100;
			var0 += WorldMapLabelSize.archive10.percentage() * 2 / 100;
			var0 += class32.archive11.percentage() * 2 / 100;
			var0 += UserComparator4.archive12.percentage() * 2 / 100;
			var0 += class2.archive13.percentage() * 2 / 100;
			var0 += Tile.archive14.percentage() * 2 / 100;
			var0 += GrandExchangeOfferOwnWorldComparator.archive15.percentage() * 2 / 100;
			var0 += ItemDefinition.archive19.percentage() / 100;
			var0 += Client.archive18.percentage() / 100;
			var0 += Entity.archive20.percentage() / 100;
			var0 += WorldMapSprite.archive17.method4258() && WorldMapSprite.archive17.isFullyLoaded() ? 1 : 0;
			if (var0 != 100) {
				if (var0 != 0) {
					Login.Login_loadingText = "Checking for updates - " + var0 + "%";
				}

				Login.Login_loadingPercent = 30;
			} else {
				class42.method763(class197.archive0, "Animations");
				class42.method763(class167.archive1, "Skeletons");
				class42.method763(class13.archive4, "Sound FX");
				class42.method763(WorldMapCacheName.archive5, "Maps");
				class42.method763(WorldMapRegion.archive6, "Music Tracks");
				class42.method763(NPCDefinition.archive7, "Models");
				class42.method763(Client.archive8, "Sprites");
				class42.method763(class32.archive11, "Music Jingles");
				class42.method763(Tile.archive14, "Music Samples");
				class42.method763(GrandExchangeOfferOwnWorldComparator.archive15, "Music Patches");
				class42.method763(ItemDefinition.archive19, "World Map");
				class42.method763(Client.archive18, "World Map Geography");
				class42.method763(Entity.archive20, "World Map Ground");
				UserComparator6.spriteIds = new GraphicsDefaults();
				UserComparator6.spriteIds.decode(WorldMapSprite.archive17);
				Login.Login_loadingText = "Loaded update list";
				Login.Login_loadingPercent = 30;
				Client.titleLoadingStage = 45;
			}
		} else if (Client.titleLoadingStage == 45) {
			Tile.method2853(22050, !Client.isLowDetail, 2);
			MidiPcmStream var33 = new MidiPcmStream();
			var33.method3720(9, 128);
			class80.pcmPlayer0 = ArchiveDiskActionHandler.method4256(GameShell.taskHandler, 0, 22050);
			class80.pcmPlayer0.setStream(var33);
			ArchiveLoader.setAudioArchives(GrandExchangeOfferOwnWorldComparator.archive15, Tile.archive14, class13.archive4, var33);
			class190.pcmPlayer1 = ArchiveDiskActionHandler.method4256(GameShell.taskHandler, 1, 2048);
			SecureRandomCallable.pcmStreamMixer = new PcmStreamMixer();
			class190.pcmPlayer1.setStream(SecureRandomCallable.pcmStreamMixer);
			AttackOption.decimator = new Decimator(22050, CollisionMap.PcmPlayer_sampleRate);
			Login.Login_loadingText = "Prepared sound engine";
			Login.Login_loadingPercent = 35;
			Client.titleLoadingStage = 50;
			class169.WorldMapElement_fonts = new Fonts(Client.archive8, class2.archive13);
		} else {
			int var1;
			if (Client.titleLoadingStage == 50) {
				FontName[] var32 = new FontName[]{FontName.FontName_verdana15, FontName.FontName_plain12, FontName.FontName_plain11, FontName.FontName_verdana11, FontName.FontName_verdana13, FontName.FontName_bold12};
				var1 = var32.length;
				Fonts var29 = class169.WorldMapElement_fonts;
				FontName[] var3 = new FontName[]{FontName.FontName_verdana15, FontName.FontName_plain12, FontName.FontName_plain11, FontName.FontName_verdana11, FontName.FontName_verdana13, FontName.FontName_bold12};
				Client.fontsMap = var29.createMap(var3);
				if (Client.fontsMap.size() < var1) {
					Login.Login_loadingText = "Loading fonts - " + Client.fontsMap.size() * 100 / var1 + "%";
					Login.Login_loadingPercent = 40;
				} else {
					Coord.fontPlain11 = (Font)Client.fontsMap.get(FontName.FontName_plain11);
					class169.fontPlain12 = (Font)Client.fontsMap.get(FontName.FontName_plain12);
					WorldMapIcon_1.fontBold12 = (Font)Client.fontsMap.get(FontName.FontName_bold12);
					WorldMapRectangle.platformInfo = Client.platformInfoProvider.get();
					Login.Login_loadingText = "Loaded fonts";
					Login.Login_loadingPercent = 40;
					Client.titleLoadingStage = 60;
				}
			} else {
				Archive var2;
				int var4;
				Archive var25;
				int var26;
				if (Client.titleLoadingStage == 60) {
					var25 = WorldMapLabelSize.archive10;
					var2 = Client.archive8;
					var26 = 0;
					if (var25.tryLoadFileByNames("title.jpg", "")) {
						++var26;
					}

					if (var2.tryLoadFileByNames("logo", "")) {
						++var26;
					}

					if (var2.tryLoadFileByNames("logo_deadman_mode", "")) {
						++var26;
					}

					if (var2.tryLoadFileByNames("titlebox", "")) {
						++var26;
					}

					if (var2.tryLoadFileByNames("titlebutton", "")) {
						++var26;
					}

					if (var2.tryLoadFileByNames("runes", "")) {
						++var26;
					}

					if (var2.tryLoadFileByNames("title_mute", "")) {
						++var26;
					}

					if (var2.tryLoadFileByNames("options_radio_buttons,0", "")) {
						++var26;
					}

					if (var2.tryLoadFileByNames("options_radio_buttons,2", "")) {
						++var26;
					}

					if (var2.tryLoadFileByNames("options_radio_buttons,4", "")) {
						++var26;
					}

					if (var2.tryLoadFileByNames("options_radio_buttons,6", "")) {
						++var26;
					}

					var2.tryLoadFileByNames("sl_back", "");
					var2.tryLoadFileByNames("sl_flags", "");
					var2.tryLoadFileByNames("sl_arrows", "");
					var2.tryLoadFileByNames("sl_stars", "");
					var2.tryLoadFileByNames("sl_button", "");
					var4 = ScriptEvent.method1121();
					if (var26 < var4) {
						Login.Login_loadingText = "Loading title screen - " + var26 * 100 / var4 + "%";
						Login.Login_loadingPercent = 50;
					} else {
						Login.Login_loadingText = "Loaded title screen";
						Login.Login_loadingPercent = 50;
						class96.updateGameState(5);
						Client.titleLoadingStage = 70;
					}
				} else if (Client.titleLoadingStage == 70) {
					if (!class215.archive2.isFullyLoaded()) {
						Login.Login_loadingText = "Loading config - " + class215.archive2.loadPercent() + "%";
						Login.Login_loadingPercent = 60;
					} else {
						Archive var31 = class215.archive2;
						FloorOverlayDefinition.FloorOverlayDefinition_archive = var31;
						WorldMapSprite.setFloorUnderlayDefinitionArchive(class215.archive2);
						GrandExchangeEvents.method66(class215.archive2, NPCDefinition.archive7);
						var25 = class215.archive2;
						var2 = NPCDefinition.archive7;
						boolean var34 = Client.isLowDetail;
						ObjectDefinition.ObjectDefinition_archive = var25;
						ObjectDefinition.ObjectDefinition_modelsArchive = var2;
						ObjectDefinition.ObjectDefinition_isLowDetail = var34;
						FaceNormal.setNpcDefinitionArchives(class215.archive2, NPCDefinition.archive7);
						GroundItem.method2054(class215.archive2);
						Archive var27 = class215.archive2;
						Archive var5 = NPCDefinition.archive7;
						boolean var6 = Client.isMembersWorld;
						Font var7 = Coord.fontPlain11;
						Messages.ItemDefinition_archive = var27;
						ItemDefinition.ItemDefinition_modelArchive = var5;
						ModelData0.inMembersWorld = var6;
						ItemDefinition.ItemDefinition_fileCount = Messages.ItemDefinition_archive.getGroupFileCount(10);
						HealthBar.ItemDefinition_fontPlain11 = var7;
						Archive var8 = class215.archive2;
						Archive var9 = class197.archive0;
						Archive var10 = class167.archive1;
						SequenceDefinition.SequenceDefinition_archive = var8;
						SequenceDefinition.SequenceDefinition_animationsArchive = var9;
						SequenceDefinition.SequenceDefinition_skeletonsArchive = var10;
						Archive var11 = class215.archive2;
						Archive var12 = NPCDefinition.archive7;
						SpotAnimationDefinition.SpotAnimationDefinition_archive = var11;
						class43.SpotAnimationDefinition_modelArchive = var12;
						Archive var13 = class215.archive2;
						VarbitDefinition.VarbitDefinition_archive = var13;
						GrandExchangeEvents.method68(class215.archive2);
						UrlRequest.method3317(class43.archive3, NPCDefinition.archive7, Client.archive8, class2.archive13);
						WorldMapData_0.method173(class215.archive2);
						Archive var14 = class215.archive2;
						EnumDefinition.EnumDefinition_archive = var14;
						GrandExchangeOfferWorldComparator.setVarcIntArchive(class215.archive2);
						KeyHandler.method794(class215.archive2);
						Clock.varcs = new Varcs();
						Archive var15 = class215.archive2;
						Archive var16 = Client.archive8;
						Archive var17 = class2.archive13;
						HitSplatDefinition.HitSplatDefinition_archive = var15;
						HitSplatDefinition.HitSplatDefinition_spritesArchive = var16;
						HitSplatDefinition.HitSplatDefinition_fontsArchive = var17;
						Archive var18 = class215.archive2;
						Archive var19 = Client.archive8;
						HealthBarDefinition.HealthBarDefinition_archive = var18;
						HealthBarDefinition.HealthBarDefinition_spritesArchive = var19;
						Archive var20 = class215.archive2;
						Archive var21 = Client.archive8;
						WorldMapElement.WorldMapElement_archive = var21;
						if (var20.isFullyLoaded()) {
							UserComparator1.WorldMapElement_count = var20.getGroupFileCount(35);
							WorldMapElement.WorldMapElement_cached = new WorldMapElement[UserComparator1.WorldMapElement_count];

							for (int var22 = 0; var22 < UserComparator1.WorldMapElement_count; ++var22) {
								byte[] var23 = var20.takeFile(35, var22);
								WorldMapElement.WorldMapElement_cached[var22] = new WorldMapElement(var22);
								if (var23 != null) {
									WorldMapElement.WorldMapElement_cached[var22].decode(new Buffer(var23));
									WorldMapElement.WorldMapElement_cached[var22].method4370();
								}
							}
						}

						Login.Login_loadingText = "Loaded config";
						Login.Login_loadingPercent = 60;
						Client.titleLoadingStage = 80;
					}
				} else if (Client.titleLoadingStage == 80) {
					var0 = 0;
					if (Message.compass == null) {
						Message.compass = class65.SpriteBuffer_tryCreateSprite(Client.archive8, UserComparator6.spriteIds.compass, 0);
					} else {
						++var0;
					}

					if (UserComparator4.redHintArrowSprite == null) {
						UserComparator4.redHintArrowSprite = class65.SpriteBuffer_tryCreateSprite(Client.archive8, UserComparator6.spriteIds.field3823, 0);
					} else {
						++var0;
					}

					if (ClanChat.mapSceneSprites == null) {
						ClanChat.mapSceneSprites = class289.method5281(Client.archive8, UserComparator6.spriteIds.mapScenes, 0);
					} else {
						++var0;
					}

					if (UserComparator3.headIconPkSprites == null) {
						UserComparator3.headIconPkSprites = TilePaint.method3062(Client.archive8, UserComparator6.spriteIds.headIconsPk, 0);
					} else {
						++var0;
					}

					if (SoundCache.headIconPrayerSprites == null) {
						SoundCache.headIconPrayerSprites = TilePaint.method3062(Client.archive8, UserComparator6.spriteIds.field3830, 0);
					} else {
						++var0;
					}

					if (class173.headIconHintSprites == null) {
						class173.headIconHintSprites = TilePaint.method3062(Client.archive8, UserComparator6.spriteIds.field3827, 0);
					} else {
						++var0;
					}

					if (WorldMapData_1.mapMarkerSprites == null) {
						WorldMapData_1.mapMarkerSprites = TilePaint.method3062(Client.archive8, UserComparator6.spriteIds.field3828, 0);
					} else {
						++var0;
					}

					if (Occluder.crossSprites == null) {
						Occluder.crossSprites = TilePaint.method3062(Client.archive8, UserComparator6.spriteIds.field3829, 0);
					} else {
						++var0;
					}

					if (Skills.mapDotSprites == null) {
						Skills.mapDotSprites = TilePaint.method3062(Client.archive8, UserComparator6.spriteIds.field3832, 0);
					} else {
						++var0;
					}

					if (GrandExchangeOfferAgeComparator.scrollBarSprites == null) {
						GrandExchangeOfferAgeComparator.scrollBarSprites = class289.method5281(Client.archive8, UserComparator6.spriteIds.field3831, 0);
					} else {
						++var0;
					}

					if (GrandExchangeOfferNameComparator.modIconSprites == null) {
						GrandExchangeOfferNameComparator.modIconSprites = class289.method5281(Client.archive8, UserComparator6.spriteIds.field3822, 0);
					} else {
						++var0;
					}

					if (var0 < 11) {
						Login.Login_loadingText = "Loading sprites - " + var0 * 100 / 12 + "%";
						Login.Login_loadingPercent = 70;
					} else {
						AbstractFont.AbstractFont_modIconSprites = GrandExchangeOfferNameComparator.modIconSprites;
						UserComparator4.redHintArrowSprite.normalize();
						var1 = (int)(Math.random() * 21.0D) - 10;
						int var28 = (int)(Math.random() * 21.0D) - 10;
						var26 = (int)(Math.random() * 21.0D) - 10;
						var4 = (int)(Math.random() * 41.0D) - 20;
						ClanChat.mapSceneSprites[0].shiftColors(var1 + var4, var4 + var28, var4 + var26);
						Login.Login_loadingText = "Loaded sprites";
						Login.Login_loadingPercent = 70;
						Client.titleLoadingStage = 90;
					}
				} else if (Client.titleLoadingStage == 90) {
					if (!class4.archive9.isFullyLoaded()) {
						Login.Login_loadingText = "Loading textures - " + "0%";
						Login.Login_loadingPercent = 90;
					} else {
						GrandExchangeEvents.textureProvider = new TextureProvider(class4.archive9, Client.archive8, 20, 0.8D, Client.isLowDetail ? 64 : 128);
						Rasterizer3D.Rasterizer3D_setTextureLoader(GrandExchangeEvents.textureProvider);
						Rasterizer3D.Rasterizer3D_setBrightness(0.8D);
						Client.titleLoadingStage = 100;
					}
				} else if (Client.titleLoadingStage == 100) {
					var0 = GrandExchangeEvents.textureProvider.getLoadedPercentage();
					if (var0 < 100) {
						Login.Login_loadingText = "Loading textures - " + var0 + "%";
						Login.Login_loadingPercent = 90;
					} else {
						Login.Login_loadingText = "Loaded textures";
						Login.Login_loadingPercent = 90;
						Client.titleLoadingStage = 110;
					}
				} else if (Client.titleLoadingStage == 110) {
					class40.mouseRecorder = new MouseRecorder();
					GameShell.taskHandler.newThreadTask(class40.mouseRecorder, 10);
					Login.Login_loadingText = "Loaded input handler";
					Login.Login_loadingPercent = 92;
					Client.titleLoadingStage = 120;
				} else if (Client.titleLoadingStage == 120) {
					if (!WorldMapLabelSize.archive10.tryLoadFileByNames("huffman", "")) {
						Login.Login_loadingText = "Loading wordpack - " + 0 + "%";
						Login.Login_loadingPercent = 94;
					} else {
						Huffman var24 = new Huffman(WorldMapLabelSize.archive10.takeFileByNames("huffman", ""));
						class210.huffman = var24;
						Login.Login_loadingText = "Loaded wordpack";
						Login.Login_loadingPercent = 94;
						Client.titleLoadingStage = 130;
					}
				} else if (Client.titleLoadingStage == 130) {
					if (!class43.archive3.isFullyLoaded()) {
						Login.Login_loadingText = "Loading interfaces - " + class43.archive3.loadPercent() * 4 / 5 + "%";
						Login.Login_loadingPercent = 96;
					} else if (!UserComparator4.archive12.isFullyLoaded()) {
						Login.Login_loadingText = "Loading interfaces - " + (80 + UserComparator4.archive12.loadPercent() / 6) + "%";
						Login.Login_loadingPercent = 96;
					} else if (!class2.archive13.isFullyLoaded()) {
						Login.Login_loadingText = "Loading interfaces - " + (96 + class2.archive13.loadPercent() / 50) + "%";
						Login.Login_loadingPercent = 96;
					} else {
						Login.Login_loadingText = "Loaded interfaces";
						Login.Login_loadingPercent = 98;
						Client.titleLoadingStage = 140;
					}
				} else if (Client.titleLoadingStage == 140) {
					Login.Login_loadingPercent = 100;
					if (!ItemDefinition.archive19.tryLoadGroupByName(WorldMapCacheName.field308.name)) {
						Login.Login_loadingText = "Loading world map - " + ItemDefinition.archive19.groupLoadPercentByName(WorldMapCacheName.field308.name) / 10 + "%";
					} else {
						if (BoundaryObject.worldMap == null) {
							BoundaryObject.worldMap = new WorldMap();
							BoundaryObject.worldMap.init(ItemDefinition.archive19, Client.archive18, Entity.archive20, WorldMapIcon_1.fontBold12, Client.fontsMap, ClanChat.mapSceneSprites);
						}

						Login.Login_loadingText = "Loaded world map";
						Client.titleLoadingStage = 150;
					}
				} else if (Client.titleLoadingStage == 150) {
					class96.updateGameState(10);
				}
			}
		}
	}
}
