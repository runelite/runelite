import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
public class class88 {
   @ObfuscatedName("t")
   static final BigInteger field1314;
   @ObfuscatedName("q")
   static final BigInteger field1315;

   static {
      field1314 = new BigInteger("10001", 16);
      field1315 = new BigInteger("8f4a98129626cc10be0802729ed056aa437f35f8e795f3ca1d97127d702b4c2f4a87ea418d036a6ad4279ca8c503f2f012bffde94b75335e2367510a82d059f1aabd30ab7035a750a0d4397d8bc08e74e209dfd0bf09d39fa05e09ec32503a782d76b04b89efddaa9d0b3baae61aeecf312be318f9124d0b8861e6d39eafb253", 16);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)Ljp;",
      garbageValue = "-147372270"
   )
   public static class278 method1916(int var0) {
      class278 var1 = (class278)class278.field3548.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class278.field3551.getConfigData(11, var0);
         var1 = new class278();
         if(var2 != null) {
            var1.method4904(new Buffer(var2));
         }

         var1.method4885();
         class278.field3548.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ILcj;ZI)I",
      garbageValue = "1234286592"
   )
   static int method1917(int var0, Script var1, boolean var2) {
      Widget var3 = GZipDecompressor.getWidget(class81.intStack[--class5.intStackSize]);
      if(var0 == 2500) {
         class81.intStack[++class5.intStackSize - 1] = var3.relativeX;
         return 1;
      } else if(var0 == 2501) {
         class81.intStack[++class5.intStackSize - 1] = var3.relativeY;
         return 1;
      } else if(var0 == 2502) {
         class81.intStack[++class5.intStackSize - 1] = var3.width;
         return 1;
      } else if(var0 == 2503) {
         class81.intStack[++class5.intStackSize - 1] = var3.height;
         return 1;
      } else if(var0 == 2504) {
         class81.intStack[++class5.intStackSize - 1] = var3.isHidden?1:0;
         return 1;
      } else if(var0 == 2505) {
         class81.intStack[++class5.intStackSize - 1] = var3.parentId;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("fg")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1530634020"
   )
   @Export("load")
   static void load() {
      int var0;
      if(Client.loadingStage == 0) {
         class38.region = new Region(4, 104, 104, class62.tileHeights);

         for(var0 = 0; var0 < 4; ++var0) {
            Client.collisionMaps[var0] = new CollisionData(104, 104);
         }

         GrandExchangeOffer.minimapSprite = new SpritePixels(512, 512);
         class90.loadingText = "Starting game engine...";
         class90.loadingBarPercentage = 5;
         Client.loadingStage = 20;
      } else {
         int var1;
         int var2;
         int var3;
         int var4;
         if(Client.loadingStage == 20) {
            int[] var35 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var2 = var1 * 32 + 15 + 128;
               var3 = var2 * 3 + 600;
               var4 = Graphics3D.SINE[var2];
               var35[var1] = var4 * var3 >> 16;
            }

            Region.buildVisibilityMaps(var35, 500, 800, 512, 334);
            class90.loadingText = "Prepared visibility map";
            class90.loadingBarPercentage = 10;
            Client.loadingStage = 30;
         } else if(Client.loadingStage == 30) {
            World.indexInterfaces = MapLabel.openCacheIndex(0, false, true, true);
            ContextMenuRow.indexSoundEffects = MapLabel.openCacheIndex(1, false, true, true);
            Client.configsIndex = MapLabel.openCacheIndex(2, true, false, true);
            class316.indexCache3 = MapLabel.openCacheIndex(3, false, true, true);
            WorldMapRectangle.indexCache4 = MapLabel.openCacheIndex(4, false, true, true);
            VertexNormal.indexMaps = MapLabel.openCacheIndex(5, true, true, true);
            Varbit.indexTrack1 = MapLabel.openCacheIndex(6, true, true, true);
            class236.indexModels = MapLabel.openCacheIndex(7, false, true, true);
            WorldMapRegion.indexSprites = MapLabel.openCacheIndex(8, false, true, true);
            class62.indexTextures = MapLabel.openCacheIndex(9, false, true, true);
            FileRequest.indexCache10 = MapLabel.openCacheIndex(10, false, true, true);
            class55.indexTrack2 = MapLabel.openCacheIndex(11, false, true, true);
            BoundingBox2D.indexScripts = MapLabel.openCacheIndex(12, false, true, true);
            Client.indexCache13 = MapLabel.openCacheIndex(13, true, false, true);
            FontName.vorbisIndex = MapLabel.openCacheIndex(14, false, true, true);
            class64.indexCache15 = MapLabel.openCacheIndex(15, false, true, true);
            class196.indexWorldMap = MapLabel.openCacheIndex(16, true, true, true);
            class90.loadingText = "Connecting to update server";
            class90.loadingBarPercentage = 20;
            Client.loadingStage = 40;
         } else if(Client.loadingStage == 40) {
            byte var33 = 0;
            var0 = var33 + World.indexInterfaces.percentage() * 4 / 100;
            var0 += ContextMenuRow.indexSoundEffects.percentage() * 4 / 100;
            var0 += Client.configsIndex.percentage() * 2 / 100;
            var0 += class316.indexCache3.percentage() * 2 / 100;
            var0 += WorldMapRectangle.indexCache4.percentage() * 6 / 100;
            var0 += VertexNormal.indexMaps.percentage() * 4 / 100;
            var0 += Varbit.indexTrack1.percentage() * 2 / 100;
            var0 += class236.indexModels.percentage() * 58 / 100;
            var0 += WorldMapRegion.indexSprites.percentage() * 2 / 100;
            var0 += class62.indexTextures.percentage() * 2 / 100;
            var0 += FileRequest.indexCache10.percentage() * 2 / 100;
            var0 += class55.indexTrack2.percentage() * 2 / 100;
            var0 += BoundingBox2D.indexScripts.percentage() * 2 / 100;
            var0 += Client.indexCache13.percentage() * 2 / 100;
            var0 += FontName.vorbisIndex.percentage() * 2 / 100;
            var0 += class64.indexCache15.percentage() * 2 / 100;
            var0 += class196.indexWorldMap.percentage() * 2 / 100;
            if(var0 != 100) {
               if(var0 != 0) {
                  class90.loadingText = "Checking for updates - " + var0 + "%";
               }

               class90.loadingBarPercentage = 30;
            } else {
               ScriptEvent.method1158(World.indexInterfaces, "Animations");
               ScriptEvent.method1158(ContextMenuRow.indexSoundEffects, "Skeletons");
               ScriptEvent.method1158(WorldMapRectangle.indexCache4, "Sound FX");
               ScriptEvent.method1158(VertexNormal.indexMaps, "Maps");
               ScriptEvent.method1158(Varbit.indexTrack1, "Music Tracks");
               ScriptEvent.method1158(class236.indexModels, "Models");
               ScriptEvent.method1158(WorldMapRegion.indexSprites, "Sprites");
               ScriptEvent.method1158(class55.indexTrack2, "Music Jingles");
               ScriptEvent.method1158(FontName.vorbisIndex, "Music Samples");
               ScriptEvent.method1158(class64.indexCache15, "Music Patches");
               ScriptEvent.method1158(class196.indexWorldMap, "World Map");
               class90.loadingText = "Loaded update list";
               class90.loadingBarPercentage = 30;
               Client.loadingStage = 45;
            }
         } else if(Client.loadingStage == 45) {
            boolean var32 = !Client.lowMemory;
            AbstractSoundSystem.sampleRate = 22050;
            AbstractSoundSystem.audioHighMemory = var32;
            class190.field2496 = 2;
            class230 var37 = new class230();
            var37.method4174(9, 128);
            WorldComparator.soundSystem0 = MapIcon.method590(GameEngine.taskManager, 0, 22050);
            WorldComparator.soundSystem0.method2209(var37);
            ItemLayer.method2590(class64.indexCache15, FontName.vorbisIndex, WorldMapRectangle.indexCache4, var37);
            class195.soundSystem1 = MapIcon.method590(GameEngine.taskManager, 1, 2048);
            FontName.field3884 = new class100();
            class195.soundSystem1.method2209(FontName.field3884);
            MapCacheArchiveNames.field523 = new Resampler(22050, AbstractSoundSystem.sampleRate);
            class90.loadingText = "Prepared sound engine";
            class90.loadingBarPercentage = 35;
            Client.loadingStage = 50;
            Client.fonts = new Fonts(WorldMapRegion.indexSprites, Client.indexCache13);
         } else if(Client.loadingStage == 50) {
            var0 = FontName.method5477().length;
            Client.fontsMap = Client.fonts.createMap(FontName.method5477());
            if(Client.fontsMap.size() < var0) {
               class90.loadingText = "Loading fonts - " + Client.fontsMap.size() * 100 / var0 + "%";
               class90.loadingBarPercentage = 40;
            } else {
               class178.fontPlain11 = (Font)Client.fontsMap.get(FontName.FontName_plain11);
               class178.font_p12full = (Font)Client.fontsMap.get(FontName.FontName_plain12);
               class5.fontBold12 = (Font)Client.fontsMap.get(FontName.FontName_bold12);
               BoundingBox3DDrawMode.platformInfo = new MachineInfo(true);
               class90.loadingText = "Loaded fonts";
               class90.loadingBarPercentage = 40;
               Client.loadingStage = 60;
            }
         } else if(Client.loadingStage == 60) {
            var0 = ItemComposition.method5058(FileRequest.indexCache10, WorldMapRegion.indexSprites);
            byte var31 = 11;
            if(var0 < var31) {
               class90.loadingText = "Loading title screen - " + var0 * 100 / var31 + "%";
               class90.loadingBarPercentage = 50;
            } else {
               class90.loadingText = "Loaded title screen";
               class90.loadingBarPercentage = 50;
               class20.setGameState(5);
               Client.loadingStage = 70;
            }
         } else {
            IndexData var28;
            if(Client.loadingStage == 70) {
               if(!Client.configsIndex.method4569()) {
                  class90.loadingText = "Loading config - " + Client.configsIndex.loadPercent() + "%";
                  class90.loadingBarPercentage = 60;
               } else {
                  class251.method4540(Client.configsIndex);
                  IndexData var34 = Client.configsIndex;
                  FloorUnderlayDefinition.underlay_ref = var34;
                  IndexData var36 = Client.configsIndex;
                  var28 = class236.indexModels;
                  class241.identKit_ref = var36;
                  KitDefinition.field3519 = var28;
                  KitDefinition.field3513 = class241.identKit_ref.fileCount(3);
                  AbstractSoundSystem.method2217(Client.configsIndex, class236.indexModels, Client.lowMemory);
                  class281.method4954(Client.configsIndex, class236.indexModels);
                  class313.method5581(Client.configsIndex);
                  IndexData var29 = Client.configsIndex;
                  IndexData var30 = class236.indexModels;
                  boolean var5 = Client.isMembers;
                  Font var6 = class178.fontPlain11;
                  ItemComposition.item_ref = var29;
                  ItemComposition.ItemDefinition_modelIndexCache = var30;
                  UnitPriceComparator.isMembersWorld = var5;
                  GrandExchangeOffer.field284 = ItemComposition.item_ref.fileCount(10);
                  Resampler.field1590 = var6;
                  IndexData var7 = Client.configsIndex;
                  IndexData var8 = World.indexInterfaces;
                  IndexData var9 = ContextMenuRow.indexSoundEffects;
                  class2.seq_ref = var7;
                  Sequence.skel_ref = var8;
                  Sequence.skin_ref = var9;
                  IndexData var10 = Client.configsIndex;
                  IndexData var11 = class236.indexModels;
                  Spotanim.SpotAnimationDefinition_indexCache = var10;
                  Spotanim.SpotAnimationDefinition_modelIndexCache = var11;
                  IndexData var12 = Client.configsIndex;
                  Varbit.varbit_ref = var12;
                  class33.method379(Client.configsIndex);
                  IndexData var13 = class316.indexCache3;
                  IndexData var14 = class236.indexModels;
                  IndexData var15 = WorldMapRegion.indexSprites;
                  IndexData var16 = Client.indexCache13;
                  Widget.widgetIndex = var13;
                  Nameable.field3824 = var14;
                  Varcs.field1417 = var15;
                  SoundTaskDataProvider.field618 = var16;
                  Widget.widgets = new Widget[Widget.widgetIndex.size()][];
                  WorldComparator.validInterfaces = new boolean[Widget.widgetIndex.size()];
                  class199.method3797(Client.configsIndex);
                  PendingSpawn.method1647(Client.configsIndex);
                  IndexData var17 = Client.configsIndex;
                  class270.field3480 = var17;
                  class47.method756(Client.configsIndex);
                  IndexData var18 = Client.configsIndex;
                  class278.field3551 = var18;
                  BoundingBox.chatMessages = new Varcs();
                  IndexData var19 = Client.configsIndex;
                  IndexData var20 = WorldMapRegion.indexSprites;
                  IndexData var21 = Client.indexCache13;
                  class281.field3585 = var19;
                  class281.field3571 = var20;
                  class281.field3572 = var21;
                  class255.method4546(Client.configsIndex, WorldMapRegion.indexSprites);
                  IndexData var22 = Client.configsIndex;
                  IndexData var23 = WorldMapRegion.indexSprites;
                  Area.field3466 = var23;
                  if(var22.method4569()) {
                     Area.field3455 = var22.fileCount(35);
                     Area.mapAreaType = new Area[Area.field3455];

                     for(int var24 = 0; var24 < Area.field3455; ++var24) {
                        byte[] var25 = var22.getConfigData(35, var24);
                        if(var25 != null) {
                           Area.mapAreaType[var24] = new Area(var24);
                           Area.mapAreaType[var24].method4768(new Buffer(var25));
                           Area.mapAreaType[var24].method4782();
                        }
                     }
                  }

                  class90.loadingText = "Loaded config";
                  class90.loadingBarPercentage = 60;
                  Client.loadingStage = 80;
               }
            } else if(Client.loadingStage == 80) {
               var0 = 0;
               SpritePixels var27;
               if(class23.compass == null) {
                  var28 = WorldMapRegion.indexSprites;
                  var3 = var28.getFile("compass");
                  var4 = var28.getChild(var3, "");
                  var27 = class1.method1(var28, var3, var4);
                  class23.compass = var27;
               } else {
                  ++var0;
               }

               if(class45.mapedge == null) {
                  var28 = WorldMapRegion.indexSprites;
                  var3 = var28.getFile("mapedge");
                  var4 = var28.getChild(var3, "");
                  var27 = class1.method1(var28, var3, var4);
                  class45.mapedge = var27;
               } else {
                  ++var0;
               }

               if(class318.mapscene == null) {
                  class318.mapscene = WorldMapData.getIndexedSprites(WorldMapRegion.indexSprites, "mapscene", "");
               } else {
                  ++var0;
               }

               if(class64.headIconsPk == null) {
                  class64.headIconsPk = CombatInfo2.getSprites(WorldMapRegion.indexSprites, "headicons_pk", "");
               } else {
                  ++var0;
               }

               if(BoundingBox3D.headIconsPrayer == null) {
                  BoundingBox3D.headIconsPrayer = CombatInfo2.getSprites(WorldMapRegion.indexSprites, "headicons_prayer", "");
               } else {
                  ++var0;
               }

               if(class234.headIconsHint == null) {
                  class234.headIconsHint = CombatInfo2.getSprites(WorldMapRegion.indexSprites, "headicons_hint", "");
               } else {
                  ++var0;
               }

               if(class62.mapMarkers == null) {
                  class62.mapMarkers = CombatInfo2.getSprites(WorldMapRegion.indexSprites, "mapmarker", "");
               } else {
                  ++var0;
               }

               if(class21.crossSprites == null) {
                  class21.crossSprites = CombatInfo2.getSprites(WorldMapRegion.indexSprites, "cross", "");
               } else {
                  ++var0;
               }

               if(Tile.mapDots == null) {
                  Tile.mapDots = CombatInfo2.getSprites(WorldMapRegion.indexSprites, "mapdots", "");
               } else {
                  ++var0;
               }

               if(class38.scrollbarSprites == null) {
                  class38.scrollbarSprites = WorldMapData.getIndexedSprites(WorldMapRegion.indexSprites, "scrollbar", "");
               } else {
                  ++var0;
               }

               if(class158.modIconSprites == null) {
                  class158.modIconSprites = WorldMapData.getIndexedSprites(WorldMapRegion.indexSprites, "mod_icons", "");
               } else {
                  ++var0;
               }

               if(var0 < 11) {
                  class90.loadingText = "Loading sprites - " + var0 * 100 / 12 + "%";
                  class90.loadingBarPercentage = 70;
               } else {
                  FontTypeFace.modIcons = class158.modIconSprites;
                  class45.mapedge.method5924();
                  var1 = (int)(Math.random() * 21.0D) - 10;
                  var2 = (int)(Math.random() * 21.0D) - 10;
                  var3 = (int)(Math.random() * 21.0D) - 10;
                  var4 = (int)(Math.random() * 41.0D) - 20;
                  class318.mapscene[0].method5824(var1 + var4, var2 + var4, var4 + var3);
                  class90.loadingText = "Loaded sprites";
                  class90.loadingBarPercentage = 70;
                  Client.loadingStage = 90;
               }
            } else if(Client.loadingStage == 90) {
               if(!class62.indexTextures.method4569()) {
                  class90.loadingText = "Loading textures - " + "0%";
                  class90.loadingBarPercentage = 90;
               } else {
                  Size.field336 = new TextureProvider(class62.indexTextures, WorldMapRegion.indexSprites, 20, 0.8D, Client.lowMemory?64:128);
                  Graphics3D.method2801(Size.field336);
                  Graphics3D.setBrightness(0.8D);
                  Client.loadingStage = 100;
               }
            } else if(Client.loadingStage == 100) {
               var0 = Size.field336.method2566();
               if(var0 < 100) {
                  class90.loadingText = "Loading textures - " + var0 + "%";
                  class90.loadingBarPercentage = 90;
               } else {
                  class90.loadingText = "Loaded textures";
                  class90.loadingBarPercentage = 90;
                  Client.loadingStage = 110;
               }
            } else if(Client.loadingStage == 110) {
               WidgetNode.mouseRecorder = new MouseRecorder();
               GameEngine.taskManager.createRunnable(WidgetNode.mouseRecorder, 10);
               class90.loadingText = "Loaded input handler";
               class90.loadingBarPercentage = 92;
               Client.loadingStage = 120;
            } else if(Client.loadingStage == 120) {
               if(!FileRequest.indexCache10.tryLoadRecordByNames("huffman", "")) {
                  class90.loadingText = "Loading wordpack - " + 0 + "%";
                  class90.loadingBarPercentage = 94;
               } else {
                  Huffman var26 = new Huffman(FileRequest.indexCache10.takeRecordByNames("huffman", ""));
                  class313.huffman = var26;
                  class90.loadingText = "Loaded wordpack";
                  class90.loadingBarPercentage = 94;
                  Client.loadingStage = 130;
               }
            } else if(Client.loadingStage == 130) {
               if(!class316.indexCache3.method4569()) {
                  class90.loadingText = "Loading interfaces - " + class316.indexCache3.loadPercent() * 4 / 5 + "%";
                  class90.loadingBarPercentage = 96;
               } else if(!BoundingBox2D.indexScripts.method4569()) {
                  class90.loadingText = "Loading interfaces - " + (80 + BoundingBox2D.indexScripts.loadPercent() / 6) + "%";
                  class90.loadingBarPercentage = 96;
               } else if(!Client.indexCache13.method4569()) {
                  class90.loadingText = "Loading interfaces - " + (96 + Client.indexCache13.loadPercent() / 50) + "%";
                  class90.loadingBarPercentage = 96;
               } else {
                  class90.loadingText = "Loaded interfaces";
                  class90.loadingBarPercentage = 98;
                  Client.loadingStage = 140;
               }
            } else if(Client.loadingStage == 140) {
               class90.loadingBarPercentage = 100;
               if(!class196.indexWorldMap.tryLoadArchiveByName(MapCacheArchiveNames.DETAILS.name)) {
                  class90.loadingText = "Loading world map - " + class196.indexWorldMap.archiveLoadPercentByName(MapCacheArchiveNames.DETAILS.name) / 10 + "%";
               } else {
                  if(class251.renderOverview == null) {
                     class251.renderOverview = new RenderOverview();
                     class251.renderOverview.method5988(class196.indexWorldMap, class5.fontBold12, Client.fontsMap, class318.mapscene);
                  }

                  var0 = class251.renderOverview.method6011();
                  if(var0 < 100) {
                     class90.loadingText = "Loading world map - " + (var0 * 9 / 10 + 10) + "%";
                  } else {
                     class90.loadingText = "Loaded world map";
                     Client.loadingStage = 150;
                  }
               }
            } else if(Client.loadingStage == 150) {
               class20.setGameState(10);
            }
         }
      }
   }
}
