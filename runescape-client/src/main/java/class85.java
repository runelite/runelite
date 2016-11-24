import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cy")
public final class class85 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -908552467
   )
   int field1446;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 27503633
   )
   int field1447;
   @ObfuscatedName("ie")
   @ObfuscatedGetter(
      intValue = -1021661769
   )
   static int field1448;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 265433449
   )
   int field1450;
   @ObfuscatedName("r")
   boolean field1451 = true;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -426224425
   )
   int field1452;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -729974659
   )
   int field1453;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1568318959
   )
   int field1454;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "14"
   )
   public static void method1736(int var0, int var1) {
      class194 var2 = class173.method3303(var0);
      int var3 = var2.field2850;
      int var4 = var2.field2848;
      int var5 = var2.field2852;
      int var6 = class146.field2034[var5 - var4];
      if(var1 < 0 || var1 > var6) {
         var1 = 0;
      }

      var6 <<= var4;
      class146.widgetSettings[var3] = class146.widgetSettings[var3] & ~var6 | var1 << var4 & var6;
   }

   @ObfuscatedSignature(
      signature = "(IIIIIIZ)V",
      garbageValue = "0"
   )
   class85(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      this.field1453 = var1;
      this.field1454 = var2;
      this.field1446 = var3;
      this.field1447 = var4;
      this.field1450 = var5;
      this.field1452 = var6;
      this.field1451 = var7;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-89"
   )
   static void method1737() {
      int var0;
      if(Client.field312 == 0) {
         class157.region = new Region(4, 104, 104, class11.tileHeights);

         for(var0 = 0; var0 < 4; ++var0) {
            Client.collisionMaps[var0] = new CollisionData(104, 104);
         }

         Projectile.field879 = new SpritePixels(512, 512);
         class41.field826 = "Starting game engine...";
         class41.field833 = 5;
         Client.field312 = 20;
      } else {
         int var1;
         int var2;
         int var4;
         int var22;
         if(Client.field312 == 20) {
            int[] var33 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var2 = 15 + 128 + var1 * 32;
               var22 = 600 + 3 * var2;
               var4 = class84.field1444[var2];
               var33[var1] = var4 * var22 >> 16;
            }

            Region.method1775(var33, 500, 800, 512, 334);
            class41.field826 = "Prepared visibility map";
            class41.field833 = 10;
            Client.field312 = 30;
         } else if(Client.field312 == 30) {
            class139.field1952 = class9.method115(0, false, true, true);
            class186.field2766 = class9.method115(1, false, true, true);
            class143.field2015 = class9.method115(2, true, false, true);
            class172.field2363 = class9.method115(3, false, true, true);
            PlayerComposition.field2036 = class9.method115(4, false, true, true);
            Client.field413 = class9.method115(5, true, true, true);
            class34.field746 = class9.method115(6, true, true, false);
            ItemLayer.field1202 = class9.method115(7, false, true, true);
            class156.field2240 = class9.method115(8, false, true, true);
            class189.field2788 = class9.method115(9, false, true, true);
            Client.field317 = class9.method115(10, false, true, true);
            Client.field332 = class9.method115(11, false, true, true);
            XClanMember.field275 = class9.method115(12, false, true, true);
            Client.field319 = class9.method115(13, true, false, true);
            class148.field2050 = class9.method115(14, false, true, false);
            class189.field2791 = class9.method115(15, false, true, true);
            class41.field826 = "Connecting to update server";
            class41.field833 = 20;
            Client.field312 = 40;
         } else if(Client.field312 == 40) {
            byte var30 = 0;
            var0 = var30 + class139.field1952.method3424() * 4 / 100;
            var0 += class186.field2766.method3424() * 4 / 100;
            var0 += class143.field2015.method3424() * 2 / 100;
            var0 += class172.field2363.method3424() * 2 / 100;
            var0 += PlayerComposition.field2036.method3424() * 6 / 100;
            var0 += Client.field413.method3424() * 4 / 100;
            var0 += class34.field746.method3424() * 2 / 100;
            var0 += ItemLayer.field1202.method3424() * 60 / 100;
            var0 += class156.field2240.method3424() * 2 / 100;
            var0 += class189.field2788.method3424() * 2 / 100;
            var0 += Client.field317.method3424() * 2 / 100;
            var0 += Client.field332.method3424() * 2 / 100;
            var0 += XClanMember.field275.method3424() * 2 / 100;
            var0 += Client.field319.method3424() * 2 / 100;
            var0 += class148.field2050.method3424() * 2 / 100;
            var0 += class189.field2791.method3424() * 2 / 100;
            if(var0 != 100) {
               if(var0 != 0) {
                  class41.field826 = "Checking for updates - " + var0 + "%";
               }

               class41.field833 = 30;
            } else {
               class41.field826 = "Loaded update list";
               class41.field833 = 30;
               Client.field312 = 45;
            }
         } else {
            class184 var3;
            class184 var24;
            class184 var25;
            if(Client.field312 == 45) {
               boolean var29 = !Client.field288;
               class57.field1031 = 22050;
               class57.field1046 = var29;
               class57.field1032 = 2;
               class139 var34 = new class139();
               var34.method2558(9, 128);
               class11.field114 = class36.method755(class15.field159, class107.canvas, 0, 22050);
               class11.field114.method1041(var34);
               var24 = class189.field2791;
               var3 = class148.field2050;
               var25 = PlayerComposition.field2036;
               class138.field1914 = var24;
               class138.field1913 = var3;
               class138.field1915 = var25;
               class138.field1919 = var34;
               class15.field156 = class36.method755(class15.field159, class107.canvas, 1, 2048);
               class143.field2007 = new class51();
               class15.field156.method1041(class143.field2007);
               class3.field35 = new class65(22050, class57.field1031);
               class41.field826 = "Prepared sound engine";
               class41.field833 = 35;
               Client.field312 = 50;
            } else if(Client.field312 == 50) {
               var0 = 0;
               if(GroundObject.field1293 == null) {
                  GroundObject.field1293 = class200.method3795(class156.field2240, Client.field319, "p11_full", "");
               } else {
                  ++var0;
               }

               if(null == XGrandExchangeOffer.field45) {
                  XGrandExchangeOffer.field45 = class200.method3795(class156.field2240, Client.field319, "p12_full", "");
               } else {
                  ++var0;
               }

               if(null == class156.field2236) {
                  class156.field2236 = class200.method3795(class156.field2240, Client.field319, "b12_full", "");
               } else {
                  ++var0;
               }

               if(var0 < 3) {
                  class41.field826 = "Loading fonts - " + 100 * var0 / 3 + "%";
                  class41.field833 = 40;
               } else {
                  Renderable.field1536 = new class230(true);
                  class41.field826 = "Loaded fonts";
                  class41.field833 = 40;
                  Client.field312 = 60;
               }
            } else if(Client.field312 == 60) {
               var0 = class200.method3780(Client.field317, class156.field2240);
               byte var28 = 9;
               if(var0 < var28) {
                  class41.field826 = "Loading title screen - " + 100 * var0 / var28 + "%";
                  class41.field833 = 50;
               } else {
                  class41.field826 = "Loaded title screen";
                  class41.field833 = 50;
                  class186.setGameState(5);
                  Client.field312 = 70;
               }
            } else if(Client.field312 == 70) {
               if(!class143.field2015.method3394()) {
                  class41.field826 = "Loading config - " + class143.field2015.method3454() + "%";
                  class41.field833 = 60;
               } else {
                  class184 var32 = class143.field2015;
                  class200.field3032 = var32;
                  class184 var26 = class143.field2015;
                  class191.field2812 = var26;
                  var24 = class143.field2015;
                  var3 = ItemLayer.field1202;
                  KitDefinition.field2829 = var24;
                  KitDefinition.field2820 = var3;
                  KitDefinition.field2818 = KitDefinition.field2829.method3339(3);
                  var25 = class143.field2015;
                  class184 var5 = ItemLayer.field1202;
                  boolean var6 = Client.field288;
                  ObjectComposition.field2912 = var25;
                  ObjectComposition.field2892 = var5;
                  ObjectComposition.field2935 = var6;
                  class179.method3323(class143.field2015, ItemLayer.field1202);
                  class184 var7 = class143.field2015;
                  class184 var8 = ItemLayer.field1202;
                  boolean var9 = Client.isMembers;
                  class208 var10 = GroundObject.field1293;
                  ItemComposition.field2942 = var7;
                  class172.field2367 = var8;
                  ItemComposition.isMembersWorld = var9;
                  FrameMap.field1465 = ItemComposition.field2942.method3339(10);
                  class183.field2733 = var10;
                  class184 var11 = class143.field2015;
                  class184 var12 = class139.field1952;
                  class184 var13 = class186.field2766;
                  Sequence.field3049 = var11;
                  class231.field3281 = var12;
                  Sequence.field3044 = var13;
                  class184 var14 = class143.field2015;
                  class184 var15 = ItemLayer.field1202;
                  class190.field2807 = var14;
                  class190.field2795 = var15;
                  class171.method3299(class143.field2015);
                  ItemLayer.method1486(class143.field2015);
                  class104.method2041(class172.field2363, ItemLayer.field1202, class156.field2240, Client.field319);
                  class184 var16 = class143.field2015;
                  class186.field2768 = var16;
                  class172.method3301(class143.field2015);
                  class184 var17 = class143.field2015;
                  class188.field2782 = var17;
                  class184 var18 = class143.field2015;
                  class189.field2789 = var18;
                  class3.chatMessages = new ChatMessages();
                  class184 var19 = class143.field2015;
                  class184 var20 = class156.field2240;
                  class184 var21 = Client.field319;
                  class196.field2881 = var19;
                  class196.field2866 = var20;
                  class196.field2888 = var21;
                  class140.method2682(class143.field2015, class156.field2240);
                  class41.field826 = "Loaded config";
                  class41.field833 = 60;
                  Client.field312 = 80;
               }
            } else if(Client.field312 != 80) {
               if(Client.field312 == 90) {
                  if(!class189.field2788.method3394()) {
                     class41.field826 = "Loading textures - " + class189.field2788.method3454() + "%";
                     class41.field833 = 90;
                  } else {
                     TextureProvider var31 = new TextureProvider(class189.field2788, class156.field2240, 20, 0.8D, Client.field288?64:128);
                     class84.method1670(var31);
                     class84.method1685(0.8D);
                     class41.field826 = "Loaded textures";
                     class41.field833 = 90;
                     Client.field312 = 110;
                  }
               } else if(Client.field312 == 110) {
                  class107.field1729 = new class20();
                  class15.field159.method2000(class107.field1729, 10);
                  class41.field826 = "Loaded input handler";
                  class41.field833 = 94;
                  Client.field312 = 120;
               } else if(Client.field312 == 120) {
                  if(!Client.field317.method3371("huffman", "")) {
                     class41.field826 = "Loading wordpack - " + 0 + "%";
                     class41.field833 = 96;
                  } else {
                     class152 var23 = new class152(Client.field317.method3346("huffman", ""));
                     class72.method1437(var23);
                     class41.field826 = "Loaded wordpack";
                     class41.field833 = 96;
                     Client.field312 = 130;
                  }
               } else if(Client.field312 == 130) {
                  if(!class172.field2363.method3394()) {
                     class41.field826 = "Loading interfaces - " + class172.field2363.method3454() * 4 / 5 + "%";
                     class41.field833 = 100;
                  } else if(!XClanMember.field275.method3394()) {
                     class41.field826 = "Loading interfaces - " + (80 + XClanMember.field275.method3454() / 6) + "%";
                     class41.field833 = 100;
                  } else if(!Client.field319.method3394()) {
                     class41.field826 = "Loading interfaces - " + (96 + Client.field319.method3454() / 20) + "%";
                     class41.field833 = 100;
                  } else {
                     class41.field826 = "Loaded interfaces";
                     class41.field833 = 100;
                     Client.field312 = 140;
                  }
               } else if(Client.field312 == 140) {
                  class186.setGameState(10);
               }
            } else {
               var0 = 0;
               if(null == class20.field213) {
                  class20.field213 = class110.method2113(class156.field2240, "compass", "");
               } else {
                  ++var0;
               }

               if(FaceNormal.field1555 == null) {
                  FaceNormal.field1555 = class110.method2113(class156.field2240, "mapedge", "");
               } else {
                  ++var0;
               }

               if(null == Frames.field1563) {
                  Frames.field1563 = class183.method3419(class156.field2240, "mapscene", "");
               } else {
                  ++var0;
               }

               if(null == class10.field96) {
                  class10.field96 = class138.method2548(class156.field2240, "mapfunction", "");
               } else {
                  ++var0;
               }

               if(null == class28.field657) {
                  class28.field657 = class138.method2548(class156.field2240, "headicons_pk", "");
               } else {
                  ++var0;
               }

               if(null == class16.field167) {
                  class16.field167 = class138.method2548(class156.field2240, "headicons_prayer", "");
               } else {
                  ++var0;
               }

               if(class3.field37 == null) {
                  class3.field37 = class138.method2548(class156.field2240, "headicons_hint", "");
               } else {
                  ++var0;
               }

               if(XGrandExchangeOffer.field47 == null) {
                  XGrandExchangeOffer.field47 = class138.method2548(class156.field2240, "mapmarker", "");
               } else {
                  ++var0;
               }

               if(class110.field1745 == null) {
                  class110.field1745 = class138.method2548(class156.field2240, "cross", "");
               } else {
                  ++var0;
               }

               if(null == class9.field87) {
                  class9.field87 = class138.method2548(class156.field2240, "mapdots", "");
               } else {
                  ++var0;
               }

               if(class171.field2357 == null) {
                  class171.field2357 = class183.method3419(class156.field2240, "scrollbar", "");
               } else {
                  ++var0;
               }

               if(null == class189.field2793) {
                  class189.field2793 = class183.method3419(class156.field2240, "mod_icons", "");
               } else {
                  ++var0;
               }

               if(var0 < 12) {
                  class41.field826 = "Loading sprites - " + 100 * var0 / 12 + "%";
                  class41.field833 = 70;
               } else {
                  class209.modIcons = class189.field2793;
                  FaceNormal.field1555.method4184();
                  var1 = (int)(Math.random() * 21.0D) - 10;
                  var2 = (int)(Math.random() * 21.0D) - 10;
                  var22 = (int)(Math.random() * 21.0D) - 10;
                  var4 = (int)(Math.random() * 41.0D) - 20;

                  for(int var27 = 0; var27 < class10.field96.length; ++var27) {
                     class10.field96[var27].method4212(var4 + var1, var2 + var4, var4 + var22);
                  }

                  Frames.field1563[0].method4135(var1 + var4, var2 + var4, var22 + var4);
                  class41.field826 = "Loaded sprites";
                  class41.field833 = 70;
                  Client.field312 = 90;
               }
            }
         }
      }
   }
}
