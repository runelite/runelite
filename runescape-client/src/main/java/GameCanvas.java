import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
@Implements("GameCanvas")
public final class GameCanvas extends Canvas {
   @ObfuscatedName("w")
   @Export("component")
   Component component;

   GameCanvas(Component var1) {
      this.component = var1;
   }

   public final void update(Graphics var1) {
      this.component.update(var1);
   }

   public final void paint(Graphics var1) {
      this.component.paint(var1);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "2000852642"
   )
   @Export("loadWidget")
   public static boolean loadWidget(int var0) {
      if(Item.validInterfaces[var0]) {
         return true;
      } else if(!Frames.widgetIndex.containsFile(var0)) {
         return false;
      } else {
         int var1 = Frames.widgetIndex.fileCount(var0);
         if(var1 == 0) {
            Item.validInterfaces[var0] = true;
            return true;
         } else {
            if(Widget.widgets[var0] == null) {
               Widget.widgets[var0] = new Widget[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(Widget.widgets[var0][var2] == null) {
                  byte[] var3 = Frames.widgetIndex.getConfigData(var0, var2);
                  if(var3 != null) {
                     Widget.widgets[var0][var2] = new Widget();
                     Widget.widgets[var0][var2].id = var2 + (var0 << 16);
                     if(var3[0] == -1) {
                        Widget.widgets[var0][var2].decodeActive(new Buffer(var3));
                     } else {
                        Widget.widgets[var0][var2].decode(new Buffer(var3));
                     }
                  }
               }
            }

            Item.validInterfaces[var0] = true;
            return true;
         }
      }
   }

   @ObfuscatedName("fh")
   @ObfuscatedSignature(
      signature = "(Lic;Ljava/lang/String;B)V",
      garbageValue = "65"
   )
   static void method775(IndexData var0, String var1) {
      class52 var2 = new class52(var0, var1);
      Client.field786.add(var2);
   }

   @ObfuscatedName("ff")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2010402622"
   )
   @Export("load")
   static void load() {
      int var0;
      if(Client.loadingStage == 0) {
         ScriptEvent.region = new Region(4, 104, 104, class50.tileHeights);

         for(var0 = 0; var0 < 4; ++var0) {
            Client.collisionMaps[var0] = new CollisionData(104, 104);
         }

         class283.minimapSprite = new SpritePixels(512, 512);
         class78.loadingText = "Starting game engine...";
         class78.loadingBarPercentage = 5;
         Client.loadingStage = 20;
      } else {
         int var1;
         int var2;
         int var3;
         int var4;
         if(Client.loadingStage == 20) {
            int[] var30 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var2 = var1 * 32 + 15 + 128;
               var3 = var2 * 3 + 600;
               var4 = Graphics3D.SINE[var2];
               var30[var1] = var3 * var4 >> 16;
            }

            Region.buildVisibilityMaps(var30, 500, 800, 512, 334);
            class78.loadingText = "Prepared visibility map";
            class78.loadingBarPercentage = 10;
            Client.loadingStage = 30;
         } else if(Client.loadingStage == 30) {
            FileSystem.indexInterfaces = class24.openCacheIndex(0, false, true, true);
            Client.indexSoundEffects = class24.openCacheIndex(1, false, true, true);
            class9.configsIndex = class24.openCacheIndex(2, true, false, true);
            WorldMapDecoration.indexCache3 = class24.openCacheIndex(3, false, true, true);
            FileOnDisk.indexCache4 = class24.openCacheIndex(4, false, true, true);
            class234.indexMaps = class24.openCacheIndex(5, true, true, true);
            MouseInput.indexTrack1 = class24.openCacheIndex(6, true, true, true);
            class216.indexModels = class24.openCacheIndex(7, false, true, true);
            class59.indexSprites = class24.openCacheIndex(8, false, true, true);
            class183.indexTextures = class24.openCacheIndex(9, false, true, true);
            MapLabel.indexCache10 = class24.openCacheIndex(10, false, true, true);
            WidgetNode.indexTrack2 = class24.openCacheIndex(11, false, true, true);
            TotalQuantityComparator.indexScripts = class24.openCacheIndex(12, false, true, true);
            TotalQuantityComparator.indexCache13 = class24.openCacheIndex(13, true, false, true);
            class10.vorbisIndex = class24.openCacheIndex(14, false, true, true);
            class6.indexCache15 = class24.openCacheIndex(15, false, true, true);
            MouseInput.indexWorldMap = class24.openCacheIndex(16, true, true, true);
            class78.loadingText = "Connecting to update server";
            class78.loadingBarPercentage = 20;
            Client.loadingStage = 40;
         } else if(Client.loadingStage == 40) {
            byte var26 = 0;
            var0 = var26 + FileSystem.indexInterfaces.percentage() * 4 / 100;
            var0 += Client.indexSoundEffects.percentage() * 4 / 100;
            var0 += class9.configsIndex.percentage() * 2 / 100;
            var0 += WorldMapDecoration.indexCache3.percentage() * 2 / 100;
            var0 += FileOnDisk.indexCache4.percentage() * 6 / 100;
            var0 += class234.indexMaps.percentage() * 4 / 100;
            var0 += MouseInput.indexTrack1.percentage() * 2 / 100;
            var0 += class216.indexModels.percentage() * 58 / 100;
            var0 += class59.indexSprites.percentage() * 2 / 100;
            var0 += class183.indexTextures.percentage() * 2 / 100;
            var0 += MapLabel.indexCache10.percentage() * 2 / 100;
            var0 += WidgetNode.indexTrack2.percentage() * 2 / 100;
            var0 += TotalQuantityComparator.indexScripts.percentage() * 2 / 100;
            var0 += TotalQuantityComparator.indexCache13.percentage() * 2 / 100;
            var0 += class10.vorbisIndex.percentage() * 2 / 100;
            var0 += class6.indexCache15.percentage() * 2 / 100;
            var0 += MouseInput.indexWorldMap.percentage() * 2 / 100;
            if(var0 != 100) {
               if(var0 != 0) {
                  class78.loadingText = "Checking for updates - " + var0 + "%";
               }

               class78.loadingBarPercentage = 30;
            } else {
               method775(FileSystem.indexInterfaces, "Animations");
               method775(Client.indexSoundEffects, "Skeletons");
               method775(FileOnDisk.indexCache4, "Sound FX");
               method775(class234.indexMaps, "Maps");
               method775(MouseInput.indexTrack1, "Music Tracks");
               method775(class216.indexModels, "Models");
               method775(class59.indexSprites, "Sprites");
               method775(WidgetNode.indexTrack2, "Music Jingles");
               method775(class10.vorbisIndex, "Music Samples");
               method775(class6.indexCache15, "Music Patches");
               method775(MouseInput.indexWorldMap, "World Map");
               class78.loadingText = "Loaded update list";
               class78.loadingBarPercentage = 30;
               Client.loadingStage = 45;
            }
         } else {
            IndexData var21;
            IndexData var22;
            IndexData var23;
            if(Client.loadingStage == 45) {
               class184.method3828(22050, !Client.lowMemory, 2);
               class218 var29 = new class218();
               var29.method4235(9, 128);
               GrandExchangeEvent.soundSystem0 = class183.method3818(GameEngine.taskManager, 0, 22050);
               GrandExchangeEvent.soundSystem0.method2226(var29);
               var21 = class6.indexCache15;
               var22 = class10.vorbisIndex;
               var23 = FileOnDisk.indexCache4;
               class217.field2484 = var21;
               class217.field2482 = var22;
               class217.field2490 = var23;
               class217.field2485 = var29;
               class191.soundSystem1 = class183.method3818(GameEngine.taskManager, 1, 2048);
               class141.field1906 = new class88();
               class191.soundSystem1.method2226(class141.field1906);
               FileSystem.field3166 = new Resampler(22050, AbstractSoundSystem.sampleRate);
               class78.loadingText = "Prepared sound engine";
               class78.loadingBarPercentage = 35;
               Client.loadingStage = 50;
               CollisionData.fonts = new Fonts(class59.indexSprites, TotalQuantityComparator.indexCache13);
            } else if(Client.loadingStage == 50) {
               FontName[] var28 = new FontName[]{FontName.FontName_plain12, FontName.field3682, FontName.FontName_plain11, FontName.FontName_bold12, FontName.field3683, FontName.field3684};
               var1 = var28.length;
               Fonts var31 = CollisionData.fonts;
               FontName[] var32 = new FontName[]{FontName.FontName_plain12, FontName.field3682, FontName.FontName_plain11, FontName.FontName_bold12, FontName.field3683, FontName.field3684};
               Client.fontsMap = var31.createMap(var32);
               if(Client.fontsMap.size() < var1) {
                  class78.loadingText = "Loading fonts - " + Client.fontsMap.size() * 100 / var1 + "%";
                  class78.loadingBarPercentage = 40;
               } else {
                  LoginPacket.fontPlain11 = (Font)Client.fontsMap.get(FontName.FontName_plain11);
                  ScriptEvent.font_p12full = (Font)Client.fontsMap.get(FontName.FontName_plain12);
                  WidgetNode.fontBold12 = (Font)Client.fontsMap.get(FontName.FontName_bold12);
                  AttackOption.platformInfo = new MachineInfo(true);
                  class78.loadingText = "Loaded fonts";
                  class78.loadingBarPercentage = 40;
                  Client.loadingStage = 60;
               }
            } else if(Client.loadingStage == 60) {
               var21 = MapLabel.indexCache10;
               var22 = class59.indexSprites;
               var3 = 0;
               if(var21.tryLoadRecordByNames("title.jpg", "")) {
                  ++var3;
               }

               if(var22.tryLoadRecordByNames("logo", "")) {
                  ++var3;
               }

               if(var22.tryLoadRecordByNames("logo_deadman_mode", "")) {
                  ++var3;
               }

               if(var22.tryLoadRecordByNames("titlebox", "")) {
                  ++var3;
               }

               if(var22.tryLoadRecordByNames("titlebutton", "")) {
                  ++var3;
               }

               if(var22.tryLoadRecordByNames("runes", "")) {
                  ++var3;
               }

               if(var22.tryLoadRecordByNames("title_mute", "")) {
                  ++var3;
               }

               if(var22.tryLoadRecordByNames("options_radio_buttons,0", "")) {
                  ++var3;
               }

               if(var22.tryLoadRecordByNames("options_radio_buttons,2", "")) {
                  ++var3;
               }

               if(var22.tryLoadRecordByNames("options_radio_buttons,4", "")) {
                  ++var3;
               }

               if(var22.tryLoadRecordByNames("options_radio_buttons,6", "")) {
                  ++var3;
               }

               var22.tryLoadRecordByNames("sl_back", "");
               var22.tryLoadRecordByNames("sl_flags", "");
               var22.tryLoadRecordByNames("sl_arrows", "");
               var22.tryLoadRecordByNames("sl_stars", "");
               var22.tryLoadRecordByNames("sl_button", "");
               byte var25 = 11;
               if(var3 < var25) {
                  class78.loadingText = "Loading title screen - " + var3 * 100 / var25 + "%";
                  class78.loadingBarPercentage = 50;
               } else {
                  class78.loadingText = "Loaded title screen";
                  class78.loadingBarPercentage = 50;
                  Resampler.setGameState(5);
                  Client.loadingStage = 70;
               }
            } else if(Client.loadingStage == 70) {
               if(!class9.configsIndex.method4631()) {
                  class78.loadingText = "Loading config - " + class9.configsIndex.loadPercent() + "%";
                  class78.loadingBarPercentage = 60;
               } else {
                  IndexData var27 = class9.configsIndex;
                  Overlay.overlay_ref = var27;
                  VarCString.method4860(class9.configsIndex);
                  class83.method1986(class9.configsIndex, class216.indexModels);
                  KitDefinition.method4924(class9.configsIndex, class216.indexModels, Client.lowMemory);
                  var21 = class9.configsIndex;
                  var22 = class216.indexModels;
                  NPCComposition.NpcDefinition_indexCache = var21;
                  NPCComposition.NpcDefinition_modelIndexCache = var22;
                  ClassInfo.method5752(class9.configsIndex);
                  var23 = class9.configsIndex;
                  IndexData var24 = class216.indexModels;
                  boolean var5 = Client.isMembers;
                  Font var6 = LoginPacket.fontPlain11;
                  ItemComposition.item_ref = var23;
                  VarCInt.ItemDefinition_modelIndexCache = var24;
                  GrandExchangeOffer.isMembersWorld = var5;
                  class49.field443 = ItemComposition.item_ref.fileCount(10);
                  GameSocket.field2036 = var6;
                  IndexData var7 = class9.configsIndex;
                  IndexData var8 = FileSystem.indexInterfaces;
                  IndexData var9 = Client.indexSoundEffects;
                  Sequence.seq_ref = var7;
                  Sequence.skel_ref = var8;
                  Sequence.skin_ref = var9;
                  Client.method1576(class9.configsIndex, class216.indexModels);
                  Script.method2002(class9.configsIndex);
                  IndexData var10 = class9.configsIndex;
                  VarPlayerType.varplayer_ref = var10;
                  VarPlayerType.field3251 = VarPlayerType.varplayer_ref.fileCount(16);
                  class157.method3310(WorldMapDecoration.indexCache3, class216.indexModels, class59.indexSprites, TotalQuantityComparator.indexCache13);
                  IndexData var11 = class9.configsIndex;
                  InvType.field3247 = var11;
                  Size.method124(class9.configsIndex);
                  IndexData var12 = class9.configsIndex;
                  VarCInt.field3278 = var12;
                  IndexData var13 = class9.configsIndex;
                  VarCString.field3283 = var13;
                  VarCInt.method4852(class9.configsIndex);
                  Permission.varcs = new Varcs();
                  class81.method1923(class9.configsIndex, class59.indexSprites, TotalQuantityComparator.indexCache13);
                  IndexData var14 = class9.configsIndex;
                  IndexData var15 = class59.indexSprites;
                  CombatInfo2.field3329 = var14;
                  CombatInfo2.field3322 = var15;
                  IndexData var16 = class9.configsIndex;
                  IndexData var17 = class59.indexSprites;
                  Area.field3256 = var17;
                  if(var16.method4631()) {
                     Area.field3257 = var16.fileCount(35);
                     Area.mapAreaType = new Area[Area.field3257];

                     for(int var18 = 0; var18 < Area.field3257; ++var18) {
                        byte[] var19 = var16.getConfigData(35, var18);
                        if(var19 != null) {
                           Area.mapAreaType[var18] = new Area(var18);
                           Area.mapAreaType[var18].method4826(new Buffer(var19));
                           Area.mapAreaType[var18].method4827();
                        }
                     }
                  }

                  class78.loadingText = "Loaded config";
                  class78.loadingBarPercentage = 60;
                  Client.loadingStage = 80;
               }
            } else if(Client.loadingStage == 80) {
               var0 = 0;
               if(class35.compass == null) {
                  class35.compass = class276.method5251(class59.indexSprites, "compass", "");
               } else {
                  ++var0;
               }

               if(Renderable.mapedge == null) {
                  Renderable.mapedge = class276.method5251(class59.indexSprites, "mapedge", "");
               } else {
                  ++var0;
               }

               if(WorldComparator.mapscene == null) {
                  WorldComparator.mapscene = class278.getIndexedSprites(class59.indexSprites, "mapscene", "");
               } else {
                  ++var0;
               }

               if(Actor.headIconsPk == null) {
                  Actor.headIconsPk = MapIconReference.getSprites(class59.indexSprites, "headicons_pk", "");
               } else {
                  ++var0;
               }

               if(KeyFocusListener.headIconsPrayer == null) {
                  KeyFocusListener.headIconsPrayer = MapIconReference.getSprites(class59.indexSprites, "headicons_prayer", "");
               } else {
                  ++var0;
               }

               if(class262.headIconsHint == null) {
                  class262.headIconsHint = MapIconReference.getSprites(class59.indexSprites, "headicons_hint", "");
               } else {
                  ++var0;
               }

               if(class217.mapMarkers == null) {
                  class217.mapMarkers = MapIconReference.getSprites(class59.indexSprites, "mapmarker", "");
               } else {
                  ++var0;
               }

               if(FileOnDisk.crossSprites == null) {
                  FileOnDisk.crossSprites = MapIconReference.getSprites(class59.indexSprites, "cross", "");
               } else {
                  ++var0;
               }

               if(class81.mapDots == null) {
                  class81.mapDots = MapIconReference.getSprites(class59.indexSprites, "mapdots", "");
               } else {
                  ++var0;
               }

               if(CombatInfoListHolder.scrollbarSprites == null) {
                  CombatInfoListHolder.scrollbarSprites = class278.getIndexedSprites(class59.indexSprites, "scrollbar", "");
               } else {
                  ++var0;
               }

               if(class78.modIconSprites == null) {
                  class78.modIconSprites = class278.getIndexedSprites(class59.indexSprites, "mod_icons", "");
               } else {
                  ++var0;
               }

               if(var0 < 11) {
                  class78.loadingText = "Loading sprites - " + var0 * 100 / 12 + "%";
                  class78.loadingBarPercentage = 70;
               } else {
                  FontTypeFace.modIcons = class78.modIconSprites;
                  Renderable.mapedge.method5958();
                  var1 = (int)(Math.random() * 21.0D) - 10;
                  var2 = (int)(Math.random() * 21.0D) - 10;
                  var3 = (int)(Math.random() * 21.0D) - 10;
                  var4 = (int)(Math.random() * 41.0D) - 20;
                  WorldComparator.mapscene[0].method5864(var1 + var4, var2 + var4, var3 + var4);
                  class78.loadingText = "Loaded sprites";
                  class78.loadingBarPercentage = 70;
                  Client.loadingStage = 90;
               }
            } else if(Client.loadingStage == 90) {
               if(!class183.indexTextures.method4631()) {
                  class78.loadingText = "Loading textures - " + "0%";
                  class78.loadingBarPercentage = 90;
               } else {
                  class10.field72 = new TextureProvider(class183.indexTextures, class59.indexSprites, 20, 0.8D, Client.lowMemory?64:128);
                  Graphics3D.method2890(class10.field72);
                  Graphics3D.setBrightness(0.8D);
                  Client.loadingStage = 100;
               }
            } else if(Client.loadingStage == 100) {
               var0 = class10.field72.method2616();
               if(var0 < 100) {
                  class78.loadingText = "Loading textures - " + var0 + "%";
                  class78.loadingBarPercentage = 90;
               } else {
                  class78.loadingText = "Loaded textures";
                  class78.loadingBarPercentage = 90;
                  Client.loadingStage = 110;
               }
            } else if(Client.loadingStage == 110) {
               VarCString.mouseRecorder = new MouseRecorder();
               GameEngine.taskManager.createRunnable(VarCString.mouseRecorder, 10);
               class78.loadingText = "Loaded input handler";
               class78.loadingBarPercentage = 92;
               Client.loadingStage = 120;
            } else if(Client.loadingStage == 120) {
               if(!MapLabel.indexCache10.tryLoadRecordByNames("huffman", "")) {
                  class78.loadingText = "Loading wordpack - " + 0 + "%";
                  class78.loadingBarPercentage = 94;
               } else {
                  Huffman var20 = new Huffman(MapLabel.indexCache10.takeRecordByNames("huffman", ""));
                  class300.huffman = var20;
                  class78.loadingText = "Loaded wordpack";
                  class78.loadingBarPercentage = 94;
                  Client.loadingStage = 130;
               }
            } else if(Client.loadingStage == 130) {
               if(!WorldMapDecoration.indexCache3.method4631()) {
                  class78.loadingText = "Loading interfaces - " + WorldMapDecoration.indexCache3.loadPercent() * 4 / 5 + "%";
                  class78.loadingBarPercentage = 96;
               } else if(!TotalQuantityComparator.indexScripts.method4631()) {
                  class78.loadingText = "Loading interfaces - " + (80 + TotalQuantityComparator.indexScripts.loadPercent() / 6) + "%";
                  class78.loadingBarPercentage = 96;
               } else if(!TotalQuantityComparator.indexCache13.method4631()) {
                  class78.loadingText = "Loading interfaces - " + (96 + TotalQuantityComparator.indexCache13.loadPercent() / 50) + "%";
                  class78.loadingBarPercentage = 96;
               } else {
                  class78.loadingText = "Loaded interfaces";
                  class78.loadingBarPercentage = 98;
                  Client.loadingStage = 140;
               }
            } else if(Client.loadingStage == 140) {
               class78.loadingBarPercentage = 100;
               if(!MouseInput.indexWorldMap.tryLoadArchiveByName(MapCacheArchiveNames.DETAILS.name)) {
                  class78.loadingText = "Loading world map - " + MouseInput.indexWorldMap.archiveLoadPercentByName(MapCacheArchiveNames.DETAILS.name) / 10 + "%";
               } else {
                  if(Preferences.renderOverview == null) {
                     Preferences.renderOverview = new RenderOverview();
                     Preferences.renderOverview.method6047(MouseInput.indexWorldMap, WidgetNode.fontBold12, Client.fontsMap, WorldComparator.mapscene);
                  }

                  var0 = Preferences.renderOverview.method6048();
                  if(var0 < 100) {
                     class78.loadingText = "Loading world map - " + (var0 * 9 / 10 + 10) + "%";
                  } else {
                     class78.loadingText = "Loaded world map";
                     Client.loadingStage = 150;
                  }
               }
            } else if(Client.loadingStage == 150) {
               Resampler.setGameState(10);
            }
         }
      }
   }

   @ObfuscatedName("fv")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "62"
   )
   static final void method774() {
      for(int var0 = 0; var0 < Client.queuedSoundEffectCount; ++var0) {
         --Client.unknownSoundValues2[var0];
         if(Client.unknownSoundValues2[var0] >= -10) {
            SoundEffect var9 = Client.audioEffects[var0];
            if(var9 == null) {
               Object var10000 = null;
               var9 = SoundEffect.getTrack(FileOnDisk.indexCache4, Client.queuedSoundEffectIDs[var0], 0);
               if(var9 == null) {
                  continue;
               }

               Client.unknownSoundValues2[var0] += var9.calculateDelay();
               Client.audioEffects[var0] = var9;
            }

            if(Client.unknownSoundValues2[var0] < 0) {
               int var2;
               if(Client.soundLocations[var0] != 0) {
                  int var3 = (Client.soundLocations[var0] & 255) * 128;
                  int var4 = Client.soundLocations[var0] >> 16 & 255;
                  int var5 = var4 * 128 + 64 - MilliTimer.localPlayer.x;
                  if(var5 < 0) {
                     var5 = -var5;
                  }

                  int var6 = Client.soundLocations[var0] >> 8 & 255;
                  int var7 = var6 * 128 + 64 - MilliTimer.localPlayer.y;
                  if(var7 < 0) {
                     var7 = -var7;
                  }

                  int var8 = var5 + var7 - 128;
                  if(var8 > var3) {
                     Client.unknownSoundValues2[var0] = -100;
                     continue;
                  }

                  if(var8 < 0) {
                     var8 = 0;
                  }

                  var2 = (var3 - var8) * Client.field827 / var3;
               } else {
                  var2 = Client.field768;
               }

               if(var2 > 0) {
                  RawAudioNode var10 = var9.method2110().applyResampler(FileSystem.field3166);
                  class103 var11 = class103.method2370(var10, 100, var2);
                  var11.method2318(Client.unknownSoundValues1[var0] - 1);
                  class141.field1906.method2049(var11);
               }

               Client.unknownSoundValues2[var0] = -100;
            }
         } else {
            --Client.queuedSoundEffectCount;

            for(int var1 = var0; var1 < Client.queuedSoundEffectCount; ++var1) {
               Client.queuedSoundEffectIDs[var1] = Client.queuedSoundEffectIDs[var1 + 1];
               Client.audioEffects[var1] = Client.audioEffects[var1 + 1];
               Client.unknownSoundValues1[var1] = Client.unknownSoundValues1[var1 + 1];
               Client.unknownSoundValues2[var1] = Client.unknownSoundValues2[var1 + 1];
               Client.soundLocations[var1] = Client.soundLocations[var1 + 1];
            }

            --var0;
         }
      }

      if(Client.field825 && !class158.method3314()) {
         if(Client.field693 != 0 && Client.field824 != -1) {
            class179.method3537(MouseInput.indexTrack1, Client.field824, 0, Client.field693, false);
         }

         Client.field825 = false;
      }

   }

   @ObfuscatedName("hr")
   @ObfuscatedSignature(
      signature = "(Lbu;IIBI)V",
      garbageValue = "2145269634"
   )
   static final void method783(Player var0, int var1, int var2, byte var3) {
      int var4 = var0.pathX[0];
      int var5 = var0.pathY[0];
      int var6 = var0.getSize();
      if(var4 >= var6 && var4 < 104 - var6 && var5 >= var6 && var5 < 104 - var6) {
         if(var1 >= var6 && var1 < 104 - var6 && var2 >= var6 && var2 < 104 - var6) {
            int var8 = var0.getSize();
            class166 var9 = ClientPacket.method3461(var1, var2);
            CollisionData var10 = Client.collisionMaps[var0.field581];
            int[] var11 = Client.field680;
            int[] var12 = Client.field864;

            int var13;
            int var14;
            for(var13 = 0; var13 < 128; ++var13) {
               for(var14 = 0; var14 < 128; ++var14) {
                  class165.field2059[var13][var14] = 0;
                  class165.field2058[var13][var14] = 99999999;
               }
            }

            int var15;
            int var16;
            byte var18;
            int var19;
            int var20;
            int var22;
            int var24;
            int var25;
            int var26;
            boolean var33;
            int var35;
            int var36;
            int var38;
            if(var8 == 1) {
               var15 = var4;
               var16 = var5;
               byte var17 = 64;
               var18 = 64;
               var19 = var4 - var17;
               var20 = var5 - var18;
               class165.field2059[var17][var18] = 99;
               class165.field2058[var17][var18] = 0;
               byte var21 = 0;
               var22 = 0;
               class165.field2061[var21] = var4;
               var38 = var21 + 1;
               class165.field2060[var21] = var5;
               int[][] var23 = var10.flags;

               boolean var34;
               while(true) {
                  if(var22 == var38) {
                     Bounds.field3748 = var15;
                     ScriptState.field463 = var16;
                     var34 = false;
                     break;
                  }

                  var15 = class165.field2061[var22];
                  var16 = class165.field2060[var22];
                  var22 = var22 + 1 & 4095;
                  var35 = var15 - var19;
                  var36 = var16 - var20;
                  var24 = var15 - var10.x;
                  var25 = var16 - var10.y;
                  if(var9.vmethod3457(1, var15, var16, var10)) {
                     Bounds.field3748 = var15;
                     ScriptState.field463 = var16;
                     var34 = true;
                     break;
                  }

                  var26 = class165.field2058[var35][var36] + 1;
                  if(var35 > 0 && class165.field2059[var35 - 1][var36] == 0 && (var23[var24 - 1][var25] & 19136776) == 0) {
                     class165.field2061[var38] = var15 - 1;
                     class165.field2060[var38] = var16;
                     var38 = var38 + 1 & 4095;
                     class165.field2059[var35 - 1][var36] = 2;
                     class165.field2058[var35 - 1][var36] = var26;
                  }

                  if(var35 < 127 && class165.field2059[var35 + 1][var36] == 0 && (var23[var24 + 1][var25] & 19136896) == 0) {
                     class165.field2061[var38] = var15 + 1;
                     class165.field2060[var38] = var16;
                     var38 = var38 + 1 & 4095;
                     class165.field2059[var35 + 1][var36] = 8;
                     class165.field2058[var35 + 1][var36] = var26;
                  }

                  if(var36 > 0 && class165.field2059[var35][var36 - 1] == 0 && (var23[var24][var25 - 1] & 19136770) == 0) {
                     class165.field2061[var38] = var15;
                     class165.field2060[var38] = var16 - 1;
                     var38 = var38 + 1 & 4095;
                     class165.field2059[var35][var36 - 1] = 1;
                     class165.field2058[var35][var36 - 1] = var26;
                  }

                  if(var36 < 127 && class165.field2059[var35][var36 + 1] == 0 && (var23[var24][var25 + 1] & 19136800) == 0) {
                     class165.field2061[var38] = var15;
                     class165.field2060[var38] = var16 + 1;
                     var38 = var38 + 1 & 4095;
                     class165.field2059[var35][var36 + 1] = 4;
                     class165.field2058[var35][var36 + 1] = var26;
                  }

                  if(var35 > 0 && var36 > 0 && class165.field2059[var35 - 1][var36 - 1] == 0 && (var23[var24 - 1][var25 - 1] & 19136782) == 0 && (var23[var24 - 1][var25] & 19136776) == 0 && (var23[var24][var25 - 1] & 19136770) == 0) {
                     class165.field2061[var38] = var15 - 1;
                     class165.field2060[var38] = var16 - 1;
                     var38 = var38 + 1 & 4095;
                     class165.field2059[var35 - 1][var36 - 1] = 3;
                     class165.field2058[var35 - 1][var36 - 1] = var26;
                  }

                  if(var35 < 127 && var36 > 0 && class165.field2059[var35 + 1][var36 - 1] == 0 && (var23[var24 + 1][var25 - 1] & 19136899) == 0 && (var23[var24 + 1][var25] & 19136896) == 0 && (var23[var24][var25 - 1] & 19136770) == 0) {
                     class165.field2061[var38] = var15 + 1;
                     class165.field2060[var38] = var16 - 1;
                     var38 = var38 + 1 & 4095;
                     class165.field2059[var35 + 1][var36 - 1] = 9;
                     class165.field2058[var35 + 1][var36 - 1] = var26;
                  }

                  if(var35 > 0 && var36 < 127 && class165.field2059[var35 - 1][var36 + 1] == 0 && (var23[var24 - 1][var25 + 1] & 19136824) == 0 && (var23[var24 - 1][var25] & 19136776) == 0 && (var23[var24][var25 + 1] & 19136800) == 0) {
                     class165.field2061[var38] = var15 - 1;
                     class165.field2060[var38] = var16 + 1;
                     var38 = var38 + 1 & 4095;
                     class165.field2059[var35 - 1][var36 + 1] = 6;
                     class165.field2058[var35 - 1][var36 + 1] = var26;
                  }

                  if(var35 < 127 && var36 < 127 && class165.field2059[var35 + 1][var36 + 1] == 0 && (var23[var24 + 1][var25 + 1] & 19136992) == 0 && (var23[var24 + 1][var25] & 19136896) == 0 && (var23[var24][var25 + 1] & 19136800) == 0) {
                     class165.field2061[var38] = var15 + 1;
                     class165.field2060[var38] = var16 + 1;
                     var38 = var38 + 1 & 4095;
                     class165.field2059[var35 + 1][var36 + 1] = 12;
                     class165.field2058[var35 + 1][var36 + 1] = var26;
                  }
               }

               var33 = var34;
            } else if(var8 == 2) {
               var33 = class50.method1059(var4, var5, var9, var10);
            } else {
               var33 = WorldMapType1.method219(var4, var5, var8, var9, var10);
            }

            int var7;
            label374: {
               var14 = var4 - 64;
               var15 = var5 - 64;
               var16 = Bounds.field3748;
               var35 = ScriptState.field463;
               if(!var33) {
                  var36 = Integer.MAX_VALUE;
                  var19 = Integer.MAX_VALUE;
                  byte var37 = 10;
                  var38 = var9.field2066;
                  var22 = var9.field2067;
                  int var32 = var9.field2070;
                  var24 = var9.field2069;

                  for(var25 = var38 - var37; var25 <= var38 + var37; ++var25) {
                     for(var26 = var22 - var37; var26 <= var22 + var37; ++var26) {
                        int var27 = var25 - var14;
                        int var28 = var26 - var15;
                        if(var27 >= 0 && var28 >= 0 && var27 < 128 && var28 < 128 && class165.field2058[var27][var28] < 100) {
                           int var29 = 0;
                           if(var25 < var38) {
                              var29 = var38 - var25;
                           } else if(var25 > var32 + var38 - 1) {
                              var29 = var25 - (var32 + var38 - 1);
                           }

                           int var30 = 0;
                           if(var26 < var22) {
                              var30 = var22 - var26;
                           } else if(var26 > var22 + var24 - 1) {
                              var30 = var26 - (var22 + var24 - 1);
                           }

                           int var31 = var30 * var30 + var29 * var29;
                           if(var31 < var36 || var31 == var36 && class165.field2058[var27][var28] < var19) {
                              var36 = var31;
                              var19 = class165.field2058[var27][var28];
                              var16 = var25;
                              var35 = var26;
                           }
                        }
                     }
                  }

                  if(var36 == Integer.MAX_VALUE) {
                     var7 = -1;
                     break label374;
                  }
               }

               if(var4 == var16 && var35 == var5) {
                  var7 = 0;
               } else {
                  var18 = 0;
                  class165.field2061[var18] = var16;
                  var36 = var18 + 1;
                  class165.field2060[var18] = var35;

                  for(var19 = var20 = class165.field2059[var16 - var14][var35 - var15]; var16 != var4 || var5 != var35; var19 = class165.field2059[var16 - var14][var35 - var15]) {
                     if(var20 != var19) {
                        var20 = var19;
                        class165.field2061[var36] = var16;
                        class165.field2060[var36++] = var35;
                     }

                     if((var19 & 2) != 0) {
                        ++var16;
                     } else if((var19 & 8) != 0) {
                        --var16;
                     }

                     if((var19 & 1) != 0) {
                        ++var35;
                     } else if((var19 & 4) != 0) {
                        --var35;
                     }
                  }

                  var38 = 0;

                  while(var36-- > 0) {
                     var11[var38] = class165.field2061[var36];
                     var12[var38++] = class165.field2060[var36];
                     if(var38 >= var11.length) {
                        break;
                     }
                  }

                  var7 = var38;
               }
            }

            var13 = var7;
            if(var7 >= 1) {
               for(var14 = 0; var14 < var13 - 1; ++var14) {
                  var0.method1164(Client.field680[var14], Client.field864[var14], var3);
               }

            }
         }
      }
   }
}
