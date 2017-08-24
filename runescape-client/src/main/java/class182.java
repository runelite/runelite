import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gz")
public class class182 {
   @ObfuscatedName("rg")
   @ObfuscatedGetter(
      intValue = 924961505
   )
   static int field2443;

   @ObfuscatedName("et")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1709705607"
   )
   @Export("load")
   static void load() {
      int var0;
      if(Client.loadingStage == 0) {
         ScriptState.region = new Region(4, 104, 104, class61.tileHeights);

         for(var0 = 0; var0 < 4; ++var0) {
            Client.collisionMaps[var0] = new CollisionData(104, 104);
         }

         GrandExchangeOffer.field315 = new SpritePixels(512, 512);
         class91.loadingText = "Starting game engine...";
         class91.loadingBarPercentage = 5;
         Client.loadingStage = 20;
      } else {
         int var1;
         int var2;
         int var3;
         int var4;
         if(Client.loadingStage == 20) {
            int[] var37 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var2 = 15 + var1 * 32 + 128;
               var3 = var2 * 3 + 600;
               var4 = Graphics3D.SINE[var2];
               var37[var1] = var4 * var3 >> 16;
            }

            Region.method2852(var37, 500, 800, 512, 334);
            class91.loadingText = "Prepared visibility map";
            class91.loadingBarPercentage = 10;
            Client.loadingStage = 30;
         } else if(Client.loadingStage == 30) {
            Player.indexInterfaces = GroundObject.openCacheIndex(0, false, true, true);
            class89.indexSoundEffects = GroundObject.openCacheIndex(1, false, true, true);
            GameEngine.configsIndex = GroundObject.openCacheIndex(2, true, false, true);
            DState.field2389 = GroundObject.openCacheIndex(3, false, true, true);
            class178.field2419 = GroundObject.openCacheIndex(4, false, true, true);
            RSCanvas.indexMaps = GroundObject.openCacheIndex(5, true, true, true);
            class45.indexTrack1 = GroundObject.openCacheIndex(6, true, true, false);
            class272.indexModels = GroundObject.openCacheIndex(7, false, true, true);
            GrandExchangeOffer.indexSprites = GroundObject.openCacheIndex(8, false, true, true);
            class18.indexTextures = GroundObject.openCacheIndex(9, false, true, true);
            InvType.field3283 = GroundObject.openCacheIndex(10, false, true, true);
            class46.indexTrack2 = GroundObject.openCacheIndex(11, false, true, true);
            class67.indexScripts = GroundObject.openCacheIndex(12, false, true, true);
            class216.field2644 = GroundObject.openCacheIndex(13, true, false, true);
            class34.vorbisIndex = GroundObject.openCacheIndex(14, false, true, false);
            class7.field235 = GroundObject.openCacheIndex(15, false, true, true);
            class111.indexWorldMap = GroundObject.openCacheIndex(16, false, true, false);
            class91.loadingText = "Connecting to update server";
            class91.loadingBarPercentage = 20;
            Client.loadingStage = 40;
         } else if(Client.loadingStage == 40) {
            byte var33 = 0;
            var0 = var33 + Player.indexInterfaces.percentage() * 4 / 100;
            var0 += class89.indexSoundEffects.percentage() * 4 / 100;
            var0 += GameEngine.configsIndex.percentage() * 2 / 100;
            var0 += DState.field2389.percentage() * 2 / 100;
            var0 += class178.field2419.percentage() * 6 / 100;
            var0 += RSCanvas.indexMaps.percentage() * 4 / 100;
            var0 += class45.indexTrack1.percentage() * 2 / 100;
            var0 += class272.indexModels.percentage() * 58 / 100;
            var0 += GrandExchangeOffer.indexSprites.percentage() * 2 / 100;
            var0 += class18.indexTextures.percentage() * 2 / 100;
            var0 += InvType.field3283.percentage() * 2 / 100;
            var0 += class46.indexTrack2.percentage() * 2 / 100;
            var0 += class67.indexScripts.percentage() * 2 / 100;
            var0 += class216.field2644.percentage() * 2 / 100;
            var0 += class34.vorbisIndex.percentage() * 2 / 100;
            var0 += class7.field235.percentage() * 2 / 100;
            var0 += class111.indexWorldMap.percentage() * 2 / 100;
            if(var0 != 100) {
               if(var0 != 0) {
                  class91.loadingText = "Checking for updates - " + var0 + "%";
               }

               class91.loadingBarPercentage = 30;
            } else {
               class91.loadingText = "Loaded update list";
               class91.loadingBarPercentage = 30;
               Client.loadingStage = 45;
            }
         } else {
            IndexData var28;
            IndexData var29;
            IndexData var30;
            if(Client.loadingStage == 45) {
               RSSocket.method3082(22050, !Client.lowMemory, 2);
               class205 var36 = new class205();
               var36.method3777(9, 128);
               CacheFile.soundSystem0 = class227.method4109(GameEngine.taskManager, 0, 22050);
               CacheFile.soundSystem0.method2009(var36);
               var28 = class7.field235;
               var29 = class34.vorbisIndex;
               var30 = class178.field2419;
               class204.field2504 = var28;
               class204.field2512 = var29;
               class204.field2506 = var30;
               class225.field2856 = var36;
               class8.soundSystem1 = class227.method4109(GameEngine.taskManager, 1, 2048);
               class33.field479 = new class101();
               class8.soundSystem1.method2009(class33.field479);
               class209.field2592 = new class115(22050, class73.sampleRate);
               class91.loadingText = "Prepared sound engine";
               class91.loadingBarPercentage = 35;
               Client.loadingStage = 50;
               WorldMapType2.field539 = new class263(GrandExchangeOffer.indexSprites, class216.field2644);
            } else if(Client.loadingStage == 50) {
               var0 = class262.method4697().length;
               Client.field997 = WorldMapType2.field539.method4701(class262.method4697());
               if(Client.field997.size() < var0) {
                  class91.loadingText = "Loading fonts - " + Client.field997.size() * 100 / var0 + "%";
                  class91.loadingBarPercentage = 40;
               } else {
                  class31.field447 = (Font)Client.field997.get(class262.field3629);
                  WorldMapType2.font_p12full = (Font)Client.field997.get(class262.field3617);
                  class73.field897 = (Font)Client.field997.get(class262.field3616);
                  class3.field21 = new MachineInfo(true);
                  class91.loadingText = "Loaded fonts";
                  class91.loadingBarPercentage = 40;
                  Client.loadingStage = 60;
               }
            } else if(Client.loadingStage == 60) {
               var0 = class17.method145(InvType.field3283, GrandExchangeOffer.indexSprites);
               byte var32 = 11;
               if(var0 < var32) {
                  class91.loadingText = "Loading title screen - " + var0 * 100 / var32 + "%";
                  class91.loadingBarPercentage = 50;
               } else {
                  class91.loadingText = "Loaded title screen";
                  class91.loadingBarPercentage = 50;
                  WorldMapType2.setGameState(5);
                  Client.loadingStage = 70;
               }
            } else if(Client.loadingStage == 70) {
               if(!GameEngine.configsIndex.method4139()) {
                  class91.loadingText = "Loading config - " + GameEngine.configsIndex.method4234() + "%";
                  class91.loadingBarPercentage = 60;
               } else {
                  IndexData var35 = GameEngine.configsIndex;
                  Overlay.overlay_ref = var35;
                  var28 = GameEngine.configsIndex;
                  FloorUnderlayDefinition.underlay_ref = var28;
                  var29 = GameEngine.configsIndex;
                  var30 = class272.indexModels;
                  class54.identKit_ref = var29;
                  class266.field3657 = var30;
                  KitDefinition.field3361 = class54.identKit_ref.fileCount(3);
                  IndexData var31 = GameEngine.configsIndex;
                  IndexData var5 = class272.indexModels;
                  boolean var6 = Client.lowMemory;
                  ObjectComposition.objects_ref = var31;
                  class228.field3150 = var5;
                  ObjectComposition.field3477 = var6;
                  IndexData var7 = GameEngine.configsIndex;
                  IndexData var8 = class272.indexModels;
                  NPCComposition.field3570 = var7;
                  NPCComposition.field3547 = var8;
                  IndexData var9 = GameEngine.configsIndex;
                  class239.field3272 = var9;
                  IndexData var10 = GameEngine.configsIndex;
                  IndexData var11 = class272.indexModels;
                  boolean var12 = Client.isMembers;
                  Font var13 = class31.field447;
                  FileOnDisk.item_ref = var10;
                  CombatInfoListHolder.field1378 = var11;
                  class2.isMembersWorld = var12;
                  ItemComposition.field3486 = FileOnDisk.item_ref.fileCount(10);
                  ItemComposition.field3489 = var13;
                  IndexData var14 = GameEngine.configsIndex;
                  IndexData var15 = Player.indexInterfaces;
                  IndexData var16 = class89.indexSoundEffects;
                  Sequence.seq_ref = var14;
                  Sequence.skel_ref = var15;
                  Sequence.skin_ref = var16;
                  IndexData var17 = GameEngine.configsIndex;
                  IndexData var18 = class272.indexModels;
                  Spotanim.field3331 = var17;
                  Spotanim.field3336 = var18;
                  GroundObject.method2499(GameEngine.configsIndex);
                  IndexData var19 = GameEngine.configsIndex;
                  VarPlayerType.varplayer_ref = var19;
                  VarPlayerType.field3291 = VarPlayerType.varplayer_ref.fileCount(16);
                  Ignore.method1134(DState.field2389, class272.indexModels, GrandExchangeOffer.indexSprites, class216.field2644);
                  class1.method2(GameEngine.configsIndex);
                  IndexData var20 = GameEngine.configsIndex;
                  Enum.field3410 = var20;
                  IndexData var21 = GameEngine.configsIndex;
                  class244.field3317 = var21;
                  class170.method3215(GameEngine.configsIndex);
                  IndexData var22 = GameEngine.configsIndex;
                  class252.field3388 = var22;
                  class2.chatMessages = new Varcs();
                  AbstractSoundSystem.method2059(GameEngine.configsIndex, GrandExchangeOffer.indexSprites, class216.field2644);
                  class28.method271(GameEngine.configsIndex, GrandExchangeOffer.indexSprites);
                  IndexData var23 = GameEngine.configsIndex;
                  IndexData var24 = GrandExchangeOffer.indexSprites;
                  Area.field3310 = var24;
                  if(var23.method4139()) {
                     class153.field2229 = var23.fileCount(35);
                     Area.field3294 = new Area[class153.field2229];

                     for(int var25 = 0; var25 < class153.field2229; ++var25) {
                        byte[] var26 = var23.getConfigData(35, var25);
                        if(var26 != null) {
                           Area.field3294[var25] = new Area(var25);
                           Area.field3294[var25].method4291(new Buffer(var26));
                           Area.field3294[var25].method4307();
                        }
                     }
                  }

                  class91.loadingText = "Loaded config";
                  class91.loadingBarPercentage = 60;
                  Client.loadingStage = 80;
               }
            } else if(Client.loadingStage == 80) {
               var0 = 0;
               if(class44.compass == null) {
                  class44.compass = class165.method3157(GrandExchangeOffer.indexSprites, "compass", "");
               } else {
                  ++var0;
               }

               if(Friend.mapedge == null) {
                  Friend.mapedge = class165.method3157(GrandExchangeOffer.indexSprites, "mapedge", "");
               } else {
                  ++var0;
               }

               if(class8.field242 == null) {
                  class8.field242 = class139.method2909(GrandExchangeOffer.indexSprites, "mapscene", "");
               } else {
                  ++var0;
               }

               if(class94.mapfunctions == null) {
                  class94.mapfunctions = class10.method62(GrandExchangeOffer.indexSprites, "headicons_pk", "");
               } else {
                  ++var0;
               }

               if(class12.hitmarks == null) {
                  class12.hitmarks = class10.method62(GrandExchangeOffer.indexSprites, "headicons_prayer", "");
               } else {
                  ++var0;
               }

               if(class10.pkIcons == null) {
                  class10.pkIcons = class10.method62(GrandExchangeOffer.indexSprites, "headicons_hint", "");
               } else {
                  ++var0;
               }

               if(class66.field832 == null) {
                  class66.field832 = class10.method62(GrandExchangeOffer.indexSprites, "mapmarker", "");
               } else {
                  ++var0;
               }

               if(class205.field2541 == null) {
                  class205.field2541 = class10.method62(GrandExchangeOffer.indexSprites, "cross", "");
               } else {
                  ++var0;
               }

               if(class156.mapDots == null) {
                  class156.mapDots = class10.method62(GrandExchangeOffer.indexSprites, "mapdots", "");
               } else {
                  ++var0;
               }

               if(class158.field2262 == null) {
                  class158.field2262 = class139.method2909(GrandExchangeOffer.indexSprites, "scrollbar", "");
               } else {
                  ++var0;
               }

               if(Timer.field2267 == null) {
                  Timer.field2267 = class139.method2909(GrandExchangeOffer.indexSprites, "mod_icons", "");
               } else {
                  ++var0;
               }

               if(var0 < 11) {
                  class91.loadingText = "Loading sprites - " + var0 * 100 / 12 + "%";
                  class91.loadingBarPercentage = 70;
               } else {
                  FontTypeFace.modIcons = Timer.field2267;
                  Friend.mapedge.method5011();
                  var1 = (int)(Math.random() * 21.0D) - 10;
                  var2 = (int)(Math.random() * 21.0D) - 10;
                  var3 = (int)(Math.random() * 21.0D) - 10;
                  var4 = (int)(Math.random() * 41.0D) - 20;
                  class8.field242[0].method5004(var1 + var4, var4 + var2, var3 + var4);
                  class91.loadingText = "Loaded sprites";
                  class91.loadingBarPercentage = 70;
                  Client.loadingStage = 90;
               }
            } else if(Client.loadingStage == 90) {
               if(!class18.indexTextures.method4139()) {
                  class91.loadingText = "Loading textures - " + class18.indexTextures.method4234() + "%";
                  class91.loadingBarPercentage = 90;
               } else {
                  TextureProvider var34 = new TextureProvider(class18.indexTextures, GrandExchangeOffer.indexSprites, 20, 0.8D, Client.lowMemory?64:128);
                  Graphics3D.setTextureLoader(var34);
                  Graphics3D.setBrightness(0.8D);
                  class91.loadingText = "Loaded textures";
                  class91.loadingBarPercentage = 90;
                  Client.loadingStage = 110;
               }
            } else if(Client.loadingStage == 110) {
               Client.field970 = new class71();
               GameEngine.taskManager.createRunnable(Client.field970, 10);
               class91.loadingText = "Loaded input handler";
               class91.loadingBarPercentage = 94;
               Client.loadingStage = 120;
            } else if(Client.loadingStage == 120) {
               if(!InvType.field3283.method4155("huffman", "")) {
                  class91.loadingText = "Loading wordpack - " + 0 + "%";
                  class91.loadingBarPercentage = 96;
               } else {
                  Huffman var27 = new Huffman(InvType.field3283.method4154("huffman", ""));
                  class266.field3656 = var27;
                  class91.loadingText = "Loaded wordpack";
                  class91.loadingBarPercentage = 96;
                  Client.loadingStage = 130;
               }
            } else if(Client.loadingStage == 130) {
               if(!DState.field2389.method4139()) {
                  class91.loadingText = "Loading interfaces - " + DState.field2389.method4234() * 4 / 5 + "%";
                  class91.loadingBarPercentage = 100;
               } else if(!class67.indexScripts.method4139()) {
                  class91.loadingText = "Loading interfaces - " + (80 + class67.indexScripts.method4234() / 6) + "%";
                  class91.loadingBarPercentage = 100;
               } else if(!class216.field2644.method4139()) {
                  class91.loadingText = "Loading interfaces - " + (96 + class216.field2644.method4234() / 50) + "%";
                  class91.loadingBarPercentage = 100;
               } else {
                  class91.loadingText = "Loaded interfaces";
                  class91.loadingBarPercentage = 98;
                  Client.loadingStage = 140;
               }
            } else if(Client.loadingStage == 140) {
               if(!class111.indexWorldMap.method4172(class40.field560.field556)) {
                  class91.loadingText = "Loading world map - " + class111.indexWorldMap.method4158(class40.field560.field556) / 10 + "%";
               } else {
                  if(KeyFocusListener.renderOverview == null) {
                     KeyFocusListener.renderOverview = new RenderOverview();
                     KeyFocusListener.renderOverview.method5157(class111.indexWorldMap, class73.field897, Client.field997, class8.field242);
                  }

                  var0 = KeyFocusListener.renderOverview.method5158();
                  if(var0 < 100) {
                     class91.loadingText = "Loading world map - " + (var0 * 9 / 10 + 10) + "%";
                  } else {
                     class91.loadingText = "Loaded world map";
                     class91.loadingBarPercentage = 100;
                     Client.loadingStage = 150;
                  }
               }
            } else if(Client.loadingStage == 150) {
               WorldMapType2.setGameState(10);
            }
         }
      }
   }

   @ObfuscatedName("gq")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-881919627"
   )
   static final void method3529(int var0, int var1, int var2, int var3) {
      Client.field1024 = 0;
      boolean var4 = false;
      int var5 = -1;
      int var6 = class95.field1507;
      int[] var7 = class95.field1511;

      int var8;
      for(var8 = 0; var8 < var6 + Client.field946; ++var8) {
         Object var9;
         if(var8 < var6) {
            var9 = Client.cachedPlayers[var7[var8]];
            if(var7[var8] == Client.field1060) {
               var4 = true;
               var5 = var8;
               continue;
            }
         } else {
            var9 = Client.cachedNPCs[Client.npcIndices[var8 - var6]];
         }

         class27.method240((Actor)var9, var8, var0, var1, var2, var3);
      }

      if(var4) {
         class27.method240(Client.cachedPlayers[Client.field1060], var5, var0, var1, var2, var3);
      }

      for(var8 = 0; var8 < Client.field1024; ++var8) {
         int var18 = Client.field1026[var8];
         int var10 = Client.field1201[var8];
         int var11 = Client.field1029[var8];
         int var12 = Client.field1118[var8];
         boolean var13 = true;

         while(var13) {
            var13 = false;

            for(int var14 = 0; var14 < var8; ++var14) {
               if(var10 + 2 > Client.field1201[var14] - Client.field1118[var14] && var10 - var12 < Client.field1201[var14] + 2 && var18 - var11 < Client.field1026[var14] + Client.field1029[var14] && var18 + var11 > Client.field1026[var14] - Client.field1029[var14] && Client.field1201[var14] - Client.field1118[var14] < var10) {
                  var10 = Client.field1201[var14] - Client.field1118[var14];
                  var13 = true;
               }
            }
         }

         Client.screenY = Client.field1026[var8];
         Client.screenX = Client.field1201[var8] = var10;
         String var19 = Client.field993[var8];
         if(Client.field1093 == 0) {
            int var15 = 16776960;
            if(Client.field1030[var8] < 6) {
               var15 = Client.field1147[Client.field1030[var8]];
            }

            if(Client.field1030[var8] == 6) {
               var15 = Client.field1035 % 20 < 10?16711680:16776960;
            }

            if(Client.field1030[var8] == 7) {
               var15 = Client.field1035 % 20 < 10?255:'\uffff';
            }

            if(Client.field1030[var8] == 8) {
               var15 = Client.field1035 % 20 < 10?'뀀':8454016;
            }

            int var16;
            if(Client.field1030[var8] == 9) {
               var16 = 150 - Client.field1032[var8];
               if(var16 < 50) {
                  var15 = var16 * 1280 + 16711680;
               } else if(var16 < 100) {
                  var15 = 16776960 - (var16 - 50) * 327680;
               } else if(var16 < 150) {
                  var15 = (var16 - 100) * 5 + '\uff00';
               }
            }

            if(Client.field1030[var8] == 10) {
               var16 = 150 - Client.field1032[var8];
               if(var16 < 50) {
                  var15 = 16711680 + var16 * 5;
               } else if(var16 < 100) {
                  var15 = 16711935 - (var16 - 50) * 327680;
               } else if(var16 < 150) {
                  var15 = (var16 - 100) * 327680 + 255 - (var16 - 100) * 5;
               }
            }

            if(Client.field1030[var8] == 11) {
               var16 = 150 - Client.field1032[var8];
               if(var16 < 50) {
                  var15 = 16777215 - var16 * 327685;
               } else if(var16 < 100) {
                  var15 = (var16 - 50) * 327685 + '\uff00';
               } else if(var16 < 150) {
                  var15 = 16777215 - (var16 - 100) * 327680;
               }
            }

            if(Client.field1031[var8] == 0) {
               class73.field897.method4755(var19, var0 + Client.screenY, Client.screenX + var1, var15, 0);
            }

            if(Client.field1031[var8] == 1) {
               class73.field897.method4725(var19, var0 + Client.screenY, Client.screenX + var1, var15, 0, Client.field1035);
            }

            if(Client.field1031[var8] == 2) {
               class73.field897.method4779(var19, var0 + Client.screenY, Client.screenX + var1, var15, 0, Client.field1035);
            }

            if(Client.field1031[var8] == 3) {
               class73.field897.method4762(var19, var0 + Client.screenY, Client.screenX + var1, var15, 0, Client.field1035, 150 - Client.field1032[var8]);
            }

            if(Client.field1031[var8] == 4) {
               var16 = (150 - Client.field1032[var8]) * (class73.field897.method4775(var19) + 100) / 150;
               Rasterizer2D.setInnerDrawRegion(var0 + Client.screenY - 50, var1, var0 + Client.screenY + 50, var3 + var1);
               class73.field897.method4773(var19, var0 + Client.screenY + 50 - var16, Client.screenX + var1, var15, 0);
               Rasterizer2D.setDrawRegion(var0, var1, var0 + var2, var3 + var1);
            }

            if(Client.field1031[var8] == 5) {
               var16 = 150 - Client.field1032[var8];
               int var17 = 0;
               if(var16 < 25) {
                  var17 = var16 - 25;
               } else if(var16 > 125) {
                  var17 = var16 - 125;
               }

               Rasterizer2D.setInnerDrawRegion(var0, Client.screenX + var1 - class73.field897.verticalSpace - 1, var0 + var2, Client.screenX + var1 + 5);
               class73.field897.method4755(var19, var0 + Client.screenY, var17 + Client.screenX + var1, var15, 0);
               Rasterizer2D.setDrawRegion(var0, var1, var0 + var2, var3 + var1);
            }
         } else {
            class73.field897.method4755(var19, var0 + Client.screenY, Client.screenX + var1, 16776960, 0);
         }
      }

   }
}
