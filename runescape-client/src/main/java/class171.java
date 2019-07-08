import java.io.File;
import java.util.Hashtable;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fo")
public class class171 {
   @ObfuscatedName("ro")
   @ObfuscatedGetter(
      intValue = -852697585
   )
   static int field1116;
   @ObfuscatedName("m")
   public static boolean field1117;
   @ObfuscatedName("f")
   public static File field1118;
   @ObfuscatedName("q")
   static Hashtable field1119;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "21"
   )
   public static void method3498() {
      KeyHandler var0 = KeyHandler.KeyHandler_instance;
      synchronized(KeyHandler.KeyHandler_instance) {
         ++KeyHandler.KeyHandler_idleCycles;
         KeyHandler.field453 = KeyHandler.field455;
         KeyHandler.field452 = 0;
         int var2;
         if (KeyHandler.field448 < 0) {
            for (var2 = 0; var2 < 112; ++var2) {
               KeyHandler.KeyHandler_pressedKeys[var2] = false;
            }

            KeyHandler.field448 = KeyHandler.field447;
         } else {
            while (KeyHandler.field448 != KeyHandler.field447) {
               var2 = KeyHandler.field446[KeyHandler.field447];
               KeyHandler.field447 = KeyHandler.field447 + 1 & 127;
               if (var2 < 0) {
                  KeyHandler.KeyHandler_pressedKeys[~var2] = false;
               } else {
                  if (!KeyHandler.KeyHandler_pressedKeys[var2] && KeyHandler.field452 < KeyHandler.field451.length - 1) {
                     KeyHandler.field451[++KeyHandler.field452 - 1] = var2;
                  }

                  KeyHandler.KeyHandler_pressedKeys[var2] = true;
               }
            }
         }

         if (KeyHandler.field452 > 0) {
            KeyHandler.KeyHandler_idleCycles = 0;
         }

         KeyHandler.field455 = KeyHandler.field454;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIIIII)I",
      garbageValue = "-1048935304"
   )
   public static int method3496(int var0, int var1, int var2, int var3, int var4, int var5) {
      if ((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return var2 == 0 ? var1 : (var2 == 1 ? 7 - var0 - (var3 - 1) : (var2 == 2 ? 7 - var1 - (var4 - 1) : var0));
   }

   @ObfuscatedName("fq")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-36"
   )
   static void method3497() {
      int var0;
      if (Client.titleLoadingStage == 0) {
         class65.scene = new Scene(4, 104, 104, Tiles.Tiles_heights);

         for (var0 = 0; var0 < 4; ++var0) {
            Client.collisionMaps[var0] = new CollisionMap(104, 104);
         }

         InterfaceParent.sceneMinimapSprite = new Sprite(512, 512);
         Login.Login_loadingText = "Starting game engine...";
         Login.Login_loadingPercent = 5;
         Client.titleLoadingStage = 20;
      } else if (Client.titleLoadingStage == 20) {
         Login.Login_loadingText = "Prepared visibility map";
         Login.Login_loadingPercent = 10;
         Client.titleLoadingStage = 30;
      } else if (Client.titleLoadingStage == 30) {
         AbstractArchive.archive0 = WorldMapRectangle.newArchive(0, false, true, true);
         Skeleton.archive1 = WorldMapRectangle.newArchive(1, false, true, true);
         ObjectSound.archive2 = WorldMapRectangle.newArchive(2, true, false, true);
         WorldMapIcon1.archive3 = WorldMapRectangle.newArchive(3, false, true, true);
         WorldMapDecoration.archive4 = WorldMapRectangle.newArchive(4, false, true, true);
         SecureRandomFuture.archive5 = WorldMapRectangle.newArchive(5, true, true, true);
         UserComparator3.archive6 = WorldMapRectangle.newArchive(6, true, true, true);
         class40.archive7 = WorldMapRectangle.newArchive(7, false, true, true);
         WorldMapSection1.archive8 = WorldMapRectangle.newArchive(8, false, true, true);
         class238.archive9 = WorldMapRectangle.newArchive(9, false, true, true);
         class16.archive10 = WorldMapRectangle.newArchive(10, false, true, true);
         Login.archive11 = WorldMapRectangle.newArchive(11, false, true, true);
         Formatting.archive12 = WorldMapRectangle.newArchive(12, false, true, true);
         ByteArrayPool.archive13 = WorldMapRectangle.newArchive(13, true, false, true);
         class2.archive14 = WorldMapRectangle.newArchive(14, false, true, true);
         WorldMapSection2.archive15 = WorldMapRectangle.newArchive(15, false, true, true);
         WorldMapRectangle.archive17 = WorldMapRectangle.newArchive(17, true, true, true);
         WorldMapLabelSize.archive18 = WorldMapRectangle.newArchive(18, false, true, true);
         ItemContainer.archive19 = WorldMapRectangle.newArchive(19, false, true, true);
         AbstractByteArrayCopier.archive20 = WorldMapRectangle.newArchive(20, false, true, true);
         Login.Login_loadingText = "Connecting to update server";
         Login.Login_loadingPercent = 20;
         Client.titleLoadingStage = 40;
      } else if (Client.titleLoadingStage == 40) {
         byte var1 = 0;
         var0 = var1 + AbstractArchive.archive0.percentage() * 4 / 100;
         var0 += Skeleton.archive1.percentage() * 4 / 100;
         var0 += ObjectSound.archive2.percentage() * 2 / 100;
         var0 += WorldMapIcon1.archive3.percentage() * 2 / 100;
         var0 += WorldMapDecoration.archive4.percentage() * 6 / 100;
         var0 += SecureRandomFuture.archive5.percentage() * 4 / 100;
         var0 += UserComparator3.archive6.percentage() * 2 / 100;
         var0 += class40.archive7.percentage() * 56 / 100;
         var0 += WorldMapSection1.archive8.percentage() * 2 / 100;
         var0 += class238.archive9.percentage() * 2 / 100;
         var0 += class16.archive10.percentage() * 2 / 100;
         var0 += Login.archive11.percentage() * 2 / 100;
         var0 += Formatting.archive12.percentage() * 2 / 100;
         var0 += ByteArrayPool.archive13.percentage() * 2 / 100;
         var0 += class2.archive14.percentage() * 2 / 100;
         var0 += WorldMapSection2.archive15.percentage() * 2 / 100;
         var0 += ItemContainer.archive19.percentage() / 100;
         var0 += WorldMapLabelSize.archive18.percentage() / 100;
         var0 += AbstractByteArrayCopier.archive20.percentage() / 100;
         var0 += WorldMapRectangle.archive17.method130() && WorldMapRectangle.archive17.method2() ? 1 : 0;
         if (var0 != 100) {
            if (var0 != 0) {
               Login.Login_loadingText = "Checking for updates - " + var0 + "%";
            }

            Login.Login_loadingPercent = 30;
         } else {
            AbstractWorldMapIcon.method625(AbstractArchive.archive0, "Animations");
            AbstractWorldMapIcon.method625(Skeleton.archive1, "Skeletons");
            AbstractWorldMapIcon.method625(WorldMapDecoration.archive4, "Sound FX");
            AbstractWorldMapIcon.method625(SecureRandomFuture.archive5, "Maps");
            AbstractWorldMapIcon.method625(UserComparator3.archive6, "Music Tracks");
            AbstractWorldMapIcon.method625(class40.archive7, "Models");
            AbstractWorldMapIcon.method625(WorldMapSection1.archive8, "Sprites");
            AbstractWorldMapIcon.method625(Login.archive11, "Music Jingles");
            AbstractWorldMapIcon.method625(class2.archive14, "Music Samples");
            AbstractWorldMapIcon.method625(WorldMapSection2.archive15, "Music Patches");
            AbstractWorldMapIcon.method625(ItemContainer.archive19, "World Map");
            AbstractWorldMapIcon.method625(WorldMapLabelSize.archive18, "World Map Geography");
            AbstractWorldMapIcon.method625(AbstractByteArrayCopier.archive20, "World Map Ground");
            Calendar.spriteIds = new GraphicsDefaults();
            Calendar.spriteIds.decode(WorldMapRectangle.archive17);
            Login.Login_loadingText = "Loaded update list";
            Login.Login_loadingPercent = 30;
            Client.titleLoadingStage = 45;
         }
      } else if (Client.titleLoadingStage == 45) {
         Tiles.method1097(22050, !Client.isLowDetail, 2);
         MidiPcmStream var28 = new MidiPcmStream();
         var28.method174(9, 128);
         WorldMapCacheName.pcmPlayer0 = Players.newPcmPlayer(GameShell.taskHandler, 0, 22050);
         WorldMapCacheName.pcmPlayer0.setStream(var28);
         NetSocket.method3537(WorldMapSection2.archive15, class2.archive14, WorldMapDecoration.archive4, var28);
         AbstractArchive.pcmPlayer1 = Players.newPcmPlayer(GameShell.taskHandler, 1, 2048);
         TaskHandler.pcmStreamMixer = new PcmStreamMixer();
         AbstractArchive.pcmPlayer1.setStream(TaskHandler.pcmStreamMixer);
         MilliClock.decimator = new Decimator(22050, class309.PcmPlayer_sampleRate);
         Login.Login_loadingText = "Prepared sound engine";
         Login.Login_loadingPercent = 35;
         Client.titleLoadingStage = 50;
         WorldMapElement.WorldMapElement_fonts = new Fonts(WorldMapSection1.archive8, ByteArrayPool.archive13);
      } else {
         int var29;
         if (Client.titleLoadingStage == 50) {
            FontName[] var2 = new FontName[]{FontName.FontName_verdana15, FontName.FontName_bold12, FontName.FontName_plain12, FontName.FontName_verdana11, FontName.FontName_plain11, FontName.FontName_verdana13};
            var29 = var2.length;
            Fonts var3 = WorldMapElement.WorldMapElement_fonts;
            FontName[] var4 = new FontName[]{FontName.FontName_verdana15, FontName.FontName_bold12, FontName.FontName_plain12, FontName.FontName_verdana11, FontName.FontName_plain11, FontName.FontName_verdana13};
            Client.fontsMap = var3.createMap(var4);
            if (Client.fontsMap.size() < var29) {
               Login.Login_loadingText = "Loading fonts - " + Client.fontsMap.size() * 100 / var29 + "%";
               Login.Login_loadingPercent = 40;
            } else {
               ScriptEvent.fontPlain11 = (Font)Client.fontsMap.get(FontName.FontName_plain11);
               DevicePcmPlayerProvider.fontPlain12 = (Font)Client.fontsMap.get(FontName.FontName_plain12);
               class2.fontBold12 = (Font)Client.fontsMap.get(FontName.FontName_bold12);
               WorldMapLabelSize.platformInfo = Client.platformInfoProvider.get();
               Login.Login_loadingText = "Loaded fonts";
               Login.Login_loadingPercent = 40;
               Client.titleLoadingStage = 60;
            }
         } else if (Client.titleLoadingStage == 60) {
            var0 = FloorDecoration.method2853(class16.archive10, WorldMapSection1.archive8);
            var29 = class3.method36();
            if (var0 < var29) {
               Login.Login_loadingText = "Loading title screen - " + var0 * 100 / var29 + "%";
               Login.Login_loadingPercent = 50;
            } else {
               Login.Login_loadingText = "Loaded title screen";
               Login.Login_loadingPercent = 50;
               GameShell.updateGameState(5);
               Client.titleLoadingStage = 70;
            }
         } else {
            Archive var30;
            if (Client.titleLoadingStage == 70) {
               if (!ObjectSound.archive2.method2()) {
                  Login.Login_loadingText = "Loading config - " + ObjectSound.archive2.loadPercent() + "%";
                  Login.Login_loadingPercent = 60;
               } else {
                  Varcs.method2160(ObjectSound.archive2);
                  Varps.method4393(ObjectSound.archive2);
                  Archive var31 = ObjectSound.archive2;
                  Archive var33 = class40.archive7;
                  KitDefinition.KitDefinition_archive = var31;
                  KitDefinition.field456 = var33;
                  KitDefinition.KitDefinition_totalCount = KitDefinition.KitDefinition_archive.getGroupFileCount(3);
                  RectangleMode.setObjectDefinitionArchives(ObjectSound.archive2, class40.archive7, Client.isLowDetail);
                  IsaacCipher.setNpcDefinitionArchives(ObjectSound.archive2, class40.archive7);
                  var30 = ObjectSound.archive2;
                  StructDefinition.StructDefinition_archive = var30;
                  Archive var5 = ObjectSound.archive2;
                  Archive var6 = class40.archive7;
                  boolean var7 = Client.isMembersWorld;
                  Font var8 = ScriptEvent.fontPlain11;
                  ItemDefinition.ItemDefinition_archive = var5;
                  ItemDefinition.ItemDefinition_modelArchive = var6;
                  class30.inMembersWorld = var7;
                  class83.field1167 = ItemDefinition.ItemDefinition_archive.getGroupFileCount(10);
                  class204.field1122 = var8;
                  Archive var9 = ObjectSound.archive2;
                  Archive var10 = AbstractArchive.archive0;
                  Archive var11 = Skeleton.archive1;
                  SequenceDefinition.SequenceDefinition_archive = var9;
                  SequenceDefinition.field773 = var10;
                  SequenceDefinition.field774 = var11;
                  Archive var12 = ObjectSound.archive2;
                  Archive var13 = class40.archive7;
                  SpotAnimationDefinition.SpotAnimationDefinition_archive = var12;
                  SpotAnimationDefinition.SpotAnimationDefinition_modelArchive = var13;
                  GrandExchangeOfferUnitPriceComparator.setVarbitDefinitionArchive(ObjectSound.archive2);
                  Archive var14 = ObjectSound.archive2;
                  VarpDefinition.field943 = var14;
                  VarpDefinition.field944 = VarpDefinition.field943.getGroupFileCount(16);
                  Archive var15 = WorldMapIcon1.archive3;
                  Archive var16 = class40.archive7;
                  Archive var17 = WorldMapSection1.archive8;
                  Archive var18 = ByteArrayPool.archive13;
                  Widget.Widget_archive = var15;
                  BufferedSource.field54 = var16;
                  Widget.field955 = var17;
                  class27.field1143 = var18;
                  Widget.interfaceComponents = new Widget[Widget.Widget_archive.getGroupCount()][];
                  Widget.loadedInterfaces = new boolean[Widget.Widget_archive.getGroupCount()];
                  Archive var19 = ObjectSound.archive2;
                  class4.InvDefinition_archive = var19;
                  Archive var20 = ObjectSound.archive2;
                  EnumDefinition.EnumDefinition_archive = var20;
                  Frames.method3241(ObjectSound.archive2);
                  Archive var21 = ObjectSound.archive2;
                  ParamDefinition.ParamDefinition_archive = var21;
                  class196.varcs = new Varcs();
                  class60.method1172(ObjectSound.archive2, WorldMapSection1.archive8, ByteArrayPool.archive13);
                  Archive var22 = ObjectSound.archive2;
                  Archive var23 = WorldMapSection1.archive8;
                  HealthBarDefinition.field379 = var22;
                  HealthBarDefinition.field380 = var23;
                  Archive var24 = ObjectSound.archive2;
                  Archive var25 = WorldMapSection1.archive8;
                  WorldMapElement.WorldMapElement_archive = var25;
                  if (var24.method2()) {
                     UserComparator4.WorldMapElement_count = var24.getGroupFileCount(35);
                     Widget.WorldMapElement_cached = new WorldMapElement[UserComparator4.WorldMapElement_count];

                     for (int var26 = 0; var26 < UserComparator4.WorldMapElement_count; ++var26) {
                        byte[] var27 = var24.takeFile(35, var26);
                        Widget.WorldMapElement_cached[var26] = new WorldMapElement(var26);
                        if (var27 != null) {
                           Widget.WorldMapElement_cached[var26].decode(new Buffer(var27));
                           Widget.WorldMapElement_cached[var26].method389();
                        }
                     }
                  }

                  Login.Login_loadingText = "Loaded config";
                  Login.Login_loadingPercent = 60;
                  Client.titleLoadingStage = 80;
               }
            } else if (Client.titleLoadingStage == 80) {
               var0 = 0;
               if (GrandExchangeOfferUnitPriceComparator.compass == null) {
                  GrandExchangeOfferUnitPriceComparator.compass = class322.readSprite(WorldMapSection1.archive8, Calendar.spriteIds.field878, 0);
               } else {
                  ++var0;
               }

               if (FaceNormal.field345 == null) {
                  FaceNormal.field345 = class322.readSprite(WorldMapSection1.archive8, Calendar.spriteIds.field879, 0);
               } else {
                  ++var0;
               }

               IndexedSprite[] var32;
               int var34;
               if (class192.mapSceneSprites == null) {
                  var30 = WorldMapSection1.archive8;
                  var34 = Calendar.spriteIds.mapScenes;
                  if (!SpriteMask.loadSprite(var30, var34, 0)) {
                     var32 = null;
                  } else {
                     var32 = WorldMapLabel.createIndexedSpriteArray();
                  }

                  class192.mapSceneSprites = var32;
               } else {
                  ++var0;
               }

               Sprite[] var35;
               if (class15.headIconPkSprites == null) {
                  var30 = WorldMapSection1.archive8;
                  var34 = Calendar.spriteIds.headIconsPk;
                  if (!SpriteMask.loadSprite(var30, var34, 0)) {
                     var35 = null;
                  } else {
                     var35 = UserComparator9.createSpriteArray();
                  }

                  class15.headIconPkSprites = var35;
               } else {
                  ++var0;
               }

               if (ClientPreferences.headIconPrayerSprites == null) {
                  var30 = WorldMapSection1.archive8;
                  var34 = Calendar.spriteIds.headIconsPrayer;
                  if (!SpriteMask.loadSprite(var30, var34, 0)) {
                     var35 = null;
                  } else {
                     var35 = UserComparator9.createSpriteArray();
                  }

                  ClientPreferences.headIconPrayerSprites = var35;
               } else {
                  ++var0;
               }

               if (Player.headIconHintSprites == null) {
                  var30 = WorldMapSection1.archive8;
                  var34 = Calendar.spriteIds.headIconsHint;
                  if (!SpriteMask.loadSprite(var30, var34, 0)) {
                     var35 = null;
                  } else {
                     var35 = UserComparator9.createSpriteArray();
                  }

                  Player.headIconHintSprites = var35;
               } else {
                  ++var0;
               }

               if (class16.mapMarkerSprites == null) {
                  var30 = WorldMapSection1.archive8;
                  var34 = Calendar.spriteIds.mapMarkers;
                  if (!SpriteMask.loadSprite(var30, var34, 0)) {
                     var35 = null;
                  } else {
                     var35 = UserComparator9.createSpriteArray();
                  }

                  class16.mapMarkerSprites = var35;
               } else {
                  ++var0;
               }

               if (KeyHandler.crossSprites == null) {
                  var30 = WorldMapSection1.archive8;
                  var34 = Calendar.spriteIds.crosses;
                  if (!SpriteMask.loadSprite(var30, var34, 0)) {
                     var35 = null;
                  } else {
                     var35 = UserComparator9.createSpriteArray();
                  }

                  KeyHandler.crossSprites = var35;
               } else {
                  ++var0;
               }

               if (class39.mapDotSprites == null) {
                  var30 = WorldMapSection1.archive8;
                  var34 = Calendar.spriteIds.mapDots;
                  if (!SpriteMask.loadSprite(var30, var34, 0)) {
                     var35 = null;
                  } else {
                     var35 = UserComparator9.createSpriteArray();
                  }

                  class39.mapDotSprites = var35;
               } else {
                  ++var0;
               }

               if (class32.scrollBarSprites == null) {
                  var30 = WorldMapSection1.archive8;
                  var34 = Calendar.spriteIds.scrollBars;
                  if (!SpriteMask.loadSprite(var30, var34, 0)) {
                     var32 = null;
                  } else {
                     var32 = WorldMapLabel.createIndexedSpriteArray();
                  }

                  class32.scrollBarSprites = var32;
               } else {
                  ++var0;
               }

               if (WorldMapSectionType.modIconSprites == null) {
                  var30 = WorldMapSection1.archive8;
                  var34 = Calendar.spriteIds.modIcons;
                  if (!SpriteMask.loadSprite(var30, var34, 0)) {
                     var32 = null;
                  } else {
                     var32 = WorldMapLabel.createIndexedSpriteArray();
                  }

                  WorldMapSectionType.modIconSprites = var32;
               } else {
                  ++var0;
               }

               if (var0 < 11) {
                  Login.Login_loadingText = "Loading sprites - " + var0 * 100 / 12 + "%";
                  Login.Login_loadingPercent = 70;
               } else {
                  AbstractFont.AbstractFont_modIconSprites = WorldMapSectionType.modIconSprites;
                  FaceNormal.field345.normalize();
                  var29 = (int)(Math.random() * 21.0D) - 10;
                  int var36 = (int)(Math.random() * 21.0D) - 10;
                  var34 = (int)(Math.random() * 21.0D) - 10;
                  int var38 = (int)(Math.random() * 41.0D) - 20;
                  class192.mapSceneSprites[0].shiftColors(var38 + var29, var38 + var36, var38 + var34);
                  Login.Login_loadingText = "Loaded sprites";
                  Login.Login_loadingPercent = 70;
                  Client.titleLoadingStage = 90;
               }
            } else if (Client.titleLoadingStage == 90) {
               if (!class238.archive9.method2()) {
                  Login.Login_loadingText = "Loading textures - 0%";
                  Login.Login_loadingPercent = 90;
               } else {
                  SecureRandomFuture.textureProvider = new TextureProvider(class238.archive9, WorldMapSection1.archive8, 20, 0.8D, Client.isLowDetail ? 64 : 128);
                  Rasterizer3D.Rasterizer3D_setTextureLoader(SecureRandomFuture.textureProvider);
                  Rasterizer3D.Rasterizer3D_setBrightness(0.8D);
                  Client.titleLoadingStage = 100;
               }
            } else if (Client.titleLoadingStage == 100) {
               var0 = SecureRandomFuture.textureProvider.method323();
               if (var0 < 100) {
                  Login.Login_loadingText = "Loading textures - " + var0 + "%";
                  Login.Login_loadingPercent = 90;
               } else {
                  Login.Login_loadingText = "Loaded textures";
                  Login.Login_loadingPercent = 90;
                  Client.titleLoadingStage = 110;
               }
            } else if (Client.titleLoadingStage == 110) {
               Projectile.mouseRecorder = new MouseRecorder();
               GameShell.taskHandler.newThreadTask(Projectile.mouseRecorder, 10);
               Login.Login_loadingText = "Loaded input handler";
               Login.Login_loadingPercent = 92;
               Client.titleLoadingStage = 120;
            } else if (Client.titleLoadingStage == 120) {
               if (!class16.archive10.tryLoadFileByNames("huffman", "")) {
                  Login.Login_loadingText = "Loading wordpack - 0%";
                  Login.Login_loadingPercent = 94;
               } else {
                  Huffman var37 = new Huffman(class16.archive10.takeFileByNames("huffman", ""));
                  class303.huffman = var37;
                  Login.Login_loadingText = "Loaded wordpack";
                  Login.Login_loadingPercent = 94;
                  Client.titleLoadingStage = 130;
               }
            } else if (Client.titleLoadingStage == 130) {
               if (!WorldMapIcon1.archive3.method2()) {
                  Login.Login_loadingText = "Loading interfaces - " + WorldMapIcon1.archive3.loadPercent() * 4 / 5 + "%";
                  Login.Login_loadingPercent = 96;
               } else if (!Formatting.archive12.method2()) {
                  Login.Login_loadingText = "Loading interfaces - " + (80 + Formatting.archive12.loadPercent() / 6) + "%";
                  Login.Login_loadingPercent = 96;
               } else if (!ByteArrayPool.archive13.method2()) {
                  Login.Login_loadingText = "Loading interfaces - " + (96 + ByteArrayPool.archive13.loadPercent() / 50) + "%";
                  Login.Login_loadingPercent = 96;
               } else {
                  Login.Login_loadingText = "Loaded interfaces";
                  Login.Login_loadingPercent = 98;
                  Client.titleLoadingStage = 140;
               }
            } else if (Client.titleLoadingStage == 140) {
               Login.Login_loadingPercent = 100;
               if (!ItemContainer.archive19.tryLoadGroupByName(WorldMapCacheName.WorldMapCacheName_details.name)) {
                  Login.Login_loadingText = "Loading world map - " + ItemContainer.archive19.groupLoadPercentByName(WorldMapCacheName.WorldMapCacheName_details.name) / 10 + "%";
               } else {
                  if (class60.worldMap0 == null) {
                     class60.worldMap0 = new WorldMap();
                     class60.worldMap0.init(ItemContainer.archive19, WorldMapLabelSize.archive18, AbstractByteArrayCopier.archive20, class2.fontBold12, Client.fontsMap, class192.mapSceneSprites);
                  }

                  Login.Login_loadingText = "Loaded world map";
                  Client.titleLoadingStage = 150;
               }
            } else if (Client.titleLoadingStage == 150) {
               GameShell.updateGameState(10);
            }
         }
      }

   }

   @ObfuscatedName("ie")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;I)V",
      garbageValue = "49247882"
   )
   static void method3494(int var0, int var1, int var2, int var3, String var4) {
      Widget var5 = class204.getWidgetChild(var1, var2);
      if (var5 != null) {
         if (var5.onOp != null) {
            ScriptEvent var6 = new ScriptEvent();
            var6.widget = var5;
            var6.opIndex = var0;
            var6.targetName = var4;
            var6.args0 = var5.onOp;
            AbstractArchive.runScript(var6);
         }

         boolean var11 = true;
         if (var5.contentType > 0) {
            var11 = ViewportMouse.method2957(var5);
         }

         if (var11) {
            int var7 = class1.getWidgetClickMask(var5);
            int var8 = var0 - 1;
            boolean var9 = (var7 >> var8 + 1 & 1) != 0;
            if (var9) {
               PacketBufferNode var10;
               if (var0 == 1) {
                  var10 = Interpreter.method1915(ClientPacket.field290, Client.packetWriter.isaacCipher);
                  var10.packetBuffer.writeInt(var1);
                  var10.packetBuffer.writeShort(var2);
                  var10.packetBuffer.writeShort(var3);
                  Client.packetWriter.method241(var10);
               }

               if (var0 == 2) {
                  var10 = Interpreter.method1915(ClientPacket.field243, Client.packetWriter.isaacCipher);
                  var10.packetBuffer.writeInt(var1);
                  var10.packetBuffer.writeShort(var2);
                  var10.packetBuffer.writeShort(var3);
                  Client.packetWriter.method241(var10);
               }

               if (var0 == 3) {
                  var10 = Interpreter.method1915(ClientPacket.field270, Client.packetWriter.isaacCipher);
                  var10.packetBuffer.writeInt(var1);
                  var10.packetBuffer.writeShort(var2);
                  var10.packetBuffer.writeShort(var3);
                  Client.packetWriter.method241(var10);
               }

               if (var0 == 4) {
                  var10 = Interpreter.method1915(ClientPacket.field241, Client.packetWriter.isaacCipher);
                  var10.packetBuffer.writeInt(var1);
                  var10.packetBuffer.writeShort(var2);
                  var10.packetBuffer.writeShort(var3);
                  Client.packetWriter.method241(var10);
               }

               if (var0 == 5) {
                  var10 = Interpreter.method1915(ClientPacket.field262, Client.packetWriter.isaacCipher);
                  var10.packetBuffer.writeInt(var1);
                  var10.packetBuffer.writeShort(var2);
                  var10.packetBuffer.writeShort(var3);
                  Client.packetWriter.method241(var10);
               }

               if (var0 == 6) {
                  var10 = Interpreter.method1915(ClientPacket.field288, Client.packetWriter.isaacCipher);
                  var10.packetBuffer.writeInt(var1);
                  var10.packetBuffer.writeShort(var2);
                  var10.packetBuffer.writeShort(var3);
                  Client.packetWriter.method241(var10);
               }

               if (var0 == 7) {
                  var10 = Interpreter.method1915(ClientPacket.field307, Client.packetWriter.isaacCipher);
                  var10.packetBuffer.writeInt(var1);
                  var10.packetBuffer.writeShort(var2);
                  var10.packetBuffer.writeShort(var3);
                  Client.packetWriter.method241(var10);
               }

               if (var0 == 8) {
                  var10 = Interpreter.method1915(ClientPacket.field236, Client.packetWriter.isaacCipher);
                  var10.packetBuffer.writeInt(var1);
                  var10.packetBuffer.writeShort(var2);
                  var10.packetBuffer.writeShort(var3);
                  Client.packetWriter.method241(var10);
               }

               if (var0 == 9) {
                  var10 = Interpreter.method1915(ClientPacket.field306, Client.packetWriter.isaacCipher);
                  var10.packetBuffer.writeInt(var1);
                  var10.packetBuffer.writeShort(var2);
                  var10.packetBuffer.writeShort(var3);
                  Client.packetWriter.method241(var10);
               }

               if (var0 == 10) {
                  var10 = Interpreter.method1915(ClientPacket.field222, Client.packetWriter.isaacCipher);
                  var10.packetBuffer.writeInt(var1);
                  var10.packetBuffer.writeShort(var2);
                  var10.packetBuffer.writeShort(var3);
                  Client.packetWriter.method241(var10);
               }
            }
         }
      }

   }

   static {
      field1117 = false;
      field1119 = new Hashtable(16);
   }
}
