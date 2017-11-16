import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
public class class51 implements class102 {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   public static IndexDataBase field612;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 2134145219
   )
   static int field611;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = -186615343
   )
   static int field609;
   @ObfuscatedName("fl")
   @Export("xteaKeys")
   static int[][] xteaKeys;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Ldo;",
      garbageValue = "-880282110"
   )
   public AbstractSoundSystem vmethod1919() {
      return new SourceDataSoundSystem();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "90"
   )
   static int method719(int var0, int var1) {
      Overlay var2 = ClientPacket.method3094(var0);
      if(var2 == null) {
         return var1;
      } else if(var2.otherRgbColor >= 0) {
         return var2.otherRgbColor | -16777216;
      } else {
         int var4;
         int var5;
         if(var2.texture >= 0) {
            var4 = Graphics3D.textureLoader.getAverageTextureRGB(var2.texture);
            byte var11 = 96;
            int var3;
            if(var4 == -2) {
               var3 = 12345678;
            } else if(var4 == -1) {
               if(var11 < 0) {
                  var11 = 0;
               } else if(var11 > 127) {
                  var11 = 127;
               }

               var5 = 127 - var11;
               var3 = var5;
            } else {
               var5 = var11 * (var4 & 127) / 128;
               if(var5 < 2) {
                  var5 = 2;
               } else if(var5 > 126) {
                  var5 = 126;
               }

               var3 = var5 + (var4 & 65408);
            }

            return Graphics3D.colorPalette[var3] | -16777216;
         } else if(var2.color == 16711935) {
            return var1;
         } else {
            var4 = var2.hue;
            var5 = var2.saturation;
            int var6 = var2.lightness;
            if(var6 > 179) {
               var5 /= 2;
            }

            if(var6 > 192) {
               var5 /= 2;
            }

            if(var6 > 217) {
               var5 /= 2;
            }

            if(var6 > 243) {
               var5 /= 2;
            }

            int var7 = (var5 / 32 << 7) + var6 / 2 + (var4 / 4 << 10);
            byte var9 = 96;
            int var8;
            if(var7 == -2) {
               var8 = 12345678;
            } else {
               int var12;
               if(var7 == -1) {
                  if(var9 < 0) {
                     var9 = 0;
                  } else if(var9 > 127) {
                     var9 = 127;
                  }

                  var12 = 127 - var9;
                  var8 = var12;
               } else {
                  var12 = var9 * (var7 & 127) / 128;
                  if(var12 < 2) {
                     var12 = 2;
                  } else if(var12 > 126) {
                     var12 = 126;
                  }

                  var8 = var12 + (var7 & 65408);
               }
            }

            return Graphics3D.colorPalette[var8] | -16777216;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1175761408"
   )
   @Export("setItemTableSlot")
   static void setItemTableSlot(int var0, int var1, int var2, int var3) {
      ItemContainer var4 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      if(var4 == null) {
         var4 = new ItemContainer();
         ItemContainer.itemContainers.put(var4, (long)var0);
      }

      if(var4.itemIds.length <= var1) {
         int[] var5 = new int[var1 + 1];
         int[] var6 = new int[var1 + 1];

         int var7;
         for(var7 = 0; var7 < var4.itemIds.length; ++var7) {
            var5[var7] = var4.itemIds[var7];
            var6[var7] = var4.stackSizes[var7];
         }

         for(var7 = var4.itemIds.length; var7 < var1; ++var7) {
            var5[var7] = -1;
            var6[var7] = 0;
         }

         var4.itemIds = var5;
         var4.stackSizes = var6;
      }

      var4.itemIds[var1] = var2;
      var4.stackSizes[var1] = var3;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1893903156"
   )
   static final int method722(int var0, int var1) {
      int var2 = class21.getSmoothNoise(var0 + 45365, var1 + 91923, 4) - 128 + (class21.getSmoothNoise(10294 + var0, var1 + 37821, 2) - 128 >> 1) + (class21.getSmoothNoise(var0, var1, 1) - 128 >> 2);
      var2 = (int)((double)var2 * 0.3D) + 35;
      if(var2 < 10) {
         var2 = 10;
      } else if(var2 > 60) {
         var2 = 60;
      }

      return var2;
   }

   @ObfuscatedName("iv")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1056885892"
   )
   static final void method724(int var0) {
      if(class64.loadWidget(var0)) {
         Widget[] var1 = Widget.widgets[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Widget var3 = var1[var2];
            if(var3 != null) {
               var3.field2835 = 0;
               var3.field2723 = 0;
            }
         }

      }
   }
}
