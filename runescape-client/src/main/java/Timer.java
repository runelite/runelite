import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ff")
@Implements("Timer")
public abstract class Timer {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2072405029"
   )
   public abstract void vmethod3369();

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-2142133773"
   )
   public abstract int vmethod3370(int var1, int var2);

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Llt;B)I",
      garbageValue = "42"
   )
   public static final int method3376(JagexLoginType var0) {
      if(var0 == null) {
         return 12;
      } else {
         switch(var0.field4071) {
         case 3:
            return 20;
         default:
            return 12;
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Ljm;",
      garbageValue = "1194149954"
   )
   public static class278 method3375(int var0) {
      class278 var1 = (class278)class278.field3541.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class278.field3547.getConfigData(11, var0);
         var1 = new class278();
         if(var2 != null) {
            var1.method5035(new Buffer(var2));
         }

         var1.method5032();
         class278.field3541.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("ea")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-931652668"
   )
   @Export("load")
   static void load() {
      int var0;
      if(Client.loadingStage == 0) {
         class86.region = new Region(4, 104, 104, class62.tileHeights);

         for(var0 = 0; var0 < 4; ++var0) {
            Client.collisionMaps[var0] = new CollisionData(104, 104);
         }

         class25.minimapSprite = new SpritePixels(512, 512);
         class90.loadingText = "Starting game engine...";
         class90.loadingBarPercentage = 5;
         Client.loadingStage = 20;
      } else {
         int var1;
         int var2;
         int var3;
         int var4;
         if(Client.loadingStage != 20) {
            if(Client.loadingStage == 30) {
               class21.indexInterfaces = class316.openCacheIndex(0, false, true, true);
               class5.indexSoundEffects = class316.openCacheIndex(1, false, true, true);
               BoundingBox2D.configsIndex = class316.openCacheIndex(2, true, false, true);
               class195.indexCache3 = class316.openCacheIndex(3, false, true, true);
               class178.indexCache4 = class316.openCacheIndex(4, false, true, true);
               BuildType.indexMaps = class316.openCacheIndex(5, true, true, true);
               class154.indexTrack1 = class316.openCacheIndex(6, true, true, true);
               Client.indexModels = class316.openCacheIndex(7, false, true, true);
               Renderable.indexSprites = class316.openCacheIndex(8, false, true, true);
               class86.indexTextures = class316.openCacheIndex(9, false, true, true);
               GrandExchangeOffer.indexCache10 = class316.openCacheIndex(10, false, true, true);
               class66.indexTrack2 = class316.openCacheIndex(11, false, true, true);
               class1.indexScripts = class316.openCacheIndex(12, false, true, true);
               class20.indexCache13 = class316.openCacheIndex(13, true, false, true);
               class152.vorbisIndex = class316.openCacheIndex(14, false, true, true);
               class55.indexCache15 = class316.openCacheIndex(15, false, true, true);
               ServerPacket.indexWorldMap = class316.openCacheIndex(16, true, true, true);
               class90.loadingText = "Connecting to update server";
               class90.loadingBarPercentage = 20;
               Client.loadingStage = 40;
            } else if(Client.loadingStage == 40) {
               byte var32 = 0;
               var0 = var32 + class21.indexInterfaces.percentage() * 4 / 100;
               var0 += class5.indexSoundEffects.percentage() * 4 / 100;
               var0 += BoundingBox2D.configsIndex.percentage() * 2 / 100;
               var0 += class195.indexCache3.percentage() * 2 / 100;
               var0 += class178.indexCache4.percentage() * 6 / 100;
               var0 += BuildType.indexMaps.percentage() * 4 / 100;
               var0 += class154.indexTrack1.percentage() * 2 / 100;
               var0 += Client.indexModels.percentage() * 58 / 100;
               var0 += Renderable.indexSprites.percentage() * 2 / 100;
               var0 += class86.indexTextures.percentage() * 2 / 100;
               var0 += GrandExchangeOffer.indexCache10.percentage() * 2 / 100;
               var0 += class66.indexTrack2.percentage() * 2 / 100;
               var0 += class1.indexScripts.percentage() * 2 / 100;
               var0 += class20.indexCache13.percentage() * 2 / 100;
               var0 += class152.vorbisIndex.percentage() * 2 / 100;
               var0 += class55.indexCache15.percentage() * 2 / 100;
               var0 += ServerPacket.indexWorldMap.percentage() * 2 / 100;
               if(var0 != 100) {
                  if(var0 != 0) {
                     class90.loadingText = "Checking for updates - " + var0 + "%";
                  }

                  class90.loadingBarPercentage = 30;
               } else {
                  Signlink.method3303(class21.indexInterfaces, "Animations");
                  Signlink.method3303(class5.indexSoundEffects, "Skeletons");
                  Signlink.method3303(class178.indexCache4, "Sound FX");
                  Signlink.method3303(BuildType.indexMaps, "Maps");
                  Signlink.method3303(class154.indexTrack1, "Music Tracks");
                  Signlink.method3303(Client.indexModels, "Models");
                  Signlink.method3303(Renderable.indexSprites, "Sprites");
                  Signlink.method3303(class66.indexTrack2, "Music Jingles");
                  Signlink.method3303(class152.vorbisIndex, "Music Samples");
                  Signlink.method3303(class55.indexCache15, "Music Patches");
                  Signlink.method3303(ServerPacket.indexWorldMap, "World Map");
                  class90.loadingText = "Loaded update list";
                  class90.loadingBarPercentage = 30;
                  Client.loadingStage = 45;
               }
            } else {
               IndexData var26;
               IndexData var27;
               if(Client.loadingStage == 45) {
                  boolean var31 = !Client.lowMemory;
                  KeyFocusListener.sampleRate = 22050;
                  AbstractSoundSystem.audioHighMemory = var31;
                  GrandExchangeOffer.field309 = 2;
                  class230 var37 = new class230();
                  var37.method4261(9, 128);
                  class284.soundSystem0 = MapIcon.method556(GameEngine.taskManager, 0, 22050);
                  class284.soundSystem0.method2248(var37);
                  var26 = class55.indexCache15;
                  var27 = class152.vorbisIndex;
                  IndexData var28 = class178.indexCache4;
                  class229.field2688 = var26;
                  class229.field2693 = var27;
                  class229.field2689 = var28;
                  class229.field2690 = var37;
                  ChatLineBuffer.soundSystem1 = MapIcon.method556(GameEngine.taskManager, 1, 2048);
                  class29.field431 = new class100();
                  ChatLineBuffer.soundSystem1.method2248(class29.field431);
                  class57.field673 = new Resampler(22050, KeyFocusListener.sampleRate);
                  class90.loadingText = "Prepared sound engine";
                  class90.loadingBarPercentage = 35;
                  Client.loadingStage = 50;
                  class167.fonts = new Fonts(Renderable.indexSprites, class20.indexCache13);
               } else if(Client.loadingStage == 50) {
                  FontName[] var35 = new FontName[]{FontName.FontName_bold12, FontName.FontName_plain11, FontName.field3868, FontName.FontName_plain12, FontName.field3870, FontName.field3867};
                  var1 = var35.length;
                  Fonts var38 = class167.fonts;
                  FontName[] var39 = new FontName[]{FontName.FontName_bold12, FontName.FontName_plain11, FontName.field3868, FontName.FontName_plain12, FontName.field3870, FontName.field3867};
                  Client.fontsMap = var38.createMap(var39);
                  if(Client.fontsMap.size() < var1) {
                     class90.loadingText = "Loading fonts - " + Client.fontsMap.size() * 100 / var1 + "%";
                     class90.loadingBarPercentage = 40;
                  } else {
                     class41.fontPlain11 = (Font)Client.fontsMap.get(FontName.FontName_plain11);
                     SoundTaskDataProvider.font_p12full = (Font)Client.fontsMap.get(FontName.FontName_plain12);
                     DecorativeObject.fontBold12 = (Font)Client.fontsMap.get(FontName.FontName_bold12);
                     class21.platformInfo = new MachineInfo(true);
                     class90.loadingText = "Loaded fonts";
                     class90.loadingBarPercentage = 40;
                     Client.loadingStage = 60;
                  }
               } else if(Client.loadingStage == 60) {
                  var0 = CombatInfo1.method1650(GrandExchangeOffer.indexCache10, Renderable.indexSprites);
                  byte var29 = 11;
                  if(var0 < var29) {
                     class90.loadingText = "Loading title screen - " + var0 * 100 / var29 + "%";
                     class90.loadingBarPercentage = 50;
                  } else {
                     class90.loadingText = "Loaded title screen";
                     class90.loadingBarPercentage = 50;
                     Enum.setGameState(5);
                     Client.loadingStage = 70;
                  }
               } else if(Client.loadingStage == 70) {
                  if(!BoundingBox2D.configsIndex.method4674()) {
                     class90.loadingText = "Loading config - " + BoundingBox2D.configsIndex.loadPercent() + "%";
                     class90.loadingBarPercentage = 60;
                  } else {
                     Preferences.method1699(BoundingBox2D.configsIndex);
                     FileOnDisk.method2621(BoundingBox2D.configsIndex);
                     IndexData var34 = BoundingBox2D.configsIndex;
                     IndexData var36 = Client.indexModels;
                     class2.identKit_ref = var34;
                     KitDefinition.field3510 = var36;
                     KitDefinition.field3508 = class2.identKit_ref.fileCount(3);
                     var26 = BoundingBox2D.configsIndex;
                     var27 = Client.indexModels;
                     boolean var30 = Client.lowMemory;
                     ObjectComposition.objects_ref = var26;
                     ObjectComposition.field3589 = var27;
                     ObjectComposition.objectCompositionLowDetail = var30;
                     IndexData var5 = BoundingBox2D.configsIndex;
                     IndexData var6 = Client.indexModels;
                     class324.NpcDefinition_indexCache = var5;
                     NPCComposition.NpcDefinition_modelIndexCache = var6;
                     MilliTimer.method3263(BoundingBox2D.configsIndex);
                     IndexData var7 = BoundingBox2D.configsIndex;
                     IndexData var8 = Client.indexModels;
                     boolean var9 = Client.isMembers;
                     Font var10 = class41.fontPlain11;
                     WorldComparator.item_ref = var7;
                     class288.ItemDefinition_modelIndexCache = var8;
                     ItemComposition.isMembersWorld = var9;
                     ItemComposition.field3643 = WorldComparator.item_ref.fileCount(10);
                     BufferProvider.field3959 = var10;
                     class251.method4637(BoundingBox2D.configsIndex, class21.indexInterfaces, class5.indexSoundEffects);
                     IndexData var11 = BoundingBox2D.configsIndex;
                     IndexData var12 = Client.indexModels;
                     Spotanim.SpotAnimationDefinition_indexCache = var11;
                     Spotanim.SpotAnimationDefinition_modelIndexCache = var12;
                     class5.method21(BoundingBox2D.configsIndex);
                     IndexData var13 = BoundingBox2D.configsIndex;
                     VarPlayerType.varplayer_ref = var13;
                     VarPlayerType.field3446 = VarPlayerType.varplayer_ref.fileCount(16);
                     IndexData var14 = class195.indexCache3;
                     IndexData var15 = Client.indexModels;
                     IndexData var16 = Renderable.indexSprites;
                     IndexData var17 = class20.indexCache13;
                     class3.widgetIndex = var14;
                     BaseVarType.field30 = var15;
                     class29.field428 = var16;
                     Widget.field2818 = var17;
                     Widget.widgets = new Widget[class3.widgetIndex.size()][];
                     Widget.validInterfaces = new boolean[class3.widgetIndex.size()];
                     UrlRequest.method3183(BoundingBox2D.configsIndex);
                     IndexData var18 = BoundingBox2D.configsIndex;
                     Enum.EnumDefinition_indexCache = var18;
                     IndexData var19 = BoundingBox2D.configsIndex;
                     class270.field3471 = var19;
                     IndexData var20 = BoundingBox2D.configsIndex;
                     class271.field3475 = var20;
                     IndexData var21 = BoundingBox2D.configsIndex;
                     class278.field3547 = var21;
                     Script.chatMessages = new Varcs();
                     Occluder.method3162(BoundingBox2D.configsIndex, Renderable.indexSprites, class20.indexCache13);
                     IndexData var22 = BoundingBox2D.configsIndex;
                     IndexData var23 = Renderable.indexSprites;
                     CombatInfo2.field3515 = var22;
                     CombatInfo2.field3516 = var23;
                     class245.method4621(BoundingBox2D.configsIndex, Renderable.indexSprites);
                     class90.loadingText = "Loaded config";
                     class90.loadingBarPercentage = 60;
                     Client.loadingStage = 80;
                  }
               } else if(Client.loadingStage == 80) {
                  var0 = 0;
                  SpritePixels var25;
                  if(FrameMap.compass == null) {
                     var26 = Renderable.indexSprites;
                     var3 = var26.getFile("compass");
                     var4 = var26.getChild(var3, "");
                     var25 = class45.method640(var26, var3, var4);
                     FrameMap.compass = var25;
                  } else {
                     ++var0;
                  }

                  if(class169.mapedge == null) {
                     var26 = Renderable.indexSprites;
                     var3 = var26.getFile("mapedge");
                     var4 = var26.getChild(var3, "");
                     var25 = class45.method640(var26, var3, var4);
                     class169.mapedge = var25;
                  } else {
                     ++var0;
                  }

                  if(UrlRequester.mapscene == null) {
                     UrlRequester.mapscene = class254.getIndexedSprites(Renderable.indexSprites, "mapscene", "");
                  } else {
                     ++var0;
                  }

                  if(class241.headIconsPk == null) {
                     class241.headIconsPk = WorldMapType1.getSprites(Renderable.indexSprites, "headicons_pk", "");
                  } else {
                     ++var0;
                  }

                  if(class276.headIconsPrayer == null) {
                     class276.headIconsPrayer = WorldMapType1.getSprites(Renderable.indexSprites, "headicons_prayer", "");
                  } else {
                     ++var0;
                  }

                  if(SceneTilePaint.headIconsHint == null) {
                     SceneTilePaint.headIconsHint = WorldMapType1.getSprites(Renderable.indexSprites, "headicons_hint", "");
                  } else {
                     ++var0;
                  }

                  if(BaseVarType.mapMarkers == null) {
                     BaseVarType.mapMarkers = WorldMapType1.getSprites(Renderable.indexSprites, "mapmarker", "");
                  } else {
                     ++var0;
                  }

                  if(class278.crossSprites == null) {
                     class278.crossSprites = WorldMapType1.getSprites(Renderable.indexSprites, "cross", "");
                  } else {
                     ++var0;
                  }

                  if(WorldMapType3.mapDots == null) {
                     WorldMapType3.mapDots = WorldMapType1.getSprites(Renderable.indexSprites, "mapdots", "");
                  } else {
                     ++var0;
                  }

                  if(class233.scrollbarSprites == null) {
                     class233.scrollbarSprites = class254.getIndexedSprites(Renderable.indexSprites, "scrollbar", "");
                  } else {
                     ++var0;
                  }

                  if(BoundingBox2D.modIconSprites == null) {
                     BoundingBox2D.modIconSprites = class254.getIndexedSprites(Renderable.indexSprites, "mod_icons", "");
                  } else {
                     ++var0;
                  }

                  if(var0 < 11) {
                     class90.loadingText = "Loading sprites - " + var0 * 100 / 12 + "%";
                     class90.loadingBarPercentage = 70;
                  } else {
                     FontTypeFace.modIcons = BoundingBox2D.modIconSprites;
                     class169.mapedge.method5947();
                     var1 = (int)(Math.random() * 21.0D) - 10;
                     var2 = (int)(Math.random() * 21.0D) - 10;
                     var3 = (int)(Math.random() * 21.0D) - 10;
                     var4 = (int)(Math.random() * 41.0D) - 20;
                     UrlRequester.mapscene[0].method5890(var1 + var4, var2 + var4, var3 + var4);
                     class90.loadingText = "Loaded sprites";
                     class90.loadingBarPercentage = 70;
                     Client.loadingStage = 90;
                  }
               } else if(Client.loadingStage == 90) {
                  if(!class86.indexTextures.method4674()) {
                     class90.loadingText = "Loading textures - " + "0%";
                     class90.loadingBarPercentage = 90;
                  } else {
                     BoundingBox3DDrawMode.field272 = new TextureProvider(class86.indexTextures, Renderable.indexSprites, 20, 0.8D, Client.lowMemory?64:128);
                     Graphics3D.method2887(BoundingBox3DDrawMode.field272);
                     Graphics3D.setBrightness(0.8D);
                     Client.loadingStage = 100;
                  }
               } else if(Client.loadingStage == 100) {
                  var0 = BoundingBox3DDrawMode.field272.method2623();
                  if(var0 < 100) {
                     class90.loadingText = "Loading textures - " + var0 + "%";
                     class90.loadingBarPercentage = 90;
                  } else {
                     class90.loadingText = "Loaded textures";
                     class90.loadingBarPercentage = 90;
                     Client.loadingStage = 110;
                  }
               } else if(Client.loadingStage == 110) {
                  BoundingBox3D.mouseRecorder = new MouseRecorder();
                  GameEngine.taskManager.createRunnable(BoundingBox3D.mouseRecorder, 10);
                  class90.loadingText = "Loaded input handler";
                  class90.loadingBarPercentage = 92;
                  Client.loadingStage = 120;
               } else if(Client.loadingStage == 120) {
                  if(!GrandExchangeOffer.indexCache10.tryLoadRecordByNames("huffman", "")) {
                     class90.loadingText = "Loading wordpack - " + 0 + "%";
                     class90.loadingBarPercentage = 94;
                  } else {
                     Huffman var33 = new Huffman(GrandExchangeOffer.indexCache10.takeRecordByNames("huffman", ""));
                     ItemComposition.method5206(var33);
                     class90.loadingText = "Loaded wordpack";
                     class90.loadingBarPercentage = 94;
                     Client.loadingStage = 130;
                  }
               } else if(Client.loadingStage == 130) {
                  if(!class195.indexCache3.method4674()) {
                     class90.loadingText = "Loading interfaces - " + class195.indexCache3.loadPercent() * 4 / 5 + "%";
                     class90.loadingBarPercentage = 96;
                  } else if(!class1.indexScripts.method4674()) {
                     class90.loadingText = "Loading interfaces - " + (80 + class1.indexScripts.loadPercent() / 6) + "%";
                     class90.loadingBarPercentage = 96;
                  } else if(!class20.indexCache13.method4674()) {
                     class90.loadingText = "Loading interfaces - " + (96 + class20.indexCache13.loadPercent() / 50) + "%";
                     class90.loadingBarPercentage = 96;
                  } else {
                     class90.loadingText = "Loaded interfaces";
                     class90.loadingBarPercentage = 98;
                     Client.loadingStage = 140;
                  }
               } else if(Client.loadingStage == 140) {
                  class90.loadingBarPercentage = 100;
                  if(!ServerPacket.indexWorldMap.tryLoadArchiveByName(class41.field546.field542)) {
                     class90.loadingText = "Loading world map - " + ServerPacket.indexWorldMap.archiveLoadPercentByName(class41.field546.field542) / 10 + "%";
                  } else {
                     if(class248.renderOverview == null) {
                        class248.renderOverview = new RenderOverview();
                        class248.renderOverview.method6156(ServerPacket.indexWorldMap, DecorativeObject.fontBold12, Client.fontsMap, UrlRequester.mapscene);
                     }

                     var0 = class248.renderOverview.method6086();
                     if(var0 < 100) {
                        class90.loadingText = "Loading world map - " + (var0 * 9 / 10 + 10) + "%";
                     } else {
                        class90.loadingText = "Loaded world map";
                        Client.loadingStage = 150;
                     }
                  }
               } else if(Client.loadingStage == 150) {
                  Enum.setGameState(10);
               }
            }
         } else {
            int[] var24 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var2 = var1 * 32 + 15 + 128;
               var3 = var2 * 3 + 600;
               var4 = Graphics3D.SINE[var2];
               var24[var1] = var3 * var4 >> 16;
            }

            Region.buildVisibilityMaps(var24, 500, 800, 512, 334);
            class90.loadingText = "Prepared visibility map";
            class90.loadingBarPercentage = 10;
            Client.loadingStage = 30;
         }
      }
   }
}
