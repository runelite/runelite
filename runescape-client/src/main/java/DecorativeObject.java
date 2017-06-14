import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ez")
@Implements("DecorativeObject")
public final class DecorativeObject {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -379531649
   )
   @Export("x")
   int x;
   @ObfuscatedName("h")
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -153226405
   )
   @Export("renderFlag")
   int renderFlag;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 65207471
   )
   @Export("rotation")
   int rotation;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1301838097
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1657842287
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("z")
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("v")
   static int[] field2184;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1758039725
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -670583549
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1410479593
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1543829445
   )
   @Export("y")
   int y;

   @ObfuscatedName("ez")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-104"
   )
   static void method2903() {
      int var0;
      if(Client.field981 == 0) {
         class61.region = new Region(4, 104, 104, class61.tileHeights);

         for(var0 = 0; var0 < 4; ++var0) {
            Client.collisionMaps[var0] = new CollisionData(104, 104);
         }

         TextureProvider.field1787 = new SpritePixels(512, 512);
         class92.field1433 = "Starting game engine...";
         class92.field1416 = 5;
         Client.field981 = 20;
      } else {
         int var1;
         int var2;
         int var3;
         int var4;
         if(Client.field981 == 20) {
            int[] var38 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var2 = var1 * 32 + 128 + 15;
               var3 = var2 * 3 + 600;
               var4 = class136.SINE[var2];
               var38[var1] = var4 * var3 >> 16;
            }

            Region.method2710(var38, 500, 800, 512, 334);
            class92.field1433 = "Prepared visibility map";
            class92.field1416 = 10;
            Client.field981 = 30;
         } else if(Client.field981 == 30) {
            class69.indexInterfaces = class220.method4085(0, false, true, true);
            Client.indexSoundEffects = class220.method4085(1, false, true, true);
            NPC.field1374 = class220.method4085(2, true, false, true);
            XItemContainer.field765 = class220.method4085(3, false, true, true);
            RSCanvas.field655 = class220.method4085(4, false, true, true);
            class77.indexMaps = class220.method4085(5, true, true, true);
            class54.indexTrack1 = class220.method4085(6, true, true, false);
            class23.indexModels = class220.method4085(7, false, true, true);
            Client.indexSprites = class220.method4085(8, false, true, true);
            Player.indexTextures = class220.method4085(9, false, true, true);
            class22.field353 = class220.method4085(10, false, true, true);
            IndexData.indexTrack2 = class220.method4085(11, false, true, true);
            GroundObject.indexScripts = class220.method4085(12, false, true, true);
            FileSystem.field3207 = class220.method4085(13, true, false, true);
            class61.field753 = class220.method4085(14, false, true, false);
            class14.field291 = class220.method4085(15, false, true, true);
            class21.indexWorldMap = class220.method4085(16, false, true, false);
            class92.field1433 = "Connecting to update server";
            class92.field1416 = 20;
            Client.field981 = 40;
         } else if(Client.field981 == 40) {
            byte var35 = 0;
            var0 = var35 + class69.indexInterfaces.method4252() * 4 / 100;
            var0 += Client.indexSoundEffects.method4252() * 4 / 100;
            var0 += NPC.field1374.method4252() * 2 / 100;
            var0 += XItemContainer.field765.method4252() * 2 / 100;
            var0 += RSCanvas.field655.method4252() * 6 / 100;
            var0 += class77.indexMaps.method4252() * 4 / 100;
            var0 += class54.indexTrack1.method4252() * 2 / 100;
            var0 += class23.indexModels.method4252() * 58 / 100;
            var0 += Client.indexSprites.method4252() * 2 / 100;
            var0 += Player.indexTextures.method4252() * 2 / 100;
            var0 += class22.field353.method4252() * 2 / 100;
            var0 += IndexData.indexTrack2.method4252() * 2 / 100;
            var0 += GroundObject.indexScripts.method4252() * 2 / 100;
            var0 += FileSystem.field3207.method4252() * 2 / 100;
            var0 += class61.field753.method4252() * 2 / 100;
            var0 += class14.field291.method4252() * 2 / 100;
            var0 += class21.indexWorldMap.method4252() * 2 / 100;
            if(var0 != 100) {
               if(var0 != 0) {
                  class92.field1433 = "Checking for updates - " + var0 + "%";
               }

               class92.field1416 = 30;
            } else {
               class92.field1433 = "Loaded update list";
               class92.field1416 = 30;
               Client.field981 = 45;
            }
         } else {
            IndexData var28;
            IndexData var29;
            IndexData var31;
            if(Client.field981 == 45) {
               boolean var34 = !Client.field918;
               class109.field1633 = 22050;
               class109.field1630 = var34;
               class71.field852 = 2;
               class204 var40 = new class204();
               var40.method3717(9, 128);
               RSSocket.field2287 = class154.method2957(GameEngine.field678, 0, 22050);
               RSSocket.field2287.method1997(var40);
               var31 = class14.field291;
               var28 = class61.field753;
               var29 = RSCanvas.field655;
               class203.field2514 = var31;
               class203.field2512 = var28;
               class203.field2513 = var29;
               class203.field2517 = var40;
               class154.field2250 = class154.method2957(GameEngine.field678, 1, 2048);
               WorldMapType0.field613 = new class102();
               class154.field2250.method1997(WorldMapType0.field613);
               class165.field2334 = new class116(22050, class109.field1633);
               class92.field1433 = "Prepared sound engine";
               class92.field1416 = 35;
               Client.field981 = 50;
               class34.field494 = new class262(Client.indexSprites, FileSystem.field3207);
            } else if(Client.field981 == 50) {
               var0 = class261.method4760().length;
               Client.field914 = class34.field494.method4768(class261.method4760());
               if(Client.field914.size() < var0) {
                  class92.field1433 = "Loading fonts - " + Client.field914.size() * 100 / var0 + "%";
                  class92.field1416 = 40;
               } else {
                  class261.field3629 = (Font)Client.field914.get(class261.field3627);
                  WidgetNode.font_p12full = (Font)Client.field914.get(class261.field3635);
                  class241.field3288 = (Font)Client.field914.get(class261.field3628);
                  class230.field3183 = new class291(true);
                  class92.field1433 = "Loaded fonts";
                  class92.field1416 = 40;
                  Client.field981 = 60;
               }
            } else {
               IndexData var39;
               if(Client.field981 == 60) {
                  var39 = class22.field353;
                  var31 = Client.indexSprites;
                  var3 = 0;
                  if(var39.method4145("title.jpg", "")) {
                     ++var3;
                  }

                  if(var31.method4145("logo", "")) {
                     ++var3;
                  }

                  if(var31.method4145("logo_deadman_mode", "")) {
                     ++var3;
                  }

                  if(var31.method4145("titlebox", "")) {
                     ++var3;
                  }

                  if(var31.method4145("titlebutton", "")) {
                     ++var3;
                  }

                  if(var31.method4145("runes", "")) {
                     ++var3;
                  }

                  if(var31.method4145("title_mute", "")) {
                     ++var3;
                  }

                  if(var31.method4145("options_radio_buttons,0", "")) {
                     ++var3;
                  }

                  if(var31.method4145("options_radio_buttons,2", "")) {
                     ++var3;
                  }

                  var31.method4145("sl_back", "");
                  var31.method4145("sl_flags", "");
                  var31.method4145("sl_arrows", "");
                  var31.method4145("sl_stars", "");
                  var31.method4145("sl_button", "");
                  byte var33 = 9;
                  if(var3 < var33) {
                     class92.field1433 = "Loading title screen - " + var3 * 100 / var33 + "%";
                     class92.field1416 = 50;
                  } else {
                     class92.field1433 = "Loaded title screen";
                     class92.field1416 = 50;
                     class3.setGameState(5);
                     Client.field981 = 70;
                  }
               } else if(Client.field981 == 70) {
                  if(!NPC.field1374.method4197()) {
                     class92.field1433 = "Loading config - " + NPC.field1374.method4253() + "%";
                     class92.field1416 = 60;
                  } else {
                     class151.method2927(NPC.field1374);
                     IndexData var37 = NPC.field1374;
                     FloorUnderlayDefinition.field3344 = var37;
                     var39 = NPC.field1374;
                     var31 = class23.indexModels;
                     KitDefinition.field3357 = var39;
                     KitDefinition.field3352 = var31;
                     KitDefinition.field3353 = KitDefinition.field3357.method4174(3);
                     class154.method2956(NPC.field1374, class23.indexModels, Client.field918);
                     class82.method1575(NPC.field1374, class23.indexModels);
                     var28 = NPC.field1374;
                     class252.field3401 = var28;
                     var29 = NPC.field1374;
                     IndexData var32 = class23.indexModels;
                     boolean var6 = Client.isMembers;
                     Font var7 = class261.field3629;
                     class56.field665 = var29;
                     ItemComposition.field3498 = var32;
                     ItemComposition.isMembersWorld = var6;
                     ItemComposition.field3500 = class56.field665.method4174(10);
                     CombatInfo1.field1292 = var7;
                     IndexData var8 = NPC.field1374;
                     IndexData var9 = class69.indexInterfaces;
                     IndexData var10 = Client.indexSoundEffects;
                     Sequence.field3610 = var8;
                     Sequence.field3608 = var9;
                     Sequence.field3609 = var10;
                     class158.method2982(NPC.field1374, class23.indexModels);
                     class164.method3070(NPC.field1374);
                     IndexData var11 = NPC.field1374;
                     class241.field3291 = var11;
                     class241.field3289 = class241.field3291.method4174(16);
                     IndexData var12 = XItemContainer.field765;
                     IndexData var13 = class23.indexModels;
                     IndexData var14 = Client.indexSprites;
                     IndexData var15 = FileSystem.field3207;
                     Widget.field2736 = var12;
                     Widget.field2644 = var13;
                     Widget.field2645 = var14;
                     class12.field272 = var15;
                     Widget.widgets = new Widget[Widget.field2736.method4215()][];
                     FileOnDisk.validInterfaces = new boolean[Widget.field2736.method4215()];
                     IndexData var16 = NPC.field1374;
                     class240.field3283 = var16;
                     class221.method4091(NPC.field1374);
                     IndexData var17 = NPC.field1374;
                     class243.field3318 = var17;
                     RSCanvas.method762(NPC.field1374);
                     class56.method800(NPC.field1374);
                     Tile.chatMessages = new ChatMessages();
                     IndexData var18 = NPC.field1374;
                     IndexData var19 = Client.indexSprites;
                     IndexData var20 = FileSystem.field3207;
                     class254.field3430 = var18;
                     class254.field3437 = var19;
                     class2.field20 = var20;
                     IndexData var21 = NPC.field1374;
                     IndexData var22 = Client.indexSprites;
                     CombatInfo2.field3373 = var21;
                     class5.field40 = var22;
                     IndexData var23 = NPC.field1374;
                     IndexData var24 = Client.indexSprites;
                     Area.field3298 = var24;
                     if(var23.method4197()) {
                        ISAACCipher.field2442 = var23.method4174(35);
                        World.field1300 = new Area[ISAACCipher.field2442];

                        for(int var25 = 0; var25 < ISAACCipher.field2442; ++var25) {
                           byte[] var26 = var23.getConfigData(35, var25);
                           if(var26 != null) {
                              World.field1300[var25] = new Area(var25);
                              World.field1300[var25].method4310(new Buffer(var26));
                              World.field1300[var25].method4312();
                           }
                        }
                     }

                     class92.field1433 = "Loaded config";
                     class92.field1416 = 60;
                     Client.field981 = 80;
                  }
               } else if(Client.field981 == 80) {
                  var0 = 0;
                  SpritePixels var30;
                  if(ChatLineBuffer.field1558 == null) {
                     var31 = Client.indexSprites;
                     var3 = var31.method4141("compass");
                     var4 = var31.method4209(var3, "");
                     var30 = WallObject.method2876(var31, var3, var4);
                     ChatLineBuffer.field1558 = var30;
                  } else {
                     ++var0;
                  }

                  if(class44.field577 == null) {
                     var31 = Client.indexSprites;
                     var3 = var31.method4141("mapedge");
                     var4 = var31.method4209(var3, "");
                     var30 = WallObject.method2876(var31, var3, var4);
                     class44.field577 = var30;
                  } else {
                     ++var0;
                  }

                  if(class73.field864 == null) {
                     class73.field864 = class41.method582(Client.indexSprites, "mapscene", "");
                  } else {
                     ++var0;
                  }

                  if(WorldMapType3.field396 == null) {
                     WorldMapType3.field396 = class271.method4937(Client.indexSprites, "headicons_pk", "");
                  } else {
                     ++var0;
                  }

                  if(class15.field297 == null) {
                     class15.field297 = class271.method4937(Client.indexSprites, "headicons_prayer", "");
                  } else {
                     ++var0;
                  }

                  if(class60.field732 == null) {
                     class60.field732 = class271.method4937(Client.indexSprites, "headicons_hint", "");
                  } else {
                     ++var0;
                  }

                  if(World.field1310 == null) {
                     World.field1310 = class271.method4937(Client.indexSprites, "mapmarker", "");
                  } else {
                     ++var0;
                  }

                  if(class73.field867 == null) {
                     class73.field867 = class271.method4937(Client.indexSprites, "cross", "");
                  } else {
                     ++var0;
                  }

                  if(Frames.field2151 == null) {
                     Frames.field2151 = class271.method4937(Client.indexSprites, "mapdots", "");
                  } else {
                     ++var0;
                  }

                  if(GameEngine.field707 == null) {
                     GameEngine.field707 = class41.method582(Client.indexSprites, "scrollbar", "");
                  } else {
                     ++var0;
                  }

                  if(class7.field233 == null) {
                     class7.field233 = class41.method582(Client.indexSprites, "mod_icons", "");
                  } else {
                     ++var0;
                  }

                  if(var0 < 11) {
                     class92.field1433 = "Loading sprites - " + var0 * 100 / 12 + "%";
                     class92.field1416 = 70;
                  } else {
                     FontTypeFace.modIcons = class7.field233;
                     class44.field577.method5090();
                     var1 = (int)(Math.random() * 21.0D) - 10;
                     var2 = (int)(Math.random() * 21.0D) - 10;
                     var3 = (int)(Math.random() * 21.0D) - 10;
                     var4 = (int)(Math.random() * 41.0D) - 20;
                     class73.field864[0].method5064(var1 + var4, var4 + var2, var3 + var4);
                     class92.field1433 = "Loaded sprites";
                     class92.field1416 = 70;
                     Client.field981 = 90;
                  }
               } else if(Client.field981 == 90) {
                  if(!Player.indexTextures.method4197()) {
                     class92.field1433 = "Loading textures - " + Player.indexTextures.method4253() + "%";
                     class92.field1416 = 90;
                  } else {
                     TextureProvider var36 = new TextureProvider(Player.indexTextures, Client.indexSprites, 20, 0.8D, Client.field918?64:128);
                     class136.method2658(var36);
                     class136.method2599(0.8D);
                     class92.field1433 = "Loaded textures";
                     class92.field1416 = 90;
                     Client.field981 = 110;
                  }
               } else if(Client.field981 == 110) {
                  WorldMapType1.field443 = new class71();
                  GameEngine.field678.method2937(WorldMapType1.field443, 10);
                  class92.field1433 = "Loaded input handler";
                  class92.field1416 = 94;
                  Client.field981 = 120;
               } else if(Client.field981 == 120) {
                  if(!class22.field353.method4145("huffman", "")) {
                     class92.field1433 = "Loading wordpack - " + 0 + "%";
                     class92.field1416 = 96;
                  } else {
                     class165 var27 = new class165(class22.field353.method4144("huffman", ""));
                     class265.field3670 = var27;
                     class92.field1433 = "Loaded wordpack";
                     class92.field1416 = 96;
                     Client.field981 = 130;
                  }
               } else if(Client.field981 == 130) {
                  if(!XItemContainer.field765.method4197()) {
                     class92.field1433 = "Loading interfaces - " + XItemContainer.field765.method4253() * 4 / 5 + "%";
                     class92.field1416 = 100;
                  } else if(!GroundObject.indexScripts.method4197()) {
                     class92.field1433 = "Loading interfaces - " + (GroundObject.indexScripts.method4253() / 6 + 80) + "%";
                     class92.field1416 = 100;
                  } else if(!FileSystem.field3207.method4197()) {
                     class92.field1433 = "Loading interfaces - " + (FileSystem.field3207.method4253() / 50 + 96) + "%";
                     class92.field1416 = 100;
                  } else {
                     class92.field1433 = "Loaded interfaces";
                     class92.field1416 = 98;
                     Client.field981 = 140;
                  }
               } else if(Client.field981 == 140) {
                  if(!class21.indexWorldMap.method4148(class40.field540.field543)) {
                     class92.field1433 = "Loading world map - " + class21.indexWorldMap.method4172(class40.field540.field543) / 10 + "%";
                  } else {
                     if(FaceNormal.field2146 == null) {
                        FaceNormal.field2146 = new RenderOverview();
                        FaceNormal.field2146.method5218(class21.indexWorldMap, class241.field3288, Client.field914, class73.field864);
                     }

                     var0 = FaceNormal.field2146.method5346();
                     if(var0 < 100) {
                        class92.field1433 = "Loading world map - " + (var0 * 9 / 10 + 10) + "%";
                     } else {
                        class92.field1433 = "Loaded world map";
                        class92.field1416 = 100;
                        Client.field981 = 150;
                     }
                  }
               } else if(Client.field981 == 150) {
                  class3.setGameState(10);
               }
            }
         }
      }
   }

   DecorativeObject() {
      this.hash = 0;
      this.renderInfoBitPacked = 0;
   }
}
