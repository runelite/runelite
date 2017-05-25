import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eb")
public class class140 {
   @ObfuscatedName("gn")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "-1595658830"
   )
   static final void method2900(int var0, int var1, int var2, int var3, int var4) {
      int var5 = class46.region.method2733(var0, var1, var2);
      int var6;
      int var7;
      int var9;
      int var11;
      int var12;
      int var19;
      if(var5 != 0) {
         var6 = class46.region.method2896(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var19 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var18 = class172.field2368.image;
         var11 = var1 * 4 + 24624 + (103 - var2) * 2048;
         var12 = var5 >> 14 & 32767;
         ObjectComposition var13 = class43.getObjectDefinition(var12);
         if(var13.mapSceneId != -1) {
            ModIcon var14 = class112.field1658[var13.mapSceneId];
            if(var14 != null) {
               int var15 = (var13.sizeX * 4 - var14.originalWidth) / 2;
               int var16 = (var13.sizeY * 4 - var14.height) / 2;
               var14.method5101(var1 * 4 + 48 + var15, var16 + (104 - var2 - var13.sizeY) * 4 + 48);
            }
         } else {
            if(var19 == 0 || var19 == 2) {
               if(var7 == 0) {
                  var18[var11] = var9;
                  var18[var11 + 512] = var9;
                  var18[var11 + 1024] = var9;
                  var18[var11 + 1536] = var9;
               } else if(var7 == 1) {
                  var18[var11] = var9;
                  var18[var11 + 1] = var9;
                  var18[var11 + 2] = var9;
                  var18[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var18[var11 + 3] = var9;
                  var18[var11 + 3 + 512] = var9;
                  var18[var11 + 3 + 1024] = var9;
                  var18[var11 + 3 + 1536] = var9;
               } else if(var7 == 3) {
                  var18[var11 + 1536] = var9;
                  var18[var11 + 1536 + 1] = var9;
                  var18[var11 + 1536 + 2] = var9;
                  var18[var11 + 1536 + 3] = var9;
               }
            }

            if(var19 == 3) {
               if(var7 == 0) {
                  var18[var11] = var9;
               } else if(var7 == 1) {
                  var18[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var18[var11 + 3 + 1536] = var9;
               } else if(var7 == 3) {
                  var18[var11 + 1536] = var9;
               }
            }

            if(var19 == 2) {
               if(var7 == 3) {
                  var18[var11] = var9;
                  var18[var11 + 512] = var9;
                  var18[var11 + 1024] = var9;
                  var18[var11 + 1536] = var9;
               } else if(var7 == 0) {
                  var18[var11] = var9;
                  var18[var11 + 1] = var9;
                  var18[var11 + 2] = var9;
                  var18[var11 + 3] = var9;
               } else if(var7 == 1) {
                  var18[var11 + 3] = var9;
                  var18[var11 + 3 + 512] = var9;
                  var18[var11 + 3 + 1024] = var9;
                  var18[var11 + 3 + 1536] = var9;
               } else if(var7 == 2) {
                  var18[var11 + 1536] = var9;
                  var18[var11 + 1536 + 1] = var9;
                  var18[var11 + 1536 + 2] = var9;
                  var18[var11 + 1536 + 3] = var9;
               }
            }
         }
      }

      var5 = class46.region.method2821(var0, var1, var2);
      if(var5 != 0) {
         var6 = class46.region.method2896(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var19 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         ObjectComposition var23 = class43.getObjectDefinition(var9);
         int var21;
         if(var23.mapSceneId != -1) {
            ModIcon var20 = class112.field1658[var23.mapSceneId];
            if(var20 != null) {
               var12 = (var23.sizeX * 4 - var20.originalWidth) / 2;
               var21 = (var23.sizeY * 4 - var20.height) / 2;
               var20.method5101(var1 * 4 + 48 + var12, (104 - var2 - var23.sizeY) * 4 + 48 + var21);
            }
         } else if(var19 == 9) {
            var11 = 15658734;
            if(var5 > 0) {
               var11 = 15597568;
            }

            int[] var22 = class172.field2368.image;
            var21 = (103 - var2) * 2048 + var1 * 4 + 24624;
            if(var7 != 0 && var7 != 2) {
               var22[var21] = var11;
               var22[var21 + 512 + 1] = var11;
               var22[var21 + 1024 + 2] = var11;
               var22[var21 + 1536 + 3] = var11;
            } else {
               var22[var21 + 1536] = var11;
               var22[var21 + 1024 + 1] = var11;
               var22[var21 + 512 + 2] = var11;
               var22[var21 + 3] = var11;
            }
         }
      }

      var5 = class46.region.method2736(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         ObjectComposition var17 = class43.getObjectDefinition(var6);
         if(var17.mapSceneId != -1) {
            ModIcon var8 = class112.field1658[var17.mapSceneId];
            if(var8 != null) {
               var9 = (var17.sizeX * 4 - var8.originalWidth) / 2;
               int var10 = (var17.sizeY * 4 - var8.height) / 2;
               var8.method5101(var9 + var1 * 4 + 48, (104 - var2 - var17.sizeY) * 4 + 48 + var10);
            }
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)[Lclass283;",
      garbageValue = "3"
   )
   public static class283[] method2901() {
      return new class283[]{class283.field3757, class283.field3756, class283.field3760, class283.field3758, class283.field3759};
   }
}
