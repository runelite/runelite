import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hv")
public class class222 {
   @ObfuscatedName("o")
   public static Track1 field2843;
   @ObfuscatedName("w")
   public static final boolean[] field2844;
   @ObfuscatedName("a")
   public static int[] field2845;

   @ObfuscatedName("ie")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "65280"
   )
   static final void method4070(int var0) {
      if(class66.loadWidget(var0)) {
         Widget[] var1 = class46.widgets[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Widget var3 = var1[var2];
            if(var3 != null) {
               var3.field2788 = 0;
               var3.field2777 = 0;
            }
         }
      }

   }

   @ObfuscatedName("gd")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "-146992606"
   )
   static final void method4071(int var0, int var1, int var2, int var3, int var4) {
      int var5 = class2.region.method2692(var0, var1, var2);
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      int var11;
      ModIcon var14;
      if(var5 != 0) {
         var6 = class2.region.method2696(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var12 = MouseInput.field758.image;
         var10 = var1 * 4 + 24624 + (103 - var2) * 2048;
         var11 = var5 >> 14 & 32767;
         ObjectComposition var13 = class251.getObjectDefinition(var11);
         if(var13.mapSceneId != -1) {
            var14 = class8.field246[var13.mapSceneId];
            if(var14 != null) {
               int var15 = (var13.sizeX * 4 - var14.originalWidth) / 2;
               int var16 = (var13.sizeY * 4 - var14.height) / 2;
               var14.method5025(var1 * 4 + 48 + var15, (104 - var2 - var13.sizeY) * 4 + 48 + var16);
            }
         } else {
            if(var8 == 0 || var8 == 2) {
               if(var7 == 0) {
                  var12[var10] = var9;
                  var12[var10 + 512] = var9;
                  var12[var10 + 1024] = var9;
                  var12[var10 + 1536] = var9;
               } else if(var7 == 1) {
                  var12[var10] = var9;
                  var12[var10 + 1] = var9;
                  var12[var10 + 2] = var9;
                  var12[var10 + 3] = var9;
               } else if(var7 == 2) {
                  var12[var10 + 3] = var9;
                  var12[var10 + 3 + 512] = var9;
                  var12[3 + var10 + 1024] = var9;
                  var12[var10 + 3 + 1536] = var9;
               } else if(var7 == 3) {
                  var12[var10 + 1536] = var9;
                  var12[var10 + 1536 + 1] = var9;
                  var12[var10 + 1536 + 2] = var9;
                  var12[var10 + 1536 + 3] = var9;
               }
            }

            if(var8 == 3) {
               if(var7 == 0) {
                  var12[var10] = var9;
               } else if(var7 == 1) {
                  var12[var10 + 3] = var9;
               } else if(var7 == 2) {
                  var12[3 + var10 + 1536] = var9;
               } else if(var7 == 3) {
                  var12[var10 + 1536] = var9;
               }
            }

            if(var8 == 2) {
               if(var7 == 3) {
                  var12[var10] = var9;
                  var12[var10 + 512] = var9;
                  var12[var10 + 1024] = var9;
                  var12[var10 + 1536] = var9;
               } else if(var7 == 0) {
                  var12[var10] = var9;
                  var12[var10 + 1] = var9;
                  var12[var10 + 2] = var9;
                  var12[var10 + 3] = var9;
               } else if(var7 == 1) {
                  var12[var10 + 3] = var9;
                  var12[var10 + 3 + 512] = var9;
                  var12[var10 + 3 + 1024] = var9;
                  var12[var10 + 3 + 1536] = var9;
               } else if(var7 == 2) {
                  var12[var10 + 1536] = var9;
                  var12[var10 + 1536 + 1] = var9;
                  var12[var10 + 1536 + 2] = var9;
                  var12[var10 + 1536 + 3] = var9;
               }
            }
         }
      }

      var5 = class2.region.method2694(var0, var1, var2);
      ObjectComposition var17;
      if(var5 != 0) {
         var6 = class2.region.method2696(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         var17 = class251.getObjectDefinition(var9);
         int var18;
         if(var17.mapSceneId != -1) {
            var14 = class8.field246[var17.mapSceneId];
            if(var14 != null) {
               var11 = (var17.sizeX * 4 - var14.originalWidth) / 2;
               var18 = (var17.sizeY * 4 - var14.height) / 2;
               var14.method5025(4 * var1 + 48 + var11, var18 + (104 - var2 - var17.sizeY) * 4 + 48);
            }
         } else if(var8 == 9) {
            var10 = 15658734;
            if(var5 > 0) {
               var10 = 15597568;
            }

            int[] var20 = MouseInput.field758.image;
            var18 = var1 * 4 + 24624 + (103 - var2) * 2048;
            if(var7 != 0 && var7 != 2) {
               var20[var18] = var10;
               var20[512 + var18 + 1] = var10;
               var20[var18 + 1024 + 2] = var10;
               var20[var18 + 1536 + 3] = var10;
            } else {
               var20[var18 + 1536] = var10;
               var20[var18 + 1024 + 1] = var10;
               var20[512 + var18 + 2] = var10;
               var20[var18 + 3] = var10;
            }
         }
      }

      var5 = class2.region.method2695(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         var17 = class251.getObjectDefinition(var6);
         if(var17.mapSceneId != -1) {
            ModIcon var19 = class8.field246[var17.mapSceneId];
            if(var19 != null) {
               var9 = (var17.sizeX * 4 - var19.originalWidth) / 2;
               int var21 = (var17.sizeY * 4 - var19.height) / 2;
               var19.method5025(4 * var1 + 48 + var9, var21 + (104 - var2 - var17.sizeY) * 4 + 48);
            }
         }
      }

   }

   static {
      field2844 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
      field2845 = new int[99];
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = var1 + 1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field2845[var1] = var0 / 4;
      }

   }
}
