import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
public class class24 {
   @ObfuscatedName("ph")
   @ObfuscatedGetter(
      intValue = 464519875
   )
   static int field372;
   @ObfuscatedName("m")
   public static final class24 field373;
   @ObfuscatedName("e")
   public static final class24 field374;
   @ObfuscatedName("t")
   final String field375;
   @ObfuscatedName("cn")
   public static char field376;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 2048776615
   )
   final int field377;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1275699133
   )
   final int field378;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 32895513
   )
   final int field379;
   @ObfuscatedName("p")
   public static final class24 field381;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1908902507
   )
   @Export("scriptStringStackSize")
   static int scriptStringStackSize;
   @ObfuscatedName("js")
   @ObfuscatedGetter(
      intValue = 1992175919
   )
   @Export("menuY")
   static int menuY;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(FI)Z",
      garbageValue = "709698254"
   )
   boolean method191(float var1) {
      return var1 >= (float)this.field378;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Lclass24;",
      garbageValue = "-1506223167"
   )
   static class24 method193(int var0) {
      class24[] var1 = new class24[]{field373, field381, field374};
      class24[] var2 = var1;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class24 var4 = var2[var3];
         if(var0 == var4.field377) {
            return var4;
         }
      }

      return null;
   }

   static {
      field381 = new class24("SMALL", 2, 0, 4);
      field373 = new class24("MEDIUM", 1, 1, 2);
      field374 = new class24("LARGE", 0, 2, 0);
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;III)V",
      garbageValue = "4"
   )
   class24(String var1, int var2, int var3, int var4) {
      this.field375 = var1;
      this.field379 = var2;
      this.field377 = var3;
      this.field378 = var4;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;IZI)LFrames;",
      garbageValue = "1901295118"
   )
   public static Frames method197(IndexDataBase var0, IndexDataBase var1, int var2, boolean var3) {
      boolean var4 = true;
      int[] var5 = var0.method4005(var2);

      for(int var6 = 0; var6 < var5.length; ++var6) {
         byte[] var7 = var0.method4002(var2, var5[var6]);
         if(var7 == null) {
            var4 = false;
         } else {
            int var8 = (var7[0] & 255) << 8 | var7[1] & 255;
            byte[] var9 = var1.method4002(var8, 0);
            if(var9 == null) {
               var4 = false;
            }
         }
      }

      if(!var4) {
         return null;
      } else {
         try {
            return new Frames(var0, var1, var2, var3);
         } catch (Exception var11) {
            return null;
         }
      }
   }

   @ObfuscatedName("ef")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1899723856"
   )
   static void method198() {
      int var0;
      if(Client.field921 == 0) {
         class17.region = new Region(4, 104, 104, class61.tileHeights);

         for(var0 = 0; var0 < 4; ++var0) {
            Client.collisionMaps[var0] = new CollisionData(104, 104);
         }

         Actor.field1268 = new SpritePixels(512, 512);
         class92.field1446 = "Starting game engine...";
         class92.field1429 = 5;
         Client.field921 = 20;
      } else {
         int var1;
         int var2;
         int var3;
         int var4;
         if(Client.field921 != 20) {
            if(Client.field921 == 30) {
               Client.indexInterfaces = RSSocket.method2891(0, false, true, true);
               Client.indexSoundEffects = RSSocket.method2891(1, false, true, true);
               class3.field24 = RSSocket.method2891(2, true, false, true);
               class9.field255 = RSSocket.method2891(3, false, true, true);
               class66.field799 = RSSocket.method2891(4, false, true, true);
               class177.indexMaps = RSSocket.method2891(5, true, true, true);
               FaceNormal.indexTrack1 = RSSocket.method2891(6, true, true, false);
               class4.indexModels = RSSocket.method2891(7, false, true, true);
               WorldMapType3.indexSprites = RSSocket.method2891(8, false, true, true);
               class17.indexTextures = RSSocket.method2891(9, false, true, true);
               FileOnDisk.field1763 = RSSocket.method2891(10, false, true, true);
               class11.indexTrack2 = RSSocket.method2891(11, false, true, true);
               class69.indexScripts = RSSocket.method2891(12, false, true, true);
               class33.field476 = RSSocket.method2891(13, true, false, true);
               class219.field2807 = RSSocket.method2891(14, false, true, false);
               class164.field2329 = RSSocket.method2891(15, false, true, true);
               class3.indexWorldMap = RSSocket.method2891(16, false, true, false);
               class92.field1446 = "Connecting to update server";
               class92.field1429 = 20;
               Client.field921 = 40;
            } else if(Client.field921 == 40) {
               byte var23 = 0;
               var0 = var23 + Client.indexInterfaces.method4095() * 4 / 100;
               var0 += Client.indexSoundEffects.method4095() * 4 / 100;
               var0 += class3.field24.method4095() * 2 / 100;
               var0 += class9.field255.method4095() * 2 / 100;
               var0 += class66.field799.method4095() * 6 / 100;
               var0 += class177.indexMaps.method4095() * 4 / 100;
               var0 += FaceNormal.indexTrack1.method4095() * 2 / 100;
               var0 += class4.indexModels.method4095() * 58 / 100;
               var0 += WorldMapType3.indexSprites.method4095() * 2 / 100;
               var0 += class17.indexTextures.method4095() * 2 / 100;
               var0 += FileOnDisk.field1763.method4095() * 2 / 100;
               var0 += class11.indexTrack2.method4095() * 2 / 100;
               var0 += class69.indexScripts.method4095() * 2 / 100;
               var0 += class33.field476.method4095() * 2 / 100;
               var0 += class219.field2807.method4095() * 2 / 100;
               var0 += class164.field2329.method4095() * 2 / 100;
               var0 += class3.indexWorldMap.method4095() * 2 / 100;
               if(var0 != 100) {
                  if(var0 != 0) {
                     class92.field1446 = "Checking for updates - " + var0 + "%";
                  }

                  class92.field1429 = 30;
               } else {
                  class92.field1446 = "Loaded update list";
                  class92.field1429 = 30;
                  Client.field921 = 45;
               }
            } else {
               IndexData var19;
               IndexData var20;
               IndexData var21;
               if(Client.field921 == 45) {
                  class90.method1618(22050, !Client.field1055, 2);
                  class204 var28 = new class204();
                  var28.method3689(9, 128);
                  class134.field2003 = class41.method573(GameEngine.field691, 0, 22050);
                  class134.field2003.method1938(var28);
                  var19 = class164.field2329;
                  var20 = class219.field2807;
                  var21 = class66.field799;
                  class203.field2513 = var19;
                  class203.field2514 = var20;
                  class203.field2515 = var21;
                  class203.field2516 = var28;
                  Player.field862 = class41.method573(GameEngine.field691, 1, 2048);
                  WorldMapType1.field442 = new class102();
                  Player.field862.method1938(WorldMapType1.field442);
                  class59.field724 = new class116(22050, class109.field1635);
                  class92.field1446 = "Prepared sound engine";
                  class92.field1429 = 35;
                  Client.field921 = 50;
                  class69.field820 = new class262(WorldMapType3.indexSprites, class33.field476);
               } else if(Client.field921 == 50) {
                  class261[] var27 = new class261[]{class261.field3625, class261.field3632, class261.field3624, class261.field3623, class261.field3626, class261.field3622};
                  var1 = var27.length;
                  class262 var29 = class69.field820;
                  class261[] var30 = new class261[]{class261.field3625, class261.field3632, class261.field3624, class261.field3623, class261.field3626, class261.field3622};
                  Client.field1052 = var29.method4611(var30);
                  if(Client.field1052.size() < var1) {
                     class92.field1446 = "Loading fonts - " + Client.field1052.size() * 100 / var1 + "%";
                     class92.field1429 = 40;
                  } else {
                     class5.field39 = (Font)Client.field1052.get(class261.field3626);
                     WallObject.font_p12full = (Font)Client.field1052.get(class261.field3632);
                     class64.field788 = (Font)Client.field1052.get(class261.field3624);
                     class19.field337 = new class291(true);
                     class92.field1446 = "Loaded fonts";
                     class92.field1429 = 40;
                     Client.field921 = 60;
                  }
               } else if(Client.field921 == 60) {
                  var0 = class21.method169(FileOnDisk.field1763, WorldMapType3.indexSprites);
                  var1 = class28.method229();
                  if(var0 < var1) {
                     class92.field1446 = "Loading title screen - " + var0 * 100 / var1 + "%";
                     class92.field1429 = 50;
                  } else {
                     class92.field1446 = "Loaded title screen";
                     class92.field1429 = 50;
                     class23.setGameState(5);
                     Client.field921 = 70;
                  }
               } else if(Client.field921 == 70) {
                  if(!class3.field24.method3999()) {
                     class92.field1446 = "Loading config - " + class3.field24.method4103() + "%";
                     class92.field1429 = 60;
                  } else {
                     IndexData var26 = class3.field24;
                     Overlay.field3594 = var26;
                     PlayerComposition.method3867(class3.field24);
                     var19 = class3.field24;
                     var20 = class4.indexModels;
                     KitDefinition.field3366 = var19;
                     KitDefinition.field3367 = var20;
                     KitDefinition.field3359 = KitDefinition.field3366.method4075(3);
                     var21 = class3.field24;
                     IndexData var22 = class4.indexModels;
                     boolean var5 = Client.field1055;
                     ObjectComposition.field3444 = var21;
                     ObjectComposition.field3459 = var22;
                     ObjectComposition.field3467 = var5;
                     class252.method4337(class3.field24, class4.indexModels);
                     GraphicsObject.method1565(class3.field24);
                     IndexData var6 = class3.field24;
                     IndexData var7 = class4.indexModels;
                     boolean var8 = Client.isMembers;
                     Font var9 = class5.field39;
                     class91.field1409 = var6;
                     class95.field1485 = var7;
                     class240.isMembersWorld = var8;
                     class181.field2449 = class91.field1409.method4075(10);
                     class14.field294 = var9;
                     GraphicsObject.method1566(class3.field24, Client.indexInterfaces, Client.indexSoundEffects);
                     IndexData var10 = class3.field24;
                     IndexData var11 = class4.indexModels;
                     Spotanim.field3344 = var10;
                     class217.field2792 = var11;
                     class54.method745(class3.field24);
                     IndexData var12 = class3.field24;
                     class241.field3293 = var12;
                     class241.field3292 = class241.field3293.method4075(16);
                     class88.method1614(class9.field255, class4.indexModels, WorldMapType3.indexSprites, class33.field476);
                     class238.method4138(class3.field24);
                     class92.method1651(class3.field24);
                     IndexData var13 = class3.field24;
                     class243.field3321 = var13;
                     WorldMapType1.method274(class3.field24);
                     IndexData var14 = class3.field24;
                     class251.field3395 = var14;
                     class66.chatMessages = new ChatMessages();
                     IndexData var15 = class3.field24;
                     IndexData var16 = WorldMapType3.indexSprites;
                     IndexData var17 = class33.field476;
                     class254.field3429 = var15;
                     class254.field3417 = var16;
                     class254.field3425 = var17;
                     class5.method17(class3.field24, WorldMapType3.indexSprites);
                     class45.method632(class3.field24, WorldMapType3.indexSprites);
                     class92.field1446 = "Loaded config";
                     class92.field1429 = 60;
                     Client.field921 = 80;
                  }
               } else if(Client.field921 == 80) {
                  var0 = 0;
                  if(class158.field2277 == null) {
                     class158.field2277 = class154.method2820(WorldMapType3.indexSprites, "compass", "");
                  } else {
                     ++var0;
                  }

                  if(class15.field300 == null) {
                     class15.field300 = class154.method2820(WorldMapType3.indexSprites, "mapedge", "");
                  } else {
                     ++var0;
                  }

                  if(Client.field925 == null) {
                     Client.field925 = WidgetNode.method1033(WorldMapType3.indexSprites, "mapscene", "");
                  } else {
                     ++var0;
                  }

                  if(class226.field3144 == null) {
                     class226.field3144 = class152.method2812(WorldMapType3.indexSprites, "headicons_pk", "");
                  } else {
                     ++var0;
                  }

                  if(class266.field3661 == null) {
                     class266.field3661 = class152.method2812(WorldMapType3.indexSprites, "headicons_prayer", "");
                  } else {
                     ++var0;
                  }

                  if(class18.field332 == null) {
                     class18.field332 = class152.method2812(WorldMapType3.indexSprites, "headicons_hint", "");
                  } else {
                     ++var0;
                  }

                  if(class20.field346 == null) {
                     class20.field346 = class152.method2812(WorldMapType3.indexSprites, "mapmarker", "");
                  } else {
                     ++var0;
                  }

                  if(class44.field590 == null) {
                     class44.field590 = class152.method2812(WorldMapType3.indexSprites, "cross", "");
                  } else {
                     ++var0;
                  }

                  if(class22.field360 == null) {
                     class22.field360 = class152.method2812(WorldMapType3.indexSprites, "mapdots", "");
                  } else {
                     ++var0;
                  }

                  if(class1.field13 == null) {
                     class1.field13 = WidgetNode.method1033(WorldMapType3.indexSprites, "scrollbar", "");
                  } else {
                     ++var0;
                  }

                  if(class33.field481 == null) {
                     class33.field481 = WidgetNode.method1033(WorldMapType3.indexSprites, "mod_icons", "");
                  } else {
                     ++var0;
                  }

                  if(var0 < 11) {
                     class92.field1446 = "Loading sprites - " + var0 * 100 / 12 + "%";
                     class92.field1429 = 70;
                  } else {
                     FontTypeFace.modIcons = class33.field481;
                     class15.field300.method4933();
                     var1 = (int)(Math.random() * 21.0D) - 10;
                     var2 = (int)(Math.random() * 21.0D) - 10;
                     var3 = (int)(Math.random() * 21.0D) - 10;
                     var4 = (int)(Math.random() * 41.0D) - 20;
                     Client.field925[0].method4912(var4 + var1, var4 + var2, var4 + var3);
                     class92.field1446 = "Loaded sprites";
                     class92.field1429 = 70;
                     Client.field921 = 90;
                  }
               } else if(Client.field921 == 90) {
                  if(!class17.indexTextures.method3999()) {
                     class92.field1446 = "Loading textures - " + class17.indexTextures.method4103() + "%";
                     class92.field1429 = 90;
                  } else {
                     TextureProvider var25 = new TextureProvider(class17.indexTextures, WorldMapType3.indexSprites, 20, 0.8D, Client.field1055?64:128);
                     class136.method2497(var25);
                     class136.method2498(0.8D);
                     class92.field1446 = "Loaded textures";
                     class92.field1429 = 90;
                     Client.field921 = 110;
                  }
               } else if(Client.field921 == 110) {
                  Client.field913 = new class71();
                  GameEngine.field691.method2822(Client.field913, 10);
                  class92.field1446 = "Loaded input handler";
                  class92.field1429 = 94;
                  Client.field921 = 120;
               } else if(Client.field921 == 120) {
                  if(!FileOnDisk.field1763.method4026("huffman", "")) {
                     class92.field1446 = "Loading wordpack - " + 0 + "%";
                     class92.field1429 = 96;
                  } else {
                     class165 var24 = new class165(FileOnDisk.field1763.method4014("huffman", ""));
                     XGrandExchangeOffer.method128(var24);
                     class92.field1446 = "Loaded wordpack";
                     class92.field1429 = 96;
                     Client.field921 = 130;
                  }
               } else if(Client.field921 == 130) {
                  if(!class9.field255.method3999()) {
                     class92.field1446 = "Loading interfaces - " + class9.field255.method4103() * 4 / 5 + "%";
                     class92.field1429 = 100;
                  } else if(!class69.indexScripts.method3999()) {
                     class92.field1446 = "Loading interfaces - " + (class69.indexScripts.method4103() / 6 + 80) + "%";
                     class92.field1429 = 100;
                  } else if(!class33.field476.method3999()) {
                     class92.field1446 = "Loading interfaces - " + (class33.field476.method4103() / 50 + 96) + "%";
                     class92.field1429 = 100;
                  } else {
                     class92.field1446 = "Loaded interfaces";
                     class92.field1429 = 98;
                     Client.field921 = 140;
                  }
               } else if(Client.field921 == 140) {
                  if(!class3.indexWorldMap.method4016(class40.field556.field548)) {
                     class92.field1446 = "Loading world map - " + class3.indexWorldMap.method4018(class40.field556.field548) / 10 + "%";
                  } else {
                     if(class46.field601 == null) {
                        class46.field601 = new RenderOverview();
                        class46.field601.method5068(class3.indexWorldMap, class64.field788, Client.field1052, Client.field925);
                     }

                     var0 = class46.field601.method5217();
                     if(var0 < 100) {
                        class92.field1446 = "Loading world map - " + (var0 * 9 / 10 + 10) + "%";
                     } else {
                        class92.field1446 = "Loaded world map";
                        class92.field1429 = 100;
                        Client.field921 = 150;
                     }
                  }
               } else if(Client.field921 == 150) {
                  class23.setGameState(10);
               }
            }
         } else {
            int[] var18 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var2 = var1 * 32 + 128 + 15;
               var3 = var2 * 3 + 600;
               var4 = class136.SINE[var2];
               var18[var1] = var4 * var3 >> 16;
            }

            Region.method2738(var18, 500, 800, 512, 334);
            class92.field1446 = "Prepared visibility map";
            class92.field1429 = 10;
            Client.field921 = 30;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IB)Lclass254;",
      garbageValue = "1"
   )
   public static class254 method200(int var0) {
      class254 var1 = (class254)class254.field3419.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class254.field3429.getConfigData(32, var0);
         var1 = new class254();
         if(var2 != null) {
            var1.method4349(new Buffer(var2));
         }

         class254.field3419.put(var1, (long)var0);
         return var1;
      }
   }
}
