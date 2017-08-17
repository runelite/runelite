import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
public class class24 {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Ln;"
   )
   public static final class24 field369;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Ln;"
   )
   public static final class24 field366;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Ln;"
   )
   public static final class24 field367;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1959884687
   )
   final int field371;
   @ObfuscatedName("p")
   final String field368;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -360655387
   )
   final int field365;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1052244577
   )
   final int field370;

   static {
      field369 = new class24("SMALL", 2, 0, 4);
      field366 = new class24("MEDIUM", 0, 1, 2);
      field367 = new class24("LARGE", 1, 2, 0);
   }

   class24(String var1, int var2, int var3, int var4) {
      this.field368 = var1;
      this.field365 = var2;
      this.field370 = var3;
      this.field371 = var4;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(FI)Z",
      garbageValue = "1704513990"
   )
   boolean method186(float var1) {
      return var1 >= (float)this.field371;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)[Ln;",
      garbageValue = "75"
   )
   static class24[] method187() {
      return new class24[]{field369, field367, field366};
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)Ln;",
      garbageValue = "108178025"
   )
   static class24 method190(int var0) {
      class24[] var1 = method187();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         class24 var3 = var1[var2];
         if(var0 == var3.field370) {
            return var3;
         }
      }

      return null;
   }

   @ObfuscatedName("ff")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "83896728"
   )
   @Export("load")
   static void load() {
      int var0;
      if(Client.loadingStage == 0) {
         class36.region = new Region(4, 104, 104, class61.tileHeights);

         for(var0 = 0; var0 < 4; ++var0) {
            Client.collisionMaps[var0] = new CollisionData(104, 104);
         }

         ItemComposition.field3531 = new SpritePixels(512, 512);
         class93.loadingText = "Starting game engine...";
         class93.loadingBarPercentage = 5;
         Client.loadingStage = 20;
      } else {
         int var1;
         int var2;
         int var3;
         int var4;
         if(Client.loadingStage == 20) {
            int[] var32 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var2 = var1 * 32 + 15 + 128;
               var3 = var2 * 3 + 600;
               var4 = Graphics3D.SINE[var2];
               var32[var1] = var4 * var3 >> 16;
            }

            Region.method2737(var32, 500, 800, 512, 334);
            class93.loadingText = "Prepared visibility map";
            class93.loadingBarPercentage = 10;
            Client.loadingStage = 30;
         } else if(Client.loadingStage == 30) {
            class33.indexInterfaces = class209.openCacheIndex(0, false, true, true);
            ScriptState.indexSoundEffects = class209.openCacheIndex(1, false, true, true);
            class28.configsIndex = class209.openCacheIndex(2, true, false, true);
            class83.field1337 = class209.openCacheIndex(3, false, true, true);
            Client.field965 = class209.openCacheIndex(4, false, true, true);
            class14.indexMaps = class209.openCacheIndex(5, true, true, true);
            class253.indexTrack1 = class209.openCacheIndex(6, true, true, false);
            class47.indexModels = class209.openCacheIndex(7, false, true, true);
            class176.indexSprites = class209.openCacheIndex(8, false, true, true);
            Tile.indexTextures = class209.openCacheIndex(9, false, true, true);
            MouseInput.field744 = class209.openCacheIndex(10, false, true, true);
            DState.indexTrack2 = class209.openCacheIndex(11, false, true, true);
            FrameMap.indexScripts = class209.openCacheIndex(12, false, true, true);
            class262.field3617 = class209.openCacheIndex(13, true, false, true);
            Enum.vorbisIndex = class209.openCacheIndex(14, false, true, false);
            class212.field2606 = class209.openCacheIndex(15, false, true, true);
            VertexNormal.indexWorldMap = class209.openCacheIndex(16, false, true, false);
            class93.loadingText = "Connecting to update server";
            class93.loadingBarPercentage = 20;
            Client.loadingStage = 40;
         } else if(Client.loadingStage == 40) {
            byte var26 = 0;
            var0 = var26 + class33.indexInterfaces.percentage() * 4 / 100;
            var0 += ScriptState.indexSoundEffects.percentage() * 4 / 100;
            var0 += class28.configsIndex.percentage() * 2 / 100;
            var0 += class83.field1337.percentage() * 2 / 100;
            var0 += Client.field965.percentage() * 6 / 100;
            var0 += class14.indexMaps.percentage() * 4 / 100;
            var0 += class253.indexTrack1.percentage() * 2 / 100;
            var0 += class47.indexModels.percentage() * 58 / 100;
            var0 += class176.indexSprites.percentage() * 2 / 100;
            var0 += Tile.indexTextures.percentage() * 2 / 100;
            var0 += MouseInput.field744.percentage() * 2 / 100;
            var0 += DState.indexTrack2.percentage() * 2 / 100;
            var0 += FrameMap.indexScripts.percentage() * 2 / 100;
            var0 += class262.field3617.percentage() * 2 / 100;
            var0 += Enum.vorbisIndex.percentage() * 2 / 100;
            var0 += class212.field2606.percentage() * 2 / 100;
            var0 += VertexNormal.indexWorldMap.percentage() * 2 / 100;
            if(var0 != 100) {
               if(var0 != 0) {
                  class93.loadingText = "Checking for updates - " + var0 + "%";
               }

               class93.loadingBarPercentage = 30;
            } else {
               class93.loadingText = "Loaded update list";
               class93.loadingBarPercentage = 30;
               Client.loadingStage = 45;
            }
         } else if(Client.loadingStage == 45) {
            class41.method616(22050, !Client.lowMemory, 2);
            class205 var30 = new class205();
            var30.method3697(9, 128);
            class84.soundSystem0 = class51.method808(GameEngine.taskManager, 0, 22050);
            class84.soundSystem0.method2030(var30);
            class83.method1625(class212.field2606, Enum.vorbisIndex, Client.field965, var30);
            WorldMapType1.soundSystem1 = class51.method808(GameEngine.taskManager, 1, 2048);
            class56.field679 = new class103();
            WorldMapType1.soundSystem1.method2030(class56.field679);
            class11.field262 = new class117(22050, AbstractSoundSystem.sampleRate);
            class93.loadingText = "Prepared sound engine";
            class93.loadingBarPercentage = 35;
            Client.loadingStage = 50;
            SceneTilePaint.field2052 = new class263(class176.indexSprites, class262.field3617);
         } else if(Client.loadingStage == 50) {
            class262[] var29 = new class262[]{class262.field3612, class262.field3611, class262.field3613, class262.field3610, class262.field3614, class262.field3609};
            var1 = var29.length;
            class263 var31 = SceneTilePaint.field2052;
            class262[] var33 = new class262[]{class262.field3612, class262.field3611, class262.field3613, class262.field3610, class262.field3614, class262.field3609};
            Client.field989 = var31.method4760(var33);
            if(Client.field989.size() < var1) {
               class93.loadingText = "Loading fonts - " + Client.field989.size() * 100 / var1 + "%";
               class93.loadingBarPercentage = 40;
            } else {
               VertexNormal.field2006 = (Font)Client.field989.get(class262.field3612);
               class35.font_p12full = (Font)Client.field989.get(class262.field3609);
               class61.field765 = (Font)Client.field989.get(class262.field3610);
               ChatLineBuffer.field1564 = new MachineInfo(true);
               class93.loadingText = "Loaded fonts";
               class93.loadingBarPercentage = 40;
               Client.loadingStage = 60;
            }
         } else if(Client.loadingStage == 60) {
            var0 = class5.method14(MouseInput.field744, class176.indexSprites);
            var1 = class45.method689();
            if(var0 < var1) {
               class93.loadingText = "Loading title screen - " + var0 * 100 / var1 + "%";
               class93.loadingBarPercentage = 50;
            } else {
               class93.loadingText = "Loaded title screen";
               class93.loadingBarPercentage = 50;
               MouseInput.setGameState(5);
               Client.loadingStage = 70;
            }
         } else if(Client.loadingStage == 70) {
            if(!class28.configsIndex.method4117()) {
               class93.loadingText = "Loading config - " + class28.configsIndex.method4226() + "%";
               class93.loadingBarPercentage = 60;
            } else {
               IndexData var28 = class28.configsIndex;
               class250.overlay_ref = var28;
               class34.method505(class28.configsIndex);
               IndexData var24 = class28.configsIndex;
               IndexData var22 = class47.indexModels;
               KitDefinition.identKit_ref = var24;
               KitDefinition.field3341 = var22;
               KitDefinition.field3337 = KitDefinition.identKit_ref.fileCount(3);
               IndexData var23 = class28.configsIndex;
               IndexData var25 = class47.indexModels;
               boolean var5 = Client.lowMemory;
               ObjectComposition.objects_ref = var23;
               ObjectComposition.field3427 = var25;
               ObjectComposition.field3451 = var5;
               IndexData var6 = class28.configsIndex;
               IndexData var7 = class47.indexModels;
               class156.field2258 = var6;
               NPCComposition.field3565 = var7;
               class29.method260(class28.configsIndex);
               class245.method4360(class28.configsIndex, class47.indexModels, Client.isMembers, VertexNormal.field2006);
               IndexData var8 = class28.configsIndex;
               IndexData var9 = class33.indexInterfaces;
               IndexData var10 = ScriptState.indexSoundEffects;
               Sequence.seq_ref = var8;
               class18.skel_ref = var9;
               Sequence.skin_ref = var10;
               IndexData var11 = class28.configsIndex;
               IndexData var12 = class47.indexModels;
               Spotanim.field3312 = var11;
               Spotanim.field3311 = var12;
               IndexData var13 = class28.configsIndex;
               Varbit.varbit_ref = var13;
               class14.method80(class28.configsIndex);
               ItemLayer.method2429(class83.field1337, class47.indexModels, class176.indexSprites, class262.field3617);
               class28.method255(class28.configsIndex);
               class150.method2928(class28.configsIndex);
               class89.method1718(class28.configsIndex);
               class27.method235(class28.configsIndex);
               IndexData var14 = class28.configsIndex;
               class252.field3375 = var14;
               class156.chatMessages = new Varcs();
               class176.method3394(class28.configsIndex, class176.indexSprites, class262.field3617);
               IndexData var15 = class28.configsIndex;
               IndexData var16 = class176.indexSprites;
               CombatInfo2.field3349 = var15;
               CombatInfo2.field3359 = var16;
               IndexData var17 = class28.configsIndex;
               IndexData var18 = class176.indexSprites;
               Area.field3288 = var18;
               if(var17.method4117()) {
                  Area.field3277 = var17.fileCount(35);
                  Area.field3284 = new Area[Area.field3277];

                  for(int var19 = 0; var19 < Area.field3277; ++var19) {
                     byte[] var20 = var17.getConfigData(35, var19);
                     if(var20 != null) {
                        Area.field3284[var19] = new Area(var19);
                        Area.field3284[var19].method4305(new Buffer(var20));
                        Area.field3284[var19].method4311();
                     }
                  }
               }

               class93.loadingText = "Loaded config";
               class93.loadingBarPercentage = 60;
               Client.loadingStage = 80;
            }
         } else if(Client.loadingStage == 80) {
            var0 = 0;
            if(RSCanvas.compass == null) {
               RSCanvas.compass = IndexData.method4233(class176.indexSprites, "compass", "");
            } else {
               ++var0;
            }

            if(class141.mapedge == null) {
               class141.mapedge = IndexData.method4233(class176.indexSprites, "mapedge", "");
            } else {
               ++var0;
            }

            if(Client.field1001 == null) {
               Client.field1001 = class25.method197(class176.indexSprites, "mapscene", "");
            } else {
               ++var0;
            }

            if(RSCanvas.mapfunctions == null) {
               RSCanvas.mapfunctions = class54.method833(class176.indexSprites, "headicons_pk", "");
            } else {
               ++var0;
            }

            if(class27.hitmarks == null) {
               class27.hitmarks = class54.method833(class176.indexSprites, "headicons_prayer", "");
            } else {
               ++var0;
            }

            if(class13.pkIcons == null) {
               class13.pkIcons = class54.method833(class176.indexSprites, "headicons_hint", "");
            } else {
               ++var0;
            }

            if(class9.field249 == null) {
               class9.field249 = class54.method833(class176.indexSprites, "mapmarker", "");
            } else {
               ++var0;
            }

            if(class165.field2320 == null) {
               class165.field2320 = class54.method833(class176.indexSprites, "cross", "");
            } else {
               ++var0;
            }

            if(class60.mapDots == null) {
               class60.mapDots = class54.method833(class176.indexSprites, "mapdots", "");
            } else {
               ++var0;
            }

            if(class60.field753 == null) {
               class60.field753 = class25.method197(class176.indexSprites, "scrollbar", "");
            } else {
               ++var0;
            }

            if(BaseVarType.field29 == null) {
               BaseVarType.field29 = class25.method197(class176.indexSprites, "mod_icons", "");
            } else {
               ++var0;
            }

            if(var0 < 11) {
               class93.loadingText = "Loading sprites - " + var0 * 100 / 12 + "%";
               class93.loadingBarPercentage = 70;
            } else {
               FontTypeFace.modIcons = BaseVarType.field29;
               class141.mapedge.method5083();
               var1 = (int)(Math.random() * 21.0D) - 10;
               var2 = (int)(Math.random() * 21.0D) - 10;
               var3 = (int)(Math.random() * 21.0D) - 10;
               var4 = (int)(Math.random() * 41.0D) - 20;
               Client.field1001[0].method5078(var4 + var1, var4 + var2, var4 + var3);
               class93.loadingText = "Loaded sprites";
               class93.loadingBarPercentage = 70;
               Client.loadingStage = 90;
            }
         } else if(Client.loadingStage == 90) {
            if(!Tile.indexTextures.method4117()) {
               class93.loadingText = "Loading textures - " + Tile.indexTextures.method4226() + "%";
               class93.loadingBarPercentage = 90;
            } else {
               TextureProvider var27 = new TextureProvider(Tile.indexTextures, class176.indexSprites, 20, 0.8D, Client.lowMemory?64:128);
               Graphics3D.setTextureLoader(var27);
               Graphics3D.setBrightness(0.8D);
               class93.loadingText = "Loaded textures";
               class93.loadingBarPercentage = 90;
               Client.loadingStage = 110;
            }
         } else if(Client.loadingStage == 110) {
            class84.field1357 = new class72();
            GameEngine.taskManager.createRunnable(class84.field1357, 10);
            class93.loadingText = "Loaded input handler";
            class93.loadingBarPercentage = 94;
            Client.loadingStage = 120;
         } else if(Client.loadingStage == 120) {
            if(!MouseInput.field744.method4133("huffman", "")) {
               class93.loadingText = "Loading wordpack - " + 0 + "%";
               class93.loadingBarPercentage = 96;
            } else {
               Huffman var21 = new Huffman(MouseInput.field744.method4206("huffman", ""));
               SceneTilePaint.method2698(var21);
               class93.loadingText = "Loaded wordpack";
               class93.loadingBarPercentage = 96;
               Client.loadingStage = 130;
            }
         } else if(Client.loadingStage == 130) {
            if(!class83.field1337.method4117()) {
               class93.loadingText = "Loading interfaces - " + class83.field1337.method4226() * 4 / 5 + "%";
               class93.loadingBarPercentage = 100;
            } else if(!FrameMap.indexScripts.method4117()) {
               class93.loadingText = "Loading interfaces - " + (80 + FrameMap.indexScripts.method4226() / 6) + "%";
               class93.loadingBarPercentage = 100;
            } else if(!class262.field3617.method4117()) {
               class93.loadingText = "Loading interfaces - " + (96 + class262.field3617.method4226() / 50) + "%";
               class93.loadingBarPercentage = 100;
            } else {
               class93.loadingText = "Loaded interfaces";
               class93.loadingBarPercentage = 98;
               Client.loadingStage = 140;
            }
         } else if(Client.loadingStage == 140) {
            if(!VertexNormal.indexWorldMap.method4134(class40.field559.field551)) {
               class93.loadingText = "Loading world map - " + VertexNormal.indexWorldMap.method4136(class40.field559.field551) / 10 + "%";
            } else {
               if(class46.renderOverview == null) {
                  class46.renderOverview = new RenderOverview();
                  class46.renderOverview.method5280(VertexNormal.indexWorldMap, class61.field765, Client.field989, Client.field1001);
               }

               var0 = class46.renderOverview.method5228();
               if(var0 < 100) {
                  class93.loadingText = "Loading world map - " + (var0 * 9 / 10 + 10) + "%";
               } else {
                  class93.loadingText = "Loaded world map";
                  class93.loadingBarPercentage = 100;
                  Client.loadingStage = 150;
               }
            }
         } else if(Client.loadingStage == 150) {
            MouseInput.setGameState(10);
         }
      }
   }
}
