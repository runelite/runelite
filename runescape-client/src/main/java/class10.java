import java.awt.Font;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
public final class class10 {
   @ObfuscatedName("c")
   static byte[][][] field80;
   @ObfuscatedName("m")
   @Export("tileSettings")
   static byte[][][] tileSettings = new byte[4][104][104];
   @ObfuscatedName("l")
   static byte[][][] field82;
   @ObfuscatedName("g")
   static byte[][][] field83;
   @ObfuscatedName("j")
   static int[] field84;
   @ObfuscatedName("rh")
   protected static String field85;
   @ObfuscatedName("u")
   static int[][] field86;
   @ObfuscatedName("w")
   static final int[] field87 = new int[]{16, 32, 64, 128};
   @ObfuscatedName("y")
   static int[] field88;
   @ObfuscatedName("n")
   static final int[] field89 = new int[]{1, 0, -1, 0};
   @ObfuscatedName("f")
   static int[] field90;
   @ObfuscatedName("d")
   static final int[] field92 = new int[]{1, 2, 4, 8};
   @ObfuscatedName("o")
   @Export("tileHeights")
   static int[][][] tileHeights = new int[4][105][105];
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1362030715
   )
   static int field94 = 99;
   @ObfuscatedName("q")
   static final int[] field95 = new int[]{0, -1, 0, 1};
   @ObfuscatedName("r")
   static final int[] field97 = new int[]{-1, -1, 1, 1};
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -811054563
   )
   static int field98 = (int)(Math.random() * 17.0D) - 8;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1461432875
   )
   static int field99 = (int)(Math.random() * 33.0D) - 16;
   @ObfuscatedName("t")
   static final int[] field100 = new int[]{1, -1, -1, 1};
   @ObfuscatedName("jn")
   @ObfuscatedGetter(
      intValue = 1958767349
   )
   static int field101;
   @ObfuscatedName("qo")
   static Font field103;
   @ObfuscatedName("z")
   static int[] field104;

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(IIIIIB)V",
      garbageValue = "1"
   )
   static final void method122(int var0, int var1, int var2, int var3, int var4) {
      int var5 = class159.region.method1823(var0, var1, var2);
      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var12;
      if(var5 != 0) {
         var6 = class159.region.method1696(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var10 = class154.field2118.image;
         var11 = 24624 + var1 * 4 + 2048 * (103 - var2);
         var12 = var5 >> 14 & 32767;
         ObjectComposition var13 = class143.getObjectDefinition(var12);
         if(var13.field2919 != -1) {
            ModIcon var14 = class38.field808[var13.field2919];
            if(null != var14) {
               int var15 = (var13.field2905 * 4 - var14.originalWidth) / 2;
               int var16 = (var13.field2938 * 4 - var14.height) / 2;
               var14.method3995(4 * var1 + 48 + var15, var16 + 48 + 4 * (104 - var2 - var13.field2938));
            }
         } else {
            if(var8 == 0 || var8 == 2) {
               if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[1024 + var11] = var9;
                  var10[1536 + var11] = var9;
               } else if(var7 == 1) {
                  var10[var11] = var9;
                  var10[1 + var11] = var9;
                  var10[2 + var11] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[3 + var11] = var9;
                  var10[512 + var11 + 3] = var9;
                  var10[1024 + 3 + var11] = var9;
                  var10[3 + var11 + 1536] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
                  var10[1536 + var11 + 1] = var9;
                  var10[var11 + 1536 + 2] = var9;
                  var10[3 + 1536 + var11] = var9;
               }
            }

            if(var8 == 3) {
               if(var7 == 0) {
                  var10[var11] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[1536 + 3 + var11] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
               }
            }

            if(var8 == 2) {
               if(var7 == 3) {
                  var10[var11] = var9;
                  var10[512 + var11] = var9;
                  var10[var11 + 1024] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[2 + var11] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 1) {
                  var10[3 + var11] = var9;
                  var10[3 + var11 + 512] = var9;
                  var10[1024 + 3 + var11] = var9;
                  var10[1536 + var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[1536 + var11] = var9;
                  var10[1 + 1536 + var11] = var9;
                  var10[2 + 1536 + var11] = var9;
                  var10[3 + 1536 + var11] = var9;
               }
            }
         }
      }

      var5 = class159.region.method1691(var0, var1, var2);
      if(var5 != 0) {
         var6 = class159.region.method1696(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         ObjectComposition var23 = class143.getObjectDefinition(var9);
         int var20;
         if(var23.field2919 != -1) {
            ModIcon var21 = class38.field808[var23.field2919];
            if(var21 != null) {
               var12 = (var23.field2905 * 4 - var21.originalWidth) / 2;
               var20 = (var23.field2938 * 4 - var21.height) / 2;
               var21.method3995(var12 + 48 + 4 * var1, 48 + 4 * (104 - var2 - var23.field2938) + var20);
            }
         } else if(var8 == 9) {
            var11 = 15658734;
            if(var5 > 0) {
               var11 = 15597568;
            }

            int[] var19 = class154.field2118.image;
            var20 = 24624 + var1 * 4 + 2048 * (103 - var2);
            if(var7 != 0 && var7 != 2) {
               var19[var20] = var11;
               var19[var20 + 512 + 1] = var11;
               var19[2 + var20 + 1024] = var11;
               var19[3 + 1536 + var20] = var11;
            } else {
               var19[var20 + 1536] = var11;
               var19[var20 + 1024 + 1] = var11;
               var19[512 + var20 + 2] = var11;
               var19[var20 + 3] = var11;
            }
         }
      }

      var5 = class159.region.method1803(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         ObjectComposition var17 = class143.getObjectDefinition(var6);
         if(var17.field2919 != -1) {
            ModIcon var18 = class38.field808[var17.field2919];
            if(null != var18) {
               var9 = (var17.field2905 * 4 - var18.originalWidth) / 2;
               int var22 = (var17.field2938 * 4 - var18.height) / 2;
               var18.method3995(4 * var1 + 48 + var9, var22 + 4 * (104 - var2 - var17.field2938) + 48);
            }
         }
      }

   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-106"
   )
   static final void method142(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field487; ++var4) {
         if(Client.widgetPositionX[var4] + Client.widgetBoundsWidth[var4] > var0 && Client.widgetPositionX[var4] < var0 + var2 && Client.widgetPositionY[var4] + Client.widgetBoundsHeight[var4] > var1 && Client.widgetPositionY[var4] < var1 + var3) {
            Client.field490[var4] = true;
         }
      }

   }

   @ObfuscatedName("do")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-29"
   )
   static final void method143(int var0) {
      Ignore.method188();

      for(class31 var1 = (class31)class31.field723.method2349(); null != var1; var1 = (class31)class31.field723.method2351()) {
         if(var1.field725 != null) {
            var1.method651();
         }
      }

      int var4 = class177.method3187(var0).field2782;
      if(var4 != 0) {
         int var2 = class165.widgetSettings[var0];
         if(var4 == 1) {
            if(var2 == 1) {
               class84.method1643(0.9D);
               ((TextureProvider)class84.field1442).method1406(0.9D);
            }

            if(var2 == 2) {
               class84.method1643(0.8D);
               ((TextureProvider)class84.field1442).method1406(0.8D);
            }

            if(var2 == 3) {
               class84.method1643(0.7D);
               ((TextureProvider)class84.field1442).method1406(0.7D);
            }

            if(var2 == 4) {
               class84.method1643(0.6D);
               ((TextureProvider)class84.field1442).method1406(0.6D);
            }

            ItemComposition.itemSpriteCache.reset();
         }

         if(var4 == 3) {
            short var3 = 0;
            if(var2 == 0) {
               var3 = 255;
            }

            if(var2 == 1) {
               var3 = 192;
            }

            if(var2 == 2) {
               var3 = 128;
            }

            if(var2 == 3) {
               var3 = 64;
            }

            if(var2 == 4) {
               var3 = 0;
            }

            if(Client.field521 != var3) {
               if(Client.field521 == 0 && Client.field522 != -1) {
                  WallObject.method1843(class119.field1864, Client.field522, 0, var3, false);
                  Client.field493 = false;
               } else if(var3 == 0) {
                  class47.method873();
                  Client.field493 = false;
               } else {
                  class20.method193(var3);
               }

               Client.field521 = var3;
            }
         }

         if(var4 == 4) {
            if(var2 == 0) {
               Client.field524 = 127;
            }

            if(var2 == 1) {
               Client.field524 = 96;
            }

            if(var2 == 2) {
               Client.field524 = 64;
            }

            if(var2 == 3) {
               Client.field524 = 32;
            }

            if(var2 == 4) {
               Client.field524 = 0;
            }
         }

         if(var4 == 5) {
            Client.field424 = var2;
         }

         if(var4 == 6) {
            Client.field446 = var2;
         }

         if(var4 == 9) {
            Client.field354 = var2;
         }

         if(var4 == 10) {
            if(var2 == 0) {
               Client.field525 = 127;
            }

            if(var2 == 1) {
               Client.field525 = 96;
            }

            if(var2 == 2) {
               Client.field525 = 64;
            }

            if(var2 == 3) {
               Client.field525 = 32;
            }

            if(var2 == 4) {
               Client.field525 = 0;
            }
         }

         if(var4 == 17) {
            Client.field452 = var2 & '\uffff';
         }

         class40[] var5;
         if(var4 == 18) {
            var5 = new class40[]{class40.field824, class40.field821, class40.field818, class40.field819};
            Client.field376 = (class40)FileOnDisk.method1390(var5, var2);
            if(null == Client.field376) {
               Client.field376 = class40.field821;
            }
         }

         if(var4 == 19) {
            if(var2 == -1) {
               Client.field416 = -1;
            } else {
               Client.field416 = var2 & 2047;
            }
         }

         if(var4 == 22) {
            var5 = new class40[]{class40.field824, class40.field821, class40.field818, class40.field819};
            Client.field315 = (class40)FileOnDisk.method1390(var5, var2);
            if(Client.field315 == null) {
               Client.field315 = class40.field821;
            }
         }

      }
   }
}
