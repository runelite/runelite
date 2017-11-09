import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cx")
public class class100 {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lft;"
   )
   RSSocket field1468;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   CombatInfoList field1465;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 313570127
   )
   int field1472;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lfv;"
   )
   Buffer field1467;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   public ISAACCipher field1478;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   PacketBuffer field1469;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lfw;"
   )
   ServerPacket field1470;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 957088099
   )
   @Export("packetId")
   int packetId;
   @ObfuscatedName("b")
   boolean field1474;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 252930701
   )
   int field1475;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -2099798161
   )
   int field1466;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lfw;"
   )
   ServerPacket field1464;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lfw;"
   )
   ServerPacket field1476;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lfw;"
   )
   ServerPacket field1477;

   class100() {
      this.field1465 = new CombatInfoList();
      this.field1472 = 0;
      this.field1467 = new Buffer(5000);
      this.field1469 = new PacketBuffer(40000);
      this.field1470 = null;
      this.packetId = 0;
      this.field1474 = true;
      this.field1475 = 0;
      this.field1466 = 0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "5"
   )
   final void method1949() {
      this.field1465.method3736();
      this.field1472 = 0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "265169248"
   )
   final void method1958() throws IOException {
      if(this.field1468 != null && this.field1472 > 0) {
         this.field1467.offset = 0;

         while(true) {
            PacketNode var1 = (PacketNode)this.field1465.method3741();
            if(var1 == null || var1.field2426 > this.field1467.payload.length - this.field1467.offset) {
               this.field1468.queueForWrite(this.field1467.payload, 0, this.field1467.offset);
               this.field1466 = 0;
               break;
            }

            this.field1467.putBytes(var1.packetBuffer.payload, 0, var1.field2426);
            this.field1472 -= var1.field2426;
            var1.unlink();
            var1.packetBuffer.method3505();
            var1.method3193();
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lfg;B)V",
      garbageValue = "3"
   )
   public final void method1951(PacketNode var1) {
      this.field1465.method3749(var1);
      var1.field2426 = var1.packetBuffer.offset;
      var1.packetBuffer.offset = 0;
      this.field1472 += var1.field2426;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lft;I)V",
      garbageValue = "1969782925"
   )
   void method1952(RSSocket var1) {
      this.field1468 = var1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "497573931"
   )
   void method1970() {
      if(this.field1468 != null) {
         this.field1468.close();
         this.field1468 = null;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   void method1953() {
      this.field1468 = null;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Lft;",
      garbageValue = "-1669589735"
   )
   RSSocket method1954() {
      return this.field1468;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)[Ljw;",
      garbageValue = "187531318"
   )
   static class285[] method1969() {
      return new class285[]{class285.field3793, class285.field3786, class285.field3787};
   }

   @ObfuscatedName("fp")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1460882318"
   )
   @Export("load")
   static void load() {
      int var0;
      if(Client.loadingStage == 0) {
         class56.region = new Region(4, 104, 104, class61.tileHeights);

         for(var0 = 0; var0 < 4; ++var0) {
            Client.collisionMaps[var0] = new CollisionData(104, 104);
         }

         class39.field507 = new SpritePixels(512, 512);
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
               var2 = var1 * 32 + 15 + 128;
               var3 = var2 * 3 + 600;
               var4 = Graphics3D.SINE[var2];
               var37[var1] = var3 * var4 >> 16;
            }

            Region.method2816(var37, 500, 800, 512, 334);
            class91.loadingText = "Prepared visibility map";
            class91.loadingBarPercentage = 10;
            Client.loadingStage = 30;
         } else if(Client.loadingStage == 30) {
            Varcs.indexInterfaces = WallObject.openCacheIndex(0, false, true, true);
            class31.indexSoundEffects = WallObject.openCacheIndex(1, false, true, true);
            GrandExchangeOffer.configsIndex = WallObject.openCacheIndex(2, true, false, true);
            class149.field2115 = WallObject.openCacheIndex(3, false, true, true);
            Tile.field1838 = WallObject.openCacheIndex(4, false, true, true);
            class56.indexMaps = WallObject.openCacheIndex(5, true, true, true);
            class21.indexTrack1 = WallObject.openCacheIndex(6, true, true, false);
            class48.indexModels = WallObject.openCacheIndex(7, false, true, true);
            class96.indexSprites = WallObject.openCacheIndex(8, false, true, true);
            class12.indexTextures = WallObject.openCacheIndex(9, false, true, true);
            AbstractSoundSystem.field1563 = WallObject.openCacheIndex(10, false, true, true);
            class236.indexTrack2 = WallObject.openCacheIndex(11, false, true, true);
            class43.indexScripts = WallObject.openCacheIndex(12, false, true, true);
            class27.field382 = WallObject.openCacheIndex(13, true, false, true);
            WorldMapType2.vorbisIndex = WallObject.openCacheIndex(14, false, true, false);
            class177.field2452 = WallObject.openCacheIndex(15, false, true, true);
            RSCanvas.indexWorldMap = WallObject.openCacheIndex(16, false, true, false);
            class91.loadingText = "Connecting to update server";
            class91.loadingBarPercentage = 20;
            Client.loadingStage = 40;
         } else if(Client.loadingStage == 40) {
            byte var33 = 0;
            var0 = var33 + Varcs.indexInterfaces.percentage() * 4 / 100;
            var0 += class31.indexSoundEffects.percentage() * 4 / 100;
            var0 += GrandExchangeOffer.configsIndex.percentage() * 2 / 100;
            var0 += class149.field2115.percentage() * 2 / 100;
            var0 += Tile.field1838.percentage() * 6 / 100;
            var0 += class56.indexMaps.percentage() * 4 / 100;
            var0 += class21.indexTrack1.percentage() * 2 / 100;
            var0 += class48.indexModels.percentage() * 58 / 100;
            var0 += class96.indexSprites.percentage() * 2 / 100;
            var0 += class12.indexTextures.percentage() * 2 / 100;
            var0 += AbstractSoundSystem.field1563.percentage() * 2 / 100;
            var0 += class236.indexTrack2.percentage() * 2 / 100;
            var0 += class43.indexScripts.percentage() * 2 / 100;
            var0 += class27.field382.percentage() * 2 / 100;
            var0 += WorldMapType2.vorbisIndex.percentage() * 2 / 100;
            var0 += class177.field2452.percentage() * 2 / 100;
            var0 += RSCanvas.indexWorldMap.percentage() * 2 / 100;
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
         } else if(Client.loadingStage == 45) {
            class15.method109(22050, !Client.lowMemory, 2);
            class211 var36 = new class211();
            var36.method3862(9, 128);
            class3.soundSystem0 = FrameMap.method2779(GameEngine.taskManager, 0, 22050);
            class3.soundSystem0.method2105(var36);
            class25.method201(class177.field2452, WorldMapType2.vorbisIndex, Tile.field1838, var36);
            class13.soundSystem1 = FrameMap.method2779(GameEngine.taskManager, 1, 2048);
            class268.field3675 = new class101();
            class13.soundSystem1.method2105(class268.field3675);
            class231.field2920 = new class115(22050, AbstractSoundSystem.sampleRate);
            class91.loadingText = "Prepared sound engine";
            class91.loadingBarPercentage = 35;
            Client.loadingStage = 50;
            class47.field581 = new class269(class96.indexSprites, class27.field382);
         } else if(Client.loadingStage == 50) {
            var0 = class268.method4911().length;
            Client.field915 = class47.field581.method4915(class268.method4911());
            if(Client.field915.size() < var0) {
               class91.loadingText = "Loading fonts - " + Client.field915.size() * 100 / var0 + "%";
               class91.loadingBarPercentage = 40;
            } else {
               class47.field580 = (Font)Client.field915.get(class268.field3677);
               class48.font_p12full = (Font)Client.field915.get(class268.field3673);
               class20.field320 = (Font)Client.field915.get(class268.field3678);
               CombatInfo1.field1203 = new MachineInfo(true);
               class91.loadingText = "Loaded fonts";
               class91.loadingBarPercentage = 40;
               Client.loadingStage = 60;
            }
         } else if(Client.loadingStage == 60) {
            var0 = Timer.method3091(AbstractSoundSystem.field1563, class96.indexSprites);
            byte var32 = 11;
            if(var0 < var32) {
               class91.loadingText = "Loading title screen - " + var0 * 100 / var32 + "%";
               class91.loadingBarPercentage = 50;
            } else {
               class91.loadingText = "Loaded title screen";
               class91.loadingBarPercentage = 50;
               class287.setGameState(5);
               Client.loadingStage = 70;
            }
         } else if(Client.loadingStage == 70) {
            if(!GrandExchangeOffer.configsIndex.method4283()) {
               class91.loadingText = "Loading config - " + GrandExchangeOffer.configsIndex.method4392() + "%";
               class91.loadingBarPercentage = 60;
            } else {
               class246.method4441(GrandExchangeOffer.configsIndex);
               IndexData var35 = GrandExchangeOffer.configsIndex;
               FloorUnderlayDefinition.underlay_ref = var35;
               IndexData var28 = GrandExchangeOffer.configsIndex;
               IndexData var29 = class48.indexModels;
               KitDefinition.identKit_ref = var28;
               KitDefinition.field3409 = var29;
               KitDefinition.field3407 = KitDefinition.identKit_ref.fileCount(3);
               IndexData var30 = GrandExchangeOffer.configsIndex;
               IndexData var31 = class48.indexModels;
               boolean var5 = Client.lowMemory;
               ObjectComposition.objects_ref = var30;
               ObjectComposition.field3488 = var31;
               ObjectComposition.field3530 = var5;
               IndexData var6 = GrandExchangeOffer.configsIndex;
               IndexData var7 = class48.indexModels;
               NPCComposition.field3615 = var6;
               NPCComposition.field3604 = var7;
               class22.method189(GrandExchangeOffer.configsIndex);
               IndexData var8 = GrandExchangeOffer.configsIndex;
               IndexData var9 = class48.indexModels;
               boolean var10 = Client.isMembers;
               Font var11 = class47.field580;
               ItemComposition.item_ref = var8;
               ItemComposition.field3538 = var9;
               class246.isMembersWorld = var10;
               ItemComposition.field3543 = ItemComposition.item_ref.fileCount(10);
               ItemComposition.field3547 = var11;
               IndexData var12 = GrandExchangeOffer.configsIndex;
               IndexData var13 = Varcs.indexInterfaces;
               IndexData var14 = class31.indexSoundEffects;
               class3.seq_ref = var12;
               Sequence.skel_ref = var13;
               Sequence.skin_ref = var14;
               class176.method3252(GrandExchangeOffer.configsIndex, class48.indexModels);
               class24.method199(GrandExchangeOffer.configsIndex);
               IndexData var15 = GrandExchangeOffer.configsIndex;
               class51.varplayer_ref = var15;
               VarPlayerType.field3344 = class51.varplayer_ref.fileCount(16);
               IndexData var16 = class149.field2115;
               IndexData var17 = class48.indexModels;
               IndexData var18 = class96.indexSprites;
               IndexData var19 = class27.field382;
               class46.widgetIndex = var16;
               Widget.field2718 = var17;
               class27.field386 = var18;
               Widget.field2719 = var19;
               class243.widgets = new Widget[class46.widgetIndex.size()][];
               class8.validInterfaces = new boolean[class46.widgetIndex.size()];
               IndexData var20 = GrandExchangeOffer.configsIndex;
               InvType.field3340 = var20;
               IndexData var21 = GrandExchangeOffer.configsIndex;
               Enum.field3456 = var21;
               class230.method4240(GrandExchangeOffer.configsIndex);
               class175.method3248(GrandExchangeOffer.configsIndex);
               IndexData var22 = GrandExchangeOffer.configsIndex;
               class258.field3446 = var22;
               class1.chatMessages = new Varcs();
               Friend.method1150(GrandExchangeOffer.configsIndex, class96.indexSprites, class27.field382);
               class139.method2965(GrandExchangeOffer.configsIndex, class96.indexSprites);
               IndexData var23 = GrandExchangeOffer.configsIndex;
               IndexData var24 = class96.indexSprites;
               Area.field3365 = var24;
               if(var23.method4283()) {
                  Area.field3350 = var23.fileCount(35);
                  Area.field3358 = new Area[Area.field3350];

                  for(int var25 = 0; var25 < Area.field3350; ++var25) {
                     byte[] var26 = var23.getConfigData(35, var25);
                     if(var26 != null) {
                        Area.field3358[var25] = new Area(var25);
                        Area.field3358[var25].method4466(new Buffer(var26));
                        Area.field3358[var25].method4468();
                     }
                  }
               }

               class91.loadingText = "Loaded config";
               class91.loadingBarPercentage = 60;
               Client.loadingStage = 80;
            }
         } else if(Client.loadingStage == 80) {
            var0 = 0;
            if(class3.compass == null) {
               class3.compass = class224.method4213(class96.indexSprites, "compass", "");
            } else {
               ++var0;
            }

            if(class36.mapedge == null) {
               class36.mapedge = class224.method4213(class96.indexSprites, "mapedge", "");
            } else {
               ++var0;
            }

            if(BuildType.mapscene == null) {
               BuildType.mapscene = class150.method3023(class96.indexSprites, "mapscene", "");
            } else {
               ++var0;
            }

            if(CacheFile.headIconsPk == null) {
               CacheFile.headIconsPk = Buffer.method3496(class96.indexSprites, "headicons_pk", "");
            } else {
               ++var0;
            }

            if(class72.headIconsPrayer == null) {
               class72.headIconsPrayer = Buffer.method3496(class96.indexSprites, "headicons_prayer", "");
            } else {
               ++var0;
            }

            if(class229.headIconsHint == null) {
               class229.headIconsHint = Buffer.method3496(class96.indexSprites, "headicons_hint", "");
            } else {
               ++var0;
            }

            if(Ignore.mapMarkers == null) {
               Ignore.mapMarkers = Buffer.method3496(class96.indexSprites, "mapmarker", "");
            } else {
               ++var0;
            }

            if(CombatInfoListHolder.field1287 == null) {
               CombatInfoListHolder.field1287 = Buffer.method3496(class96.indexSprites, "cross", "");
            } else {
               ++var0;
            }

            if(class8.mapDots == null) {
               class8.mapDots = Buffer.method3496(class96.indexSprites, "mapdots", "");
            } else {
               ++var0;
            }

            if(class51.field627 == null) {
               class51.field627 = class150.method3023(class96.indexSprites, "scrollbar", "");
            } else {
               ++var0;
            }

            if(Buffer.field2500 == null) {
               Buffer.field2500 = class150.method3023(class96.indexSprites, "mod_icons", "");
            } else {
               ++var0;
            }

            if(var0 < 11) {
               class91.loadingText = "Loading sprites - " + var0 * 100 / 12 + "%";
               class91.loadingBarPercentage = 70;
            } else {
               FontTypeFace.modIcons = Buffer.field2500;
               class36.mapedge.method5279();
               var1 = (int)(Math.random() * 21.0D) - 10;
               var2 = (int)(Math.random() * 21.0D) - 10;
               var3 = (int)(Math.random() * 21.0D) - 10;
               var4 = (int)(Math.random() * 41.0D) - 20;
               BuildType.mapscene[0].method5245(var4 + var1, var2 + var4, var4 + var3);
               class91.loadingText = "Loaded sprites";
               class91.loadingBarPercentage = 70;
               Client.loadingStage = 90;
            }
         } else if(Client.loadingStage == 90) {
            if(!class12.indexTextures.method4283()) {
               class91.loadingText = "Loading textures - " + class12.indexTextures.method4392() + "%";
               class91.loadingBarPercentage = 90;
            } else {
               TextureProvider var34 = new TextureProvider(class12.indexTextures, class96.indexSprites, 20, 0.8D, Client.lowMemory?64:128);
               Graphics3D.setTextureLoader(var34);
               Graphics3D.setBrightness(0.8D);
               class91.loadingText = "Loaded textures";
               class91.loadingBarPercentage = 90;
               Client.loadingStage = 110;
            }
         } else if(Client.loadingStage == 110) {
            class5.field31 = new class70();
            GameEngine.taskManager.createRunnable(class5.field31, 10);
            class91.loadingText = "Loaded input handler";
            class91.loadingBarPercentage = 92;
            Client.loadingStage = 120;
         } else if(Client.loadingStage == 120) {
            if(!AbstractSoundSystem.field1563.method4295("huffman", "")) {
               class91.loadingText = "Loading wordpack - " + 0 + "%";
               class91.loadingBarPercentage = 94;
            } else {
               Huffman var27 = new Huffman(AbstractSoundSystem.field1563.method4308("huffman", ""));
               class272.field3717 = var27;
               class91.loadingText = "Loaded wordpack";
               class91.loadingBarPercentage = 94;
               Client.loadingStage = 130;
            }
         } else if(Client.loadingStage == 130) {
            if(!class149.field2115.method4283()) {
               class91.loadingText = "Loading interfaces - " + class149.field2115.method4392() * 4 / 5 + "%";
               class91.loadingBarPercentage = 96;
            } else if(!class43.indexScripts.method4283()) {
               class91.loadingText = "Loading interfaces - " + (80 + class43.indexScripts.method4392() / 6) + "%";
               class91.loadingBarPercentage = 96;
            } else if(!class27.field382.method4283()) {
               class91.loadingText = "Loading interfaces - " + (96 + class27.field382.method4392() / 50) + "%";
               class91.loadingBarPercentage = 96;
            } else {
               class91.loadingText = "Loaded interfaces";
               class91.loadingBarPercentage = 98;
               Client.loadingStage = 140;
            }
         } else if(Client.loadingStage == 140) {
            class91.loadingBarPercentage = 100;
            if(!RSCanvas.indexWorldMap.method4300(class40.field514.field512)) {
               class91.loadingText = "Loading world map - " + RSCanvas.indexWorldMap.method4323(class40.field514.field512) / 10 + "%";
            } else {
               if(Client.renderOverview == null) {
                  Client.renderOverview = new RenderOverview();
                  Client.renderOverview.method5413(RSCanvas.indexWorldMap, class20.field320, Client.field915, BuildType.mapscene);
               }

               var0 = Client.renderOverview.method5474();
               if(var0 < 100) {
                  class91.loadingText = "Loading world map - " + (var0 * 9 / 10 + 10) + "%";
               } else {
                  class91.loadingText = "Loaded world map";
                  Client.loadingStage = 150;
               }
            }
         } else if(Client.loadingStage == 150) {
            class287.setGameState(10);
         }
      }
   }
}
