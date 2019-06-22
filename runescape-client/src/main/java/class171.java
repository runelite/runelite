import java.io.File;
import java.util.Hashtable;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fo")
public class class171 {
   @ObfuscatedName("ro")
   @ObfuscatedGetter(
      intValue = -852697585
   )
   @Export("__fo_ro")
   static int __fo_ro;
   @ObfuscatedName("m")
   @Export("__fo_m")
   public static boolean __fo_m;
   @ObfuscatedName("f")
   @Export("__fo_f")
   public static File __fo_f;
   @ObfuscatedName("q")
   @Export("__fo_q")
   static Hashtable __fo_q;

   static {
      __fo_m = false;
      __fo_q = new Hashtable(16);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "21"
   )
   public static void method3498() {
      KeyHandler var0 = KeyHandler.KeyHandler_instance;
      synchronized(KeyHandler.KeyHandler_instance) {
         ++KeyHandler.KeyHandler_idleCycles;
         KeyHandler.__an_ct = KeyHandler.__an_cc;
         KeyHandler.__an_cl = 0;
         int var1;
         if(KeyHandler.__an_cw < 0) {
            for(var1 = 0; var1 < 112; ++var1) {
               KeyHandler.KeyHandler_pressedKeys[var1] = false;
            }

            KeyHandler.__an_cw = KeyHandler.__an_ch;
         } else {
            while(KeyHandler.__an_cw != KeyHandler.__an_ch) {
               var1 = KeyHandler.__an_cq[KeyHandler.__an_ch];
               KeyHandler.__an_ch = KeyHandler.__an_ch + 1 & 127;
               if(var1 < 0) {
                  KeyHandler.KeyHandler_pressedKeys[~var1] = false;
               } else {
                  if(!KeyHandler.KeyHandler_pressedKeys[var1] && KeyHandler.__an_cl < KeyHandler.__an_cp.length - 1) {
                     KeyHandler.__an_cp[++KeyHandler.__an_cl - 1] = var1;
                  }

                  KeyHandler.KeyHandler_pressedKeys[var1] = true;
               }
            }
         }

         if(KeyHandler.__an_cl > 0) {
            KeyHandler.KeyHandler_idleCycles = 0;
         }

         KeyHandler.__an_cc = KeyHandler.__an_cz;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIIIII)I",
      garbageValue = "-1048935304"
   )
   public static int method3496(int var0, int var1, int var2, int var3, int var4, int var5) {
      if((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return var2 == 0?var1:(var2 == 1?7 - var0 - (var3 - 1):(var2 == 2?7 - var1 - (var4 - 1):var0));
   }

   @ObfuscatedName("fq")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-36"
   )
   static void method3497() {
      int var0;
      if(Client.titleLoadingStage == 0) {
         class65.scene = new Scene(4, 104, 104, Tiles.Tiles_heights);

         for(var0 = 0; var0 < 4; ++var0) {
            Client.collisionMaps[var0] = new CollisionMap(104, 104);
         }

         WidgetGroupParent.sceneMinimapSprite = new Sprite(512, 512);
         Login.Login_loadingText = "Starting game engine...";
         Login.Login_loadingPercent = 5;
         Client.titleLoadingStage = 20;
      } else if(Client.titleLoadingStage == 20) {
         Login.Login_loadingText = "Prepared visibility map";
         Login.Login_loadingPercent = 10;
         Client.titleLoadingStage = 30;
      } else if(Client.titleLoadingStage == 30) {
         AbstractIndexCache.indexCache0 = class22.newIndexCache(0, false, true, true);
         Skeleton.indexCache1 = class22.newIndexCache(1, false, true, true);
         ObjectSound.indexCache2 = class22.newIndexCache(2, true, false, true);
         WorldMapIcon1.indexCache3 = class22.newIndexCache(3, false, true, true);
         class25.indexCache4 = class22.newIndexCache(4, false, true, true);
         SecureRandomFuture.indexCache5 = class22.newIndexCache(5, true, true, true);
         UserComparator3.indexCache6 = class22.newIndexCache(6, true, true, true);
         class40.indexCache7 = class22.newIndexCache(7, false, true, true);
         WorldMapSection3.indexCache8 = class22.newIndexCache(8, false, true, true);
         class238.indexCache9 = class22.newIndexCache(9, false, true, true);
         class16.indexCache10 = class22.newIndexCache(10, false, true, true);
         Login.indexCache11 = class22.newIndexCache(11, false, true, true);
         Formatting.indexCache12 = class22.newIndexCache(12, false, true, true);
         ByteArrayPool.indexCache13 = class22.newIndexCache(13, true, false, true);
         class2.indexCache14 = class22.newIndexCache(14, false, true, true);
         WorldMapSection1.indexCache15 = class22.newIndexCache(15, false, true, true);
         class22.indexCache16 = class22.newIndexCache(17, true, true, true);
         WorldMapLabelSize.__s_dq = class22.newIndexCache(18, false, true, true);
         ItemContainer.__bc_dm = class22.newIndexCache(19, false, true, true);
         AbstractByteArrayCopier.__gu_et = class22.newIndexCache(20, false, true, true);
         Login.Login_loadingText = "Connecting to update server";
         Login.Login_loadingPercent = 20;
         Client.titleLoadingStage = 40;
      } else if(Client.titleLoadingStage == 40) {
         byte var33 = 0;
         var0 = var33 + AbstractIndexCache.indexCache0.__ca_405() * 4 / 100;
         var0 += Skeleton.indexCache1.__ca_405() * 4 / 100;
         var0 += ObjectSound.indexCache2.__ca_405() * 2 / 100;
         var0 += WorldMapIcon1.indexCache3.__ca_405() * 2 / 100;
         var0 += class25.indexCache4.__ca_405() * 6 / 100;
         var0 += SecureRandomFuture.indexCache5.__ca_405() * 4 / 100;
         var0 += UserComparator3.indexCache6.__ca_405() * 2 / 100;
         var0 += class40.indexCache7.__ca_405() * 56 / 100;
         var0 += WorldMapSection3.indexCache8.__ca_405() * 2 / 100;
         var0 += class238.indexCache9.__ca_405() * 2 / 100;
         var0 += class16.indexCache10.__ca_405() * 2 / 100;
         var0 += Login.indexCache11.__ca_405() * 2 / 100;
         var0 += Formatting.indexCache12.__ca_405() * 2 / 100;
         var0 += ByteArrayPool.indexCache13.__ca_405() * 2 / 100;
         var0 += class2.indexCache14.__ca_405() * 2 / 100;
         var0 += WorldMapSection1.indexCache15.__ca_405() * 2 / 100;
         var0 += ItemContainer.__bc_dm.__ca_405() / 100;
         var0 += WorldMapLabelSize.__s_dq.__ca_405() / 100;
         var0 += AbstractByteArrayCopier.__gu_et.__ca_405() / 100;
         var0 += class22.indexCache16.__cx_404() && class22.indexCache16.__l_394()?1:0;
         if(var0 != 100) {
            if(var0 != 0) {
               Login.Login_loadingText = "Checking for updates - " + var0 + "%";
            }

            Login.Login_loadingPercent = 30;
         } else {
            AbstractWorldMapIcon.method625(AbstractIndexCache.indexCache0, "Animations");
            AbstractWorldMapIcon.method625(Skeleton.indexCache1, "Skeletons");
            AbstractWorldMapIcon.method625(class25.indexCache4, "Sound FX");
            AbstractWorldMapIcon.method625(SecureRandomFuture.indexCache5, "Maps");
            AbstractWorldMapIcon.method625(UserComparator3.indexCache6, "Music Tracks");
            AbstractWorldMapIcon.method625(class40.indexCache7, "Models");
            AbstractWorldMapIcon.method625(WorldMapSection3.indexCache8, "Sprites");
            AbstractWorldMapIcon.method625(Login.indexCache11, "Music Jingles");
            AbstractWorldMapIcon.method625(class2.indexCache14, "Music Samples");
            AbstractWorldMapIcon.method625(WorldMapSection1.indexCache15, "Music Patches");
            AbstractWorldMapIcon.method625(ItemContainer.__bc_dm, "World Map");
            AbstractWorldMapIcon.method625(WorldMapLabelSize.__s_dq, "World Map Geography");
            AbstractWorldMapIcon.method625(AbstractByteArrayCopier.__gu_et, "World Map Ground");
            class211.spriteIds = new SpriteIds();
            class211.spriteIds.read(class22.indexCache16);
            Login.Login_loadingText = "Loaded update list";
            Login.Login_loadingPercent = 30;
            Client.titleLoadingStage = 45;
         }
      } else if(Client.titleLoadingStage == 45) {
         Tiles.method1097(22050, !Client.isLowDetail, 2);
         MidiPcmStream var36 = new MidiPcmStream();
         var36.__j_342(9, 128);
         WorldMapCacheName.pcmPlayer0 = Players.newPcmPlayer(GameShell.taskHandler, 0, 22050);
         WorldMapCacheName.pcmPlayer0.setStream(var36);
         NetSocket.method3537(WorldMapSection1.indexCache15, class2.indexCache14, class25.indexCache4, var36);
         AbstractIndexCache.pcmPlayer1 = Players.newPcmPlayer(GameShell.taskHandler, 1, 2048);
         TaskHandler.pcmStreamMixer = new PcmStreamMixer();
         AbstractIndexCache.pcmPlayer1.setStream(TaskHandler.pcmStreamMixer);
         MilliClock.decimator = new Decimator(22050, class309.PcmPlayer_sampleRate);
         Login.Login_loadingText = "Prepared sound engine";
         Login.Login_loadingPercent = 35;
         Client.titleLoadingStage = 50;
         WorldMapElement.fonts = new Fonts(WorldMapSection3.indexCache8, ByteArrayPool.indexCache13);
      } else {
         int var1;
         if(Client.titleLoadingStage == 50) {
            FontName[] var35 = new FontName[]{FontName.FontName_verdana15, FontName.FontName_bold12, FontName.FontName_plain12, FontName.FontName_verdana11, FontName.FontName_plain11, FontName.FontName_verdana13};
            var1 = var35.length;
            Fonts var32 = WorldMapElement.fonts;
            FontName[] var31 = new FontName[]{FontName.FontName_verdana15, FontName.FontName_bold12, FontName.FontName_plain12, FontName.FontName_verdana11, FontName.FontName_plain11, FontName.FontName_verdana13};
            Client.fontsMap = var32.createMap(var31);
            if(Client.fontsMap.size() < var1) {
               Login.Login_loadingText = "Loading fonts - " + Client.fontsMap.size() * 100 / var1 + "%";
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
         } else if(Client.titleLoadingStage == 60) {
            var0 = FloorDecoration.method2853(class16.indexCache10, WorldMapSection3.indexCache8);
            var1 = class3.method36();
            if(var0 < var1) {
               Login.Login_loadingText = "Loading title screen - " + var0 * 100 / var1 + "%";
               Login.Login_loadingPercent = 50;
            } else {
               Login.Login_loadingText = "Loaded title screen";
               Login.Login_loadingPercent = 50;
               GameShell.updateGameState(5);
               Client.titleLoadingStage = 70;
            }
         } else {
            IndexCache var2;
            if(Client.titleLoadingStage == 70) {
               if(!ObjectSound.indexCache2.__l_394()) {
                  Login.Login_loadingText = "Loading config - " + ObjectSound.indexCache2.loadPercent() + "%";
                  Login.Login_loadingPercent = 60;
               } else {
                  Varcs.method2160(ObjectSound.indexCache2);
                  Varps.method4393(ObjectSound.indexCache2);
                  IndexCache var34 = ObjectSound.indexCache2;
                  IndexCache var38 = class40.indexCache7;
                  KitDefinition.KitDefinition_indexCache = var34;
                  KitDefinition.__im_f = var38;
                  KitDefinition.__im_q = KitDefinition.KitDefinition_indexCache.__s_396(3);
                  RectangleMode.method6028(ObjectSound.indexCache2, class40.indexCache7, Client.isLowDetail);
                  IsaacCipher.method4082(ObjectSound.indexCache2, class40.indexCache7);
                  var2 = ObjectSound.indexCache2;
                  StructDefinition.__jq_m = var2;
                  IndexCache var3 = ObjectSound.indexCache2;
                  IndexCache var4 = class40.indexCache7;
                  boolean var5 = Client.isMembersWorld;
                  Font var6 = ScriptEvent.fontPlain11;
                  ItemDefinition.ItemDefinition_indexCache = var3;
                  ItemDefinition.ItemDefinition_modelIndexCache = var4;
                  class30.inMembersWorld = var5;
                  class83.__cm_e = ItemDefinition.ItemDefinition_indexCache.__s_396(10);
                  class204.__gx_n = var6;
                  IndexCache var7 = ObjectSound.indexCache2;
                  IndexCache var8 = AbstractIndexCache.indexCache0;
                  IndexCache var9 = Skeleton.indexCache1;
                  SequenceDefinition.SequenceDefinition_indexCache = var7;
                  SequenceDefinition.__jh_f = var8;
                  SequenceDefinition.__jh_q = var9;
                  IndexCache var10 = ObjectSound.indexCache2;
                  IndexCache var11 = class40.indexCache7;
                  SpotAnimationDefinition.SpotAnimationDefinition_indexCache = var10;
                  SpotAnimationDefinition.SpotAnimationDefinition_modelIndexCache = var11;
                  UnitPriceComparator.method135(ObjectSound.indexCache2);
                  IndexCache var12 = ObjectSound.indexCache2;
                  VarpDefinition.__ix_m = var12;
                  VarpDefinition.__ix_f = VarpDefinition.__ix_m.__s_396(16);
                  IndexCache var13 = WorldMapIcon1.indexCache3;
                  IndexCache var14 = class40.indexCache7;
                  IndexCache var15 = WorldMapSection3.indexCache8;
                  IndexCache var16 = ByteArrayPool.indexCache13;
                  Widget.Widget_indexCache = var13;
                  BufferedSource.__fh_x = var14;
                  Widget.__ho_d = var15;
                  class27.__aq_k = var16;
                  Widget.widgets = new Widget[Widget.Widget_indexCache.__t_397()][];
                  Widget.loadedWidgetGroups = new boolean[Widget.Widget_indexCache.__t_397()];
                  IndexCache var17 = ObjectSound.indexCache2;
                  class4.__o_m = var17;
                  IndexCache var18 = ObjectSound.indexCache2;
                  EnumDefinition.EnumDefinition_indexCache = var18;
                  Frames.method3241(ObjectSound.indexCache2);
                  IndexCache var19 = ObjectSound.indexCache2;
                  ParamKeyDefinition.__jb_m = var19;
                  class196.varcs = new Varcs();
                  class60.method1172(ObjectSound.indexCache2, WorldMapSection3.indexCache8, ByteArrayPool.indexCache13);
                  IndexCache var20 = ObjectSound.indexCache2;
                  IndexCache var21 = WorldMapSection3.indexCache8;
                  HealthBarDefinition.__ii_m = var20;
                  HealthBarDefinition.__ii_f = var21;
                  IndexCache var22 = ObjectSound.indexCache2;
                  IndexCache var23 = WorldMapSection3.indexCache8;
                  WorldMapElement.__ic_m = var23;
                  if(var22.__l_394()) {
                     UserComparator4.WorldMapElement_count = var22.__s_396(35);
                     Widget.WorldMapElement_cached = new WorldMapElement[UserComparator4.WorldMapElement_count];

                     for(int var24 = 0; var24 < UserComparator4.WorldMapElement_count; ++var24) {
                        byte[] var25 = var22.takeRecord(35, var24);
                        Widget.WorldMapElement_cached[var24] = new WorldMapElement(var24);
                        if(var25 != null) {
                           Widget.WorldMapElement_cached[var24].read(new Buffer(var25));
                           Widget.WorldMapElement_cached[var24].__w_409();
                        }
                     }
                  }

                  Login.Login_loadingText = "Loaded config";
                  Login.Login_loadingPercent = 60;
                  Client.titleLoadingStage = 80;
               }
            } else if(Client.titleLoadingStage == 80) {
               var0 = 0;
               if(UnitPriceComparator.compass == null) {
                  UnitPriceComparator.compass = class322.readSprite(WorldMapSection3.indexCache8, class211.spriteIds.__m, 0);
               } else {
                  ++var0;
               }

               if(FaceNormal.__el_gm == null) {
                  FaceNormal.__el_gm = class322.readSprite(WorldMapSection3.indexCache8, class211.spriteIds.__f, 0);
               } else {
                  ++var0;
               }

               IndexedSprite[] var27;
               int var28;
               if(class192.mapSceneSprites == null) {
                  var2 = WorldMapSection3.indexCache8;
                  var28 = class211.spriteIds.mapScenes;
                  if(!SpriteMask.method4392(var2, var28, 0)) {
                     var27 = null;
                  } else {
                     var27 = WorldMapLabel.method444();
                  }

                  class192.mapSceneSprites = var27;
               } else {
                  ++var0;
               }

               Sprite[] var37;
               if(class15.headIconPkSprites == null) {
                  var2 = WorldMapSection3.indexCache8;
                  var28 = class211.spriteIds.headIconsPk;
                  if(!SpriteMask.method4392(var2, var28, 0)) {
                     var37 = null;
                  } else {
                     var37 = UserComparator9.method3344();
                  }

                  class15.headIconPkSprites = var37;
               } else {
                  ++var0;
               }

               if(ClientPreferences.headIconPrayerSprites == null) {
                  var2 = WorldMapSection3.indexCache8;
                  var28 = class211.spriteIds.headIconsPrayer;
                  if(!SpriteMask.method4392(var2, var28, 0)) {
                     var37 = null;
                  } else {
                     var37 = UserComparator9.method3344();
                  }

                  ClientPreferences.headIconPrayerSprites = var37;
               } else {
                  ++var0;
               }

               if(Player.headIconHintSprites == null) {
                  var2 = WorldMapSection3.indexCache8;
                  var28 = class211.spriteIds.headIconsHint;
                  if(!SpriteMask.method4392(var2, var28, 0)) {
                     var37 = null;
                  } else {
                     var37 = UserComparator9.method3344();
                  }

                  Player.headIconHintSprites = var37;
               } else {
                  ++var0;
               }

               if(class16.mapMarkerSprites == null) {
                  var2 = WorldMapSection3.indexCache8;
                  var28 = class211.spriteIds.mapMarkers;
                  if(!SpriteMask.method4392(var2, var28, 0)) {
                     var37 = null;
                  } else {
                     var37 = UserComparator9.method3344();
                  }

                  class16.mapMarkerSprites = var37;
               } else {
                  ++var0;
               }

               if(KeyHandler.crossSprites == null) {
                  var2 = WorldMapSection3.indexCache8;
                  var28 = class211.spriteIds.crosses;
                  if(!SpriteMask.method4392(var2, var28, 0)) {
                     var37 = null;
                  } else {
                     var37 = UserComparator9.method3344();
                  }

                  KeyHandler.crossSprites = var37;
               } else {
                  ++var0;
               }

               if(class39.mapDotSprites == null) {
                  var2 = WorldMapSection3.indexCache8;
                  var28 = class211.spriteIds.mapDots;
                  if(!SpriteMask.method4392(var2, var28, 0)) {
                     var37 = null;
                  } else {
                     var37 = UserComparator9.method3344();
                  }

                  class39.mapDotSprites = var37;
               } else {
                  ++var0;
               }

               if(class32.scrollBarSprites == null) {
                  var2 = WorldMapSection3.indexCache8;
                  var28 = class211.spriteIds.scrollBars;
                  if(!SpriteMask.method4392(var2, var28, 0)) {
                     var27 = null;
                  } else {
                     var27 = WorldMapLabel.method444();
                  }

                  class32.scrollBarSprites = var27;
               } else {
                  ++var0;
               }

               if(WorldMapSectionType.modIconSprites == null) {
                  var2 = WorldMapSection3.indexCache8;
                  var28 = class211.spriteIds.modIcons;
                  if(!SpriteMask.method4392(var2, var28, 0)) {
                     var27 = null;
                  } else {
                     var27 = WorldMapLabel.method444();
                  }

                  WorldMapSectionType.modIconSprites = var27;
               } else {
                  ++var0;
               }

               if(var0 < 11) {
                  Login.Login_loadingText = "Loading sprites - " + var0 * 100 / 12 + "%";
                  Login.Login_loadingPercent = 70;
               } else {
                  AbstractFont.AbstractFont_modIconSprites = WorldMapSectionType.modIconSprites;
                  FaceNormal.__el_gm.normalize();
                  var1 = (int)(Math.random() * 21.0D) - 10;
                  int var29 = (int)(Math.random() * 21.0D) - 10;
                  var28 = (int)(Math.random() * 21.0D) - 10;
                  int var30 = (int)(Math.random() * 41.0D) - 20;
                  class192.mapSceneSprites[0].shiftColors(var30 + var1, var30 + var29, var30 + var28);
                  Login.Login_loadingText = "Loaded sprites";
                  Login.Login_loadingPercent = 70;
                  Client.titleLoadingStage = 90;
               }
            } else if(Client.titleLoadingStage == 90) {
               if(!class238.indexCache9.__l_394()) {
                  Login.Login_loadingText = "Loading textures - " + "0%";
                  Login.Login_loadingPercent = 90;
               } else {
                  SecureRandomFuture.textureProvider = new TextureProvider(class238.indexCache9, WorldMapSection3.indexCache8, 20, 0.8D, Client.isLowDetail?64:128);
                  Rasterizer3D.Rasterizer3D_setTextureLoader(SecureRandomFuture.textureProvider);
                  Rasterizer3D.Rasterizer3D_setBrightness(0.8D);
                  Client.titleLoadingStage = 100;
               }
            } else if(Client.titleLoadingStage == 100) {
               var0 = SecureRandomFuture.textureProvider.__m_212();
               if(var0 < 100) {
                  Login.Login_loadingText = "Loading textures - " + var0 + "%";
                  Login.Login_loadingPercent = 90;
               } else {
                  Login.Login_loadingText = "Loaded textures";
                  Login.Login_loadingPercent = 90;
                  Client.titleLoadingStage = 110;
               }
            } else if(Client.titleLoadingStage == 110) {
               Projectile.mouseRecorder = new MouseRecorder();
               GameShell.taskHandler.newThreadTask(Projectile.mouseRecorder, 10);
               Login.Login_loadingText = "Loaded input handler";
               Login.Login_loadingPercent = 92;
               Client.titleLoadingStage = 120;
            } else if(Client.titleLoadingStage == 120) {
               if(!class16.indexCache10.tryLoadRecordByNames("huffman", "")) {
                  Login.Login_loadingText = "Loading wordpack - " + 0 + "%";
                  Login.Login_loadingPercent = 94;
               } else {
                  Huffman var26 = new Huffman(class16.indexCache10.takeRecordByNames("huffman", ""));
                  class303.huffman = var26;
                  Login.Login_loadingText = "Loaded wordpack";
                  Login.Login_loadingPercent = 94;
                  Client.titleLoadingStage = 130;
               }
            } else if(Client.titleLoadingStage == 130) {
               if(!WorldMapIcon1.indexCache3.__l_394()) {
                  Login.Login_loadingText = "Loading interfaces - " + WorldMapIcon1.indexCache3.loadPercent() * 4 / 5 + "%";
                  Login.Login_loadingPercent = 96;
               } else if(!Formatting.indexCache12.__l_394()) {
                  Login.Login_loadingText = "Loading interfaces - " + (80 + Formatting.indexCache12.loadPercent() / 6) + "%";
                  Login.Login_loadingPercent = 96;
               } else if(!ByteArrayPool.indexCache13.__l_394()) {
                  Login.Login_loadingText = "Loading interfaces - " + (96 + ByteArrayPool.indexCache13.loadPercent() / 50) + "%";
                  Login.Login_loadingPercent = 96;
               } else {
                  Login.Login_loadingText = "Loaded interfaces";
                  Login.Login_loadingPercent = 98;
                  Client.titleLoadingStage = 140;
               }
            } else if(Client.titleLoadingStage == 140) {
               Login.Login_loadingPercent = 100;
               if(!ItemContainer.__bc_dm.tryLoadArchiveByName(WorldMapCacheName.WorldMapCacheName_details.name)) {
                  Login.Login_loadingText = "Loading world map - " + ItemContainer.__bc_dm.archiveLoadPercentByName(WorldMapCacheName.WorldMapCacheName_details.name) / 10 + "%";
               } else {
                  if(class60.worldMap0 == null) {
                     class60.worldMap0 = new WorldMap();
                     class60.worldMap0.init(ItemContainer.__bc_dm, WorldMapLabelSize.__s_dq, AbstractByteArrayCopier.__gu_et, class2.fontBold12, Client.fontsMap, class192.mapSceneSprites);
                  }

                  Login.Login_loadingText = "Loaded world map";
                  Client.titleLoadingStage = 150;
               }
            } else if(Client.titleLoadingStage == 150) {
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
      if(var5 != null) {
         if(var5.onOp != null) {
            ScriptEvent var6 = new ScriptEvent();
            var6.widget = var5;
            var6.opIndex = var0;
            var6.targetName = var4;
            var6.args0 = var5.onOp;
            AbstractIndexCache.runScript(var6);
         }

         boolean var11 = true;
         if(var5.contentType > 0) {
            var11 = ViewportMouse.method2957(var5);
         }

         if(var11) {
            int var8 = class1.getWidgetClickMask(var5);
            int var9 = var0 - 1;
            boolean var7 = (var8 >> var9 + 1 & 1) != 0;
            if(var7) {
               PacketBufferNode var10;
               if(var0 == 1) {
                  var10 = Interpreter.method1915(ClientPacket.__gs_bi, Client.packetWriter.isaacCipher);
                  var10.packetBuffer.writeInt(var1);
                  var10.packetBuffer.writeShort(var2);
                  var10.packetBuffer.writeShort(var3);
                  Client.packetWriter.__q_167(var10);
               }

               if(var0 == 2) {
                  var10 = Interpreter.method1915(ClientPacket.__gs_b, Client.packetWriter.isaacCipher);
                  var10.packetBuffer.writeInt(var1);
                  var10.packetBuffer.writeShort(var2);
                  var10.packetBuffer.writeShort(var3);
                  Client.packetWriter.__q_167(var10);
               }

               if(var0 == 3) {
                  var10 = Interpreter.method1915(ClientPacket.__gs_aa, Client.packetWriter.isaacCipher);
                  var10.packetBuffer.writeInt(var1);
                  var10.packetBuffer.writeShort(var2);
                  var10.packetBuffer.writeShort(var3);
                  Client.packetWriter.__q_167(var10);
               }

               if(var0 == 4) {
                  var10 = Interpreter.method1915(ClientPacket.__gs_y, Client.packetWriter.isaacCipher);
                  var10.packetBuffer.writeInt(var1);
                  var10.packetBuffer.writeShort(var2);
                  var10.packetBuffer.writeShort(var3);
                  Client.packetWriter.__q_167(var10);
               }

               if(var0 == 5) {
                  var10 = Interpreter.method1915(ClientPacket.__gs_ad, Client.packetWriter.isaacCipher);
                  var10.packetBuffer.writeInt(var1);
                  var10.packetBuffer.writeShort(var2);
                  var10.packetBuffer.writeShort(var3);
                  Client.packetWriter.__q_167(var10);
               }

               if(var0 == 6) {
                  var10 = Interpreter.method1915(ClientPacket.__gs_br, Client.packetWriter.isaacCipher);
                  var10.packetBuffer.writeInt(var1);
                  var10.packetBuffer.writeShort(var2);
                  var10.packetBuffer.writeShort(var3);
                  Client.packetWriter.__q_167(var10);
               }

               if(var0 == 7) {
                  var10 = Interpreter.method1915(ClientPacket.__gs_cu, Client.packetWriter.isaacCipher);
                  var10.packetBuffer.writeInt(var1);
                  var10.packetBuffer.writeShort(var2);
                  var10.packetBuffer.writeShort(var3);
                  Client.packetWriter.__q_167(var10);
               }

               if(var0 == 8) {
                  var10 = Interpreter.method1915(ClientPacket.__gs_a, Client.packetWriter.isaacCipher);
                  var10.packetBuffer.writeInt(var1);
                  var10.packetBuffer.writeShort(var2);
                  var10.packetBuffer.writeShort(var3);
                  Client.packetWriter.__q_167(var10);
               }

               if(var0 == 9) {
                  var10 = Interpreter.method1915(ClientPacket.__gs_cj, Client.packetWriter.isaacCipher);
                  var10.packetBuffer.writeInt(var1);
                  var10.packetBuffer.writeShort(var2);
                  var10.packetBuffer.writeShort(var3);
                  Client.packetWriter.__q_167(var10);
               }

               if(var0 == 10) {
                  var10 = Interpreter.method1915(ClientPacket.__gs_m, Client.packetWriter.isaacCipher);
                  var10.packetBuffer.writeInt(var1);
                  var10.packetBuffer.writeShort(var2);
                  var10.packetBuffer.writeShort(var3);
                  Client.packetWriter.__q_167(var10);
               }

            }
         }
      }
   }
}
