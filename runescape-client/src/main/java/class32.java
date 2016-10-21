import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
public class class32 {
   @ObfuscatedName("d")
   public static Buffer field707;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2017092257
   )
   int field708;
   @ObfuscatedName("t")
   String field709;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1323844647
   )
   int field710;
   @ObfuscatedName("iw")
   @ObfuscatedGetter(
      intValue = -93942295
   )
   static int field711;
   @ObfuscatedName("du")
   @ObfuscatedGetter(
      intValue = -1919225761
   )
   @Export("baseX")
   static int baseX;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2010868749
   )
   int field714;
   @ObfuscatedName("x")
   static int[][][] field715;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -808722765
   )
   int field718;

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "1104190039"
   )
   static final void method685(int var0, int var1, int var2, int var3, boolean var4) {
      if(var2 < 1) {
         var2 = 1;
      }

      if(var3 < 1) {
         var3 = 1;
      }

      int var5 = var3 - 334;
      if(var5 < 0) {
         var5 = 0;
      } else if(var5 > 100) {
         var5 = 100;
      }

      int var6 = Client.field410 + (Client.field542 - Client.field410) * var5 / 100;
      int var7 = var3 * var6 * 512 / (334 * var2);
      int var8;
      int var14;
      short var15;
      if(var7 < Client.field539) {
         var15 = Client.field539;
         var6 = var2 * var15 * 334 / (var3 * 512);
         if(var6 > Client.field538) {
            var6 = Client.field538;
            var8 = var3 * var6 * 512 / (var15 * 334);
            var14 = (var2 - var8) / 2;
            if(var4) {
               class82.method1839();
               class82.method1861(var0, var1, var14, var3, -16777216);
               class82.method1861(var2 + var0 - var14, var1, var14, var3, -16777216);
            }

            var0 += var14;
            var2 -= 2 * var14;
         }
      } else if(var7 > Client.field540) {
         var15 = Client.field540;
         var6 = var15 * var2 * 334 / (var3 * 512);
         if(var6 < Client.field537) {
            var6 = Client.field537;
            var8 = var15 * var2 * 334 / (var6 * 512);
            var14 = (var3 - var8) / 2;
            if(var4) {
               class82.method1839();
               class82.method1861(var0, var1, var2, var14, -16777216);
               class82.method1861(var0, var3 + var1 - var14, var2, var14, -16777216);
            }

            var1 += var14;
            var3 -= 2 * var14;
         }
      }

      var8 = Client.field513 + var5 * (Client.field536 - Client.field513) / 100;
      Client.scale = var8 * var6 * var3 / 85504 << 1;
      if(Client.camera2 != var2 || Client.camera3 != var3) {
         int[] var9 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = var10 * 32 + 128 + 15;
            int var12 = var11 * 3 + 600;
            int var13 = class94.field1635[var11];
            var9[var10] = var13 * var12 >> 16;
         }

         Region.method1999(var9, 500, 800, var2, var3);
      }

      Client.field541 = var0;
      Client.field547 = var1;
      Client.camera2 = var2;
      Client.camera3 = var3;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "417492030"
   )
   static final int method686() {
      if(class16.field232.field149) {
         return XItemContainer.plane;
      } else {
         int var0 = 3;
         if(class144.cameraPitch < 310) {
            int var1 = class139.cameraX >> 7;
            int var2 = class77.cameraY >> 7;
            int var3 = class34.localPlayer.x >> 7;
            int var4 = class34.localPlayer.y >> 7;
            if(var1 < 0 || var2 < 0 || var1 >= 104 || var2 >= 104) {
               return XItemContainer.plane;
            }

            if((class5.tileSettings[XItemContainer.plane][var1][var2] & 4) != 0) {
               var0 = XItemContainer.plane;
            }

            int var5;
            if(var3 > var1) {
               var5 = var3 - var1;
            } else {
               var5 = var1 - var3;
            }

            int var6;
            if(var4 > var2) {
               var6 = var4 - var2;
            } else {
               var6 = var2 - var4;
            }

            int var7;
            int var8;
            if(var5 > var6) {
               var7 = var6 * 65536 / var5;
               var8 = '耀';

               while(var3 != var1) {
                  if(var1 < var3) {
                     ++var1;
                  } else if(var1 > var3) {
                     --var1;
                  }

                  if((class5.tileSettings[XItemContainer.plane][var1][var2] & 4) != 0) {
                     var0 = XItemContainer.plane;
                  }

                  var8 += var7;
                  if(var8 >= 65536) {
                     var8 -= 65536;
                     if(var2 < var4) {
                        ++var2;
                     } else if(var2 > var4) {
                        --var2;
                     }

                     if((class5.tileSettings[XItemContainer.plane][var1][var2] & 4) != 0) {
                        var0 = XItemContainer.plane;
                     }
                  }
               }
            } else {
               var7 = var5 * 65536 / var6;
               var8 = '耀';

               while(var2 != var4) {
                  if(var2 < var4) {
                     ++var2;
                  } else if(var2 > var4) {
                     --var2;
                  }

                  if((class5.tileSettings[XItemContainer.plane][var1][var2] & 4) != 0) {
                     var0 = XItemContainer.plane;
                  }

                  var8 += var7;
                  if(var8 >= 65536) {
                     var8 -= 65536;
                     if(var1 < var3) {
                        ++var1;
                     } else if(var1 > var3) {
                        --var1;
                     }

                     if((class5.tileSettings[XItemContainer.plane][var1][var2] & 4) != 0) {
                        var0 = XItemContainer.plane;
                     }
                  }
               }
            }
         }

         if(class34.localPlayer.x >= 0 && class34.localPlayer.y >= 0 && class34.localPlayer.x < 13312 && class34.localPlayer.y < 13312) {
            if((class5.tileSettings[XItemContainer.plane][class34.localPlayer.x >> 7][class34.localPlayer.y >> 7] & 4) != 0) {
               var0 = XItemContainer.plane;
            }

            return var0;
         } else {
            return XItemContainer.plane;
         }
      }
   }
}
